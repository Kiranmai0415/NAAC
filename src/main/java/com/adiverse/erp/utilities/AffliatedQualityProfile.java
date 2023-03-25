package com.adiverse.erp.utilities;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adiverse.erp.model.Qualitative;
import com.adiverse.erp.model.QualitativeCriterionWise;
import com.adiverse.erp.model.QualitativeQuantitative;
import com.adiverse.erp.model.QualitativeQuantitativeCriterionWise;
import com.adiverse.erp.model.QualitativeQuantitativeInfo;
import com.adiverse.erp.model.QuantitativeCriterionWise;
import com.adiverse.erp.model.QuantitativeData;
import com.adiverse.erp.service.PDFGeneratorService;
import com.adiverse.erp.service.QualitativeQuantitativeService;
import com.adiverse.erp.service.QuantitativeService;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class AffliatedQualityProfile {


	@Autowired
	PDFGeneratorService service;

	
	@Autowired
	QuantitativeService quanService;
	
	@Autowired
	QualitativeQuantitativeService qualitativeQuantitativeService;

	private static final String item = null;
//
	@Value("${logoImgPath}")
	private String logoImgPath;
//
	@Value("${logoImgScale}")
	private Float[] logoImgScale;
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;


	/** An Image that goes in the header. */
	public Image headerImage;

//	public void export(HttpServletResponse response) throws DocumentException, IOException {
		
	
	Logger logger =LoggerFactory.getLogger(AffliatedQualityProfile.class);

	public String export() throws DocumentException, IOException {

		String reportPath = "";
		Path root = Paths.get(reportGeneratePath);
		Path file = null;
		Date date = new Date();

		List<QualitativeQuantitative> qualquantitativeCriterionWiseList1 = null;
		
		
		List<Qualitative> qual = null;
		//List<QuantitativeData> quan = null;

		//List<QualitativeQuantitative> qualitativeQuantitativeCriterionWise = null;
		


		List<QualitativeQuantitativeInfo> profileInfo1 = qualitativeQuantitativeService.getAllPdfData();
		
	
	//	List<Qualitative> qual = qualitativeQuantitativeService.getAllQualitativedataData();
		List<QuantitativeData> quan = qualitativeQuantitativeService.getAllQuantitativeInfo();
		List<QualitativeQuantitativeCriterionWise> qualitativeQuantitativeCriterionWise = qualitativeQuantitativeService.getCriteriawise();
		List<QualitativeCriterionWise> qualin = qualitativeQuantitativeService.getQualCriteriawise();
		List<QuantitativeCriterionWise> quanin = qualitativeQuantitativeService.getQuanCriteriawise();

		if (CollectionUtils.isNotEmpty(profileInfo1)) {
			qualitativeQuantitativeCriterionWise = profileInfo1.get(0).getCriteriaWise();
			qual=profileInfo1.get(0).getQualitative();

		}

//		List<Qualitative> qual = null; //qualService.getAllQualitativedataData();
//		List<QuantitativeData>quan = profileInfo.get(0).getQuantitativeDataList();

		System.out.println("report generation path from property file ==>" + reportGeneratePath);
		if (root != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
			String strDate = formatter.format(date);
			reportPath = "pdfGeneratorUtil-" + strDate + ".pdf";
			file = root.resolve(reportPath);
		}
		System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

		Document document = new Document(PageSize.A4);
		// PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
		// Font font = new Font(Font.FontFamily.TIMES_ROMAN, 26, Font.UNDERLINE,
		// BaseColor.BLACK);

		document.open();

		// addLogo(document);

		Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fontTitle.setSize(22);
		fontTitle.setColor(Color.RED);

		Paragraph paragraph = new Paragraph("ADIVERSE EXPERT GRADE SHEET", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		PdfPCell cell5 = new PdfPCell();
		cell5.setPadding(5);
		document.add(cell5);
		document.add(paragraph);
		

//Quality Profile	
		Font fontTitle1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
		fontTitle1.setSize(16);
		fontTitle1.setColor(Color.RED);

		Paragraph paragraph1 = new Paragraph("Quality Profile(Tentative) \r\n", fontTitle1);
		paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
		PdfPCell cell6 = new PdfPCell();
		cell6.setPadding(6);
		document.add(cell6);
		document.add(paragraph1);

		// Name of the Institution
		Font fontParagraph2 = FontFactory.getFont(FontFactory.TIMES_ITALIC);
		fontParagraph2.setSize(12);

		Paragraph paragraph2 = new Paragraph("Name of the Institution :\r\n", fontParagraph2);
		paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(paragraph2);

		// place
		Font fontParagraph3 = FontFactory.getFont(FontFactory.TIMES_ITALIC);
		fontParagraph3.setSize(12);

		Paragraph paragraph3 = new Paragraph("Place :\r\n" + " ", fontParagraph2);
		paragraph3.setAlignment(Paragraph.ALIGN_UNDEFINED);
		document.add(paragraph3);
		cell6.setPadding(5);
		document.add(cell6);
		// creating table
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		com.lowagie.text.Font font18 = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC);
		com.lowagie.text.Font font17 = FontFactory.getFont(FontFactory.TIMES_ITALIC);
		font17.setColor(CMYKColor.BLACK);
		PdfPCell cell7 = new PdfPCell(new Paragraph("  Criteria\r\n  ", font17));
		PdfPCell cell2 = new PdfPCell(new Paragraph("  Weightage\r\n  " + " (Wi)\r\n ", font17));
		PdfPCell cell3 = new PdfPCell(
				new Paragraph("  Criterion-wise  " + "  Weighted\r\n  " + "  Grade Point (Cr WGPi)\r\n ", font17));
		PdfPCell cell4 = new PdfPCell(
				new Paragraph("  Criterion-wise\r\n " + "  Grade  " + " PointAverages(Cr WGPi/Wi)\r\n", font17));
		PdfPCell cell9 = new PdfPCell(new Paragraph(" I.Curricular Aspects\r\n " + "", font17));

		// PdfPCell cell10 = new PdfPCell(new
		// Paragraph(qualitativeQuantitativeCriterionWise.get(0).ge()));
		PdfPCell cell10 = new PdfPCell(new Paragraph("150"));
		PdfPCell cell11 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(0).getCriterionWiseWeighted()));
		PdfPCell cell12 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(0).getCriterionWiseGrade()));
		PdfPCell cell13 = new PdfPCell(new Paragraph(" II.Teaching-Learning and Evalution \r\n  ", font17));
		// PdfPCell cell14 = new PdfPCell(new
		// Paragraph(qualitativeQuantitativeCriterionWise.get(1).getNaacWeighted()));
		PdfPCell cell14 = new PdfPCell(new Paragraph("300"));
		PdfPCell cell15 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(1).getCriterionWiseWeighted()));
		PdfPCell cell16 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(1).getCriterionWiseGrade()));

		PdfPCell cell17 = new PdfPCell(new Paragraph(" III.Research,Innovation and Extension\r\n ", font17));
		// PdfPCell cell18 = new PdfPCell(new
		// Paragraph(qualitativeQuantitativeCriterionWise.get(2).getNaacWeighted()));
		PdfPCell cell18 = new PdfPCell(new Paragraph("400"));
		PdfPCell cell19 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(2).getCriterionWiseWeighted()));
		PdfPCell cell20 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(2).getCriterionWiseGrade()));

		PdfPCell cell21 = new PdfPCell(new Paragraph(" IV.Infrastructure and Learning Resource\r\n ", font17));
		// PdfPCell cell22 = new PdfPCell(new
		// Paragraph(qualitativeQuantitativeCriterionWise.get(3).getNaacWeighted()));
		PdfPCell cell22 = new PdfPCell(new Paragraph("500"));
		PdfPCell cell23 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(3).getCriterionWiseWeighted()));
		PdfPCell cell24 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(3).getCriterionWiseGrade()));

		PdfPCell cell25 = new PdfPCell(new Paragraph(" V.Student Support and Progression\r\n  ", font17));
		// PdfPCell cell26 = new PdfPCell(new
		// Paragraph(qualitativeQuantitativeCriterionWise.get(4).getNaacWeighted()));
		PdfPCell cell26 = new PdfPCell(new Paragraph("299"));
		PdfPCell cell27 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(4).getCriterionWiseWeighted()));
		PdfPCell cell28 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(4).getCriterionWiseGrade()));

		PdfPCell cell29 = new PdfPCell(new Paragraph(" VI Governance,Leadership & Management\r\n  ", font17));
		// PdfPCell cell30 = new PdfPCell(new
		// Paragraph(qualitativeQuantitativeCriterionWise.get(5).getNaacWeighted()));
		PdfPCell cell30 = new PdfPCell(new Paragraph("300"));
		PdfPCell cell31 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(5).getCriterionWiseWeighted()));
		PdfPCell cell32 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(5).getCriterionWiseGrade()));

		PdfPCell cell33 = new PdfPCell(new Paragraph(" VII.Institutional Values and Best Practies \r\n ", font17));
		// PdfPCell cell34 = new PdfPCell(new
		// Paragraph(qualitativeQuantitativeCriterionWise.get(6).getNaacWeighted()));
		PdfPCell cell34 = new PdfPCell(new Paragraph("200"));
		PdfPCell cell35 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(6).getCriterionWiseWeighted()));
		PdfPCell cell36 = new PdfPCell(new Paragraph(qualitativeQuantitativeCriterionWise.get(6).getCriterionWiseGrade()));
		PdfPCell cell37 = new PdfPCell(new Paragraph(" Total \r\n ", font18));
		
//
		 BigDecimal sum1=new BigDecimal(150).
				 add(new
				
				  BigDecimal(280)).
				  add(new
				  BigDecimal(130)).
				  add(new
				  BigDecimal(100)).
				  add(new
				  BigDecimal(98)).
				  add(new
				  BigDecimal(92)).
				  add(new
				  BigDecimal(100));
				 
		//
		
		
		 BigDecimal sum2=new BigDecimal(qualitativeQuantitativeCriterionWise.get(0).
				  getCriterionWiseWeighted()).add(new
				  BigDecimal(qualitativeQuantitativeCriterionWise.get(1).getCriterionWiseWeighted())).
				  add(new
				  BigDecimal(qualitativeQuantitativeCriterionWise.get(2).getCriterionWiseWeighted())).
				  add(new
				  BigDecimal(qualitativeQuantitativeCriterionWise.get(3).getCriterionWiseWeighted())).
				  add(new
				  BigDecimal(qualitativeQuantitativeCriterionWise.get(4).getCriterionWiseWeighted())).
				  add(new
				  BigDecimal(qualitativeQuantitativeCriterionWise.get(5).getCriterionWiseWeighted())).
				  add(new
				  BigDecimal(qualitativeQuantitativeCriterionWise.get(6).getCriterionWiseWeighted()));
	 BigDecimal avg1=sum2.divide(sum1,2,RoundingMode.CEILING); 
		Image img = Image.getInstance("image/eq1.JPG");
		img.scalePercent(70);

		PdfPCell cell38 = new PdfPCell();
		cell38.addElement(new Chunk(img, 15, 15).setGenericTag("234234234"));

		Image img1 = Image.getInstance("image/eq2.JPG");
		img1.scalePercent(70);

		PdfPCell cell39 = new PdfPCell();

		cell39.addElement(new Chunk(img1, 15, 15));
		cell39.setColspan(2);

		// cell38.addElement(paragraph000010101);
		Paragraph paragraph000010101 = new Paragraph(""+sum1.intValue());
		cell38.addElement(paragraph000010101);
