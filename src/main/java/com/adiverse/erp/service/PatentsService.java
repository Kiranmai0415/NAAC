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
import java.util.Map;
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
import com.adiverse.erp.model.PatentsFileUpload;
import com.adiverse.erp.model.PatentsMain;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.PatentsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class PatentsService {

	private final Logger logger = LoggerFactory.getLogger(PatentsService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private PatentsRepository patentsRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;

	public PatentsMain patentsInfo(PatentsMain patentsObj, MultipartFile[] patentsFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(patentsObj));
			List<PatentsFileUpload> file1 = new ArrayList<>();
if(patentsFiles != null) {
			for (int i = 0; i < patentsFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = patentsFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(patentsFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				PatentsFileUpload fileUpload1 = new PatentsFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+patentsObj.getCriteriaId().getFinancialYear()));
				fileUpload1.setPatentsFileName(filename);
				fileUpload1.setPatentsFilePath(filepath);
				fileUpload1.setPatentsFileType(param);
				fileUpload1.setCriteriaId(patentsObj.getCriteriaId());

				file1.add(fileUpload1);

			}
			patentsObj.setPatentsFileUpload(file1);
}
////3431 U
//	if("university".equalsIgnoreCase(patentsObj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(patentsObj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(patentsObj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(patentsObj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable3431())) {
//				System.out.println("3431 table is empty.....");
//	//Insert 3431 tb					
//				int result3431=criteria3Repository.insertYearTable3431(patentsObj.getPatents().get(0).getInputppt7(),
//						1,1,patentsObj.getCriteriaId().getCollegeId(),
//						patentsObj.getCriteriaId().getFinancialYear(),patentsObj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3431 inserted=======>"+result3431);
//			}else {
//	//update 3431 tb		
//				System.out.println("yr 3431 is not  empty.....");
//					String value3431= criteria3.get().getUniversityYearTable3431().get(0).getInput3431v();
//					System.out.println("existing value3431 is============>"+value3431);
//					BigDecimal bd = new BigDecimal(value3431);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+patentsObj.getPatents().get(0).getUniqueKey1());
//					int update3431=criteria3Repository.updateYearTable3431(finalValue,
//							patentsObj.getPatents().get(0).getUniqueKey1());
//					System.out.println("update3321 u=======>"+update3431);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(patentsObj.getCriteriaId().getCollegeId(),
//				patentsObj.getCriteriaId().getFinancialYear(),patentsObj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3431 tb					
//		int result3431=criteria3Repository.insertYearTable3431(patentsObj.getPatents().get(0).getInputppt7(),
//				1,1,patentsObj.getCriteriaId().getCollegeId(),
//				patentsObj.getCriteriaId().getFinancialYear(),patentsObj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3431 inserted=======>"+result3431);
//
//	  
//	  }			
//}		
			//int result = criteria3Repository.updateYearTable3431();
			//System.out.println("result=============>"+result);
			return patentsRepository.save(patentsObj);

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

	

	public List<PatentsMain> getAllPatentData() {
		try {
			List<PatentsMain> criteria1 = new ArrayList<PatentsMain>();

			patentsRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
