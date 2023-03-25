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
import com.adiverse.erp.model.Criteria6_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FinancialSupportToTeachersFileUpload;
import com.adiverse.erp.model.FinancialSupportToTeachersMain;
import com.adiverse.erp.repository.Criteria6Repository;
import com.adiverse.erp.repository.FinanceSupportTeachRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class FinanceSupportTeachService {

	private final Logger logger = LoggerFactory.getLogger(FinanceSupportTeachService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private FinanceSupportTeachRepository financeSupportTeachRepository;
	
	@Autowired
	private Criteria6Repository criteria6Repository;

	public FinancialSupportToTeachersMain financeSupportTeachInfo(FinancialSupportToTeachersMain financeSupportTeach, MultipartFile[] financeSuppTeachFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(financeSupportTeach));
			List<FinancialSupportToTeachersFileUpload> file1 = new ArrayList<>();
if(financeSuppTeachFiles != null) {
			for (int i = 0; i < financeSuppTeachFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = financeSuppTeachFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(financeSuppTeachFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				FinancialSupportToTeachersFileUpload fileUpload1 = new FinancialSupportToTeachersFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+financeSupportTeach.getCriteriaId().getFinancialYear()));
				fileUpload1.setFinanceSupTeachFileName(filename);
				fileUpload1.setFinanceSupTeachFilePath(filepath);
				fileUpload1.setFinanceSupTeachFileType(param);
				fileUpload1.setCriteriaId(financeSupportTeach.getCriteriaId());

				file1.add(fileUpload1);

			}
			financeSupportTeach.setFinancialSupportToTeachersFileUpload(file1);
}
////6321 U
//	if("university".equalsIgnoreCase(financeSupportTeach.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(financeSupportTeach.getCriteriaId().getCollegeId());
//		key.setFinancialYear(financeSupportTeach.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(financeSupportTeach.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
//		if(criteria6.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria6.get().getYearTable6321())) {
//				System.out.println("6321 table is empty.....");
//	//Insert 6321 tb					
//				int result6321=criteria6Repository.insertYearTable6321(financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(),
//						1,1,financeSupportTeach.getCriteriaId().getCollegeId(),
//						financeSupportTeach.getCriteriaId().getFinancialYear(),financeSupportTeach.getCriteriaId().getTypeofInstitution());
//			System.out.println("result6321 inserted=======>"+result6321);
//			
//			}else {
//	//update 6321 tb		
//				System.out.println("yr 6321 is not  empty.....");
//					String value6321= criteria6.get().getYearTable6321().get(0).getInput6321v();
//					System.out.println("existing value6321 is============>"+value6321);
//					BigDecimal bd = new BigDecimal(value6321);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
//					int update6321=criteria6Repository.updateYearTable6321(finalValue,
//							financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
//					System.out.println("update6321 u=======>"+update6321);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr6 main table else......");
//		int criteria6Main=criteria6Repository.insertCriteria6FieldInfoMain(financeSupportTeach.getCriteriaId().getCollegeId(),
//				financeSupportTeach.getCriteriaId().getFinancialYear(),financeSupportTeach.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria6Main else====>"+criteria6Main);
//	//Insert 6321 tb					
//		int result6321=criteria6Repository.insertYearTable6321(financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(),
//				1,1,financeSupportTeach.getCriteriaId().getCollegeId(),
//				financeSupportTeach.getCriteriaId().getFinancialYear(),financeSupportTeach.getCriteriaId().getTypeofInstitution());
//	System.out.println("result6321 inserted=======>"+result6321);
//	  
//	  }			
//}
////6321 Au
//	else if("autonomous".equalsIgnoreCase(financeSupportTeach.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(financeSupportTeach.getCriteriaId().getCollegeId());
//		key.setFinancialYear(financeSupportTeach.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(financeSupportTeach.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
//		if(criteria6.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria6.get().getYearTable6321())) {
//				System.out.println("3711 table is empty.....");
//	//Insert 6321 tb					
//				int result6321=criteria6Repository.insertYearTable6321(financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(),
//						1,1,financeSupportTeach.getCriteriaId().getCollegeId(),
//						financeSupportTeach.getCriteriaId().getFinancialYear(),financeSupportTeach.getCriteriaId().getTypeofInstitution());
//			System.out.println("result6321 inserted=======>"+result6321);
//			
//			}else {
//	//update 6321 tb		
//				System.out.println("yr 6321 is not  empty.....");
//					String value6321= criteria6.get().getYearTable6321().get(0).getInput6321v();
//					System.out.println("existing value6321 is============>"+value6321);
//					BigDecimal bd = new BigDecimal(value6321);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
//					int update6321=criteria6Repository.updateYearTable6321(finalValue,
//							financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
//					System.out.println("update6321 u=======>"+update6321);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria6Repository.insertCriteria6FieldInfoMain(financeSupportTeach.getCriteriaId().getCollegeId(),
//				financeSupportTeach.getCriteriaId().getFinancialYear(),financeSupportTeach.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 6321 tb					
//		int result6321=criteria6Repository.insertYearTable6321(financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(),
//				1,1,financeSupportTeach.getCriteriaId().getCollegeId(),
//				financeSupportTeach.getCriteriaId().getFinancialYear(),financeSupportTeach.getCriteriaId().getTypeofInstitution());
//	System.out.println("result6321 inserted=======>"+result6321);
//	  
//	  }			
//}
////36321 Af
//	else if("affiliated".equalsIgnoreCase(financeSupportTeach.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(financeSupportTeach.getCriteriaId().getCollegeId());
//		key.setFinancialYear(financeSupportTeach.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(financeSupportTeach.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
//		if(criteria6.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria6.get().getYearTable6321())) {
//				System.out.println("3711 table is empty.....");
//	//Insert 6321 tb					
//				int result6321=criteria6Repository.insertYearTable6321(financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(),
//						1,1,financeSupportTeach.getCriteriaId().getCollegeId(),
//						financeSupportTeach.getCriteriaId().getFinancialYear(),financeSupportTeach.getCriteriaId().getTypeofInstitution());
//			System.out.println("result6321 inserted=======>"+result6321);
//			
//			}else {
//	//update 6321 tb		
//				System.out.println("yr 6321 is not  empty.....");
//					String value6321= criteria6.get().getYearTable6321().get(0).getInput6321v();
//					System.out.println("existing value6321 is============>"+value6321);
//					BigDecimal bd = new BigDecimal(value6321);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
//					int update6321=criteria6Repository.updateYearTable6321(finalValue,
//							financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
//					System.out.println("update6321 u=======>"+update6321);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria6Repository.insertCriteria6FieldInfoMain(financeSupportTeach.getCriteriaId().getCollegeId(),
//				financeSupportTeach.getCriteriaId().getFinancialYear(),financeSupportTeach.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 6321 tb					
//		int result6321=criteria6Repository.insertYearTable6321(financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(),
//				1,1,financeSupportTeach.getCriteriaId().getCollegeId(),
//				financeSupportTeach.getCriteriaId().getFinancialYear(),financeSupportTeach.getCriteriaId().getTypeofInstitution());
//	System.out.println("result6321 inserted=======>"+result6321);
//	  
//	  }			
//}
//			int result = criteria6Repository.updateYearTable6321(financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(),
//					financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst2());
//			System.out.println("result632=============>"+result);
			
			return financeSupportTeachRepository.save(financeSupportTeach);

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

	

	public List<FinancialSupportToTeachersMain> getAllFinanceSuppTeachData() {
		try {
			List<FinancialSupportToTeachersMain> criteria1 = new ArrayList<FinancialSupportToTeachersMain>();

			financeSupportTeachRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
