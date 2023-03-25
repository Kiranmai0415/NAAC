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

import com.adiverse.erp.model.Criteria1_FieldInfo;

public class Criteria1ExcelGenerator {

	private List<Criteria1_FieldInfo> listRecords;
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
	

	private String[] excelHeaders = new String[] { "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders1 = new String[] { "unique_key1", "input111t1", "responseValue111", "collegeId",
			"financialYear", "typeofInstitution" };
	
	private String[] excelHeaders2 = new String[] { "unique_key1", "responseValue112", "input1121t1", "input1122t1",
			"responseValue113", "collegeId", "financialYear", "typeofInstitution" };
	
	private String[] excelHeaders3 = new String[] { "unique_key1", "responseValue121", "responseValue122",
			"input1211t1", "input1212t1", "input1221t1", "input1221t2", "collegeId", "financialYear","typeofInstitution" };
	
	private String[] excelHeaders4 = new String[] { "unique_key1", "input131t1", "responseValue131", "responseValue132",
			"input132t1", "input132t2", "collegeId", "financialYear", "typeofInstitution" };
	
	private String[] excelHeaders5 = new String[] { "unique_key1", "responseValue132", "responseValue134",
			"input1341t1", "input1341t2", "collegeId", "financialYear", "typeofInstitution" };
	
