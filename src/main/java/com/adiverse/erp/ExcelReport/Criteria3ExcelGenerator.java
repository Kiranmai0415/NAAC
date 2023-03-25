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
import com.adiverse.erp.model.Criteria3_FieldInfo;

public class Criteria3ExcelGenerator {

	private List<Criteria3_FieldInfo> listRecords;
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
	private XSSFSheet sheet30;
	private XSSFSheet sheet31;
	private XSSFSheet sheet32;
	private XSSFSheet sheet33;
	private XSSFSheet sheet34;
	private XSSFSheet sheet35;
	private XSSFSheet sheet36;
	private XSSFSheet sheet37;
	private XSSFSheet sheet38;
	private XSSFSheet sheet39;
	private XSSFSheet sheet40;
	private XSSFSheet sheet41;
	private XSSFSheet sheet42;
	private XSSFSheet sheet43;
	private XSSFSheet sheet44;
	private XSSFSheet sheet45;
	
	

	private String[] excelHeaders = new String[] { "collegeId", "financialYear", "typeofInstitution" };

	// 31ql
	private String[] excelHeaders1 = new String[] { "unique_key1", "responseValue311", "input311t1", "input3131t1",
			"collegeId", "financialYear", "typeofInstitution" };

// 31qn
	private String[] excelHeaders2 = new String[] { "unique_key1", "responseValue312", "responseValue313", "input313t1",
			"responseValue314", "responseValue315", "input315t1", "responseValue316", "input3161t1", "input3162t1",
			"collegeId", "financialYear", "typeofInstitution" };

	// 32ql
	private String[] excelHeaders3 = new String[] { "unique_key1", "responseValue321", "input321t1", "collegeId",
			"financialYear", "typeofInstitution" };

	// 32qn
	private String[] excelHeaders4 = new String[] { "unique_key1", "responseValue322", "input3221t11", "input3221t11",
			"responseValue323", "input3231t1", "input3231t2", "input3232t1", "responseValue324", "collegeId",
			"financialYear", "typeofInstitution" };

	// 33ql
	private String[] excelHeaders5 = new String[] { "unique_key1", "input331t1", "responseValue331", "collegeId",
			"financialYear", "typeofInstitution" };

	// 33qn
	private String[] excelHeaders6 = new String[] { "unique_key1", "responseValue332", "responseValue333", "collegeId",
			"financialYear", "typeofInstitution" };

	// 34ql

	private String[] excelHeaders7 = new String[] { "unique_key1", "responseValue341", "input341t1", "responseValue349",
			"input3491t1", "input3491t2", "collegeId", "financialYear", "typeofInstitution" };

	// 34qn
	private String[] excelHeaders8 = new String[] { "unique_key1", "responseValue342", "input342t1", "input3422t1",
			"responseValue343", "input343t1", "responseValue344", "responseValue345", "input3451t1", "input3451t2",
			"input3452t1", "responseValue346", "input3461t1", "input3461t2", "responseValue347", "responseValue348",
			"input3481t1", "input348t2", "input3482t1", "input3482t2", "input3441t1", "input3441t2", "collegeId",
			"financialYear", "typeofInstitution" };

	// 35ql
	private String[] excelHeaders9 = new String[] { "unique_key1", "responseValue352", "collegeId", "financialYear",
			"typeofInstitution" };

	// 35qn

	private String[] excelHeaders10 = new String[] { "unique_key1", "responseValue351", "collegeId", "financialYear",
			"typeofInstitution" };

	// 36ql
	private String[] excelHeaders11 = new String[] { "unique_key1", "responseValue361", "input361t1", "input361t2",
			"collegeId", "financialYear", "typeofInstitution" };

	// 36qn
	private String[] excelHeaders12 = new String[] { "unique_key1", "responseValue362", "responseValue363",
			"responseValue364", "collegeId", "financialYear", "typeofInstitution" };

	// 37 qn

