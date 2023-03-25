package com.adiverse.erp.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;


import com.adiverse.erp.model.AssignFunctionality;

import com.adiverse.erp.service.Assignservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AssignController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    private Assignservice assignservice;
    
   
	 
    @PostMapping(value = "/assignFunctionality", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String assignFunctionality(@RequestPart AssignFunctionality assignFunctionality,@RequestParam Map<String,String>allparams)
       throws JsonProcessingException
	{
    	
    	 String message = "";
    	    try {
    	    	ObjectMapper mapper=new ObjectMapper();
    	    	System.out.println("data from front end is ==>"+mapper.writeValueAsString(assignFunctionality));
    	    	System.out.println("all params are  ==>"+allparams);
    	    	
    	    	
    	    	assignservice.assigninfo(assignFunctionality);
    	    	String status1=assignservice.sendAssignFunctionality(assignFunctionality, allparams);
    	    	return status1;
    	    }
    	    catch(Exception e) {
    	    	e.printStackTrace();
    	    	return null;
    	    }
	}
    @GetMapping("/getallassignfunctionalitydata")
    public ResponseEntity<List<AssignFunctionality>>getExtendedtotalData(@RequestParam Map<String,String>allparams){
    	List<AssignFunctionality>assignemail=assignservice.getAllAssignData();
    	return ResponseEntity.status(HttpStatus.OK).body(assignemail);
    }
    
}





















