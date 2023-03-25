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

import com.adiverse.erp.model.Citations;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.repository.CitationsRepository;
import com.adiverse.erp.repository.Criteria3Repository;

@Service
@Transactional
public class CitationsService
{
	
	@Autowired
	private  CitationsRepository citationsRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

  
	public Citations citationsInfo(Citations citationsobj)
	{
		try {
////3.4.8.1 U insert
//	if("university".equalsIgnoreCase(citationsobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(citationsobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(citationsobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(citationsobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getCriteria34Qn())) {
//				System.out.println("3481 Qn is empty.....");
//	//Insert 3481 					
//				int result3481=criteria3Repository.insertCriteria3481U(citationsobj.getInputct5(),
//						citationsobj.getInputct4(),1,citationsobj.getCriteriaId().getCollegeId(),
//						citationsobj.getCriteriaId().getFinancialYear(),citationsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3481 inserted=======>"+result3481);
//			
//			}else {
//	//update 3481 		
//				System.out.println("Qn 3481 is not  empty.....");
//					String value3481t1= criteria3.get().getCriteria34Qn().get(0).getInput348t1();
//					String value3481t2= criteria3.get().getCriteria34Qn().get(0).getInput348t2();
//					System.out.println("existing value3481 is============>"+value3481t1+"  value3481t2====> "+value3481t2);
//					BigDecimal bd1 = new BigDecimal(value3481t1);
//					BigDecimal bd2 = new BigDecimal(value3481t2);
//					BigDecimal finalValue1=bd1.add(new BigDecimal(citationsobj.getInputct5()));
//					BigDecimal finalValue2 = bd2.add(new BigDecimal(citationsobj.getInputct4()));
//					System.out.println("what is the final value ==>"+finalValue1+"    finalValue2=====>"+finalValue2);
//					System.out.println("unique key ==>"+citationsobj.getUniqueKey1());
//					int update3481=criteria3Repository.updateCriteria3481U(finalValue1,finalValue2,citationsobj.getUniqueKey1());
//					System.out.println("update3481 u=======>"+update3481);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(citationsobj.getCriteriaId().getCollegeId(),
//				citationsobj.getCriteriaId().getFinancialYear(),citationsobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3481					
//		int result3481=criteria3Repository.insertCriteria3481U(citationsobj.getInputct5(),
//				citationsobj.getInputct4(),1,citationsobj.getCriteriaId().getCollegeId(),
//				citationsobj.getCriteriaId().getFinancialYear(),citationsobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3481 inserted=======>"+result3481);
//	  
//	  }			
//}
////3.4.5.1 Au
//	else if("autonomous".equalsIgnoreCase(citationsobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(citationsobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(citationsobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(citationsobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getCriteria34Qn())) {
//				System.out.println("3451 Qn is empty.....");
//	//Insert 3451 					
//				int result3451Au=criteria3Repository.insertCriteria3451Au(citationsobj.getInputct5(),
//						citationsobj.getInputct4(),1,citationsobj.getCriteriaId().getCollegeId(),
//						citationsobj.getCriteriaId().getFinancialYear(),citationsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3451Au inserted=======>"+result3451Au);
//			
//			}else {
//	//update 3451 		
//				System.out.println("Qn 3451 is not  empty.....");
//					String value3451t1= criteria3.get().getCriteria34Qn().get(0).getInput3451t1();
//					String value3451t2= criteria3.get().getCriteria34Qn().get(0).getInput3451t2();
//					System.out.println("existing value3451t1 is============>"+value3451t1+"  value3451t2====> "+value3451t2);
//					BigDecimal bd3 = new BigDecimal(value3451t1);
//					BigDecimal bd4 = new BigDecimal(value3451t2);
//					BigDecimal finalValue3=bd3.add(new BigDecimal(citationsobj.getInputct5()));
//					BigDecimal finalValue4 = bd4.add(new BigDecimal(citationsobj.getInputct4()));
//					System.out.println("what is the final value ==>"+finalValue3+"    finalValue2=====>"+finalValue4);
//					System.out.println("unique key ==>"+citationsobj.getUniqueKey1());
//					int update3451Au=criteria3Repository.updateCriteria3451Au(finalValue3,finalValue4,citationsobj.getUniqueKey1());
//					System.out.println("update3451Au u=======>"+update3451Au);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(citationsobj.getCriteriaId().getCollegeId(),
//				citationsobj.getCriteriaId().getFinancialYear(),citationsobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3481					
//		int result3451Au=criteria3Repository.insertCriteria3451Au(citationsobj.getInputct5(),
//				citationsobj.getInputct4(),1,citationsobj.getCriteriaId().getCollegeId(),
//				citationsobj.getCriteriaId().getFinancialYear(),citationsobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3451Au inserted=======>"+result3451Au);
//	  
//	  }			
//}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
//		int result345 = criteria3Repository.updateCriteria3_FieldInfoQn(citationsobj.getInputct4(),citationsobj.getInputct5());
//		System.out.println("result345=============>"+result345);
    	return citationsRepository.save(citationsobj);

	}
	

	  
	  public List<Citations> getAllCitationsData() {
	    try {
	      List<Citations> quality = new ArrayList<Citations>();
	     
	      citationsRepository.findAll().forEach(quality::add);
	   
	      return quality;
	    
	   
	  }catch (Exception e) { return null;}
		
  
    
}
}
    

