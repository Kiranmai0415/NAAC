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

import com.adiverse.erp.model.ExtendedProfile;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.SsrService;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class SSRController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SsrService ssrService;
	
	@Autowired
	private TrackingService trackingService;
    

	@PostMapping(value = "/ssrupload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Ssr(@RequestPart(name = "ssrData") ProfileoftheCollege ssrData,
			@RequestPart(name = "uploadSsrfile", required=false) MultipartFile[] uploadSsrfile) {

		System.out.println("ssrupload");
		String message = "";
		try {
			ssrService.ssrInfo(ssrData, uploadSsrfile);

			message = "Uploaded the SSR data and files successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the SSR data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}
	
	
	 @PostMapping("/ssruploadsubmittoprincipal")
		public String ssruploadDeanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

		{
	    	System.out.println("ssruploadsubmittoprincipal");
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
		    status1 =ssrService.ssruploadMail(allParams1);
			
			return status1;
		}

	

	
	
	
	@PostMapping(value = "/academicdata", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Academic(@RequestPart ProfileoftheCollege ssrData) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("data is ===>"+mapper.writeValueAsString(ssrData));
		
		String message = "";
		try {
			System.out.println("academicdata");
			
			ssrService.academicInfo(ssrData);

			message = " Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the  Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}
	}
	
	
	 @PostMapping("/academicdatasubmittoprincipal")
		public String extendeDeanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

		{
	    	System.out.println("academicdatasubmittoprincipal");
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
		    status1 =ssrService.academicdataMail(allParams1);
			
			return status1;
		}

	

		
	 @PostMapping("/academicdataDeanRejectRecord")
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

	
	
	
	
	
	
	
	
	

	@GetMapping("/getallacademicdata")
	public ResponseEntity<List<ProfileoftheCollege>> getSsrListFiles(@RequestParam Map<String, String> allParams) {

		System.out.println("params are --->"+allParams);
		List<ProfileoftheCollege> ssrFiles = ssrService.getAllAcademicData(allParams);

		return ResponseEntity.status(HttpStatus.OK).body(ssrFiles);

	}
	
	
	
	@GetMapping("/getallbasicdata")
	public ResponseEntity<List<ProfileoftheCollege>> getSsrListFiles1() {

		List<ProfileoftheCollege> ssrFiles = ssrService.getAllBasicData();

		return ResponseEntity.status(HttpStatus.OK).body(ssrFiles);

	}
	
	//autonomous SSrEmail

		@PostMapping("/autonomousSsrEmail")
		public String AutonomousCriteria4Email(@RequestPart Tracking tracking)

		{
			String status1 = null;

			trackingService.authorizedInfo(tracking);

//			status1 = trackingService.sendAutonomousSsrEmail();

			return status1;
		}

		//affiliated SSr report 
		@PostMapping("/affiliatedSSr")
		public String AffiliatedSsr(@RequestPart Tracking tracking)
		{
		String status1 = null;
		trackingService.authorizedInfo(tracking);
//		status1 = trackingService.sendAffiliatedSsrEmail();
		return status1;
	}
		   
		//University SSr report 
				@PostMapping("/universitySSr")
				public String UniversitySSr(@RequestPart Tracking tracking)
				{
				String status1 = null;
				trackingService.authorizedInfo(tracking);
//				status1 = trackingService.sendUniversitySsr();
				return status1;
			}
				  

}




	