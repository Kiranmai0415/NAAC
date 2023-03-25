package com.adiverse.erp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.EvaluativereportMain;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.repository.EvaluativeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class EvalutiveReportService {
	
	@Autowired
	private EvaluativeRepository evaluativeRepository;
	
	@Autowired
	private TrackingService trackingService;
	

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	

	public EvaluativereportMain  evaluativeInfo(EvaluativereportMain  evaluativereportofthedepartment) {
		
		evaluativeRepository.save(evaluativereportofthedepartment);
		
		String institutionType=evaluativereportofthedepartment.getCriteriaId().getTypeofInstitution();
		
		
		Map<String, String> allParams = new HashMap<String, String>();
    	allParams.put("collegeId", evaluativereportofthedepartment.getCriteriaId().getCollegeId() );
    	allParams.put("financialYear", evaluativereportofthedepartment.getCriteriaId().getFinancialYear() );
    	allParams.put("typeofInstitution", evaluativereportofthedepartment.getCriteriaId().getTypeofInstitution() );
		
		
		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			trackingService.sendAutonomousEvaluationReport(  allParams);
			}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
				trackingService.sendAffiliatedEvaluationReport(allParams);
			}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
				System.out.println("u");
				trackingService.sendUniversityEvaluationReport(allParams);
			}
		

		return null;

	}
	
	
	public String evalutiveMail(Map<String, String> allParams)
	{
		String status ="";
		String institutionType=allParams.get("typeofInstitution");

		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			status =trackingService.sendAutonomousEvaluationReport(  allParams);
			}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
				status =trackingService.sendAffiliatedEvaluationReport(allParams);
			}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
				System.out.println("u");
				status =trackingService.sendUniversityEvaluationReport(allParams);
			}
		
		
		return status;
	}

	public List<EvaluativereportMain > getAllEvaluativeData() {
		try {
			List<EvaluativereportMain > evaluative = new ArrayList<EvaluativereportMain >();

			evaluativeRepository.findAll().forEach(evaluative::add);

			return evaluative;

		} catch (Exception e) {
			return null;
		}

	}
//AffiliatedEvaluationReport

	public List<EvaluativereportMain > getAllEvaluativeData(Map<String, String> allParams) {
		try {
			
			
			ObjectMapper mapper =new ObjectMapper();
			List<EvaluativereportMain > evaluative = new ArrayList<EvaluativereportMain >();
			   CriteriaPrimaryKey id =new CriteriaPrimaryKey();
	            id.setCollegeId(allParams.get("collegeId"));
	            id.setFinancialYear(allParams.get("financialYear"));
				id.setTypeofInstitution(allParams.get("typeofInstitution"));
//				System.out.println("id object is--->"+mapper.writeValueAsString(id));
				Optional<EvaluativereportMain> academic2 = evaluativeRepository.findById(id);
				
				if (academic2.isPresent()) {
					evaluative.add(academic2.get());
				}
//				System.out.println("options ==>"+mapper.writeValueAsString(academic2));

				return evaluative;

			} catch (Exception e) {
				return null;
			}
				
			
	}

}