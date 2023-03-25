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

import com.adiverse.erp.model.ProfileoftheCollege;

public class ProfileOftheCollegeExcelGenerator {

	private List<ProfileoftheCollege> listRecords;
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
	//private XSSFSheet sheet26;
//	private XSSFSheet sheet27;
	private XSSFSheet sheet28;
	private XSSFSheet sheet29;
	//private XSSFSheet sheet30;
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
	private XSSFSheet sheet46;
	private XSSFSheet sheet47;
	//private XSSFSheet sheet48;
	private XSSFSheet sheet49;
	private XSSFSheet sheet50;

	private String[] excelHeaders = new String[] { "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders1 = new String[] { "unique_key1", "typeofstudents", "enrollment_ug", "enrollment_pg",
			"enrollment_mphil", "enrollment_phd", "enrollment_total", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders2 = new String[] { "unique_key1", "Name", "Address", "City", "Pin", "state_status",
			"Website", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders3 = new String[] { "unique_key1", "Contacts_Designation", "Contacts_Name",
			"telephone_code", "contacts_mobile", "contacts_fax", "contacts_email", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders4 = new String[] { "unique_key1", "college_constituent", "typeof_gender", "by_gender",
			"by_shift", "minority_institution", "sourceof_finding", "dateof_establishment", "governsof_college",
			"act_provide", "college_applied", "college_potential", "dateof_recognition", "governmental_agency",
			"nameof_agency", "recognition", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders5 = new String[] { "unique_key1", "datemonthyear", "remarks", "collegeId",
			"financialYear", "typeofInstitution" };
	private String[] excelHeaders6 = new String[] { "unique_key1", "recognitionRegulatory", "recognitionApproval",
			"daymonthyear", "validityinmonths", "remarks", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders7 = new String[] { "unique_key1", "location", "campus_area", "builtup_area",
			"collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders8 = new String[] { "unique_key1", "sino", "Level_of_Programme",
			"Name_of_Programme_Course", "Duration_of_Months", "Entry_Qualification", "Medium_of_Instruction",
			"Sanctioned_Strength", "No_Of_Students_Admitted", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders9 = new String[] { "unique_key1", "selffinanced_offered", "newprogrammes_introduced",
			"collegeId", "financialYear", "typeofInstitution" };
	
	private String[] excelHeaders10 = new String[] { "unique_key1", "faculty", "departments", "ug", "pg", "research",
			"collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders11 = new String[] { "unique_key1", "position", "Professior_male", "Professior_Female",
			"AssociateProfessior_male", "AssociateProfessior_Female", "AssistantProfessior_male",
			"AssistantProfessior_Female", "nonteaching_staff", "technical_staff", "collegeId", "financialYear",
			"typeofInstitution" };
	private String[] excelHeaders12 = new String[] { "unique_key1", "highest_qualification", "Professior_male",
			"Professior_Female", "AssociateProfessior_male", "AssociateProfessior_Female ", "AssistantProfessior_male",
			"AssistantProfessior_Female", "total", "visiting_faculty", "collegeId", "financialYear",
			"typeofInstitution" };
	private String[] excelHeaders13 = new String[] { "unique_key1", "unitcostof_education", "salary_component",
			"excluding_component", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders14 = new String[] { "unique_key1", "accrediation_cycle1", "accrediation_cycle1",
			"accrediation_cycle3", "accrediation_cycle4", "accrediation_result1", "accrediation_result2",
			"accrediation_result3", "accrediation_result4", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders15 = new String[] { "unique_key1", "accrediation_iqac", "accrediation_aqar1",
			"accrediation_aqar2", "accrediation_aqar3", "accrediation_aqar4", "collegeId", "financialYear",
			"typeofInstitution" };
	private String[] excelHeaders16 = new String[] { "unique_key1", "year1_male", "year1_female", "year2_male",
			"year2_female", "year3_male", "year3_female", "year4_male", "year4_female", "collegeId", "financialYear",
			"typeofInstitution" };
	private String[] excelHeaders17 = new String[] { "unique_key1", "year", "programmes_no", "programmes_name",
			"programs_ug", "programs_pg", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders18 = new String[] { "unique_key1", "ugcpotentialfor_excellence", "CPE",
			"dateofrecognition_date", "government_agency", "nametheagency_name", "recognition_date", "collegeId",
			"financialYear", "typeofInstitution" };
	private String[] excelHeaders19 = new String[] { "unique_key1", "campustype", "campusaddress", "campuslocation",
			"campusareainacres", "builtupareainsqmts", "campus_programmesoffered", "campus_establishmentdate",
			"dateof_recognition", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders20 = new String[] { "unique_key1", "Contract", "Professior_male", "Professior_Female",
			"Professior_Others", "Professior_Total", "AssociateProfessior_male", "AssociateProfessior_Female",
			"AssociateProfessior_Others", "AssociateProfessior_Total", "AssistantProfessior_male",
			"AssistantProfessior_Female", "AssistantProfessior_Others", "AssistantProfessior_Total", "collegeId",
			"financialYear", "typeofInstitution" };
	private String[] excelHeaders21 = new String[] { "unique_key1", "enrolledProgramme", "locatedCollege",
			"statesOfindia", "nriStudents", "foreignStudents", "enrolledTotal", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders22 = new String[] { "unique_key1", "admittedProgramme", "year1", "year2", "year3",
			"year4", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders23 = new String[] { "unique_key1", "dname_1", "dname_2", "dname_3", "dname_4",
			"collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders24 = new String[] { "unique_key1", "evaluative_fileName", "evaluative_filePath",
			"evaluate_fileType", "collegeId", "financialYear", "typeofInstitution" };
//	private String[] excelHeaders26 = new String[] { "unique_key1", "college_type", "permanent_affiliation",
//			"temporary_affiliation", "collegeId", "financialYear", "typeofInstitution" };
//	private String[] excelHeaders27 = new String[] { "unique_key1", "auniversityaffiliated1", "permanent", "temporary",
//			"total", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders28 = new String[] { "unique_key1", "constituent_colleges", "affiliated_colleges",
			"colleges_under2f", "colleges_under2fand12b", "naacaccredited_colleges", "potential_excellence",
			"autonomous_colleges", "postgraduate_departments", "research_departments", "research_institutes",
			"regulatory_authority", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders29 = new String[] { "unique_key1", "academicians_male", "academicians_female",
			"academicians_others", "academicians_total", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders30 = new String[] { "unique_key1", "integrated_programmes", "university_located",
			"statesof_india", "nri_students", "foreign_students", "total", "total_integratedprogrammes",
			"numberof_integration", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders31 = new String[] { "unique_key1", "yearof_establishment", "orientation_programmes",
			"refresher_course", "own_programmes", "programmes_conducted", "collegeId", "financialYear",
			"typeofInstitution" };
	private String[] excelHeaders32 = new String[] { "unique_key1", "sino", "nameof_department", "nameof_chair",
			"nameof_sponsororaganisation", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders33 = new String[] { "unique_key1", "programme_offred", "aided", "self_financed",
			"collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders34 = new String[] { "unique_key1", "professional_offered", "professional_offered1",
			"professional_offered2", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders35 = new String[] { "unique_key1", "recogized_minority", "specify_minority",
			"religious", "linguistic", "any_other", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders36 = new String[] { "unique_key1", "UGC_OF_2f", "UGC_OF_12B", "collegeId",
			"financialYear", "typeofInstitution" };

	private String[] excelHeaders37 = new String[] { "unique_key1", "Visting_Male", "Visting_Female", "Visting_Others",
			"Visting_Total", "collegeId", "financialYear", "typeofInstitution" };
	private String[] excelHeaders38 = new String[] { "unique_key1", "Non_teaching_male", "Non_teaching_Female",
			"Non_teaching_Others", "Non_teaching_Total", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders39 = new String[] { "unique_key1", "Technical_male", "Technical_Female",
			"Technical_Others", "Technical_Total", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders40 = new String[] { "unique_key1", "permanent_professor_male",
			"permanent_professor_female", "permanent_professor_others", "permanent_associate_male",
			"permanent_associate_female", "permanent_associate_others", "permanent_assistant_male",
			"permanent_assistant_female", "permanent_assistant_others", "permanent_total", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders41 = new String[] { "unique_key1", "temporary_professor_male",
			"temporary_professor_female", "temporary_professor_others", "temporary_associate_male",
			"temporary_associate_female", "temporary_associate_others", "temporary_assistant_male",
			"temporary_assistant_female", "temporary_assistant_others", "temporary_total", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders42 = new String[] { "unique_key1", "parttime_professor_male",
			"parttime_professor_female", "parttime_professor_others", "parttime_associate_male",
			"parttime_associate_female", "parttime_associate_others", "parttime_assistant_male",
			"parttime_assistant_female", "parttime_assistant_others", "parttime_total", "collegeId", "financialYear",
			"typeofInstitution" };

	private String[] excelHeaders43 = new String[] { "unique_key1", "institution_state", "institution_name",
			"view_Document", "collegeId", "financialYear", "typeofInstitution" };

	private String[] excelHeaders44 = new String[] { "unique_key1", "institution_status", "By_gender", "By_Shift",
			"Dateof_Establishment", "Dateof_grant", "Establishment_date", "collegeId", "financialYear",
			"typeofInstitution" };



	private String[] excelHeaders45= new String[] {"unique_key1","college_type","permanent_affiliation","Skill_development","temporary_affiliation"
			,  "collegeId", "financialYear","typeofInstitution"};

	private String[] excelHeaders46 = new String[] {"unique_key1","auniversityaffiliated1","permanent","temporary","total"
			,  "collegeId", "financialYear","typeofInstitution"};


	private String[] excelHeaders47 = new String[] {"unique_key1","constituent_colleges","affiliated_colleges","colleges_under2f","colleges_under2fand12b"
			,"naacaccredited_colleges","potential_excellence","autonomous_colleges","postgraduate_departments","research_departments","research_institutes","regulatory_authority"	,  "collegeId", "financialYear","typeofInstitution"};

//	private String[] excelHeaders48 = new String[] {"unique_key1","academicians_male","academicians_female","academicians_others","academicians_total"
//			,  "collegeId", "financialYear","typeofInstitution"};


	private String[] excelHeaders49 = new String[] {"unique_key1","integrated_programmes","university_located","statesof_india","nri_students"
		,"foreign_students","total","total_integratedprogrammes","numberof_integration"	,  "collegeId", "financialYear","typeofInstitution"};



	private String[] excelHeaders50 = new String[] {"unique_key1","yearof_establishment","orientation_programmes","refresher_course","own_programmes"
		,"programmes_conducted"	,  "collegeId", "financialYear","typeofInstitution"};

//	private String[] excelHeaders51= new String[] {"unique_key1","yearof_establishment","orientation_programmes","refresher_course","own_programmes"
//			,"programmes_conducted"	,  "collegeId", "financialYear","typeofInstitution"};


	public ProfileOftheCollegeExcelGenerator(List<ProfileoftheCollege> listRecords) {
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

	// ProfileoftheCollege CriteriaPrimaryKey

	private void writeHeader() {
		sheet = workbook.createSheet("Profile_oftheCollege");

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// AffiliatedEnrollment
	private void writeHeader1() {
		sheet1 = workbook.createSheet("affiliated_enrollment");

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

	}

	private void write1() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet1.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedEnrollment().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedEnrollment().get(0).getInputet1(), style);
			createCell(row, columnCount++, record.getAffiliatedEnrollment().get(0).getInputet2(), style);
			createCell(row, columnCount++, record.getAffiliatedEnrollment().get(0).getInputet3(), style);
			createCell(row, columnCount++, record.getAffiliatedEnrollment().get(0).getInputet4(), style);

			createCell(row, columnCount++, record.getAffiliatedEnrollment().get(0).getInputet5(), style);
			createCell(row, columnCount++, record.getAffiliatedEnrollment().get(0).getInputet6(), style);

			createCell(row, columnCount++, record.getAffiliatedEnrollment().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getAffiliatedEnrollment().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedEnrollment().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

	// BasicProfile
	private void writeHeader2() {
		sheet2 = workbook.createSheet("basic_profile");

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet2.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getBasicProfile().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getBasicProfile().get(0).getInputbt1(), style);
			createCell(row, columnCount++, record.getBasicProfile().get(0).getInputbt2(), style);
			createCell(row, columnCount++, record.getBasicProfile().get(0).getInputbt3(), style);
			createCell(row, columnCount++, record.getBasicProfile().get(0).getInputbt4(), style);

			createCell(row, columnCount++, record.getBasicProfile().get(0).getInputbt5(), style);
			createCell(row, columnCount++, record.getBasicProfile().get(0).getInputbt6(), style);

			createCell(row, columnCount++, record.getBasicProfile().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getBasicProfile().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getBasicProfile().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// ContactsforCommunication
	private void writeHeader3() {
		sheet3 = workbook.createSheet("contacts_forCommunication");

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet3.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getContactsforCommunication().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getContactsforCommunication().get(0).getInputbtc1(), style);
			createCell(row, columnCount++, record.getContactsforCommunication().get(0).getInputbtc2(), style);
			createCell(row, columnCount++, record.getContactsforCommunication().get(0).getInputbtc3(), style);
			createCell(row, columnCount++, record.getContactsforCommunication().get(0).getInputbtc4(), style);

			createCell(row, columnCount++, record.getContactsforCommunication().get(0).getInputbtc5(), style);
			createCell(row, columnCount++, record.getContactsforCommunication().get(0).getInputbtc6(), style);

			createCell(row, columnCount++, record.getContactsforCommunication().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getContactsforCommunication().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getContactsforCommunication().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Criteria2 affiliated_status -1

	private void writeHeader4() {
		sheet4 = workbook.createSheet("affiliated_status");

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
		createCell(row, 11, excelHeaders4[11], style);
		createCell(row, 12, excelHeaders4[12], style);
		createCell(row, 13, excelHeaders4[13], style);
		createCell(row, 14, excelHeaders4[14], style);

		createCell(row, 15, excelHeaders4[15], style);
		createCell(row, 16, excelHeaders4[16], style);
		createCell(row, 17, excelHeaders4[17], style);
		createCell(row, 18, excelHeaders4[18], style);

		
	}

	private void write4() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet4.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst1(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst11(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst12(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst13(), style);

			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst14(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst15(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst16(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst17(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst2(), style);

			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst3(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst4(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst5(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst6(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst7(), style);

			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getInputst8(), style);

			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++, record.getAffiliatedStatus().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// DetailsofUgcRecognition

	private void writeHeader5() {
		sheet5 = workbook.createSheet("detailsofUgc_recognition");

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet5.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getDetailsofUgcRecognition().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getDetailsofUgcRecognition().get(0).getInputst10(), style);
			createCell(row, columnCount++, record.getDetailsofUgcRecognition().get(0).getInputst9(), style);

			createCell(row, columnCount++, record.getDetailsofUgcRecognition().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getDetailsofUgcRecognition().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getDetailsofUgcRecognition().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// recognition

	private void writeHeader6() {
		sheet6 = workbook.createSheet("recognition");

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
		createCell(row, 8, excelHeaders6[8], style);

	}

	private void write6() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet6.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getRecognition().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getRecognition().get(0).getInputbtd11(), style);
			createCell(row, columnCount++, record.getRecognition().get(0).getInputbtd12(), style);
			createCell(row, columnCount++, record.getRecognition().get(0).getInputbtd13(), style);
			createCell(row, columnCount++, record.getRecognition().get(0).getInputbtd14(), style);

			createCell(row, columnCount++, record.getRecognition().get(0).getInputbtd15(), style);

			createCell(row, columnCount++, record.getRecognition().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getRecognition().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getRecognition().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// affiliated_campus
	private void writeHeader7() {
		sheet7 = workbook.createSheet("affiliated_campus");

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet7.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedCampus().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedCampus().get(0).getInputst18(), style);
			createCell(row, columnCount++, record.getAffiliatedCampus().get(0).getInputst19(), style);
			createCell(row, columnCount++, record.getAffiliatedCampus().get(0).getInputst20(), style);

			createCell(row, columnCount++, record.getAffiliatedCampus().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getAffiliatedCampus().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++, record.getAffiliatedCampus().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// Criteria3 academic -5

	private void writeHeader8() {
		sheet8 = workbook.createSheet("academic");

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

	}

	private void write8() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet8.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAcademicinformation().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAcademicinformation().get(0).getInputad1(), style);
			createCell(row, columnCount++, record.getAcademicinformation().get(0).getInputad11(), style);
			createCell(row, columnCount++, record.getAcademicinformation().get(0).getInputad12(), style);
			createCell(row, columnCount++, record.getAcademicinformation().get(0).getInputad13(), style);

			createCell(row, columnCount++, record.getAcademicinformation().get(0).getInputad14(), style);
			createCell(row, columnCount++, record.getAcademicinformation().get(0).getInputad15(), style);
			createCell(row, columnCount++, record.getAcademicinformation().get(0).getInputad16(), style);
			createCell(row, columnCount++, record.getAcademicinformation().get(0).getInputad17(), style);

			createCell(row, columnCount++, record.getAcademicinformation().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getAcademicinformation().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getAcademicinformation().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Criteria3 affiliated_Programmes -6

	private void writeHeader9() {
		sheet9 = workbook.createSheet("affiliated_Programmes");

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet9.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedProgrammes().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedProgrammes().get(0).getInputpt1(), style);
			createCell(row, columnCount++, record.getAffiliatedProgrammes().get(0).getInputpt2(), style);

			createCell(row, columnCount++, record.getAffiliatedProgrammes().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getAffiliatedProgrammes().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedProgrammes().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Criteria2 affiliated_department

	private void writeHeader10() {
		sheet10 = workbook.createSheet("affiliated_department");

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

		createCell(row, 6, excelHeaders10[6], style);
		createCell(row, 7, excelHeaders10[7], style);
		createCell(row, 8, excelHeaders10[8], style);

	}

	private void write10() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet10.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedDepartment().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedDepartment().get(0).getInputdt1(), style);
			createCell(row, columnCount++, record.getAffiliatedDepartment().get(0).getInputdt2(), style);
			createCell(row, columnCount++, record.getAffiliatedDepartment().get(0).getInputdt3(), style);
			createCell(row, columnCount++, record.getAffiliatedDepartment().get(0).getInputdt4(), style);
			createCell(row, columnCount++, record.getAffiliatedDepartment().get(0).getInputdt5(), style);

			createCell(row, columnCount++, record.getAffiliatedDepartment().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getAffiliatedDepartment().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedDepartment().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Criteria2 getAffiliatedDepartment

	private void writeHeader11() {
		sheet11 = workbook.createSheet("affiliated_institution");

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
		createCell(row, 7, excelHeaders11[7], style);
		createCell(row, 8, excelHeaders11[8], style);
		createCell(row, 9, excelHeaders11[9], style);
		createCell(row, 10, excelHeaders11[10], style);

		createCell(row, 11, excelHeaders11[11], style);
		createCell(row, 12, excelHeaders11[12], style);
		// createCell(row, 13, excelHeaders11[13], style);

	}

	private void write11() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet11.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedInstitution().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedInstitution().get(0).getInputatt1(), style);
			createCell(row, columnCount++, record.getAffiliatedInstitution().get(0).getInputatt2(), style);
			createCell(row, columnCount++, record.getAffiliatedInstitution().get(0).getInputatt3(), style);
			createCell(row, columnCount++, record.getAffiliatedInstitution().get(0).getInputatt4(), style);

			createCell(row, columnCount++, record.getAffiliatedInstitution().get(0).getInputatt5(), style);
			createCell(row, columnCount++, record.getAffiliatedInstitution().get(0).getInputatt6(), style);
			createCell(row, columnCount++, record.getAffiliatedInstitution().get(0).getInputatt7(), style);
			createCell(row, columnCount++, record.getAffiliatedInstitution().get(0).getInputatt8(), style);

			createCell(row, columnCount++, record.getAffiliatedInstitution().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getAffiliatedInstitution().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedInstitution().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}
	// Criteria2

	private void writeHeader12() {
		sheet12 = workbook.createSheet("affiliated_teachingstaff");

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
		createCell(row, 7, excelHeaders12[7], style);
		createCell(row, 8, excelHeaders12[8], style);
		createCell(row, 9, excelHeaders12[9], style);

		createCell(row, 10, excelHeaders12[10], style);
		createCell(row, 11, excelHeaders12[11], style);
		createCell(row, 12, excelHeaders12[12], style);

	}

	private void write12() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet12.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedTeachingstaff().get(0).getUniqueKey1(), style);
			//createCell(row, columnCount++, record.getAffiliatedTeachingstaff().get(0).getInputatg1(), style);
			createCell(row, columnCount++, record.getAffiliatedTeachingstaff().get(0).getInputats1(), style);
			createCell(row, columnCount++, record.getAffiliatedTeachingstaff().get(0).getInputats2(), style);
			createCell(row, columnCount++, record.getAffiliatedTeachingstaff().get(0).getInputats3(), style);

			createCell(row, columnCount++, record.getAffiliatedTeachingstaff().get(0).getInputats4(), style);
			createCell(row, columnCount++, record.getAffiliatedTeachingstaff().get(0).getInputats5(), style);
			createCell(row, columnCount++, record.getAffiliatedTeachingstaff().get(0).getInputats6(), style);
			createCell(row, columnCount++, record.getAffiliatedTeachingstaff().get(0).getInputats7(), style);
			createCell(row, columnCount++, record.getAffiliatedTeachingstaff().get(0).getInputatso(), style);

			createCell(row, columnCount++, record.getAffiliatedTeachingstaff().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedTeachingstaff().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedTeachingstaff().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Criteria3 affiliated_education

	private void writeHeader13() {
		sheet13 = workbook.createSheet("affiliated_education");

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
		createCell(row, 6, excelHeaders13[6], style);

	}

	private void write13() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet13.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedEducation().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedEducation().get(0).getInputct1(), style);
			createCell(row, columnCount++, record.getAffiliatedEducation().get(0).getInputct2(), style);
			createCell(row, columnCount++, record.getAffiliatedEducation().get(0).getInputct3(), style);

			createCell(row, columnCount++, record.getAffiliatedEducation().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getAffiliatedEducation().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedEducation().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Criteria2 affiliated_accrediation

	private void writeHeader14() {
		sheet14 = workbook.createSheet("affiliated_accrediation");

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
		createCell(row, 7, excelHeaders14[7], style);

		createCell(row, 8, excelHeaders14[8], style);
		createCell(row, 9, excelHeaders14[9], style);
		createCell(row, 10, excelHeaders14[10], style);
		createCell(row, 11, excelHeaders14[11], style);

	}

	private void write14() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet14.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedAccrediation().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedAccrediation().get(0).getInputat1(), style);
			createCell(row, columnCount++, record.getAffiliatedAccrediation().get(0).getInputat2(), style);
			createCell(row, columnCount++, record.getAffiliatedAccrediation().get(0).getInputat3(), style);
			createCell(row, columnCount++, record.getAffiliatedAccrediation().get(0).getInputat4(), style);

			createCell(row, columnCount++, record.getAffiliatedAccrediation().get(0).getInputat5(), style);
			createCell(row, columnCount++, record.getAffiliatedAccrediation().get(0).getInputat6(), style);
			createCell(row, columnCount++, record.getAffiliatedAccrediation().get(0).getInputat7(), style);
			createCell(row, columnCount++, record.getAffiliatedAccrediation().get(0).getInputat8(), style);

			createCell(row, columnCount++, record.getAffiliatedAccrediation().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getAffiliatedAccrediation().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedAccrediation().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// affiliated_annualQuality

	private void writeHeader15() {
		sheet15 = workbook.createSheet("affiliated_annualQuality");

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
		createCell(row, 6, excelHeaders15[5], style);
		createCell(row, 7, excelHeaders15[5], style);
		createCell(row, 8, excelHeaders15[5], style);

	}

	private void write15() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet15.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedAnnualQuality().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedAnnualQuality().get(0).getInputat10(), style);
			createCell(row, columnCount++, record.getAffiliatedAnnualQuality().get(0).getInputat11(), style);
			createCell(row, columnCount++, record.getAffiliatedAnnualQuality().get(0).getInputat12(), style);
			createCell(row, columnCount++, record.getAffiliatedAnnualQuality().get(0).getInputat13(), style);

			createCell(row, columnCount++, record.getAffiliatedAnnualQuality().get(0).getInputat9(), style);

			createCell(row, columnCount++, record.getAffiliatedAnnualQuality().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedAnnualQuality().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedAnnualQuality().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Criteria2 affiliated_admittstudents

	private void writeHeader16() {
		sheet16 = workbook.createSheet("affiliated_admittstudents");

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
		createCell(row, 6, excelHeaders16[6], style);
		createCell(row, 7, excelHeaders16[7], style);
		createCell(row, 8, excelHeaders16[8], style);
		createCell(row, 9, excelHeaders16[9], style);
		createCell(row, 10, excelHeaders16[10], style);
		createCell(row, 11, excelHeaders16[11], style);

	}

	private void write16() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet16.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAffiliatedAdmittstudents().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAffiliatedAdmittstudents().get(0).getInputat1(), style);
			createCell(row, columnCount++, record.getAffiliatedAdmittstudents().get(0).getInputat2(), style);
			createCell(row, columnCount++, record.getAffiliatedAdmittstudents().get(0).getInputat3(), style);
			createCell(row, columnCount++, record.getAffiliatedAdmittstudents().get(0).getInputat4(), style);

			createCell(row, columnCount++, record.getAffiliatedAdmittstudents().get(0).getInputat5(), style);
			createCell(row, columnCount++, record.getAffiliatedAdmittstudents().get(0).getInputat6(), style);
			createCell(row, columnCount++, record.getAffiliatedAdmittstudents().get(0).getInputat7(), style);
			createCell(row, columnCount++, record.getAffiliatedAdmittstudents().get(0).getInputat8(), style);

			createCell(row, columnCount++, record.getAffiliatedAdmittstudents().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAffiliatedAdmittstudents().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAffiliatedAdmittstudents().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// programme_introduced
	private void writeHeader17() {
		sheet17 = workbook.createSheet("programme_introduced");

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet17.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getProgrammeIntroduced().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getProgrammeIntroduced().get(0).getInputbtp11(), style);
			createCell(row, columnCount++, record.getProgrammeIntroduced().get(0).getInputbtp12(), style);

			createCell(row, columnCount++, record.getProgrammeIntroduced().get(0).getInputbtp13(), style);
			createCell(row, columnCount++, record.getProgrammeIntroduced().get(0).getInputbtp14(), style);
			createCell(row, columnCount++, record.getProgrammeIntroduced().get(0).getInputbtp15(), style);

			createCell(row, columnCount++, record.getProgrammeIntroduced().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getProgrammeIntroduced().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getProgrammeIntroduced().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// basic_profile2
	private void writeHeader18() {
		sheet18 = workbook.createSheet("basic_profile2");

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
		createCell(row, 6, excelHeaders18[6], style);
		createCell(row, 7, excelHeaders18[7], style);
		createCell(row, 8, excelHeaders18[8], style);
		createCell(row, 9, excelHeaders18[9], style);

	}

	private void write18() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet18.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getBasicprofile2().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getBasicprofile2().get(0).getInputbtip1(), style);
			createCell(row, columnCount++, record.getBasicprofile2().get(0).getInputbtip2(), style);
			createCell(row, columnCount++, record.getBasicprofile2().get(0).getInputbtip3(), style);
			createCell(row, columnCount++, record.getBasicprofile2().get(0).getInputbtip4(), style);

			createCell(row, columnCount++, record.getBasicprofile2().get(0).getInputbtip5(), style);
			createCell(row, columnCount++, record.getBasicprofile2().get(0).getInputbtip6(), style);

			createCell(row, columnCount++, record.getBasicprofile2().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getBasicprofile2().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getBasicprofile2().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// campus
	private void writeHeader19() {
		sheet19 = workbook.createSheet("campus");

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
		createCell(row, 6, excelHeaders19[6], style);
		createCell(row, 7, excelHeaders19[7], style);
		createCell(row, 8, excelHeaders19[8], style);

	}

	private void write19() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet19.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getCampus().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getCampus().get(0).getInputbtl11(), style);
			createCell(row, columnCount++, record.getCampus().get(0).getInputbtl12(), style);
			createCell(row, columnCount++, record.getCampus().get(0).getInputbtl13(), style);
			createCell(row, columnCount++, record.getCampus().get(0).getInputbtl14(), style);
			createCell(row, columnCount++, record.getCampus().get(0).getInputbtl15(), style);
			createCell(row, columnCount++, record.getCampus().get(0).getInputbtl16(), style);
			createCell(row, columnCount++, record.getCampus().get(0).getInputbtl17(), style);
			createCell(row, columnCount++, record.getCampus().get(0).getInputbtl18(), style);

			createCell(row, columnCount++, record.getCampus().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getCampus().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getCampus().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// academic_institution
	private void writeHeader20() {
		sheet20 = workbook.createSheet("academic_institution");

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
		createCell(row, 6, excelHeaders20[6], style);
		createCell(row, 7, excelHeaders20[7], style);
		createCell(row, 8, excelHeaders20[8], style);
		createCell(row, 9, excelHeaders20[9], style);

		createCell(row, 10, excelHeaders20[10], style);
		createCell(row, 11, excelHeaders20[11], style);
		createCell(row, 12, excelHeaders20[12], style);
		createCell(row, 13, excelHeaders20[13], style);
		createCell(row, 14, excelHeaders20[14], style);

		createCell(row, 15, excelHeaders20[15], style);
		createCell(row, 16, excelHeaders20[16], style);


	}

	private void write20() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet20.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat00(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat10(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat11(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat111(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat112(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat12(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat13(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat14(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat15(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat16(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat17(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat18(), style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getInputat19(), style);

			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getAcademicinstitution().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getAcademicinstitution().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// academicstudentsenrolled
	private void writeHeader21() {
		sheet21 = workbook.createSheet("academicstudentsenrolled");

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

		createCell(row, 6, excelHeaders21[5], style);

	}

	private void write21() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet21.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAcademicstudentsEnrolled().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAcademicstudentsEnrolled().get(0).getInputas00(), style);
			createCell(row, columnCount++, record.getAcademicstudentsEnrolled().get(0).getInputas11(), style);
			createCell(row, columnCount++, record.getAcademicstudentsEnrolled().get(0).getInputas12(), style);
			createCell(row, columnCount++, record.getAcademicstudentsEnrolled().get(0).getInputas13(), style);
			createCell(row, columnCount++, record.getAcademicstudentsEnrolled().get(0).getInputas14(), style);
			createCell(row, columnCount++, record.getAcademicstudentsEnrolled().get(0).getInputas15(), style);

			createCell(row, columnCount++, record.getAcademicstudentsEnrolled().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAcademicstudentsEnrolled().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAcademicstudentsEnrolled().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// academic_studentsadmitted
	private void writeHeader22() {
		sheet22 = workbook.createSheet("academic_studentsadmitted"); // university 3231

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet22.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAcademicstudentsAdmitted().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAcademicstudentsAdmitted().get(0).getInputaa00(), style);
			createCell(row, columnCount++, record.getAcademicstudentsAdmitted().get(0).getInputaa11(), style);
			createCell(row, columnCount++, record.getAcademicstudentsAdmitted().get(0).getInputaa12(), style);
			createCell(row, columnCount++, record.getAcademicstudentsAdmitted().get(0).getInputaa13(), style);

			createCell(row, columnCount++, record.getAcademicstudentsAdmitted().get(0).getInputaa14(), style);

			createCell(row, columnCount++, record.getAcademicstudentsAdmitted().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAcademicstudentsAdmitted().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAcademicstudentsAdmitted().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// evaluative
	private void writeHeader23() {
		sheet23 = workbook.createSheet("evaluative");

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet23.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEvaluativeReport().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEvaluativeReport().get(0).getValuet1(), style);
			createCell(row, columnCount++, record.getEvaluativeReport().get(0).getValuet2(), style);
			createCell(row, columnCount++, record.getEvaluativeReport().get(0).getValuet3(), style);
			createCell(row, columnCount++, record.getEvaluativeReport().get(0).getValuet4(), style);

			createCell(row, columnCount++, record.getEvaluativeReport().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getEvaluativeReport().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++, record.getEvaluativeReport().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// evaluative_fileupload
	private void writeHeader24() {
		sheet24 = workbook.createSheet("evaluative_fileupload");

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
		createCell(row, 6, excelHeaders24[6], style);
		// createCell(row, 7, excelHeaders24[4], style);
		// createCell(row, 8, excelHeaders24[5], style);

	}

	private void write24() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet24.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getEvaluativeFileupload().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getEvaluativeFileupload().get(0).getEvaluate_fileType(), style);
			createCell(row, columnCount++, record.getEvaluativeFileupload().get(0).getEvaluative_fileName(), style);

			createCell(row, columnCount++, record.getEvaluativeFileupload().get(0).getEvaluative_filePath(), style);

			createCell(row, columnCount++,
					record.getEvaluativeFileupload().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++,
					record.getEvaluativeFileupload().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getEvaluativeFileupload().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}


//	// auniversityaffiliated
//	private void writeHeader26() {
//		sheet26 = workbook.createSheet("auniversityaffiliated");
//
//		Row row = sheet26.createRow(0);
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		font.setFontHeight(16);
//		style.setFont(font);
//
//		createCell(row, 0, excelHeaders26[0], style);
//		createCell(row, 1, excelHeaders26[1], style);
//		createCell(row, 2, excelHeaders26[2], style);
//		createCell(row, 3, excelHeaders26[3], style);
//		createCell(row, 4, excelHeaders26[4], style);
//		createCell(row, 5, excelHeaders26[5], style);
//		createCell(row, 6, excelHeaders26[6], style);
//
//	}
//
//	private void write26() {
//		int rowCount = 1;
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setFontHeight(14);
//		style.setFont(font);
//
//		for (ProfileoftheCollege record : listRecords) {
//			Row row = sheet26.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getInputa1t1(), style);
//			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getInputa1t2(), style);
//			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getInputa1t3(), style);
//
//			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getCriteriaId().getCollegeId(),
//					style);
//			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getAuniversityAffiliated().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//
//	}

//	// auniversityaffiliated1
//	private void writeHeader27() {
//		sheet27 = workbook.createSheet("auniversityaffiliated1");
//
//		Row row = sheet27.createRow(0);
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		font.setFontHeight(16);
//		style.setFont(font);
//
//		createCell(row, 0, excelHeaders27[0], style);
//		createCell(row, 1, excelHeaders27[1], style);
//		createCell(row, 2, excelHeaders27[2], style);
//		createCell(row, 3, excelHeaders27[3], style);
//		createCell(row, 4, excelHeaders27[4], style);
//		createCell(row, 5, excelHeaders27[5], style);
//
//	}
//
//	private void write27() {
//		int rowCount = 1;
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setFontHeight(14);
//		style.setFont(font);
//
//		for (ProfileoftheCollege record : listRecords) {
//			Row row = sheet27.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getInputa2t1(), style);
//			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getInputa2t2(), style);
//			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getInputa2t3(), style);
//			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getInputa2t4(), style);
//
//			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getCriteriaId().getCollegeId(),
//					style);
//			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getAuniversityAffiliated1().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//
//	}

//	// universitycolleges
//	private void writeHeader28() {
//		sheet28 = workbook.createSheet("universitycolleges");
//
//		Row row = sheet28.createRow(0);
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		font.setFontHeight(16);
//		style.setFont(font);
//
//		createCell(row, 0, excelHeaders28[0], style);
//		createCell(row, 1, excelHeaders28[1], style);
//		createCell(row, 2, excelHeaders28[2], style);
//		createCell(row, 3, excelHeaders28[3], style);
//		createCell(row, 4, excelHeaders28[4], style);
//
//		createCell(row, 5, excelHeaders28[5], style);
//		createCell(row, 6, excelHeaders28[6], style);
//		createCell(row, 7, excelHeaders28[7], style);
//		createCell(row, 8, excelHeaders28[8], style);
//		createCell(row, 9, excelHeaders28[9], style);
//
//		createCell(row, 10, excelHeaders28[10], style);
//		createCell(row, 11, excelHeaders28[11], style);
//		createCell(row, 12, excelHeaders28[12], style);
//		createCell(row, 13, excelHeaders28[13], style);
//		createCell(row, 14, excelHeaders28[14], style);
//	}
//
//	private void write28() {
//		int rowCount = 1;
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setFontHeight(14);
//		style.setFont(font);
//
//		for (ProfileoftheCollege record : listRecords) {
//			Row row = sheet28.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t1(), style);
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t10(), style);
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t2(), style);
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t11(), style);
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t3(), style);
//
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t4(), style);
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t5(), style);
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t6(), style);
//
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t7(), style);
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t8(), style);
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t9(), style);
//
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getCriteriaId().getCollegeId(), style);
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++, record.getUniversityColleges().get(0).getCriteriaId().getTypeofInstitution(),
//					style);
//
//		}
//
//	}

	// academiciansappointed
	private void writeHeader29() {
		sheet29 = workbook.createSheet("academiciansappointed");

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
		createCell(row, 6, excelHeaders29[6], style);
		createCell(row, 7, excelHeaders29[7], style);

	}

	private void write29() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet29.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getInputaa1t1(), style);
			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getInputaa1t2(), style);

			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getInputaa1t3(), style);
			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getInputaa1t4(), style);

			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getAcademiciansAppointed().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

//	// integratedprogrammes
//	private void writeHeader30() {
//		sheet30 = workbook.createSheet("integratedprogrammes");
//
//		Row row = sheet30.createRow(0);
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		font.setFontHeight(16);
//		style.setFont(font);
//
//		createCell(row, 0, excelHeaders30[0], style);
//		createCell(row, 1, excelHeaders30[1], style);
//		createCell(row, 2, excelHeaders30[2], style);
//		createCell(row, 3, excelHeaders30[3], style);
//		createCell(row, 4, excelHeaders30[4], style);
//
//		createCell(row, 5, excelHeaders30[5], style);
//		createCell(row, 6, excelHeaders30[1], style);
//		createCell(row, 7, excelHeaders30[2], style);
//		createCell(row, 8, excelHeaders30[3], style);
//		createCell(row, 9, excelHeaders30[4], style);
//
//		createCell(row, 10, excelHeaders30[1], style);
//		createCell(row, 11, excelHeaders30[2], style);
//	}
//
//	private void write30() {
//		int rowCount = 1;
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setFontHeight(14);
//		style.setFont(font);
//
//		for (ProfileoftheCollege record : listRecords) {
//			Row row = sheet30.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult1(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult2(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult3(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult4(), style);
//
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult5(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult6(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult7(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult8(), style);
//
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getCriteriaId().getCollegeId(),
//					style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getCriteriaId().getFinancialYear(),
//					style);
//			createCell(row, columnCount++,
//					record.getIntegratedProgrammes().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//
//	}

	// humanresourcedevelopment
	private void writeHeader31() {
		sheet31 = workbook.createSheet("humanresourcedevelopment");

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet31.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getHumanResourceDevelopment().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getHumanResourceDevelopment().get(0).getInputrdt1(), style);
			createCell(row, columnCount++, record.getHumanResourceDevelopment().get(0).getInputrdt2(), style);
			createCell(row, columnCount++, record.getHumanResourceDevelopment().get(0).getInputrdt3(), style);
			createCell(row, columnCount++, record.getHumanResourceDevelopment().get(0).getInputrdt4(), style);

			createCell(row, columnCount++, record.getHumanResourceDevelopment().get(0).getInputrdt5(), style);
			createCell(row, columnCount++, record.getHumanResourceDevelopment().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getHumanResourceDevelopment().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getHumanResourceDevelopment().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// instituteduniversity
	private void writeHeader32() {
		sheet32 = workbook.createSheet("instituteduniversity");

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
		createCell(row, 6, excelHeaders32[6], style);
		createCell(row, 7, excelHeaders32[7], style);

	}

	private void write32() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet32.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getInstitutedUniversity().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getInstitutedUniversity().get(0).getInputiut1(), style);
			createCell(row, columnCount++, record.getInstitutedUniversity().get(0).getInputiut2(), style);
			createCell(row, columnCount++, record.getInstitutedUniversity().get(0).getInputiut3(), style);
			createCell(row, columnCount++, record.getInstitutedUniversity().get(0).getInputiut4(), style);

			createCell(row, columnCount++, record.getInstitutedUniversity().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getInstitutedUniversity().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getInstitutedUniversity().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// Programmes_Offred
	private void writeHeader33() {
		sheet33 = workbook.createSheet("Programmes_Offred");

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
		createCell(row, 6, excelHeaders33[6], style);

	}

	private void write33() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet33.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getProgrammesOffered().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getProgrammesOffered().get(0).getInputpot1(), style);
			createCell(row, columnCount++, record.getProgrammesOffered().get(0).getInputpot2(), style);
			createCell(row, columnCount++, record.getProgrammesOffered().get(0).getInputpot3(), style);

			createCell(row, columnCount++, record.getProgrammesOffered().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getProgrammesOffered().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++, record.getProgrammesOffered().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// Proffessional_programmes
	private void writeHeader34() {
		sheet34 = workbook.createSheet("Proffessional_programmes");

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
		createCell(row, 6, excelHeaders34[6], style);

	}

	private void write34() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet34.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getProffessionalprogrammes().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getProffessionalprogrammes().get(0).getInputpopt1(), style);
			createCell(row, columnCount++, record.getProffessionalprogrammes().get(0).getInputpopt2(), style);
			createCell(row, columnCount++, record.getProffessionalprogrammes().get(0).getInputpopt3(), style);

			createCell(row, columnCount++, record.getProffessionalprogrammes().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getProffessionalprogrammes().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getProffessionalprogrammes().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

	// Recognized_Minority
	private void writeHeader35() {
		sheet35 = workbook.createSheet("Recognized_Minority");

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
		createCell(row, 6, excelHeaders35[6], style);
		createCell(row, 7, excelHeaders35[7], style);
		createCell(row, 8, excelHeaders35[8], style);

	}

	private void write35() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet35.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getRecognizedMinority().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getRecognizedMinority().get(0).getInputbtr1(), style);
			createCell(row, columnCount++, record.getRecognizedMinority().get(0).getInputbtr2(), style);
			createCell(row, columnCount++, record.getRecognizedMinority().get(0).getInputbtr3(), style);
			createCell(row, columnCount++, record.getRecognizedMinority().get(0).getInputbtr4(), style);
			createCell(row, columnCount++, record.getRecognizedMinority().get(0).getInputbtr5(), style);

			createCell(row, columnCount++, record.getRecognizedMinority().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getRecognizedMinority().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++, record.getRecognizedMinority().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}

	}

	// recognization_Details
	private void writeHeader36() {
		sheet36 = workbook.createSheet("recognization_Details");

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet36.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getRecognizationDetails().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getRecognizationDetails().get(0).getInputbtr6(), style);
			createCell(row, columnCount++, record.getRecognizationDetails().get(0).getInputbtr7(), style);
			createCell(row, columnCount++, record.getRecognizationDetails().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getRecognizationDetails().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getRecognizationDetails().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// detailsofVisiting_Faculties
	private void writeHeader37() {
		sheet37 = workbook.createSheet("detailsofVisiting_Faculties");

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
		createCell(row, 6, excelHeaders37[6], style);
		createCell(row, 7, excelHeaders37[7], style);

	}

	private void write37() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet37.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getDetailsofVisitingFaculties().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getDetailsofVisitingFaculties().get(0).getInputatg11(), style);
			createCell(row, columnCount++, record.getDetailsofVisitingFaculties().get(0).getInputatg12(), style);
			createCell(row, columnCount++, record.getDetailsofVisitingFaculties().get(0).getInputatg13(), style);
			createCell(row, columnCount++, record.getDetailsofVisitingFaculties().get(0).getInputatg14(), style);

			createCell(row, columnCount++, record.getDetailsofVisitingFaculties().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getDetailsofVisitingFaculties().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getDetailsofVisitingFaculties().get(0).getCriteriaId().getTypeofInstitution(), style);

		}

	}

	// nonTeaching_staff
	private void writeHeader38() {
		sheet38 = workbook.createSheet("nonTeaching_staff");

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
		createCell(row, 6, excelHeaders38[6], style);
		createCell(row, 7, excelHeaders38[7], style);

	}

	private void write38() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet38.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getNonTeachingStaff().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getNonTeachingStaff().get(0).getInputatnt11(), style);
			createCell(row, columnCount++, record.getNonTeachingStaff().get(0).getInputatnt12(), style);
			createCell(row, columnCount++, record.getNonTeachingStaff().get(0).getInputatnt13(), style);
			createCell(row, columnCount++, record.getNonTeachingStaff().get(0).getInputatnt14(), style);

			createCell(row, columnCount++, record.getNonTeachingStaff().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getNonTeachingStaff().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++, record.getNonTeachingStaff().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// technical_Staff
	private void writeHeader39() {
		sheet39 = workbook.createSheet("technical_Staff");

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
		createCell(row, 6, excelHeaders39[6], style);
		createCell(row, 7, excelHeaders39[7], style);

	}

	private void write39() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet39.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getTechnicalStaff().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getTechnicalStaff().get(0).getInputatt15(), style);
			createCell(row, columnCount++, record.getTechnicalStaff().get(0).getInputatt16(), style);
			createCell(row, columnCount++, record.getTechnicalStaff().get(0).getInputatt17(), style);
			createCell(row, columnCount++, record.getTechnicalStaff().get(0).getInputatt18(), style);

			createCell(row, columnCount++, record.getTechnicalStaff().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getTechnicalStaff().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getTechnicalStaff().get(0).getCriteriaId().getTypeofInstitution(),
					style);

		}
	}

	// academic_perminentTeachers
	private void writeHeader40() {
		sheet40 = workbook.createSheet("academic_perminentTeachers");

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
		createCell(row, 6, excelHeaders40[6], style);
		createCell(row, 7, excelHeaders40[7], style);

		createCell(row, 8, excelHeaders40[8], style);
		createCell(row, 9, excelHeaders40[9], style);
		createCell(row, 10, excelHeaders40[10], style);
		createCell(row, 11, excelHeaders40[11], style);
		createCell(row, 12, excelHeaders40[12], style);
		createCell(row, 13, excelHeaders40[13], style);

	}

	private void write40() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet40.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getInputatq11(), style);
			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getInputatq110(), style);
			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getInputatq12(), style);
			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getInputatq13(), style);

			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getInputatq14(), style);
			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getInputatq15(), style);
			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getInputatq16(), style);
			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getInputatq17(), style);
			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getInputatq19(), style);
			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getInputatq18(), style);

			createCell(row, columnCount++, record.getAcademicPerminentTeachers().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAcademicPerminentTeachers().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAcademicPerminentTeachers().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

	// academic_temporaryTeachers
	private void writeHeader41() {
		sheet41 = workbook.createSheet("academic_temporaryTeachers");

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
		createCell(row, 6, excelHeaders41[6], style);
		createCell(row, 7, excelHeaders41[7], style);

		createCell(row, 8, excelHeaders41[8], style);
		createCell(row, 9, excelHeaders41[9], style);
		createCell(row, 10, excelHeaders41[10], style);
		createCell(row, 11, excelHeaders41[11], style);
		createCell(row, 12, excelHeaders41[12], style);
		createCell(row, 13, excelHeaders41[13], style);

	}

	private void write41() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet41.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getInputatq51(), style);
			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getInputatq510(), style);
			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getInputatq52(), style);
			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getInputatq53(), style);

			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getInputatq54(), style);
			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getInputatq55(), style);
			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getInputatq56(), style);
			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getInputatq57(), style);
			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getInputatq58(), style);
			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getInputatq59(), style);

			createCell(row, columnCount++, record.getAcademicTemporaryTeachers().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAcademicTemporaryTeachers().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAcademicTemporaryTeachers().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

	// academic_ParttimeTeacheres
	private void writeHeader42() {
		sheet42 = workbook.createSheet("academic_ParttimeTeacheres");

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
		createCell(row, 6, excelHeaders42[6], style);
		createCell(row, 7, excelHeaders42[7], style);

		createCell(row, 8, excelHeaders42[8], style);
		createCell(row, 9, excelHeaders42[9], style);
		createCell(row, 10, excelHeaders42[10], style);
		createCell(row, 11, excelHeaders42[11], style);
		createCell(row, 12, excelHeaders42[12], style);
		createCell(row, 13, excelHeaders42[13], style);

	}

	private void write42() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet42.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getInputatq91(), style);
			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getInputatq910(), style);
			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getInputatq92(), style);
			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getInputatq93(), style);

			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getInputatq94(), style);
			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getInputatq95(), style);
			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getInputatq96(), style);
			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getInputatq97(), style);
			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getInputatq98(), style);
			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getInputatq99(), style);

			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAcademicParttimeTeacheres().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAcademicParttimeTeacheres().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

	// institution_collegeAffiliated
	private void writeHeader43() {
		sheet43 = workbook.createSheet("institution_collegeAffiliated");

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

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet43.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getInstitutionCollegeAffiliated().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getInstitutionCollegeAffiliated().get(0).getInputbti11(), style);
			createCell(row, columnCount++, record.getInstitutionCollegeAffiliated().get(0).getInputbti12(), style);
			createCell(row, columnCount++, record.getInstitutionCollegeAffiliated().get(0).getInputbti13(), style);

			createCell(row, columnCount++, record.getAcademicParttimeTeacheres().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++,
					record.getAcademicParttimeTeacheres().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++,
					record.getAcademicParttimeTeacheres().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

	// natureof_institution
	private void writeHeader44() {
		sheet44 = workbook.createSheet("natureof_institution");

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
		createCell(row, 6, excelHeaders44[6], style);
		createCell(row, 7, excelHeaders44[7], style);
		createCell(row, 8, excelHeaders44[8], style);
		createCell(row, 9, excelHeaders44[9], style);
	}

	private void write44() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet44.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getNatureofInstitution().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getNatureofInstitution().get(0).getInputbti1(), style);
			createCell(row, columnCount++, record.getNatureofInstitution().get(0).getInputbti2(), style);
			createCell(row, columnCount++, record.getNatureofInstitution().get(0).getInputbti3(), style);
			createCell(row, columnCount++, record.getNatureofInstitution().get(0).getInputbti4(), style);
			createCell(row, columnCount++, record.getNatureofInstitution().get(0).getInputbti5(), style);
			createCell(row, columnCount++, record.getNatureofInstitution().get(0).getInputbti6(), style);

			createCell(row, columnCount++, record.getNatureofInstitution().get(0).getCriteriaId().getCollegeId(),
					style);
			createCell(row, columnCount++, record.getNatureofInstitution().get(0).getCriteriaId().getFinancialYear(),
					style);
			createCell(row, columnCount++,
					record.getNatureofInstitution().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}



	//  auniversityaffiliated
	private void writeHeader45() {
		sheet45 = workbook.createSheet("auniversityaffiliated");

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
		createCell(row, 6, excelHeaders45[6], style);

	}


	private void write45() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet45.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getInputa1t1(), style);
			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getInputa1t2(), style);
			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getInputa1t3(), style);

			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getAuniversityAffiliated().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}
