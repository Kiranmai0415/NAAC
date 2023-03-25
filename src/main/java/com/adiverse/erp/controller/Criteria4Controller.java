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

import com.adiverse.erp.model.Criteria4_FieldInfo;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.Criteria4Service;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class Criteria4Controller {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    private Criteria4Service criteria4Service;
    
    @Autowired
	private TrackingService trackingService;
    
	 
    @PostMapping(value = "/criteria4upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> Criteria4(@RequestPart(name = "criteria4Fieldinfo") Criteria4_FieldInfo criteria4Fieldinfo,  @RequestPart(name="uploadfile4") MultipartFile[] uploadfile4)
	{
    	
    	 String message = "";
    	    try {
    	    	criteria4Service.criteria4Info(criteria4Fieldinfo,uploadfile4);

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	

	}
    
    
    
    @PostMapping(value = "/criteria4submit")
    public ResponseEntity<MessageResponse> Criteria4( @RequestParam Map<String, String> allParams)
	{
    	
    	 String message = "";
    	    try {
    	    	
    	    	
    	    	
//    	    	Map<String, String> allParams = new HashMap<String, String>();
//    			allParams.put("collegeId", criteria4Fieldinfo.getCriteriaId().getCollegeId() );
//    			allParams.put("financialYear", criteria4Fieldinfo.getCriteriaId().getFinancialYear() );
//    			allParams.put("typeofInstitution", criteria4Fieldinfo.getCriteriaId().getTypeofInstitution() );
    	    	allParams.put("role","faculty");
    	    	criteria4Service.criteria4Info(allParams);

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	

	}
    
    @PostMapping("/criteria4submittoprincipal")
   	public String deanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

   	{
       	System.out.println("criteria4submittoprincipal");
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

   		status1 =criteria4Service.criteria4Info(allParams1);
   		
     		
//   		status1 = trackingService.sendAutomatedEmail(tracking, institutionType);

   		return status1;
   	}
       
    
    
    
    
    
    
    @GetMapping("/criteria4getallfiles")
    public ResponseEntity<List<Criteria4_FieldInfo>> getCriteria4ListFiles(@RequestParam Map<String, String> allParams) {
    	
		System.out.println("params are --->"+allParams);

      List<Criteria4_FieldInfo> files4 = criteria4Service.getAllCriteria4Data(allParams);
        

      return ResponseEntity.status(HttpStatus.OK).body(files4);
    }

  //autonomous criteria 4

  	@PostMapping("/autonomouscriteria4Email")
  	public String AutonomousCriteria4Email(@RequestPart Tracking tracking)

  	{
  		String status1 = null;

  		trackingService.authorizedInfo(tracking);

//  		status1 = trackingService.sendAutonomousCriteria4Email();

  		return status1;
  	}
  
  //affiliatedcriteria4
  	@PostMapping("/affiliatedcriteria4Email")

  	public String Affiliatedcriteria4Email(@RequestPart Tracking tracking)
  	{
  	  String status1 = null;
  	trackingService.authorizedInfo(tracking);
//  	  status1 = trackingService.sendAffiliatedCriteria4Email();
  	  return status1;
  	}	
  	
  	@PostMapping("/universityCriteria4Email")
  	public String UniversityCriteria4Email(@RequestPart Tracking tracking)
  	{
  	String 	status1 = null;
  	trackingService.authorizedInfo(tracking);
//  	status1= trackingService.sendUniversityCriteria4Email();
  	return status1;
  	}
     
}






































