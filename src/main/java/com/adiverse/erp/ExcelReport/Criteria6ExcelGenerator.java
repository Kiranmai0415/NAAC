package com.adiverse.erp.ExcelReport;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.adiverse.erp.model.Criteria6_FieldInfo;

public class Criteria6ExcelGenerator {

	private List<Criteria6_FieldInfo> listRecords;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFSheet sheet1;
	private XSSFSheet sheet2;
	private XSSFSheet sheet3;
	private XSSFSheet sheet4;
	private XSSFSheet sheet5;
	private XSSFSheet sheet6;
	private XSSFSheet sheet7;
	private XSSFSheet sheet8;
	private XSSFSheet sheet9;
	private XSSFSheet sheet10;
	
	private XSSFSheet sheet11;
    private XSSFSheet sheet12;
	private XSSFSheet sheet13;
	private XSSFSheet sheet14;
	private XSSFSheet sheet15;
	private XSSFSheet sheet16;
	private XSSFSheet sheet17;

	

	private String[] excelHeaders = new String[] { "collegeId", "financialYear", "typeofInstitution" };

	// criteria61ql
	private String[] excelHeaders1 = new String[] { "unique_key1", "input611t1", "responseValue611", "input612t1",
			"responseValue612", "collegeId", "financialYear", "typeofInstitution" };

	// criteria62ql
	private String[] excelHeaders2 = new String[] { "unique_key1", "responseValue621", "input621t1", "responseValu622",
			"input622t1", "collegeId", "financialYear", "typeofInstitution" };

	// criteria62qn

	private String[] excelHeaders3 = new String[] { "unique_key1", "responseValue623", "input623t1", "collegeId",
			"financialYear", "typeofInstitution" };

	// criteria63ql

	private String[] excelHeaders4 = new String[] { "unique_key1", "input631t1", "responseValue631", "responseValue633",
			"input633t1", "collegeId", "financialYear", "typeofInstitution" };

//criteria63qn
	private String[] excelHeaders5 = new String[] { "unique_key1", "responseValue632", "input632t1", "responseValue634",
			"input633t1", "collegeId", "financialYear", "typeofInstitution" };

	// criteria64ql
	private String[] excelHeaders6 = new String[] { "unique_key1", "responseValue641", "input641t1", "input643t1",
			"responseValue643", "responseValue644", "input644t1", "collegeId", "financialYear", "typeofInstitution" };

	// criteria64qn
	private String[] excelHeaders7 = new String[] { "unique_key1", "responseValue642", "input642t1", "collegeId",
			"financialYear", "typeofInstitution" };

	// criteria65ql
	private String[] excelHeaders8 = new String[] { "unique_key1", "input651t1", "responseValue651", "input652t1",
			"responseValue652", "collegeId", "financialYear", "typeofInstitution" };

