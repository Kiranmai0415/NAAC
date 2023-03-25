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
import com.adiverse.erp.model.Criteria7_FieldInfo;

public class Criteria7ExcelGenerator1 {

	private List<Criteria7_FieldInfo> listRecords;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFSheet sheet1;
	private XSSFSheet sheet2;
	private XSSFSheet sheet3;
	private XSSFSheet sheet4;

	private XSSFSheet sheet5;


	private String[] excelHeaders = new String[] { "collegeId", "financialYear", "typeofInstitution" };
	
	//criteria71ql
	private String[] excelHeaders1 = new String[] { "unique_key1", "responseValue711", "input711t1", "responseValue718",
			"input718t1", "responseValue719", "input719t1", "responseValue7111", "input7111t1", "collegeId", "financialYear", "typeofInstitution" };
//criteria71qn
	
	private String[] excelHeaders2 = new String[] { "unique_key1", "responseValue712", "input712t1", "responseValue713",
			"input713t1", "responseValu714", "input714t1", "responseValue715", "input715t1", "responseValue716","input716t1", "responseValue717",
"input717t1", "responseValue7110", "input7110t1", "collegeId", "financialYear", "typeofInstitution" };
	
	//criteria72ql
	private String[] excelHeaders3 = new String[] { "unique_key1", "responseValue721", "input721t1","collegeId", "financialYear", "typeofInstitution" };

	//criteria73ql
		private String[] excelHeaders4 = new String[] { "unique_key1", "responseValue731", "input731t1","collegeId", "financialYear", "typeofInstitution" };

	
	
	private String[] excelHeaders5 = new String[] { "unique_key1", "criteria7_file_name", "criteria7_file_path",
			"criteria7_file_type", "collegeId", "financialYear", "typeofInstitution" };

	public Criteria7ExcelGenerator1(List<Criteria7_FieldInfo> listRecords) {
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

//		 criteria7_fieldinfo

	private void writeHeader() {
		sheet = workbook.createSheet("criteria7_fieldinfo");

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

		for (Criteria7_FieldInfo record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);

		}

	}
	
	
	// criteria71Ql
	private void writeHeader1() {
		sheet1 = workbook.createSheet("Criteria71Ql");

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
		
		createCell(row, 7, excelHeaders1[0], style);
		createCell(row, 8, excelHeaders1[1], style);
		createCell(row, 9, excelHeaders1[2], style);
		createCell(row, 10, excelHeaders1[3], style);
		createCell(row, 11, excelHeaders1[4], style);
		createCell(row, 12, excelHeaders1[5], style);

	}

	private void write1() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Criteria7_FieldInfo record : listRecords) {
			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getResponse711(), style);
			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getInput711t1(), style);
			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getResponse718(), style);
			
			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getInput718t1(), style);
			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getResponse719(), style);
			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getInput719t1(), style);
			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getResponse7111(), style);
			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getInput7111t1(), style);

			
			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
		}
	}
	
	
	
	// criteria71Qn
		private void writeHeader2() {
			sheet2 = workbook.createSheet("Criteria71Qn");

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
			
			createCell(row, 7, excelHeaders1[0], style);
			createCell(row, 8, excelHeaders1[1], style);
			createCell(row, 9, excelHeaders1[2], style);
			createCell(row, 10, excelHeaders1[3], style);
			createCell(row, 11, excelHeaders1[4], style);
			createCell(row, 12, excelHeaders1[5], style);
			
			createCell(row, 13, excelHeaders1[2], style);
			createCell(row, 14, excelHeaders1[3], style);
			createCell(row, 15, excelHeaders1[4], style);
			createCell(row, 16, excelHeaders1[5], style);

		}

		private void write2() {
			int rowCount = 1;

			CellStyle style = workbook.createCellStyle();
			XSSFFont font = workbook.createFont();
			font.setFontHeight(14);
			style.setFont(font);

			for (Criteria7_FieldInfo record : listRecords) {
				Row row = sheet2.createRow(rowCount++);
				int columnCount = 0;
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getUniqueKey1(), style);
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse712(), style);
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput712t1(), style);
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse713(), style);
				
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput713t1(), style);
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse714(), style);
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse715(), style);
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput715t1(), style);
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse716(), style);
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput716t1(), style);
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse717(), style);
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput717t1(), style);
				
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse7110(), style);
				createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput7110t1(), style);

				
				createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
				createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
				createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
			}
		}
		
	
		// criteria72Ql
				private void writeHeader3() {
					sheet3= workbook.createSheet("Criteria72Ql");

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

					for (Criteria7_FieldInfo record : listRecords) {
						Row row = sheet3.createRow(rowCount++);
						int columnCount = 0;
						createCell(row, columnCount++, record.getCriteria72Ql().get(0).getUniqueKey1(), style);
						createCell(row, columnCount++, record.getCriteria72Ql().get(0).getResponse721(), style);
						createCell(row, columnCount++, record.getCriteria72Ql().get(0).getInput721t1(), style);
						
						
						createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
						createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
						createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
					}
				}
				
	
	
				// criteria73Ql
				private void writeHeader4() {
					sheet4 = workbook.createSheet("Criteria73Ql");

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

					for (Criteria7_FieldInfo record : listRecords) {
						Row row = sheet4.createRow(rowCount++);
						int columnCount = 0;
						createCell(row, columnCount++, record.getCriteria73Ql().get(0).getUniqueKey1(), style);
						createCell(row, columnCount++, record.getCriteria73Ql().get(0).getResponse731(), style);
						createCell(row, columnCount++, record.getCriteria73Ql().get(0).getInput731t1(), style);
						
						
						createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
						createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
						createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
					}
				}
				
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

