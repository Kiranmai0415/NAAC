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
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.ResearchFellowsEnrolledMain;
import com.adiverse.erp.model.ResearchFellowsEnrolledinInstitutionFileUpload;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.ResearchFellowsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class ResearchFellowsService {

	private final Logger logger = LoggerFactory.getLogger(ResearchFellowsService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private ResearchFellowsRepository researchFellowsRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;

	public ResearchFellowsEnrolledMain researchInfo1(ResearchFellowsEnrolledMain reseachFellowsInfo, MultipartFile[] reseachFellowsFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(reseachFellowsInfo));
			List<ResearchFellowsEnrolledinInstitutionFileUpload> file1 = new ArrayList<>();
if(reseachFellowsFiles != null) {
			for (int i = 0; i < reseachFellowsFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = reseachFellowsFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(reseachFellowsFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				ResearchFellowsEnrolledinInstitutionFileUpload fileUpload1 = new ResearchFellowsEnrolledinInstitutionFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+reseachFellowsInfo.getCriteriaId().getFinancialYear()));
				fileUpload1.setResearchFellowEnrolinInstituteFileName(filename);
				fileUpload1.setResearchFellowEnrolinInstituteFilePath(filepath);
				fileUpload1.setResearchFellowEnrolinInstituteFileType(param);
				fileUpload1.setCriteriaId(reseachFellowsInfo.getCriteriaId());

				file1.add(fileUpload1);

			}
			reseachFellowsInfo.setResearchFellowsEnrolledinInstitutionFileUpload(file1);
}
////3141 U
//	if("university".equalsIgnoreCase(reseachFellowsInfo.getCriteriaId().getTypeofInstitution())) {
//				
//				CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//				key.setCollegeId(reseachFellowsInfo.getCriteriaId().getCollegeId());
//				key.setFinancialYear(reseachFellowsInfo.getCriteriaId().getFinancialYear());
//				key.setTypeofInstitution(reseachFellowsInfo.getCriteriaId().getTypeofInstitution());
//				Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//				if(criteria3.isPresent()) {
//					if(CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable3141())) {
//						System.out.println("3141 table is empty.....");
//			//Insert 3141 tb					
//						int result3141=criteria3Repository.insertYearTable3141(reseachFellowsInfo.getResearchFellowsEnrolledinInstitution().get(0).getInputrft4(),
//								1,1,reseachFellowsInfo.getCriteriaId().getCollegeId(),
//								reseachFellowsInfo.getCriteriaId().getFinancialYear(),reseachFellowsInfo.getCriteriaId().getTypeofInstitution());
//					System.out.println("result3141 inserted=======>"+result3141);
//					}else {
//			//update 3141 tb		
//						System.out.println("yr 3141 is not  empty.....");
//							String value3141= criteria3.get().getUniversityYearTable3141().get(0).getInput3141v();
//							System.out.println("existing value3141 is============>"+value3141);
//							BigDecimal bd = new BigDecimal(value3141);
//							int finalValue = bd.intValue() + 1;
//							System.out.println("what is the final value ==>"+finalValue);
//							System.out.println("unique key ==>"+reseachFellowsInfo.getResearchFellowsEnrolledinInstitution().get(0).getUniqueKey1());
//							int update3141=criteria3Repository.updateYearTable3141(finalValue,
//									reseachFellowsInfo.getResearchFellowsEnrolledinInstitution().get(0).getUniqueKey1());
//							System.out.println("update3141 u=======>"+update3141);			
//						}
//			  }else {
//						
//				System.out.println("inserting into cr3 main table else......");
//				int criteria2Main=criteria3Repository.insertCriteria3FieldInfoMain(reseachFellowsInfo.getCriteriaId().getCollegeId(),
//						reseachFellowsInfo.getCriteriaId().getFinancialYear(),reseachFellowsInfo.getCriteriaId().getTypeofInstitution());
//				System.out.println("criteria2Main else====>"+criteria2Main);
//	//Insert 3141 tb
//				int result3141=criteria3Repository.insertYearTable3141(reseachFellowsInfo.getResearchFellowsEnrolledinInstitution().get(0).getInputrft4(),
//						1,1,reseachFellowsInfo.getCriteriaId().getCollegeId(),
//						reseachFellowsInfo.getCriteriaId().getFinancialYear(),reseachFellowsInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3141 inserted=======>"+result3141);
//		
//			  
//			  }			
//		}		
			return researchFellowsRepository.save(reseachFellowsInfo);

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

	

	public List<ResearchFellowsEnrolledMain> getAllResearchFellowsData() {
		try {
			List<ResearchFellowsEnrolledMain> criteria1 = new ArrayList<ResearchFellowsEnrolledMain>();

			researchFellowsRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
