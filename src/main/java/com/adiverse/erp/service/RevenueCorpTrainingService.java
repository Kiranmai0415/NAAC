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
import com.adiverse.erp.model.RevenueCorpTrainingMain;
import com.adiverse.erp.model.RevenueCorporateTrainingFileUpload;
import com.adiverse.erp.model.SeedMoneyFileUpload;
import com.adiverse.erp.model.SeedMoneyMain;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.RevenueCorpTrainingRepository;
import com.adiverse.erp.repository.SeedMoneyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class RevenueCorpTrainingService {

	private final Logger logger = LoggerFactory.getLogger(RevenueCorpTrainingService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private RevenueCorpTrainingRepository revenueCorpTrainingRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;

	public RevenueCorpTrainingMain revenueCorpTrainInfo(RevenueCorpTrainingMain revenueCorpTrainobj, MultipartFile[] revenueCorpTrainFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(revenueCorpTrainobj));
			List<RevenueCorporateTrainingFileUpload> file1 = new ArrayList<>();
if(revenueCorpTrainFiles != null) {
			for (int i = 0; i < revenueCorpTrainFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = revenueCorpTrainFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(revenueCorpTrainFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				RevenueCorporateTrainingFileUpload fileUpload1 = new RevenueCorporateTrainingFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+revenueCorpTrainobj.getCriteriaId().getFinancialYear()));
				fileUpload1.setRevenueCorpoTrainingFileName(filename);
				fileUpload1.setRevenueCorpoTrainingFilePath(filepath);
				fileUpload1.setRevenueCorpoTrainingFileType(param);
				fileUpload1.setCriteriaId(revenueCorpTrainobj.getCriteriaId());

				file1.add(fileUpload1);

			}
			revenueCorpTrainobj.setRevenueCorporateTrainingFileUpload(file1);
}
////3521 U
//	 if("university".equalsIgnoreCase(revenueCorpTrainobj.getCriteriaId().getTypeofInstitution())) {
//			
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(revenueCorpTrainobj.getCriteriaId().getCollegeId());
//			key.setFinancialYear(revenueCorpTrainobj.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//			if(criteria3.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria3.get().getYearTable3521())) {
//					System.out.println("yr 3521 tb is empty.....");
//		//Insert 3521 					
//					int result3521=criteria3Repository.insertYearTable3521(revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt6(),
//							revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt7(),1,revenueCorpTrainobj.getCriteriaId().getCollegeId(),
//							revenueCorpTrainobj.getCriteriaId().getFinancialYear(),revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result3521 inserted=======>"+result3521);
//			}else {
//				
//		//update 3521 		
//	    System.out.println("yr 3521 tb is not  empty Corp.....");
//		String value3521Corp= criteria3.get().getYearTable3521().get(0).getInput3521v();
//		System.out.println("existing value3521Corp is============>"+value3521Corp);
//		BigDecimal bd1 = new BigDecimal(value3521Corp);
//		BigDecimal finalValue2=bd1.add(new BigDecimal(revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt7()));
//		System.out.println("what is the final value ==>"+finalValue2);
//		System.out.println("unique key ==>"+criteria3.get().getYearTable3521().get(0).getUniqueKey1());
//		int update3521Corp=criteria3Repository.updateYearTable3521Corp(finalValue2,criteria3.get().getYearTable3521().get(0).getUniqueKey1());
//		System.out.println("update3521Corp u Corp =======>"+update3521Corp);			
//					}
//		  }else {
//					
//			System.out.println("inserting into cr3 main table else......");
//			int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(revenueCorpTrainobj.getCriteriaId().getCollegeId(),
//					revenueCorpTrainobj.getCriteriaId().getFinancialYear(),revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria3Main else====>"+criteria3Main);
//		//Insert 3481					
////			int result3521=criteria3Repository.insertYearTable3521(revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt6(),
////					revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt7(),1,revenueCorpTrainobj.getCriteriaId().getCollegeId(),
////					revenueCorpTrainobj.getCriteriaId().getFinancialYear(),revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
////		System.out.println("result3521 inserted=======>"+result3521);
//		  
//		  }			
//	}	
////3511 Au
//	 else if("autonomous".equalsIgnoreCase(revenueCorpTrainobj.getCriteriaId().getTypeofInstitution())) {
//			
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(revenueCorpTrainobj.getCriteriaId().getCollegeId());
//			key.setFinancialYear(revenueCorpTrainobj.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//			if(criteria3.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria3.get().getYearTable3511())) {
//					System.out.println("yr 3511 tb is empty.....");
//		//Insert 3511 					
//					int result3511=criteria3Repository.insertYearTable3511(revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt6(),
//							revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt7(),1,revenueCorpTrainobj.getCriteriaId().getCollegeId(),
//							revenueCorpTrainobj.getCriteriaId().getFinancialYear(),revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result3511 inserted=======>"+result3511);
//			}else {
//				
//		//update 3511 		
//	    System.out.println("yr 3511 tb is not  empty Corp.....");
//		String value3511Corp= criteria3.get().getYearTable3511().get(0).getInput3511v();
//		System.out.println("existing value3511Corp is============>"+value3511Corp);
//		BigDecimal bd1 = new BigDecimal(value3511Corp);
//		BigDecimal finalValue2=bd1.add(new BigDecimal(revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt7()));
//		System.out.println("what is the final value ==>"+finalValue2);
//		System.out.println("unique key ==>"+criteria3.get().getYearTable3511().get(0).getUniqueKey1());
//		int update3511Corp=criteria3Repository.updateYearTable3511Corp(finalValue2,criteria3.get().getYearTable3511().get(0).getUniqueKey1());
//		System.out.println("update3511Corp u Corp =======>"+update3511Corp);			
//					}
//		  }else {
//					
//			System.out.println("inserting into cr3 main table else......");
//			int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(revenueCorpTrainobj.getCriteriaId().getCollegeId(),
//					revenueCorpTrainobj.getCriteriaId().getFinancialYear(),revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria3Main else====>"+criteria3Main);
//		//Insert 3481					
////			int result3521=criteria3Repository.insertYearTable3521(revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt6(),
////					revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt7(),1,revenueCorpTrainobj.getCriteriaId().getCollegeId(),
////					revenueCorpTrainobj.getCriteriaId().getFinancialYear(),revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
////		System.out.println("result3521 inserted=======>"+result3521);
//		  
//		  }			
//	}	
			return revenueCorpTrainingRepository.save(revenueCorpTrainobj);

		} catch (Exception e) {
			e.printStackTrace();
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

	

	public List<RevenueCorpTrainingMain> getAllRevCorpTrainData() {
		try {
			List<RevenueCorpTrainingMain> criteria1 = new ArrayList<RevenueCorpTrainingMain>();

			revenueCorpTrainingRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
