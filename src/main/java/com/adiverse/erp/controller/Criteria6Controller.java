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

import com.adiverse.erp.model.Criteria6_FieldInfo;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.Criteria6Service;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class Criteria6Controller {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private Criteria6Service criteria6Service;
    
	
	@Autowired
	private TrackingService trackingService;
	
	 @PostMapping(value = "/criteria6submit")
	    public ResponseEntity<MessageResponse> Criteria6(@RequestParam Map<String, String> allParams)
		{
	    	System.out.println("cr6 controller");
	    	 String message = "";
	    	    try {
//	    	    	Map<String, String> allParams = new HashMap<String, String>();
//	    			allParams.put("collegeId", criteria6Fieldinfo.getCriteriaId().getCollegeId() );
//	    			allParams.put("financialYear", criteria6Fieldinfo.getCriteriaId().getFinancialYear() );
//	    			allParams.put("typeofInstitution", criteria6Fieldinfo.getCriteriaId().getTypeofInstitution() );
	    	    	allParams.put("role","faculty");
	    	    	criteria6Service.criteria6Info(allParams);

	    	      message = "Uploaded the file successfully:";
	    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
	    	    } catch (Exception e) {
	    	      message = "Could not upload the file: ";
	    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
	    	    }
	    	

		}
	
	 
	    
	    @PostMapping("/criteria6submittoprincipal")
		public String deanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

		{
	    	System.out.println("criteria6submittoprincipal");
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
			status1 =criteria6Service.criteria6Info(allParams1);
			
	  		trackingService.authorizedInfo(tracking);

//			status1 = trackingService.sendAutomatedEmail(tracking, institutionType);

			return status1;
		}
	
	
	
	
	
    @PostMapping(value = "/criteria6upload")
    public ResponseEntity<MessageResponse> Criteria6(@RequestPart(name = "criteria6Fieldinfo") Criteria6_FieldInfo criteria6Fieldinfo,  @RequestPart(name="uploadfile6") MultipartFile[] uploadfile6)
	{
    	System.out.println("cr6 controller");
    	 String message = "";
    	    try {
    	    	ObjectMapper mapper=new ObjectMapper();
    	    	System.out.println("mapper===>"+mapper.writeValueAsString(criteria6Fieldinfo));
    	    	criteria6Service.criteria6Info(criteria6Fieldinfo,uploadfile6);

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	

	}
    
    
    
    
    
    @GetMapping("/criteria6getallfiles")
    public ResponseEntity<List<Criteria6_FieldInfo>> getCriteria6ListFiles(@RequestParam Map<String, String> allParams) {
    	
		System.out.println("params are --->"+allParams);

      List<Criteria6_FieldInfo> files = criteria6Service.getAllCriteria6Data(allParams);
        

      return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    //email autonoumous
	@PostMapping("/autonomouscriteria6Email")
	public String AutonomousCriteria6Email(@RequestPart Tracking tracking)

	{
		String status1 = null;

		criteria6Service.authorizedInfo(tracking);

//		status1 = trackingService.sendAutonomousCriteria6Email();

		return status1;
	}
	

	//affilliated criteria6 email
	@PostMapping("/affiliatedcriteria6Email")
	public String AffiliatedCriteria6Email(@RequestPart Tracking tracking)
	{
	String 	status1 = null;
	criteria6Service.authorizedInfo(tracking);
//	status1= trackingService.sendAffiliatedCriteria6Email();
	return status1;
	}

	
    //email university
    @PostMapping("/universityCriteria6Email")
    public String UniversityCriteria6Email(@RequestPart Tracking tracking) {
   String 	status1 = null;
   criteria6Service.authorizedInfo(tracking);
//   status1 = trackingService.sendUniversityCriteria6Email();
    	return status1;
    }

}
   




































