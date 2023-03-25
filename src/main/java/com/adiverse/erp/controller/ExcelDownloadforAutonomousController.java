package com.adiverse.erp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adiverse.erp.ExcelReport.Criteria1ExcelGenerator;
import com.adiverse.erp.ExcelReport.Criteria2ExcelGenerator;
import com.adiverse.erp.ExcelReport.Criteria3ExcelGenerator;
import com.adiverse.erp.ExcelReport.Criteria4ExcelGenerator;
import com.adiverse.erp.ExcelReport.Criteria5Excelgenerator;
import com.adiverse.erp.ExcelReport.Criteria6ExcelGenerator;
import com.adiverse.erp.ExcelReport.Criteria7ExcelGenerator1;
import com.adiverse.erp.ExcelReport.EvaluatedexcelGenerator;
//import com.adiverse.erp.ExcelReport.Criteria6ExcelGenerator;
import com.adiverse.erp.ExcelReport.ExecutiveSummaryExcelGenerator;
import com.adiverse.erp.ExcelReport.ExtendedExcelGenerator;
//import com.adiverse.erp.ExcelReport.Criteria5ExcelGenerator;
import com.adiverse.erp.ExcelReport.IIQAExcelGenerator;
import com.adiverse.erp.ExcelReport.ProfileOftheCollegeExcelGenerator;
import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.Criteria4_FieldInfo;
import com.adiverse.erp.model.Criteria5_FieldInfo;
import com.adiverse.erp.model.Criteria6_FieldInfo;
import com.adiverse.erp.model.Criteria7_FieldInfo;
import com.adiverse.erp.model.EvaluativereportMain;
import com.adiverse.erp.model.ExecutiveSummary;
import com.adiverse.erp.model.ExtendedProfile;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.model.QIAIndicatorMain;
import com.adiverse.erp.repository.SsrRepository;
import com.adiverse.erp.service.Criteria1Service;
import com.adiverse.erp.service.Criteria2Service;
import com.adiverse.erp.service.Criteria3Service;
import com.adiverse.erp.service.Criteria4Service;
import com.adiverse.erp.service.Criteria5Service;
import com.adiverse.erp.service.Criteria6Service;
import com.adiverse.erp.service.Criteria7Service;
import com.adiverse.erp.service.EvaluationService;
import com.adiverse.erp.service.EvalutiveReportService;
import com.adiverse.erp.service.ExecutiveService;
import com.adiverse.erp.service.ExtendedService;
import com.adiverse.erp.service.QiaService;
import com.adiverse.erp.service.SsrService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ExcelDownloadforAutonomousController {

	@Autowired
	private QiaService qiaService;

	@Autowired
	private Criteria1Service criteria1Service;

	@Autowired
	private Criteria2Service criteria2Service;

	@Autowired
	private Criteria3Service criteria3Service;

	@Autowired
	private Criteria4Service criteria4Service;

	@Autowired
	private Criteria5Service criteria5Service;

	@Autowired
	private Criteria6Service criteria6Service;

	@Autowired
	private Criteria7Service criteria7Service;

	@Autowired
	private ExecutiveService executiveService;

	@Autowired
	private EvaluationService evaluationService;

	@Autowired
	private EvalutiveReportService evalutiveReportService;

	@Autowired
	private SsrService ssrservice;
	
	@Autowired
	private ExtendedService extendedService;
	
	

	@GetMapping("/export/excel/Autonomous/IIQA")
	public void exportIntoExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=IIQA_records_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<QIAIndicatorMain> listOfRecords = qiaService.getAllQiaFiles(allParams);

		IIQAExcelGenerator generator = new IIQAExcelGenerator(listOfRecords);

		generator.generate(response,allParams);
	}

	@GetMapping("/export/excel/Autonomous/criteria1")
	public void exportIntoExcelc1ql(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Criteria1QL_records_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<Criteria1_FieldInfo> listOfRecords = criteria1Service.getAllCriteria1Data(allParams);

		Criteria1ExcelGenerator generator = new Criteria1ExcelGenerator(listOfRecords);

		generator.generate(response,allParams);
	}