//
//
//
//
	//  auniversityaffiliated1
	private void writeHeader46() {
		sheet46 = workbook.createSheet("auniversityaffiliated1");

		Row row = sheet46.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders46[0], style);
		createCell(row, 1, excelHeaders46[1], style);
		createCell(row, 2, excelHeaders46[2], style);
		createCell(row, 3, excelHeaders46[3], style);
		createCell(row, 4, excelHeaders46[4], style);
		createCell(row, 5, excelHeaders46[5], style);
		createCell(row, 6, excelHeaders46[6], style);

		createCell(row, 7, excelHeaders46[7], style);

	
	}


	private void write46() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet46.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getInputa2t1(), style);
			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getInputa2t2(), style);
			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getInputa2t3(), style);
			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getInputa2t4(), style);

			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getAuniversityAffiliated1().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}
	
	

	//  universitycolleges
	private void writeHeader47() {
		sheet47= workbook.createSheet("universitycolleges");

		Row row = sheet47.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders47[0], style);
		createCell(row, 1, excelHeaders47[1], style);
		createCell(row, 2, excelHeaders47[2], style);
		createCell(row, 3, excelHeaders47[3], style);
		createCell(row, 4, excelHeaders47[4], style);
		createCell(row, 5, excelHeaders47[5], style);
		createCell(row, 6, excelHeaders47[6], style);

		createCell(row, 8, excelHeaders47[8], style);
		createCell(row, 9, excelHeaders47[9], style);
		createCell(row, 10, excelHeaders47[10], style);
		createCell(row, 11, excelHeaders47[11], style);
		createCell(row, 12, excelHeaders47[12], style);
		createCell(row, 13, excelHeaders47[13], style);
		createCell(row, 14, excelHeaders47[14], style);

	}


	private void write47() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet47.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getUniversityColleges().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t1(), style);
			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t10(), style);
			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t11(), style);
			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t2(), style);

			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t3(), style);
			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t4(), style);
			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t5(), style);
			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t6(), style);
			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t7(), style);

			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t8(), style);
			createCell(row, columnCount++, record.getUniversityColleges().get(0).getInputa3t9(), style);

			createCell(row, columnCount++, record.getUniversityColleges().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getUniversityColleges().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getUniversityColleges().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}


