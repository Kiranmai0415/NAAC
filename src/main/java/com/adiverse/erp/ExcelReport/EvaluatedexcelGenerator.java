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

import com.adiverse.erp.model.EvaluativereportMain;

public class EvaluatedexcelGenerator {

	private List<EvaluativereportMain> listRecords;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFSheet sheet1;

	private String[] excelHeaders = new String[] { "collegeId", "financialYear", "typeofInstitution",
			"nameof_the_autonomous_college", "nameof_the_department", "dist", "state",
			"total_numberof_departments_inthe_institution" };

	private String[] excelHeaders1 = new String[] { "unique_key1", "si_no", "name_ofthe_department1", "english",
			"zoology", "bio_technology", "collegeId", "financialYear", "typeofInstitution" };

	public EvaluatedexcelGenerator(List<EvaluativereportMain> listOfRecords) {
		this.listRecords = listOfRecords;
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

	// evaluativereport_Main

	private void writeHeader() {
		sheet = workbook.createSheet("evaluativereport_Main");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders[0], style);
		createCell(row, 1, excelHeaders[1], style);
		createCell(row, 2, excelHeaders[2], style);
		createCell(row, 3, excelHeaders[3], style);
		createCell(row, 4, excelHeaders[4], style);

		createCell(row, 5, excelHeaders[5], style);
		createCell(row, 6, excelHeaders[6], style);
		createCell(row, 7, excelHeaders[7], style);

	}

	private void write() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (EvaluativereportMain record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
			createCell(row, columnCount++, record.getDist(), style);
			createCell(row, columnCount++, record.getState(), style);
			createCell(row, columnCount++, record.getNameofTheAutonomousCollege(), style);
			createCell(row, columnCount++, record.getTotalNumberofDepartmentsIntheInstitution(), style);
			createCell(row, columnCount++, record.getNameofTheDepartment(), style);

		}

	}

	// evaluative_departmentschild
	private void writeHeader1() {
		sheet1 = workbook.createSheet("evaluative_departmentschild");

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

	}

	private void write1() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (EvaluativereportMain record : listRecords) {
			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEvaluativereportofthedepartment11().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEvaluativereportofthedepartment11().get(0).getSiNo(), style);
			createCell(row, columnCount++,
					record.getEvaluativereportofthedepartment11().get(0).getNameOftheDepartment1(), style);

			createCell(row, columnCount++, record.getEvaluativereportofthedepartment11().get(0).getEnglish(), style);

			createCell(row, columnCount++, record.getEvaluativereportofthedepartment11().get(0).getZoology(), style);
			createCell(row, columnCount++, record.getEvaluativereportofthedepartment11().get(0).getBioTechnology(),
					style);

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}

	public void generate(HttpServletResponse response,Map<String, String> allParams) throws IOException {
		if ("autonomous".equalsIgnoreCase(allParams.get("typeofInstitution"))) 
		{
		writeHeader();
		writeHeader1();

		write();
		write1();
		}
		
		
		
		if ("university".equalsIgnoreCase(allParams.get("typeofInstitution"))) 
		{
			writeHeader();
			writeHeader1();

			write();
			write1();
			
			
		}
		
		if ("affiliated".equalsIgnoreCase(allParams.get("typeofInstitution"))) 
		{
			writeHeader();
			writeHeader1();

			write();
			write1();
			
			
		}

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