	private String[] excelHeaders6 = new String[] { "unique_key1", "responseValue141", "input141t1", "input141t2",
			"responseValue142", "input142t1", "input142t2", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders7 = new String[] { "unique_key1", "year", "skill_development", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders8 = new String[] { "unique_key1", "year", "skill_development_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders9 = new String[] { "unique_key1", "year", "value_added", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders10 = new String[] { "unique_key1", "year", "added_courses", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders11 = new String[] { "unique_key1", "year", "added_courses_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders12 = new String[] { "unique_key1", "criteria1_file_name", "criteria1_file_path",
			"criteria1_file_type", "collegeId", "financialYear", "typeofInstitution" };
	
	private String[] excelHeaders13= new String[] { "unique_key1", "year", "subject",
			 "collegeId", "financialYear", "typeofInstitution" };
	
	
	
	
	

	public Criteria1ExcelGenerator(List<Criteria1_FieldInfo> listRecords) {
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

//	criteria 1 fieldinfo

	private void writeHeader() {
		sheet = workbook.createSheet("Criteria1FieldInfo");

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

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);

		}
	}

//	criteria11Ql  

	private void writeHeader1() {
		sheet1 = workbook.createSheet("Criteria11Ql");

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
//		createCell(row, 6, excelHeaders1[6], style);
//		createCell(row, 7, excelHeaders1[7], style);

	}

	private void write1() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria11Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria11Ql().get(0).getInput111t1(), style);
			createCell(row, columnCount++, record.getCriteria11Ql().get(0).getResponse111(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

//	criteria11Qn 

	private void writeHeader2() {
		sheet2 = workbook.createSheet("Criteria11Qn");

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

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet2.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria11Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria11Qn().get(0).getResponse112(), style);
			createCell(row, columnCount++, record.getCriteria11Qn().get(0).getInput1121t1(), style);
			createCell(row, columnCount++, record.getCriteria11Qn().get(0).getInput1122t1(), style);
			createCell(row, columnCount++, record.getCriteria11Qn().get(0).getResponse113(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria 12Qn

	private void writeHeader3() {
		sheet3 = workbook.createSheet("Criteria12Qn");

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
		createCell(row, 6, excelHeaders3[6], style);
		createCell(row, 7, excelHeaders3[7], style);
		createCell(row, 8, excelHeaders3[8], style);
		createCell(row, 9, excelHeaders3[9], style);

	}

	private void write3() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet3.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria12Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria12Qn().get(0).getResponse121(), style);
			createCell(row, columnCount++, record.getCriteria12Qn().get(0).getResponse122(), style);
			createCell(row, columnCount++, record.getCriteria12Qn().get(0).getInput1211t1(), style);
			createCell(row, columnCount++, record.getCriteria12Qn().get(0).getInput1212t1(), style);
			createCell(row, columnCount++, record.getCriteria12Qn().get(0).getInput1221t1(), style);
			createCell(row, columnCount++, record.getCriteria12Qn().get(0).getInput1221t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria 13Ql

	private void writeHeader4() {
		sheet4 = workbook.createSheet("Criteria13Ql");

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
		createCell(row, 8, excelHeaders4[7], style);

	}

	private void write4() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet4.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria13Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria13Ql().get(0).getInput131t1(), style);
			createCell(row, columnCount++, record.getCriteria13Ql().get(0).getResponse131(), style);
			createCell(row, columnCount++, record.getCriteria13Ql().get(0).getResponse132(), style);
			createCell(row, columnCount++, record.getCriteria13Ql().get(0).getInput132t1(), style);
			createCell(row, columnCount++, record.getCriteria13Ql().get(0).getInput132t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria13Qn

	private void writeHeader5() {
		sheet5 = workbook.createSheet("Criteria13Qn");

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
		createCell(row, 8, excelHeaders5[7], style);

	}

	private void write5() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet5.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria13Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria13Qn().get(0).getResponseValue132(), style);
			createCell(row, columnCount++, record.getCriteria13Qn().get(0).getResponse133(), style);
			createCell(row, columnCount++, record.getCriteria13Qn().get(0).getResponse134(), style);
			createCell(row, columnCount++, record.getCriteria13Qn().get(0).getInput1341t1(), style);
			createCell(row, columnCount++, record.getCriteria13Qn().get(0).getInput1341t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria14Qn

	private void writeHeader6() {
		sheet6 = workbook.createSheet("Criteria14Qn");

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
		createCell(row, 8, excelHeaders6[7], style);
		createCell(row, 9, excelHeaders6[7], style);

	}

	private void write6() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet6.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria14Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria14Qn().get(0).getResponse141(), style);
			createCell(row, columnCount++, record.getCriteria14Qn().get(0).getInput141t1(), style);
			createCell(row, columnCount++, record.getCriteria14Qn().get(0).getInput141t2(), style);
			createCell(row, columnCount++, record.getCriteria14Qn().get(0).getResponse142(), style);
			createCell(row, columnCount++, record.getCriteria14Qn().get(0).getInput142t1(), style);
			createCell(row, columnCount++, record.getCriteria14Qn().get(0).getInput142t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// YearTable1131

	private void writeHeaderyears7() {
		sheet7 = workbook.createSheet("YearTable1131");

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

	private void writeyears7() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet7.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getYearTable1131().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable1131().get(0).getInput1131y(), style);
			createCell(row, columnCount++, record.getYearTable1131().get(0).getInput1131v(), style);
			createCell(row, columnCount++, record.getYearTable1131().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable1131().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable1131().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// YearTable11312 2 table

	private void writeHeaderyears8() {
		sheet8 = workbook.createSheet("YearTable11312");

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

	private void writeyears8() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet8.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getYearTable11312().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable11312().get(0).getInput11312v(), style);
			createCell(row, columnCount++, record.getYearTable11312().get(0).getInput11312y(), style);
			createCell(row, columnCount++, record.getYearTable11312().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable11312().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable11312().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// YearTable1321 table -3

	private void writeHeaderyears9() {
		sheet8 = workbook.createSheet("YearTable1321");

		Row row = sheet8.createRow(0);

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

	private void writeyears9() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet8.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getYearTable1321().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable1321().get(0).getInput1321v(), style);
			createCell(row, columnCount++, record.getYearTable1321().get(0).getInput1321y(), style);
			createCell(row, columnCount++, record.getYearTable1321().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable1321().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable1321().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// YearTable1331 table -4

	private void writeHeaderyears10() {
		sheet9 = workbook.createSheet("YearTable1331");

		Row row = sheet9.createRow(0);

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

	}

	private void writeyears10() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet9.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getYearTable1331().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable1331().get(0).getInput1331v(), style);
			createCell(row, columnCount++, record.getYearTable1331().get(0).getInput1331y(), style);
			createCell(row, columnCount++, record.getYearTable1331().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable1331().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable1331().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// YearTable13312 table -5

	private void writeHeaderyears11() {
		sheet10 = workbook.createSheet("YearTable13312");

		Row row = sheet10.createRow(0);

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

	private void writeyears11() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet10.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getYearTable11312().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable11312().get(0).getInput11312v(), style);
			createCell(row, columnCount++, record.getYearTable11312().get(0).getInput11312y(), style);
			createCell(row, columnCount++, record.getYearTable11312().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable11312().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable11312().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}
	
	
	
	
	

	// criteria1_fileupload file upload-6

	private void writeHeaderyears12() {
		sheet11 = workbook.createSheet("criteria1_fileupload");

		Row row = sheet11.createRow(0);

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

	private void writeyears12() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet11.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria1FileUpload().get(0).getCriteria1FileName(), style);
			createCell(row, columnCount++, record.getCriteria1FileUpload().get(0).getCriteria1FilePath(), style);
			createCell(row, columnCount++, record.getCriteria1FileUpload().get(0).getCriteria1FileType(), style);
			createCell(row, columnCount++, record.getCriteria1FileUpload().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getCriteria1FileUpload().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getCriteria1FileUpload().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}
	
	
	//affiliatedyeartable 1221
	
	private void writeHeaderyears13() {
		sheet12 = workbook.createSheet("Affiliated_YearTable1221");

		Row row = sheet12.createRow(0);

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

	private void writeyears13() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria1_FieldInfo record : listRecords) {
			Row row = sheet12.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getAffiliatedYearTable1221().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable1221().get(0).getInput1221v(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable1221().get(0).getInput1221y(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable1221().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable1221().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable1221().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void generate(HttpServletResponse response,Map<String, String> allParams) throws IOException {
		
		
		if("autonomous".equalsIgnoreCase(allParams.get("typeofInstitution")))
		{
		writeHeader();
		writeHeader1();
		writeHeader2();
		writeHeader3();
		writeHeader4();
		writeHeader5();
		writeHeader6();

		writeHeaderyears7();
		writeHeaderyears8();
		writeHeaderyears9();
		writeHeaderyears10();
		writeHeaderyears11();
		writeHeaderyears12();

		write();
		write1();
		write2();
		write3();
		write4();
		write5();
		write6();

		writeyears7();
		writeyears8();
		writeyears9();
		writeyears10();
		writeyears11();
		writeyears12();
		}
		
		if("university".equalsIgnoreCase(allParams.get("typeofInstitution")))
		{
		writeHeader();
		writeHeader1();
		writeHeader2();
		writeHeader3();
		writeHeader4();
		writeHeader5();
		writeHeader6();

		writeHeaderyears7();
		writeHeaderyears8();
		writeHeaderyears9();
		writeHeaderyears10();
		writeHeaderyears11();
		writeHeaderyears12();

		write();
		write1();
		write2();
		write3();
		write4();
		write5();
		write6();

		writeyears7();
		writeyears8();
		writeyears9();
		writeyears10();
		writeyears11();
		writeyears12();
		}
		
		if("affiliated".equalsIgnoreCase(allParams.get("typeofInstitution")))
		{
		
			
			
			writeHeader();
			writeHeader1();
			writeHeader2();
			writeHeader3();
			writeHeader4();
			writeHeader5();
			writeHeader6();

			//writeHeaderyears7();
			//writeHeaderyears8();
			//writeHeaderyears9();
			//writeHeaderyears10();
			//writeHeaderyears11();
			writeHeaderyears12();
			writeHeaderyears13();

			write();
			write1();
			write2();
			write3();
			write4();
			write5();
			write6();

			//writeyears7();
			//writeyears8();
			//writeyears9();
			//writeyears10();
			//writeyears11();
			writeyears12();
			writeyears13();
			
			}
	
		
		
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