//	//  academiciansappointed
//	private void writeHeader48() {
//		sheet48 = workbook.createSheet("academiciansappointed");
//
//		Row row = sheet48.createRow(0);
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		font.setFontHeight(16);
//		style.setFont(font);
//
//		createCell(row, 0, excelHeaders48[0], style);
//		createCell(row, 1, excelHeaders48[1], style);
//		createCell(row, 2, excelHeaders48[2], style);
//		createCell(row, 3, excelHeaders48[3], style);
//		createCell(row, 4, excelHeaders48[4], style);
//		createCell(row, 5, excelHeaders48[5], style);
//		createCell(row, 6, excelHeaders48[6], style);
//
//		createCell(row, 7, excelHeaders48[7], style);
//		createCell(row, 9, excelHeaders48[9], style);
//		createCell(row, 10, excelHeaders48[10], style);
//		createCell(row, 11, excelHeaders48[11], style);
//		createCell(row, 12, excelHeaders48[12], style);
//		createCell(row, 13, excelHeaders48[13], style);
//		createCell(row, 14, excelHeaders48[14], style);
////
//	}
//
//
//	private void write48() {
//		int rowCount = 1;
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setFontHeight(14);
//		style.setFont(font);
//
//		for (ProfileoftheCollege record : listRecords) {
//			Row row = sheet48.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getInputaa1t1(), style);
//			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getInputaa1t2(), style);
//			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getInputaa1t3(), style);
//			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getInputaa1t4(), style);
//
//			
//			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getCriteriaId().getCollegeId(), style);
//			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getCriteriaId().getFinancialYear(), style);
//			createCell(row, columnCount++, record.getAcademiciansAppointed().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}

