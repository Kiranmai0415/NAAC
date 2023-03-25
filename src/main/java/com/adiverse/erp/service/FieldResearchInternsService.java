package com.adiverse.erp.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.exception.FileStorageException;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FieldResearchInternsMain;
import com.adiverse.erp.model.FieldorResearchProjectsInternshipsFileUpload;
import com.adiverse.erp.repository.Criteria1Repository;
import com.adiverse.erp.repository.FieldResearchInternsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class FieldResearchInternsService {

	private final Logger logger = LoggerFactory.getLogger(FieldResearchInternsService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private FieldResearchInternsRepository fieldResearchInternsRepository;
	
	@Autowired
	private Criteria1Repository criteria1Repository;

	public FieldResearchInternsMain fieldInternsInfo(FieldResearchInternsMain  fieldInternsobj, MultipartFile[]  fieldInternsFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(fieldInternsobj));
			List<FieldorResearchProjectsInternshipsFileUpload> file1 = new ArrayList<>();
  if(fieldInternsFiles != null) {
			for (int i = 0; i < fieldInternsFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = fieldInternsFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(fieldInternsFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				FieldorResearchProjectsInternshipsFileUpload fileUpload1 = new FieldorResearchProjectsInternshipsFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+fieldInternsobj.getCriteriaId().getFinancialYear()));
				fileUpload1.setFieldResearchProjInternsFileName(filename);
				fileUpload1.setFieldResearchProjInternsFilePath(filepath);
				fileUpload1.setFieldResearchProjInternsFileType(param);
				fileUpload1.setCriteriaId(fieldInternsobj.getCriteriaId());

				file1.add(fileUpload1);

			}
			fieldInternsobj.setFieldorResearchProjectsInternshipsFileUpload(file1);
  }
//1.3.4.1 tx U
//		if("university".equalsIgnoreCase(fieldInternsobj.getCriteriaId().getTypeofInstitution())) {
//				
//				CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//				key.setCollegeId(fieldInternsobj.getCriteriaId().getCollegeId());
//				key.setFinancialYear(fieldInternsobj.getCriteriaId().getFinancialYear());
//				key.setTypeofInstitution(fieldInternsobj.getCriteriaId().getTypeofInstitution());
//				Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
//				if(criteria1.isPresent()) {
//					if(CollectionUtils.isEmpty(criteria1.get().getCriteria13Qn())) {
//						System.out.println(" Cr13 Qn is empty.....");
//			//Insert 1341 tx		
//						int result1341=criteria1Repository.insertCriteria13Qn(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(),
//								fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),1,fieldInternsobj.getCriteriaId().getCollegeId(),
//								fieldInternsobj.getCriteriaId().getFinancialYear(),fieldInternsobj.getCriteriaId().getTypeofInstitution());
//						System.out.println("result1341 inserted=======>"+result1341);
//					}else {
//			//update 1341 tx				
//						System.out.println("Cr13 Qn is not  empty.....");
//						String value1341t1 = criteria1.get().getCriteria13Qn().get(0).getInput1341t1();
//						String value1341t2 = criteria1.get().getCriteria13Qn().get(0).getInput1341t1();
//						System.out.println("existing value is============>"+value1341t1+"   value1341t2==>"+value1341t2);
//						BigDecimal bdAu1 = new BigDecimal(value1341t1);
//						BigDecimal bdAu2 = new BigDecimal(value1341t2);
//						BigDecimal finalValueAu1 = bdAu1.add(new BigDecimal(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5()));
//						BigDecimal finalValueAu2 = bdAu1.add(new BigDecimal(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7()));
//						System.out.println("what is the final value ==>"+finalValueAu1+"   finalValueAu2====>"+finalValueAu2);
//						System.out.println("unique key ==>"+fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
//						int update1341=criteria1Repository.updateCriteria13Qn(finalValueAu1,finalValueAu2,fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
//						System.out.println("update1341 u=======>"+update1341);
//	
//						}
//			  }else {
//						
//				System.out.println("inserting into cr1 main table else......");
//				int criteria1Main=criteria1Repository.insertCriteria1Main(fieldInternsobj.getCriteriaId().getCollegeId(),
//						fieldInternsobj.getCriteriaId().getFinancialYear(),fieldInternsobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("criteria1Main else====>"+criteria1Main);
//		//insert 1341			
//				int result1341=criteria1Repository.insertCriteria13Qn(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(),
//						fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),1,fieldInternsobj.getCriteriaId().getCollegeId(),
//						fieldInternsobj.getCriteriaId().getFinancialYear(),fieldInternsobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result1341 inserted=======>"+result1341);
//			
//			  }			
//		}
////1.3.4.1 Au 		
//		else if("autonomous".equalsIgnoreCase(fieldInternsobj.getCriteriaId().getTypeofInstitution())) {
//			
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(fieldInternsobj.getCriteriaId().getCollegeId());
//			key.setFinancialYear(fieldInternsobj.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(fieldInternsobj.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
//			if(criteria1.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria1.get().getCriteria13Qn())) {
//					System.out.println(" Cr13 Qn is empty.....");
//		//Insert 1341 tx		
//				int result1341=criteria1Repository.insertCriteria13Qn(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(),
//						fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),1,fieldInternsobj.getCriteriaId().getCollegeId(),
//						fieldInternsobj.getCriteriaId().getFinancialYear(),fieldInternsobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result1341 inserted=======>"+result1341);
//				}else {
//		//update 1341 tx				
//					System.out.println("Cr13 Qn is not  empty.....");
//						String value1341t1 = criteria1.get().getCriteria13Qn().get(0).getInput1341t1();
//						String value1341t2 = criteria1.get().getCriteria13Qn().get(0).getInput1341t1();
//						System.out.println("existing value is============>"+value1341t1+"   value1341t2==>"+value1341t2);
//						BigDecimal bdAu1 = new BigDecimal(value1341t1);
//						BigDecimal bdAu2 = new BigDecimal(value1341t2);
//						BigDecimal finalValueAu1 = bdAu1.add(new BigDecimal(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5()));
//						BigDecimal finalValueAu2 = bdAu1.add(new BigDecimal(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7()));
//						System.out.println("what is the final value ==>"+finalValueAu1+"   finalValueAu2====>"+finalValueAu2);
//						System.out.println("unique key ==>"+fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
//						int update1341=criteria1Repository.updateCriteria13Qn(finalValueAu1,finalValueAu2,fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
//						System.out.println("update1341 u=======>"+update1341);
//	
//					}
//		  }else {
//					
//			System.out.println("inserting into cr1 main table else......");
//			int criteria1Main=criteria1Repository.insertCriteria1Main(fieldInternsobj.getCriteriaId().getCollegeId(),
//					fieldInternsobj.getCriteriaId().getFinancialYear(),fieldInternsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria1Main else====>"+criteria1Main);
//	//insert 1341			
//			int result1341=criteria1Repository.insertCriteria13Qn(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(),
//					fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),1,fieldInternsobj.getCriteriaId().getCollegeId(),
//					fieldInternsobj.getCriteriaId().getFinancialYear(),fieldInternsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result1341 inserted=======>"+result1341);
//		
//		  }			
//	}	
//// 1.3.2.1 Af
//else if("affiliated".equalsIgnoreCase(fieldInternsobj.getCriteriaId().getTypeofInstitution())) {
//			System.out.println("collegeId ===>"+fieldInternsobj.getCriteriaId().getCollegeId());
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(fieldInternsobj.getCriteriaId().getCollegeId());
//			key.setFinancialYear(fieldInternsobj.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(fieldInternsobj.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
//			if(criteria1.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria1.get().getCriteria13Qn())) {
//					System.out.println(" Cr13 Qn is empty.....");
//		//Insert 1321 tx		
//				int result1321=criteria1Repository.insertCriteria13QnAf(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(),
//						fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),1,fieldInternsobj.getCriteriaId().getCollegeId(),
//						fieldInternsobj.getCriteriaId().getFinancialYear(),fieldInternsobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result1321 affiliated inserted=======>"+result1321);
//				}else {
//		//update 1321 tx				
//					System.out.println("Cr13 Qn affiliated is not  empty.....");
//						String value1321af1 = criteria1.get().getCriteria13Qn().get(0).getInput1321t11();
//						String value1321af2 = criteria1.get().getCriteria13Qn().get(0).getInput1321t12();
//						System.out.println("existing value is============>"+value1321af1+"      value1321af2=====> "+value1321af2);
//						BigDecimal bdaf1 = new BigDecimal(value1321af1);
//						BigDecimal bdaf2 = new BigDecimal(value1321af2);
//						BigDecimal finalValueAf1 = bdaf1.add(new BigDecimal(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5()));
//						BigDecimal finalValueAf2 = bdaf2.add(new BigDecimal(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7()));
//						System.out.println("what is the final value ==>"+finalValueAf1+"    finalValueAf2=====> "+finalValueAf2);
//						System.out.println("unique key ==>"+fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
//						int update1341=criteria1Repository.updateCriteria13QnAf(finalValueAf1,finalValueAf2,fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
//						System.out.println("update1341 affiliated u=======>"+update1341);
//	
//					}
//		  }else {
//					
//			System.out.println("inserting into cr1 main table else......");
//			int criteria1Main=criteria1Repository.insertCriteria1Main(fieldInternsobj.getCriteriaId().getCollegeId(),
//					fieldInternsobj.getCriteriaId().getFinancialYear(),fieldInternsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria1Main else====>"+criteria1Main);
//	//insert 1341			
//			int result1321=criteria1Repository.insertCriteria13QnAf(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(),
//					fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),1,fieldInternsobj.getCriteriaId().getCollegeId(),
//					fieldInternsobj.getCriteriaId().getFinancialYear(),fieldInternsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result1321 affiliated inserted=======>"+result1321);
//		
//		  }			
//	}	
//	  System.out.println("key is ==>"+mapper.writeValueAsString(fieldInternsobj.getCriteriaId()));
//	  int result134 =criteria1Repository.insertCriteria1_FieldInfoQn1(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit1(),
//			fieldInternsobj.getCriteriaId().getCollegeId(), fieldInternsobj.getCriteriaId().getFinancialYear(),fieldInternsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result134=======>"+result134);
////3.Au,U 134			
//	if("autonomous".equalsIgnoreCase(fieldInternsobj.getCriteriaId().getTypeofInstitution())) {
//	int result134 = criteria1Repository.updateCriteria1_FieldInfoQn1(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5());
//	System.out.println("result134au=============>"+result134);
//							
//	}
//	else if ("university".equalsIgnoreCase(fieldInternsobj.getCriteriaId().getTypeofInstitution()))	{
//	int result134 = criteria1Repository.updateCriteria1_FieldInfoQn1(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5());
//	System.out.println("result134u=============>"+result134);	
//	}	
////3.Af 132	
//	else if ("affiliated".equalsIgnoreCase(fieldInternsobj.getCriteriaId().getTypeofInstitution())) {
//	int result132 = criteria1Repository.updateCriteria1_FieldInfoQn2(fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5());
//	System.out.println("result132af=============>"+result132); 
//		
//	}
	return fieldResearchInternsRepository.save(fieldInternsobj);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		

	}

	public void init() {
		// TODO Auto-generated method stub
		try {
			Files.createDirectories(Paths.get(uploadFilePath));
		} catch (Exception ex) {
			throw new FileStorageException("Could not create upload dir!");
		}
	}

	public String saveFile(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			String fileName = file.getOriginalFilename();
			Path root = Paths.get(uploadFilePath);
            if (!Files.exists(root)) {
                init();
            }
			Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			return fileName;

		} catch (Exception e) {
			throw new FileStorageException("Could not upload file");
		}
	}

	

	public List<FieldResearchInternsMain> getAllFieldInternsData(Map<String,String> allparams) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			List<FieldResearchInternsMain> criteria1 = new ArrayList<FieldResearchInternsMain>();
			 CriteriaPrimaryKey id = new CriteriaPrimaryKey();
				id.setCollegeId(allparams.get("collegeId"));
				id.setFinancialYear(allparams.get("financialYear"));
				id.setTypeofInstitution(allparams.get("typeofInstitution"));
				System.out.println("options ==>"+mapper.writeValueAsString(id));
				Optional<FieldResearchInternsMain> academic2 = fieldResearchInternsRepository.findById(id);
				if(academic2.isPresent()) {
					criteria1.add(academic2.get());
				}
			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}
	
	

	
	
	
}