//		

	Paragraph paragraph0000101012 = new Paragraph(""+sum2.intValue());
//		Paragraph paragraph0000101012 = new Paragraph();
		paragraph0000101012.add(img1);
		paragraph0000101012.add("");

		cell39.addElement(paragraph0000101012);

//PdfPCell cell40 = new PdfPCell(new Paragraph(" 3001 "));

//PdfPCell cell26 = new PdfPCell(new Paragraph("Appropriate web in the Institutional websit"));

		table.addCell(cell7);
		table.addCell(cell2);
		table.addCell(cell3);
		table.addCell(cell4);
		table.addCell(cell9);
		table.addCell(cell10);
		table.addCell(cell11);
		table.addCell(cell12);
		table.addCell(cell13);
		table.addCell(cell14);
		table.addCell(cell15);
		table.addCell(cell16);
		table.addCell(cell17);
		table.addCell(cell18);
		table.addCell(cell19);
		table.addCell(cell20);
		table.addCell(cell21);
		table.addCell(cell22);
		table.addCell(cell23);
		table.addCell(cell24);
		table.addCell(cell25);
		table.addCell(cell26);
		table.addCell(cell27);
		table.addCell(cell28);
		table.addCell(cell29);
		table.addCell(cell30);
		table.addCell(cell31);
		table.addCell(cell32);
		table.addCell(cell33);
		table.addCell(cell34);
		table.addCell(cell35);
		table.addCell(cell36);
		table.addCell(cell37);
		table.addCell(cell38);
//cell39.setRowspan(2);
		table.addCell(cell39);
//table.addCell(cell40);

//table.addCell(cell26);
		table.setSpacingAfter(30f);
		document.add(table);
// 
//Table pojodbTable=new Table(pdfpojo1)

		PdfPCell cell41 = new PdfPCell();
		cell41.setPadding(25);
		document.add(cell41);
//-----insitutional cgpa---
		Font fontParagraph52 = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC);
		fontParagraph52.setSize(10);
//PdfPTable table0013= new PdfPTable(1);
//
		Paragraph paragraph52 = new Paragraph("                    Institutional CGPA : "  +avg1
//		
				, fontParagraph52);
		document.add(paragraph52);
	
//
//
//document.add(table0013);
//

		Font fontParagraph51 = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC);
		fontParagraph51.setSize(10);

		Paragraph paragraph51 = new Paragraph("                    Grade  : " +getGradeValue(avg1), fontParagraph51);
		paragraph51.setAlignment(Paragraph.ALIGN_MIDDLE);
		document.add(paragraph51);

//

//date
		Font fontParagraph6 = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC);
		fontParagraph6.setSize(9);

		Paragraph paragraph6 = new Paragraph("Date:");
		paragraph6.setAlignment(Paragraph.ALIGN_LEFT);
		// paragraph6.setSpacingAfter(1f);
		document.add(paragraph6);
//director
		Font fontParagraph71 = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC);
		fontParagraph71.setSize(9);

		Paragraph paragraph7 = new Paragraph("                                 Director:", fontParagraph71);
		paragraph7.setAlignment(Paragraph.ALIGN_RIGHT);
		document.add(paragraph7);

		PdfPCell cell42 = new PdfPCell();
		cell42.setPadding(25);
		document.add(cell42);

		Font fontParagraph7 = FontFactory.getFont(FontFactory.TIMES_BOLD);
		fontParagraph7.setSize(10);

		Paragraph paragraph9 = new Paragraph(" ", fontParagraph7);
		paragraph9.setAlignment(Paragraph.ALIGN_RIGHT);
		Chunk bullet = new Chunk("\u2022", fontParagraph7);
		paragraph9.add(bullet);
		paragraph9.add(
				new Phrase("This Certification is valid for a period  of Five years with effect from July 03,2018 ",
						fontParagraph7));
		paragraph9.setAlignment(Paragraph.ALIGN_LEFT);
//paragraph9.add(new Phrase("\u00a0" + item.replace(' ', '\u00a0') + " ", paragraph9));
		document.add(paragraph9);

		Paragraph paragraph10 = new Paragraph(" ", fontParagraph7);
		paragraph10.setAlignment(Paragraph.ALIGN_RIGHT);
		Chunk bullet1 = new Chunk("\u2022", fontParagraph7);
		paragraph10.add(bullet1);
		paragraph10.add(new Phrase(
				"An institutional CGPA  on seven points scale in the rage of 3.51-4.00 denotes A grade, "
						+ "3.26-3.50 denotes A' grade ,3.01-3.25 denotes A grade,2.76-3.00 denotes B ' grade,"
						+ "231-275 denotes B' grade,2.01-2.50 denotes B grade,1.51-2.00 denotesC grade ",
				fontParagraph7));
		paragraph10.setAlignment(Paragraph.ALIGN_LEFT);
//paragraph9.add(new Phrase("\u00a0" + item.replace(' ', '\u00a0') + " ", paragraph9));
		document.add(paragraph10);

		Paragraph paragraph11 = new Paragraph(" ", fontParagraph7);
		paragraph11.setAlignment(Paragraph.ALIGN_RIGHT);
		Chunk bullet2 = new Chunk("\u2022", fontParagraph7);
		paragraph11.add(bullet2);
		paragraph11.add(new Phrase("Scores rounded off to the nearest integer ", fontParagraph7));
		paragraph11.setAlignment(Paragraph.ALIGN_LEFT);
//paragraph9.add(new Phrase("\u00a0" + item.replace(' ', '\u00a0') + " ", paragraph9));
		document.add(paragraph11);

		Paragraph paragraph12 = new Paragraph("EC(SC)/30/TSCOGN100278 ", fontParagraph7);
		paragraph12.setAlignment(Paragraph.ALIGN_RIGHT);
		paragraph12.setSpacingAfter(20f);
		document.add(paragraph12);

		//

//Quantitave Grade Sheet
//create table


//--------------------------------------------------
//----------------------------------------------------
//-----------------------------------------------------------------------------------------
//-----------------------------Qualitative------------------------------------
		PdfPTable table12 = new PdfPTable(1);
		table12.setWidthPercentage(100f);
		com.lowagie.text.Font font171 = FontFactory.getFont(FontFactory.TIMES_BOLD);

		font171.setColor(CMYKColor.BLACK);
		table12.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		PdfPCell cell71 = new PdfPCell(new Paragraph(" Qualitative Grade Sheet", font171));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
		font171.setSize(12);
		cell71.setBackgroundColor(Color.WHITE);

//cell71.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table12.addCell(cell71);
		table12.setSpacingBefore(30f);

		document.add(table12);

		PdfPTable table13 = new PdfPTable(2);
		table13.setWidthPercentage(100f);
		com.lowagie.text.Font font172 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell172 = new PdfPCell(new Paragraph("Name of the Institution:", font172));
		PdfPCell cell173 = new PdfPCell(new Paragraph("Institute Name", font172));
		PdfPCell cell174 = new PdfPCell(new Paragraph("Type of the Institution:", font172));
		PdfPCell cell175 = new PdfPCell(new Paragraph("Affiliated", font172));
		table13.addCell(cell172);
		table13.addCell(cell173);
		table13.addCell(cell174);
		table13.addCell(cell175);
		document.add(table13);

		PdfPTable table14 = new PdfPTable(1);
		table14.setWidthPercentage(100f);
		com.lowagie.text.Font font173 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell176 = new PdfPCell(new Paragraph("Date of Vist:", font173));

		table14.addCell(cell176);
		document.add(table14);

		PdfPTable table15 = new PdfPTable(4);
		table15.setWidthPercentage(100f);
		table15.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		com.lowagie.text.Font font174 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell177 = new PdfPCell(new Paragraph("No:", font174));

		PdfPCell cell178 = new PdfPCell(new Paragraph("Criteria and Key Indicators:", font174));

		PdfPCell cell179 = new PdfPCell(new Paragraph("Key\r\n" + "Indicator\r\n" + "Weightage\r\n" + "(Wi)", font174));

		PdfPCell cell180 = new PdfPCell(
				new Paragraph("Key Indicator \r\n" + "Wise Weighted\r\n" + "Grade Points\r\n" + "(KIWGP)i", font174));

		table15.addCell(cell177);
		table15.addCell(cell178);
		table15.addCell(cell179);
		table15.addCell(cell180);
		document.add(table15);
		PdfPTable table16 = new PdfPTable(1);
		table16.setWidthPercentage(100f);
		table16.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		com.lowagie.text.Font font175 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell181 = new PdfPCell(new Paragraph("Criterion 1: Curricular Aspects", font175));
		cell181.setHorizontalAlignment(Element.ALIGN_CENTER);
		table16.addCell(cell181);
		document.add(table16);	
		

		PdfPTable table18 = new PdfPTable(4);
		table18.setWidthPercentage(100f);
		table18.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		com.lowagie.text.Font font177 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell183 = new PdfPCell(new Paragraph("1.1", font177));
		PdfPCell cell184 = new PdfPCell(new Paragraph("Curriculum Planning and Implementation", font177));
		PdfPCell cell185 = new PdfPCell(new Paragraph("20", font177));
		PdfPCell cell186 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(7).getKiwisetotal() : "", font177));
		PdfPCell cell187 = new PdfPCell(new Paragraph("1.3", font177));
		PdfPCell cell188 = new PdfPCell(new Paragraph("Curriculum Enrichment", font177));
		PdfPCell cell189 = new PdfPCell(new Paragraph("10", font177));
		PdfPCell cell190 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(8).getKiwisetotal() : "", font177));
		PdfPCell cell191 = new PdfPCell(new Paragraph("Total", font177));
		PdfPCell cell192 = new PdfPCell();
		PdfPCell cell193 = new PdfPCell();

		cell191.setColspan(2);
		Paragraph paragraph000040 = new Paragraph("30");
		
		

		Image img13 = Image.getInstance("image/equation1.jpg");
		img13.scalePercent(70);

