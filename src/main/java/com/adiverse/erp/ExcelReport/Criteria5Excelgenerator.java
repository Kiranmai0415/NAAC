package com.adiverse.erp.ExcelReport;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria5_FieldInfo;

public class Criteria5Excelgenerator {

	private List<Criteria5_FieldInfo> listRecords;
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
	private XSSFSheet sheet18;
	private XSSFSheet sheet19;
	private XSSFSheet sheet20;
	private XSSFSheet sheet21;
	private XSSFSheet sheet22;
	private XSSFSheet sheet23;
	private XSSFSheet sheet24;

	

	private String[] excelHeaders = new String[] { "collegeId", "financialYear", "typeofInstitution" };

	// criteria51qn

	private String[] excelHeaders1 = new String[] { "unique_key1", "responseValue511", "input511t1", "responseValue512",
			"input512t1", "responseValue513", "input513t1", "input514t1", "responseValue514", "responseValue515",
			"input515t1", "collegeId", "financialYear", "typeofInstitution" };

	// criteria52qn
	private String[] excelHeaders2 = new String[] { "unique_key1", "responseValue521", "responseValue522", "input522t1",
			"input522t2", "input5212t1", "responseValue523", "collegeId", "financialYear", "typeofInstitution" };

	// criteria53qn

	private String[] excelHeaders3 = new String[] { "unique_key1", "responseValue531", "input531t1", "responseValue532",
			"input532t1", "responseValue533", "input533t1", "collegeId", "financialYear", "typeofInstitution" };

