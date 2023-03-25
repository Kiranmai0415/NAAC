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

import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Criteria2ExcelGenerator {

	private List<Criteria2_FieldInfo> listRecords;
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

	private XSSFSheet sheet25;
	private XSSFSheet sheet26;
	private XSSFSheet sheet27;
	private XSSFSheet sheet28;
	private XSSFSheet sheet29;

	private String[] excelHeaders = new String[] { "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders1 = new String[] { "unique_key1", "responseValue211", "responseValue212", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders2 = new String[] { "unique_key1", "responseValue221", "input221t1", "input221t2",
			"responseValue222", "input222t1", "input2221t2", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders3 = new String[] { "unique_key1", "responseValue231", "input231t1", "responseValue232",
			"input232t1", "responseValue234", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders4 = new String[] { "unique_key1", "responseValue233", "input2331t1", "input2331t2",
			"collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders5 = new String[] { "unique_key1", "responseValue241", "responseValue242",
			"responseValue243", "input2431t1", "input2431t2", "responseValue244", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders6 = new String[] { "unique_key1", "responseValue253", "input253t1", "responseValue254",
			"input254t1", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders7 = new String[] { "unique_key1", "responseValue251", "input251t1", "responseValue252",
			"collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders8 = new String[] { "unique_key1", "responseValue261", "input261t1", "responseValue262",
			"input262t1", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders9 = new String[] { "unique_key1", "responseValue263", "input2631t1", "input2632t1",
			"responseValue262", "input2621t1", "input2622t2", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders10 = new String[] { "unique_key1", "responseValue271", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders11 = new String[] { "unique_key1", "criteria2_file_name", "criteria2_file_path",
			"criteria2_file_type", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders12 = new String[] { "unique_key1", "year", "students_admitted", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders13 = new String[] { "unique_key1", "year", "sanctioned_seats", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders14 = new String[] { "unique_key1", "year", "reserved_categories", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders15 = new String[] { "unique_key1", "year", "govtrules", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders16 = new String[] { "unique_key1", "year", "reserved_categories_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders17 = new String[] { "unique_key1", "year", "sanctioned_posts", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders18 = new String[] { "unique_key1", "year", "sanctioned_posts", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders19 = new String[] { "unique_key1", "year", "sanctioned_posts_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders20 = new String[] { "unique_key1", "year", "fulltime_teachers", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders21 = new String[] { "unique_key1", "year", "fulltime_teachers_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders22 = new String[] { "unique_key1", "year", "semester_year", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders23 = new String[] { "unique_key1", "year", "complaints_grievances", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders24 = new String[] { "unique_key1", "year", "complaints_grievances_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders25 = new String[] { "unique_key1", "year", "Recognized_bodies", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders26 = new String[] { "unique_key1", "year", "assessment", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders27 = new String[] { "unique_key1", "year", "teachers", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders28 = new String[] { "unique_key1", "year", "students", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders29 = new String[] { "unique_key1", "year", "finalyear", "collegeId", "financialYear",
			"typeofInstitution" };

	public Criteria2ExcelGenerator(List<Criteria2_FieldInfo> listRecords) {
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

//	Criteria2  criteriaId

	private void writeHeader() {
		sheet = workbook.createSheet("Criteria2_FieldInfo");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// criteria21Qn
	private void writeHeader1() {
		sheet1 = workbook.createSheet("Criteria21Qn");

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

	}

	private void write1() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria21Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria21Qn().get(0).getResponse211(), style);
			createCell(row, columnCount++, record.getCriteria21Qn().get(0).getResponse212(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria22Qn
	private void writeHeader2() {
		sheet2 = workbook.createSheet("Criteria22Qn");

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
		createCell(row, 9, excelHeaders2[9], style);

	}

	private void write2() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet2.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria22Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria22Qn().get(0).getResponse221(), style);
			createCell(row, columnCount++, record.getCriteria22Qn().get(0).getInput221t1(), style);
			createCell(row, columnCount++, record.getCriteria22Qn().get(0).getInput221t2(), style);
			createCell(row, columnCount++, record.getCriteria22Qn().get(0).getResponse222(), style);
			createCell(row, columnCount++, record.getCriteria22Qn().get(0).getInput222t1(), style);
			createCell(row, columnCount++, record.getCriteria22Qn().get(0).getInput2221t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria23Ql
	private void writeHeader3() {
		sheet3 = workbook.createSheet("Criteria23Ql");

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

	}

	private void write3() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet3.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria23Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria23Ql().get(0).getResponse231(), style);
			createCell(row, columnCount++, record.getCriteria23Ql().get(0).getInput231t1(), style);
			createCell(row, columnCount++, record.getCriteria23Ql().get(0).getResponse232(), style);
			createCell(row, columnCount++, record.getCriteria23Ql().get(0).getInput232t1(), style);
			createCell(row, columnCount++, record.getCriteria23Ql().get(0).getResponse234(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria23Qn
	private void writeHeader4() {
		sheet4 = workbook.createSheet("Criteria23Qn");

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

	}

	private void write4() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet4.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria23Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria23Qn().get(0).getResponse233(), style);
			createCell(row, columnCount++, record.getCriteria23Qn().get(0).getInput2331t1(), style);
			createCell(row, columnCount++, record.getCriteria23Qn().get(0).getInput2331t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria24Qn
	private void writeHeader5() {
		sheet5 = workbook.createSheet("Criteria24Qn");

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
		createCell(row, 8, excelHeaders5[8], style);
		createCell(row, 9, excelHeaders5[9], style);

	}

	private void write5() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet5.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria24Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria24Qn().get(0).getResponse241(), style);
			createCell(row, columnCount++, record.getCriteria24Qn().get(0).getResponse242(), style);
			createCell(row, columnCount++, record.getCriteria24Qn().get(0).getResponse243(), style);
			createCell(row, columnCount++, record.getCriteria24Qn().get(0).getInput2431t1(), style);
			createCell(row, columnCount++, record.getCriteria24Qn().get(0).getInput2431t2(), style);
			createCell(row, columnCount++, record.getCriteria24Qn().get(0).getResponse244(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria25Ql
	private void writeHeader6() {
		sheet6 = workbook.createSheet("Criteria25Ql");

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

	}

	private void write6() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet6.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria25Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria25Ql().get(0).getResponse253(), style);
			createCell(row, columnCount++, record.getCriteria25Ql().get(0).getInput253t1(), style);
			createCell(row, columnCount++, record.getCriteria25Ql().get(0).getResponse254(), style);
			createCell(row, columnCount++, record.getCriteria25Ql().get(0).getInput254t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria25Qn
	private void writeHeader7() {
		sheet7 = workbook.createSheet("Criteria25Qn");

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
		createCell(row, 6, excelHeaders7[6], style);

	}

	private void write7() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet7.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria25Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria25Qn().get(0).getResponse251(), style);
			createCell(row, columnCount++, record.getCriteria25Qn().get(0).getInput251t1(), style);
			createCell(row, columnCount++, record.getCriteria25Qn().get(0).getResponse252(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria26Ql
	private void writeHeader8() {
		sheet8 = workbook.createSheet("Criteria26Ql");

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
		createCell(row, 6, excelHeaders8[6], style);
		createCell(row, 7, excelHeaders8[7], style);

	}

	private void write8() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet8.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria26Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria26Ql().get(0).getResponse261(), style);
			createCell(row, columnCount++, record.getCriteria26Ql().get(0).getInput261t1(), style);
			createCell(row, columnCount++, record.getCriteria26Ql().get(0).getResponse262(), style);
			createCell(row, columnCount++, record.getCriteria26Ql().get(0).getInput262t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria26Qn
	private void writeHeader9() {
		sheet9 = workbook.createSheet("Criteria26Qn");

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
		createCell(row, 6, excelHeaders9[6], style);
		createCell(row, 7, excelHeaders9[7], style);
		createCell(row, 8, excelHeaders9[8], style);
		createCell(row, 9, excelHeaders9[9], style);

	}

	private void write9() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet9.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria26Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria26Qn().get(0).getResponse263(), style);
			createCell(row, columnCount++, record.getCriteria26Qn().get(0).getInput2631t1(), style);
			createCell(row, columnCount++, record.getCriteria26Qn().get(0).getInput2632t1(), style);
			createCell(row, columnCount++, record.getCriteria26Qn().get(0).getResponse262(), style);
			createCell(row, columnCount++, record.getCriteria26Qn().get(0).getInput2621t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria27Ql
	private void writeHeader10() {
		sheet10 = workbook.createSheet("Criteria27Ql");

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

	}

	private void write10() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet10.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria27Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria27Ql().get(0).getResponse271(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	private void writeHeader11() {
		sheet11 = workbook.createSheet("Criteria2_FileUpload");

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
		createCell(row, 6, excelHeaders11[6], style);

	}

	private void write11() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet11.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteria2FileUpload().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria2FileUpload().get(0).getCriteria2FileName(), style);
			createCell(row, columnCount++, record.getCriteria2FileUpload().get(0).getCriteria2FilePath(), style);
			createCell(row, columnCount++, record.getCriteria2FileUpload().get(0).getCriteria2FileType(), style);

			createCell(row, columnCount++, record.getCriteria2FileUpload().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getCriteria2FileUpload().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getCriteria2FileUpload().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//	Criteria2  YearTable2111 -1

	private void writeHeader12() {
		sheet12 = workbook.createSheet("YearTable2111");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet12.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable2111().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable2111().get(0).getInput2111y(), style);
			createCell(row, columnCount++, record.getYearTable2111().get(0).getInput2111v(), style);

			createCell(row, columnCount++, record.getYearTable2111().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable2111().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable2111().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable2112 -2

	private void writeHeader13() {
		sheet13 = workbook.createSheet("YearTable2112");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet13.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable2112().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable2112().get(0).getInput2112y(), style);
			createCell(row, columnCount++, record.getYearTable2112().get(0).getInput2112v(), style);

			createCell(row, columnCount++, record.getYearTable2111().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable2111().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable2111().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// Criteria2 YearTable2121 -3

	private void writeHeader14() {
		sheet14 = workbook.createSheet("YearTable2121");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet14.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable2121().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable2121().get(0).getInput2121y(), style);
			createCell(row, columnCount++, record.getYearTable2121().get(0).getInput2121v(), style);

			createCell(row, columnCount++, record.getYearTable2121().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable2121().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable2121().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  Affiliated_YearTable2122 -4

	private void writeHeader15() {
		sheet15 = workbook.createSheet("affiliated_YearTable2122");

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
		System.out.println(listRecords.size());
		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet15.createRow(rowCount++);
			ObjectMapper mapper = new ObjectMapper();
			try {
				System.out.println("list==>" + mapper.writeValueAsString(record));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliated_YearTable2122().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable2122().get(0).getInput2122y(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable2122().get(0).getInput2122v(), style);

			createCell(row, columnCount++, record.getAffiliated_YearTable2122().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable2122().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable2122().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//	Criteria2  YearTable21212 -5

	private void writeHeader16() {
		sheet16 = workbook.createSheet("yeartable21212");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet16.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable21212().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable21212().get(0).getInput21212y(), style);
			createCell(row, columnCount++, record.getYearTable21212().get(0).getInput21212v(), style);

			createCell(row, columnCount++, record.getYearTable21212().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable21212().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable21212().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable2411 -6

	private void writeHeader17() {
		sheet17 = workbook.createSheet("yeartable2411");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet17.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable2411().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable2411().get(0).getInput2411y(), style);
			createCell(row, columnCount++, record.getYearTable2411().get(0).getInput2411v(), style);

			createCell(row, columnCount++, record.getYearTable2411().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable2411().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable2411().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// Criteria2 YearTable24112

	private void writeHeader18() {
		sheet18 = workbook.createSheet("yeartable24112");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet18.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable24112().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable24112().get(0).getInput24112y(), style);
			createCell(row, columnCount++, record.getYearTable24112().get(0).getInput24112v(), style);

			createCell(row, columnCount++, record.getYearTable24112().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable24112().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable24112().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable2412

	private void writeHeader19() {
		sheet19 = workbook.createSheet("yeartable2412");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet19.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable2412().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable2412().get(0).getInput2412y(), style);
			createCell(row, columnCount++, record.getYearTable2412().get(0).getInput2412v(), style);

			createCell(row, columnCount++, record.getYearTable2412().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable2412().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable2412().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}
//	Criteria2  YearTable2421

	private void writeHeader20() {
		sheet20 = workbook.createSheet("yeartable2421");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet20.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable2421().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable2421().get(0).getInput2421y(), style);
			createCell(row, columnCount++, record.getYearTable2421().get(0).getInput2421v(), style);

			createCell(row, columnCount++, record.getYearTable2421().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable2421().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable2421().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable24212

	private void writeHeader21() {
		sheet21 = workbook.createSheet("yeartable24212");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet21.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable24212().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable24212().get(0).getInput24212y(), style);
			createCell(row, columnCount++, record.getYearTable24212().get(0).getInput24212v(), style);

			createCell(row, columnCount++, record.getYearTable24212().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable24212().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable24212().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable2511

	private void writeHeader22() {
		sheet22 = workbook.createSheet("yeartable2511");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet22.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable2511().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable2511().get(0).getInput2511y(), style);
			createCell(row, columnCount++, record.getYearTable2511().get(0).getInput2511v(), style);

			createCell(row, columnCount++, record.getYearTable2511().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable2511().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable2511().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable2521

	private void writeHeader23() {
		sheet23 = workbook.createSheet("yeartable2521");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet23.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable2521().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable2521().get(0).getInput2521y(), style);
			createCell(row, columnCount++, record.getYearTable2521().get(0).getInput2521v(), style);

			createCell(row, columnCount++, record.getYearTable2521().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable2521().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable2521().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable25212

	private void writeHeader24() {
		sheet24 = workbook.createSheet("yeartable25212");

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

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet24.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable25212().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable25212().get(0).getInput25212y(), style);
			createCell(row, columnCount++, record.getYearTable25212().get(0).getInput25212v(), style);

			createCell(row, columnCount++, record.getYearTable25212().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable25212().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable25212().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// UniversityYearTable2441
	private void writeHeader25() {
		sheet25 = workbook.createSheet("universityyeartable2441");

		Row row = sheet25.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders25[0], style);
		createCell(row, 1, excelHeaders25[1], style);
		createCell(row, 2, excelHeaders25[2], style);
		createCell(row, 3, excelHeaders25[3], style);
		createCell(row, 4, excelHeaders25[4], style);
		createCell(row, 5, excelHeaders25[5], style);

	}

	private void write25() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet25.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable2441().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable2441().get(0).getInput2441y(), style);
			createCell(row, columnCount++, record.getUniversityYearTable2441().get(0).getInput2441v(), style);

			createCell(row, columnCount++, record.getUniversityYearTable2441().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getUniversityYearTable2441().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getUniversityYearTable2441().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  Affiliated_YearTable251
	private void writeHeader26() {
		sheet26 = workbook.createSheet("affiliated_yeartable251");

		Row row = sheet26.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders26[0], style);
		createCell(row, 1, excelHeaders26[1], style);
		createCell(row, 2, excelHeaders26[2], style);
		createCell(row, 3, excelHeaders26[3], style);
		createCell(row, 4, excelHeaders26[4], style);
		createCell(row, 5, excelHeaders26[5], style);

	}

	private void write26() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet26.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliated_YearTable251().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable251().get(0).getInput251y(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable251().get(0).getInput251v(), style);

			createCell(row, columnCount++, record.getAffiliated_YearTable251().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable251().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable251().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  Affiliated_YearTable221
	private void writeHeader27() {
		sheet27 = workbook.createSheet("affiliated_yeartable221");

		Row row = sheet27.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders27[0], style);
		createCell(row, 1, excelHeaders27[1], style);
		createCell(row, 2, excelHeaders27[2], style);
		createCell(row, 3, excelHeaders27[3], style);
		createCell(row, 4, excelHeaders27[4], style);
		createCell(row, 5, excelHeaders27[5], style);

	}

	private void write27() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet27.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliated_YearTable221().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable221().get(0).getInput221y(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable221().get(0).getInput221v(), style);

			createCell(row, columnCount++, record.getAffiliated_YearTable221().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable221().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable221().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  Affiliated_YearTable2621
	private void writeHeader28() {
		sheet28 = workbook.createSheet("affiliated_yeartable2621");

		Row row = sheet28.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders28[0], style);
		createCell(row, 1, excelHeaders28[1], style);
		createCell(row, 2, excelHeaders28[2], style);
		createCell(row, 3, excelHeaders28[3], style);
		createCell(row, 4, excelHeaders28[4], style);
		createCell(row, 5, excelHeaders28[5], style);

	}

	private void write28() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet28.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliated_YearTable2621().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable2621().get(0).getInput2621y(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable2621().get(0).getInput2621v(), style);

			createCell(row, columnCount++, record.getAffiliated_YearTable2621().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable2621().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable2621().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  Affiliated_YearTable2622
	private void writeHeader29() {
		sheet29 = workbook.createSheet("affiliated_yeartable2622");

		Row row = sheet29.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders29[0], style);
		createCell(row, 1, excelHeaders29[1], style);
		createCell(row, 2, excelHeaders29[2], style);
		createCell(row, 3, excelHeaders29[3], style);
		createCell(row, 4, excelHeaders29[4], style);
		createCell(row, 5, excelHeaders29[5], style);

	}

	private void write29() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria2_FieldInfo record : listRecords) {
			Row row = sheet29.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliated_YearTable2622().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable2622().get(0).getInput2622y(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable2622().get(0).getInput2622v(), style);

			createCell(row, columnCount++, record.getAffiliated_YearTable2622().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable2622().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable2622().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	public void generate(HttpServletResponse response, Map<String, String> allParams) throws IOException {

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
			writeHeader14();
            writeHeader16();
			writeHeader17();
			writeHeader18();
			writeHeader19();
			writeHeader20();
			writeHeader21();
			writeHeader22();
			writeHeader23();
			writeHeader24();
			

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
			write14();
            write16();
			write17();
			write18();
			write19();
			write20();
			write21();
			write22();
			write23();
			write24();
		
	
		}
		if ("university".equalsIgnoreCase(allParams.get("typeofInstitution"))) {

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
			writeHeader14();
            writeHeader16();
			writeHeader17();
			//writeHeader18();
			writeHeader19();
			writeHeader20();
			writeHeader21();
			writeHeader22();
			writeHeader23();
			writeHeader24();
			writeHeader25(); //university

			
			
			
			
			
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
			write14();
			write16();
			write17();
			//write18();
			write19();
			write20();
			write21();
			write22();
			write23();
			write24();
			write25();

		}
		if ("affiliated".equalsIgnoreCase(allParams.get("typeofInstitution"))) {

			writeHeader();
			writeHeader1();
			writeHeader2();
			writeHeader3();
			//writeHeader4();
			writeHeader5();
		//	writeHeader6();
			writeHeader7();
			writeHeader8();
			writeHeader9();
			writeHeader10();
			writeHeader11();
			writeHeader12();
			writeHeader13();
			writeHeader14();
		//	writeHeader15(); //affiliated
			writeHeader16();
			writeHeader17();
			writeHeader18();
			//writeHeader19();
			writeHeader20();
			writeHeader21();
			//writeHeader22();
			//writeHeader23();
			//writeHeader24();
		

			
			//writeHeader26(); //affiliated
			//writeHeader27();  //affiliated
			//writeHeader28(); //affiliated
			//writeHeader29(); //affiliated

			write();
			write1();
			write2();
			write3();
			//write4();
			write5();
			//write6();
			write7();
			write8();
			write9();
			write10();
			write11();
			write12();
			write13();
			write14();
			//write15();
			write16();
			write17();
			write18();
			//write19();
			write20();
			write21();
			//write22();
			//write23();
			//write24();
			//write26();
			//write27();
			///write28();
			//write29();

		}

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
