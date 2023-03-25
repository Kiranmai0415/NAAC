package com.adiverse.erp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.AssignEmail;
import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.FacultyAwardsMain;
import com.adiverse.erp.model.PhdAwardedorRegisteredMain;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.FacultyAwardsService;
import com.adiverse.erp.service.PhDAwardedService;
import com.adiverse.erp.service.TrackingService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PhDAwardsController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    private PhDAwardedService phDAwardedService;
   
     
    @PostMapping(value = "/phdData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> phdAwards(@RequestPart(name = "phdInfo") PhdAwardedorRegisteredMain phdInfo,
    		@RequestPart(name="phdFiles",required = false) MultipartFile[]  phdFiles)
	{
    	
    	 String message = "";
    	    try {
    	    	phDAwardedService.phDAwardeInfo(phdInfo,phdFiles);

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	

	}
    
    @GetMapping("/getallphdAwardsdata")
    public ResponseEntity<List<PhdAwardedorRegisteredMain>> getCriteria1ListFiles() {
      List<PhdAwardedorRegisteredMain> files = phDAwardedService.getAllPhDAwardedData( );
        

      return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    
	
}















