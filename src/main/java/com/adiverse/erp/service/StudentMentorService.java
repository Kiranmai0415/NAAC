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
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.StudentMentorMain;
import com.adiverse.erp.model.StudentMentorRatioFileUppload;
import com.adiverse.erp.repository.Criteria2Repository;
import com.adiverse.erp.repository.StudentMentorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class StudentMentorService {

	
	@Value("${upload.files.path}")
	private String uploadFilePath;
	
	@Autowired
	private  StudentMentorRepository studentMentorRepository;
	
	@Autowired
	private Criteria2Repository criteria2Repository;
	
	private final Logger logger = LoggerFactory.getLogger(StudentMentorService.class);

	
	public StudentMentorMain studentMentor(StudentMentorMain studentMentorobj, MultipartFile[] studentMentoruploadfile) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(studentMentorobj));
			//System.out.println("Files======>"+mapper.writeValueAsString(studentMentoruploadfile));
			
			//logger.info("employee info===" + studentMentorobj);
			List<StudentMentorRatioFileUppload> studentFile = new ArrayList<>();
if(studentMentoruploadfile != null) {
			for (int i = 0; i < studentMentoruploadfile.length; i++) {
				// Get the filename and build the local file path
				String filename = studentMentoruploadfile[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(studentMentoruploadfile[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				StudentMentorRatioFileUppload studentFileUpload = new StudentMentorRatioFileUppload();
				studentFileUpload.setUniqueKey1(param.concat("-"+studentMentorobj.getCriteriaId().getFinancialYear()));
				studentFileUpload.setStudentMentorFileName(filename);
				studentFileUpload.setStudentMentorFilePath(filepath);
				studentFileUpload.setStudentMentorFilePath(studentMentoruploadfile[i].getContentType());
				studentFileUpload.setCriteriaId(studentMentorobj.getCriteriaId());

				studentFile.add(studentFileUpload);

			}
			studentMentorobj.setStudentMentorRatioFileUppload(studentFile);
}
// 2.3.3 U
// if("university".equalsIgnoreCase(studentMentorobj.getCriteriaId().getTypeofInstitution())) {
//	
//	CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//	key.setCollegeId(studentMentorobj.getCriteriaId().getCollegeId());
//	key.setFinancialYear(studentMentorobj.getCriteriaId().getFinancialYear());
//	key.setTypeofInstitution(studentMentorobj.getCriteriaId().getTypeofInstitution());
//	Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//	if(criteria2.isPresent()) {
//		if(CollectionUtils.isEmpty(criteria2.get().getCriteria23Qn())) {
//			System.out.println(" Cr23 Qn is empty.....");
////Insert 233 tx		
//		int result233=criteria2Repository.insertCriteria23Qn(studentMentorobj.getStudentMentorRatio().get(0).getInputsmt5(),
//				studentMentorobj.getStudentMentorRatio().get(0).getInputsmt4(),1,studentMentorobj.getCriteriaId().getCollegeId(),
//				studentMentorobj.getCriteriaId().getFinancialYear(),studentMentorobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("result233 inserted=======>"+result233);
//		}else {
////update 233 tx			
//			System.out.println("Cr23 Qn is not  empty.....");
//				String value233t1 = criteria2.get().getCriteria23Qn().get(0).getInput2331t1();
//				String value233t2=criteria2.get().getCriteria23Qn().get(0).getInput2331t2();				
//				System.out.println("existing value233t1 is============>"+value233t1+"  value233t2====> "+value233t2);
//				BigDecimal bd1 = new BigDecimal(value233t1);
//				BigDecimal bd2 = new BigDecimal(value233t2);
//				BigDecimal finalValue1 = bd1.add(new BigDecimal(studentMentorobj.getStudentMentorRatio().get(0).getInputsmt5()));
//				BigDecimal finalValue2 = bd2.add(new BigDecimal(studentMentorobj.getStudentMentorRatio().get(0).getInputsmt4()));
//				System.out.println("what is the final value ==>"+finalValue1+"  finalValue2=====> "+finalValue2);
//				System.out.println("unique key ==>"+studentMentorobj.getStudentMentorRatio().get(0).getUniqueKey1());
//				int update233=criteria2Repository.updateCriteria23Qn(finalValue1,finalValue2,studentMentorobj.getStudentMentorRatio().get(0).getUniqueKey1());
//				System.out.println("update233 u=======>"+update233);
//
//			}
//  }else {
//			
//	System.out.println("inserting into cr2 main table else......");
//	int criteria2Main=criteria2Repository.insertCriteria2Main(studentMentorobj.getCriteriaId().getCollegeId(),
//			studentMentorobj.getCriteriaId().getFinancialYear(),studentMentorobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("criteria2Main else====>"+criteria2Main);
////Insert 233 tx		
//			int result233=criteria2Repository.insertCriteria23Qn(studentMentorobj.getStudentMentorRatio().get(0).getInputsmt5(),
//					studentMentorobj.getStudentMentorRatio().get(0).getInputsmt4(),1,studentMentorobj.getCriteriaId().getCollegeId(),
//					studentMentorobj.getCriteriaId().getFinancialYear(),studentMentorobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result233 inserted=======>"+result233);
//  }			
//}
// //2.3.3 Au
// else if("autonomous".equalsIgnoreCase(studentMentorobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(studentMentorobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(studentMentorobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(studentMentorobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//		if(criteria2.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria2.get().getCriteria23Qn())) {
//				System.out.println(" Cr23 Qn is empty.....");
//	//Insert 233 tx		
//			int result233=criteria2Repository.insertCriteria23Qn(studentMentorobj.getStudentMentorRatio().get(0).getInputsmt5(),
//					studentMentorobj.getStudentMentorRatio().get(0).getInputsmt4(),1,studentMentorobj.getCriteriaId().getCollegeId(),
//					studentMentorobj.getCriteriaId().getFinancialYear(),studentMentorobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result233 inserted=======>"+result233);
//			}else {
//	//update 233 tx			
//				System.out.println("Cr23 Qn is not  empty.....");
//					String value233t1 = criteria2.get().getCriteria23Qn().get(0).getInput2331t1();
//					String value233t2=criteria2.get().getCriteria23Qn().get(0).getInput2331t2();				
//					System.out.println("existing value233t1 is============>"+value233t1+"  value233t2====> "+value233t2);
//					BigDecimal bd1 = new BigDecimal(value233t1);
//					BigDecimal bd2 = new BigDecimal(value233t2);
//					BigDecimal finalValue1 = bd1.add(new BigDecimal(studentMentorobj.getStudentMentorRatio().get(0).getInputsmt5()));
//					BigDecimal finalValue2 = bd2.add(new BigDecimal(studentMentorobj.getStudentMentorRatio().get(0).getInputsmt4()));
//					System.out.println("what is the final value ==>"+finalValue1+"  finalValue2=====> "+finalValue2);
//					System.out.println("unique key ==>"+studentMentorobj.getStudentMentorRatio().get(0).getUniqueKey1());
//					int update233=criteria2Repository.updateCriteria23Qn(finalValue1,finalValue2,studentMentorobj.getStudentMentorRatio().get(0).getUniqueKey1());
//					System.out.println("update233 u=======>"+update233);
//
//				}
//	  }else {
//				
//		System.out.println("inserting into cr2 main table else......");
//		int criteria2Main=criteria2Repository.insertCriteria2Main(studentMentorobj.getCriteriaId().getCollegeId(),
//				studentMentorobj.getCriteriaId().getFinancialYear(),studentMentorobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria2Main else====>"+criteria2Main);
//	//Insert 233 tx		
//				int result233=criteria2Repository.insertCriteria23Qn(studentMentorobj.getStudentMentorRatio().get(0).getInputsmt5(),
//						studentMentorobj.getStudentMentorRatio().get(0).getInputsmt4(),1,studentMentorobj.getCriteriaId().getCollegeId(),
//						studentMentorobj.getCriteriaId().getFinancialYear(),studentMentorobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result233 inserted=======>"+result233);
//	  }			
//	}
//		if("autonomous".equalsIgnoreCase(studentMentorobj.getCriteriaId().getTypeofInstitution())) {
//	    int result233 = criteria2Repository.updateCriteria2_FieldInfoQn(studentMentorobj.getStudentMentorRatio().get(0).getInputsmt1(),
//	    		studentMentorobj.getStudentMentorRatio().get(0).getInputsmt2());
//		System.out.println("result233au=============>"+result233);
//											
//		}
//		else if ("university".equalsIgnoreCase(studentMentorobj.getCriteriaId().getTypeofInstitution()))	{
//		int result233 = criteria2Repository.updateCriteria2_FieldInfoQn(studentMentorobj.getStudentMentorRatio().get(0).getInputsmt1(),
//				studentMentorobj.getStudentMentorRatio().get(0).getInputsmt2());
//		System.out.println("result233u=============>"+result233);	
//		}			
			
			return studentMentorRepository.save(studentMentorobj);

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

//	public Resource loadFile(String fileName) {
//		logger.info("excelTemplatesPath==>{}",excelTemplatesPath);
//		Path path = Paths.get(excelTemplatesPath + fileName);
//		try {
//			logger.info("path.toUri()=========>{}",path.toUri());
//			Resource resource = new UrlResource(path.toUri());
//
//			if (resource.exists() || resource.isReadable()) {
//				return resource;
//			} else {
//				throw new FileStorageException("Could not download file");
//			}
//		} catch (MalformedURLException e) {
//			throw new FileStorageException("Could not download file");
//		}
//	}

	public List<StudentMentorMain> getAllStudentData() {
		try {
			List<StudentMentorMain> criteria1 = new ArrayList<StudentMentorMain>();

			studentMentorRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}
}