//
		cell192.addElement(new Chunk(img13, 15, 15));
		cell192.addElement(paragraph000040);
		

		Paragraph paragraph000041 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(0).getCriterionWiseWeighted() : "",font177);

		Image img33 = Image.getInstance("image/k111.jpg");
		img33.scalePercent(70);

//
		cell193.addElement(new Chunk(img33, 15, 15));
		cell193.addElement(paragraph000041);

		table18.addCell(cell183);
		table18.addCell(cell184);
		table18.addCell(cell185);
		table18.addCell(cell186);
		table18.addCell(cell187);
		table18.addCell(cell188);
		table18.addCell(cell189);
		table18.addCell(cell190);
		table18.addCell(cell191);
		table18.addCell(cell192);
		table18.addCell(cell193);
		document.add(table18);
		

		PdfPTable table17 = new PdfPTable(1);
		table17.setWidthPercentage(100f);
		table17.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		com.lowagie.text.Font font176 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell182 = new PdfPCell();
//cell182.setHorizontalAlignment(Element.ALIGN_CENTER);

		Paragraph paragraph000061 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(0).getCriterionWiseGrade() :"", font176);
		cell182.addElement(paragraph000061);
		Image img49 = Image.getInstance("image/w1.jpg");
		img49.scalePercent(70);

//
		cell182.addElement(new Chunk(img49, 15, 15));
		table17.addCell(cell182);
		document.add(table17);

		PdfPTable table19 = new PdfPTable(1);
		table19.setWidthPercentage(100f);
		table19.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		com.lowagie.text.Font font178 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell194 = new PdfPCell(new Paragraph("Criterion 2: Teaching-learning and Evaluation", font178));
		cell194.setHorizontalAlignment(Element.ALIGN_CENTER);
		table19.addCell(cell194);
		document.add(table19);

		PdfPTable table20 = new PdfPTable(4);
		table20.setWidthPercentage(100f);
		table20.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		com.lowagie.text.Font font179 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		
		PdfPCell cell195 = new PdfPCell(new Paragraph("2.3", font177));
		PdfPCell cell196 = new PdfPCell(new Paragraph("Teaching- Learning Process", font179));
		PdfPCell cell197 = new PdfPCell(new Paragraph("40", font179));
		PdfPCell cell198 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(9).getKiwisetotal() :"", font179));
		PdfPCell cell199 = new PdfPCell(new Paragraph("2.5", font179));
		PdfPCell cell200 = new PdfPCell(new Paragraph("Evaluation Process and Reforms", font179));
		PdfPCell cell201 = new PdfPCell(new Paragraph("40", font179));
		PdfPCell cell202 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(10).getKiwisetotal() : "", font179));

		PdfPCell cell203 = new PdfPCell(new Paragraph("2.6", font179));
		PdfPCell cell204 = new PdfPCell(new Paragraph("Student Performance and Learning Outcomes", font179));
		PdfPCell cell205 = new PdfPCell(new Paragraph("45", font179));
		PdfPCell cell206 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(11).getKiwisetotal() : "", font179));
		PdfPCell cell207 = new PdfPCell(new Paragraph("Total", font179));
		PdfPCell cell208 = new PdfPCell();
		PdfPCell cell209 = new PdfPCell();

		cell207.setColspan(2);
		
		Paragraph paragraph000043 = new Paragraph("125");
		//paragraph000043.setAlignment(Element.ALIGN_RIGHT);

		Image img12 = Image.getInstance("image/eqaution2.jpg");
		img12.scalePercent(70);
		

		Paragraph paragraph000044 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(1).getCriterionWiseWeighted() : "", font177);
		Image img34 = Image.getInstance("image/k2.jpg");
		img34.scalePercent(70);

//
		cell209.addElement(new Chunk(img34, 15, 15));
		cell209.addElement(paragraph000044);
//
		cell208.addElement(new Chunk(img12, 15, 15));
		cell208.addElement(paragraph000043);
		
////paragraph40.setAlignment(Right);
//cell208.addElement(paragraph41);
////rightCell .addElement(addText);

		table20.addCell(cell195);
		table20.addCell(cell196);
		table20.addCell(cell197);
		table20.addCell(cell198);
		table20.addCell(cell199);
		table20.addCell(cell200);
		table20.addCell(cell201);
		table20.addCell(cell202);
		table20.addCell(cell203);
		table20.addCell(cell204);
		table20.addCell(cell205);
		table20.addCell(cell206);
		table20.addCell(cell207);
		table20.addCell(cell208);
		table20.addCell(cell209);
		document.add(table20);
		

		// calculation 2
				PdfPTable table21 = new PdfPTable(1);
				table21.setWidthPercentage(100f);
				table21.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font180 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				PdfPCell cell210 = new PdfPCell();

				Paragraph paragraph0000062 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(1).getCriterionWiseGrade() :"", font180);
				cell210.addElement(paragraph0000062);
		//cell182.setHorizontalAlignment(Element.ALIGN_CENTER);

				Image img48 = Image.getInstance("image/w2.jpg");
				img48.scalePercent(70);

		//
				cell210.addElement(new Chunk(img48, 15, 15));

				table21.addCell(cell210);
				document.add(table21);

				PdfPTable table22 = new PdfPTable(1);
				table22.setWidthPercentage(100f);
				table22.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font181 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				PdfPCell cell211 = new PdfPCell(new Paragraph("Criterion 3: Research, Innovations and Extension", font181));
				cell211.setHorizontalAlignment(Element.ALIGN_CENTER);
				table22.addCell(cell211);
				document.add(table22);
				
				
				PdfPTable table23 = new PdfPTable(4);
				table23.setWidthPercentage(100f);
				table23.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font182 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			
				PdfPCell cell212 = new PdfPCell(new Paragraph("3.2", font177));
				PdfPCell cell213 = new PdfPCell(new Paragraph("Innovation Ecosystem", font182));
				PdfPCell cell214 = new PdfPCell(new Paragraph("10", font182));
				PdfPCell cell215 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(12).getKiwisetotal() : "", font182));
				PdfPCell cell216 = new PdfPCell(new Paragraph("3.4", font182));
				PdfPCell cell217 = new PdfPCell(new Paragraph("Extension Activities", font182));
				PdfPCell cell218 = new PdfPCell(new Paragraph("20", font182));
				PdfPCell cell219 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(13).getKiwisetotal() : "", font182));
				PdfPCell cell220 = new PdfPCell(new Paragraph("Total", font182));
				PdfPCell cell221 = new PdfPCell();
				PdfPCell cell222 = new PdfPCell();

				cell220.setColspan(2);
				

				Image img14 = Image.getInstance("image/equation3.jpg");
				img14.scalePercent(70);
				cell221.addElement(new Chunk(img14, 15, 15));
				
				Paragraph paragraph000045 = new Paragraph("30");
				
				cell221.addElement(paragraph000045);

				Paragraph paragraph000046 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(2).getCriterionWiseWeighted() : "", font177);
				cell222.addElement(paragraph000046);
				Image img36 = Image.getInstance("image/k3.jpg");
				img36.scalePercent(70);

