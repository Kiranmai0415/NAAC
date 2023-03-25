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
import com.adiverse.erp.model.Criteria4_FieldInfo;

public class Criteria4ExcelGenerator {

	private List<Criteria4_FieldInfo> listRecords;
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

	private String[] excelHeaders = new String[] { "collegeId", "financialYear", "typeofInstitution" };

	// criteria4ql

	private String[] excelHeaders1 = new String[] { "unique_key1", "responseValue411", "input411t1", "responseValue412",
			"responseValue413", "input413t1", "input4131t1", "input412t1", "responseValue431", "input431t1",
			"responseValue414", "collegeId", "financialYear", "typeofInstitution" };

	// criteria41qn

	private String[] excelHeaders2 = new String[] { "unique_key1", "responseValue413", "input4131t1", "input4131t2",
			"collegeId", "financialYear", "typeofInstitution" };

	// criteria42ql

	private String[] excelHeaders3 = new String[] { "unique_key1", "responseValue421", "input421t1", "collegeId",
			"financialYear", "typeofInstitution" };

	// criteria42qn
	private String[] excelHeaders4 = new String[] { "unique_key1", "responseValue422", "input422t1", "responseValue423",
			"responseValue424", "input4241t1", "input4241t2", "collegeId", "financialYear", "typeofInstitution" };

	// criteria43ql
	private String[] excelHeaders5 = new String[] { "unique_key1", "responseValue431", "input431t1", "input431t2",
			"collegeId", "financialYear", "typeofInstitution" };

	// criteria43qn

	private String[] excelHeaders6 = new String[] { "unique_key1", "responseValue432", "input432t1", "input432t2",
			"responseValue433", "input433t1", "input433t2", "responseValue434", "input434t1", "responseValue435",
			"input435t1", "collegeId", "financialYear", "typeofInstitution" };

