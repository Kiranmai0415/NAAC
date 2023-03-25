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
import com.adiverse.erp.model.FacultyAwardsFileUpload;
import com.adiverse.erp.model.FacultyAwardsMain;
import com.adiverse.erp.repository.Criteria2Repository;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.FacultyAwardsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class FacultyAwardsService {

	private final Logger logger = LoggerFactory.getLogger(FacultyAwardsService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private FacultyAwardsRepository facultyAwardsRepository;
	
	@Autowired
	private Criteria2Repository criteria2Repository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;


	public FacultyAwardsMain facultyAwardsInfo(FacultyAwardsMain awardsInfo, MultipartFile[] facultyFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(awardsInfo));
			List<FacultyAwardsFileUpload> file1 = new ArrayList<>();
if(facultyFiles != null) {
			for (int i = 0; i < facultyFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = facultyFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(facultyFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				FacultyAwardsFileUpload fileUpload1 = new FacultyAwardsFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+awardsInfo.getCriteriaId().getFinancialYear()));
				fileUpload1.setFacultyAwardsFileName(filename);
				fileUpload1.setFacultyAwardsFilePath(filepath);
				fileUpload1.setFacultyAwardsFileType(facultyFiles[i].getContentType());
				fileUpload1.setCriteriaId(awardsInfo.getCriteriaId());

				file1.add(fileUpload1);

			}
			awardsInfo.setFacultyAwardsFileUpload(file1);
}	
////2441 U
// if("university".equalsIgnoreCase(awardsInfo.getCriteriaId().getTypeofInstitution())) {
//			
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(awardsInfo.getCriteriaId().getCollegeId());
//			key.setFinancialYear(awardsInfo.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(awardsInfo.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//			if(criteria2.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria2.get().getUniversityYearTable2441())) {
//					System.out.println(" yr 2441 is empty.....");
//		//Insert 2441
//				int result2441=criteria2Repository.insertYearTable2441(awardsInfo.getFacultyAwards().get(0).getInputfat9(),
//						1,1,awardsInfo.getCriteriaId().getCollegeId(),
//						awardsInfo.getCriteriaId().getFinancialYear(),awardsInfo.getCriteriaId().getTypeofInstitution());
//				System.out.println("result2441 inserted=======>"+result2441);
//				
//				}else {
//		//update 2441		
//					System.out.println("yr 2441 is not  empty.....");
//						String value2441 = criteria2.get().getUniversityYearTable2441().get(0).getInput2441v();
//						System.out.println("existing value is============>"+value2441);
//						BigDecimal bd = new BigDecimal(value2441);
//						int finalValue = bd.intValue() + 1;
//						System.out.println("what is the final value ==>"+finalValue);
//						System.out.println("unique key ==>"+awardsInfo.getFacultyAwards().get(0).getUniqueKey1());
//						int update2441=criteria2Repository.updateYearTable2441(finalValue,awardsInfo.getFacultyAwards().get(0).getUniqueKey1());
//						System.out.println("update2441 u=======>"+update2441);			
//					}
//		  }else {
//					
//			System.out.println("inserting into cr2 main table else......");
//			int criteria2Main=criteria2Repository.insertCriteria2Main(awardsInfo.getCriteriaId().getCollegeId(),
//					awardsInfo.getCriteriaId().getFinancialYear(),awardsInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria2Main else====>"+criteria2Main);
//	//insert 2421 tx area			
//			int result2441=criteria2Repository.insertYearTable2441(awardsInfo.getFacultyAwards().get(0).getInputfat9(),
//					1,1,awardsInfo.getCriteriaId().getCollegeId(),
//					awardsInfo.getCriteriaId().getFinancialYear(),awardsInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result2441 inserted=======>"+result2441);
//	
//		  
//		  }			
//	}else {
//		System.out.println("inserted and updated into 2441........");
//	}
// System.out.println("now inserting into table 3331 university.........");
// 
// 
////3331 table U
// 
// if("university".equalsIgnoreCase(awardsInfo.getCriteriaId().getTypeofInstitution())) {
//			
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(awardsInfo.getCriteriaId().getCollegeId());
//			key.setFinancialYear(awardsInfo.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(awardsInfo.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//			if(criteria3.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable3331())) {
//					System.out.println(" yr 3331 is empty.....");
//		//Insert 3331
//				int result3331=criteria3Repository.insertYearTable3331(awardsInfo.getFacultyAwards().get(0).getInputfat9(),
//						1,1,awardsInfo.getCriteriaId().getCollegeId(),
//						awardsInfo.getCriteriaId().getFinancialYear(),awardsInfo.getCriteriaId().getTypeofInstitution());
//				System.out.println("result3331 inserted=======>"+result3331);
//				
//				}else {
//		//update 3331		
//					System.out.println("yr 3331 is not  empty.....");
//						String value3331 = criteria3.get().getUniversityYearTable3331().get(0).getInput3331v();
//						System.out.println("existing value is============>"+value3331);
//						BigDecimal bd = new BigDecimal(value3331);
//						int finalValue1 = bd.intValue() + 1;
//						System.out.println("what is the final value ==>"+finalValue1);
//						System.out.println("unique key ==>"+awardsInfo.getFacultyAwards().get(0).getUniqueKey1());
//						int update3331=criteria3Repository.updateYearTable3331(finalValue1,awardsInfo.getFacultyAwards().get(0).getUniqueKey1());
//						System.out.println("update3331 u=======>"+update3331);			
//					}
//		  }else {
//					
//			System.out.println("inserting into cr3 main table else......");
//			int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(awardsInfo.getCriteriaId().getCollegeId(),
//					awardsInfo.getCriteriaId().getFinancialYear(),awardsInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria2Main else====>"+criteria3Main);
//		//Insert 3331
//			int result3331=criteria3Repository.insertYearTable3331(awardsInfo.getFacultyAwards().get(0).getInputfat9(),
//					1,1,awardsInfo.getCriteriaId().getCollegeId(),
//					awardsInfo.getCriteriaId().getFinancialYear(),awardsInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3331 inserted=======>"+result3331);
//	
//		  
//		  }			
//	}
			return facultyAwardsRepository.save(awardsInfo);

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

	

	public List<FacultyAwardsMain> getAllFacultyData() {
		try {
			List<FacultyAwardsMain> criteria1 = new ArrayList<FacultyAwardsMain>();

			facultyAwardsRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
