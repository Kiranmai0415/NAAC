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

import com.adiverse.erp.model.ResearchPapersMain;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.ResearchPaperService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ResearchPaperController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    private ResearchPaperService researchPaperService;
   
     
    @PostMapping(value = "/researchData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> researchPaper(@RequestPart(name = "researchInfo") ResearchPapersMain researchInfo, 
    		@RequestPart(name="researchFiles",required = false) MultipartFile[] researchFiles)
	{
    	
    	 String message = "";
    	    try {
    	    	researchPaperService.researchPaperInfo(researchInfo,researchFiles);

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	

	}
    
    @GetMapping("/getallResearchPaperdata")
    public ResponseEntity<List<ResearchPapersMain>> getCriteria1ListFiles() {
      List<ResearchPapersMain> files = researchPaperService.getAllResearchData( );
        
      System.out.println("getallResearchPaperdata");
       ObjectMapper mapper=new ObjectMapper();
       try {
		System.out.println("mapper values ===>"+mapper.writeValueAsString(files));
	} catch (JsonProcessingException e) {
		
		e.printStackTrace();
	}
      return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    
	
}















