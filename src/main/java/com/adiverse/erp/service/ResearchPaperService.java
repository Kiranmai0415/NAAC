package com.adiverse.erp.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.exception.FileStorageException;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.ResearchPapersMain;
import com.adiverse.erp.model.ResearchPapersPublishedFileUpload;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.ResearchPaperRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class ResearchPaperService {

	private final Logger logger = LoggerFactory.getLogger(ResearchPaperService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private ResearchPaperRepository researchPaperRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;


	public ResearchPapersMain researchPaperInfo(ResearchPapersMain  researchInfo, MultipartFile[]  researchFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(researchInfo));
			List<ResearchPapersPublishedFileUpload> file1 = new ArrayList<>();
if(researchFiles != null) {
			for (int i = 0; i < researchFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = researchFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(researchFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				ResearchPapersPublishedFileUpload fileUpload1 = new ResearchPapersPublishedFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+researchInfo.getCriteriaId().getFinancialYear()));
				fileUpload1.setResearchPapersFileName(filename);
				fileUpload1.setResearchPapersFilePath(filepath);
				fileUpload1.setResearchPapersFileType(param);
				fileUpload1.setCriteriaId(researchInfo.getCriteriaId());

				file1.add(fileUpload1);

			}
			researchInfo.setResearchPapersPublishedFileUpload(file1);
}
////3.4.5.1 U
//	if("university".equalsIgnoreCase(researchInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(researchInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(researchInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(researchInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable3451())) {
//				System.out.println("3451 table is empty.....");
//	//Insert 3451 tb					
//				int result3451=criteria3Repository.insertYearTable3451(researchInfo.getResearchPapersPublished().get(0).getInputrp7(),
//						1,1,researchInfo.getCriteriaId().getCollegeId(),
//						researchInfo.getCriteriaId().getFinancialYear(),researchInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3451 inserted=======>"+result3451);
//			
//			}else {
//	//update 3441 tb		
//				System.out.println("yr 3451 is not  empty.....");
//					String value3451= criteria3.get().getUniversityYearTable3451().get(0).getInput3451v();
//					System.out.println("existing value3451 is============>"+value3451);
//					BigDecimal bd = new BigDecimal(value3451);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
//					int update3451=criteria3Repository.updateYearTable3451(finalValue,
//							researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
//					System.out.println("update3451 u=======>"+update3451);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(researchInfo.getCriteriaId().getCollegeId(),
//				researchInfo.getCriteriaId().getFinancialYear(),researchInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3451 tb					
//		int result3451=criteria3Repository.insertYearTable3451(researchInfo.getResearchPapersPublished().get(0).getInputrp7(),
//				1,1,researchInfo.getCriteriaId().getCollegeId(),
//				researchInfo.getCriteriaId().getFinancialYear(),researchInfo.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3451 inserted=======>"+result3451);
//
//	  
//	  }			
//}	
////3431 Au
//	else if("autonomous".equalsIgnoreCase(researchInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(researchInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(researchInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(researchInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3431())) {
//				System.out.println("3431 table is empty.....");
//	//Insert 3431 tb					
//				int result3431=criteria3Repository.insertYearTable3431Au(researchInfo.getResearchPapersPublished().get(0).getInputrp7(),
//						1,1,researchInfo.getCriteriaId().getCollegeId(),
//						researchInfo.getCriteriaId().getFinancialYear(),researchInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3431 inserted=======>"+result3431);
//			
//			}else {
//	//update 3441 tb		
//				System.out.println("yr 34311 is not  empty.....");
//					String value3431= criteria3.get().getYearTable3431().get(0).getInput3431v();
//					System.out.println("existing value3431 is============>"+value3431);
//					BigDecimal bd = new BigDecimal(value3431);
//					int finalValue1 = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue1);
//					System.out.println("unique key ==>"+researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
//					int update3431=criteria3Repository.updateYearTable3431Au(finalValue1,
//							researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
//					System.out.println("update3431 u=======>"+update3431);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(researchInfo.getCriteriaId().getCollegeId(),
//				researchInfo.getCriteriaId().getFinancialYear(),researchInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3431 tb					
//		int result3431=criteria3Repository.insertYearTable3431Au(researchInfo.getResearchPapersPublished().get(0).getInputrp7(),
//				1,1,researchInfo.getCriteriaId().getCollegeId(),
//				researchInfo.getCriteriaId().getFinancialYear(),researchInfo.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3431 inserted=======>"+result3431);
//
//	  
//	  }			
//}	
//// 3311 Af
//	else if("affiliated".equalsIgnoreCase(researchInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(researchInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(researchInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(researchInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getAffiliatedYearTable3311())) {
//				System.out.println("3311 table affiliated is empty.....");
//	//Insert 3311 tb					
//				int result3311=criteria3Repository.insertYearTable3311Af(researchInfo.getResearchPapersPublished().get(0).getInputrp12(),
//						1,1,researchInfo.getCriteriaId().getCollegeId(),
//						researchInfo.getCriteriaId().getFinancialYear(),researchInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3311 affiliated inserted=======>"+result3311);
//			
//			}else {
//	//update 3311 tb		
//				System.out.println("yr 3311 is not  empty.....");
//					String value3311= criteria3.get().getAffiliatedYearTable3311().get(0).getInput3311v();
//					System.out.println("existing value3311 is============>"+value3311);
//					BigDecimal bd = new BigDecimal(value3311);
//					int finalValue2 = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue2);
//					System.out.println("unique key ==>"+researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
//					int update3311=criteria3Repository.updateYearTable3311Af(finalValue2,
//							researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
//					System.out.println("update3311 affiliated  u=======>"+update3311);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(researchInfo.getCriteriaId().getCollegeId(),
//				researchInfo.getCriteriaId().getFinancialYear(),researchInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main affiliated else====>"+criteria3Main);
//	//Insert 3311 tb					
//		int result3311=criteria3Repository.insertYearTable3311Af(researchInfo.getResearchPapersPublished().get(0).getInputrp12(),
//				1,1,researchInfo.getCriteriaId().getCollegeId(),
//				researchInfo.getCriteriaId().getFinancialYear(),researchInfo.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3311 affiliated inserted=======>"+result3311);
//
//	  
//	  }			
//}	
//			int result343 = criteria3Repository.updateYearTable3431(researchInfo.getResearchPapersPublished().get(0).getInputrp7(),
//					researchInfo.getResearchPapersPublished().get(0).getInputrp1());
//			System.out.println("result343=============>"+result343);
			return researchPaperRepository.save(researchInfo);

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

	

	public List<ResearchPapersMain> getAllResearchData() {
		try {
			List<ResearchPapersMain> criteria1 = new ArrayList<ResearchPapersMain>();

			researchPaperRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
