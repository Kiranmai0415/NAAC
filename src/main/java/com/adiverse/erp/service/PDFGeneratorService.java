package com.adiverse.erp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.Pdfpojo;
import com.adiverse.erp.repository.Pdfrepository;

@Service
public class PDFGeneratorService {

	@Autowired
	private  Pdfrepository pdfRepository;

	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    
	public Pdfpojo extendedInfo(Pdfpojo data)
			 {
    	
    	return pdfRepository.save(data);

	}
	

	  
	  public List<Pdfpojo> getAllPdfData() {
	    try {
	      List<Pdfpojo> pdfData = new ArrayList<Pdfpojo>();
	     
	      pdfRepository.findAll().forEach(pdfData::add);
	   
	      return pdfData;
	    
	   
	  }catch (Exception e) { return null;}
		
  
    
}	
	
 
}
		