//		           
				

		//
				cell222.addElement(new Chunk(img36, 15, 15));
	
				table23.addCell(cell212);
				table23.addCell(cell213);
				table23.addCell(cell214);
				table23.addCell(cell215);
				table23.addCell(cell216);
				table23.addCell(cell217);
				table23.addCell(cell218);
				table23.addCell(cell219);
				table23.addCell(cell220);
				table23.addCell(cell221);
				table23.addCell(cell222);
				document.add(table23);
		
				//calculation 3
				PdfPTable table24 = new PdfPTable(1);
				table24.setWidthPercentage(100f);
				table24.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font183 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				PdfPCell cell223 = new PdfPCell();
				Paragraph paragraph0000962 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(2).getCriterionWiseGrade() : "", font183);

				cell223.addElement(paragraph0000962);
		//cell182.setHorizontalAlignment(Element.ALIGN_CENTER);

				Image img47 = Image.getInstance("image/w3.jpg");
				img47.scalePercent(70);

		//
				cell223.addElement(new Chunk(img47, 15, 15));
				table24.addCell(cell223);
				document.add(table24);

		//criteria4

				PdfPTable table25 = new PdfPTable(1);
				table25.setWidthPercentage(100f);
				table25.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font184 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				PdfPCell cell224 = new PdfPCell(new Paragraph("Criterion 4: Infrastructure and Learning Resources", font184));
				cell224.setHorizontalAlignment(Element.ALIGN_CENTER);
				table25.addCell(cell224);
				document.add(table25);
				
				PdfPTable table26 = new PdfPTable(4);
				table26.setWidthPercentage(100f);
				table26.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font185 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				PdfPCell cell225 = new PdfPCell(new Paragraph("4.1", font177));
				PdfPCell cell226 = new PdfPCell(new Paragraph("Physical Facilities", font185));
				PdfPCell cell227 = new PdfPCell(new Paragraph("20", font185));
				PdfPCell cell228 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(14).getKiwisetotal() : "", font185));
				PdfPCell cell229 = new PdfPCell(new Paragraph("4.2", font185));
				PdfPCell cell230 = new PdfPCell(new Paragraph("Library as a Learning Resource", font185));
				PdfPCell cell231 = new PdfPCell(new Paragraph("20", font185));
				PdfPCell cell232 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(15).getKiwisetotal() :"", font185));

				PdfPCell cell233 = new PdfPCell(new Paragraph("4.3", font185));
				PdfPCell cell234 = new PdfPCell(new Paragraph("IT Infrastructure", font185));
				PdfPCell cell235 = new PdfPCell(new Paragraph("20", font185));
				PdfPCell cell236 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(16).getKiwisetotal() : "", font185));
			
				PdfPCell cell237 = new PdfPCell(new Paragraph("Total", font185));
				PdfPCell cell238 = new PdfPCell();
				PdfPCell cell239 = new PdfPCell();

				cell237.setColspan(2);
			
				Image img15 = Image.getInstance("image/equation4.jpg");
				img15.scalePercent(70);
				cell238.addElement(new Chunk(img15, 15, 15));
				Paragraph paragraph0000047 = new Paragraph("60");
				cell238.addElement(paragraph0000047);
		//
				Paragraph paragraph000048 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(3).getCriterionWiseWeighted() : "", font177);
				cell239.addElement(paragraph000048);
				
				Image img37 = Image.getInstance("image/k4.jpg");
				img37.scalePercent(70);

		//
				cell221.addElement(new Chunk(img37, 15, 15));
				table26.addCell(cell225);
				table26.addCell(cell226);
				table26.addCell(cell227);
				table26.addCell(cell228);
				table26.addCell(cell229);
				table26.addCell(cell230);
				table26.addCell(cell231);
				table26.addCell(cell232);
				table26.addCell(cell233);
				table26.addCell(cell234);
				table26.addCell(cell235);
				table26.addCell(cell236);
			
				table26.addCell(cell237);
				table26.addCell(cell238);
				table26.addCell(cell239);
				document.add(table26);	
	
				//calculation 4
				PdfPTable table27 = new PdfPTable(1);
				table27.setWidthPercentage(100f);
				table27.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font186 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				PdfPCell cell240 = new PdfPCell();

				Paragraph paragraph0000963 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(3).getCriterionWiseGrade() : "", font186);

				cell240.addElement(paragraph0000963);
		//cell182.setHorizontalAlignment(Element.ALIGN_CENTER);

				Image img46 = Image.getInstance("image/w4.jpg");
				img46.scalePercent(70);

		//
				cell240.addElement(new Chunk(img46, 15, 15));
				table27.addCell(cell240);
				document.add(table27);
				
				//crirteria 5
				PdfPTable table28 = new PdfPTable(1);
				table28.setWidthPercentage(100f);
				table28.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font187 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				PdfPCell cell441 = new PdfPCell(new Paragraph("Criterion 5: Student Support and Progression", font187));
				cell441.setHorizontalAlignment(Element.ALIGN_CENTER);
				table28.addCell(cell441);
				document.add(table28);

				PdfPTable table29 = new PdfPTable(4);
				table29.setWidthPercentage(100f);
				table29.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font188 = FontFactory.getFont(FontFactory.TIMES_ROMAN);		
		

				PdfPCell cell454 = new PdfPCell(new Paragraph("5.4", font188));
				PdfPCell cell455 = new PdfPCell(new Paragraph("Alumini Engagement", font188));
				PdfPCell cell456 = new PdfPCell(new Paragraph("5", font188));
				PdfPCell cell457 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(17).getKiwisetotal(): "", font188));
				PdfPCell cell458 = new PdfPCell(new Paragraph("Total", font188));
				PdfPCell cell459 = new PdfPCell();
				PdfPCell cell460 = new PdfPCell();
				cell458.setColspan(2);
			
				Image img16 = Image.getInstance("image/equation5.jpg");
				img16.scalePercent(70);

				Paragraph paragraph000051 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(4).getCriterionWiseWeighted() :"", font177);
				cell460.addElement(paragraph000051);
				cell459.addElement(new Chunk(img16, 15, 15));
				Paragraph paragraph000050 = new Paragraph("140");
				cell459.addElement(paragraph000050);
				Image img38 = Image.getInstance("image/k5.jpg");
				img38.scalePercent(70);

		//
				cell460.addElement(new Chunk(img38, 15, 15));
				/*
				 * table29.addCell(cell442); table29.addCell(cell443); table29.addCell(cell444);
				 * table29.addCell(cell445); table29.addCell(cell446); table29.addCell(cell447);
				 * table29.addCell(cell448); table29.addCell(cell449);
				 */
			
				table29.addCell(cell454);
				table29.addCell(cell455);
				table29.addCell(cell456);
				table29.addCell(cell457);
				table29.addCell(cell458);
				table29.addCell(cell459);
				table29.addCell(cell460);
				document.add(table29);

		//calculation 5
				PdfPTable table30 = new PdfPTable(1);
				table30.setWidthPercentage(100f);
				table30.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font189 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				PdfPCell cell461 = new PdfPCell();

				Paragraph paragraph0000964 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(4).getCriterionWiseGrade() : "", font189);

				cell461.addElement(paragraph0000964);

				Image img45 = Image.getInstance("image/w11.jpg");
				img45.scalePercent(70);

		//
				cell461.addElement(new Chunk(img45, 15, 15));

		//cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
				table30.addCell(cell461);
				document.add(table30);
	
				//crirteria 6
				PdfPTable table31 = new PdfPTable(1);
				table31.setWidthPercentage(100f);
				table31.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font190 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				PdfPCell cell462 = new PdfPCell(new Paragraph("Criterion 6: Governance, Leadership and Management", font190));
				cell462.setHorizontalAlignment(Element.ALIGN_CENTER);
				table31.addCell(cell462);
				document.add(table31);

				PdfPTable table32 = new PdfPTable(4);
				table32.setWidthPercentage(100f);
				table32.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font191 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				PdfPCell cell463 = new PdfPCell(new Paragraph("6.1", font191));
				PdfPCell cell464 = new PdfPCell(new Paragraph("Institutional Vision and Leadership", font191));
				PdfPCell cell465 = new PdfPCell(new Paragraph("10", font191));
				PdfPCell cell466 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(18).getKiwisetotal(): "", font191));
				PdfPCell cell467 = new PdfPCell(new Paragraph("6.2", font191));
				PdfPCell cell468 = new PdfPCell(new Paragraph("Strategy Development and Development", font191));
				PdfPCell cell469 = new PdfPCell(new Paragraph("6", font191));
				PdfPCell cell470 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(19).getKiwisetotal() : "", font191));

				PdfPCell cell471 = new PdfPCell(new Paragraph("6.3", font191));
				PdfPCell cell472 = new PdfPCell(new Paragraph("Faculty Empowerment Strategies", font191));
				PdfPCell cell473 = new PdfPCell(new Paragraph("8", font191));
				PdfPCell cell474 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(20).getKiwisetotal() : "", font191));
				PdfPCell cell475 = new PdfPCell(new Paragraph("6.4", font191));
				PdfPCell cell476 = new PdfPCell(new Paragraph("Financial Management and Resource Mobilization", font191));
				PdfPCell cell477 = new PdfPCell(new Paragraph("15", font191));
				PdfPCell cell478 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(21).getKiwisetotal(): "", font191));
				PdfPCell cell479 = new PdfPCell(new Paragraph("6.5", font191));
				PdfPCell cell480 = new PdfPCell(new Paragraph("Internal Quality Assurance System", font191));
				PdfPCell cell481 = new PdfPCell(new Paragraph("15", font191));
				PdfPCell cell482 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(22).getKiwisetotal() : "", font191));
				PdfPCell cell483 = new PdfPCell(new Paragraph("Total", font191));
				PdfPCell cell484 = new PdfPCell();
				PdfPCell cell485 = new PdfPCell();
				cell483.setColspan(2);
				Paragraph paragraph40 = new Paragraph("54");
		//rightCell484 .addElement(paragraph40);
				Image img11 = Image.getInstance("image/equation6.jpg");
				img11.scalePercent(70);

		//PdfPCell cell38 = new PdfPCell();

				cell484.addElement(new Chunk(img11, 15, 15));

		//paragraph40.setAlignment(Right);
				cell484.addElement(paragraph40);

		//rightCell .addElement(addText);
				Paragraph paragraph000053 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(5).getCriterionWiseWeighted() : "", font177);
				cell485.addElement(paragraph000053);

				cell459.addElement(new Chunk(img15, 15, 15));
				Image img39 = Image.getInstance("image/k6.jpg");
				img39.scalePercent(70);

		//
				cell485.addElement(new Chunk(img39, 15, 15));

				table32.addCell(cell463);
				table32.addCell(cell464);
				table32.addCell(cell465);
				table32.addCell(cell466);
				table32.addCell(cell467);
				table32.addCell(cell468);
				table32.addCell(cell469);
				table32.addCell(cell470);
				table32.addCell(cell471);
				table32.addCell(cell472);
				table32.addCell(cell473);
				table32.addCell(cell474);
				table32.addCell(cell475);
				table32.addCell(cell476);
				table32.addCell(cell477);
				table32.addCell(cell478);
				table32.addCell(cell479);
				table32.addCell(cell480);
				table32.addCell(cell481);
				table32.addCell(cell482);
				table32.addCell(cell483);
				table32.addCell(cell484);
				table32.addCell(cell485);
				document.add(table32);		
				
				//calculation 6
				PdfPTable table33 = new PdfPTable(1);
				table33.setWidthPercentage(100f);
				table33.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				com.lowagie.text.Font font192 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				PdfPCell cell486 = new PdfPCell();

				Paragraph paragraph0000965 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(5).getCriterionWiseGrade() : "", font192);

				cell486.addElement(paragraph0000965);
				Image img42 = Image.getInstance("image/w6.jpg");
				img42.scalePercent(70);

		//
				cell486.addElement(new Chunk(img42, 15, 15));
		//cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
				table33.addCell(cell486);
				document.add(table33);
				

				// criteria 7

						PdfPTable table34 = new PdfPTable(1);
						table34.setWidthPercentage(100f);
						table34.setHorizontalAlignment(Element.ALIGN_MIDDLE);
						com.lowagie.text.Font font193 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
						PdfPCell cell487 = new PdfPCell(new Paragraph("Criterion 7: Institutional Values and Best Practices", font193));
						cell487.setHorizontalAlignment(Element.ALIGN_CENTER);
						table31.addCell(cell487);
						document.add(table34);

						PdfPTable table35 = new PdfPTable(4);
						table35.setWidthPercentage(100f);
						table35.setHorizontalAlignment(Element.ALIGN_MIDDLE);
						com.lowagie.text.Font font194 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
						PdfPCell cell488 = new PdfPCell(new Paragraph("7.1", font194));
						PdfPCell cell489 = new PdfPCell(new Paragraph("Institutional Values and Social Responsibilities", font194));
						PdfPCell cell490 = new PdfPCell(new Paragraph("20", font194));
						PdfPCell cell491 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(23).getKiwisetotal(): "", font194));
						PdfPCell cell492 = new PdfPCell(new Paragraph("7.2", font194));
						PdfPCell cell493 = new PdfPCell(new Paragraph("Best Practices", font194));
						PdfPCell cell494 = new PdfPCell(new Paragraph("30", font194));
						PdfPCell cell495 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(24).getKiwisetotal() : "", font194));

						PdfPCell cell496 = new PdfPCell(new Paragraph("7.3", font194));
						PdfPCell cell497 = new PdfPCell(new Paragraph("Institutional Distinctiveness", font194));
						PdfPCell cell498 = new PdfPCell(new Paragraph("20", font194));
						PdfPCell cell499 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(25).getKiwisetotal() : "", font194));
						PdfPCell cell500 = new PdfPCell(new Paragraph("Total", font194));
						PdfPCell cell501 = new PdfPCell();
						PdfPCell cell502 = new PdfPCell();

						cell500.setColspan(2);
					

						Image img17 = Image.getInstance("image/equation7.jpg");
						img17.scalePercent(70);

				//
						cell501.addElement(new Chunk(img17, 15, 15));
						Paragraph paragraph000052 = new Paragraph("70");
						cell501.addElement(paragraph000052);
						cell459.addElement(new Chunk(img15, 15, 15));
						Image img0000040 = Image.getInstance("image/k7.jpg");
						img0000040.scalePercent(70);

						Paragraph paragraph000054 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(6).getCriterionWiseWeighted() :"", font177);
						cell502.addElement(paragraph000054);

				//
						cell502.addElement(new Chunk(img0000040, 15, 15));

						table35.addCell(cell488);
						table35.addCell(cell489);
						table35.addCell(cell490);
						table35.addCell(cell491);
						table35.addCell(cell492);
						table35.addCell(cell493);
						table35.addCell(cell494);
						table35.addCell(cell495);
						table35.addCell(cell496);
						table35.addCell(cell497);
						table35.addCell(cell498);
						table35.addCell(cell499);
						table35.addCell(cell500);
						table35.addCell(cell501);
						table35.addCell(cell502);

						document.add(table35);	
				
						//calculation 7
						PdfPTable table36 = new PdfPTable(1);
						table36.setWidthPercentage(100f);
						table36.setHorizontalAlignment(Element.ALIGN_MIDDLE);
						com.lowagie.text.Font font195 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
						PdfPCell cell503 = new PdfPCell();
						Paragraph paragraph0000764 = new Paragraph(CollectionUtils.isNotEmpty(qualin) ? qualin.get(6).getCriterionWiseGrade() : "", font195);

						cell503.addElement(paragraph0000764);

						Image img41 = Image.getInstance("image/w7.jpg");
						img41.scalePercent(70);

				//
						cell503.addElement(new Chunk(img41, 15, 15));
				//cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
						table36.addCell(cell503);
						
						
						document.add(table36);

				//grade totol


						PdfPTable table37 = new PdfPTable(3);
						table37.setWidthPercentage(100f);
						table37.setHorizontalAlignment(Element.ALIGN_MIDDLE);
						com.lowagie.text.Font font196 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
						PdfPCell cell504 = new PdfPCell(new Paragraph("Grade Total", font196));
						cell504.setHorizontalAlignment(Element.ALIGN_CENTER);
					BigDecimal sum12 =new BigDecimal(30).add(new BigDecimal(125)).add(new BigDecimal(30)).add(new BigDecimal(60)).add(new BigDecimal(140)).add(new BigDecimal(54)).add(new BigDecimal(70));
						
						PdfPCell cell505 = new PdfPCell(new Paragraph("" +sum12.intValue(), font196));
						
						
						BigDecimal sum7 = new BigDecimal(CollectionUtils.isNotEmpty(qualin) ? qualin.get(0).getCriterionWiseWeighted() : "").add(new BigDecimal(CollectionUtils.isNotEmpty(qualin) ? qualin.get(1).getCriterionWiseWeighted() : "")).
								add(new BigDecimal(CollectionUtils.isNotEmpty(qualin) ? qualin.get(2).getCriterionWiseWeighted() : "")).add(new BigDecimal(CollectionUtils.isNotEmpty(qualin) ? qualin.get(3).getCriterionWiseWeighted() : "")).	
								add(new BigDecimal(CollectionUtils.isNotEmpty(qualin) ? qualin.get(4).getCriterionWiseWeighted() : "")).add(new BigDecimal(CollectionUtils.isNotEmpty(qualin) ? qualin.get(5).getCriterionWiseWeighted() : "")).	add(new BigDecimal(CollectionUtils.isNotEmpty(qualin) ? qualin.get(6).getCriterionWiseWeighted() : ""));
								PdfPCell cell506 = new PdfPCell(new Paragraph("" +sum7.intValue()));
								 BigDecimal avg3 =sum7.divide(sum12,2,RoundingMode.CEILING); 
								
						//PdfPCell cell506 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(qual) ? qual.get(0).getQlit4() : "", font196));
								

						// cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
						table37.addCell(cell504);
						table37.addCell(cell505);
						table37.addCell(cell506);
						document.add(table37);

				//insti

						PdfPTable table38 = new PdfPTable(1);
						table38.setWidthPercentage(100f);
						table38.setHorizontalAlignment(Element.ALIGN_MIDDLE);
						com.lowagie.text.Font font197 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
						PdfPCell cell507 = new PdfPCell();
						PdfPCell cell508 = new PdfPCell(new Paragraph("Grade : " + getGradeValue(avg3)));

						cell508.setHorizontalAlignment(Element.ALIGN_CENTER);
						Image img107 = Image.getInstance("image/IN.jpg");
						img107.scalePercent(70);
						Paragraph paragraph0000541 = new Paragraph( "                   " + avg3);
						cell507.addElement(paragraph0000541);
							//
						cell507.addElement(new Chunk(img107, 15, 15));

				//cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
						table38.addCell(cell507);
						table38.addCell(cell508);
						;
						document.add(table38);

				//-------

						PdfPTable table38000 = new PdfPTable(1);
						table38000.setWidthPercentage(100f);
						table38000.setHorizontalAlignment(Element.ALIGN_MIDDLE);
						com.lowagie.text.Font font19700 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
						PdfPCell cell50700 = new PdfPCell();
						table38000.addCell(cell50700);
						document.add(table38000);
		