	// criteria54ql
	private String[] excelHeaders4 = new String[] { "unique_key1", "responseValue541", "input541t1", "responseValue542",
			"input542t1", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders5 = new String[] { "unique_key1", "criteria5_file_name", "criteria5_file_path",
			"criteria5_file_type", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders6 = new String[] { "unique_key1", "year", "government_year", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders7 = new String[] { "unique_key1", "year", "government_year_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders8 = new String[] { "unique_key1", "year", "non_government_agencies", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders9 = new String[] { "unique_key1", "year", "non_government_agencies_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders10 = new String[] { "unique_key1", "year", "competitive", "collegeId", "financialYear",
			"typeofInstitution" };
	private String[] excelHeaders11 = new String[] { "unique_key1", "year", "competitive_examinations", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders12 = new String[] { "unique_key1", "year", "competitive_examinations_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders13 = new String[] { "unique_key1", "year", "outgoing_students", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders14 = new String[] { "unique_key1", "year", "outgoing_students_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders15 = new String[] { "unique_key1", "year", "students_qualifying", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders16 = new String[] { "unique_key1", "year", "students_appearing", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders17 = new String[] { "unique_key1", "year", "inter_university", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders18 = new String[] { "unique_key1", "year", "cultural_events", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders19 = new String[] { "unique_key1", "year", "students_placed", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders20 = new String[] { "unique_key1", "year", "students_placed2", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders21 = new String[] { "unique_key1", "year", "sports", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders22 = new String[] { "unique_key1", "year", "outgoingstudents", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders23 = new String[] { "unique_key1", "year", "examinations", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders24 = new String[] { "unique_key1", "year", "studentsappearing", "collegeId",
			"financialYear", "typeofInstitution" };

	public Criteria5Excelgenerator(List<Criteria5_FieldInfo> listRecords) {
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

//	Criteria5  criteriaId

	private void writeHeader() {
		sheet = workbook.createSheet("criteria5_FieldInfo");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// criteria51Qn
	private void writeHeader1() {
		sheet1 = workbook.createSheet("Criteria51Qn");

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
		createCell(row, 7, excelHeaders1[7], style);
		createCell(row, 8, excelHeaders1[8], style);
		createCell(row, 9, excelHeaders1[9], style);
		createCell(row, 10, excelHeaders1[10], style);
		createCell(row, 11, excelHeaders1[11], style);
		createCell(row, 12, excelHeaders1[12], style);
		createCell(row, 13, excelHeaders1[13], style);

	}

	private void write1() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getResponse511(), style);
			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getInput511t1(), style);
			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getResponse512(), style);
			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getInput512t1(), style);
			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getResponse513(), style);

			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getInput513t1(), style);
			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getInput514t1(), style);
			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getResponse514(), style);

			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getResponse515(), style);
			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getInput515t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria52Qn
	private void writeHeader2() {
		sheet2 = workbook.createSheet("Criteria52Qn");

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
		createCell(row, 8, excelHeaders2[8], style);

	}

	private void write2() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet2.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria52Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria52Qn().get(0).getResponse521(), style);
			createCell(row, columnCount++, record.getCriteria52Qn().get(0).getResponse522(), style);
			createCell(row, columnCount++, record.getCriteria52Qn().get(0).getInput522t1(), style);
			createCell(row, columnCount++, record.getCriteria52Qn().get(0).getInput522t2(), style);
			createCell(row, columnCount++, record.getCriteria52Qn().get(0).getResponse523(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria53Qn
	private void writeHeader3() {
		sheet3 = workbook.createSheet("Criteria53Qn");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet3.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getResponse531(), style);
			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getInput531t1(), style);
			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getResponse532(), style);
			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getInput532t1(), style);
			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getResponse533(), style);
			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getInput533t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria54Ql
	private void writeHeader4() {
		sheet4 = workbook.createSheet("Criteria54Ql");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet4.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria54Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria54Ql().get(0).getResponse541(), style);
			createCell(row, columnCount++, record.getCriteria54Ql().get(0).getInput541t1(), style);
			createCell(row, columnCount++, record.getCriteria54Ql().get(0).getResponse542(), style);
			createCell(row, columnCount++, record.getCriteria54Ql().get(0).getInput542t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

////	Criteria4 Criteria5_FieldInfoQl
//
//	private void writeHeader1() {
//		sheet1 = workbook.createSheet("criteria5_FieldInfoQl");
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
//		for (Criteria5_FieldInfo record : listRecords) {
//			Row row = sheet1.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getUniqueKey1(), style);
//			//createCell(row, columnCount++, record.getCriteria53Qn().get(0).getInput5321t1(), style);
//			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getInput532t1(), style);
//			createCell(row, columnCount++, record.getCriteria54Ql().get(0).getInput541t1(), style);
//			createCell(row, columnCount++, record.getCriteria54Ql().get(0).getInput542t1(), style);
//
//			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getResponse532(), style);
//			createCell(row, columnCount++, record.getCriteria54Ql().get(0).getResponse541(), style);
//
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getCriteriaId().getCollegeId(),
//					style);
//
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getCriteria51Qn().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}
//
////	Criteria5 Criteria5_FieldInfoQn
//
//	private void writeHeader2() {
//		sheet2 = workbook.createSheet("criteria5_FieldInfoQn");
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
//		createCell(row, 18, excelHeaders2[18], style);
//		createCell(row, 19, excelHeaders2[19], style);
//
//		createCell(row, 20, excelHeaders2[20], style);
//		createCell(row, 21, excelHeaders2[21], style);
//		createCell(row, 22, excelHeaders2[22], style);
//		createCell(row, 23, excelHeaders2[20], style);
//		createCell(row, 24, excelHeaders2[21], style);
//
//		createCell(row, 2, excelHeaders2[20], style);
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
//		for (Criteria5_FieldInfo record : listRecords) {
//			Row row = sheet2.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getInput511t1(), style);
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getInput512t1(), style);
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getInput513t1(), style);
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getInput514t1(), style);
//
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getInput515t1(), style);
//			//createCell(row, columnCount++, record.getCriteria52Ql().get(0).getInput5212t1(), style);
//			createCell(row, columnCount++, record.getCriteria52Qn().get(0).getInput522t1(), style);
//			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getInput531t1(), style);
//			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getInput532t1(), style);
//
//			createCell(row, columnCount++, record.getCriteria54Ql().get(0).getInput542t1(), style);
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getResponse511(), style);
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getResponse512(), style);
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getResponse513(), style);
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getResponse514(), style);
//
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getResponse515(), style);
//			createCell(row, columnCount++, record.getCriteria52Qn().get(0).getResponse521(), style);
//			createCell(row, columnCount++, record.getCriteria52Qn().get(0).getResponse522(), style);
//			createCell(row, columnCount++, record.getCriteria52Qn().get(0).getResponse523(), style);
//			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getResponse531(), style);
//
//			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getResponse532(), style);
//			createCell(row, columnCount++, record.getCriteria53Qn().get(0).getResponse533(), style);
//			createCell(row, columnCount++, record.getCriteria54Ql().get(0).getResponse542(), style);
//
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getCriteriaId().getCollegeId(),
//					style);
//			createCell(row, columnCount++, record.getCriteria51Qn().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getCriteria51Qn().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}

