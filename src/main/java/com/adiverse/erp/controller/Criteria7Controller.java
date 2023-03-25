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

import com.adiverse.erp.model.Criteria7_FieldInfo;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.Criteria7Service;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class Criteria7Controller {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private Criteria7Service criteria7Service;
	
	@Autowired
	private TrackingService trackingService;
    
   
	
	
	
	@PostMapping(value = "/criteria7submit")
    public ResponseEntity<MessageResponse> Criteria7( @RequestParam Map<String, String> allParams)
	{
    	
    	 String message = "";
    	    try {
//    	    	Map<String, String> allParams = new HashMap<String, String>();
//    			allParams.put("collegeId", criteria7Fieldinfo.getCriteriaId().getCollegeId() );
//    			allParams.put("financialYear", criteria7Fieldinfo.getCriteriaId().getFinancialYear() );
//    			allParams.put("typeofInstitution", criteria7Fieldinfo.getCriteriaId().getTypeofInstitution() );
    	    	allParams.put("role","faculty");
    	    	criteria7Service.criteria7Info(allParams);
//    	    	trackingService.sendFacultyAutonomusEmail();

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	
    	    
	}
	
	
 
    
    @PostMapping("/criteria7submittoprincipal")
	public String deanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

	{
    	System.out.println("criteria7submittoprincipal");
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
		status1 =criteria7Service.criteria7Info(allParams1);
		
  		trackingService.authorizedInfo(tracking);

//		status1 = trackingService.sendAutomatedEmail(tracking, institutionType);

		return status1;
	}
    
    
	
	
	
	 
    @PostMapping(value = "/criteria7upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> Criteria1(@RequestPart(name = "criteria7Fieldinfo") Criteria7_FieldInfo criteria7Fieldinfo,  @RequestPart(name="uploadfile7") MultipartFile[] uploadfile7)
	{
    	System.out.println("criteria7upload");
    	ObjectMapper mapper=new ObjectMapper();
    	
    	 String message = "";
    	    try {
//    	    	System.out.println("criteria7upload==>"+mapper.writeValueAsString(criteria7Fieldinfo));

    	    	System.out.println("criteria7upload==>"+uploadfile7.length);

    	    	criteria7Service.criteria7Info(criteria7Fieldinfo,uploadfile7);
//    	    	trackingService.sendFacultyAutonomusEmail();
    	    	System.out.println("criteria7upload==>");

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	    	e.printStackTrace();
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	
    	    
	}
    
    @GetMapping("/criteria7getallfiles")
    public ResponseEntity<List<Criteria7_FieldInfo>> getCriteria7ListFiles(@RequestParam Map<String, String> allParams) {
    	
		System.out.println("params are --->"+allParams);

      List<Criteria7_FieldInfo> files = criteria7Service.getAllCriteria7Data(allParams);
        

      return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    
    //autonoums email 
    

	// criteria 7
	@PostMapping("/autonomouscriteria7Email")
	public String AutonomousCriteria7Email(@RequestPart Tracking tracking)

	{
		String status1 = null;

		trackingService.authorizedInfo(tracking);

//		status1 = trackingService.sendAutonomousCriteria7Email(tracking);

		return status1;
	}

    
    
   //affiliated  email
    @PostMapping("/affiliatedcriteria7Email")
    public String AffliatedCriteria7Email(@RequestPart Tracking tracking)
    {
    	String status1 = null;
    	trackingService.authorizedInfo(tracking);
//    	status1= trackingService.sendAffiliatedCriteria7Email(tracking);
    	return status1;
    	
    }
    

   //universityemail

@PostMapping("/universityCriteria7Email")
public String UniversityCriteria7Email(@RequestPart Tracking tracking)
{
	String status1 = null;
	trackingService.authorizedInfo(tracking);
//	status1= trackingService.sendUniversityCriteria7Email(tracking);
	return status1;
	
}


}

