//  integratedprogrammes
	private void writeHeader49() {
		sheet49 = workbook.createSheet("integratedprogrammes");

		Row row = sheet49.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, excelHeaders49[0], style);
		createCell(row, 1, excelHeaders49[1], style);
		createCell(row, 2, excelHeaders49[2], style);
		createCell(row, 3, excelHeaders49[3], style);
		createCell(row, 4, excelHeaders49[4], style);
		createCell(row, 5, excelHeaders49[5], style);
		createCell(row, 6, excelHeaders49[6], style);

		createCell(row, 7, excelHeaders49[7], style);
    	createCell(row, 8, excelHeaders49[8], style);
		createCell(row, 9, excelHeaders49[9], style);
		createCell(row, 10, excelHeaders49[10], style);
     	createCell(row, 11, excelHeaders49[11], style);

		
//
	}


	private void write49() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ProfileoftheCollege record : listRecords) {
			Row row = sheet49.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getUniqueKey1(), style);
			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult1(), style);
			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult2(), style);
			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult3(), style);
			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult4(), style);

			
			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult5(), style);
			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult6(), style);
			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult7(), style);
			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult8(), style);

			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getCriteriaId().getCollegeId(), style);
			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getCriteriaId().getFinancialYear(), style);
			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getCriteriaId().getTypeofInstitution(), style);

		}
	}

