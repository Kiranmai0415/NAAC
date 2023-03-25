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
import com.adiverse.erp.model.FellowshipFileUpload;
import com.adiverse.erp.model.FellowshipMain;
import com.adiverse.erp.model.FinancialSupportToTeachersFileUpload;
import com.adiverse.erp.model.FinancialSupportToTeachersMain;
import com.adiverse.erp.model.FullTimeTeacherSanctionMain;
import com.adiverse.erp.model.FullTimeTeacherSanctionedPostFileUpload;
import com.adiverse.erp.model.FullTimeTeachersPhdFileUpload;
import com.adiverse.erp.model.FullTimeTeachersPhdMain;
import com.adiverse.erp.model.NumberofWorkshopsSeminorsMain;
import com.adiverse.erp.model.NumberofWorkshopsorSeminarsFileUpload;
import com.adiverse.erp.model.OnlineorF2FFDPFileUpload;
import com.adiverse.erp.model.OnlineorF2FFDPMain;
import com.adiverse.erp.model.ResearchGuideFileUpload;
import com.adiverse.erp.model.ResearchGuidesMain;
import com.adiverse.erp.model.SeedMoneyFileUpload;
import com.adiverse.erp.model.SeedMoneyMain;
import com.adiverse.erp.model.StudentSatisfactionMain;
import com.adiverse.erp.model.StudentSatisfactorySurveyFileUpload;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.FellowshipRepository;
import com.adiverse.erp.repository.FinanceSupportTeachRepository;
import com.adiverse.erp.repository.FullTimeTeacherPhdRepository;
import com.adiverse.erp.repository.FullTimeTeacherSacnctionRepository;
import com.adiverse.erp.repository.NoOfWorkshopsSeminarsRepository;
import com.adiverse.erp.repository.OnlineF2FFDPRepository;
import com.adiverse.erp.repository.ResearchGuidesRepository;
import com.adiverse.erp.repository.SeedMoneyRepository;
import com.adiverse.erp.repository.StudentSatisfactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class NoOfWorkshopsSeminarsService {

	private final Logger logger = LoggerFactory.getLogger(NoOfWorkshopsSeminarsService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private NoOfWorkshopsSeminarsRepository noOfWorkshopsSeminarsRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;


	public NumberofWorkshopsSeminorsMain noofWorkshopsInfo(NumberofWorkshopsSeminorsMain noofWorkshopspobj, MultipartFile[] noofWorkshopsFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(noofWorkshopspobj));
			List<NumberofWorkshopsorSeminarsFileUpload> file1 = new ArrayList<>();
if(noofWorkshopsFiles != null) {
			for (int i = 0; i < noofWorkshopsFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = noofWorkshopsFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(noofWorkshopsFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				NumberofWorkshopsorSeminarsFileUpload fileUpload1 = new NumberofWorkshopsorSeminarsFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+noofWorkshopspobj.getCriteriaId().getFinancialYear()));
				fileUpload1.setNoofWorkshopsSeminorsFileName(filename);
				fileUpload1.setNoofWorkshopsSeminorsFilePath(filepath);
				fileUpload1.setNoofWorkshopsSeminorsFileType(param);
				fileUpload1.setCriteriaId(noofWorkshopspobj.getCriteriaId());

				file1.add(fileUpload1);

			}
			noofWorkshopspobj.setNumberofWorkshopsorSeminarsFileUpload(file1);
}
////3321 U
// if("university".equalsIgnoreCase(noofWorkshopspobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(noofWorkshopspobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(noofWorkshopspobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3321())) {
//				System.out.println("3321 table is empty.....");
//	//Insert 3321 tb					
//				int result3321=criteria3Repository.insertYearTable3321(noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(),
//						1,1,noofWorkshopspobj.getCriteriaId().getCollegeId(),
//						noofWorkshopspobj.getCriteriaId().getFinancialYear(),noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3321 inserted=======>"+result3321);
//			}else {
//	//update 3321 tb		
//				System.out.println("yr 3321 is not  empty.....");
//					String value3321= criteria3.get().getYearTable3321().get(0).getInput3321v();
//					System.out.println("existing value3321 is============>"+value3321);
//					BigDecimal bd = new BigDecimal(value3321);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
//					int update3321=criteria3Repository.updateYearTable3321(finalValue,
//							noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
//					System.out.println("update3321 u=======>"+update3321);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(noofWorkshopspobj.getCriteriaId().getCollegeId(),
//				noofWorkshopspobj.getCriteriaId().getFinancialYear(),noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3321 tb					
//		int result3321=criteria3Repository.insertYearTable3321(noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(),
//				1,1,noofWorkshopspobj.getCriteriaId().getCollegeId(),
//				noofWorkshopspobj.getCriteriaId().getFinancialYear(),noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3321 inserted=======>"+result3321);
//
//	  
//	  }			
//}
// //3321 Au
// else if("autonomous".equalsIgnoreCase(noofWorkshopspobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(noofWorkshopspobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(noofWorkshopspobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3321())) {
//				System.out.println("3321 table is empty.....");
//	//Insert 3321 tb					
//				int result3321=criteria3Repository.insertYearTable3321(noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(),
//						1,1,noofWorkshopspobj.getCriteriaId().getCollegeId(),
//						noofWorkshopspobj.getCriteriaId().getFinancialYear(),noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3321 inserted=======>"+result3321);
//			}else {
//	//update 3321 tb		
//				System.out.println("yr 3321 is not  empty.....");
//					String value3321= criteria3.get().getYearTable3321().get(0).getInput3321v();
//					System.out.println("existing value3321 is============>"+value3321);
//					BigDecimal bd = new BigDecimal(value3321);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
//					int update3321=criteria3Repository.updateYearTable3321(finalValue,
//							noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
//					System.out.println("update3321 u=======>"+update3321);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(noofWorkshopspobj.getCriteriaId().getCollegeId(),
//				noofWorkshopspobj.getCriteriaId().getFinancialYear(),noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3321 tb					
//		int result3321=criteria3Repository.insertYearTable3321(noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(),
//				1,1,noofWorkshopspobj.getCriteriaId().getCollegeId(),
//				noofWorkshopspobj.getCriteriaId().getFinancialYear(),noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3321 inserted=======>"+result3321);
//
//	  
//	  }			
//}
// //3221 Af
// else if("affiliated".equalsIgnoreCase(noofWorkshopspobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(noofWorkshopspobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(noofWorkshopspobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3221())) {
//				System.out.println("3221 table affiliated is empty.....");
//	//Insert 3221 tb					
//				int result3221=criteria3Repository.insertYearTable3221(noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(),
//						1,1,noofWorkshopspobj.getCriteriaId().getCollegeId(),
//						noofWorkshopspobj.getCriteriaId().getFinancialYear(),noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3221 affiliated inserted=======>"+result3221);
//			}else {
//	//update 3221 tb		
//				System.out.println("yr 3221 affiliated is not  empty.....");
//					String value3221Af= criteria3.get().getYearTable3221().get(0).getInput3221v();
//					System.out.println("existing value3221Af is============>"+value3221Af);
//					BigDecimal bdAf = new BigDecimal(value3221Af);
//					int finalValueAf = bdAf.intValue() + 1;
//					System.out.println("what is the finalValueAf ==>"+finalValueAf);
//					System.out.println("unique key ==>"+noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
//					int update3221=criteria3Repository.updateYearTable3221(finalValueAf,
//							noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
//					System.out.println("update3221 affiliated u=======>"+update3221);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(noofWorkshopspobj.getCriteriaId().getCollegeId(),
//				noofWorkshopspobj.getCriteriaId().getFinancialYear(),noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main  affiliated else====>"+criteria3Main);
//	//Insert 3221 tb					
//		int result3221=criteria3Repository.insertYearTable3221(noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(),
//				1,1,noofWorkshopspobj.getCriteriaId().getCollegeId(),
//				noofWorkshopspobj.getCriteriaId().getFinancialYear(),noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3221 affiliated inserted=======>"+result3221);
//
//	  
//	  }			
//}
			//int result = criteria3Repository.updateYearTable3321();
			//System.out.println("result=============>"+result);
			return noOfWorkshopsSeminarsRepository.save(noofWorkshopspobj);

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

	

	public List<NumberofWorkshopsSeminorsMain> getAllNoOfWorkshopsData() {
		try {
			List<NumberofWorkshopsSeminorsMain> criteria1 = new ArrayList<NumberofWorkshopsSeminorsMain>();

			noOfWorkshopsSeminarsRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
