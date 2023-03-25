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
import com.adiverse.erp.model.ProfessionalDevelopmenMain;
import com.adiverse.erp.model.ProfessionalDevelopmentProgrammesFileUpload;
import com.adiverse.erp.repository.Criteria6Repository;
import com.adiverse.erp.repository.ProfessionaldevelopmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class ProfessionaldevelopmentService {

	private final Logger logger = LoggerFactory.getLogger(ProfessionaldevelopmentService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private ProfessionaldevelopmentRepository professionaldevelopmentRepository;
	
	@Autowired
	private Criteria6Repository criteria6Repository;

	public ProfessionalDevelopmenMain professionalInfo(ProfessionalDevelopmenMain professionalInfo, MultipartFile[] professionalFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(professionalInfo));
			List<ProfessionalDevelopmentProgrammesFileUpload> file1 = new ArrayList<>();
if(professionalFiles != null) {
			for (int i = 0; i < professionalFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = professionalFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(professionalFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				ProfessionalDevelopmentProgrammesFileUpload fileUpload1 = new ProfessionalDevelopmentProgrammesFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+professionalInfo.getCriteriaId().getFinancialYear()));
				fileUpload1.setProfessionalDevelopmentProgmFileName(filename);
				fileUpload1.setProfessionalDevelopmentProgmFilePath(filepath);
				fileUpload1.setProfessionalDevelopmentProgmFileType(param);
				fileUpload1.setCriteriaId(professionalInfo.getCriteriaId());

				file1.add(fileUpload1);

			}
			professionalInfo.setProfessionalDevelopmentProgrammesFileUpload(file1);
}
//// 6331 U
//	if("university".equalsIgnoreCase(professionalInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(professionalInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(professionalInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(professionalInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
//		if(criteria6.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria6.get().getYearTable6331())) {
//				System.out.println("6331 table is empty.....");
//	//Insert 6331 tb					
//				int result6331=criteria6Repository.insertYearTable6331(professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getInputpdt1(),
//						1,1,professionalInfo.getCriteriaId().getCollegeId(),
//						professionalInfo.getCriteriaId().getFinancialYear(),professionalInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result6331 inserted=======>"+result6331);
//			
//			}else {
//	//update 6331 tb		
//				System.out.println("yr 6331 is not  empty.....");
//					String value6331= criteria6.get().getYearTable6331().get(0).getInput6331v();
//					System.out.println("existing value6331 is============>"+value6331);
//					BigDecimal bd = new BigDecimal(value6331);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getUniqueKey1());
//					int update6331=criteria6Repository.updateYearTable6331(finalValue,
//							professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getUniqueKey1());
//					System.out.println("update6331 u=======>"+update6331);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr6 main table else......");
//		int criteria6Main=criteria6Repository.insertCriteria6FieldInfoMain(professionalInfo.getCriteriaId().getCollegeId(),
//				professionalInfo.getCriteriaId().getFinancialYear(),professionalInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria6Main else====>"+criteria6Main);
//		//Insert 6331 tb					
//		int result6331=criteria6Repository.insertYearTable6331(professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getInputpdt1(),
//				1,1,professionalInfo.getCriteriaId().getCollegeId(),
//				professionalInfo.getCriteriaId().getFinancialYear(),professionalInfo.getCriteriaId().getTypeofInstitution());
//	System.out.println("result6331 inserted=======>"+result6331);
//	  
//	  }	
//	
//}
//// 6331 Au
//	else if("autonomous".equalsIgnoreCase(professionalInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(professionalInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(professionalInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(professionalInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
//		if(criteria6.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria6.get().getYearTable6331())) {
//				System.out.println("6331 table is empty.....");
//	//Insert 6331 tb					
//				int result6331=criteria6Repository.insertYearTable6331(professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getInputpdt1(),
//						1,1,professionalInfo.getCriteriaId().getCollegeId(),
//						professionalInfo.getCriteriaId().getFinancialYear(),professionalInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result6331 inserted=======>"+result6331);
//			
//			}else {
//	//update 6331 tb		
//				System.out.println("yr 6331 is not  empty.....");
//					String value6331= criteria6.get().getYearTable6331().get(0).getInput6331v();
//					System.out.println("existing value6331 is============>"+value6331);
//					BigDecimal bd = new BigDecimal(value6331);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getUniqueKey1());
//					int update6331=criteria6Repository.updateYearTable6331(finalValue,
//							professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getUniqueKey1());
//					System.out.println("update6331 u=======>"+update6331);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr6 main table else......");
//		int criteria6Main=criteria6Repository.insertCriteria6FieldInfoMain(professionalInfo.getCriteriaId().getCollegeId(),
//				professionalInfo.getCriteriaId().getFinancialYear(),professionalInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria6Main else====>"+criteria6Main);
//		//Insert 6331 tb					
//		int result6331=criteria6Repository.insertYearTable6331(professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getInputpdt1(),
//				1,1,professionalInfo.getCriteriaId().getCollegeId(),
//				professionalInfo.getCriteriaId().getFinancialYear(),professionalInfo.getCriteriaId().getTypeofInstitution());
//	System.out.println("result6331 inserted=======>"+result6331);
//	  
//	  }	
//	
//}
//			int result = criteria6Repository.updateYearTable6331(professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getInputpdt1(),
//					professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getInputpdt3());
//			System.out.println("result633=============>"+result);
			return professionaldevelopmentRepository.save(professionalInfo);

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

	

	public List<ProfessionalDevelopmenMain> getAllProfessionalData() {
		try {
			List<ProfessionalDevelopmenMain> criteria1 = new ArrayList<ProfessionalDevelopmenMain>();

			professionaldevelopmentRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
