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
import com.adiverse.erp.model.CollaborationLinkagesMain;
import com.adiverse.erp.model.CollaborationsLinkagesFileUpload;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.repository.CollaborationsRepository;
import com.adiverse.erp.repository.Criteria3Repository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class CollaborationsService {

	private final Logger logger = LoggerFactory.getLogger(CollaborationsService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private CollaborationsRepository collaborationsRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;


	public CollaborationLinkagesMain collaborationInfo(CollaborationLinkagesMain collaborationsobj, MultipartFile[] collaborationsFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(collaborationsobj));
			List<CollaborationsLinkagesFileUpload> file1 = new ArrayList<>();
if(collaborationsFiles != null) {
			for (int i = 0; i < collaborationsFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = collaborationsFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(collaborationsFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				CollaborationsLinkagesFileUpload fileUpload1 = new CollaborationsLinkagesFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+collaborationsobj.getCriteriaId().getFinancialYear()));
				fileUpload1.setCollaborationsLinkagesFileName(filename);
				fileUpload1.setCollaborationsLinkagesFilePath(filepath);
				fileUpload1.setCollaborationsLinkagesFileType(param);
				fileUpload1.setCriteriaId(collaborationsobj.getCriteriaId());

				file1.add(fileUpload1);

			}
			collaborationsobj.setCollaborationsLinkagesFileUpload(file1);
}
////3711 U
//	if("university".equalsIgnoreCase(collaborationsobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(collaborationsobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(collaborationsobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(collaborationsobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3711())) {
//				System.out.println("3711 table is empty.....");
//	//Insert 3711 tb					
//				int result3711=criteria3Repository.insertYearTable3711(collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(),
//						1,1,collaborationsobj.getCriteriaId().getCollegeId(),
//						collaborationsobj.getCriteriaId().getFinancialYear(),collaborationsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3711 inserted=======>"+result3711);
//			
//			}else {
//	//update 3711 tb		
//				System.out.println("yr 3711 is not  empty.....");
//					String value3711= criteria3.get().getYearTable3711().get(0).getInput3711v();
//					System.out.println("existing value3711 is============>"+value3711);
//					BigDecimal bd = new BigDecimal(value3711);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
//					int update3711=criteria3Repository.updateYearTable3711(finalValue,
//							collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
//					System.out.println("update3711 u=======>"+update3711);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(collaborationsobj.getCriteriaId().getCollegeId(),
//				collaborationsobj.getCriteriaId().getFinancialYear(),collaborationsobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3711 tb					
//		int result3711=criteria3Repository.insertYearTable3711(collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(),
//				1,1,collaborationsobj.getCriteriaId().getCollegeId(),
//				collaborationsobj.getCriteriaId().getFinancialYear(),collaborationsobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3711 inserted=======>"+result3711);
//	  
//	  }			
//}	
////3711 Au
//	else if("autonomous".equalsIgnoreCase(collaborationsobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(collaborationsobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(collaborationsobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(collaborationsobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3711())) {
//				System.out.println("3711 table is empty.....");
//	//Insert 3711 tb					
//				int result3711=criteria3Repository.insertYearTable3711(collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(),
//						1,1,collaborationsobj.getCriteriaId().getCollegeId(),
//						collaborationsobj.getCriteriaId().getFinancialYear(),collaborationsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3711 inserted=======>"+result3711);
//			
//			}else {
//	//update 3711 tb		
//				System.out.println("yr 3711 is not  empty.....");
//					String value3711= criteria3.get().getYearTable3711().get(0).getInput3711v();
//					System.out.println("existing value3711 is============>"+value3711);
//					BigDecimal bd = new BigDecimal(value3711);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
//					int update3711=criteria3Repository.updateYearTable3711(finalValue,
//							collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
//					System.out.println("update3711 u=======>"+update3711);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(collaborationsobj.getCriteriaId().getCollegeId(),
//				collaborationsobj.getCriteriaId().getFinancialYear(),collaborationsobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3711 tb					
//		int result3711=criteria3Repository.insertYearTable3711(collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(),
//				1,1,collaborationsobj.getCriteriaId().getCollegeId(),
//				collaborationsobj.getCriteriaId().getFinancialYear(),collaborationsobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3711 inserted=======>"+result3711);
//	  
//	  }			
//}
//// 3711 Af
//	else if("affiliated".equalsIgnoreCase(collaborationsobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(collaborationsobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(collaborationsobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(collaborationsobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3711())) {
//				System.out.println("3711 table affiliated is empty.....");
//	//Insert 3711 tb					
//				int result3711=criteria3Repository.insertYearTable3711(collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(),
//						1,1,collaborationsobj.getCriteriaId().getCollegeId(),
//						collaborationsobj.getCriteriaId().getFinancialYear(),collaborationsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3711 affiliated inserted=======>"+result3711);
//			
//			}else {
//	//update 3711 tb		
//				System.out.println("yr 3711 is not  empty.....");
//					String value3711= criteria3.get().getYearTable3711().get(0).getInput3711v();
//					System.out.println("existing value3711 is============>"+value3711);
//					BigDecimal bd = new BigDecimal(value3711);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
//					int update3711=criteria3Repository.updateYearTable3711(finalValue,
//							collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
//					System.out.println("update3711 affiliated u=======>"+update3711);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(collaborationsobj.getCriteriaId().getCollegeId(),
//				collaborationsobj.getCriteriaId().getFinancialYear(),collaborationsobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main affiliated else====>"+criteria3Main);
//	//Insert 3711 tb					
//		int result3711=criteria3Repository.insertYearTable3711(collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(),
//				1,1,collaborationsobj.getCriteriaId().getCollegeId(),
//				collaborationsobj.getCriteriaId().getFinancialYear(),collaborationsobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3711 affiliated inserted=======>"+result3711);
//	  
//	  }			
//}	
//			int result371 = criteria3Repository.updateYearTable3711(collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(),
//					collaborationsobj.getCollaborationsLinkages().get(0).getInputclt1());
//			System.out.println("result371=============>"+result371);
			return collaborationsRepository.save(collaborationsobj);

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

	

	public List<CollaborationLinkagesMain> getAllCollaborationData() {
		try {
			List<CollaborationLinkagesMain> criteria1 = new ArrayList<CollaborationLinkagesMain>();

			collaborationsRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