//	Criteria5_FileUpload

	private void writeHeader5() {
		sheet5 = workbook.createSheet("criteria5_FileUpload");

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

	}

	private void write5() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet5.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteria5FileUpload().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria5FileUpload().get(0).getCriteria5FileName(), style);
			createCell(row, columnCount++, record.getCriteria5FileUpload().get(0).getCriteria5FilePath(), style);
			createCell(row, columnCount++, record.getCriteria5FileUpload().get(0).getCriteria5FileType(), style);

			createCell(row, columnCount++, record.getCriteria5FileUpload().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getCriteria5FileUpload().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getCriteria5FileUpload().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//	Criteria5  YearTable5111 -1

	private void writeHeader6() {
		sheet6 = workbook.createSheet("yearTable5111");

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

	}

	private void write6() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet6.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable5111().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable5111().get(0).getInput5111v(), style);
			createCell(row, columnCount++, record.getYearTable5111().get(0).getInput5111y(), style);

			createCell(row, columnCount++, record.getYearTable5111().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable5111().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable5111().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria5  YearTable51112 -2

	private void writeHeader7() {
		sheet7 = workbook.createSheet("yearTable51112");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet7.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable51112().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable51112().get(0).getInput51112v(), style);
			createCell(row, columnCount++, record.getYearTable51112().get(0).getInput51112y(), style);

			createCell(row, columnCount++, record.getYearTable51112().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable51112().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable51112().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// Criteria5 YearTable51211-3

	private void writeHeader8() {
		sheet8 = workbook.createSheet("yearTable51211");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet8.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable5121().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable5121().get(0).getInput5121v(), style);
			createCell(row, columnCount++, record.getYearTable5121().get(0).getInput5121y(), style);

			createCell(row, columnCount++, record.getYearTable5121().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable5121().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable5121().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria5  YearTable51212 -4

	private void writeHeader9() {
		sheet9 = workbook.createSheet("yearTable51212");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet9.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable51212().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable51212().get(0).getInput51212v(), style);
			createCell(row, columnCount++, record.getYearTable51212().get(0).getInput51212y(), style);

			createCell(row, columnCount++, record.getYearTable51212().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable51212().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable51212().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria5  Affiliated_YearTable5131 -5

	private void writeHeader10() {
		sheet10 = workbook.createSheet("affiliated_yearTable5131");

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

	}

	private void write10() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet10.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedYearTable5131().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable5131().get(0).getInput5131v(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable5131().get(0).getInput5131y(), style);

			createCell(row, columnCount++, record.getAffiliatedYearTable5131().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable5131().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable5131().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//	Criteria5  YearTable5141 

	private void writeHeader11() {
		sheet11 = workbook.createSheet("yearTable5141");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet11.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable5141().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable5141().get(0).getInput5141v(), style);
			createCell(row, columnCount++, record.getYearTable5141().get(0).getInput5141y(), style);

			createCell(row, columnCount++, record.getYearTable5141().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable5141().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable5141().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}
	// yeartable51412

	private void writeHeader12() {
		sheet12 = workbook.createSheet("yeartable51412");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet12.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable51412().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable51412().get(0).getInput51412v(), style);
			createCell(row, columnCount++, record.getYearTable51412().get(0).getInput51412y(), style);

			createCell(row, columnCount++, record.getYearTable51412().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable51412().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable51412().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// yeartable5211 not write

	private void writeHeader13() {
		sheet13 = workbook.createSheet("yeartable5211");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet13.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable52112().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable52112().get(0).getInput52112v(), style);
			createCell(row, columnCount++, record.getYearTable52112().get(0).getInput52112y(), style);

			createCell(row, columnCount++, record.getYearTable52112().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable52112().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable52112().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// yeartable52112

	private void writeHeader14() {
		sheet14 = workbook.createSheet("yeartable52112");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet14.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable52112().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable52112().get(0).getInput52112v(), style);
			createCell(row, columnCount++, record.getYearTable52112().get(0).getInput52112y(), style);

			createCell(row, columnCount++, record.getYearTable52112().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable52112().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable52112().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// yeartable5231

	private void writeHeader15() {
		sheet15 = workbook.createSheet("yeartable5231");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet15.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable5231().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable5231().get(0).getInput5231v(), style);
			createCell(row, columnCount++, record.getYearTable5231().get(0).getInput5231y(), style);

			createCell(row, columnCount++, record.getYearTable5231().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable5231().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable5231().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

//yeartable5232

	private void writeHeader16() {
		sheet16 = workbook.createSheet("yeartable5232");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet16.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable5232().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable5232().get(0).getInput5232v(), style);
			createCell(row, columnCount++, record.getYearTable5232().get(0).getInput5232y(), style);

			createCell(row, columnCount++, record.getYearTable5232().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable5232().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable5232().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

//yeartable5311

	private void writeHeader17() {
		sheet17 = workbook.createSheet("yeartable5311");

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

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet17.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable5311().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable5311().get(0).getInput5311v(), style);
			createCell(row, columnCount++, record.getYearTable5311().get(0).getInput5311v(), style);

			createCell(row, columnCount++, record.getYearTable5311().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable5311().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable5311().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

//yeartable5331

	private void writeHeader18() {
		sheet18 = workbook.createSheet("yeartable5331");

		Row row = sheet18.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders18[0], style);
		createCell(row, 1, excelHeaders18[1], style);
		createCell(row, 2, excelHeaders18[2], style);
		createCell(row, 3, excelHeaders18[3], style);
		createCell(row, 4, excelHeaders18[4], style);
		createCell(row, 5, excelHeaders18[5], style);

	}

	private void write18() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet18.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable5331().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable5331().get(0).getInput5331v(), style);
			createCell(row, columnCount++, record.getYearTable5331().get(0).getInput5331y(), style);

			createCell(row, columnCount++, record.getYearTable5331().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable5331().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable5331().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

//universityyeartable5221

	private void writeHeader19() {
		sheet19 = workbook.createSheet("universityyeartable5221");

		Row row = sheet19.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders19[0], style);
		createCell(row, 1, excelHeaders19[1], style);
		createCell(row, 2, excelHeaders19[2], style);
		createCell(row, 3, excelHeaders19[3], style);
		createCell(row, 4, excelHeaders19[4], style);
		createCell(row, 5, excelHeaders19[5], style);

	}

	private void write19() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet19.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable5221().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable5221().get(0).getInput5221v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable5221().get(0).getInput5221y(), style);

			createCell(row, columnCount++, record.getUniversityYearTable5221().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getUniversityYearTable5221().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getUniversityYearTable5221().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

//universityyeartable52212

	private void writeHeader20() {
		sheet20 = workbook.createSheet("universityyeartable52212");

		Row row = sheet20.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders20[0], style);
		createCell(row, 1, excelHeaders20[1], style);
		createCell(row, 2, excelHeaders20[2], style);
		createCell(row, 3, excelHeaders20[3], style);
		createCell(row, 4, excelHeaders20[4], style);
		createCell(row, 5, excelHeaders20[5], style);

	}

	private void write20() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet20.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable52212().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable52212().get(0).getInput52212v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable52212().get(0).getInput52212y(), style);

			createCell(row, columnCount++, record.getUniversityYearTable52212().get(0).getCriteriaId().getCollegeId(),style);
			createCell(row, columnCount++,record.getUniversityYearTable52212().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,record.getUniversityYearTable52212().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

//affiliated_YearTable5321

	private void writeHeader21() {
		sheet21 = workbook.createSheet("affiliated_YearTable5321");

		Row row = sheet21.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders21[0], style);
		createCell(row, 1, excelHeaders21[1], style);
		createCell(row, 2, excelHeaders21[2], style);
		createCell(row, 3, excelHeaders21[3], style);
		createCell(row, 4, excelHeaders21[4], style);
		createCell(row, 5, excelHeaders21[5], style);

	}

	private void write21() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet21.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedYearTable5321().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable5321().get(0).getInput5321v(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable5321().get(0).getInput5321y(), style);

			createCell(row, columnCount++, record.getAffiliatedYearTable5321().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable5321().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable5321().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

//affiliated_YearTable5212

	private void writeHeader22() {
		sheet22 = workbook.createSheet("affiliated_YearTable5212");

		Row row = sheet22.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders22[0], style);
		createCell(row, 1, excelHeaders22[1], style);
		createCell(row, 2, excelHeaders22[2], style);
		createCell(row, 3, excelHeaders22[3], style);
		createCell(row, 4, excelHeaders22[4], style);
		createCell(row, 5, excelHeaders22[5], style);

	}

	private void write22() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet22.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedYearTable5212().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable5212().get(0).getInput5212v(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable5212().get(0).getInput5212y(), style);

			createCell(row, columnCount++, record.getAffiliatedYearTable5212().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable5212().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable5212().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

//affiliated_YearTable5221

	private void writeHeader23() {
		sheet23 = workbook.createSheet("affiliated_YearTable5221");

		Row row = sheet23.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders23[0], style);
		createCell(row, 1, excelHeaders23[1], style);
		createCell(row, 2, excelHeaders23[2], style);
		createCell(row, 3, excelHeaders23[3], style);
		createCell(row, 4, excelHeaders23[4], style);
		createCell(row, 5, excelHeaders23[5], style);

	}

	private void write23() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet23.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedYearTable5221().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable5221().get(0).getInput5221v(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable5221().get(0).getInput5221y(), style);

			createCell(row, columnCount++, record.getAffiliatedYearTable5221().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable5221().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable5221().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

//Affiliated_YearTable5222

	private void writeHeader24() {
		sheet24 = workbook.createSheet("Affiliated_YearTable5222");

		Row row = sheet24.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders24[0], style);
		createCell(row, 1, excelHeaders24[1], style);
		createCell(row, 2, excelHeaders24[2], style);
		createCell(row, 3, excelHeaders24[3], style);
		createCell(row, 4, excelHeaders24[4], style);
		createCell(row, 5, excelHeaders24[5], style);

	}

	private void write24() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria5_FieldInfo record : listRecords) {
			Row row = sheet24.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedYearTable5222().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable5222().get(0).getInput5222v(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable5222().get(0).getInput5222y(), style);

			createCell(row, columnCount++, record.getAffiliatedYearTable5222().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable5222().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable5222().get(0).getCriteriaId().getTypeofInstitution(), style);

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
//		writeHeader10();
		writeHeader11();
		writeHeader12();
		writeHeader13();
		writeHeader14();
		writeHeader15();
		writeHeader16();
		writeHeader17();
		writeHeader18();
//		writeHeader19();
//		writeHeader20();
//		writeHeader21();
//		writeHeader22();
//		writeHeader23();
//		writeHeader24();

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
//		write10();
		write11();
		write12();
		write13();
		write14();
		write15();
		write16();
		write17();
		write18();
//		write19();
//		write20();
//		write21();
//		write22();
//		write23();
//		write24();
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

			//writeHeader11();
			//writeHeader12();
			writeHeader13();
			writeHeader14();
			writeHeader15();
			//writeHeader16();
			writeHeader17();
			writeHeader18();
			
			writeHeader19(); //universities
		    writeHeader20();  //universities
			
		    
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

			//write11();
			//write12();
			write13();
			write14();
			write15();
			//write16();
			write17();
			write18();
			write19();  //universities
			write20();  //universities
			
		}
		
		
		if ("affiliated".equalsIgnoreCase(allParams.get("typeofInstitution"))) 
		
		{
			
			writeHeader();
			writeHeader1();
			writeHeader2();
			writeHeader3();
			writeHeader4();
			writeHeader5();
			writeHeader6();
			writeHeader7();
			//writeHeader8();
			//writeHeader9();

			//writeHeader11();
			//writeHeader12();
			writeHeader13();
			writeHeader14();
			writeHeader15();
			writeHeader16();
			writeHeader17();
			//writeHeader18();
			
			writeHeader10(); //affiliated
			writeHeader21();  //affiliated
			//writeHeader22();  //affiliated
			//writeHeader23();  //affiliated
		//	writeHeader24();  //affiliated
			
			
			write();
			write1();
			write2();
			write3();
			write4();
			write5();
			write6();
			write7();
			//write8();
			//write9();

			//write11();
			//write12();
			write13();
			write14();
			write15();
			write16();
			write17();
			//write18();
			write10();  //affiliated
			write21();  //affiliated
			//write22();  //affiliated
			//write23();  //affiliated
			//write24();  //affiliated
			
		}
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