///-------------------------------------Quantitative---------------------------
//----------------------------------------------------------------------------
//--------------------------------------------------------------------------------
		PdfPTable table134 = new PdfPTable(1);
		table134.setWidthPercentage(100f);
		table134.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table134.setSpacingBefore(20f);
		com.lowagie.text.Font font200 = FontFactory.getFont(FontFactory.TIMES_BOLD);
		PdfPCell cell1000 = new PdfPCell(new Paragraph("Quantitive Grade Sheet ", font200));
		font200.setColor(CMYKColor.BLACK);
		cell1000.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1000.setBackgroundColor(Color.white);
		table134.addCell(cell1000);
		document.add(table134);

		PdfPTable table135 = new PdfPTable(2);
		table135.setWidthPercentage(100f);
		com.lowagie.text.Font font201 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell1001 = new PdfPCell(new Paragraph("Name of the Institution:", font201));
		PdfPCell cell1002 = new PdfPCell(new Paragraph("Institute Name", font201));
		PdfPCell cell1003 = new PdfPCell(new Paragraph("Type of the Institution:", font201));
		PdfPCell cell1004 = new PdfPCell(new Paragraph("Affiliated:", font201));
		table135.addCell(cell1001);
		table135.addCell(cell1002);
		table135.addCell(cell1003);
		table135.addCell(cell1004);
		document.add(table135);

		PdfPTable table136 = new PdfPTable(1);
		table136.setWidthPercentage(100f);
		com.lowagie.text.Font font202 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell1005 = new PdfPCell(new Paragraph("Date of Vist:", font202));

		table136.addCell(cell1005);
		document.add(table136);

		PdfPTable table137 = new PdfPTable(4);
		table137.setWidthPercentage(100f);
		table137.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		com.lowagie.text.Font font203 = FontFactory.getFont(FontFactory.TIMES_ROMAN);

		PdfPCell cell1006 = new PdfPCell(new Paragraph("No:", font203));
//cell177.setBackgroundColor(Color.orage);
		PdfPCell cell1007 = new PdfPCell(new Paragraph("Criteria and Key Indicators:", font203));
//cell178.setBackgroundColor(Color.blue);
		PdfPCell cell1008 = new PdfPCell(
				new Paragraph("Key\r\n" + "Indicator\r\n" + "Weightage\r\n" + "(Wi)", font203));
//cell179.setBackgroundColor(Color.blue);
		PdfPCell cell1009 = new PdfPCell(
				new Paragraph("Key Indicator \r\n" + "Wise Weighted\r\n" + "Grade Points\r\n" + "(KIWGP)i", font203));
