//package com.adiverse.erp.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.Model;
//
//import com.adiverse.erp.model.BasicProfile;
//import com.adiverse.erp.repository.ModelRepository;
//
//@Service
//@Transactional
//public class Modelservice {
//
//	@Autowired
//	ModelRepository modelRepository;
//	
//	private final Logger log = LoggerFactory.getLogger(this.getClass());
//	
//	public List<Model> getAllModelData() {
//	    try {
//	      List<Model> model = new ArrayList<Model>();
//	     
//	      modelRepository.findAll().forEach(model::add);
//	   
//	      return model;
//	    
//	   
//	  }catch (Exception e) { return null;}
//		
//  
//    
//}
//}