	private String[] excelHeaders13 = new String[] { "unique_key1", "responseValue371", "responseValue372", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders14 = new String[] { "unique_key1", "criteria3_file_name", "criteria3_file_path",
			"criteria3_file_type", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders15 = new String[] { "unique_key1", "year", "seed_money", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders16 = new String[] { "unique_key1", "year", "teacher_awarded", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders17 = new String[] { "unique_key1", "year", "grant12", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders18 = new String[] { "unique_key1", "year", "research_projects", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders19 = new String[] { "unique_key1", "year", "research_gov_projects", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders20 = new String[] { "unique_key1", "year", "research_gov_projects", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders21 = new String[] { "unique_key1", "year", "workshop", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders22 = new String[] { "unique_key1", "year", "research_papers", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders23 = new String[] { "unique_key1", "year", "books", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders24 = new String[] { "unique_key1", "year", "amount_generated", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders25 = new String[] { "unique_key1", "year", "amount_spent", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders26 = new String[] { "unique_key1", "year", "awards_recognition", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders27 = new String[] { "unique_key1", "year", "extension_outreach", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders28 = new String[] { "unique_key1", "year", "extension_activities", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders29 = new String[] { "unique_key1", "year", "extension_activities", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders30 = new String[] { "unique_key1", "year", "collaborative_activities", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders31 = new String[] { "unique_key1", "year", "mous", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders32 = new String[] { "unique_key1", "year", "JRF_SRF", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders33 = new String[] { "unique_key1", "year", "research_projects", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders34 = new String[] { "unique_key1", "year", "fulltime_teachers", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders35 = new String[] { "unique_key1", "year", "awards_recognitions", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders36 = new String[] { "unique_key1", "year", "published_awarded", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders37 = new String[] { "unique_key1", "year", "guides_during", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders38 = new String[] { "unique_key1", "year", "papers_published", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders39 = new String[] { "unique_key1", "year", "ugc_website", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders40 = new String[] { "unique_key1", "year", "books_chapters", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders41 = new String[] { "unique_key1", "year", "volumes_books", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders42 = new String[] { "unique_key1", "year", "awards", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders43 = new String[] { "unique_key1", "year", "collaborations", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders44 = new String[] { "unique_key1", "year", "researchprojects", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders45 = new String[] { "unique_key1", "year", "journals", "collegeId", "financialYear",
			"typeofInstitution" };

	public Criteria3ExcelGenerator(List<Criteria3_FieldInfo> listRecords) {
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

//	Criteria3  criteriaId

	private void writeHeader() {
		sheet = workbook.createSheet("Criteria3_FieldInfo");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// criteria31Ql
	private void writeHeader1() {
		sheet1 = workbook.createSheet("Criteria31Ql");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getResponse311(), style);
			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getInput311t1(), style);
			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getInput3131t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria31Qn
	private void writeHeader2() {
		sheet2 = workbook.createSheet("Criteria31Qn");

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
		createCell(row, 10, excelHeaders2[10], style);
		createCell(row, 11, excelHeaders2[11], style);
		createCell(row, 12, excelHeaders2[12], style);

	}

	private void write2() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet2.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getResponse312(), style);
			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getResponse313(), style);
			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getInput313t1(), style);
			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getResponse314(), style);
			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getResponse315(), style);
			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getInput315t1(), style);
			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getResponse316(), style);
			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getInput3161t1(), style);
			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getInput3162t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria32Ql
	private void writeHeader3() {
		sheet3 = workbook.createSheet("Criteria32Ql");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet3.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria32Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria32Ql().get(0).getResponse321(), style);
			createCell(row, columnCount++, record.getCriteria32Ql().get(0).getInput321t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria32Qn
	private void writeHeader4() {
		sheet4 = workbook.createSheet("Criteria32Qn");

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
		createCell(row, 8, excelHeaders4[8], style);
		createCell(row, 9, excelHeaders4[9], style);
		createCell(row, 10, excelHeaders4[10], style);

	}

	private void write4() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet4.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getResponse322(), style);
			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getInput3221t11(), style);
			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getResponse323(), style);
			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getInput3231t1(), style);
			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getInput3231t2(), style);
			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getInput3232t1(), style);
			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getResponse324(), style);
			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria33Ql
	private void writeHeader5() {
		sheet5 = workbook.createSheet("Criteria33Ql");

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

	}

	private void write5() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet5.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria33Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria33Ql().get(0).getInput331t1(), style);
			createCell(row, columnCount++, record.getCriteria33Qn().get(0).getResponse331(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria33Qn
	private void writeHeader6() {
		sheet6 = workbook.createSheet("Criteria33Qn");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet6.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria33Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria33Qn().get(0).getResponse332(), style);
			createCell(row, columnCount++, record.getCriteria33Qn().get(0).getResponse333(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria34Ql
	private void writeHeader7() {
		sheet7 = workbook.createSheet("Criteria34Ql");

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
		createCell(row, 7, excelHeaders7[7], style);
		createCell(row, 8, excelHeaders7[8], style);

	}

	private void write7() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet7.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria34Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria34Ql().get(0).getResponse341(), style);
			createCell(row, columnCount++, record.getCriteria34Ql().get(0).getInput341t1(), style);
			createCell(row, columnCount++, record.getCriteria34Ql().get(0).getResponse349(), style);
			createCell(row, columnCount++, record.getCriteria34Ql().get(0).getInput3491t1(), style);
			createCell(row, columnCount++, record.getCriteria34Ql().get(0).getInput3491t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria34Qn
	private void writeHeader8() {
		sheet8 = workbook.createSheet("Criteria34Qn");

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
		createCell(row, 8, excelHeaders8[8], style);

		createCell(row, 9, excelHeaders8[9], style);
		createCell(row, 10, excelHeaders8[10], style);
		createCell(row, 11, excelHeaders8[11], style);
		createCell(row, 12, excelHeaders8[12], style);
		createCell(row, 13, excelHeaders8[13], style);
		createCell(row, 14, excelHeaders8[14], style);
		createCell(row, 15, excelHeaders8[15], style);
		createCell(row, 16, excelHeaders8[16], style);
		createCell(row, 17, excelHeaders8[17], style);

		createCell(row, 18, excelHeaders8[18], style);
		createCell(row, 19, excelHeaders8[19], style);
		createCell(row, 20, excelHeaders8[20], style);
		createCell(row, 21, excelHeaders8[21], style);
		createCell(row, 22, excelHeaders8[22], style);
		createCell(row, 23, excelHeaders8[23], style);
		createCell(row, 24, excelHeaders8[24], style);

	}

	private void write8() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet8.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse342(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput342t1(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3422t1(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse343(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput343t1(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse344(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse345(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3451t1(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3451t2(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3452t1(), style);

			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse346(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3461t1(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3461t2(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse347(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse348(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput348t1(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput348t2(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3482t1(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3482t2(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3441t1(), style);
			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3441t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria35ql
	private void writeHeader9() {
		sheet9 = workbook.createSheet("Criteria35Ql");

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

	}

	private void write9() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet9.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria35Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria35Ql().get(0).getResponse352(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria35qn
	private void writeHeader10() {
		sheet10 = workbook.createSheet("Criteria35Qn");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet10.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria35Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria35Qn().get(0).getResponse351(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria36ql
	private void writeHeader11() {
		sheet11 = workbook.createSheet("Criteria36Ql");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet11.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria36Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria36Ql().get(0).getResponse361(), style);
			createCell(row, columnCount++, record.getCriteria36Ql().get(0).getInput361t1(), style);
			createCell(row, columnCount++, record.getCriteria36Ql().get(0).getInput361t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria36qn
	private void writeHeader12() {
		sheet12 = workbook.createSheet("Criteria36Qn");

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
		createCell(row, 6, excelHeaders12[6], style);

	}

	private void write12() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet12.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria36Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria36Qn().get(0).getResponse362(), style);
			createCell(row, columnCount++, record.getCriteria36Qn().get(0).getResponse363(), style);
			createCell(row, columnCount++, record.getCriteria36Qn().get(0).getResponse364(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}
	

	
	

	// criteria37qn
	private void writeHeader13() {
		sheet13 = workbook.createSheet("Criteria37Qn");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet13.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria37Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria37Qn().get(0).getResponse371(), style);
			createCell(row, columnCount++, record.getCriteria37Qn().get(0).getResponse372(), style);
		

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

////	Criteria3 Criteria3_FieldInfoQl
//
//	private void writeHeader1() {
//		sheet1 = workbook.createSheet("Criteria3_FieldInfoQl");
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
//		for (Criteria3_FieldInfo record : listRecords) {
//			Row row = sheet1.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getInput311t1(), style);
//			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getInput3221t11(), style);
////			createCell(row, columnCount++, record.getCriteria33Qn().get(0).getInput331t1(), style);
////			createCell(row, columnCount++, record.getCriteria33Qn().get(0).getInput331t2(), style);
//
//			createCell(row, columnCount++, record.getCriteria34Ql().get(0).getInput341t1(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput342t1(), style);
//			createCell(row, columnCount++, record.getCriteria36Ql().get(0).getInput361t1(), style);
//			createCell(row, columnCount++, record.getCriteria36Ql().get(0).getInput361t2(), style);
//			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getResponse311(), style);
//
//			createCell(row, columnCount++, record.getCriteria32Ql().get(0).getResponse321(), style);
//			createCell(row, columnCount++, record.getCriteria33Ql().get(0).getResponse331(), style);
//			createCell(row, columnCount++, record.getCriteria34Ql().get(0).getResponse341(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput342t1(), style);
//			createCell(row, columnCount++, record.getCriteria36Ql().get(0).getResponse361(), style);
//
//			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getCriteriaId().getCollegeId(),
//					style);
//			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getCriteria31Ql().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}
//
////	Criteria3 Criteria3_FieldInfoQn
//
//	private void writeHeader2() {
//		sheet2 = workbook.createSheet("Criteria3_FieldInfoQn");
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
//		createCell(row, 23, excelHeaders2[23], style);
//		createCell(row, 24, excelHeaders2[24], style);
//
//		createCell(row, 25, excelHeaders2[25], style);
//		createCell(row, 26, excelHeaders2[26], style);
//		createCell(row, 27, excelHeaders2[27], style);
//		createCell(row, 28, excelHeaders2[28], style);
//		createCell(row, 29, excelHeaders2[29], style);
//
//		createCell(row, 30, excelHeaders2[30], style);
//		createCell(row, 31, excelHeaders2[31], style);
//		createCell(row, 32, excelHeaders2[32], style);
//		createCell(row, 33, excelHeaders2[33], style);
//		createCell(row, 34, excelHeaders2[34], style);
//
//		createCell(row, 35, excelHeaders2[35], style);
//		createCell(row, 36, excelHeaders2[36], style);
//		createCell(row, 37, excelHeaders2[37], style);
//		createCell(row, 38, excelHeaders2[38], style);
//		createCell(row, 39, excelHeaders2[39], style);
//
//		createCell(row, 40, excelHeaders2[40], style);
//		createCell(row, 41, excelHeaders2[41], style);
//		createCell(row, 42, excelHeaders2[42], style);
//		createCell(row, 43, excelHeaders2[43], style);
//		createCell(row, 44, excelHeaders2[44], style);
//
//		createCell(row, 45, excelHeaders2[45], style);
//		createCell(row, 46, excelHeaders2[46], style);
//		createCell(row, 47, excelHeaders2[47], style);
//		createCell(row, 48, excelHeaders2[48], style);
//		createCell(row, 49, excelHeaders2[49], style);
//
//		createCell(row, 50, excelHeaders2[50], style);
//		createCell(row, 51, excelHeaders2[51], style);
//		createCell(row, 52, excelHeaders2[52], style);
//		createCell(row, 53, excelHeaders2[53], style);
//		createCell(row, 54, excelHeaders2[54], style);
//
//	}
//	
//	
//
//	private void write2() {
//		int rowCount = 1;
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setFontHeight(14);
//		style.setFont(font);
//
//		for (Criteria3_FieldInfo record : listRecords) {
//			Row row = sheet2.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getUniqueKey1(), style);
////			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getInput3111t1(), style);
////			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getInput3131t11(), style);
////			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getInput3141t11(), style);
//			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getInput3221t11(), style);
//
//			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getInput3231t1(), style);
//			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getInput3231t1(), style);
//			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getInput3231t2(), style);
////			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getInput3232t2(), style);
////			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getInput3232t3(), style);
//
////			createCell(row, columnCount++, record.getCriteria33Qn().get(0).getInput3311t1(), style);
////			createCell(row, columnCount++, record.getCriteria33Qn().get(0).getInput332t1(), style);
//			createCell(row, columnCount++, record.getCriteria34Ql().get(0).getInput341t1(), style);
////			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3421t1(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3422t1(), style);
//
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput343t1(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3441t1(), style);
////			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3442t1(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3451t1(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3451t2(), style);
//
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3452t1(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3461t1(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getInput3461t2(), style);
////			createCell(row, columnCount++, record.getCriteria35Qn().get(0).getInput351t1(), style);
//			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getResponse311(), style);
//
//			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getResponse312(), style);
//			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getResponse313(), style);
//			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getResponse314(), style);
//			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getResponse315(), style);
//			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getResponse316(), style);
//
//			createCell(row, columnCount++, record.getCriteria31Qn().get(0).getResponse316(), style);
//			createCell(row, columnCount++, record.getCriteria32Ql().get(0).getResponse321(), style);
//
//			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getResponse322(), style);
//			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getResponse323(), style);
//			createCell(row, columnCount++, record.getCriteria32Qn().get(0).getResponse324(), style);
//			createCell(row, columnCount++, record.getCriteria33Qn().get(0).getResponse332(), style);
//			createCell(row, columnCount++, record.getCriteria33Qn().get(0).getResponse333(), style);
//
//			createCell(row, columnCount++, record.getCriteria34Ql().get(0).getResponse341(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse342(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse343(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse344(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse345(), style);
//
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse346(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse347(), style);
//			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse348(), style);
////			createCell(row, columnCount++, record.getCriteria34Qn().get(0).getResponse349(), style);
//			createCell(row, columnCount++, record.getCriteria35Qn().get(0).getResponse351(), style);
//
//			createCell(row, columnCount++, record.getCriteria35Ql().get(0).getResponse352(), style);
//			createCell(row, columnCount++, record.getCriteria36Qn().get(0).getResponse362(), style);
//			createCell(row, columnCount++, record.getCriteria36Qn().get(0).getResponse363(), style);
//			createCell(row, columnCount++, record.getCriteria36Qn().get(0).getResponse364(), style);
//			createCell(row, columnCount++, record.getCriteria37Qn().get(0).getResponse371(), style);
//
//			createCell(row, columnCount++, record.getCriteria37Qn().get(0).getResponse372(), style);
//
//			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getCriteriaId().getCollegeId(),
//					style);
//			createCell(row, columnCount++, record.getCriteria31Ql().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getCriteria31Ql().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}

//	Criteria2  Criteria3_FileUpload

	private void writeHeader14() {
		sheet14 = workbook.createSheet("Criteria3_FileUpload");

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
		createCell(row, 6, excelHeaders14[6], style);

	}

	private void write14() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet14.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteria3FileUpload().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria3FileUpload().get(0).getCriteria3FileName(), style);
			createCell(row, columnCount++, record.getCriteria3FileUpload().get(0).getCriteria3FilePath(), style);
			createCell(row, columnCount++, record.getCriteria3FileUpload().get(0).getCriteria3FileType(), style);

			createCell(row, columnCount++, record.getCriteria3FileUpload().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getCriteria3FileUpload().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getCriteria3FileUpload().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//	Criteria2  YearTable3121 -1

	private void writeHeader15() {
		sheet15 = workbook.createSheet("YearTable3121");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet15.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3121().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3121().get(0).getInput3121v(), style);
			createCell(row, columnCount++, record.getYearTable3121().get(0).getInput3121y(), style);

			createCell(row, columnCount++, record.getYearTable3121().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3121().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3121().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable3131 -2

	private void writeHeader16() {
		sheet16 = workbook.createSheet("YearTable3131");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet16.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3131().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3131().get(0).getInput3131v(), style);
			createCell(row, columnCount++, record.getYearTable3131().get(0).getInput3131y(), style);

			createCell(row, columnCount++, record.getYearTable3131().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3131().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3131().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// Criteria2 YearTable3211 -3

	private void writeHeader17() {
		sheet17 = workbook.createSheet("YearTable3211");

		Row row = sheet6.createRow(0);

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet17.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3211().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3211().get(0).getInput3211v(), style);
			createCell(row, columnCount++, record.getYearTable3211().get(0).getInput3211y(), style);

			createCell(row, columnCount++, record.getYearTable3211().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3211().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3211().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable3221 -4

	private void writeHeader18() {
		sheet18= workbook.createSheet("YearTable3221");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet18.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3221().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3221().get(0).getInput3221v(), style);
			createCell(row, columnCount++, record.getYearTable3221().get(0).getInput3221y(), style);

			createCell(row, columnCount++, record.getYearTable3221().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3221().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3221().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria3  YearTable3241 -5

	private void writeHeader19() {
		sheet19 = workbook.createSheet("YearTable3241");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet19.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3241().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3241().get(0).getInput3241v(), style);
			createCell(row, columnCount++, record.getYearTable3241().get(0).getInput3241y(), style);

			createCell(row, columnCount++, record.getYearTable3241().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3241().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3241().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria3  YearTable3242 -6

	private void writeHeader20() {
		sheet20= workbook.createSheet("YearTable3242");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet20.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3242().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3242().get(0).getInput3242v(), style);
			createCell(row, columnCount++, record.getYearTable3242().get(0).getInput3242y(), style);

			createCell(row, columnCount++, record.getYearTable3242().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3242().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3242().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// Criteria2 yearTable3321

	private void writeHeader21() {
		sheet21= workbook.createSheet("yearTable3321");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet21.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3321().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3321().get(0).getInput3321v(), style);
			createCell(row, columnCount++, record.getYearTable3321().get(0).getInput3321y(), style);

			createCell(row, columnCount++, record.getYearTable3321().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3321().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3321().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable3431

	private void writeHeader22() {
		sheet22 = workbook.createSheet("YearTable3431");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet22.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3431().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3431().get(0).getInput3431v(), style);
			createCell(row, columnCount++, record.getYearTable3431().get(0).getInput3431y(), style);

			createCell(row, columnCount++, record.getYearTable3431().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3431().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3431().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}
//	Criteria2  YearTable3441

	private void writeHeader23() {
		sheet23 = workbook.createSheet("YearTable3441");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet23.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3441().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3441().get(0).getInput3441v(), style);
			createCell(row, columnCount++, record.getYearTable3441().get(0).getInput3441y(), style);

			createCell(row, columnCount++, record.getYearTable3441().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3441().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3441().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria3  YearTable3511

	private void writeHeader24() {
		sheet24 = workbook.createSheet("YearTable3511");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet24.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3511().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3511().get(0).getInput3511v(), style);
			createCell(row, columnCount++, record.getYearTable3511().get(0).getInput3511y(), style);

			createCell(row, columnCount++, record.getYearTable3511().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3511().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3511().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable3521

	private void writeHeader25() {
		sheet25 = workbook.createSheet("YearTable3521");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet25.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3521().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3521().get(0).getInput3521v(), style);
			createCell(row, columnCount++, record.getYearTable3521().get(0).getInput3521y(), style);

			createCell(row, columnCount++, record.getYearTable3521().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3521().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3521().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable3621

	private void writeHeader26() {
		sheet26 = workbook.createSheet("YearTable3621");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet26.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3621().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3621().get(0).getInput3621v(), style);
			createCell(row, columnCount++, record.getYearTable3621().get(0).getInput3621y(), style);

			createCell(row, columnCount++, record.getYearTable3621().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3621().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3621().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable3631

	private void writeHeader27() {
		sheet27 = workbook.createSheet("YearTable3631");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet27.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3631().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3631().get(0).getInput3631v(), style);
			createCell(row, columnCount++, record.getYearTable3631().get(0).getInput3631y(), style);

			createCell(row, columnCount++, record.getYearTable3631().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3631().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3631().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// YearTable3641
	private void writeHeader28() {
		sheet28 = workbook.createSheet("YearTable3641");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet28.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3641().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3641().get(0).getInput3641v(), style);
			createCell(row, columnCount++, record.getYearTable3641().get(0).getInput3641y(), style);

			createCell(row, columnCount++, record.getYearTable3641().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3641().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3641().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//  YearTable36412
	private void writeHeader29() {
		sheet29 = workbook.createSheet("YearTable36412");

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

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet29.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable36412().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable36412().get(0).getInput36412v(), style);
			createCell(row, columnCount++, record.getYearTable36412().get(0).getInput36412y(), style);

			createCell(row, columnCount++, record.getYearTable36412().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable36412().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable36412().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//  YearTable3711
	private void writeHeader30() {
		sheet30 = workbook.createSheet("YearTable3711");

		Row row = sheet30.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders30[0], style);
		createCell(row, 1, excelHeaders30[1], style);
		createCell(row, 2, excelHeaders30[2], style);
		createCell(row, 3, excelHeaders30[3], style);
		createCell(row, 4, excelHeaders30[4], style);
		createCell(row, 5, excelHeaders30[5], style);

	}

	private void write30() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet30.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable3711().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3711().get(0).getInput3711v(), style);
			createCell(row, columnCount++, record.getYearTable3711().get(0).getInput3711y(), style);

			createCell(row, columnCount++, record.getYearTable3711().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3711().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3711().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

// YearTable3721
	private void writeHeader31() {
		sheet31 = workbook.createSheet("YearTable3721");

		Row row = sheet31.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders31[0], style);
		createCell(row, 1, excelHeaders31[1], style);
		createCell(row, 2, excelHeaders31[2], style);
		createCell(row, 3, excelHeaders31[3], style);
		createCell(row, 4, excelHeaders31[4], style);
		createCell(row, 5, excelHeaders31[5], style);

	}

	private void write31() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet31.createRow(rowCount++);
			int columnCount = 0;

		createCell(row, columnCount++, record.getYearTable3721().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable3721().get(0).getInput3721v(), style);
			createCell(row, columnCount++, record.getYearTable3721().get(0).getInput3721y(), style);
//			
			createCell(row, columnCount++, record.getYearTable3721().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable3721().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable3721().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  UniversityYearTable3141
	private void writeHeader32() {
		sheet32 = workbook.createSheet("UniversityYearTable3141");

		Row row = sheet32.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders32[0], style);
		createCell(row, 1, excelHeaders32[1], style);
		createCell(row, 2, excelHeaders32[2], style);
		createCell(row, 3, excelHeaders32[3], style);
		createCell(row, 4, excelHeaders32[4], style);
		createCell(row, 5, excelHeaders32[5], style);

	}

	private void write32() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet32.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable3141().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3141().get(0).getInput3141v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3141().get(0).getInput3141y(), style);

			createCell(row, columnCount++, record.getUniversityYearTable3141().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3141().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3141().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  UniversityYearTable3141
	private void writeHeader33() {
		sheet33= workbook.createSheet("UniversityYearTable3231"); // university 3231

		Row row = sheet33.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders33[0], style);
		createCell(row, 1, excelHeaders33[1], style);
		createCell(row, 2, excelHeaders33[2], style);
		createCell(row, 3, excelHeaders33[3], style);
		createCell(row, 4, excelHeaders33[4], style);
		createCell(row, 5, excelHeaders33[5], style);

	}

	private void write33() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet33.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable3231().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3231().get(0).getInput3231v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3231().get(0).getInput3231y(), style);

			createCell(row, columnCount++, record.getUniversityYearTable3231().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3231().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3231().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  UniversityYearTable3232
	private void writeHeader34() {
		sheet34 = workbook.createSheet("UniversityYearTable3232");

		Row row = sheet34.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders34[0], style);
		createCell(row, 1, excelHeaders34[1], style);
		createCell(row, 2, excelHeaders34[2], style);
		createCell(row, 3, excelHeaders34[3], style);
		createCell(row, 4, excelHeaders34[4], style);
		createCell(row, 5, excelHeaders34[5], style);

	}

	private void write34() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet34.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable3232().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3232().get(0).getInput3232v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3232().get(0).getInput3232y(), style);

			createCell(row, columnCount++, record.getUniversityYearTable3232().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3232().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3232().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  UniversityYearTable3331
	private void writeHeader35() {
		sheet35 = workbook.createSheet("UniversityYearTable3331");

		Row row = sheet35.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders35[0], style);
		createCell(row, 1, excelHeaders35[1], style);
		createCell(row, 2, excelHeaders35[2], style);
		createCell(row, 3, excelHeaders35[3], style);
		createCell(row, 4, excelHeaders35[4], style);
		createCell(row, 5, excelHeaders35[5], style);

	}

	private void write35() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet35.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable3331().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3331().get(0).getInput3331v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3331().get(0).getInput3331y(), style);

			createCell(row, columnCount++, record.getUniversityYearTable3331().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3331().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3331().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  UniversityYearTable3141
	private void writeHeader36() {
		sheet36 = workbook.createSheet("UniversityYearTable3431");

		Row row = sheet36.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders36[0], style);
		createCell(row, 1, excelHeaders36[1], style);
		createCell(row, 2, excelHeaders36[2], style);
		createCell(row, 3, excelHeaders36[3], style);
		createCell(row, 4, excelHeaders36[4], style);
		createCell(row, 5, excelHeaders36[5], style);

	}

	private void write36() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet36.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable3431().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3431().get(0).getInput3431v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3431().get(0).getInput3431y(), style);

			createCell(row, columnCount++, record.getUniversityYearTable3431().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3431().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3431().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  UniversityYearTable3442
	private void writeHeader37() {
		sheet37 = workbook.createSheet("UniversityYearTable3442");

		Row row = sheet37.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders37[0], style);
		createCell(row, 1, excelHeaders37[1], style);
		createCell(row, 2, excelHeaders37[2], style);
		createCell(row, 3, excelHeaders37[3], style);
		createCell(row, 4, excelHeaders37[4], style);
		createCell(row, 5, excelHeaders37[5], style);

	}

	private void write37() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet37.createRow(rowCount++);
			int columnCount = 0;

			// createCell(row, columnCount++,
			// record.getUniversityYearTable3442().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3442().get(0).getInput3442v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3442().get(0).getInput3442y(), style);

//			createCell(row, columnCount++, record.getUniversityYearTable3442().get(0).getCriteriaId().getCollegeId(), style);
//			createCell(row, columnCount++, record.getUniversityYearTable3442().get(0).getCriteriaId().getFinancialYear(), style);
//			createCell(row, columnCount++, record.getUniversityYearTable3442().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  UniversityYearTable3451
	private void writeHeader38() {
		sheet38 = workbook.createSheet("UniversityYearTable3451");

		Row row = sheet38.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders38[0], style);
		createCell(row, 1, excelHeaders38[1], style);
		createCell(row, 2, excelHeaders38[2], style);
		createCell(row, 3, excelHeaders38[3], style);
		createCell(row, 4, excelHeaders38[4], style);
		createCell(row, 5, excelHeaders38[5], style);

	}

	private void write38() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet38.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable3451().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3451().get(0).getInput3451v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3451().get(0).getInput3451y(), style);

			createCell(row, columnCount++, record.getUniversityYearTable3451().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3451().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3451().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  UniversityYearTable34512
	private void writeHeader39() {
		sheet39 = workbook.createSheet("UniversityYearTable34512");

		Row row = sheet39.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders39[0], style);
		createCell(row, 1, excelHeaders39[1], style);
		createCell(row, 2, excelHeaders39[2], style);
		createCell(row, 3, excelHeaders39[3], style);
		createCell(row, 4, excelHeaders39[4], style);
		createCell(row, 5, excelHeaders39[5], style);

	}

	private void write39() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet39.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable34512().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable34512().get(0).getInput34512v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable34512().get(0).getInput34512y(), style);

			createCell(row, columnCount++, record.getUniversityYearTable34512().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getUniversityYearTable34512().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getUniversityYearTable34512().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//  UniversityYearTable3461
	private void writeHeader40() {
		sheet40 = workbook.createSheet("UniversityYearTable3461");

		Row row = sheet40.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders40[0], style);
		createCell(row, 1, excelHeaders40[1], style);
		createCell(row, 2, excelHeaders40[2], style);
		createCell(row, 3, excelHeaders40[3], style);
		createCell(row, 4, excelHeaders40[4], style);
		createCell(row, 5, excelHeaders40[5], style);

	}

	private void write40() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet40.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable3461().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3461().get(0).getInput3461v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable3461().get(0).getInput3461y(), style);

			createCell(row, columnCount++, record.getUniversityYearTable3461().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3461().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getUniversityYearTable3461().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// UniversityYearTable3141
	private void writeHeader41() {
		sheet41 = workbook.createSheet("UniversityYearTable34612");

		Row row = sheet41.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders41[0], style);
		createCell(row, 1, excelHeaders41[1], style);
		createCell(row, 2, excelHeaders41[2], style);
		createCell(row, 3, excelHeaders41[3], style);
		createCell(row, 4, excelHeaders41[4], style);
		createCell(row, 5, excelHeaders41[5], style);

	}

	private void write41() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet41.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityYearTable34612().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityYearTable34612().get(0).getInput34612v(), style);
			createCell(row, columnCount++, record.getUniversityYearTable34612().get(0).getInput34612y(), style);

			createCell(row, columnCount++, record.getUniversityYearTable34612().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getUniversityYearTable34612().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getUniversityYearTable34612().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Affiliated_YearTable342
	private void writeHeader42() {
		sheet42 = workbook.createSheet("Affiliated_YearTable342");

		Row row = sheet42.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders42[0], style);
		createCell(row, 1, excelHeaders42[1], style);
		createCell(row, 2, excelHeaders42[2], style);
		createCell(row, 3, excelHeaders42[3], style);
		createCell(row, 4, excelHeaders42[4], style);
		createCell(row, 5, excelHeaders42[5], style);

	}

	private void write42() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet42.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliated_YearTable342().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable342().get(0).getInput342v(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable342().get(0).getInput342y(), style);

			createCell(row, columnCount++, record.getAffiliated_YearTable342().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable342().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable342().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Affiliated_YearTable351
	private void writeHeader43() {
		sheet43 = workbook.createSheet("Affiliated_YearTable351");

		Row row = sheet43.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders43[0], style);
		createCell(row, 1, excelHeaders43[1], style);
		createCell(row, 2, excelHeaders43[2], style);
		createCell(row, 3, excelHeaders43[3], style);
		createCell(row, 4, excelHeaders43[4], style);
		createCell(row, 5, excelHeaders43[5], style);

	}

	private void write43() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet43.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliated_YearTable351().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable351().get(0).getInput351v(), style);
			createCell(row, columnCount++, record.getAffiliated_YearTable351().get(0).getInput351y(), style);

			createCell(row, columnCount++, record.getAffiliated_YearTable351().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable351().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliated_YearTable351().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Affiliated_YearTable3111
	private void writeHeader44() {
		sheet44 = workbook.createSheet("Affiliated_YearTable3111");

		Row row = sheet44.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders44[0], style);
		createCell(row, 1, excelHeaders44[1], style);
		createCell(row, 2, excelHeaders44[2], style);
		createCell(row, 3, excelHeaders44[3], style);
		createCell(row, 4, excelHeaders44[4], style);
		createCell(row, 5, excelHeaders44[5], style);

	}

	private void write44() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet44.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedYearTable3111().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable3111().get(0).getInput3111v(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable3111().get(0).getInput3111y(), style);

			createCell(row, columnCount++, record.getAffiliatedYearTable3111().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable3111().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable3111().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Affiliated_YearTable3311
	private void writeHeader45() {
		sheet45 = workbook.createSheet("Affiliated_YearTable3311");

		Row row = sheet45.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders45[0], style);
		createCell(row, 1, excelHeaders45[1], style);
		createCell(row, 2, excelHeaders45[2], style);
		createCell(row, 3, excelHeaders45[3], style);
		createCell(row, 4, excelHeaders45[4], style);
		createCell(row, 5, excelHeaders45[5], style);

	}

	private void write45() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria3_FieldInfo record : listRecords) {
			Row row = sheet45.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedYearTable3311().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable3311().get(0).getInput3311v(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable3311().get(0).getInput3311y(), style);

			createCell(row, columnCount++, record.getAffiliatedYearTable3311().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable3311().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable3311().get(0).getCriteriaId().getTypeofInstitution(), style);

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
		writeHeader14();
		writeHeader15();
		writeHeader16();
		writeHeader17();
		writeHeader18();
		writeHeader19();
		writeHeader20();
		writeHeader21();
		writeHeader22();
		writeHeader23();
		writeHeader24();
		writeHeader25();
		writeHeader26();
		writeHeader27();
		writeHeader28();
		writeHeader29();
		writeHeader30();
		writeHeader31();
//		writeHeader32();
//		writeHeader33();
//		writeHeader34();
//		writeHeader35();
//		writeHeader36();
//		writeHeader37();
//		writeHeader38();
//		writeHeader39();
//		writeHeader40();
//		writeHeader41();
//		writeHeader42();
	//	writeHeader43();
//		writeHeader44();
//		writeHeader45();
		

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
		write15();
		write16();
		write17();
		write18();
		write19();
		write20();
		write21();
		write22();
		write23();
		write24();
		write25();
		write26();
		write27();
		write28();
		write29();
		write30();
		write31();
//		write32();
//		write33();
//		write34();
//		write35();
//		write36();
//		write37();
//		write38();
//		write39();
//		write40();
//		write41();
//		write42();
		//write43();
//		write44();
//		write45();
		
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
			writeHeader14();
			writeHeader15();
			writeHeader16();
			writeHeader17();
			writeHeader18();
			//writeHeader19();
			//writeHeader20();
			writeHeader21();
			writeHeader22();
			writeHeader23();
		//	writeHeader24();
			writeHeader25();
			writeHeader26();
			writeHeader27();
			writeHeader28();
			writeHeader29();
			writeHeader30();
			writeHeader31();
			//writeHeader43();
			
			
			writeHeader32(); //university
			writeHeader33();  //university
			writeHeader34();  //university
			writeHeader35();  //university
			writeHeader36();  //university
			writeHeader37();  //university
			writeHeader38();  //university
			writeHeader39();  //university
			writeHeader40();  //university
			writeHeader41();  //university
			
			
			
			
			
			
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
			write15();
			write16();
			write17();
			write18();
			//write19();
			//write20();
			write21();
			write22();
			write23();
			//write24();
			write25();
			write26();
			write27();
			write28();
			write29();
			write30();
			write31();
			//write43();
			
			write32();  //university
			write33();  //university
			write34();  //university
			write35();  //university
			write36();  //university
			write37();  //university
			write38();  //university
			write39();  //university
			write40();  //university
			write41();  //university
			
			
			
		}
		
		
		
		if ("affiliated".equalsIgnoreCase(allParams.get("typeofInstitution"))) 
		{
			
			writeHeader();
			writeHeader1();
			//writeHeader2();
			writeHeader3();
			writeHeader4();
			writeHeader5();
			writeHeader6();
			writeHeader7();
			writeHeader8();
			//writeHeader9();
			writeHeader10();
			writeHeader11();
			writeHeader12();
			writeHeader13();
			writeHeader14();
			//writeHeader15();
			//writeHeader16();
			//writeHeader17();
			writeHeader18();
			writeHeader19();
			writeHeader20();
			writeHeader21();
			writeHeader22();
			writeHeader23();
			writeHeader24();
			writeHeader25();
			writeHeader26();
			writeHeader27();
			writeHeader28();
			writeHeader29();
			writeHeader30();
			writeHeader31();
			writeHeader43();
			writeHeader42(); //affiliated
			writeHeader44(); //affiliated
			writeHeader45(); //affiliated
			
			
			
			write();
			write1();
			//write2();
			write3();
			write4();
			write5();
			write6();
			write7();
			write8();
			//write9();
			write10();
			write11();
			write12();
			write13();
			write14();
			//write15();
			//write16();
		//	write17();
			write18();
			write19();
			write20();
			write21();
			write22();
			write23();
			write24();
			write25();
			write26();
			write27();
			write28();
			write29();
			write30();
			write31();
			write43();
			
			write42(); //affiliated
			write44(); //affiliated
			write45();  //affiliated
		}

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