//cell180.setBackgroundColor(Color.blue);
		table137.addCell(cell1006);
		table137.addCell(cell1007);
		table137.addCell(cell1008);
		table137.addCell(cell1009);
		document.add(table137);

		PdfPTable table138 = new PdfPTable(1);
		table138.setWidthPercentage(100f);
		table138.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		com.lowagie.text.Font font204 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell1010 = new PdfPCell(new Paragraph("Criterion 1: Curricular Aspects", font204));
		cell1010.setHorizontalAlignment(Element.ALIGN_CENTER);
		table138.addCell(cell1010);
		document.add(table138);

		
		  PdfPTable table139 = new PdfPTable(4); table139.setWidthPercentage(100f);
		  table139.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font205 = FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		  PdfPCell cell1011 =  new PdfPCell(new Paragraph("1.2", font205));
		 
		  PdfPCell cell1012 = new   PdfPCell(new Paragraph("Academic Flexibility", font205));
		
		 
		  PdfPCell cell1013 = new PdfPCell(new Paragraph("30", font205)); 
		 
		  PdfPCell cell1014 = new  PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(7).getKiwisetotal() : "", font205));
		   PdfPCell cell1015 = new PdfPCell(new
		  Paragraph("1.3", font205)); PdfPCell cell1016 = new PdfPCell(new
		  Paragraph("Curriculum Enrichment", font205)); PdfPCell cell1017 = new
		  PdfPCell(new Paragraph("20", font205)); 
		 
		  PdfPCell cell1018 = new PdfPCell(new  Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(8).getKiwisetotal()  : "",font205));
		   PdfPCell cell1019 = new PdfPCell(new Paragraph("1.4", font205));
		  PdfPCell cell1020 = new PdfPCell(new Paragraph("Feedback System", font205));
		  PdfPCell cell1021 = new PdfPCell(new Paragraph("20", font205)); PdfPCell
		  cell1022 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(9).getKiwisetotal()  : "", font205));
		 PdfPCell cell1023 = new PdfPCell(new  Paragraph("Total", font205)); 

		 PdfPCell cell1024 = new PdfPCell(); PdfPCell
		  cell1025 = new PdfPCell();
		  
		  cell1023.setColspan(2); 
		 
		  
		  Image img131 = Image.getInstance("image/equation1.jpg");
		  img131.scalePercent(70);
		  
		   cell1024.addElement(new Chunk(img131, 15, 15)); 
		   Paragraph paragraph000152 = new Paragraph("70");
			  cell1024.addElement(paragraph000152);
		 Paragraph  paragraph000153 = new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(0).getCriterionWiseWeighted() : ""); 
		  cell1025.addElement(paragraph000153);
		  
		  Image img132 = Image.getInstance("image/k111.jpg"); img132.scalePercent(70);
		  
		   cell1025.addElement(new Chunk(img132, 15, 15));
		  
		  table139.addCell(cell1011); table139.addCell(cell1012);
		  table139.addCell(cell1013); table139.addCell(cell1014);
		  table139.addCell(cell1015); table139.addCell(cell1016);
		  table139.addCell(cell1017); table139.addCell(cell1018);
		  table139.addCell(cell1019); table139.addCell(cell1020);
		  table139.addCell(cell1021); table139.addCell(cell1022);
		  table139.addCell(cell1023); table139.addCell(cell1024);
		  table139.addCell(cell1025); document.add(table139);
		  
		  PdfPTable table140 = new PdfPTable(1); table140.setWidthPercentage(100f);
		  table140.setHorizontalAlignment(Element.ALIGN_MIDDLE); com.lowagie.text.Font
		  font206 = FontFactory.getFont(FontFactory.TIMES_ROMAN); PdfPCell cell1026 =
		  new PdfPCell();
		  
		  //cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
		  
		  Image img133 = Image.getInstance("image/w1.jpg"); img133.scalePercent(70);
		  Paragraph paragraph000154 = new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(0).getCriterionWiseGrade() :
		""); cell1026.addElement(paragraph000154); //
		  cell1026.addElement(new Chunk(img133, 15, 15)); table140.addCell(cell1026);
		  document.add(table140);
		  
		  PdfPTable table141 = new PdfPTable(1); 
		  table141.setWidthPercentage(100f);
		  table141.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font207 = FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		  PdfPCell cell1027 = new PdfPCell(new Paragraph("Criterion 2: Teaching-learning and Evaluation",font207));
		  
		   cell1027.setHorizontalAlignment(Element.ALIGN_CENTER);
		  table141.addCell(cell1027); 
		  document.add(table141);
		  
		  PdfPTable table142 = new PdfPTable(4); 
		  table142.setWidthPercentage(100f);
		  table142.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font208 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		   PdfPCell cell1028 = new PdfPCell(new Paragraph("2.1", font208));
		   PdfPCell cell1029 = new PdfPCell(new Paragraph("Student Enrollment and Profile", font208));
		   
		  PdfPCell cell1030 = new PdfPCell(new Paragraph("40", font208));
		   PdfPCell cell1031 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(10).getKiwisetotal()  : "", font208));
		  
		   PdfPCell cell1032 = new PdfPCell(new Paragraph("2.2", font208));
		   PdfPCell cell1033 = new PdfPCell(new Paragraph("Catering to Student Diversity", font208));
		   PdfPCell cell1034 = new PdfPCell(new Paragraph("40", font208)); 
		  PdfPCell cell1035 = new PdfPCell(new
		  Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(11).getKiwisetotal()  : "", font208));
		  
		  
		  PdfPCell cell1036 = new PdfPCell(new Paragraph("2.4", font208)); 
		  
		  
		 PdfPCell cell1037 = new PdfPCell(new Paragraph("Student Performance and Learning Outcomes", font208)); 
		  PdfPCell cell1038 = new PdfPCell(new Paragraph("40", font208)); 
		 PdfPCell cell1039 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(12).getKiwisetotal() : "", font208));
		   PdfPCell cell1040 = new PdfPCell(new Paragraph("2.6", font208));
		   PdfPCell cell1041 = new PdfPCell(new Paragraph("Student Performance and Learning Outcomes", font208));
		   
		  PdfPCell cell1042 = new PdfPCell(new Paragraph("45", font208)); 
		 PdfPCell cell1043 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(13).getKiwisetotal()  : "", font208));
		   PdfPCell cell1044 = new PdfPCell(new Paragraph("2.7", font208));
		   PdfPCell cell1045 = new PdfPCell(new Paragraph("Student Satisfaction Survey", font208));
		   PdfPCell cell1046 = new  PdfPCell(new Paragraph("60", font208));
		  
		  PdfPCell cell1047 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(14).getKiwisetotal()  : "",font208));
		   PdfPCell cell1048 = new PdfPCell(new Paragraph("Total", font208));
		   
		  PdfPCell cell1049 = new PdfPCell(); PdfPCell cell1050 = new PdfPCell();
		  
		  cell1048.setColspan(2); 
	
		  
		  Image img1340 = Image.getInstance("image/eqaution2.jpg");
		  img1340.scalePercent(70); Image img1350 = Image.getInstance("image/k2.jpg");
		  img1350.scalePercent(70);
		  
		   cell1049.addElement(new Chunk(img1340, 15, 15)); 
		   
			  Paragraph paragraph000158 = new Paragraph("225");
			  cell1049.addElement(paragraph000158);
		  Paragraph paragraph000159 = new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(1).getCriterionWiseWeighted() :
		  ""); cell1050.addElement(paragraph000159);
		  
		   cell1050.addElement(new Chunk(img1350, 15, 15));
		  
		  table142.addCell(cell1028); table142.addCell(cell1029);
		  table142.addCell(cell1030); table142.addCell(cell1031);
		  table142.addCell(cell1032); table142.addCell(cell1033);
		  table142.addCell(cell1034); table142.addCell(cell1035);
		  table142.addCell(cell1036); table142.addCell(cell1037);
		  table142.addCell(cell1038); table142.addCell(cell1039);
		  table142.addCell(cell1040); table142.addCell(cell1041);
		  table142.addCell(cell1042); table142.addCell(cell1043);
		  table142.addCell(cell1044); table142.addCell(cell1045);
		  table142.addCell(cell1046); table142.addCell(cell1047);
		  table142.addCell(cell1048); table142.addCell(cell1049);
		  table142.addCell(cell1050); document.add(table142);
		  
		  // calculation 2 
		  PdfPTable table143 = new PdfPTable(1);
		  table143.setWidthPercentage(100f);
		  table143.setHorizontalAlignment(Element.ALIGN_MIDDLE); com.lowagie.text.Font
		  font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		  PdfPCell cell1051 = new   PdfPCell(); 
		//cell182.setHorizontalAlignment(Element.ALIGN_CENTER); 
		  Paragraph  paragraph000160 = new Paragraph(CollectionUtils.isNotEmpty(quan) ?
		  quan.get(1).getQntt3() : ""); cell1051.addElement(paragraph000160);
		  
		  Image img50 = Image.getInstance("image/w2.jpg"); img50.scalePercent(70);
		  
		   cell1051.addElement(new Chunk(img50, 15, 15));
		  
		  table143.addCell(cell1051); document.add(table143);
		  
		  PdfPTable table144 = new PdfPTable(1); 
		  table144.setWidthPercentage(100f);
		  table144.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font002 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		  
		  
		  PdfPCell cell1052 = new PdfPCell(new Paragraph("Criterion 3: Research, Innovations and Extension", font002));
		  cell1052.setHorizontalAlignment(Element.ALIGN_CENTER);
		  table144.addCell(cell1052); document.add(table144);
		  
		  PdfPTable table145 = new PdfPTable(4); table145.setWidthPercentage(100f);
		  table145.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		  //com.lowagie.text.Font font182 =
	//	  com.lowagie.text.Font font182 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		  FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		  PdfPCell cell1053 = new PdfPCell(new Paragraph("3.1", font208));
		   PdfPCell cell1054 = new PdfPCell(new  Paragraph("Resource Mobilization for Research", font182));
		 
		    PdfPCell cell1055 = new PdfPCell(new Paragraph("10", font208)); 
		    PdfPCell cell1056 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(15).getKiwisetotal() : "", font208));
		  
		   PdfPCell cell1057 = new PdfPCell(new Paragraph("3.2", font208));
		   PdfPCell cell1058 = new PdfPCell(new Paragraph("Innovation Ecosystem", font208));
		   PdfPCell cell1059 = new  PdfPCell(new Paragraph("20", font182));
		  
		 PdfPCell cell1060 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(16).getKiwisetotal()  : "", font208));
		   PdfPCell cell1061 = new PdfPCell(new Paragraph("3.3", font182));
		  
		  PdfPCell cell1062 = new PdfPCell(new Paragraph("Research Publications and Awards", font182)); 
		  PdfPCell cell1063 = new PdfPCell(new Paragraph("20", font182)); PdfPCell cell1064 = new
		  PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(17).getKiwisetotal()  : "", font182));
		   PdfPCell cell1065 = new PdfPCell(new  Paragraph("3.4", font182));
		  PdfPCell cell1066 = new PdfPCell(new Paragraph("Extension Activities", font182)); 
		  PdfPCell cell1067 = new  PdfPCell(new Paragraph("20", font182));
		 
		   PdfPCell cell1068 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(18).getKiwisetotal()  : "",font182));
		   PdfPCell cell1069 = new PdfPCell(new Paragraph("3.5", font182));
		  PdfPCell cell1070 = new PdfPCell(new Paragraph("Collaboration", font182));
		  PdfPCell cell1071 = new PdfPCell(new Paragraph("20", font182)); 
		  PdfPCell cell1072 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(19).getKiwisetotal() : "", font182));
		   PdfPCell cell1073 = new PdfPCell(new Paragraph("Total", font182));
		   PdfPCell cell1074 = new PdfPCell(); 
		  PdfPCell cell1075 = new PdfPCell();
		 
		  
		  Image img44 = Image.getInstance("image/equation3.jpg");
		  img44.scalePercent(70);
		  
		  Image img601 = Image.getInstance("image/k3.jpg"); img601.scalePercent(70);
		  
		   cell1074.addElement(new Chunk(img44, 15, 15)); 
		   
			  cell1073.setColspan(2); Paragraph paragraph000162 = new Paragraph("90");
			  cell1074.addElement(paragraph000162);
		  Paragraph paragraph000163 =
		  new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(2).getCriterionWiseWeighted() :
		  ""); cell1075.addElement(paragraph000163); 
		  cell1075.addElement(new Chunk(img601, 15, 15));
		  
		  
		  table145.addCell(cell1053); table145.addCell(cell1054);
		  table145.addCell(cell1055); table145.addCell(cell1056);
		  table145.addCell(cell1057); table145.addCell(cell1058);
		  table145.addCell(cell1059); table145.addCell(cell1060);
		  table145.addCell(cell1061); table145.addCell(cell1062);
		  table145.addCell(cell1063); table145.addCell(cell1064);
		  table145.addCell(cell1065); table145.addCell(cell1066);
		  table145.addCell(cell1067); table145.addCell(cell1068);
		  table145.addCell(cell1069); table145.addCell(cell1070);
		  table145.addCell(cell1071); table145.addCell(cell1072);
		  table145.addCell(cell1073); table145.addCell(cell1074);
		  table145.addCell(cell1075);
		  
		  document.add(table145);
		  
		  //calculation 3
		  PdfPTable table146 = new PdfPTable(1);
		  table146.setWidthPercentage(100f);
		  table146.setHorizontalAlignment(Element.ALIGN_MIDDLE); com.lowagie.text.Font
		  font300 = FontFactory.getFont(FontFactory.TIMES_ROMAN); PdfPCell cell1076 =
		  new PdfPCell(); //cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
		  
		  Paragraph paragraph000164 = new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(2).getCriterionWiseGrade()  : "");
		  cell1076.addElement(paragraph000164);
		  
		  
		  Image img147 = Image.getInstance("image/w3.jpg"); img147.scalePercent(70);
		  
		   cell1076.addElement(new Chunk(img147, 15, 15));
		  table146.addCell(cell1076); document.add(table146);
		  
		  //criteria4
		  
		  PdfPTable table147 = new PdfPTable(1); table147.setWidthPercentage(100f);
		  table147.setHorizontalAlignment(Element.ALIGN_MIDDLE); com.lowagie.text.Font
		  font301 = FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		 
		  PdfPCell cell1077 = new PdfPCell(new Paragraph("Criterion 4: Infrastructure and Learning Resources", font301));
		  cell1077.setHorizontalAlignment(Element.ALIGN_CENTER);
		  table147.addCell(cell1077);
		  document.add(table147);
		  
		  PdfPTable table148 = new PdfPTable(4); table148.setWidthPercentage(100f);
		  table148.setHorizontalAlignment(Element.ALIGN_MIDDLE); com.lowagie.text.Font
		  font302 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		   PdfPCell cell1078 = new PdfPCell(new Paragraph("4.1", font302)); PdfPCell cell1079 = new
		  PdfPCell(new Paragraph("Physical Facilities", font302)); 
		  PdfPCell cell1080 = new PdfPCell(new Paragraph("20", font302)); 
		  PdfPCell cell1081 = new  PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(20).getKiwisetotal() : "", font302));
		   PdfPCell cell1082 = new PdfPCell(new  Paragraph("4.3", font302));
		  
		  PdfPCell cell1083 = new PdfPCell(new Paragraph("IT Infrastructure", font302)); 
		  PdfPCell cell1084 = new PdfPCell(new Paragraph("10", font302)); 
		  PdfPCell cell1085 = new PdfPCell(new  Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(21).getKiwisetotal()   : "",font302));
		  
		  
		  PdfPCell cell1086 = new PdfPCell(new Paragraph("4.3", font302)); 
		  PdfPCell cell1087 = new PdfPCell(new Paragraph("Maintence of Campus Infrastructure", font302)); 
		  PdfPCell cell1088 = new PdfPCell(new Paragraph("20", font302));
		  
		  PdfPCell cell1089 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(22).getKiwisetotal()  : "",font302));
		   PdfPCell cell1090 = new PdfPCell(new Paragraph("Total", font302));
		  PdfPCell cell1091 = new PdfPCell(); PdfPCell cell1092 = new PdfPCell();
		   cell1090.setColspan(2);
		  
		   
		  Image img151 = Image.getInstance("image/equation4.jpg"); 
		  img151.scalePercent(70);
		  
		  Paragraph paragraph000166 = new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(2).getCriterionWiseWeighted() :""); 
		  cell1092.addElement(paragraph000166); //
		  cell1091.addElement(new Chunk(img151, 15, 15)); 
		  Paragraph paragraph000165 = new Paragraph("50");
		  cell1091.addElement(paragraph000165);
		  Image img152 =  Image.getInstance("image/k4.jpg"); img152.scalePercent(70);
		  
		  cell1092.addElement(new Chunk(img152, 15, 15));
		  table148.addCell(cell1078); table148.addCell(cell1079);
		  table148.addCell(cell1080); table148.addCell(cell1081);
		  table148.addCell(cell1082); table148.addCell(cell1083);
		  table148.addCell(cell1084); table148.addCell(cell1085);
		  table148.addCell(cell1086); table148.addCell(cell1087);
		  table148.addCell(cell1088); table148.addCell(cell1089);
		  table148.addCell(cell1090); table148.addCell(cell1091);
		  table148.addCell(cell1092); document.add(table148);
		  
		  //calculation 4 
		  PdfPTable 
		  table149 = new PdfPTable(1);
		  table149.setWidthPercentage(100f);
		  table149.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font303 = FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		  
		  
		  
		  PdfPCell cell1093 = new PdfPCell(); 
		  Paragraph paragraph000167 = new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(3).getCriterionWiseGrade() : "");
		   cell1093.addElement(paragraph000167);
		  //cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
		  
		  Image img246 = Image.getInstance("image/w4.jpg"); img246.scalePercent(70);
		  
		   cell1093.addElement(new Chunk(img246, 15, 15));
		  table149.addCell(cell1093); 
		  document.add(table149);
		  //__------------------------------------------------------------------------
		  PdfPTable table477 = new PdfPTable(1); 
		  table477.setWidthPercentage(100f);
		  table477.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font308 = FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		  PdfPCell cell10101 =
		  new PdfPCell(new Paragraph("Criterion 5: Student Support and Progression",
		  font308)); cell10101.setHorizontalAlignment(Element.ALIGN_CENTER);
		  table477.addCell(cell10101); document.add(table477);
		  
		  PdfPTable table500 = new PdfPTable(4);
		  table500.setWidthPercentage(100f);
		  table500.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font600 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		//	com.lowagie.text.Font font188 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		  PdfPCell cell2501 =
		  new PdfPCell(new Paragraph("5.1", font600)); PdfPCell cell2502 = new
		  PdfPCell(new Paragraph("Student Support", font600)); PdfPCell cell2503 = new
		  PdfPCell(new Paragraph("50", font600));
		  PdfPCell cell2504 = new PdfPCell(new
		  Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(23).getKiwisetotal() : "",  font600));
		 PdfPCell cell2505 = new PdfPCell(new Paragraph("5.2", font600));
		  PdfPCell cell2506 = new PdfPCell(new Paragraph("Student Progression",
		  font188)); PdfPCell cell2507 = new PdfPCell(new Paragraph("30", font188));
		  PdfPCell cell2508 = new PdfPCell(new
		  Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(24).getKiwisetotal() : "",
		  font188));
		  
		  PdfPCell cell2509 = new PdfPCell(new Paragraph("5.3", font188));
		  PdfPCell cell2510 = new PdfPCell(new Paragraph("Student Participation and Activities",
				  font188));
		  PdfPCell cell2511 = new PdfPCell(new Paragraph("50", font188));
		  PdfPCell cell2512 = new PdfPCell(new
		  Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(25).getKiwisetotal()  : "",
		  font188)); PdfPCell cell2513 = new PdfPCell(new Paragraph("Total", font188));
		  PdfPCell cell2514 = new PdfPCell();
		  PdfPCell cell2515 = new PdfPCell();
		  cell2513.setColspan(2); 
		
		  
		  Image img2517 = Image.getInstance("image/equation5.jpg");
		  img2517.scalePercent(70);
		  
		  Paragraph paragraph000169 = new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(4).getCriterionWiseWeighted() :"");
		   cell2515.addElement(paragraph000169);
		  cell2514.addElement(new Chunk(img2517, 15, 15));
		  Paragraph paragraph000168 = new Paragraph("130");
		  cell2514.addElement(paragraph000168);
		  Image img2519 = Image.getInstance("image/k5.jpg"); img2519.scalePercent(70);
		  
		   cell2515.addElement(new Chunk(img2519, 15, 15));
		  table500.addCell(cell2501); table500.addCell(cell2502);
		  table500.addCell(cell2503); table500.addCell(cell2504);
		  table500.addCell(cell2505); table500.addCell(cell2506);
		  table500.addCell(cell2507); table500.addCell(cell2508);
		  table500.addCell(cell2509); table500.addCell(cell2510);
		  table500.addCell(cell2511); table500.addCell(cell2512);
		  table500.addCell(cell2513); table500.addCell(cell2514);
		  table500.addCell(cell2515);
		  
		  document.add(table500);
		  
		  PdfPTable table521 = new PdfPTable(1); table521.setWidthPercentage(100f);
		  table521.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font522 = FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		  
		  PdfPCell cell2523 =
		  new PdfPCell(); Paragraph paragraph000170 = new
		  Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(4).getCriterionWiseGrade() : "");
		  cell2523.addElement(paragraph000170);
		  
		  Image img524 = Image.getInstance("image/w11.jpg"); img524.scalePercent(70);
		  
		   cell2523.addElement(new Chunk(img524, 15, 15));
		  
		//  cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
		  table521.addCell(cell2523); document.add(table521);
		  
		  PdfPTable table522 = new PdfPTable(1); table522.setWidthPercentage(100f);
		  table522.setHorizontalAlignment(Element.ALIGN_MIDDLE); com.lowagie.text.Font
		  font1901 = FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		  PdfPCell cell2524 =
		  new PdfPCell(new
		  Paragraph("Criterion 6: Governance, Leadership and Management", font1901));
		  cell2524.setHorizontalAlignment(Element.ALIGN_CENTER);
		  table522.addCell(cell2524); document.add(table522);
		  
		  //--------------------------------------6 criteria--------------------------
		  
		  PdfPTable table11132 = new PdfPTable(4); table11132.setWidthPercentage(100f);
		  table11132.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		  com.lowagie.text.Font font2191 =
		  FontFactory.getFont(FontFactory.TIMES_ROMAN);
		  
		  PdfPCell cell4467 = new PdfPCell(new Paragraph("6.2", font2191)); 
		 PdfPCell cell4468 = new PdfPCell(new Paragraph("Strategy Development and Development",font2191));
		   PdfPCell cell4469 = new PdfPCell(new Paragraph("10", font2191));
		  
		 PdfPCell cell4470 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(26).getKiwisetotal()  : "",font2191));
		  
		  
		  PdfPCell cell4471 = new PdfPCell(new Paragraph("6.3", font2191)); 

		  PdfPCell cell4472 = new PdfPCell(new Paragraph("Faculty Empowerment Strategies",font2191));
		  PdfPCell cell4473 = new PdfPCell(new Paragraph("35", font2191));
		 
		   PdfPCell cell4474 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(27).getKiwisetotal()  : "",font2191));
		  
		  
		  PdfPCell cell4479 = new PdfPCell(new Paragraph("6.5", font2191)); 
		  PdfPCell cell4480 = new PdfPCell(new Paragraph("Internal Quality Assurance System",
		  font2191)); PdfPCell cell4481 = new PdfPCell(new Paragraph("30", font2191));
		 
		   PdfPCell cell4482 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(28).getKiwisetotal()  : "", font2191));
		  PdfPCell cell4483 = new PdfPCell(new Paragraph("Total",font2191));
		   PdfPCell cell4484 = new PdfPCell();
		   PdfPCell cell4485 = new PdfPCell(); 
		   cell4483.setColspan(2); 
		   Paragraph paragraph000171 = new Paragraph("75");
		   cell4484.addElement(paragraph000171);
		  
		  //Paragraph paragraph40 = new Paragraph("128"); //rightCell484 .addElement(paragraph40);
		 
		   Image img11789 =  Image.getInstance("image/equation6.jpg"); img11789.scalePercent(70);
		  
		  //PdfPCell cell38 = new PdfPCell(); 
		  Paragraph paragraph000172 = new
		  Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(5).getCriterionWiseWeighted() : "");
		  cell4485.addElement(paragraph000172);
		  
		  cell4484.addElement(new Chunk(img11789, 15, 15));
		  
		  //paragraph40.setAlignment(Right); //cell4484.addElement(paragraph40);
		  //rightCell .addElement(addText); //cell4485.addElement(new Chunk(img15,15,15));
		   Image img3911 = Image.getInstance("image/k6.jpg");
		  img3911.scalePercent(70);
		  
		   cell4485.addElement(new Chunk(img3911, 15, 15));
		  
		  table11132.addCell(cell4467); table11132.addCell(cell4468);
		  table11132.addCell(cell4469); table11132.addCell(cell4470);
		  table11132.addCell(cell4471); table11132.addCell(cell4472);
		  table11132.addCell(cell4473); table11132.addCell(cell4474);
		  
		  table11132.addCell(cell4479); table11132.addCell(cell4480);
		  table11132.addCell(cell4481); table11132.addCell(cell4482);
		  table11132.addCell(cell4483); table11132.addCell(cell4484);
		  table11132.addCell(cell4485); document.add(table11132);
		  
		  PdfPTable table524 = new PdfPTable(1); table524.setWidthPercentage(100f);
		  table524.setHorizontalAlignment(Element.ALIGN_MIDDLE); com.lowagie.text.Font
		  font5000 = FontFactory.getFont(FontFactory.TIMES_ROMAN); PdfPCell cell5261 =
		  new PdfPCell(); Paragraph paragraph000176 = new
		  Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(5).getCriterionWiseGrade()  : "");
		  cell5261.addElement(paragraph000176);
		  
		  Image img527 = Image.getInstance("image/w6.jpg"); img527.scalePercent(70);
		  
		  cell5261.addElement(new Chunk(img527, 15, 15));
		//  cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
		  table524.addCell(cell5261); document.add(table524);
		  
		  PdfPTable table525 = new PdfPTable(1);
		   table525.setWidthPercentage(100f);
		  table525.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font5001 = FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		  
		  
		  PdfPCell cell5273 = new PdfPCell( new Paragraph("Criterion 7: Institutional Values and Best Practices", font5001));
		  cell5273.setHorizontalAlignment(Element.ALIGN_CENTER);
		  table525.addCell(cell5273); document.add(table525);
		  
		  PdfPTable table526 = new PdfPTable(4); 
		  table526.setWidthPercentage(100f);
		  table526.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font1941 = FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		 
		   PdfPCell cell2527 = new PdfPCell(new Paragraph("7.1", font1941)); 
		 PdfPCell cell2528 = new PdfPCell(new Paragraph("Institutional Values and Social Responsibilities", font1941));
		  PdfPCell cell2529 = new PdfPCell(new Paragraph("30", font1941));
		  
		  PdfPCell cell2530 = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(29 ).getKiwisetotal()  : "",font1941));
		   PdfPCell cell2531 = new PdfPCell(new Paragraph("Total", font1941));
		  PdfPCell cell2532 = new PdfPCell(); PdfPCell cell2533 = new PdfPCell();
		  
		  cell2531.setColspan(2); Paragraph paragraph000177 = new Paragraph("30");
		  cell2532.addElement(paragraph000177); Image img018 =
		  Image.getInstance("image/equation7.jpg"); img018.scalePercent(70);
		  
		  Paragraph paragraph000178 = new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(6).getCriterionWiseWeighted() : "");
		   cell2533.addElement(paragraph000178); //
		  cell2532.addElement(new Chunk(img018, 15, 15));
		  
		  Image img041000000 = Image.getInstance("image/k7.jpg"); img041000000.scalePercent(70);
		  
		   cell2533.addElement(new Chunk(img041000000, 15, 15));
		  
		  table526.addCell(cell2527); table526.addCell(cell2528);
		  table526.addCell(cell2529); table526.addCell(cell2530);
		  table526.addCell(cell2531); table526.addCell(cell2532);
		  table526.addCell(cell2533);
		  
		  document.add(table526);
		  
		  //---calculation--- //calculation 7
		  PdfPTable table0021 = new PdfPTable(1);
		  table0021.setWidthPercentage(100f);
		  table0021.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font1180 = FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		  PdfPCell cell2101 =new PdfPCell();
		  
		  
		  Paragraph paragraph00000062 = new Paragraph(CollectionUtils.isNotEmpty(quanin) ? quanin.get(6).getCriterionWiseGrade() : "", font1180);
		  
		  cell2101.addElement(paragraph00000062);
		  //cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
		  
		  Image img0048 = Image.getInstance("image/w7.jpg"); img0048.scalePercent(70);
		  
		  cell2101.addElement(new Chunk(img0048, 15, 15));
		  
		  table0021.addCell(cell2101); document.add(table0021);
		  
		  //-----------------------------------------------grade total--------------
		  PdfPTable table150 = new PdfPTable(3); table150.setWidthPercentage(100f);
		  table150.setHorizontalAlignment(Element.ALIGN_MIDDLE); 
		  com.lowagie.text.Font
		  font304 = FontFactory.getFont(FontFactory.TIMES_ROMAN); 
		  PdfPCell cell1094 = new PdfPCell(new Paragraph("Grade Total", font304));
		  cell1094.setHorizontalAlignment(Element.ALIGN_CENTER); 
		  BigDecimal sum13 = new BigDecimal(70).add(new BigDecimal(225)).add(new BigDecimal(90)).add(new BigDecimal(50))
					.add(new BigDecimal(130)).add(new BigDecimal(75)).add(new BigDecimal(30));

			PdfPCell cell1095 = new PdfPCell(new Paragraph("" + sum13.intValue(), font304));

			BigDecimal sum8 = new BigDecimal(
					CollectionUtils.isNotEmpty(quanin) ? quanin.get(0).getCriterionWiseWeighted() : "")
					.add(new BigDecimal(CollectionUtils.isNotEmpty(quanin) ? quanin.get(1).getCriterionWiseWeighted() : ""))
					.add(new BigDecimal(CollectionUtils.isNotEmpty(quanin) ? quanin.get(2).getCriterionWiseWeighted() : ""))
					.add(new BigDecimal(CollectionUtils.isNotEmpty(quanin) ? quanin.get(3).getCriterionWiseWeighted() : ""))
					.add(new BigDecimal(CollectionUtils.isNotEmpty(quanin) ? quanin.get(4).getCriterionWiseWeighted() : ""))
					.add(new BigDecimal(CollectionUtils.isNotEmpty(quanin) ? quanin.get(5).getCriterionWiseWeighted() : ""))
					.add(new BigDecimal(
							CollectionUtils.isNotEmpty(quanin) ? quanin.get(6).getCriterionWiseWeighted() : ""));
			PdfPCell cell1096 = new PdfPCell(new Paragraph("" + sum8.intValue()));
			
	BigDecimal avg4 = sum8.divide(sum13,2,RoundingMode.CEILING);

			// PdfPCell cell1096 = new PdfPCell(new
			// Paragraph(CollectionUtils.isNotEmpty(quan) ? quan.get(1).getQntt4() : ""));

			// ""+sum2.intValue()

			// cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
			table150.addCell(cell1094);
			table150.addCell(cell1095);
			table150.addCell(cell1096);
			document.add(table150);
		 


		PdfPTable table151 = new PdfPTable(1);
		table151.setWidthPercentage(100f);
		table151.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		com.lowagie.text.Font font305 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell1097 = new PdfPCell();
		PdfPCell cell1098 = new PdfPCell(new Paragraph("Grade :"  +getGradeValue(avg4), font305));
		cell1098.setHorizontalAlignment(Element.ALIGN_CENTER);
		Image img407 = Image.getInstance("image/IN.jpg");
		img407.scalePercent(70);

