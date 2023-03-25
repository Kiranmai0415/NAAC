package com.adiverse.erp.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.TeachingPedagology;
import com.adiverse.erp.repository.Criteria2Repository;
import com.adiverse.erp.repository.TeachingPedagologyRepository;

@Service
@Transactional
public class TeachingPedagologyService
{
	
	@Autowired
	private  TeachingPedagologyRepository teachingPedagologyRepository;
	
	@Autowired
	private Criteria2Repository criteria2Repository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

  
	public TeachingPedagology pedagologyInfo(TeachingPedagology pedagologyobj)
	{
	
////2.3.2 U,Au 
//if("university".equalsIgnoreCase(pedagologyobj.getCriteriaId().getTypeofInstitution())) {
//			
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(pedagologyobj.getCriteriaId().getCollegeId());
//			key.setFinancialYear(pedagologyobj.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(pedagologyobj.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//			if(criteria2.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria2.get().getCriteria23Ql())) {
//					System.out.println(" Cr23 Ql is empty.....");
//		//Insert 232 tx	area	
//				int result232=criteria2Repository.insertCriteria23Ql1(pedagologyobj.getInputtpt5(),
//						1,pedagologyobj.getCriteriaId().getCollegeId(),
//						pedagologyobj.getCriteriaId().getFinancialYear(),pedagologyobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result232 inserted=======>"+result232);
//				}else {
//		//update 232 tx	area		
//					System.out.println("Cr23 Ql is not  empty.....");
//						String value232 = criteria2.get().getCriteria23Ql().get(0).getResponse232();
//						System.out.println("existing value is============>"+value232);
//						System.out.println("unique key ==>"+pedagologyobj.getUniqueKey1());
//						int update232=criteria2Repository.updateCriteria23Ql1(pedagologyobj.getInputtpt5(),pedagologyobj.getUniqueKey1());
//						System.out.println("update232 u=======>"+update232);
//	
//					}
//		  }else {
//					
//			System.out.println("inserting into cr1 main table else......");
//			int criteria2Main=criteria2Repository.insertCriteria2Main(pedagologyobj.getCriteriaId().getCollegeId(),
//					pedagologyobj.getCriteriaId().getFinancialYear(),pedagologyobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria2Main else====>"+criteria2Main);
//	//insert 232 tx area			
//			int result232=criteria2Repository.insertCriteria23Ql1(pedagologyobj.getInputtpt5(),
//					1,pedagologyobj.getCriteriaId().getCollegeId(),
//					pedagologyobj.getCriteriaId().getFinancialYear(),pedagologyobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result232 inserted else=======>"+result232);
//		
//		  }			
//	}
//// 2.3.2 Au
//   else if("autonomous".equalsIgnoreCase(pedagologyobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(pedagologyobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(pedagologyobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(pedagologyobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//		if(criteria2.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria2.get().getCriteria23Ql())) {
//				System.out.println(" Cr23 Ql is empty.....");
//	//Insert 232 tx	area	
//			int result232=criteria2Repository.insertCriteria23Ql1(pedagologyobj.getInputtpt4(),
//					1,pedagologyobj.getCriteriaId().getCollegeId(),
//					pedagologyobj.getCriteriaId().getFinancialYear(),pedagologyobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result232 inserted=======>"+result232);
//			}else {
//	//update 232 tx	area		
//				System.out.println("Cr23 Ql is not  empty.....");
//					String value232 = criteria2.get().getCriteria23Ql().get(0).getResponse232();
//					System.out.println("existing value is============>"+value232);
//					System.out.println("unique key ==>"+pedagologyobj.getUniqueKey1());
//					int update232=criteria2Repository.updateCriteria23Ql1(pedagologyobj.getInputtpt4(),pedagologyobj.getUniqueKey1());
//					System.out.println("update232 u=======>"+update232);
//
//				}
//	  }else {
//				
//		System.out.println("inserting into cr1 main table else......");
//		int criteria2Main=criteria2Repository.insertCriteria2Main(pedagologyobj.getCriteriaId().getCollegeId(),
//				pedagologyobj.getCriteriaId().getFinancialYear(),pedagologyobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria2Main else====>"+criteria2Main);
////insert 232 tx area			
//		int result232=criteria2Repository.insertCriteria23Ql1(pedagologyobj.getInputtpt4(),
//				1,pedagologyobj.getCriteriaId().getCollegeId(),
//				pedagologyobj.getCriteriaId().getFinancialYear(),pedagologyobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("result232 inserted else=======>"+result232);
//	
//	  }			
//}
//		if("autonomous".equalsIgnoreCase(pedagologyobj.getCriteriaId().getTypeofInstitution())) {
//			int result232 = criteria2Repository.updateCriteria2_FieldInfoQl2(pedagologyobj.getInputtpt4());
//			System.out.println("result232au=============>"+result232);
//										
//			}
//			else if ("university".equalsIgnoreCase(pedagologyobj.getCriteriaId().getTypeofInstitution()))	{
//			int result232 = criteria2Repository.updateCriteria2_FieldInfoQl2(pedagologyobj.getInputtpt4());
//			System.out.println("result232u=============>"+result232);	
//			}	
		
    	return teachingPedagologyRepository.save(pedagologyobj);

	}
	

	  
	  public List<TeachingPedagology> getAllPedagologyData() {
	    try {
	      List<TeachingPedagology> quality = new ArrayList<TeachingPedagology>();
	     
	      teachingPedagologyRepository.findAll().forEach(quality::add);
	   
	      return quality;
	    
	   
	  }catch (Exception e) { return null;}
		
  
    
}
}
    

