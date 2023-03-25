package com.adiverse.erp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.ProfessionalDevelopmenMain;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.ProfessionaldevelopmentService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ProfessionaldevelopmentController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    private ProfessionaldevelopmentService professionaldevelopmentService;
   
     
    @PostMapping(value = "/professionalData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> professionalDevelopment(@RequestPart(name = "professionalInfo") ProfessionalDevelopmenMain professionalInfo, 
    		@RequestPart(name="professionalFiles",required = false) MultipartFile[]  professionalFiles)
	{
    	
    	 String message = "";
    	    try {
    	    	professionaldevelopmentService.professionalInfo(professionalInfo,professionalFiles);

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	

	}
    
    @GetMapping("/getallprofessionalDevelopmentdata")
    public ResponseEntity<List<ProfessionalDevelopmenMain>> getCriteria1ListFiles() {
      List<ProfessionalDevelopmenMain> files = professionaldevelopmentService.getAllProfessionalData( );
        

      return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    
	
}