////		criteria7Ql_fieldinfo
//
//	private void writeHeader1() {
//		sheet1 = workbook.createSheet("criteria7Ql_fieldinfo");
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
//		for (Criteria7_FieldInfo record : listRecords) {
//			Row row = sheet1.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getInput7111t1(), style);
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getInput711t1(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput713t1(), style);
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getInput718t1(), style);
//
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getInput719t1(), style);
//			createCell(row, columnCount++, record.getCriteria72Ql().get(0).getInput721t1(), style);
//			createCell(row, columnCount++, record.getCriteria73Ql().get(0).getInput731t1(), style);
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getResponse711(), style);
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getResponse7111(), style);
//
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse713(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse714(), style);
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getResponse718(), style);
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getResponse719(), style);
//			createCell(row, columnCount++, record.getCriteria72Ql().get(0).getResponse721(), style);
//			createCell(row, columnCount++, record.getCriteria73Ql().get(0).getResponse731(), style);
//
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getCriteriaId().getCollegeId(),
//					style);
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getCriteria71Ql().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}
//
////		Criteria5 Criteria7_FieldInfoQn
//
//	private void writeHeader2() {
//		sheet2 = workbook.createSheet("Criteria7_FieldInfoQn");
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
//		for (Criteria7_FieldInfo record : listRecords) {
//			Row row = sheet2.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput7110t1(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput712t1(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput713t1(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput714t1(), style);
//
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput715t1(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput716t1(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getInput717t1(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse7110(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse712(), style);
//
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse713(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse714(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse715(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse716(), style);
//			createCell(row, columnCount++, record.getCriteria71Qn().get(0).getResponse717(), style);
//
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getCriteriaId().getCollegeId(),
//					style);
//			createCell(row, columnCount++, record.getCriteria71Ql().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getCriteria71Ql().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}

//		Criteria5_FileUpload

	private void writeHeader5() {
		sheet5 = workbook.createSheet("criteria7_fileupload");

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

		for (Criteria7_FieldInfo record : listRecords) {
			Row row = sheet5.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteria7FileUpload().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCriteria7FileUpload().get(0).getCriteria7FileName(), style);
			createCell(row, columnCount++, record.getCriteria7FileUpload().get(0).getCriteria7FilePath(), style);
			createCell(row, columnCount++, record.getCriteria7FileUpload().get(0).getCriteria7FileType(), style);

			createCell(row, columnCount++, record.getCriteria7FileUpload().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getCriteria7FileUpload().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getCriteria7FileUpload().get(0).getCriteriaId().getTypeofInstitution(), style);

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


		write();
		write1();
		write2();
		write3();
		write4();
		write5();
		
		}
		
		if ("university".equalsIgnoreCase(allParams.get("typeofInstitution"))) {
			
			writeHeader();
			writeHeader1();
			writeHeader2();
			writeHeader3();
			writeHeader4();
			writeHeader5();


			write();
			write1();
			write2();
			write3();
			write4();
			write5();
			
			
		}
		
       if ("affiliated".equalsIgnoreCase(allParams.get("typeofInstitution"))) {
			
			writeHeader();
			writeHeader1();
			writeHeader2();
			writeHeader3();
			writeHeader4();
			writeHeader5();


			write();
			write1();
			write2();
			write3();
			write4();
			write5();
			
			
		}
		
		

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
