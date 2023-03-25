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
import com.adiverse.erp.model.RevenueConsultancyFileUpload;
import com.adiverse.erp.model.RevenueConsultancyMain;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.RevenueConsultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class RevenueConsultService {

	private final Logger logger = LoggerFactory.getLogger(RevenueConsultService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;
	
	@Autowired
	private RevenueConsultRepository revenueConsultRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;

	public RevenueConsultancyMain revenueConsultInfo(RevenueConsultancyMain revenueConsultobj, MultipartFile[] revenueConsultFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(revenueConsultobj));
			List<RevenueConsultancyFileUpload> file1 = new ArrayList<>();
if(revenueConsultFiles != null) {
			for (int i = 0; i < revenueConsultFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = revenueConsultFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(revenueConsultFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				RevenueConsultancyFileUpload fileUpload1 = new RevenueConsultancyFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+revenueConsultobj.getCriteriaId().getFinancialYear()));
				fileUpload1.setRevenueConsultancyFileName(filename);
				fileUpload1.setRevenueConsultancyFilePath(filepath);
				fileUpload1.setRevenueConsultancyFileType(param);
				fileUpload1.setCriteriaId(revenueConsultobj.getCriteriaId());

				file1.add(fileUpload1);

			}
			revenueConsultobj.setRevenueConsultancyFileUpload(file1);
}
////3521 u
// if("university".equalsIgnoreCase(revenueConsultobj.getCriteriaId().getTypeofInstitution())) {
//			
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(revenueConsultobj.getCriteriaId().getCollegeId());
//			key.setFinancialYear(revenueConsultobj.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(revenueConsultobj.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//			if(criteria3.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria3.get().getYearTable3521())) {
//					System.out.println("yr 3521 tb is empty.....");
//		//Insert 3521 					
//		int result3521=criteria3Repository.insertYearTable3521(revenueConsultobj.getRevenueConsultancy().get(0).getInputrct6(),
//				revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7(),1,revenueConsultobj.getCriteriaId().getCollegeId(),
//				revenueConsultobj.getCriteriaId().getFinancialYear(),revenueConsultobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("result3521 inserted=======>"+result3521);
//				
//				}else {
//		//update 3521 		
//			System.out.println("yr 3521 tb is not  empty.....");
//				String value3521t1= criteria3.get().getYearTable3521().get(0).getInput3521v();
//				System.out.println("existing value3521 is============>"+value3521t1);
//				BigDecimal bd1 = new BigDecimal(value3521t1);
//			BigDecimal finalValue1=bd1.add(new BigDecimal(revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7()));
//				System.out.println("what is the final value ==>"+finalValue1);
//				System.out.println("unique key ==>"+revenueConsultobj.getRevenueConsultancy().get(0).getUniqueKey1());
//				int update3521=criteria3Repository.updateYearTable3521(finalValue1,revenueConsultobj.getRevenueConsultancy().get(0).getUniqueKey1());
//				System.out.println("update3521 u=======>"+update3521);
//					}
//		  }else {
//					
//			System.out.println("inserting into cr3 main table else......");
//			int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(revenueConsultobj.getCriteriaId().getCollegeId(),
//					revenueConsultobj.getCriteriaId().getFinancialYear(),revenueConsultobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria3Main else====>"+criteria3Main);
//		//Insert 3521					
//			int result3521=criteria3Repository.insertYearTable3521(revenueConsultobj.getRevenueConsultancy().get(0).getInputrct6(),
//					revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7(),1,revenueConsultobj.getCriteriaId().getCollegeId(),
//					revenueConsultobj.getCriteriaId().getFinancialYear(),revenueConsultobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3521 inserted=======>"+result3521);
//		  
//		  }			
//	}	
// // 3511 Au
// else if("autonomous".equalsIgnoreCase(revenueConsultobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(revenueConsultobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(revenueConsultobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(revenueConsultobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3511())) {
//				System.out.println("yr 3511 tb is empty.....");
//	//Insert 3511 					
//	int result3511=criteria3Repository.insertYearTable3511(revenueConsultobj.getRevenueConsultancy().get(0).getInputrct6(),
//			revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7(),1,revenueConsultobj.getCriteriaId().getCollegeId(),
//			revenueConsultobj.getCriteriaId().getFinancialYear(),revenueConsultobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3511 inserted=======>"+result3511);
//			
//			}else {
//	//update 3511 		
//		System.out.println("yr 3511 tb is not  empty.....");
//			String value3511t1= criteria3.get().getYearTable3511().get(0).getInput3511v();
//			System.out.println("existing value3511t1 is============>"+value3511t1);
//			BigDecimal bd1 = new BigDecimal(value3511t1);
//		BigDecimal finalValue1=bd1.add(new BigDecimal(revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7()));
//			System.out.println("what is the final value ==>"+finalValue1);
//			System.out.println("unique key ==>"+revenueConsultobj.getRevenueConsultancy().get(0).getUniqueKey1());
//			int update3511=criteria3Repository.updateYearTable3511(finalValue1,revenueConsultobj.getRevenueConsultancy().get(0).getUniqueKey1());
//			System.out.println("update3511 u=======>"+update3511);
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(revenueConsultobj.getCriteriaId().getCollegeId(),
//				revenueConsultobj.getCriteriaId().getFinancialYear(),revenueConsultobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3511					
//		int result3511=criteria3Repository.insertYearTable3511(revenueConsultobj.getRevenueConsultancy().get(0).getInputrct6(),
//				revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7(),1,revenueConsultobj.getCriteriaId().getCollegeId(),
//				revenueConsultobj.getCriteriaId().getFinancialYear(),revenueConsultobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("result3511 inserted=======>"+result3511);
//	  
//	  }			
//}	
//			int result = criteria3Repository.updateYearTable3511(revenueConsultobj.getRevenueConsultancy().get(0).getInputrct6(),
//					revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7());
//			System.out.println("result=============>"+result);
			return revenueConsultRepository.save(revenueConsultobj);

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

	

	public List<RevenueConsultancyMain> getAllRevenueConsultData() {
		try {
			List<RevenueConsultancyMain> criteria1 = new ArrayList<RevenueConsultancyMain>();

			revenueConsultRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
