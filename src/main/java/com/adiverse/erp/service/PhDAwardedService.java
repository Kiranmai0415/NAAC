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
import com.adiverse.erp.model.FacultyAwardsFileUpload;
import com.adiverse.erp.model.PhdAwardedorRegisteredFileUpload;
import com.adiverse.erp.model.PhdAwardedorRegisteredMain;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.PhDAwardedRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class PhDAwardedService {

	private final Logger logger = LoggerFactory.getLogger(PhDAwardedService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private PhDAwardedRepository phDAwardedRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;

	public PhdAwardedorRegisteredMain phDAwardeInfo(PhdAwardedorRegisteredMain phdInfo, MultipartFile[] phdFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(phdInfo));
			List<PhdAwardedorRegisteredFileUpload> file1 = new ArrayList<>();
if(phdFiles != null) {
			for (int i = 0; i < phdFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = phdFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(phdFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				PhdAwardedorRegisteredFileUpload fileUpload1 = new PhdAwardedorRegisteredFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+phdInfo.getCriteriaId().getFinancialYear()));
				fileUpload1.setPhdawardedFileName(filename);
				fileUpload1.setPhdawardedFilePath(filepath);
				fileUpload1.setPhdawardedFileType(param);
				fileUpload1.setCriteriaId(phdInfo.getCriteriaId());

				file1.add(fileUpload1);

			}
			phdInfo.setPhdAwardedorRegisteredFileUpload(file1);
}
////3441 & 3442
// if("university".equalsIgnoreCase(phdInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(phdInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(phdInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(phdInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3441())) {
//				System.out.println("3441 table is empty.....");
//	//Insert 3441 tb					
//				int result3441=criteria3Repository.insertYearTable3441(phdInfo.getPhdAwardedorRegistered().get(0).getInputphdt10(),
//						1,1,phdInfo.getCriteriaId().getCollegeId(),
//						phdInfo.getCriteriaId().getFinancialYear(),phdInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3441 inserted=======>"+result3441);
//			
//			}else {
//	//update 3441 tb		
//				System.out.println("yr 3441 is not  empty.....");
//					String value3441= criteria3.get().getYearTable3441().get(0).getInput3441v();
//					System.out.println("existing value3441 is============>"+value3441);
//					BigDecimal bd = new BigDecimal(value3441);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+phdInfo.getPhdAwardedorRegistered().get(0).getUniqueKey1());
//					int update3441=criteria3Repository.updateYearTable3441(finalValue,
//							phdInfo.getPhdAwardedorRegistered().get(0).getUniqueKey1());
//					System.out.println("update3441 u=======>"+update3441);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(phdInfo.getCriteriaId().getCollegeId(),
//				phdInfo.getCriteriaId().getFinancialYear(),phdInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3441 tb					
//		int result3441=criteria3Repository.insertYearTable3441(phdInfo.getPhdAwardedorRegistered().get(0).getInputphdt10(),
//				1,1,phdInfo.getCriteriaId().getCollegeId(),
//				phdInfo.getCriteriaId().getFinancialYear(),phdInfo.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3441 inserted=======>"+result3441);
//
//	  
//	  }			
//}					
			return phDAwardedRepository.save(phdInfo);

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

	

	public List<PhdAwardedorRegisteredMain> getAllPhDAwardedData() {
		try {
			List<PhdAwardedorRegisteredMain> criteria1 = new ArrayList<PhdAwardedorRegisteredMain>();

			phDAwardedRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
