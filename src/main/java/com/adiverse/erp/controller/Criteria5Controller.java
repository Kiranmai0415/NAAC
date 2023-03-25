package com.adiverse.erp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.Criteria5_FieldInfo;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.openpdf.AffilatedCriteria1Report;
import com.adiverse.erp.openpdf.AffiliatedQualityAdivisorReport;
import com.adiverse.erp.openpdf.AffiliatedSsrReport;
import com.adiverse.erp.openpdf.AutonomousExtendedProfileReport;
import com.adiverse.erp.openpdf.AutonomousQualityAdvisorReport;
import com.adiverse.erp.openpdf.AutonoumsSsr;
import com.adiverse.erp.openpdf.UniversityQualityAdvisorReport;
import com.adiverse.erp.openpdf.UniversitySsrReport;
import com.adiverse.erp.openpdf.UnivertyExtendedProfileReport;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.Criteria5Service;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.DocumentException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class Criteria5Controller {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Criteria5Service criteria5Service;

	@Autowired
	private AutonomousQualityAdvisorReport pDF5GeneratorService;

	@Autowired
	private UniversityQualityAdvisorReport universityReport;

	@Autowired
	private AffiliatedQualityAdivisorReport affiliatedReport;

	// autonoums SsR

	@Autowired
	private AutonoumsSsr autonoumsSsr;

	@Autowired
	private AutonomousExtendedProfileReport autonomousExtendedProfileReport;

//	@Autowired
//	private AuthonomousCriteria1Report authonomousCriteria1Report;
//
//	@Autowired
//	private AutonomousCriteria2Report autonomousCriteria2Report;
//
//
//	@Autowired
//	private AutonomousCriteria4Report autonomousCriteria4Report;
//
//	@Autowired
//	private AutonomousCriteria5Report autonomousCriteria5Report;
//
//	@Autowired
//	private AutonomousCriteria6Report autonomousCriteria6Report;
//	@Autowired
//	private AutonomousCriteria7Report autonomousCriteria7Report;

	/// Affiliate

	@Autowired
	private AffiliatedSsrReport affiliatedSsrReport;

	@Autowired
	private AffilatedCriteria1Report affilatedCriteria1Report;

//	@Autowired
//	private AffiliatedCriteria2Report affiliatedCriteria2Report;
//
//	@Autowired
//	private AffilatedCriteria3Report affilatedCriteria3Report;
//
//	@Autowired
//	private AffiliatedCriteria4Report affiliatedCriteria4Report;
//
//	@Autowired
//	private AffiliatedCriteria5Report affiliatedCriteria5Report;
//
//	@Autowired
//	private AffiliatedCriteria6Report affiliatedCriteria6Report;

//	@Autowired
//	private AffiliatedCriteria7Report affiliatedCriteria7Report;

	// UNIVERSITY
	@Autowired
	private UniversitySsrReport universitySsrReport;

	@Autowired
	private UnivertyExtendedProfileReport univertyExtendedProfileReport;

//	@Autowired
//	private UniversityCriteria1Report universityCriteria1Report;
//	@Autowired
//	private UniversityCriteria2Report universityCriteria2Report;
//	@Autowired
//	private UniversityCriteria3Report universityCriteria3Report;
//	@Autowired
//	private UniversityCriteria4Report universityCriteria4Report;
//	@Autowired
//	private UniversityCriteria5Report universityCriteria5Report;
//
//	@Autowired
//	private UniversityCriteria6Report universityCriteria6Report;
//
//	@Autowired
//	private UniversityCriteria7Report universityCriteria7Report;
	

    @Autowired
	private TrackingService trackingService;
	
	
	
	@PostMapping(value = "/criteria5submit")
	public ResponseEntity<MessageResponse> Criteria5( @RequestParam Map<String, String> allParams)
//			@RequestPart(name = "criteria5Fieldinfo") Criteria5_FieldInfo criteria5Fieldinfo)
	 {

		String message = "";
		try {
//			Map<String, String> allParams = new HashMap<String, String>();
//			allParams.put("collegeId", criteria5Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear", criteria5Fieldinfo.getCriteriaId().getFinancialYear() );
////			allParams.put("typeofInstitution", criteria5Fieldinfo.getCriteriaId().getTypeofInstitution() );
			allParams.put("role","faculty");
			criteria5Service.criteria5Info(allParams);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}
	
	
	
	@PostMapping("/criteria5submittoprincipal")
	public String deanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

	{
    	System.out.println("criteria5submittoprincipal");
    	ObjectMapper mapper =new ObjectMapper();
    	try {
			System.out.println(mapper.writeValueAsString(tracking));

			System.out.println("allparams==>"+mapper.writeValueAsString(allParams));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String status1 = null;
		Map<String, String> allParams1 = new HashMap<String, String>();
		allParams1.put("collegeId", tracking.getCriteriaId().getCollegeId() );
		allParams1.put("financialYear", tracking.getCriteriaId().getFinancialYear() );
		allParams1.put("typeofInstitution", tracking.getCriteriaId().getTypeofInstitution() );
		allParams1.put("role",tracking.getRole());
		try {
			System.out.println("allparems===++>>"+mapper.writeValueAsString(allParams1));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("start");
		trackingService.authorizedInfo(tracking);
		status1 =criteria5Service.criteria5Info(allParams1);
		
  		

//		status1 = trackingService.sendAutomatedEmail(tracking, institutionType);

		return status1;
	}
	
	
	
	

	@PostMapping(value = "/criteria5upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Criteria5(
			@RequestPart(name = "criteria5Fieldinfo") Criteria5_FieldInfo criteria5Fieldinfo,
			@RequestPart(name = "uploadfile5") MultipartFile[] uploadfile5) {

		String message = "";
		try {
			criteria5Service.criteria5Info(criteria5Fieldinfo, uploadfile5);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/criteria5getallfiles")
	public ResponseEntity<List<Criteria5_FieldInfo>> getCriteria5ListFiles(
			@RequestParam Map<String, String> allParams) {

		System.out.println("params are --->" + allParams);

		List<Criteria5_FieldInfo> files4 = criteria5Service.getAllCriteria5Data(allParams);

		return ResponseEntity.status(HttpStatus.OK).body(files4);
	}

	@GetMapping("/pdf5/generate")
	public void generate4PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

//		pDF5GeneratorService.generateReport();

	}

	@GetMapping("/university/generate")
	public void generateUniversityPDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

//		universityReport.generateReport();

	}
	// authonomousCriteria11Report2

	@GetMapping("/authonomousCriteria11Report2/generate")
	public void generateaAuthonomousCriteria11Report2(HttpServletResponse response)
			throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

//   		authonomousCriteria11Report2.generateReport();
	}

	@GetMapping("/affiliated/generate")
	public void generateaAffiliatedPDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

//		affiliatedReport.generateReport();
	}

	@GetMapping("/autonoumsSsr/generate")
	public void generateautonoumsSsr(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		autonoumsSsr.generateReport();
	}

	@GetMapping("/autonomousExtendedProfileReport/generate")
	public void generateautonomousExtendedProfileReport(HttpServletResponse response)
			throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

//		autonomousExtendedProfileReport.generateReport();
	}

	@GetMapping("/authonomousCriteria1Report/generate")
	public void generateautonomousauthonomousCriteria1Report(HttpServletResponse response)
			throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//authonomousCriteria1Report.generateReport();
	}

	@GetMapping("/autonomouscriteria2/generate")
	public void generateaautonomouscriteria2PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//autonomousCriteria2Report.generateReport();
	}

	@GetMapping("/autonomouscriteria3/generate")
	public void generateautonomouscriteria3PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

	//	autonomousCriteria3Report.generateReport();
	}

	@GetMapping("/autonomouscriteria4/generate")
	public void generateautonomouscriteria4PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//autonomousCriteria4Report.generateReport();
	}

	@GetMapping("/autonomousCriteria5Report/generate")
	public void generateautonomousCriteria5Report(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

	//	autonomousCriteria5Report.generateReport();
	}

	@GetMapping("/autonomouscriteria6/generate")
	public void generateautonomouscriteria6PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

	//	autonomousCriteria6Report.generateReport();
	}

	@GetMapping("/autonomouscriteria7/generate")
	public void generateautonomouscriteria7PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//autonomousCriteria7Report.generateReport();
	}

	// AFFI;IATED
	@GetMapping("/affiliatedSsrReport/generate")
	public void generateaffiliatedSsrReport(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		affiliatedSsrReport.generateReport();
	}

	@GetMapping("/affiliatedExtendedProfileReport/generate")
	public void generateaffiliatedExtendedProfileReportt(HttpServletResponse response)
			throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

