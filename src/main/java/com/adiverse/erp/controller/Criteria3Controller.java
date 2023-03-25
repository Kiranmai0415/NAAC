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

import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.Criteria3Service;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class Criteria3Controller {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    private Criteria3Service criteria3Service;
    
    
    @Autowired
    private TrackingService trackingService;
    
   
	 
    @PostMapping(value = "/criteria3upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> Criteria3(@RequestPart(name = "criteria3Fieldinfo") Criteria3_FieldInfo criteria3Fieldinfo,  @RequestPart(name="uploadfile3") MultipartFile[] uploadfile3)
	{
    	ObjectMapper mapper=new ObjectMapper();
    	try {
			System.out.println("criteria data=========>"+mapper.writeValueAsString(criteria3Fieldinfo));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	 String message = "";
    	    try {
    	    	
    	    	criteria3Service.criteria3Info(criteria3Fieldinfo,uploadfile3);

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	    	log.info("error:"+e);
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	

	}
    
    @PostMapping("/criteria3submittoprincipal")
   	public String deanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

   	{
       	System.out.println("criteria3submittoprincipal");
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
   		status1 =criteria3Service.criteria3Info(allParams1);
   		
     		

//   		status1 = trackingService.sendAutomatedEmail(tracking, institutionType);

   		return status1;
   	}
    
    
    
    
    
    
    
    
    @PostMapping(value = "/criteria3submit")
    public ResponseEntity<MessageResponse> Criteria3( @RequestParam Map<String, String> allParams)
	{
    	
    	 String message = "";
    	    try {
    	    	
//    	    	Map<String, String> allParams = new HashMap<String, String>();
//    			allParams.put("collegeId", criteria3Fieldinfo.getCriteriaId().getCollegeId() );
//    			allParams.put("financialYear", criteria3Fieldinfo.getCriteriaId().getFinancialYear() );
//    			allParams.put("typeofInstitution", criteria3Fieldinfo.getCriteriaId().getTypeofInstitution() );
    	    	
    	    	allParams.put("role","faculty");
    	    	ObjectMapper mapper=new ObjectMapper();
    	    	System.out.println("criteria data"+mapper.writeValueAsString(allParams));
    	    	criteria3Service.criteria3Info(allParams);

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	    	log.info("error:"+e);
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	

	}
    
    
    
    
    
    
    
    
    @GetMapping("/criteria3getallfiles")
    public ResponseEntity<List<Criteria3_FieldInfo>> getCriteria3ListFiles(@RequestParam Map<String, String> allParams) {
    	
		System.out.println("params are --->"+allParams);

      List<Criteria3_FieldInfo> files3 = criteria3Service.getAllCriteria3Data(allParams);
        

      return ResponseEntity.status(HttpStatus.OK).body(files3);
    }
    
    
    @PostMapping("/universityCriteria3ReportEmail")
public String UniversityCriteria3Email(@RequestPart Tracking tracking)
{
   String status1 = null;
   trackingService.authorizedInfo(tracking);
//   status1 = trackingService.sendUniversityCriteria3Email(tracking);
   return status1;
   
}
    
  //autonomous criteria3
	
  	@PostMapping("/autonomouscriteria3Email")
  	public String AutonomousCriteria3Email(@RequestPart Tracking tracking)

  	{
  		String status1 = null;

  		trackingService.authorizedInfo(tracking);

//  		status1 = trackingService.sendAutonomousCriteria3Email(tracking);

  		return status1;
  	}
  	
  //affiliated criteria3
  	@PostMapping("/affiliatedcriteria3Email")
  	public String AffiliatedCriteria3Email(@RequestPart Tracking tracking)
  	{
  		String status1 = null;
  		trackingService.authorizedInfo(tracking);
  		
//  		status1 = trackingService.sendAffiliatedCriteria1Email();
  		return status1;
  	}
  	
  	
  	
  	
}






































