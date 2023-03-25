package com.adiverse.erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adiverse.erp.payload.request.RestAPIRequest;
import com.adiverse.erp.payload.response.RestAPIResponse;
import com.adiverse.erp.service.DashBoardTrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class DashBoardTrackingController {

	@Autowired
	private DashBoardTrackingService dashBoardTrackingService;

	Logger logger = LoggerFactory.getLogger(DashBoardTrackingController.class);

	/*
	 * This method is used for storing the dean reject comments into table and
	 * applicable for autonomous, affiliated and University input params are
	 * tracking object and institutionType=autonomous as parameter
	 */
	@PostMapping("/hodDashBoardRejectRecord")
	public ResponseEntity<RestAPIResponse> hodRejectRecord(@RequestBody RestAPIRequest restAPIRequest, @RequestParam String screenType)
			throws JsonProcessingException

	{
		RestAPIResponse restAPIResponse = null;
		try {
			restAPIResponse = dashBoardTrackingService.trackingInfo(restAPIRequest,screenType);

		//String status = dashBoardTrackingService.sendAutomatedEmail(programsAuthorise, programsAuthorise.getCriteriaId().getTypeofInstitution(),screenType);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(restAPIResponse);
	}

	/*
	 * This method is used for storing the dean authorized record data and
	 * applicable for autonomous, affiliated and University input params are
	 * tracking object and institutionType=autonomous as parameter
	 */
	@PostMapping("/hodDashBoardAuthorizedEmail")
	public ResponseEntity<RestAPIResponse> hodAuthorizedEmail(@RequestBody RestAPIRequest restAPIRequest, @RequestParam String screenType)
	{
		String status1 = null;
		ObjectMapper mapper = new ObjectMapper();
		RestAPIResponse restAPIResponse = null;
		try {
			
			System.out.println("object is ==>"+mapper.writeValueAsString(restAPIRequest));
			System.out.println("screen type ==>"+screenType);
			restAPIResponse = dashBoardTrackingService.trackingInfo(restAPIRequest,screenType);
	
			//status1 = dashBoardTrackingService.sendAutomatedEmail(restAPIRequest, restAPIRequest.getTypeofInstitution(),screenType);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(restAPIResponse);
	}

	/*
	 * This method is used for storing the dean reject comments into table and
	 * applicable for autonomous, affiliated and University input params are
	 * tracking object and institutionType=autonomous as parameter
	 */
//	@PostMapping("/principalDashBoardRejectRecord")
//	public String principalRejectRecord(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)
//			throws JsonProcessingException
//
//	{
//		ObjectMapper mapper = new ObjectMapper();
//		System.out.println(mapper.writeValueAsString(tracking));
//		System.out.println("allparams==>"+mapper.writeValueAsString(allParams));
//		System.out.println("all params are ==>" + allParams);
//		String institutionType = allParams.get("institutionType");
//		trackingService.trackingInfo(tracking);
//
//		String status = trackingService.sendPrincipalAuthorizedEmail(tracking, institutionType);
//
//		return status;
//	}
//
//	/*
//	 * This method is used for storing the dean authorized record data and
//	 * applicable for autonomous, affiliated and University input params are
//	 * tracking object and institutionType=autonomous as parameter
//	 */
//	@PostMapping("/principalDashBoardAuthorizedEmail")
//	public String principalAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams,@RequestParam PrincipalStatus principalstatus)
//
//	{
//		String status1 = null;
//		logger.info("allParams from principalAuthorizedEmail() ==>{}", allParams);
//		String institutionType = allParams.get("institutionType");
//		
//		trackingService.principalStatus(principalstatus);
//
//		trackingService.trackingInfo(tracking);
//		
//		
//
//		status1 = trackingService.sendPrincipalAuthorizedEmail(tracking, institutionType);
//
//		return status1;
//	}
//	
//	
//	
//	
	
	

//	@PostMapping("/UniversityauthorizedEmail")
//	public String UniversityAuthorizedEmail(@RequestBody Tracking tracking)
//
//	{
//		String status1 = null;
//
//		trackingService.authorizedInfo(tracking);
//
//		status1 = trackingService.sendUniversityAuthorizedEmail(tracking);
//
//		return status1;
//	}
//
//	@GetMapping("/getTrackingInfo")
//	public ResponseEntity<List<Tracking>> getTrackingInformation() {
//		List<Tracking> trackingData = trackingService.getTrackingData();
//
//		return ResponseEntity.status(HttpStatus.OK).body(trackingData);
//	}

}
