package com.adiverse.erp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.ExtendedProfile;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.openpdf.AutonomousExtendedProfileReport;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.ExtendedService;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.DocumentException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ExtendedController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExtendedService extendedService;
	
	@Autowired
	private TrackingService trackingService;
	
	@Autowired
	private AutonomousExtendedProfileReport  autonomousExtendedProfileReport;

	@PostMapping(value = "/extendeddata",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Extended(@RequestPart ExtendedProfile extendedProfile) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("data is ==>"+mapper.writeValueAsString(extendedProfile));
		String message = "";
		try {
			extendedService.extendedInfo(extendedProfile);

			message = "EXTENDED Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the EXTENDED Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}
	}
	
	
	 @PostMapping("/extendeddatasubmittoprincipal")
		public String extendeDeanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

		{
	    	System.out.println("extendeddatasubmittoprincipal");
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
		    status1 =extendedService.extendedMail(allParams1);
			
			return status1;
		}

	
	 
	 @PostMapping("/extendedDeanRejectRecord")
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

	 
	 
		

	@GetMapping("/getallextendeddata")
	public ResponseEntity<List<ExtendedProfile>> getExtendedtotalData(@RequestParam Map<String, String> allParams) {
		List<ExtendedProfile> extended = null;
		
		try {

		extended = extendedService.getAllExtendedData(allParams);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(extended);
	}
	
	
	
	
	
	
	
	
	
	//autonoums email
	@PostMapping("/extendedProfileEmail")
	public String ExtendedProfileEmail(@RequestPart Tracking tracking)
	{
	String 	status1 = null;
	trackingService.authorizedInfo(tracking);
	
//	Map<String, String> allParams = new HashMap<String, String>();
//	allParams.put("collegeId", tracking.getCriteriaId().getCollegeId() );
//	allParams.put("financialYear", tracking.getCriteriaId().getFinancialYear() );
//	allParams.put("typeofInstitution", tracking.getCriteriaId().getTypeofInstitution() );
//	
//	
//	status1= trackingService.sendAutonomousExtendedProfileEmail();
	return status1;
	}
	
	
	
	//affiliated ExtendProfile
	
		@PostMapping("/affiliatedExtendedProfileEmail")
		public String AffiliatedExtendedProfileEmail(@RequestPart Tracking tracking)
		{
			String status1 = null;
			trackingService.authorizedInfo(tracking);
//			status1 = trackingService.sendAffiliatedExtendedProfileEmail();
			return status1;
		}
		

		@PostMapping("/universityExtendedProfileEmail")
		public String UniversityExtendedProfileEmail(@RequestPart Tracking tracking)
		{
			String status1 = null;
			trackingService.authorizedInfo(tracking);
			//status1 = trackingService.sendUniversityExtendedProfileEmail();
			return status1;
		}
		
		//affliated file
		
		 @PostMapping(value = "/extendedfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
		//  @RequestMapping(value = "/extendedfile", produces = {MediaType.APPLICATION_JSON}, consumes = {MediaType.APPLICATION_JSON})
		    public ResponseEntity<MessageResponse> Extended1(@RequestPart(name = "extendedProfile") ExtendedProfile extendedProfile,  @RequestPart(name="uploadextendedfile") MultipartFile[] uploadextendedfile)
			{
		    	
		    	 String message = "";
		    	    try {
		    	    	System.out.println("extendedfile");
		    	    	extendedService.extendedInfo(extendedProfile,uploadextendedfile);

		    	      message = "Uploaded the file successfully:";
		    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		    	    } catch (Exception e) {
		    	      message = "Could not upload the file: ";
		    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		    	    }
		    	

			}
		 
		  @GetMapping("/pdf11115/generate")
		   	public void generate(HttpServletResponse response) throws DocumentException, IOException {
		   		
		   		response.setContentType("application/pdf");
		   		DateFormat dateFormatter=new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		   		String currentDateTime=dateFormatter.format(new Date());
		   		
		   		String headerKey="Content-Disposition";
		   	  String headerValue="attachment;filename=pdf_"+ currentDateTime+".pdf";
		   		response.setHeader(headerKey, headerValue);
		   		
//		   		autonomousExtendedProfileReport.generateReport();
		   		
		   
		}

}