	// criteria65qn
	private String[] excelHeaders9 = new String[] { "unique_key1", "responseValue653", "input653t1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders10 = new String[] { "unique_key1", "criteria6_file_name", "criteria6_file_path",
			"criteria6_file_type", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders11 = new String[] { "unique_key1", "year", "conferences_workshops", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders12 = new String[] { "unique_key1", "year", "conferences_workshops", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders13 = new String[] { "unique_key1", "year", "development_administrative", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders14 = new String[] { "unique_key1", "year", "nonteachingstaff", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders15 = new String[] { "unique_key1", "year", "development_programmes", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders16 = new String[] { "unique_key1", "year", "development_programmes", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders17 = new String[] { "unique_key1", "year", "philanthropists_year", "collegeId",
			"financialYear", "typeofInstitution" };

	public Criteria6ExcelGenerator(List<Criteria6_FieldInfo> listRecords) {
		this.listRecords = listRecords;
		workbook = new XSSFWorkbook();
	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Long) {
			cell.setCellValue((Long) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

//		Criteria5  criteriaId

	private void writeHeader() {
		sheet = workbook.createSheet("criteria6_fieldinfo");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders[0], style);
		createCell(row, 1, excelHeaders[1], style);
		createCell(row, 2, excelHeaders[2], style);

	}

	private void write() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// criteria61Ql
	private void writeHeader1() {
		sheet1 = workbook.createSheet("Criteria61Ql");

		Row row = sheet1.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders1[0], style);
		createCell(row, 1, excelHeaders1[1], style);
		createCell(row, 2, excelHeaders1[2], style);
		createCell(row, 3, excelHeaders1[3], style);
		createCell(row, 4, excelHeaders1[4], style);
		createCell(row, 5, excelHeaders1[5], style);
		createCell(row, 6, excelHeaders1[6], style);

	}

	private void write1() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria61Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria61Ql().get(0).getInput611t1(), style);
			createCell(row, columnCount++, record.getCriteria61Ql().get(0).getInput612t1(), style);
			createCell(row, columnCount++, record.getCriteria61Ql().get(0).getResponse612(), style);
			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria62Ql
	private void writeHeader2() {
		sheet2 = workbook.createSheet("Criteria62Ql");

		Row row = sheet2.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders2[0], style);
		createCell(row, 1, excelHeaders2[1], style);
		createCell(row, 2, excelHeaders2[2], style);
		createCell(row, 3, excelHeaders2[3], style);
		createCell(row, 4, excelHeaders2[4], style);
		createCell(row, 5, excelHeaders2[5], style);
		createCell(row, 6, excelHeaders2[6], style);
		createCell(row, 7, excelHeaders2[7], style);

	}

	private void write2() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet2.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria62Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria62Ql().get(0).getResponse621(), style);
			createCell(row, columnCount++, record.getCriteria62Ql().get(0).getInput621t1(), style);
			createCell(row, columnCount++, record.getCriteria62Ql().get(0).getResponse622(), style);
			createCell(row, columnCount++, record.getCriteria62Ql().get(0).getInput622t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria62Qn
	private void writeHeader3() {
		sheet3 = workbook.createSheet("Criteria62Qn");

		Row row = sheet3.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders3[0], style);
		createCell(row, 1, excelHeaders3[1], style);
		createCell(row, 2, excelHeaders3[2], style);
		createCell(row, 3, excelHeaders3[3], style);
		createCell(row, 4, excelHeaders3[4], style);
		createCell(row, 5, excelHeaders3[5], style);

	}

	private void write3() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet3.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria62Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria62Qn().get(0).getResponse623(), style);
			createCell(row, columnCount++, record.getCriteria62Qn().get(0).getInput623t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria63Ql
	private void writeHeader4() {
		sheet4 = workbook.createSheet("Criteria63Ql");

		Row row = sheet4.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders4[0], style);
		createCell(row, 1, excelHeaders4[1], style);
		createCell(row, 2, excelHeaders4[2], style);
		createCell(row, 3, excelHeaders4[3], style);
		createCell(row, 4, excelHeaders4[4], style);
		createCell(row, 5, excelHeaders4[5], style);
		createCell(row, 6, excelHeaders4[6], style);
		createCell(row, 7, excelHeaders4[7], style);

	}

	private void write4() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet4.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria63Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria63Ql().get(0).getInput631t1(), style);
			createCell(row, columnCount++, record.getCriteria63Ql().get(0).getResponse631(), style);
			createCell(row, columnCount++, record.getCriteria63Ql().get(0).getResponse633(), style);
			createCell(row, columnCount++, record.getCriteria63Ql().get(0).getInput633t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria63Qn
	private void writeHeader5() {
		sheet5 = workbook.createSheet("Criteria63Qn");

		Row row = sheet5.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders5[0], style);
		createCell(row, 1, excelHeaders5[1], style);
		createCell(row, 2, excelHeaders5[2], style);
		createCell(row, 3, excelHeaders5[3], style);
		createCell(row, 4, excelHeaders5[4], style);
		createCell(row, 5, excelHeaders5[5], style);
		createCell(row, 6, excelHeaders5[6], style);
		createCell(row, 7, excelHeaders5[7], style);

	}

	private void write5() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet5.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria63Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria63Qn().get(0).getResponse632(), style);
			createCell(row, columnCount++, record.getCriteria63Qn().get(0).getInput632t1(), style);
			createCell(row, columnCount++, record.getCriteria63Qn().get(0).getResponse634(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria64Ql
	private void writeHeader6() {
		sheet6 = workbook.createSheet("Criteria64Ql");

		Row row = sheet6.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders6[0], style);
		createCell(row, 1, excelHeaders6[1], style);
		createCell(row, 2, excelHeaders6[2], style);
		createCell(row, 3, excelHeaders6[3], style);
		createCell(row, 4, excelHeaders6[4], style);
		createCell(row, 5, excelHeaders6[5], style);
		createCell(row, 6, excelHeaders6[6], style);
		createCell(row, 7, excelHeaders6[7], style);
		createCell(row, 8, excelHeaders6[8], style);
		createCell(row, 9, excelHeaders6[9], style);

	}

	private void write6() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet6.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria64Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria64Ql().get(0).getResponse641(), style);
			createCell(row, columnCount++, record.getCriteria64Ql().get(0).getInput641t1(), style);
			createCell(row, columnCount++, record.getCriteria64Ql().get(0).getInput643t1(), style);

			createCell(row, columnCount++, record.getCriteria64Ql().get(0).getResponse643(), style);
			createCell(row, columnCount++, record.getCriteria64Ql().get(0).getResponse644(), style);
			createCell(row, columnCount++, record.getCriteria64Ql().get(0).getInput644t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria64Qn
	private void writeHeader7() {
		sheet7 = workbook.createSheet("Criteria64Qn");

		Row row = sheet7.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders7[0], style);
		createCell(row, 1, excelHeaders7[1], style);
		createCell(row, 2, excelHeaders7[2], style);
		createCell(row, 3, excelHeaders7[3], style);
		createCell(row, 4, excelHeaders7[4], style);
		createCell(row, 5, excelHeaders7[5], style);

	}

	private void write7() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet7.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria64Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria64Qn().get(0).getResponse642(), style);
			createCell(row, columnCount++, record.getCriteria64Qn().get(0).getInput642t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria65Ql
	private void writeHeader8() {
		sheet8 = workbook.createSheet("Criteria65Ql");

		Row row = sheet8.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders8[0], style);
		createCell(row, 1, excelHeaders8[1], style);
		createCell(row, 2, excelHeaders8[2], style);
		createCell(row, 3, excelHeaders8[3], style);
		createCell(row, 4, excelHeaders8[4], style);
		createCell(row, 5, excelHeaders8[5], style);

	}