// 		affiliatedExtendedProfileReport.generateReport();
	}

	@GetMapping("/affilatedCriteria1Report/generate")
	public void generateaffilatedCriteria1Report(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		affilatedCriteria1Report.generateReport();
	}

	@GetMapping("/affiliatedcriteria2/generate")
	public void generateaffiliatedcriteria2PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//affiliatedCriteria2Report.generateReport();
	}

	@GetMapping("/affilatedCriteria3Report/generate")
	public void generateaffilatedCriteria3Report(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//affilatedCriteria3Report.generateReport();
	}

	@GetMapping("/affiliatedcriteria4/generate")
	public void generateaffiliatedcriteria4PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//affiliatedCriteria4Report.generateReport();
	}

	@GetMapping("/affiliatedCriteria5Report/generate")
	public void generateaffiliatedCriteria5Report(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//affiliatedCriteria5Report.generateReport();
	}

	@GetMapping("/affiliatedCriteria6Report/generate")
	public void generateaffiliatedCriteria6Report(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//affiliatedCriteria6Report.generateReport();
	}

	@GetMapping("/affiliatedCriteria7Report/generate")
	public void generateaffiliatedCriteria7Report(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

	//	affiliatedCriteria7Report.generateReport();
	}

//UNIVERSITY

	@GetMapping("/universitySsrReport/generate")
	public void generateuniversitySsrReport(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		universitySsrReport.generateReport();
	}

	@GetMapping("/univertyExtendedProfileReport/generate")
	public void generateunivertyExtendedProfileReport(HttpServletResponse response)
			throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