//
		cell1097.addElement(new Chunk(img407, 15, 15));
		Paragraph paragraph200000000 = new Paragraph( "                   " + avg4);
		cell1097.addElement(paragraph200000000);

//cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
		table151.addCell(cell1097);
		table151.addCell(cell1098);
		;
		document.add(table151);
//----------
		PdfPTable table39000 = new PdfPTable(1);
		table39000.setWidthPercentage(100f);
		table39000.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		com.lowagie.text.Font font19800 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		PdfPCell cell50800 = new PdfPCell();
		table39000.addCell(cell50800);
		document.add(table39000);

		document.close();
	//	return null;
		return reportPath;
		
	}



	
	
 public String getGradeValue(BigDecimal pointAvg)  {
	 String gradeValue = "A";
	 try {
		 	if (pointAvg.intValue() >= 3.51 && pointAvg.intValue()<= 4.00) {
		 		gradeValue = "A++";
		 	}else if(pointAvg.intValue() >= 3.26 && pointAvg.intValue() <= 3.50) {
		 		gradeValue = "A+";
		 	}else if(pointAvg.intValue() >= 3.01 && pointAvg.intValue() <= 3.25) {
		 		gradeValue = "A";
		 	}else if(pointAvg.intValue() >= 2.76 && pointAvg.intValue() <= 3.00) {
		 		gradeValue = "B++";	
		 	}else if(pointAvg.intValue() >= 2.51 && pointAvg.intValue() <= 2.75) {
		 		gradeValue = "B+";
		 	}else if(pointAvg.intValue() >= 2.01 && pointAvg.intValue() <= 2.50) {
		 		gradeValue = "B";	
		 	}else if(pointAvg.intValue() >= 1.51 && pointAvg.intValue() <= 2.00) {
		 		gradeValue = "C";	
		 	}else if(pointAvg.intValue() >= 1.51 && pointAvg.intValue() <= 1.50) {
		 		gradeValue = "D";		
		 	}
	 }catch(Exception e) {
		 logger.info("Got the exception =>{}",e);
	 }
	 return gradeValue;
}

	
	
  
}
		
				
		