	// criteria44ql
	private String[] excelHeaders7 = new String[] { "unique_key1", "responseValue441", "responseValue442", "input442t1",
			"collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders8 = new String[] { "unique_key1", "criteria4_file_name", "criteria4_file_path",
			"criteria4_file_type", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders9 = new String[] { "unique_key1", "year", "expenditure_infrastructure", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders10 = new String[] { "unique_key1", "year", "expenditure_infrastructure_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders11 = new String[] { "unique_key1", "year", "books_ebooks", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders12 = new String[] { "unique_key1", "year", "physical_facilities", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders13 = new String[] { "unique_key1", "year", "physical_facilities_1", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders14 = new String[] { "unique_key1", "year", "agumentation", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders15 = new String[] { "unique_key1", "year", "agumentation", "collegeId",
			"financialYear", "typeofInstitution" };

	public Criteria4ExcelGenerator(List<Criteria4_FieldInfo> listRecords) {
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

//	Criteria4  criteriaId

	private void writeHeader() {
		sheet = workbook.createSheet("Criteria4_FieldInfo");

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

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// criteria41Ql
	private void writeHeader1() {
		sheet1 = workbook.createSheet("Criteria41Ql");

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
		createCell(row, 6, excelHeaders1[0], style);
		createCell(row, 7, excelHeaders1[1], style);
		createCell(row, 8, excelHeaders1[2], style);
		createCell(row, 9, excelHeaders1[3], style);
		createCell(row, 10, excelHeaders1[4], style);
		createCell(row, 11, excelHeaders1[5], style);
		createCell(row, 12, excelHeaders1[4], style);
		createCell(row, 13, excelHeaders1[5], style);

	}

	private void write1() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getResponse411(), style);
			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getInput411t1(), style);

			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getResponse412(), style);
			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getResponse413(), style);
			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getInput413t1(), style);
			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getInput4131t1(), style);
			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getInput412t1(), style);
			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getResponse431(), style);
			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getInput431t1(), style);
			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getResponse414(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria41Qn
	private void writeHeader2() {
		sheet2 = workbook.createSheet("Criteria41Qn");

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
		createCell(row, 6, excelHeaders2[0], style);

	}

	private void write2() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet2.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getResponse413(), style);
			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getInput4131t1(), style);

			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getInput4131t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria42Ql
	private void writeHeader3() {
		sheet3 = workbook.createSheet("Criteria42Ql");

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
		createCell(row, 6, excelHeaders3[0], style);

	}

	private void write3() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet3.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria42Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria42Ql().get(0).getResponse421(), style);
			createCell(row, columnCount++, record.getCriteria42Ql().get(0).getInput421t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria42QN
	private void writeHeader4() {
		sheet4 = workbook.createSheet("Criteria42Qn");

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
		createCell(row, 6, excelHeaders4[0], style);

	}

	private void write4() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet4.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getResponse422(), style);
			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getInput422t1(), style);
			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getResponse423(), style);
			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getResponse424(), style);
			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getInput4241t1(), style);
			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getInput4241t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria43ql
	private void writeHeader5() {
		sheet5 = workbook.createSheet("Criteria43Ql");

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
		createCell(row, 6, excelHeaders5[0], style);

	}

	private void write5() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet5.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria43Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria43Ql().get(0).getResponse431(), style);
			createCell(row, columnCount++, record.getCriteria43Ql().get(0).getInput431t1(), style);
			createCell(row, columnCount++, record.getCriteria43Ql().get(0).getInput431t2(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria43qn
	private void writeHeader6() {
		sheet6 = workbook.createSheet("Criteria43Qn");

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
		createCell(row, 6, excelHeaders6[0], style);

	}

	private void write6() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet6.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getResponse432(), style);
			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getInput432t1(), style);
			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getInput432t2(), style);
			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getResponse433(), style);
			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getInput433t1(), style);
			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getInput433t2(), style);
			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getResponse434(), style);
			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getInput434t1(), style);
			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getResponse435(), style);
			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getInput435t1(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	// criteria44ql
	private void writeHeader7() {
		sheet7 = workbook.createSheet("Criteria44Ql");

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

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet7.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria44Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria44Ql().get(0).getResponse441(), style);
			createCell(row, columnCount++, record.getCriteria44Ql().get(0).getResponse442(), style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

////	Criteria4 criteria4FieldInfoQl
//
//	private void writeHeader1() {
//		sheet1 = workbook.createSheet("Criteria4_FieldInfoQl");
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
//		for (Criteria4_FieldInfo record : listRecords) {
//			Row row = sheet1.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getInput411t1(), style);
//			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getInput412t1(), style);
//			createCell(row, columnCount++, record.getCriteria42Ql().get(0).getInput421t1(), style);
//			createCell(row, columnCount++, record.getCriteria44Ql().get(0).getInput442t1(), style);
//
//			createCell(row, columnCount++, record.getCriteria43Ql().get(0).getInput431t1(), style);
//			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getResponse411(), style);
//			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getResponse412(), style);
//			createCell(row, columnCount++, record.getCriteria42Ql().get(0).getResponse421(), style);
//			createCell(row, columnCount++, record.getCriteria43Ql().get(0).getResponse431(), style);
//
//			createCell(row, columnCount++, record.getCriteria44Ql().get(0).getResponse442(), style);
//
//			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getCriteriaId().getCollegeId(),
//					style);
//
//			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getCriteria41Qn().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}
//
////	Criteria4 Criteria4_FieldInfoQn
//
//	private void writeHeader2() {
//		sheet2 = workbook.createSheet("Criteria4_FieldInfoQn");
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
//		for (Criteria4_FieldInfo record : listRecords) {
//			Row row = sheet2.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getInput412t1(), style);
//			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getInput4131t1(), style);
//			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getInput4131t2(), style);
//			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getInput422t1(), style);
//
//			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getInput4241t1(), style);
//			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getResponse434(), style);
//			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getInput4241t2(), style);
//			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getInput432t1(), style);
////			createCell(row, columnCount++, record.getCriteria43Ql().get(0).getInput432t2(), style);
//
//			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getInput433t1(), style);
//			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getInput434t1(), style);
//			createCell(row, columnCount++, record.getCriteria44Ql().get(0).getInput442t1(), style);
//			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getResponse412(), style);
//			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getResponse413(), style);
//
//			createCell(row, columnCount++, record.getCriteria41Ql().get(0).getResponse414(), style);
//			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getResponse422(), style);
//			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getResponse423(), style);
//			createCell(row, columnCount++, record.getCriteria42Qn().get(0).getResponse424(), style);
//			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getResponse432(), style);
//
//			createCell(row, columnCount++, record.getCriteria43Qn().get(0).getResponse433(), style);
//			createCell(row, columnCount++, record.getCriteria44Ql().get(0).getResponse441(), style);
//
//			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getCriteriaId().getCollegeId(),
//					style);
//			createCell(row, columnCount++, record.getCriteria41Qn().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getCriteria41Qn().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}

//	Criteria4_FileUpload

	private void writeHeader8() {
		sheet8 = workbook.createSheet("Criteria4_FileUpload");

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

	}

	private void write8() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet8.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteria4FileUpload().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria4FileUpload().get(0).getCriteria4FileName(), style);
			createCell(row, columnCount++, record.getCriteria4FileUpload().get(0).getCriteria4FilePath(), style);
			createCell(row, columnCount++, record.getCriteria4FileUpload().get(0).getCriteria4FileType(), style);

			createCell(row, columnCount++, record.getCriteria4FileUpload().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getCriteria4FileUpload().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getCriteria4FileUpload().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//	Criteria4  YearTable4141 -1

	private void writeHeader9() {
		sheet9 = workbook.createSheet("YearTable4141");

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

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet9.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable4141().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable4141().get(0).getInput4141v(), style);
			createCell(row, columnCount++, record.getYearTable4141().get(0).getInput4141y(), style);

			createCell(row, columnCount++, record.getYearTable4141().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable4141().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable4141().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable41412 -2

	private void writeHeader10() {
		sheet10 = workbook.createSheet("YearTable41412");

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

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet10.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable41412().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable41412().get(0).getInput41412v(), style);
			createCell(row, columnCount++, record.getYearTable41412().get(0).getInput41412y(), style);

			createCell(row, columnCount++, record.getYearTable41412().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable41412().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable41412().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// Criteria4 YearTable4321-3

	private void writeHeader11() {
		sheet11 = workbook.createSheet("YearTable4321");

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

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet11.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable4231().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable4231().get(0).getInput4231v(), style);
			createCell(row, columnCount++, record.getYearTable4231().get(0).getInput4231y(), style);

			createCell(row, columnCount++, record.getYearTable4231().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable4231().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable4231().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  YearTable4411 -4

	private void writeHeader12() {
		sheet12 = workbook.createSheet("YearTable4411");

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

		for (Criteria4_FieldInfo record : listRecords) {

			Row row = sheet12.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable4411().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable4411().get(0).getInput4411v(), style);
			createCell(row, columnCount++, record.getYearTable4411().get(0).getInput4411y(), style);

			createCell(row, columnCount++, record.getYearTable4411().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable4411().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable4411().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria4  YearTable44112 -5

	private void writeHeader13() {
		sheet13 = workbook.createSheet("YearTable44112");

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

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet13.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getYearTable44112().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getYearTable44112().get(0).getInput44112v(), style);
			createCell(row, columnCount++, record.getYearTable44112().get(0).getInput44112y(), style);

			createCell(row, columnCount++, record.getYearTable44112().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getYearTable44112().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getYearTable44112().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	Criteria2  Affiliated_YearTable4121 -6

	private void writeHeader14() {
		sheet14 = workbook.createSheet("Affiliated_YearTable4121");

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

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet14.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedYearTable4121().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable4121().get(0).getInput4121v(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable4121().get(0).getInput4121y(), style);

			createCell(row, columnCount++, record.getAffiliatedYearTable4121().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable4121().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable4121().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

//	Criteria2  Affiliated_YearTable41212 -6

	private void writeHeader15() {
		sheet15 = workbook.createSheet("Affiliated_YearTable41212");

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

		for (Criteria4_FieldInfo record : listRecords) {
			Row row = sheet15.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedYearTable41212().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable41212().get(0).getInput41212v(), style);
			createCell(row, columnCount++, record.getAffiliatedYearTable41212().get(0).getInput41212y(), style);

			createCell(row, columnCount++, record.getAffiliatedYearTable4121().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable41212().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedYearTable41212().get(0).getCriteriaId().getTypeofInstitution(), style);

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
//		writeHeader14();

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
//		write14();
		}

		if ("university".equalsIgnoreCase(allParams.get("typeofInstitution"))) {

			writeHeader();
			writeHeader1();
			//writeHeader2();
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

			write();
			write1();
			//write2();
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

		}

		if ("affiliated".equalsIgnoreCase(allParams.get("typeofInstitution"))) {

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
			//writeHeader10();
			//writeHeader11();
			writeHeader12();
			writeHeader13();
			writeHeader14(); // affiliated
			writeHeader15(); // affiliated

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
			//write10();
			//write11();
			write12();
			write13();

			write14(); // affiliated
			write15(); // affiliated

		}

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
