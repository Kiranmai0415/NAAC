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
import com.adiverse.erp.model.AttainmentsFileUpload;
import com.adiverse.erp.model.AttainmentsMain;
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.repository.AttainmentsRepository;
import com.adiverse.erp.repository.Criteria2Repository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class AttainmentsService {

	private final Logger logger = LoggerFactory.getLogger(AttainmentsService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private AttainmentsRepository attainmentsRepository;
	
	@Autowired
	private Criteria2Repository criteria2Repository;

	public AttainmentsMain attainmentsInfo(AttainmentsMain attainmentsobj, MultipartFile[] attainmentsFile) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(attainmentsobj));
			List<AttainmentsFileUpload> file1 = new ArrayList<>();
if(attainmentsFile != null) {
			for (int i = 0; i < attainmentsFile.length; i++) {
				// Get the filename and build the local file path
				String filename = attainmentsFile[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(attainmentsFile[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				AttainmentsFileUpload fileUpload1 = new AttainmentsFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+attainmentsobj.getCriteriaId().getFinancialYear()));
				fileUpload1.setAttainmentsFileName(filename);
				fileUpload1.setAttainmentsFilePath(filepath);
				fileUpload1.setAttainmentsFileType(param);
				fileUpload1.setCriteriaId(attainmentsobj.getCriteriaId());

				file1.add(fileUpload1);

			}
			attainmentsobj.setAttainmentsFileUpload(file1);
}
////2.6.2 U
//	if("university".equalsIgnoreCase(attainmentsobj.getCriteriaId().getTypeofInstitution())) {
//			
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(attainmentsobj.getCriteriaId().getCollegeId());
//			key.setFinancialYear(attainmentsobj.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(attainmentsobj.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//			if(criteria2.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria2.get().getCriteria26Ql())) {
//					System.out.println("cr2 Ql is empty.....");
//		//Insert 262 tx area
//				int result262=criteria2Repository.insertCriteria26Ql(attainmentsobj.getAttainments().get(0).getInputat4(),
//						1,attainmentsobj.getCriteriaId().getCollegeId(),
//						attainmentsobj.getCriteriaId().getFinancialYear(),attainmentsobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result262 inserted=======>"+result262);
//				}else {
//		//update 262 tx area		
//					System.out.println("yr 262 is not  empty.....");
//						String value262t1= criteria2.get().getCriteria26Ql().get(0).getResponse262();
//						String value262t2=criteria2.get().getCriteria26Ql().get(0).getInput262t1();
//						System.out.println("existing value262t1 is============>"+value262t1+"   value262t2====>"+value262t2);
//						System.out.println("unique key ==>"+attainmentsobj.getAttainments().get(0).getUniqueKey1());
//						int update262=criteria2Repository.updateCriteria26Ql(attainmentsobj.getAttainments().get(0).getInputat4(),
//								attainmentsobj.getAttainments().get(0).getUniqueKey1());
//						System.out.println("update262 u=======>"+update262);			
//					}
//		  }else {
//					
//			System.out.println("inserting into cr2 main table else......");
//			int criteria2Main=criteria2Repository.insertCriteria2Main(attainmentsobj.getCriteriaId().getCollegeId(),
//					attainmentsobj.getCriteriaId().getFinancialYear(),attainmentsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria2Main else====>"+criteria2Main);
//	//Insert 262 tx area
//			int result262=criteria2Repository.insertCriteria26Ql(attainmentsobj.getAttainments().get(0).getInputat4(),
//				1,attainmentsobj.getCriteriaId().getCollegeId(),
//					attainmentsobj.getCriteriaId().getFinancialYear(),attainmentsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result262 inserted=======>"+result262);
//	
//		  
//		  }			
//	}
////2.6.2 Au	
//	else if("autonomous".equalsIgnoreCase(attainmentsobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(attainmentsobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(attainmentsobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(attainmentsobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//		if(criteria2.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria2.get().getCriteria26Ql())) {
//				System.out.println("cr2 Ql is empty.....");
//	//Insert 262 tx area
//			int result262=criteria2Repository.insertCriteria26Ql(attainmentsobj.getAttainments().get(0).getInputat4(),
//					1,attainmentsobj.getCriteriaId().getCollegeId(),
//					attainmentsobj.getCriteriaId().getFinancialYear(),attainmentsobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result262 inserted=======>"+result262);
//			}else {
//	//update 262 tx area		
//				System.out.println("yr 262 is not  empty.....");
//					String value262t1= criteria2.get().getCriteria26Ql().get(0).getResponse262();
//					String value262t2=criteria2.get().getCriteria26Ql().get(0).getInput262t1();
//					System.out.println("existing value262t1 is============>"+value262t1+"   value262t2====>"+value262t2);
//					System.out.println("unique key ==>"+attainmentsobj.getAttainments().get(0).getUniqueKey1());
//					int update262=criteria2Repository.updateCriteria26Ql(attainmentsobj.getAttainments().get(0).getInputat4(),
//							attainmentsobj.getAttainments().get(0).getUniqueKey1());
//					System.out.println("update262 u=======>"+update262);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr2 main table else......");
//		int criteria2Main=criteria2Repository.insertCriteria2Main(attainmentsobj.getCriteriaId().getCollegeId(),
//				attainmentsobj.getCriteriaId().getFinancialYear(),attainmentsobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria2Main else====>"+criteria2Main);
////Insert 262 tx area
//		int result262=criteria2Repository.insertCriteria26Ql(attainmentsobj.getAttainments().get(0).getInputat4(),
//				1,attainmentsobj.getCriteriaId().getCollegeId(),
//				attainmentsobj.getCriteriaId().getFinancialYear(),attainmentsobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("result262 inserted=======>"+result262);
//
//	  
//	  }			
//} 
//			int result262 = criteria2Repository.updateCriteria2_FieldInfoQl2(attainmentsobj.getAttainments().get(0).getInputat1());
//			System.out.println("result262=============>"+result262);
			return attainmentsRepository.save(attainmentsobj);

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

	

	public List<AttainmentsMain> getAllAttainmentData() {
		try {
			List<AttainmentsMain> criteria1 = new ArrayList<AttainmentsMain>();

			attainmentsRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
