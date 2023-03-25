package com.adiverse.erp.ExcelReport;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.mapper.Mapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.adiverse.erp.model.QIAIndicatorMain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IIQAExcelGenerator {

	private List<QIAIndicatorMain> listRecords;
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

	private String[] excelHeaders = new String[] { "collegeId", "financialYear", "typeofInstitutionr" };
	private String[] excelHeaders1 = new String[] { "unique_key1","Date_of_submission", "aishe_id", "institution_trackId",
			"collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders2 = new String[] { "unique_key1", "Numberofteaching_Male", "Numberofteaching_Female",
			"Numberofteaching_Transgender", "Numberofteaching_Total", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders3 = new String[] { "unique_key1", "Application_For", "College", "Nameof_college",
			"Date_of_establishment_of_the_Institution", "Name_of_the_Head_of_the_Institution", "Designation",
			"Does_the_college_function_from_OwnCampus", "Address_of_the_College", "State_UT", "District", "City", "Pin",
			"Phone_No", "Fax_No", "Mobile_No", "Registered_Email", "Alternate_Email2",
			"Alternate_Faculty_Contact_Details", "Alternate_Address", "Alternate_StateUT", "Alternate_City",
			"Alternate_Pin", "Alternate_PhoneNo", "Alternate_FaxNo", "Alternate_MobileNo", "Alternate_Email1",
			"AlternateFaclity_Email", "Website", "Institution_graduation_of_last_two_batches", "Nature_of_the_college",
			"College_Affiliation", "Institution_recognized_under_section", "Institution_recognized_under_section_12B",
			"institution_recognised_as_Autonomous", "institution_recognised_Potential_Excellence",
			"the_institution_recognised_Excellence_UGC", "College_offering_programmes_Statutory_Regulatory_Authority,",
			"the_institution_not_affiliated_university", "institutionstatutory_cells_committees",
			"Date_establishment_IQAC", "institution_made_statutory_declaration",
			"college_have_academic_MoU_foreign_institution", "dateof_uploading", "headof_institution", "paid_details",
			"collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders4 = new String[] { "unique_key1", "State", "University_Name", "Documents", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders5 = new String[] { "unique_key1", "SRA_program ", "Document", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders6 = new String[] { "unique_key1", "Programmes ", "Number", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders7 = new String[] { "unique_key1", "Programme ", " Departmentr",
			"University_Affiliation", "SRA_Recognition", "Affiliation_Status", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders8 = new String[] { "unique_key1", "Date", "View_Document", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders9 = new String[] { "unique_key1", "Date", "View_Document", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders10 = new String[] { "unique_key1", "Nonteachingstaff_Male", "Nonteachingstaff_Female",
			"Nonteachingstaff_Transgender", "Nonteachingstaff_Total", "collegeId", "financialYear",
			"typeofInstitution" };
	private String[] excelHeaders11 = new String[] { "unique_key1", "Studentsroll_Male", "Studentsroll_Female",
			"Studentsroll_Transgender", "Studentsroll_Total", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders12 = new String[] { "unique_key1", "Cycle", "Date", "Grade", "Score", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders13 = new String[] { "unique_key1", "qia_file_name", "qia_file_path", "qia_file_type",
			"collegeId", "financialYear", "typeofInstitution" };

	public IIQAExcelGenerator(List<QIAIndicatorMain> listRecords) {
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

	private void writeHeader() {
		sheet = workbook.createSheet("qIAIndicator_Main");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders[0], style);
		createCell(row, 1, excelHeaders[1], style);
		createCell(row, 2, excelHeaders[2], style);
//		createCell(row, 3, excelHeaders[3], style);

	}

	private void write() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

		
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);
			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);

		}
	}

	

//	qia_details
	private void writeHeader1() {
		sheet1 = workbook.createSheet("qia_details");

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
//	createCell(row, 7, excelHeaders1[7], style);
//		createCell(row, 8, excelHeaders1[8], style);
//		createCell(row, 9, excelHeaders1[9], style);

	}

	private void write1() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (QIAIndicatorMain record : listRecords) {
			ObjectMapper r=new ObjectMapper();

			try {
				System.out.println("List==>"+r.writeValueAsString(record));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getqIAIndicator().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getqIAIndicator().get(0).getInputIiqaDate(), style);
			createCell(row, columnCount++, record.getqIAIndicator().get(0).getInputIiqaAisheId(), style);
			createCell(row, columnCount++, record.getqIAIndicator().get(0).getInputIiqaTrackId(), style);

			createCell(row, columnCount++, record.getqIAIndicator().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getqIAIndicator().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getqIAIndicator().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	//
	private void writeHeader2() {
		sheet2 = workbook.createSheet("qia22_details");

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
//		createCell(row, 7, excelHeaders1[7], style);
//			createCell(row, 8, excelHeaders1[8], style);
//			createCell(row, 9, excelHeaders1[9], style);

	}

	private void write2() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet2.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndicator1().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndicator1().get(0).getInputiiqa22t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator1().get(0).getInputiiqa22t2(), style);
			createCell(row, columnCount++, record.getQiaIndicator1().get(0).getInputiiqa22t3(), style);
			createCell(row, columnCount++, record.getQiaIndicator1().get(0).getInputiiqa22t4(), style);
			createCell(row, columnCount++, record.getQiaIndicator1().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getQiaIndicator1().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getQiaIndicator1().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// Ep_student22
	private void writeHeader3() {
		sheet3 = workbook.createSheet("qia1_details");

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

		createCell(row, 10, excelHeaders3[10], style);
		createCell(row, 11, excelHeaders3[11], style);
		createCell(row, 12, excelHeaders3[12], style);
		createCell(row, 13, excelHeaders3[13], style);
		createCell(row, 14, excelHeaders3[14], style);
		createCell(row, 15, excelHeaders3[15], style);
		createCell(row, 16, excelHeaders3[16], style);
		createCell(row, 17, excelHeaders3[17], style);
		createCell(row, 18, excelHeaders3[18], style);
		createCell(row, 19, excelHeaders3[19], style);

		createCell(row, 20, excelHeaders3[20], style);
		createCell(row, 21, excelHeaders3[21], style);
		createCell(row, 22, excelHeaders3[22], style);
		createCell(row, 23, excelHeaders3[23], style);
		createCell(row, 24, excelHeaders3[24], style);
		createCell(row, 25, excelHeaders3[25], style);
		createCell(row, 26, excelHeaders3[26], style);
		createCell(row, 27, excelHeaders3[27], style);
		createCell(row, 28, excelHeaders3[28], style);
		createCell(row, 29, excelHeaders3[29], style);

		createCell(row, 30, excelHeaders3[30], style);
		createCell(row, 31, excelHeaders3[31], style);
		createCell(row, 32, excelHeaders3[32], style);
		createCell(row, 33, excelHeaders3[33], style);
		createCell(row, 34, excelHeaders3[34], style);
		createCell(row, 35, excelHeaders3[35], style);
		createCell(row, 36, excelHeaders3[36], style);
		createCell(row, 37, excelHeaders3[37], style);
		createCell(row, 38, excelHeaders3[38], style);
		createCell(row, 39, excelHeaders3[39], style);

		createCell(row, 40, excelHeaders3[40], style);
		createCell(row, 41, excelHeaders3[41], style);
		createCell(row, 42, excelHeaders3[42], style);

	}

	private void write3() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet3.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa10t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa11t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa13t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa14t1(), style);

			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa15t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa16t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa17t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa18t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa19t1(), style);

			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa1t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa1t2(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa25t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa26t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa28t1(), style);

			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa29t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa2t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa30t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa31t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa32t1(), style);

			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa3t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa4t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa4t2(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa5t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa6t6(), style);

			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa6t7(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa6t8(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa6t9(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa7t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa7t10(), style);

			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa7t2(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa7t3(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa7t4(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa7t5(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa7t6(), style);

			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa7t7(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa7t8(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa7t9(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa8t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getInputiiqa9t1(), style);

			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getQiaIndicator2().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// qia12_details

	private void writeHeader4() {
		sheet4 = workbook.createSheet("qia12_details");

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

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet4.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndicator3().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndicator3().get(0).getInputiiqa12t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator3().get(0).getInputiiqa12t2(), style);
			createCell(row, columnCount++, record.getQiaIndicator3().get(0).getInputiiqa12t3(), style);

			createCell(row, columnCount++, record.getQiaIndicator3().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getQiaIndicator3().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getQiaIndicator3().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// qia18_details

	private void writeHeader5() {
		sheet5 = workbook.createSheet("qia18_details");

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

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet5.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndicator4().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndicator4().get(0).getInputiiqa18t2(), style);
			createCell(row, columnCount++, record.getQiaIndicator4().get(0).getInputiiqa18t3(), style);

			createCell(row, columnCount++, record.getQiaIndicator4().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getQiaIndicator4().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getQiaIndicator4().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// qia20_details

	private void writeHeader6() {
		sheet6 = workbook.createSheet("qia20_details");

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

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet6.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndicator5().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndicator5().get(0).getInputiiqa20t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator5().get(0).getInputiiqa20t2(), style);

			createCell(row, columnCount++, record.getQiaIndicator5().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getQiaIndicator5().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getQiaIndicator5().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// qia21_details
	private void writeHeader7() {
		sheet7 = workbook.createSheet("qia21_details");

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

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet7.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndicator6().get(0).getInputiiqa21t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator6().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndicator6().get(0).getInputiiqa21t2(), style);

			createCell(row, columnCount++, record.getQiaIndicator6().get(0).getInputiiqa21t3(), style);
			createCell(row, columnCount++, record.getQiaIndicator6().get(0).getInputiiqa21t4(), style);
			createCell(row, columnCount++, record.getQiaIndicator6().get(0).getInputiiqa21t5(), style);

			createCell(row, columnCount++, record.getQiaIndicator6().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getQiaIndicator6().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getQiaIndicator6().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// qia26_details
	private void writeHeader8() {
		sheet8 = workbook.createSheet("qia26_details");

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

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet8.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndicator7().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndicator7().get(0).getIiqa26f1(), style);
			createCell(row, columnCount++, record.getQiaIndicator7().get(0).getInputiiqa26t2(), style);

			createCell(row, columnCount++, record.getQiaIndicator7().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getQiaIndicator7().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getQiaIndicator7().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

//	  qia27_details 

	private void writeHeader9() {
		sheet9 = workbook.createSheet("qia27_details");

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

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet9.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndicator8().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndicator8().get(0).getIiqa27f1(), style);
			createCell(row, columnCount++, record.getQiaIndicator8().get(0).getInputiiqa27t1(), style);

			createCell(row, columnCount++, record.getQiaIndicator8().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getQiaIndicator8().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getQiaIndicator8().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}
	// qia23_details

	private void writeHeader10() {
		sheet10 = workbook.createSheet("qia23_details");

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

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet10.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndicator9().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndicator9().get(0).getInputiiqa23t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator9().get(0).getInputiiqa23t2(), style);
			createCell(row, columnCount++, record.getQiaIndicator9().get(0).getInputiiqa23t3(), style);
			createCell(row, columnCount++, record.getQiaIndicator9().get(0).getInputiiqa23t4(), style);

			createCell(row, columnCount++, record.getQiaIndicator9().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getQiaIndicator9().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getQiaIndicator9().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

//	qia24_details	
	private void writeHeader11() {
		sheet11 = workbook.createSheet("qia24_details");

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

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet11.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndicator10().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndicator10().get(0).getInputiiqa24t1(), style);
			createCell(row, columnCount++, record.getQiaIndicator10().get(0).getInputiiqa24t2(), style);
			createCell(row, columnCount++, record.getQiaIndicator10().get(0).getInputiiqa24t3(), style);
			createCell(row, columnCount++, record.getQiaIndicator10().get(0).getInputiiqa24t4(), style);

			createCell(row, columnCount++, record.getQiaIndicator10().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getQiaIndicator10().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getQiaIndicator10().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// qiat11_details

	private void writeHeader12() {
		sheet12 = workbook.createSheet("qiat11_details");

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

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet12.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndicator12().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndicator12().get(0).getInputiiqa1t3(), style);
			createCell(row, columnCount++, record.getQiaIndicator12().get(0).getInputiiqa1t4(), style);
			createCell(row, columnCount++, record.getQiaIndicator12().get(0).getInputiiqa1t5(), style);
			createCell(row, columnCount++, record.getQiaIndicator12().get(0).getInputiiqa1t6(), style);

			createCell(row, columnCount++, record.getQiaIndicator12().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getQiaIndicator12().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getQiaIndicator12().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// qia_indicator_fileupload

	private void writeHeader13() {
		sheet13 = workbook.createSheet("qia_indicator_fileupload");

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

		for (QIAIndicatorMain record : listRecords) {
			Row row = sheet13.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getQiaIndiactor_fileupload().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getQiaIndiactor_fileupload().get(0).getQiaFileName(), style);
			createCell(row, columnCount++, record.getQiaIndiactor_fileupload().get(0).getQiaFilePath(), style);
			createCell(row, columnCount++, record.getQiaIndiactor_fileupload().get(0).getQiaFileType(), style);

			createCell(row, columnCount++, record.getQiaIndiactor_fileupload().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getQiaIndiactor_fileupload().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getQiaIndiactor_fileupload().get(0).getCriteriaId().getTypeofInstitution(), style);

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
		writeHeader7();
		writeHeader8();
		writeHeader9();
		writeHeader10();
		writeHeader11();
		writeHeader12();
		writeHeader13();

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
			writeHeader7();
			writeHeader8();
			writeHeader9();
			writeHeader10();
			writeHeader11();
			writeHeader12();
			writeHeader13();

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
			writeHeader7();
			writeHeader8();
			writeHeader9();
			writeHeader10();
			writeHeader11();
			writeHeader12();
			writeHeader13();

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
			
		}
		
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}