//	criteria 2

	@GetMapping("/export/excel/Autonomous/criteria2")
	public void exportIntoExcelc1ql1(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Criteria2all_records_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<Criteria2_FieldInfo> listOfRecords = criteria2Service.getAllCriteria2Data(allParams);

		Criteria2ExcelGenerator generator = new Criteria2ExcelGenerator(listOfRecords);

		generator.generate(response,allParams);
	}

//criteria 3

	@GetMapping("/export/excel/Autonomous/criteria3")
	public void exportIntoExcelc1ql2(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Criteria3all_records_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<Criteria3_FieldInfo> listOfRecords = criteria3Service.getAllCriteria3Data(allParams);

		Criteria3ExcelGenerator generator = new Criteria3ExcelGenerator(listOfRecords);

		generator.generate(response,allParams);
	}

//criteria 4

	@GetMapping("/export/excel/Autonomous/criteria4")
	public void exportIntoExcelc1ql3(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Criteria4all_records_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<Criteria4_FieldInfo> listOfRecords = criteria4Service.getAllCriteria4Data(allParams);

		Criteria4ExcelGenerator generator = new Criteria4ExcelGenerator(listOfRecords);

		generator.generate(response, allParams);
	}

//criteria 5

	@GetMapping("/export/excel/Autonomous/criteria5")
	public void exportIntoExcelc1ql4(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Criteria5all_records_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<Criteria5_FieldInfo> listOfRecords = criteria5Service.getAllCriteria5Data(allParams);

		Criteria5Excelgenerator generator = new Criteria5Excelgenerator(listOfRecords);

		generator.generate(response, allParams);
	}

//criteria 6

	@GetMapping("/export/excel/Autonomous/criteria6")
	public void exportIntoExcelc1qlcriteria6(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Criteria6all_records_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<Criteria6_FieldInfo> listOfRecords = criteria6Service.getAllCriteria6Data(allParams);

		Criteria6ExcelGenerator generator = new Criteria6ExcelGenerator(listOfRecords);

		generator.generate(response, allParams);
	}

//criteria 7

	@GetMapping("/export/excel/Autonomous/criteria7")
	public void exportIntoExcelcriteria7(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Criteria7all_records_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<Criteria7_FieldInfo> listOfRecords = criteria7Service.getAllCriteria7Data(allParams);

		Criteria7ExcelGenerator1 generator = new Criteria7ExcelGenerator1(listOfRecords);

		generator.generate(response, allParams);
	}

//	Executive summary

	@GetMapping("/export/excel/Autonomous/executive")
	public void exportIntoExcelc1qlexecutive(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Executive summary all Records" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<ExecutiveSummary> listOfRecords = executiveService.getAllExecutiveData(allParams);

		ExecutiveSummaryExcelGenerator generator = new ExecutiveSummaryExcelGenerator(listOfRecords);

		generator.generate(response,allParams);
	}
//EvaluativeReportMain

	@GetMapping("/export/excel/Autonomous/evaluativeReportMain")
	public void exportIntoExcelc1qlevaluative(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=EvaluativeReportMain summary all Records" + currentDateTime
				+ ".xlsx";
		response.setHeader(headerKey, headerValue);
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<EvaluativereportMain> listOfRecords = evalutiveReportService.getAllEvaluativeData(allParams);

		EvaluatedexcelGenerator generator = new EvaluatedexcelGenerator(listOfRecords);

		generator.generate(response,allParams);
	}

//SSr

	@GetMapping("/export/excel/Autonomous/Ssr")
	public void exportIntoExcelc1qlevalu(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=SSR all recorords" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<ProfileoftheCollege> listOfRecords = ssrservice.getAllAcademicData(allParams);

		ProfileOftheCollegeExcelGenerator generator = new ProfileOftheCollegeExcelGenerator(listOfRecords);

		generator.generate(response,allParams);
	}
	
	
	
	//extended profile


	@GetMapping("/export/excel/Autonomous/extended")
	public void exportIntoExcelc1qlextended(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=extended all recorords" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", "1");
		allParams.put("financialYear", "2022-2023");

		allParams.put("typeofInstitution", "autonomous");
		List<ExtendedProfile> listOfRecords = extendedService.getAllExtendedData(allParams);

		ExtendedExcelGenerator generator = new ExtendedExcelGenerator(listOfRecords);

		generator.generate(response, allParams);
	}

	

}
