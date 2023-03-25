package com.adiverse.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.adiverse.erp.model.TrackingDetails;
import com.adiverse.erp.service.ExecutiveService;
import com.adiverse.erp.service.TrackingDetailsService;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class TrackingDetailsController 
{
	
	@Autowired 
	private TrackingDetailsService  trackingDetailsService;
	@Autowired
	private TrackingService trackingService;
	

	
	@PostMapping("/principalAuthorizedEmail")
	public String principalAuthorizedEmail(@RequestBody TrackingDetails programsAuthorise)
			throws JsonProcessingException
  {

		System.out.println("principalAuthorizedEmail");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("data from front end is ==>"+mapper.writeValueAsString(programsAuthorise));
			
		trackingDetailsService.trackingDetailsInfo(programsAuthorise);

		String status = trackingDetailsService.sendPrincipalAuthorizedEmails(programsAuthorise);

		return status;			
		
   }
	
	/*
	 * This method is used for storing the dean reject comments into table and
	 * applicable for autonomous, affiliated and University input params are
	 * tracking object and institutionType=autonomous as parameter
	 */
	@PostMapping("/principalRejectEmail")
	public String principalRejectRecord(@RequestBody  TrackingDetails programsAuthorise)
			throws JsonProcessingException

	{
		
		System.out.println("principalRejectEmail");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(programsAuthorise));
//		System.out.println("allparams==>"+mapper.writeValueAsString(allParams));
//		System.out.println("all params are ==>" + allParams);
//		String institutionType = allParams.get("institutionType");
		System.out.println("trackingDetailsService");
		trackingDetailsService.trackingDetailsInfo(programsAuthorise);

		String status = trackingService.sendPrincipalRejetedEmail(programsAuthorise);

		return status;
	}
	
	
	@GetMapping("/getTrackingDetialInfo")
	public ResponseEntity<List<TrackingDetails>> getTrackingInformation(@RequestParam Map<String, String> allParams) {
		List<TrackingDetails> trackingDetialData = trackingDetailsService.getAllTrakingDetialsData(allParams);

		return ResponseEntity.status(HttpStatus.OK).body(trackingDetialData);
	}
	


	
	
	
		
}
