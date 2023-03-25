package com.adiverse.erp.service;


import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adiverse.erp.model.FeedbackForm_WB;
import com.adiverse.erp.repository.FeedbackRepository;


@Service
@Transactional
public class FeedbackService
{
	@Autowired
	private  FeedbackRepository feedbackRepository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

  
	public FeedbackForm_WB feedbackInfo(FeedbackForm_WB feedbackInfo)
			 {
    	
    	return feedbackRepository.save(feedbackInfo);

	}
	

	  
	  public List<FeedbackForm_WB> getAllFeedbackData() {
	    try {
	      List<FeedbackForm_WB> feedback = new ArrayList<FeedbackForm_WB>();
	     
	      feedbackRepository.findAll().forEach(feedback::add);
	   
	      return feedback;
	    
	   
	  }catch (Exception e) { return null;}
		
  
    
}
}
    

