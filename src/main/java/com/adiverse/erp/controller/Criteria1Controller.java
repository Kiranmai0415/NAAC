package com.adiverse.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.AssignEmail;
import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.Criteria5_FieldInfo;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.payload.request.RestAPIRequest;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.payload.response.RestAPIResponse;
import com.adiverse.erp.service.Criteria1Service;
import com.adiverse.erp.service.Criteria2Service;
import com.adiverse.erp.service.Criteria3Service;
import com.adiverse.erp.service.Criteria5Service;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class Criteria1Controller {

	private final Logger logger = LoggerFactory.getLogger(Criteria1Controller.class);

	@Autowired
	private Criteria1Service criteria1Service;

	@Autowired
	private Criteria2Service criteria2Service;

	@Autowired
	private Criteria3Service criteria3Service;

	@Autowired
	private Criteria5Service criteria5Service;

	@Autowired
	private TrackingService trackingService;

	@GetMapping("/viewResponseValueAffiliated122")
	public ResponseEntity<Integer> getResponseValue122(@RequestParam Map<String, String> allParams) {

		List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getYearTable2111().get(0).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(1).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(2).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(3).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(4).getInput2111v());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}

	@GetMapping("/viewResponseValueAffiliated132")
	public ResponseEntity<Integer> getResponseValue132(@RequestParam Map<String, String> allParams) {

		List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getYearTable2111().get(0).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(1).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(2).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(3).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(4).getInput2111v());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}

	@GetMapping("/viewResponseValueAffiliated241")
	public ResponseEntity<Integer> getResponseValue241(@RequestParam Map<String, String> allParams) {

		List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getCriteria24Qn().get(0).getResponse241());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}

	@GetMapping("/viewResponseValueAffiliated242")
	public ResponseEntity<Integer> getResponseValue242(@RequestParam Map<String, String> allParams) {

		List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getYearTable2411().get(0).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(1).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(2).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(3).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(4).getInput2411v());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(1);
		}

	}

	@GetMapping("/viewResponseValueAffiliated331")
	public ResponseEntity<Integer> getResponseValue331(@RequestParam Map<String, String> allParams) {

		List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getYearTable2411().get(0).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(1).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(2).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(3).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(4).getInput2411v());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}

	@GetMapping("/viewResponseValueAffiliated332")
	public ResponseEntity<Integer> getResponseValue332(@RequestParam Map<String, String> allParams) {

		List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getYearTable2411().get(0).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(1).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(2).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(3).getInput2411v())
				+ Integer.parseInt(files.get(0).getYearTable2411().get(4).getInput2411v());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}

	@GetMapping("/viewResponseValueAffiliated412")
	public ResponseEntity<Integer> getResponseValue412(@RequestParam Map<String, String> allParams) {

		List<Criteria3_FieldInfo> files = criteria3Service.getAllCriteria3Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getAffiliatedYearTable3111().get(0).getInput3111v())
				+ Integer.parseInt(files.get(0).getAffiliatedYearTable3111().get(1).getInput3111v())
				+ Integer.parseInt(files.get(0).getAffiliatedYearTable3111().get(2).getInput3111v())
				+ Integer.parseInt(files.get(0).getAffiliatedYearTable3111().get(3).getInput3111v())
				+ Integer.parseInt(files.get(0).getAffiliatedYearTable3111().get(4).getInput3111v());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}

	@GetMapping("/viewResponseValueAffiliated441")
	public ResponseEntity<Integer> getResponseValue441(@RequestParam Map<String, String> allParams) {

		List<Criteria3_FieldInfo> files = criteria3Service.getAllCriteria3Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getAffiliatedYearTable3111().get(0).getInput3111v())
				+ Integer.parseInt(files.get(0).getAffiliatedYearTable3111().get(1).getInput3111v())
				+ Integer.parseInt(files.get(0).getAffiliatedYearTable3111().get(2).getInput3111v())
				+ Integer.parseInt(files.get(0).getAffiliatedYearTable3111().get(3).getInput3111v())
				+ Integer.parseInt(files.get(0).getAffiliatedYearTable3111().get(4).getInput3111v());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}

	@GetMapping("/viewResponseValueAffiliated511")
	public ResponseEntity<Integer> getResponseValue511(@RequestParam Map<String, String> allParams) {

		List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getAffiliatedyearTable2631().get(0).getInput2631v())
				+ Integer.parseInt(files.get(0).getAffiliatedyearTable2631().get(1).getInput2631v())
				+ Integer.parseInt(files.get(0).getAffiliatedyearTable2631().get(2).getInput2631v())
				+ Integer.parseInt(files.get(0).getAffiliatedyearTable2631().get(3).getInput2631v())
				+ Integer.parseInt(files.get(0).getAffiliatedyearTable2631().get(4).getInput2631v());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}

	@GetMapping("/viewResponseValueAffiliated513")
	public ResponseEntity<Integer> getResponseValue513(@RequestParam Map<String, String> allParams) {

		List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getAffiliatedyearTable2631().get(0).getInput2631v())
				+ Integer.parseInt(files.get(0).getAffiliatedyearTable2631().get(1).getInput2631v())
				+ Integer.parseInt(files.get(0).getAffiliatedyearTable2631().get(2).getInput2631v())
				+ Integer.parseInt(files.get(0).getAffiliatedyearTable2631().get(3).getInput2631v())
				+ Integer.parseInt(files.get(0).getAffiliatedyearTable2631().get(4).getInput2631v());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}

	@GetMapping("/viewResponseValueAffiliated522")
	public ResponseEntity<Integer> getResponseValue522(@RequestParam Map<String, String> allParams) {

		List<Criteria5_FieldInfo> files = criteria5Service.getAllCriteria5Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getCriteria52Qn().get(0).getInput522t2())
				- Integer.parseInt(files.get(0).getCriteria52Qn().get(0).getInput522t2());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}

	@GetMapping("/viewResponseValueAffiliated632")
	public ResponseEntity<Integer> getResponseValue632(@RequestParam Map<String, String> allParams) {

		List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);

		int responsevalue = Integer.parseInt(files.get(0).getYearTable2111().get(0).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(1).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(2).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(3).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(4).getInput2111v());
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(1);
		}

	}

	@GetMapping("/viewResponseValueAffiliated652")
	public ResponseEntity<Integer> getResponseValue652(@RequestParam Map<String, String> allParams) {

		List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);

		int responsevalue = (Integer.parseInt(files.get(0).getYearTable2111().get(0).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(1).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(2).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(3).getInput2111v())
				+ Integer.parseInt(files.get(0).getYearTable2111().get(4).getInput2111v()));
		if (responsevalue > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}

	/////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping(value = "/criteria1upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Criteria1(
			@RequestPart(name = "criteria1Fieldinfo") Criteria1_FieldInfo criteria1Fieldinfo,
			@RequestPart(name = "uploadfile1") MultipartFile[] uploadfile1) {

		String message = "";
		try {
			System.out.println("criteria1upload");
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("criteria1upload" + mapper.writeValueAsString(criteria1Fieldinfo) + "\r\n");
			criteria1Service.criteria1Info(criteria1Fieldinfo, uploadfile1);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			e.printStackTrace();
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@PostMapping(value = "/criteria1submit")
	public ResponseEntity<MessageResponse> Criteria1(@RequestParam Map<String, String> allParams) {

		System.out.println("data");

		String message = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("criteria1submit====>" + mapper.writeValueAsString(allParams));
//        
//         Map<String, String> allParams1 = new HashMap<String, String>();
//         allParams1.put("collegeId", tracking.getCriteriaId().getCollegeId() );
//         allParams1.put("financialYear", tracking.getCriteriaId().getFinancialYear() );
//         allParams1.put("typeofInstitution", tracking.getCriteriaId().getTypeofInstitution() );
			allParams.put("role", "faculty");
			criteria1Service.criteria1Info(allParams);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@PostMapping("/criteria1submittoprincipal")
	public String deanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

	{
		System.out.println("criteria1submittoprincipal");
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("tracking" + mapper.writeValueAsString(tracking));

			System.out.println("allparams==>" + mapper.writeValueAsString(allParams));
		} catch (JsonProcessingException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String status1 = null;
		Map<String, String> allParams1 = new HashMap<String, String>();
		allParams1.put("collegeId", tracking.getCriteriaId().getCollegeId());
		allParams1.put("financialYear", tracking.getCriteriaId().getFinancialYear());
		allParams1.put("typeofInstitution", tracking.getCriteriaId().getTypeofInstitution());
		allParams1.put("role", tracking.getRole());
		System.out.println(tracking.getRole());

		try {
			System.out.println("allparems===++>>" + mapper.writeValueAsString(allParams1));
		} catch (JsonProcessingException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trackingService.authorizedInfo(tracking);
		System.out.println("start");
		status1 = criteria1Service.criteria1Info(allParams1);

// status1 = trackingService.sendAutomatedEmail(tracking, institutionType);

		return status1;
	}

	/*
	 * just for sending the value
	 */

	@GetMapping("/viewResponseValue")
	public ResponseEntity<Integer> getResponseValue() {
		int value = 10;
		return ResponseEntity.status(HttpStatus.OK).body(value);
	}

	@GetMapping("/criteria1getallfiles")
	public ResponseEntity<List<Criteria1_FieldInfo>> getCriteria1ListFiles(
			@RequestParam Map<String, String> allParams) {

		System.out.println("params are --->" + allParams);

		List<Criteria1_FieldInfo> files = criteria1Service.getAllCriteria1Data(allParams);

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	//
//api for download files
	@GetMapping("/download/{filename:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = criteria1Service.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFilename() + "\"")
				.body(file);

	}

	@PostMapping("/AssignC1Email")
	public String C1AssignEmail(@RequestBody AssignEmail c1details)

	{
		criteria1Service.assign1Info(c1details);
		String status = criteria1Service.sendCriteria1AssignEmail(c1details);

		return status;
	}

//    @PostMapping("/authorizedEmail")
//    public String AuthorizedEmail()
//    
//    {
//     //User user = new User();
//     //GeneralParameter param = new GeneralParameter();
//     //criteria1Service.sendAuthorizedEmail(user);
//     //criteria1Service.sendAuthorizedEmail1(param);
//        String status1  = criteria1Service.sendAuthorizedEmail(user);
//        String status2  = criteria1Service.sendAuthorizedEmail1(param);
//
//        return status2;
//    }
//    

	@PostMapping("/autonomouscriteria1Email")
	public String AutonomousCriteria1Email(@RequestPart Tracking tracking)

	{
		String status1 = null;

		criteria1Service.authorizedInfo(tracking);

// status1 = trackingService.sendAutonomousCriteria1Email();

		return status1;
	}

	// /affiliated criteria1

	@PostMapping("/affiliatedcriteria1Email")
	public String AffiliatedCriteria1Email(@RequestPart Tracking tracking) {
		String status1 = null;
		criteria1Service.authorizedInfo(tracking);
//     status1 = trackingService.sendAffiliatedCriteria1Email();
		return status1;
	}

	// university

	@PostMapping("/universityCriteria1Email")
	public String UniversityCriteria1Email(@RequestPart Tracking tracking) {
		String status1 = null;
		criteria1Service.authorizedInfo(tracking);
//    status1= trackingService.sendUniversityCriteria1Email();
		return status1;
	}

	@PostMapping("/valueAddedServiceUpdate")
	public ResponseEntity<RestAPIResponse> requestFromFacultydashboard(@RequestBody RestAPIRequest apiRequest) {
		RestAPIResponse response = new RestAPIResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			logger.info("request object is ==>{}", mapper.writeValueAsString(apiRequest));
			response.setErrorCode("001");
			response.setErrorMessage("Success");
		} catch (Exception e) {
			response.setErrorCode("002");
			response.setErrorMessage("Failed-" + e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}

//@GetMapping("/files/{id}")
//public ResponseEntity<byte[]> getFile1(@PathVariable String name) {
//Criteria1_FileUpload criteria1fileUpload = criteria1Service.getFile(name);
//
//return ResponseEntity.ok()
//    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + criteria1fileUpload.getCriteria1FileName() + "\"")
//    .body(criteria1fileUpload.getData());
//}

//List<Criteria1_FileUpload> criteria1Files=new ArrayList<>();
//@GetMapping("/downloadfile")
//public ResponseEntity<List<FileResponse>> getListFiles() {
//List<FileResponse> files = criteria1Service.getAllFiles().map(criteria1Files -> {
//  String fileDownloadUri = ServletUriComponentsBuilder
//      .fromCurrentContextPath()
//      .path("/upload")
//      .path(criteria1Files.getCriteria1FileName())
//      .toUriString();
//
//  return new FileResponse(
//   criteria1Files.getCriteria1FileName(),
//      fileDownloadUri,
//      criteria1Files.getCriteria1FileType());
//}).collect(Collectors.toList());
//
//return ResponseEntity.status(HttpStatus.OK).body(files);
//}
