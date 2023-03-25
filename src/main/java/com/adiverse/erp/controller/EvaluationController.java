package com.adiverse.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.EvaluationService;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EvaluationController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EvaluationService evaluationService;
	@Autowired
	private TrackingService trackingService;

	@PostMapping(value = "/evaluationupload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Ssr(@RequestPart(name = "evaluationData") ProfileoftheCollege evaluationData,
			@RequestPart(name = "evaluationuploadfile") MultipartFile[] evaluationuploadfile) {
		System.out.println("upload data is " + evaluationuploadfile);
		String message = "";
		try {
			evaluationService.evaluationInfo(evaluationData, evaluationuploadfile);

			message = "Uploaded the SSR data and files successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the SSR data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}
	

	 @PostMapping("/evaluationDatasubmittoprincipal")
			public String extendeDeanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

			{
		    	System.out.println("evaluationDatasubmittoprincipal");
		    	ObjectMapper mapper =new ObjectMapper();
		    	try {
					System.out.println("tracking"+mapper.writeValueAsString(tracking));

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
				

				
				try {
					System.out.println("allparems===++>>"+mapper.writeValueAsString(allParams1));
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				trackingService.authorizedInfo(tracking);
				System.out.println("start");
	  		status1 =evaluationService.evaluationMail(allParams1);
				
				return status1;
			}

		
	 @PostMapping("/evaluationDeanRejectRecord")
		public String principalRejectRecord(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)
				throws JsonProcessingException

		{
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writeValueAsString(tracking));
			System.out.println("allparams==>"+mapper.writeValueAsString(allParams));
			System.out.println("all params are ==>" + allParams);
			String institutionType = allParams.get("institutionType");
			trackingService.trackingInfo(tracking);

			String status = trackingService.sendAutomatedEmail(tracking, institutionType);

			return status;
		}

	
	
	
	
	
	

	@GetMapping("/getallevaluation")
	public ResponseEntity<List<ProfileoftheCollege>> getevaluationtotalData(@RequestParam Map<String, String> allParams) {
		
		System.out.println("getallevaluation");
		System.out.println("params are --->"+allParams);
		List<ProfileoftheCollege> evaluation = evaluationService.getAllEvaluationData(allParams);

		return ResponseEntity.status(HttpStatus.OK).body(evaluation);
	}

}
