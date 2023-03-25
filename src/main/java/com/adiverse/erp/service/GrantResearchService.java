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
import com.adiverse.erp.model.GrantsResearchMain;
import com.adiverse.erp.model.GrantsResearchProjectsFileUpload;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.GrantResearchRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class GrantResearchService {

	private final Logger logger = LoggerFactory.getLogger(GrantResearchService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private GrantResearchRepository grantResearchRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;

	public GrantsResearchMain grantResearchInfo(GrantsResearchMain grantInfo, MultipartFile[] grantFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(grantInfo));
			List<GrantsResearchProjectsFileUpload> file1 = new ArrayList<>();
if(grantFiles != null) {
			for (int i = 0; i < grantFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = grantFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(grantFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				GrantsResearchProjectsFileUpload fileUpload1 = new GrantsResearchProjectsFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+grantInfo.getCriteriaId().getFinancialYear()));
				fileUpload1.setGrantsResearchProjectsFileName(filename);
				fileUpload1.setGrantsResearchProjectsFilePath(filepath);
				fileUpload1.setGrantsResearchProjectsFileType(param);
				fileUpload1.setCriteriaId(grantInfo.getCriteriaId());

				file1.add(fileUpload1);

			}
			grantInfo.setGrantsResearchProjectsFileUpload(file1);
}
////3231 U
//	if("university".equalsIgnoreCase(grantInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(grantInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(grantInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(grantInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable3231())) {
//				System.out.println(" yr 3231 is empty.....");
//	//Insert 3231
//			int result3231=criteria3Repository.insertYearTable3231(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//					grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//					grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3231 inserted=======>"+result3231);
//   //3221 insert
//			if("government".equalsIgnoreCase(grantInfo.getGrantsResearchProjects().get(0).getInputgrt6())) {
//				int result3221=criteria3Repository.insertYearTable3221U(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//						grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//						grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//				System.out.println("result3221 inserted=======>"+result3221);	
//			}
//	// Insert 3211 
//			else {
//			int result3211=criteria3Repository.insertYearTable3211U(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//					grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//					grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3211 inserted=======>"+result3211);
//			}
//			}else {
//	//update 3231		
//				System.out.println("yr 3231 is not  empty.....");
//					String value3231 = criteria3.get().getUniversityYearTable3231().get(0).getInput3231v();
//					System.out.println("existing value is============>"+value3231);
//					BigDecimal bd1 = new BigDecimal(value3231);
//					BigDecimal finalValue1 = bd1.add(new BigDecimal(grantInfo.getGrantsResearchProjects().get(0).getInputgrt9()));
//					System.out.println("what is the final value1 ==>"+finalValue1);
//					System.out.println("unique key ==>"+grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
//					int update3231=criteria3Repository.updateYearTable3231(finalValue1,grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
//					System.out.println("update3231 u=======>"+update3231);	
//					
//					System.out.println("inserting into yr tb 3221......");
//
//					if(CollectionUtils.isEmpty(criteria3.get().getYearTable3221())) {
//			// insert 3221
//						int result3221=criteria3Repository.insertYearTable3221U(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//								grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//								grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//						System.out.println("result3221 inserted=======>"+result3221);		
//					}else {
//			// Insert 3221			
//					System.out.println("yr 3221 is not  empty.....");
//					String value3221 = criteria3.get().getYearTable3221().get(0).getInput3221v();
//					System.out.println("existing value3221 is============>"+value3221);
//					BigDecimal bd3 = new BigDecimal(value3221);
//					BigDecimal finalValue3221 = bd3.add(new BigDecimal(grantInfo.getGrantsResearchProjects().get(0).getInputgrt9()));
//					System.out.println("what is the finalValue3221 ==>"+finalValue3221);
//					System.out.println("unique key ==>"+grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
//					int update3221=criteria3Repository.updateYearTable3221U(finalValue3221,grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
//					System.out.println("update3221 u=======>"+update3221);	
//					}
//					
//					System.out.println("inserting into yr tb 3211......");
//
//					if(CollectionUtils.isEmpty(criteria3.get().getYearTable3211())) {
//			// Insert 3211			
//						int result3211=criteria3Repository.insertYearTable3211U(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//								grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//								grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//						System.out.println("result3211 inserted=======>"+result3211);
//					}else {
//			// update 3211		
//					System.out.println("yr 3211 is not  empty.....");
//					String value3211 = criteria3.get().getYearTable3211().get(0).getInput3211v();
//					System.out.println("existing value3211 is============>"+value3211);
//					BigDecimal bd2 = new BigDecimal(value3211);
//					BigDecimal finalValue3211 = bd2.add(new BigDecimal(grantInfo.getGrantsResearchProjects().get(0).getInputgrt9()));
//					System.out.println("what is the finalValue3211 ==>"+finalValue3211);
//					System.out.println("unique key ==>"+grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
//					int update3211=criteria3Repository.updateYearTable3211U(finalValue3211,grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
//					System.out.println("update3211 u=======>"+update3211);	
//					}
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(grantInfo.getCriteriaId().getCollegeId(),
//				grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3231
//		int result3231=criteria3Repository.insertYearTable3231(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//				grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//				grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("result3231 inserted=======>"+result3231);
//
//   //3221 insert
//		if("government".equalsIgnoreCase(grantInfo.getGrantsResearchProjects().get(0).getInputgrt6())) {
//			int result3221=criteria3Repository.insertYearTable3221U(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//					grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//					grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3221 inserted=======>"+result3221);		
//		}
//   // Insert 3211 
//		else {
//			int result3211=criteria3Repository.insertYearTable3211U(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//					grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//					grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3211 inserted=======>"+result3211);
//		}  
//	  }			
//}
////3211 Au
//	else if("autonomous".equalsIgnoreCase(grantInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(grantInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(grantInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(grantInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3211())) {
//				System.out.println(" yr 3211 is empty.....");
//	//Insert 3211
//			int result3211=criteria3Repository.insertYearTable3211Au(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//					grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//					grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3211 inserted=======>"+result3211);
//			}else {
//	//update 3211		
//				System.out.println("yr 3211 is not  empty.....");
//					String value3211 = criteria3.get().getYearTable3211().get(0).getInput3211v();
//					System.out.println("existing value is============>"+value3211);
//					BigDecimal bd1 = new BigDecimal(value3211);
//					BigDecimal finalValue2 = bd1.add(new BigDecimal(grantInfo.getGrantsResearchProjects().get(0).getInputgrt9()));
//					System.out.println("what is the final value1 ==>"+finalValue2);
//					System.out.println("unique key ==>"+grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
//					int update3211=criteria3Repository.updateYearTable3211Au(finalValue2,grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
//					System.out.println("update3211 u=======>"+update3211);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(grantInfo.getCriteriaId().getCollegeId(),
//				grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3211
//		int result3211=criteria3Repository.insertYearTable3211Au(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//				grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//				grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("result3211 inserted=======>"+result3211);
//	  
//	  }			
//}
//// 3111 Af
//	else if("affiliated".equalsIgnoreCase(grantInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(grantInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(grantInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(grantInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getAffiliatedYearTable3111())) {
//				System.out.println(" yr 3111 is empty.....");
//	//Insert 3111
//			int result3111=criteria3Repository.insertYearTable3111Af(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//					grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//					grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3111 inserted=======>"+result3111);
//			}else {
//	//update 3231		
//				System.out.println("yr 3111 is not  empty.....");
//					String value3111 = criteria3.get().getAffiliatedYearTable3111().get(0).getInput3111v();
//					System.out.println("existing value is============>"+value3111);
//					BigDecimal bd1 = new BigDecimal(value3111);
//					BigDecimal finalValue3 = bd1.add(new BigDecimal(grantInfo.getGrantsResearchProjects().get(0).getInputgrt9()));
//					System.out.println("what is the final value1 ==>"+finalValue3);
//					System.out.println("unique key ==>"+grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
//					int update3111=criteria3Repository.updateYearTable3111Af(finalValue3,grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
//					System.out.println("update3111 u=======>"+update3111);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(grantInfo.getCriteriaId().getCollegeId(),
//				grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3111
//		int result3111=criteria3Repository.insertYearTable3111Af(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//				grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(),1,grantInfo.getCriteriaId().getCollegeId(),
//				grantInfo.getCriteriaId().getFinancialYear(),grantInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("result3111 inserted=======>"+result3111);
//
//	  
//	  }			
//} 
//			int result321 = criteria3Repository.updateYearTable3211(grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
//					grantInfo.getGrantsResearchProjects().get(0).getInputgrt9());
//			System.out.println("result321=============>"+result321);
			return grantResearchRepository.save(grantInfo);

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

	

	public List<GrantsResearchMain> getAllGrantResearchData() {
		try {
			List<GrantsResearchMain> criteria1 = new ArrayList<GrantsResearchMain>();

			grantResearchRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
