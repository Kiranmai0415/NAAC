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
import com.adiverse.erp.model.SeedMoneyFileUpload;
import com.adiverse.erp.model.SeedMoneyMain;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.Criteria6Repository;
import com.adiverse.erp.repository.SeedMoneyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class SeedMoneyService {

	private static final String String = null;

	private final Logger logger = LoggerFactory.getLogger(SeedMoneyService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private SeedMoneyRepository seedMoneyRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;

   
	@Autowired
	private Criteria6Repository criteria6Repository;
	
	public SeedMoneyMain seedMoneyInfo(SeedMoneyMain seedMoney, MultipartFile[] seedMoneyFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(seedMoney));
			List<SeedMoneyFileUpload> file1 = new ArrayList<>();
if(seedMoneyFiles != null) {
			for (int i = 0; i < seedMoneyFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = seedMoneyFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(seedMoneyFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				SeedMoneyFileUpload fileUpload1 = new SeedMoneyFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+seedMoney.getCriteriaId().getFinancialYear()));
				fileUpload1.setSeedMoneyFileName(filename);
				fileUpload1.setSeedMoneyFilePath(filepath);
				fileUpload1.setSeedMoneyFileType(seedMoneyFiles[i].getContentType());
				fileUpload1.setCriteriaId(seedMoney.getCriteriaId());

				file1.add(fileUpload1);

			}
			seedMoney.setSeedMoneyFileUpload(file1);
}
////3.1.2 U
//			if("university".equalsIgnoreCase(seedMoney.getCriteriaId().getTypeofInstitution())) {
//			
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(seedMoney.getCriteriaId().getCollegeId());
//			key.setFinancialYear(seedMoney.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(seedMoney.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//			if(criteria3.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria3.get().getYearTable3121())) {
//					System.out.println(" yr 3121  is empty.....");
//		//Insert 3121 tb
//				int result312=criteria3Repository.insertYearTable3121(seedMoney.getSeedMoney().get(0).getInputsmt5(),
//						seedMoney.getSeedMoney().get(0).getInputsmt4(),1,seedMoney.getCriteriaId().getCollegeId(),
//						seedMoney.getCriteriaId().getFinancialYear(),seedMoney.getCriteriaId().getTypeofInstitution());
//				System.out.println("result312 inserted=======>"+result312);
//				}else {
//		//update 3121 tb		
//					System.out.println("yr 3121 is not  empty.....");
//						String value3121 = criteria3.get().getYearTable3121().get(0).getInput3121v();
//						System.out.println("existing value is============>"+value3121);
//						BigDecimal bd = new BigDecimal(value3121);
//						BigDecimal finalValue = bd.add(new BigDecimal(seedMoney.getSeedMoney().get(0).getInputsmt4()));
//						System.out.println("what is the final value ==>"+finalValue);
//						System.out.println("unique key ==>"+seedMoney.getSeedMoney().get(0).getUniqueKey1());
//						int update3121=criteria3Repository.updateYearTable3121(finalValue,seedMoney.getSeedMoney().get(0).getUniqueKey1());
//						System.out.println("update3121 u=======>"+update3121);			
//					}
//		  }else {
//					
//			System.out.println("inserting into cr3 main table else......");
//			int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(seedMoney.getCriteriaId().getCollegeId(),
//					seedMoney.getCriteriaId().getFinancialYear(),seedMoney.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria3Main else====>"+criteria3Main);
//	//insert 3121 tb			
//			int result312=criteria3Repository.insertYearTable3121(seedMoney.getSeedMoney().get(0).getInputsmt5(),
//					seedMoney.getSeedMoney().get(0).getInputsmt4(),1,seedMoney.getCriteriaId().getCollegeId(),
//					seedMoney.getCriteriaId().getFinancialYear(),seedMoney.getCriteriaId().getTypeofInstitution());
//			System.out.println("result312 inserted else=======>"+result312);
//	
//		  
//		  }			
//	}	
//			else if("autonomous".equalsIgnoreCase(seedMoney.getCriteriaId().getTypeofInstitution())) {
//				
//				CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//				key.setCollegeId(seedMoney.getCriteriaId().getCollegeId());
//				key.setFinancialYear(seedMoney.getCriteriaId().getFinancialYear());
//				key.setTypeofInstitution(seedMoney.getCriteriaId().getTypeofInstitution());
//				Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//				if(criteria3.isPresent()) {
//					if(CollectionUtils.isEmpty(criteria3.get().getYearTable3121())) {
//						System.out.println(" yr 3121  is empty.....");
//			//Insert 3121 tb
//					int result312=criteria3Repository.insertYearTable3121(seedMoney.getSeedMoney().get(0).getInputsmt5(),
//							seedMoney.getSeedMoney().get(0).getInputsmt4(),1,seedMoney.getCriteriaId().getCollegeId(),
//							seedMoney.getCriteriaId().getFinancialYear(),seedMoney.getCriteriaId().getTypeofInstitution());
//					System.out.println("result312 inserted=======>"+result312);
//					}else {
//			//update 3121 tb		
//						System.out.println("yr 3121 is not  empty.....");
//							String value3121 = criteria3.get().getYearTable3121().get(0).getInput3121v();
//							System.out.println("existing value is============>"+value3121);
//							BigDecimal bd = new BigDecimal(value3121);
//							BigDecimal finalValue = bd.add(new BigDecimal(seedMoney.getSeedMoney().get(0).getInputsmt4()));
//							System.out.println("what is the final value ==>"+finalValue);
//							System.out.println("unique key ==>"+seedMoney.getSeedMoney().get(0).getUniqueKey1());
//							int update3121=criteria3Repository.updateYearTable3121(finalValue,seedMoney.getSeedMoney().get(0).getUniqueKey1());
//							System.out.println("update3121 u=======>"+update3121);			
//						}
//			  }else {
//						
//				System.out.println("inserting into cr3 main table else......");
//				int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(seedMoney.getCriteriaId().getCollegeId(),
//						seedMoney.getCriteriaId().getFinancialYear(),seedMoney.getCriteriaId().getTypeofInstitution());
//				System.out.println("criteria3Main else====>"+criteria3Main);
//		//insert 3121 tb			
//				int result312=criteria3Repository.insertYearTable3121(seedMoney.getSeedMoney().get(0).getInputsmt5(),
//						seedMoney.getSeedMoney().get(0).getInputsmt4(),1,seedMoney.getCriteriaId().getCollegeId(),
//						seedMoney.getCriteriaId().getFinancialYear(),seedMoney.getCriteriaId().getTypeofInstitution());
//				System.out.println("result312 inserted else=======>"+result312);
//		
//			  
//			  }			
//		}	
			
//			int result312 = criteria3Repository.updateYearTable3121( seedMoney.getSeedMoney().get(0).getInputsmt5(),
//					seedMoney.getSeedMoney().get(0).getInputsmt4());
//			System.out.println("result312=============>"+result312);
//			int result=criteria6Repository.updateYearTable6341(seedMoney.getSeedMoney().get(0).getInputsmt5(),
//					seedMoney.getSeedMoney().get(0).getInputsmt4());
//			System.out.println("result634=============>"+result);
			return seedMoneyRepository.save(seedMoney);

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

	

	public List<SeedMoneyMain> getAllFacultyData() {
		try {
			List<SeedMoneyMain> criteria1 = new ArrayList<SeedMoneyMain>();

			seedMoneyRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

	
}
