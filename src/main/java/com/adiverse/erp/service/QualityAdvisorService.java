package com.adiverse.erp.service;


import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adiverse.erp.model.QualityAdvisor;
import com.adiverse.erp.repository.QualityAdvisorRepository;

@Service
@Transactional
public class QualityAdvisorService
{
	
	@Autowired
	private  QualityAdvisorRepository qualityadviserRepository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

  
	public QualityAdvisor qualityInfo(QualityAdvisor qualityAdvisor)
	{
    	
    	return qualityadviserRepository.save(qualityAdvisor);

	}
	

	  
	  public List<QualityAdvisor> getAllQualityAdvisorData() {
	    try {
	      List<QualityAdvisor> quality = new ArrayList<QualityAdvisor>();
	     
	      qualityadviserRepository.findAll().forEach(quality::add);
	   
	      return quality;
	    
	   
	  }catch (Exception e) { return null;}
		
  
    
}
}
    