//
////  humanresourcedevelopment
//	private void writeHeader50() {
//		sheet50 = workbook.createSheet("humanresourcedevelopment");
//
//		Row row = sheet50.createRow(0);
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		font.setFontHeight(16);
//		style.setFont(font);
//
//		createCell(row, 0, excelHeaders50[0], style);
//		createCell(row, 1, excelHeaders50[1], style);
//		createCell(row, 2, excelHeaders50[2], style);
//		createCell(row, 3, excelHeaders50[3], style);
//		createCell(row, 4, excelHeaders50[4], style);
//		createCell(row, 5, excelHeaders50[5], style);
//		createCell(row, 6, excelHeaders50[6], style);
//
//		createCell(row, 7, excelHeaders50[7], style);
//    	createCell(row, 9, excelHeaders50[9], style);
//		createCell(row, 10, excelHeaders50[10], style);
//		createCell(row, 11, excelHeaders50[11], style);
//		createCell(row, 12, excelHeaders50[12], style);
//		createCell(row, 13, excelHeaders50[13], style);
//		createCell(row, 14, excelHeaders50[14], style);
//
//	}
//
//
//	private void write50() {
//		int rowCount = 1;
//
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setFontHeight(14);
//		style.setFont(font);
//
//		for (ProfileoftheCollege record : listRecords) {
//			Row row = sheet50.createRow(rowCount++);
//			int columnCount = 0;
//
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getUniqueKey1(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult1(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult2(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult3(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult4(), style);
//
//			
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult5(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult6(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult7(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getInputult8(), style);
//
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getCriteriaId().getCollegeId(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getCriteriaId().getFinancialYear(), style);
//			createCell(row, columnCount++, record.getIntegratedProgrammes().get(0).getCriteriaId().getTypeofInstitution(), style);
//
//		}
//	}
//
//
//
//

	public void generate(HttpServletResponse response,Map<String, String> allParams) throws IOException {
		
		if("autonomous".equalsIgnoreCase(allParams.get("typeofInstitution")))
		{
		
		writeHeader();
//		writeHeader1();
//		writeHeader2();
//		writeHeader3();
//		writeHeader4();
//		writeHeader5();
//		writeHeader6();
//		writeHeader7();
	    writeHeader8();
//		writeHeader9();
//		writeHeader10();
//		writeHeader11();
//		writeHeader12();
//		writeHeader13();
//		writeHeader14();
//		writeHeader15();
	//	writeHeader16();
		writeHeader17();
		writeHeader18();
		writeHeader19();
		writeHeader20();
		writeHeader21();
		writeHeader22();
		writeHeader23();
		writeHeader24();
		//writeHeader25();
	//	writeHeader26();
		//writeHeader27();
		//writeHeader28();
	//	writeHeader29();
	//	writeHeader30();
	//	writeHeader31();
		//writeHeader32();
		writeHeader33();
		writeHeader34();
		writeHeader35();
		writeHeader36();
		writeHeader37();
		writeHeader38();
		writeHeader39();
		writeHeader40();
		writeHeader41();
		writeHeader42();
		writeHeader43();
		writeHeader44();
		//writeHeader45();
		//writeHeader46();
		//writeHeader47();
		//writeHeader48();
		writeHeader46();
		//writeHeader49();
		//writeHeader50();
//

		write();
//		write1();
//		write2();
//		write3();
//		write4();
//		write5();
//		write6();
		//write7();
		write8();
		//write9();
//		write10();
//		write11();
//		write12();
//		write13();
//		write14();
		//write15();
		//write16();
		write17();
		write18();
		write19();
		write20();
		write21();
		write22();
		write23();
		write24();
		//write25();
	//	write26();
//		write27();
		//write28();
		//write29();
		//write30();
		//write31();
		//write32();
		write33();
		write34();
		write35();
		write36();
		write37();
		write38();
		write39();
		write40();
		write41();
		write42();
		write43();
		write44();
		//write45();
		//write46();
		//write47();
		//write48();
		//write49();
		//write50();
		}
		
		if("university".equalsIgnoreCase(allParams.get("typeofInstitution")))
		{
			writeHeader();
			
			//writeHeader1();
			
		   // writeHeader8();
			
			//writeHeader16();
			//writeHeader17();
			writeHeader18();
			writeHeader19();
			writeHeader20();
			writeHeader21();
			//writeHeader22();
			writeHeader23();
			writeHeader24();
			
			//writeHeader26();
//			writeHeader27();
			//writeHeader28();
			writeHeader29();
			//writeHeader30();
			writeHeader31();
			writeHeader32();
			//writeHeader33();
			//writeHeader34();
			//writeHeader35();
			//writeHeader36();
			writeHeader37();
			writeHeader38();
			writeHeader39();
			writeHeader40();
			writeHeader41();
			writeHeader42();
			//writeHeader43();
			writeHeader44();
			writeHeader45();
			writeHeader46();
			writeHeader47();
			//writeHeader48();
			//writeHeader46();
			writeHeader49();
			//writeHeader50();
	
			
			
			write();
			//write1();
			//write8();
			
			//write16();
			//write17();
			write18();
			write19();
			write20();
			write21();
			//write22();
			write23();
			write24();
			
		//	write26();
//			write27();
			//write28();
			write29();
			//write30();
			write31();
			write32();
			//write33();
			//write34();
			//write35();
			//write36();
			write37();
			write38();
			write39();
			write40();
			write41();
			write42();
			//write43();
			write44();
			write45();
			write46();
			write47();
		//write48();
			write49();
			//write50();
			
			
			
		}
		
		if("affiliated".equalsIgnoreCase(allParams.get("typeofInstitution")))
		{
			writeHeader();
			
		    //writeHeader8();
			
			writeHeader16();
			//writeHeader17();
			//writeHeader18();
			//writeHeader19();
			//writeHeader20();
		//	writeHeader21();
		//	writeHeader22();
			//writeHeader23();
			//writeHeader24();
			
			//writeHeader26();
			//writeHeader27();
		//	writeHeader28();
			//writeHeader29();
			// writeHeader30();
			// writeHeader31();
			// writeHeader32();
	//	writeHeader33();
//			writeHeader34();
		//	writeHeader35();
			//writeHeader36();
		//	writeHeader37();
		//	writeHeader38();
		//	writeHeader39();
//			writeHeader40();
//			writeHeader41();
//			writeHeader42();
			//writeHeader43();
			//writeHeader44();
//			writeHeader45();
			writeHeader46();
		//	writeHeader47();
		//	writeHeader48();
			//writeHeader46();
		//	writeHeader49();
		//	writeHeader50();
			
			
			
			//affiliated
			
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
			
			
			
			write();
			
			write8();
			
			write16();
			//write17();
			//write18();
			//write19();
			//write20();
			//write21();
		//	write22();
			//write23();
		//	write24();
			
			//write26();
			//write27();
		//	write28();
			//write29();
			//write30();
			// write31();
			//write32();
		//write33();
//			write34();
		//	write35();
		//	write36();
			//write37();
			//write38();
			//write39();
//			write40();
//			write41();
//			write42();
			//write43();
		//	write44();
//			write45();
			//write46();
		//	write47();
		//	write48();
			//write49();
			//write50();
			
			
			// affiliated
			
			write2();
			write3();
			write4();
			write5();
			write6();
			write7();
			//write8();
			write9();
			write10();
			write11();
			write12();
			write13();
			write14();
			write15();
			
			
		}
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