	private void write8() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet8.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getInput651t1(), style);
			createCell(row, columnCount++, record.getCriteria65Qn().get(0).getResponse651(), style);
			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getInput652t1(), style);
			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getResponse652(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}
	

	// criteria65Qn
	private void writeHeader9() {
		sheet9 = workbook.createSheet("Criteria65Qn");

		Row row = sheet9.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders9[0], style);
		createCell(row, 1, excelHeaders9[1], style);
		createCell(row, 2, excelHeaders9[2], style);
		createCell(row, 3, excelHeaders9[3], style);
		createCell(row, 4, excelHeaders9[4], style);
		createCell(row, 5, excelHeaders9[5], style);

	}

	private void write9() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet9.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria65Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria65Qn().get(0).getResponse653(), style);
			createCell(row, columnCount++, record.getCriteria65Qn().get(0).getInput653t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

////		Criteria6_FieldInfoQl
//
//	private void writeHeader1() {
//		sheet1 = workbook.createSheet("Criteria6_FieldInfoQl");
//
//		Row row = sheet1.createRow(0);
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		font.setFontHeight(16);
//		style.setFont(font);
//
//		createCell(row, 0, excelHeaders1[0], style);
//		createCell(row, 1, excelHeaders1[1], style);
//		createCell(row, 2, excelHeaders1[2], style);
//		createCell(row, 3, excelHeaders1[3], style);
//		createCell(row, 4, excelHeaders1[4], style);
//
//		createCell(row, 5, excelHeaders1[5], style);
//		createCell(row, 6, excelHeaders1[6], style);
//		createCell(row, 7, excelHeaders1[7], style);
//		createCell(row, 8, excelHeaders1[8], style);
//		createCell(row, 9, excelHeaders1[9], style);
//
//		createCell(row, 10, excelHeaders1[10], style);
//		createCell(row, 11, excelHeaders1[11], style);
//		createCell(row, 12, excelHeaders1[12], style);
//		createCell(row, 13, excelHeaders1[13], style);
//		createCell(row, 14, excelHeaders1[14], style);
//
//		createCell(row, 15, excelHeaders1[15], style);
//		createCell(row, 16, excelHeaders1[16], style);
//		createCell(row, 17, excelHeaders1[17], style);
//		createCell(row, 18, excelHeaders1[18], style);
//		createCell(row, 19, excelHeaders1[19], style);
//		
//	    createCell(row, 20, excelHeaders1[20], style);
//		createCell(row, 21, excelHeaders1[21], style);
//	}
//
//	private void write1() {
//		int rowCount = 1;
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setFontHeight(14);
//		style.setFont(font);
//
//		for (Criteria6_FieldInfo record : listRecords) {
//			Row row = sheet1.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getCriteria61Ql().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getCriteria61Ql().get(0).getInput611t1(), style);
//			createCell(row, columnCount++, record.getCriteria61Ql().get(0).getInput612t1(), style);
//			createCell(row, columnCount++, record.getCriteria62Ql().get(0).getInput621t1(), style);
//			createCell(row, columnCount++, record.getCriteria62Ql().get(0).getInput622t1(), style);
//
//			createCell(row, columnCount++, record.getCriteria63Ql().get(0).getInput631t1(), style);
//			createCell(row, columnCount++, record.getCriteria64Ql().get(0).getInput641t1(), style);
//			createCell(row, columnCount++, record.getCriteria64Ql().get(0).getInput643t1(), style);
//			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getInput651t1(), style);
//			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getInput652t1(), style);
//
//			createCell(row, columnCount++, record.getCriteria61Ql().get(0).getResponse611(), style);
//			createCell(row, columnCount++, record.getCriteria61Ql().get(0).getResponse612(), style);
//			createCell(row, columnCount++, record.getCriteria62Ql().get(0).getResponse621(), style);
//			createCell(row, columnCount++, record.getCriteria62Ql().get(0).getResponse622(), style);
//			createCell(row, columnCount++, record.getCriteria63Ql().get(0).getResponse631(), style);
//			createCell(row, columnCount++, record.getCriteria64Ql().get(0).getResponse641(), style);
//
//			createCell(row, columnCount++, record.getCriteria61Ql().get(0).getCriteriaId().getCollegeId(),
//					style);
//			createCell(row, columnCount++, record.getCriteria64Ql().get(0).getResponse643(), style);
//			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getResponse651(), style);
//			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getResponse652(), style);
//
//			createCell(row, columnCount++, record.getCriteria61Ql().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getCriteria61Ql().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}
//
////		Criteria5 Criteria6_FieldInfoQn
//
//	private void writeHeader2() {
//		sheet2 = workbook.createSheet("Criteria6_FieldInfoQn");
//
//		Row row = sheet2.createRow(0);
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		font.setFontHeight(16);
//		style.setFont(font);
//
//		createCell(row, 0, excelHeaders2[0], style);
//		createCell(row, 1, excelHeaders2[1], style);
//		createCell(row, 2, excelHeaders2[2], style);
//		createCell(row, 3, excelHeaders2[3], style);
//		createCell(row, 4, excelHeaders2[4], style);
//
//		createCell(row, 5, excelHeaders2[5], style);
//		createCell(row, 6, excelHeaders2[6], style);
//		createCell(row, 7, excelHeaders2[7], style);
//		createCell(row, 8, excelHeaders2[8], style);
//		createCell(row, 9, excelHeaders2[9], style);
//
//		createCell(row, 10, excelHeaders2[10], style);
//		createCell(row, 11, excelHeaders2[11], style);
//		createCell(row, 12, excelHeaders2[12], style);
//		createCell(row, 13, excelHeaders2[13], style);
//		createCell(row, 14, excelHeaders2[14], style);
//
//		createCell(row, 15, excelHeaders2[15], style);
//		createCell(row, 16, excelHeaders2[16], style);
//		createCell(row, 17, excelHeaders2[17], style);
////		createCell(row, 18, excelHeaders2[18], style);
////		createCell(row, 19, excelHeaders2[19], style);
////
////		createCell(row, 20, excelHeaders2[20], style);
////		createCell(row, 21, excelHeaders2[21], style);
////		createCell(row, 22, excelHeaders2[22], style);
////		createCell(row, 23, excelHeaders2[20], style);
////		createCell(row, 24, excelHeaders2[21], style);
////
////		createCell(row, 25, excelHeaders2[20], style);
//
//	}
//
//	private void write2() {
//		int rowCount = 1;
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setFontHeight(14);
//		style.setFont(font);
//
//		for (Criteria6_FieldInfo record : listRecords) {
//			Row row = sheet2.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getCriteria61Qn().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getCriteria62Ql().get(0).getInput622t1(), style);
//			createCell(row, columnCount++, record.getCriteria62Qn().get(0).getInput623t1(), style);
//			createCell(row, columnCount++, record.getCriteria63Qn().get(0).getInput632t1(), style);
//			createCell(row, columnCount++, record.getCriteria63Ql().get(0).getInput633t1(), style);
//
//			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getInput652t1(), style);
//			createCell(row, columnCount++, record.getCriteria65Qn().get(0).getInput653t1(), style);
//			createCell(row, columnCount++, record.getCriteria62Ql().get(0).getResponse622(), style);
//			createCell(row, columnCount++, record.getCriteria62Qn().get(0).getResponse623(), style);
//			createCell(row, columnCount++, record.getCriteria63Qn().get(0).getResponse632(), style);
//
//			createCell(row, columnCount++, record.getCriteria63Ql().get(0).getResponse633(), style);
//			createCell(row, columnCount++, record.getCriteria63Qn().get(0).getResponse634(), style);
//			createCell(row, columnCount++, record.getCriteria64Qn().get(0).getResponse642(), style);
//			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getResponse652(), style);
//			createCell(row, columnCount++, record.getCriteria65Qn().get(0).getResponse653(), style);
//
//			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getCriteriaId().getCollegeId(),
//					style);
//			createCell(row, columnCount++, record.getCriteria65Ql().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getCriteria65Ql().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}

//		Criteria5_FileUpload

	private void writeHeader10() {
		sheet10 = workbook.createSheet("criteria6_fileupload");

		Row row = sheet10.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders10[0], style);
		createCell(row, 1, excelHeaders10[1], style);
		createCell(row, 2, excelHeaders10[2], style);
		createCell(row, 3, excelHeaders10[3], style);
		createCell(row, 4, excelHeaders10[4], style);
		createCell(row, 5, excelHeaders10[5], style);
		createCell(row, 6, excelHeaders10[6], style);

	}

	private void write10() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet10.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteria6FileUpload().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria6FileUpload().get(0).getCriteria6FileName(), style);
			createCell(row, columnCount++, record.getCriteria6FileUpload().get(0).getCriteria6FilePath(), style);
			createCell(row, columnCount++, record.getCriteria6FileUpload().get(0).getCriteria6FileType(), style);

			createCell(row, columnCount++, record.getCriteria6FileUpload().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getCriteria6FileUpload().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getCriteria6FileUpload().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//		Criteria5  YearTable6321 -1

	private void writeHeader11() {
		sheet11 = workbook.createSheet("YearTable6321");

		Row row = sheet11.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders11[0], style);
		createCell(row, 1, excelHeaders11[1], style);
		createCell(row, 2, excelHeaders11[2], style);
		createCell(row, 3, excelHeaders11[3], style);
		createCell(row, 4, excelHeaders11[4], style);
		createCell(row, 5, excelHeaders11[5], style);

	}

	private void write11() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet11.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable6321().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable6321().get(0).getInput6321v(), style);
			createCell(row, columnCount++, record.getYearTable6321().get(0).getInput6321v(), style);

			createCell(row, columnCount++, record.getYearTable6321().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable6321().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable6321().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//		Criteria5  YearTable63212 -2

	private void writeHeader12() {
		sheet12 = workbook.createSheet("YearTable63212");

		Row row = sheet12.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders12[0], style);
		createCell(row, 1, excelHeaders12[1], style);
		createCell(row, 2, excelHeaders12[2], style);
		createCell(row, 3, excelHeaders12[3], style);
		createCell(row, 4, excelHeaders12[4], style);
		createCell(row, 5, excelHeaders12[5], style);

	}

	private void write12() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet12.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable63212().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable63212().get(0).getInput63212v(), style);
			createCell(row, columnCount++, record.getYearTable63212().get(0).getInput63212y(), style);

			createCell(row, columnCount++, record.getYearTable63212().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable63212().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable63212().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// Criteria5 YearTable6331-3

	private void writeHeader13() {
		sheet13 = workbook.createSheet("YearTable6331");

		Row row = sheet13.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders13[0], style);
		createCell(row, 1, excelHeaders13[1], style);
		createCell(row, 2, excelHeaders13[2], style);
		createCell(row, 3, excelHeaders13[3], style);
		createCell(row, 4, excelHeaders13[4], style);
		createCell(row, 5, excelHeaders13[5], style);

	}

	private void write13() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet13.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable6331().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable6331().get(0).getInput6331v(), style);
			createCell(row, columnCount++, record.getYearTable6331().get(0).getInput6331y(), style);

			createCell(row, columnCount++, record.getYearTable6331().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable6331().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable6331().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//		Criteria5  affiliated_YearTable6332 -4

	private void writeHeader14() {
		sheet14 = workbook.createSheet("affiliated_YearTable6332");

		Row row = sheet14.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders14[0], style);
		createCell(row, 1, excelHeaders14[1], style);
		createCell(row, 2, excelHeaders14[2], style);
		createCell(row, 3, excelHeaders14[3], style);
		createCell(row, 4, excelHeaders14[4], style);
		createCell(row, 5, excelHeaders14[5], style);

	}

	private void write14() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet14.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliated_YearTable6332().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable6332().get(0).getInput6332v(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable6332().get(0).getInput6332y(), style);

			createCell(row, columnCount++, record.getAffiliated_YearTable6332().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable6332().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable6332().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//		  yeartable6341

	private void writeHeader15() {
		sheet15 = workbook.createSheet("yeartable6341");

		Row row = sheet15.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders15[0], style);
		createCell(row, 1, excelHeaders15[1], style);
		createCell(row, 2, excelHeaders15[2], style);
		createCell(row, 3, excelHeaders15[3], style);
		createCell(row, 4, excelHeaders15[4], style);
		createCell(row, 5, excelHeaders15[5], style);

	}

	private void write15() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet15.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable6341().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable6341().get(0).getInput6341v(), style);
			createCell(row, columnCount++, record.getYearTable6341().get(0).getInput6341y(), style);

			createCell(row, columnCount++, record.getYearTable6341().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable6341().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable6341().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//		  YearTable 

	private void writeHeader16() {
		sheet16 = workbook.createSheet("yearTable63412");

		Row row = sheet16.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders16[0], style);
		createCell(row, 1, excelHeaders16[1], style);
		createCell(row, 2, excelHeaders16[2], style);
		createCell(row, 3, excelHeaders16[3], style);
		createCell(row, 4, excelHeaders16[4], style);
		createCell(row, 5, excelHeaders16[5], style);

	}

	private void write16() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet16.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable63412().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable63412().get(0).getInput63412v(), style);
			createCell(row, columnCount++, record.getYearTable63412().get(0).getInput63412y(), style);

			createCell(row, columnCount++, record.getYearTable63412().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable63412().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable63412().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}
	// yeartable6421

	private void writeHeader17() {
		sheet17 = workbook.createSheet("yeartable6421");

		Row row = sheet17.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders17[0], style);
		createCell(row, 1, excelHeaders17[1], style);
		createCell(row, 2, excelHeaders17[2], style);
		createCell(row, 3, excelHeaders17[3], style);
		createCell(row, 4, excelHeaders17[4], style);
		createCell(row, 5, excelHeaders17[5], style);

	}

	private void write17() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria6_FieldInfo record : listRecords) {
			Row row = sheet17.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable6421().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable6421().get(0).getInput6421v(), style);
			createCell(row, columnCount++, record.getYearTable6421().get(0).getInput6421y(), style);

			createCell(row, columnCount++, record.getYearTable6421().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable6421().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable6421().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	public void generate(HttpServletResponse response,Map<String, String> allParams) throws IOException {
		
		if ("autonomous".equalsIgnoreCase(allParams.get("typeofInstitution"))) {
			

		
		writeHeader();
		writeHeader1();
		writeHeader2();
		writeHeader3();
		writeHeader4();
		writeHeader5();
		writeHeader6();
		writeHeader7();
		writeHeader8();
		writeHeader9();
		writeHeader10();
		writeHeader11();
		writeHeader12();
		writeHeader13();
		
		writeHeader15();
		writeHeader16();
		writeHeader17();

		

		write();
		write1();
		write2();
		write3();
		write4();
		write5();
		write6();
		write7();
		write8();
		write9();
		write10();
		write11();
		write12();
		write13();
		
		write15();
		write16();
		write17();
		
		}
		if ("university".equalsIgnoreCase(allParams.get("typeofInstitution"))) 
		{
			
			writeHeader();
			writeHeader1();
			writeHeader2();
			writeHeader3();
			writeHeader4();
			writeHeader5();
			writeHeader6();
			writeHeader7();
			writeHeader8();
			writeHeader9();
			writeHeader10();
			writeHeader11();
			writeHeader12();
			writeHeader13();
			
			writeHeader15();
			writeHeader16();
			writeHeader17();

			

			write();
			write1();
			write2();
			write3();
			write4();
			write5();
			write6();
			write7();
			write8();
			write9();
			write10();
			write11();
			write12();
			write13();
			
			write15();
			write16();
			write17();
			
			
		}
		
		if ("affiliated".equalsIgnoreCase(allParams.get("typeofInstitution"))) 
		{
			
			
			writeHeader();
			writeHeader1();
			writeHeader2();
			//writeHeader3();
			writeHeader4();
			writeHeader5();
			writeHeader6();
			writeHeader7();
			writeHeader8();
			writeHeader9();
			writeHeader10();
			writeHeader11();
			writeHeader12();
			writeHeader13();
			writeHeader14(); //affiliated
		//	writeHeader15();
		//	writeHeader16();
		//	writeHeader17();

			

			write();
			write1();
			write2();
		//	write3();
			write4();
			write5();
			write6();
			write7();
			write8();
			write9();
			write10();
			write11();
			write12();
			write13();
			write14(); //affiliated
			//write15();
			//write16();
			//write17();
			
			
		}
		
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
