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
import com.adiverse.erp.model.Citations;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.Hindex;
import com.adiverse.erp.model.QualityAdvisor;
import com.adiverse.erp.repository.CentricRepository;
import com.adiverse.erp.repository.CitationsRepository;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.HindexRepository;
import com.adiverse.erp.repository.QualityAdvisorRepository;

@Service
@Transactional
public class HindexService
{
	
	@Autowired
	private  HindexRepository hindexRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

  
	public Hindex hindexInfo(Hindex hindexobj)
	{
//// 3.4.9 U
//	if("university".equalsIgnoreCase(hindexobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(hindexobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(hindexobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(hindexobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getCriteria34Ql())) {
//				System.out.println("3491 Ql is empty.....");
//	//Insert 3491 					
//				int result3491=criteria3Repository.insertCriteria3491U(hindexobj.getInputhit5(),
//						hindexobj.getInputhit4(),1,hindexobj.getCriteriaId().getCollegeId(),
//						hindexobj.getCriteriaId().getFinancialYear(),hindexobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3491 inserted=======>"+result3491);
//			
//			}else {
//	//update 3491 		
//				System.out.println("Ql 3491 is not  empty.....");
//					String value3491t1= criteria3.get().getCriteria34Ql().get(0).getInput3491t1();
//					String value3491t2= criteria3.get().getCriteria34Ql().get(0).getInput3491t2();
//					System.out.println("existing value3491t1 is============>"+value3491t1+"  value3491t2====> "+value3491t2);
//					BigDecimal bd1 = new BigDecimal(value3491t1);
//					BigDecimal bd2 = new BigDecimal(value3491t2);
//					BigDecimal finalValue1=bd1.add(new BigDecimal(hindexobj.getInputhit5()));
//					BigDecimal finalValue2 = bd2.add(new BigDecimal(hindexobj.getInputhit4()));
//					System.out.println("what is the final value ==>"+finalValue1+"    finalValue2=====>"+finalValue2);
//					System.out.println("unique key ==>"+hindexobj.getUniqueKey1());
//					int update3491=criteria3Repository.updateCriteria3491U(finalValue1,finalValue2,hindexobj.getUniqueKey1());
//					System.out.println("update3491 u=======>"+update3491);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(hindexobj.getCriteriaId().getCollegeId(),
//				hindexobj.getCriteriaId().getFinancialYear(),hindexobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3491 					
//		int result3491=criteria3Repository.insertCriteria3491U(hindexobj.getInputhit5(),
//				hindexobj.getInputhit4(),1,hindexobj.getCriteriaId().getCollegeId(),
//				hindexobj.getCriteriaId().getFinancialYear(),hindexobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3491 inserted=======>"+result3491);
//	  
//	  }			
//}	
////3.4.6.1 Au
//	else if("autonomous".equalsIgnoreCase(hindexobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(hindexobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(hindexobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(hindexobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getCriteria34Qn())) {
//				System.out.println("3461 Qn is empty.....");
//	//Insert 3461 					
//				int result3461=criteria3Repository.insertCriteria3461AU(hindexobj.getInputhit5(),
//						hindexobj.getInputhit4(),0,0,hindexobj.getUniqueKey1(),hindexobj.getCriteriaId().getCollegeId(),
//						hindexobj.getCriteriaId().getFinancialYear(),hindexobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3461 & 3451  inserted=======>"+result3461);
//			
//			}else {
//	//update 3461 		
//				System.out.println("Qn 3461 is not  empty.....");
//					String value3461t1= criteria3.get().getCriteria34Qn().get(0).getInput3461t1();
//					String value3461t2= criteria3.get().getCriteria34Qn().get(0).getInput3461t2();
//					System.out.println("existing value3461t1 is============>"+value3461t1+"  value3461t2====> "+value3461t2);
//					
//					BigDecimal finalValue3= new BigDecimal(0);
//					BigDecimal finalValue4= new BigDecimal(0);
//					System.out.println(" variables declared=====>");
//					
//				if(value3461t1 != null) {
//					BigDecimal bd3 = new BigDecimal(value3461t1);
//					finalValue3=bd3.add(new BigDecimal(hindexobj.getInputhit5()));
//					System.out.println("bd3 value is====>"+bd3);
//					System.out.println("finalValue3 value is====>"+finalValue3);
//				}else {
//					BigDecimal bd3n = new BigDecimal(0);
//					finalValue3=bd3n.add(new BigDecimal(hindexobj.getInputhit5()));
//					System.out.println("what is the finalValue3  ====>"+finalValue3);	
//				}
//				
//				System.out.println("value3461t2 is======>"+value3461t2);
//				
//					if(value3461t2 !=null) {
//					BigDecimal bd4 = new BigDecimal(value3461t2);
//					finalValue4 = bd4.add(new BigDecimal(hindexobj.getInputhit4()));
//					System.out.println("bd4 value is====>"+bd4);
//					System.out.println("finalValue4 value is====>"+finalValue4);
//					}else {
//						BigDecimal bd4n = new BigDecimal(0);
//						finalValue4 = bd4n.add(new BigDecimal(hindexobj.getInputhit4()));
//						System.out.println("what is the finalValue4 ==>"+finalValue4);	
//					}
//					
//					System.out.println("h index .....");
//					
//					System.out.println("unique key ==>"+hindexobj.getUniqueKey1());
//					int update3461=criteria3Repository.updateCriteria3461AU(finalValue3,finalValue4,hindexobj.getUniqueKey1());
//					System.out.println("update3461 u=======>"+update3461);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(hindexobj.getCriteriaId().getCollegeId(),
//				hindexobj.getCriteriaId().getFinancialYear(),hindexobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3461 					
//		int result3461=criteria3Repository.insertCriteria3461AU(hindexobj.getInputhit5(),
//				hindexobj.getInputhit4(),0,0,hindexobj.getUniqueKey1(),hindexobj.getCriteriaId().getCollegeId(),
//				hindexobj.getCriteriaId().getFinancialYear(),hindexobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3461 inserted=======>"+result3461);
//	  
//	  }			
//}	 
//		int result346 = criteria3Repository.updateCriteria3_FieldInfoQn1(hindexobj.getInputhit5(), hindexobj.getInputhit4());
//		System.out.println("result346=============>"+result346);
    	return hindexRepository.save(hindexobj);

	}
	

	  
	  public List<Hindex> getAllHindexData() {
	    try {
	      List<Hindex> quality = new ArrayList<Hindex>();
	     
	      hindexRepository.findAll().forEach(quality::add);
	   
	      return quality;
	    
	   
	  }catch (Exception e) { return null;}
		
  
    
}
}
    

