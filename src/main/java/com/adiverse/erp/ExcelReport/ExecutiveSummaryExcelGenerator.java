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

import com.adiverse.erp.model.ExecutiveSummary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExecutiveSummaryExcelGenerator {

	private List<ExecutiveSummary> listRecords;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFSheet sheet1;

	private String[] excelHeaders = new String[] { "collegeId", "financialYear", "typeofInstitution",
			"executive_institution", "executive_vision", "executive_mission", "executive_location",
			"executive_typeOf_institution", "criterionWise_institution", "strength_weakness", "additional_information",
			"conclusive_explication" };

	private String[] excelHeaders1 = new String[] { "unique_key1", "executive_file_name", "executive_file_path",
			"executive_file_type", "collegeId", "financialYear", "typeofInstitution" };

	public ExecutiveSummaryExcelGenerator(List<ExecutiveSummary> listOfRecords) {
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

	// executive_summary

	private void writeHeader() {
		sheet = workbook.createSheet("executive_summary");

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
		createCell(row, 8, excelHeaders[8], style);
		createCell(row, 9, excelHeaders[9], style);

		createCell(row, 10, excelHeaders[10], style);
		createCell(row, 11, excelHeaders[11], style);

	}

	private void write() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ExecutiveSummary record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);

			createCell(row, columnCount++, record.getInputes1(), style);
			createCell(row, columnCount++, record.getInputes10(), style);
			createCell(row, columnCount++, record.getInputes2(), style);
			createCell(row, columnCount++, record.getInputes3(), style);
			createCell(row, columnCount++, record.getInputes4(), style);

			createCell(row, columnCount++, record.getInputes5(), style);
			createCell(row, columnCount++, record.getInputes7(), style);
			createCell(row, columnCount++, record.getInputes8(), style);
			createCell(row, columnCount++, record.getInputes9(), style);

		}

	}

	// executive_fileupload
	private void writeHeader1() {
		sheet1 = workbook.createSheet("executive_fileupload");

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

		for (ExecutiveSummary record : listRecords) {
			
			ObjectMapper x=new ObjectMapper();
		
			try {
				System.out.println("List==>"+x.writeValueAsString(record));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getExecutiveFileUpload().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getExecutiveFileUpload().get(0).getExecutiveFileName(), style);
			createCell(row, columnCount++, record.getExecutiveFileUpload().get(0).getExecutiveFilePath(), style);

			createCell(row, columnCount++, record.getExecutiveFileUpload().get(0).getExecutiveFileType(), style);

			createCell(row, columnCount++, record.getExecutiveFileUpload().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getExecutiveFileUpload().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getExecutiveFileUpload().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

	public void generate(HttpServletResponse response,Map<String, String> allParams) throws IOException {
		
		if("autonomous".equalsIgnoreCase(allParams.get("typeofInstitution")))
		{
		
		writeHeader();
		writeHeader1();

		write();
		write1();
		
		}

		
		if("university".equalsIgnoreCase(allParams.get("typeofInstitution")))
		{
		
		writeHeader();
		writeHeader1();

		write();
		write1();
		
		}
		if("affiliated".equalsIgnoreCase(allParams.get("typeofInstitution")))
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
