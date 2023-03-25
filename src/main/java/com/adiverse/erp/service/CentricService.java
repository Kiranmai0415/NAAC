package com.adiverse.erp.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.CentricMethods;
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.repository.CentricRepository;
import com.adiverse.erp.repository.Criteria2Repository;

@Service
@Transactional
public class CentricService
{
	
	@Autowired
	private  CentricRepository centricRepository;
	
	@Autowired
	private Criteria2Repository criteria2Repository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

  
	public CentricMethods centricInfo(CentricMethods centricobj)
	{
////2.3.1 U,Au,Af 
//		if("university".equalsIgnoreCase(centricobj.getCriteriaId().getTypeofInstitution())) {
//			
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(centricobj.getCriteriaId().getCollegeId());
//			key.setFinancialYear(centricobj.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(centricobj.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//			if(criteria2.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria2.get().getCriteria23Ql())) {
//					System.out.println(" Cr23 Ql is empty.....");
//		//Insert 231 tx	area	
//				int result231=criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(),
//						1,centricobj.getCriteriaId().getCollegeId(),
//						centricobj.getCriteriaId().getFinancialYear(),centricobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result231 inserted=======>"+result231);
//				}else {
//		//update 1341 tx				
//					System.out.println("Cr23 Ql is not  empty.....");
//						String value231 = criteria2.get().getCriteria23Ql().get(0).getResponse231();
//						System.out.println("existing value is============>"+value231);
//						System.out.println("unique key ==>"+centricobj.getUniqueKey1());
//						int update231=criteria2Repository.updateCriteria23Ql(centricobj.getInputcmt5(),centricobj.getUniqueKey1());
//						System.out.println("update231 u=======>"+update231);
//	
//					}
//		  }else {
//					
//			System.out.println("inserting into cr1 main table else......");
//			int criteria2Main=criteria2Repository.insertCriteria2Main(centricobj.getCriteriaId().getCollegeId(),
//					centricobj.getCriteriaId().getFinancialYear(),centricobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria2Main else====>"+criteria2Main);
//	//insert 231 tx area			
//			int result231=criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(),
//					1,centricobj.getCriteriaId().getCollegeId(),
//					centricobj.getCriteriaId().getFinancialYear(),centricobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result231 inserted=======>"+result231);
//		
//		  }			
//	}		
////2.3.1 Au
//	else if("autonomous".equalsIgnoreCase(centricobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(centricobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(centricobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(centricobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//		if(criteria2.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria2.get().getCriteria23Ql())) {
//				System.out.println(" Cr23 Ql is empty.....");
//	//Insert 231 tx	area	
//			int result231=criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(),
//					1,centricobj.getCriteriaId().getCollegeId(),
//					centricobj.getCriteriaId().getFinancialYear(),centricobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result231 autonomous inserted=======>"+result231);
//			}else {
//	//update 231 tx				
//				System.out.println("Cr23 Ql autonomous is not  empty.....");
//					String value231Au= criteria2.get().getCriteria23Ql().get(0).getInput231t1();
//					System.out.println("existing value231Au is============>"+value231Au);
//					System.out.println("unique key ==>"+centricobj.getUniqueKey1());
//					int update231Au=criteria2Repository.updateCriteria23QlAu(centricobj.getInputcmt5(),centricobj.getUniqueKey1());
//					System.out.println("update231Au autonomous u=======>"+update231Au);
//
//				}
//	  }else {
//				
//		System.out.println("inserting into cr1 main table else......");
//		int criteria2Main=criteria2Repository.insertCriteria2Main(centricobj.getCriteriaId().getCollegeId(),
//				centricobj.getCriteriaId().getFinancialYear(),centricobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria2Main autonomous else====>"+criteria2Main);
////insert 231 tx area			
//		int result231=criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(),
//				1,centricobj.getCriteriaId().getCollegeId(),
//				centricobj.getCriteriaId().getFinancialYear(),centricobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("result231 autonomous inserted=======>"+result231);
//	
//	  }			
//}			
////2.3.1 Af
//	else if("affiliated".equalsIgnoreCase(centricobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(centricobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(centricobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(centricobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//		if(criteria2.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria2.get().getCriteria23Ql())) {
//				System.out.println(" Cr23 Ql is empty.....");
//	//Insert 231 tx	area	
//			int result231=criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(),
//					1,centricobj.getCriteriaId().getCollegeId(),
//					centricobj.getCriteriaId().getFinancialYear(),centricobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result231 inserted affiliated=======>"+result231);
//			}else {
//	//update 1341 tx				
//				System.out.println("Cr23 Ql is not  empty.....");
//					String value231 = criteria2.get().getCriteria23Ql().get(0).getResponse231();
//					System.out.println("existing value is============>"+value231);
//					System.out.println("unique key ==>"+centricobj.getUniqueKey1());
//					int update231=criteria2Repository.updateCriteria23Ql(centricobj.getInputcmt5(),centricobj.getUniqueKey1());
//					System.out.println("update231 affiliated u=======>"+update231);
//
//				}
//	  }else {
//				
//		System.out.println("inserting into cr1 main table else......");
//		int criteria2Main=criteria2Repository.insertCriteria2Main(centricobj.getCriteriaId().getCollegeId(),
//				centricobj.getCriteriaId().getFinancialYear(),centricobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria2Main affiliated else====>"+criteria2Main);
////insert 231 tx area			
//		int result231=criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(),
//				1,centricobj.getCriteriaId().getCollegeId(),
//				centricobj.getCriteriaId().getFinancialYear(),centricobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("result231 affiliated inserted=======>"+result231);
//	
//	  }			
//}				
		
		
//		if("autonomous".equalsIgnoreCase(centricobj.getCriteriaId().getTypeofInstitution())) {
//		int result231 = criteria2Repository.updateCriteria2_FieldInfoQl1(centricobj.getInputcmt5());
//		System.out.println("result231au=============>"+result231);
//									
//		}
//		else if ("university".equalsIgnoreCase(centricobj.getCriteriaId().getTypeofInstitution()))	{
//		int result231 = criteria2Repository.updateCriteria2_FieldInfoQl1(centricobj.getInputcmt5());
//		System.out.println("result231u=============>"+result231);	
//		}	
//		else if("affiliated".equalsIgnoreCase(centricobj.getCriteriaId().getTypeofInstitution())) {
//			int result231 = criteria2Repository.updateCriteria2_FieldInfoQl1(centricobj.getInputcmt5());
//			System.out.println("result231af=============>"+result231); 
//		}
		
    	return centricRepository.save(centricobj);

	}
	

	  
	  public List<CentricMethods> getAllCentricData() {
	    try {
	      List<CentricMethods> quality = new ArrayList<CentricMethods>();
	     
	      centricRepository.findAll().forEach(quality::add);
	   
	      return quality;
	    
	   
	  }catch (Exception e) { return null;}
		
  
    
}
}
    

