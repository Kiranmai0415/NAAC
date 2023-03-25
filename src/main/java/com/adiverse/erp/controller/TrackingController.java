package com.adiverse.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.service.Criteria1Service;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class TrackingController {

	@Autowired
	private TrackingService trackingService;

	@Autowired
	private Criteria1Service criteria1Service;
	Logger logger = LoggerFactory.getLogger(TrackingController.class);

	/*
	 * This method is used for storing the dean reject comments into table and
	 * applicable for autonomous, affiliated and University input params are
	 * tracking object and institutionType=autonomous as parameter
	 */
	@PostMapping("/deanRejectRecord")
	public String deanRejectRecord(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)
			throws JsonProcessingException

	{
		System.out.println("deanRejectRecord");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(tracking));
		System.out.println("allparams==>"+mapper.writeValueAsString(allParams));
		System.out.println("all params are ==>" + allParams);
		String institutionType = allParams.get("institutionType");
		trackingService.trackingInfo(tracking);

		String status = trackingService.sendAutomatedEmail(tracking, institutionType);

		return status;
	}

	/*
	 * This method is used for storing the dean authorized record data and
	 * applicable for autonomous, affiliated and University input params are
	 * tracking object and institutionType=autonomous as parameter
	 */
	@PostMapping("/deanAuthorizedEmail")
	public String deanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

	{
		System.out.println("deanAuthorizedEmail");
		String status1 = null;
		String institutionType = allParams.get("institutionType");
		trackingService.authorizedInfo(tracking);
	

		Map<String, String> allParams1 = new HashMap<String, String>();
		allParams1.put("collegeId",tracking.getCriteriaId().getCollegeId() );
		allParams1.put("financialYear", tracking.getCriteriaId().getFinancialYear());

		allParams1.put("typeofInstitution", tracking.getCriteriaId().getTypeofInstitution() );
		allParams1.put("role", tracking.getRole());
		

		ObjectMapper mapper=new ObjectMapper();
		try {
			System.out.println("deanAuthorizedEmail===>"+mapper.writeValueAsString(tracking)+"\r\n"+"allparams===>"+mapper.writeValueAsString(allParams));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		status1 = criteria1Service.criteria1Info(allParams1);

		return status1;
	}



	/*
	 * This method is used for storing the dean authorized record data and
	 * applicable for autonomous, affiliated and University input params are
	 * tracking object and institutionType=autonomous as parameter
	 */
//	@PostMapping("/principalAuthorizedEmail")
//	public String principalAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)
//
//	{
//		String status1 = null;
//		logger.info("allParams from principalAuthorizedEmail() ==>{}", allParams);
//		String institutionType = allParams.get("institutionType");
//		
//		trackingService.authorizedInfo(tracking);
//
//		status1 = trackingService.sendPrincipalAuthorizedEmail(tracking, institutionType);
//
//		return status1;
//	}
	
	
	

	@PostMapping("/UniversityauthorizedEmail")
	public String UniversityAuthorizedEmail(@RequestBody Tracking tracking)

	{
		String status1 = null;

		trackingService.authorizedInfo(tracking);

		status1 = trackingService.sendUniversityAuthorizedEmail(tracking);

		return status1;
	}

	@GetMapping("/getTrackingInfo")
	public ResponseEntity<List<Tracking>> getTrackingInformation() {
		List<Tracking> trackingData = trackingService.getTrackingData();

		return ResponseEntity.status(HttpStatus.OK).body(trackingData);
	}

}
