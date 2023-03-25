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

import com.adiverse.erp.model.ExtendedProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtendedExcelGenerator {

	private List<ExtendedProfile> listRecords;
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

//Epprogramme
	private String[] excelHeaders1 = new String[] { "unique_key1", "programmeYear", "programmeNumber", "collegeId",
			"financialYear", "typeofInstitution" };

//Epstudent21
	private String[] excelHeaders2 = new String[] { "unique_key1", "studentYear", "studentNumberLast", "collegeId",
			"financialYear", "typeofInstitution" };

//Epstudent22
	private String[] excelHeaders3 = new String[] { "unique_key1", "studentOutgoingYear", "studentOutgoingNumber",
			"collegeId", "financialYear", "typeofInstitution" };

//Epstudent23
	private String[] excelHeaders4 = new String[] { "unique_key1", "studentAppearedexaminationYear",
			"studentAppearedexaminationNumber", "collegeId", "financialYear", "typeofInstitution" };

//Epstudent24
	private String[] excelHeaders5 = new String[] { "unique_key1", "studentRevalutionYear", "studentRevalutionNumber",
			"collegeId", "financialYear", "typeofInstitution" };

//EpAcademic31
	private String[] excelHeaders6 = new String[] { "unique_key1", "academiccourseYear", "academicprogrammerNumber",
			"collegeId", "financialYear", "typeofInstitution" };

//EpAcademic32
	private String[] excelHeaders7 = new String[] { "unique_key1", "academicfulltimeYear", "academicteacherNumber",
			"collegeId", "financialYear", "typeofInstitution" };

//EpAcademic33
	private String[] excelHeaders8 = new String[] { "unique_key1", "academicsanctionedYear", "academicsanctionedNumber",
			"collegeId", "financialYear", "typeofInstitution" };

//EpInstitution41
	private String[] excelHeaders9 = new String[] { "unique_key1", "institutionapplicationreceivedYear",
			"institionadmissionNumber", "collegeId", "financialYear", "typeofInstitution" };

//EpInstitution42
	private String[] excelHeaders10 = new String[] { "unique_key1", "institutionearnmarksYear",
			"institutioncategoryNumber", "collegeId", "financialYear", "typeofInstitution" };

//EpInstitution45
	private String[] excelHeaders11 = new String[] { "unique_key1", "totalyearexpenditureYear",
			"totalnumbersalaryNumber", "collegeId", "financialYear", "typeofInstitution" };
//ExtendedFileupload	
	
	private String[] excelHeaders12 = new String[] { "unique_key1", "executive_file_name","executive_file_path", "executive_file_type","collegeId", "financialYear", "typeofInstitution" };	
	
	
	

	public ExtendedExcelGenerator(List<ExtendedProfile> listOfRecords) {
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

	// extended

	private void writeHeader() {
		sheet = workbook.createSheet("ExtendedProfile");

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

		for (ExtendedProfile record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// ep programme(this table is epyeartable11)

	private void writeHeader1() {
		sheet1 = workbook.createSheet("Epprogramme");

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

		for (ExtendedProfile record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEpYeartable11().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEpYeartable11().get(0).getInput11y(), style);
			createCell(row, columnCount++, record.getEpYeartable11().get(0).getInput11v(), style);

			createCell(row, columnCount++, record.getEpYeartable11().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEpYeartable11().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getEpYeartable11().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// epstudent21

	private void writeHeader2() {
		sheet2 = workbook.createSheet("Epstudent21");

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

	}

	private void write2() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ExtendedProfile record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet2.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEpYeartable21().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEpYeartable21().get(0).getInput21y(), style);
			createCell(row, columnCount++, record.getEpYeartable21().get(0).getInput21v(), style);

			createCell(row, columnCount++, record.getEpYeartable21().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEpYeartable21().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getEpYeartable21().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// epstudent22

	private void writeHeader3() {
		sheet3 = workbook.createSheet("Epstudent22");

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

		for (ExtendedProfile record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet3.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEpYeartable22().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEpYeartable22().get(0).getInput22y(), style);
			createCell(row, columnCount++, record.getEpYeartable22().get(0).getInput22v(), style);
			createCell(row, columnCount++, record.getEpYeartable22().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEpYeartable22().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getEpYeartable22().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// epstudent23

	private void writeHeader4() {
		sheet4 = workbook.createSheet("Epstudent23");

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

	}

	private void write4() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ExtendedProfile record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet4.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEpYeartable23().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEpYeartable23().get(0).getInput23y(), style);
			createCell(row, columnCount++, record.getEpYeartable23().get(0).getInput23v(), style);
			createCell(row, columnCount++, record.getEpYeartable23().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEpYeartable23().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getEpYeartable23().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// epstudent24

	private void writeHeader5() {
		sheet5 = workbook.createSheet("Epstudent24");

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

		for (ExtendedProfile record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet5.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEpYeartable24().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEpYeartable24().get(0).getInput24y(), style);
			createCell(row, columnCount++, record.getEpYeartable24().get(0).getInput24v(), style);
			createCell(row, columnCount++, record.getEpYeartable24().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEpYeartable24().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getEpYeartable24().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// epacedemic 31

	private void writeHeader6() {
		sheet6 = workbook.createSheet("EpAcademic31");

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

		for (ExtendedProfile record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet6.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEpYeartable31().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEpYeartable31().get(0).getInput31y(), style);
			createCell(row, columnCount++, record.getEpYeartable31().get(0).getInput31v(), style);
			createCell(row, columnCount++, record.getEpYeartable31().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEpYeartable31().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getEpYeartable31().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// epacedemic 32

	private void writeHeader7() {
		sheet7 = workbook.createSheet("EpAcademic32");

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

		for (ExtendedProfile record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet7.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEpYeartable32().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEpYeartable32().get(0).getInput32y(), style);
			createCell(row, columnCount++, record.getEpYeartable32().get(0).getInput32v(), style);
			createCell(row, columnCount++, record.getEpYeartable32().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEpYeartable32().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getEpYeartable32().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// epacedemic 33

	private void writeHeader8() {
		sheet8 = workbook.createSheet("EpAcademic33");

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

		for (ExtendedProfile record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet8.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEpYeartable33().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEpYeartable33().get(0).getInput33y(), style);
			createCell(row, columnCount++, record.getEpYeartable33().get(0).getInput33v(), style);
			createCell(row, columnCount++, record.getEpYeartable33().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEpYeartable33().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getEpYeartable33().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// epinstitution41

	private void writeHeader9() {
		sheet9 = workbook.createSheet("EpInstitution41");

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

		for (ExtendedProfile record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet9.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEpYeartable41().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEpYeartable41().get(0).getInput41y(), style);
			createCell(row, columnCount++, record.getEpYeartable41().get(0).getInput41v(), style);
			createCell(row, columnCount++, record.getEpYeartable41().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEpYeartable41().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getEpYeartable41().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// epinstitution42

	private void writeHeader10() {
		sheet10 = workbook.createSheet("EpInstitution42");

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

		for (ExtendedProfile record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet10.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEpYeartable42().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEpYeartable42().get(0).getInput42y(), style);
			createCell(row, columnCount++, record.getEpYeartable42().get(0).getInput42v(), style);
			createCell(row, columnCount++, record.getEpYeartable42().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEpYeartable42().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getEpYeartable42().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}
	
	//epinstitution45
	
	private void writeHeader11() {
		sheet11 = workbook.createSheet("EpInstitution45");

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

		for (ExtendedProfile record : listRecords) {

			ObjectMapper e = new ObjectMapper();
			try {
				System.out.println("List==>" + e.writeValueAsString(record));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Row row = sheet11.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEpYeartable45().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEpYeartable45().get(0).getInput45y(), style);
			createCell(row, columnCount++, record.getEpYeartable45().get(0).getInput45v(), style);
			createCell(row, columnCount++, record.getEpYeartable45().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEpYeartable45().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getEpYeartable45().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}
	
	
	//extendedfileupload
	
		private void writeHeader12() {
			sheet12 = workbook.createSheet("ExtendedFileupload");

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

			for (ExtendedProfile record : listRecords) {

				ObjectMapper e = new ObjectMapper();
				try {
					System.out.println("List==>" + e.writeValueAsString(record));
				} catch (JsonProcessingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Row row = sheet12.createRow(rowCount++);
				int columnCount = 0;

				createCell(row, columnCount++, record.getExtendedFileupload().get(0).getUniqueKey1(), style);
				createCell(row, columnCount++, record.getExtendedFileupload().get(0).getExtendedFileName(), style);
				createCell(row, columnCount++, record.getExtendedFileupload().get(0).getExtendedFilePath(), style);
				createCell(row, columnCount++, record.getExtendedFileupload().get(0).getExtendedFileType(), style);

				createCell(row, columnCount++, record.getExtendedFileupload().get(0).getCriteriaId().getCollegeId(), style);
				createCell(row, columnCount++, record.getExtendedFileupload().get(0).getCriteriaId().getFinancialYear(), style);
				createCell(row, columnCount++, record.getExtendedFileupload().get(0).getCriteriaId().getTypeofInstitution(),
						style);

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
		
			
			

		}

		if ("affiliated".equalsIgnoreCase(allParams.get("typeofInstitution"))) 
		{
			writeHeader1();
			writeHeader3();
			writeHeader4();
			writeHeader12();
			
			write1();
			write3();
			write4();
			write12();
			
		}

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
