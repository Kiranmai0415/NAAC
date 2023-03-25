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

import com.adiverse.erp.model.EcontentDevbyTeachMain;
import com.adiverse.erp.model.FullTimeTeachersPhdMain;
import com.adiverse.erp.model.SeedMoneyMain;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.EContentService;
import com.adiverse.erp.service.FullTimeTeachPhdService;
import com.adiverse.erp.service.SeedMoneyService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EContentController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    private EContentService eContentService;
   
     
    @PostMapping(value = "/eContentData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> facultyAwards(@RequestPart(name = "eContentobj") EcontentDevbyTeachMain eContentobj,
    		@RequestPart(name="eContentFiles",required = false) MultipartFile[] eContentFiles)
	{
    	
    	 String message = "";
    	    try {
    	    	eContentService.eContentInfo(eContentobj,eContentFiles);

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	

	}
    
    @GetMapping("/getallEContentdata")
    public ResponseEntity<List<EcontentDevbyTeachMain>> getCriteria1ListFiles() {
      List<EcontentDevbyTeachMain> files = eContentService.getAllEContentData( );
        

      return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    
	
}