//		univertyExtendedProfileReport.generateReport();
	}

	@GetMapping("/universitycriteria1/generate")
	public void generateuniversitycriteria1PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//universityCriteria1Report.generateReport();
	}

	@GetMapping("/universitycriteria2/generate")
	public void generateuniversitycriteria2PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//universityCriteria2Report.generateReport();
	}

	@GetMapping("/universitycriteria3/generate")
	public void generateuniversitycriteria3PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//universityCriteria3Report.generateReport();
	}

	@GetMapping("/universitycriteria4/generate")
	public void generateuniversitycriteria4PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//universityCriteria4Report.generateReport();
	}

	@GetMapping("/universitycriteria5/generate")
	public void generateuniversitycriteria5PDF(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//universityCriteria5Report.generateReport();
	}

	@GetMapping("/universityCriteria6Report/generate")
	public void generateuniversityCriteria6Report(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//universityCriteria6Report.generateReport();
	}

	@GetMapping("/universityCriteria7Report/generate")
	public void generateuniversityCriteria7Report(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		//universityCriteria7Report.generateReport();
	}

// autonomous criteria 5

	@PostMapping("/autonomouscriteria5Email")
	public String AutonomousCriteria5Email(@RequestPart Tracking tracking)

	{
		String status1 = null;

		criteria5Service.authorizedInfo(tracking);

//	status1 = trackingService.sendAutonomousCriteria5Email();

		return status1;
	}

	@PostMapping("/affiliatedcriteria5Email")
	public String Affiliatedcriteria5Email(@RequestPart Tracking tracking) {
		String status1 = null;
		criteria5Service.authorizedInfo(tracking);
//status1= trackingService.sendAffiliatedCriteria5Email();

		return status1;

	}

	@PostMapping("/universityCriteria5Email")
	public String UniversityCriteria5Email(@RequestPart Tracking tracking) {
		String status1 = null;
		criteria5Service.authorizedInfo(tracking);
//	status1= trackingService.sendUniversityCriteria5Email();
		return status1;
	}
	
	
	
	

}
