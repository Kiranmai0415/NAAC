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

import com.adiverse.erp.model.ExecutiveSummary;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.ExecutiveService;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ExecutiveController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExecutiveService executiveService;
	@Autowired
	private TrackingService trackingService;
	
	@PostMapping(value = "/executiveData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Criteria7(
			@RequestPart(name = "executiveSummary") ExecutiveSummary executiveSummary,
			@RequestPart(name = "uploadexecutivefile") MultipartFile[] uploadexecutivefile) {

		String message = "";
		try {
			executiveService.executiveInfo(executiveSummary, uploadexecutivefile);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}
	
 

	 @PostMapping("/executiveDatasubmittoprincipal")
			public String extendeDeanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

			{
		    	System.out.println("executiveDatasubmittoprincipal");
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
	 		    status1 =executiveService.executiveMail(allParams1);
				
				return status1;
			}

	
	 @PostMapping("/evaluativeDeanRejectRecord")
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

	
	
	
	

	@GetMapping("/getallexecutivedata")
	public ResponseEntity<List<ExecutiveSummary>> getCriteria7ListFiles(@RequestParam Map<String, String> allParams) {
		
		System.out.println("params are --->"+allParams);

		List<ExecutiveSummary> files7 = executiveService.getAllExecutiveData(allParams);

		return ResponseEntity.status(HttpStatus.OK).body(files7);
	}

}
