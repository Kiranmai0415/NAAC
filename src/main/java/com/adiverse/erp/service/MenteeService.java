package com.adiverse.erp.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adiverse.erp.model.MenteeForm;
import com.adiverse.erp.repository.MenteeRepository;

@Service
@Transactional
public class MenteeService
{
	@Autowired
	private  MenteeRepository menteeRepository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

  
	public MenteeForm admissionInfo(MenteeForm menteeForm)
			 {
    	
    	return menteeRepository.save(menteeForm);

	}
	

	  
	  public List<MenteeForm> getAllMenteeData() {
	    try {
	      List<MenteeForm> mentee = new ArrayList<MenteeForm>();
	     
	      menteeRepository.findAll().forEach(mentee::add);
	   
	      return mentee;
	    
	   
	  }catch (Exception e) { return null;}
		
  
    
}
}
    

