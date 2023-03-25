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
import com.adiverse.erp.model.FellowshipFileUpload;
import com.adiverse.erp.model.FellowshipMain;
import com.adiverse.erp.model.FinancialSupportToTeachersFileUpload;
import com.adiverse.erp.model.FinancialSupportToTeachersMain;
import com.adiverse.erp.model.FullTimeTeacherSanctionMain;
import com.adiverse.erp.model.FullTimeTeacherSanctionedPostFileUpload;
import com.adiverse.erp.model.FullTimeTeachersPhdFileUpload;
import com.adiverse.erp.model.FullTimeTeachersPhdMain;
import com.adiverse.erp.model.OnlineorF2FFDPFileUpload;
import com.adiverse.erp.model.OnlineorF2FFDPMain;
import com.adiverse.erp.model.PassPercentStudMain;
import com.adiverse.erp.model.PassPercentofStudentsFileUpload;
import com.adiverse.erp.model.ResearchGuideFileUpload;
import com.adiverse.erp.model.ResearchGuidesMain;
import com.adiverse.erp.model.SeedMoneyFileUpload;
import com.adiverse.erp.model.SeedMoneyMain;
import com.adiverse.erp.model.StudentSatisfactionMain;
import com.adiverse.erp.model.StudentSatisfactorySurveyFileUpload;
import com.adiverse.erp.repository.Criteria2Repository;
import com.adiverse.erp.repository.FellowshipRepository;
import com.adiverse.erp.repository.FinanceSupportTeachRepository;
import com.adiverse.erp.repository.FullTimeTeacherPhdRepository;
import com.adiverse.erp.repository.FullTimeTeacherSacnctionRepository;
import com.adiverse.erp.repository.OnlineF2FFDPRepository;
import com.adiverse.erp.repository.PassPercentStudRepository;
import com.adiverse.erp.repository.ResearchGuidesRepository;
import com.adiverse.erp.repository.SeedMoneyRepository;
import com.adiverse.erp.repository.StudentSatisfactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class PassPercentStudService {

	private final Logger logger = LoggerFactory.getLogger(PassPercentStudService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private PassPercentStudRepository passPercentStudRepository;
	
	@Autowired
	private Criteria2Repository criteria2Repository;

	public PassPercentStudMain passPercentInfo(PassPercentStudMain passPercentobj, MultipartFile[] passPercentFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(passPercentobj));
			List<PassPercentofStudentsFileUpload> file1 = new ArrayList<>();
if(passPercentFiles != null) {
			for (int i = 0; i < passPercentFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = passPercentFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(passPercentFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				PassPercentofStudentsFileUpload fileUpload1 = new PassPercentofStudentsFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+passPercentobj.getCriteriaId().getFinancialYear()));
				fileUpload1.setPassPercentofStudentFileName(filename);
				fileUpload1.setPassPercentofStudentFilePath(filepath);
				fileUpload1.setPassPercentofStudentFileType(param);
				fileUpload1.setCriteriaId(passPercentobj.getCriteriaId());

				file1.add(fileUpload1);

			}
			passPercentobj.setPassPercentofStudentsFileUpload(file1);
}
////2.6.3 U,Au
//	if("university".equalsIgnoreCase(passPercentobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(passPercentobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(passPercentobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(passPercentobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//		if(criteria2.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria2.get().getCriteria26Qn())) {
//				System.out.println(" cr 26Qn is empty.....");
//	//Insert 2631 & 2632
//			int result2631=criteria2Repository.insertCriteria26Qn(passPercentobj.getPassPercentofStudents().get(0).getInputpst6(),
//					passPercentobj.getPassPercentofStudents().get(0).getInputpst5(),1,passPercentobj.getCriteriaId().getCollegeId(),
//					passPercentobj.getCriteriaId().getFinancialYear(),passPercentobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result2631  2632 inserted=======>"+result2631);
//			}else {
//	//update 2631 & 2632		
//				System.out.println("Cr26 Qn is not  empty.....");
//					String value2631 = criteria2.get().getCriteria26Qn().get(0).getInput2631t1();
//					String value2632 = criteria2.get().getCriteria26Qn().get(0).getInput2632t1();
//					System.out.println("existing value is============>"+value2631+"  value2632=====>"+value2632);
//					BigDecimal bd1 = new BigDecimal(value2631);
//					BigDecimal bd2 = new BigDecimal(value2632);
//					BigDecimal finalValue1 = bd1.add(new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst6()));
//					BigDecimal finalValue2 = bd2.add(new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst5()));
//					System.out.println("what is the final value1 ==>"+finalValue1+"   finalValue2=====>"+finalValue2);
//					System.out.println("unique key ==>"+passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
//					int update2631=criteria2Repository.updateCriteria26Qn(finalValue1,finalValue2,passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
//					System.out.println("update2631 u=======>"+update2631);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr2 main table else......");
//		int criteria2Main=criteria2Repository.insertCriteria2Main(passPercentobj.getCriteriaId().getCollegeId(),
//				passPercentobj.getCriteriaId().getFinancialYear(),passPercentobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria2Main else====>"+criteria2Main);
////insert 2421 tx area			
//		int result2631=criteria2Repository.insertCriteria26Qn(passPercentobj.getPassPercentofStudents().get(0).getInputpst6(),
//				passPercentobj.getPassPercentofStudents().get(0).getInputpst5(),1,passPercentobj.getCriteriaId().getCollegeId(),
//				passPercentobj.getCriteriaId().getFinancialYear(),passPercentobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("result2631 2632 inserted=======>"+result2631);
//
//	  
//	  }			
//}	
//// 2.6.3 Au
//	else if("autonomous".equalsIgnoreCase(passPercentobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(passPercentobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(passPercentobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(passPercentobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//		if(criteria2.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria2.get().getCriteria26Qn())) {
//				System.out.println(" cr 26Qn is empty.....");
//	//Insert 2631 & 2632
//			int result2631=criteria2Repository.insertCriteria26Qn(passPercentobj.getPassPercentofStudents().get(0).getInputpst6(),
//					passPercentobj.getPassPercentofStudents().get(0).getInputpst5(),1,passPercentobj.getCriteriaId().getCollegeId(),
//					passPercentobj.getCriteriaId().getFinancialYear(),passPercentobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result2631  2632 inserted=======>"+result2631);
//			}else {
//	//update 2631 & 2632		
//				System.out.println("Cr26 Qn is not  empty.....");
//					String value2631 = criteria2.get().getCriteria26Qn().get(0).getInput2631t1();
//					String value2632 = criteria2.get().getCriteria26Qn().get(0).getInput2632t1();
//					System.out.println("existing value is============>"+value2631+"  value2632=====>"+value2632);
//					BigDecimal bd1 = new BigDecimal(value2631);
//					BigDecimal bd2 = new BigDecimal(value2632);
//					BigDecimal finalValue1 = bd1.add(new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst6()));
//					BigDecimal finalValue2 = bd2.add(new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst5()));
//					System.out.println("what is the final value1 ==>"+finalValue1+"   finalValue2=====>"+finalValue2);
//					System.out.println("unique key ==>"+passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
//					int update2631=criteria2Repository.updateCriteria26Qn(finalValue1,finalValue2,passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
//					System.out.println("update2631 u=======>"+update2631);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr2 main table else......");
//		int criteria2Main=criteria2Repository.insertCriteria2Main(passPercentobj.getCriteriaId().getCollegeId(),
//				passPercentobj.getCriteriaId().getFinancialYear(),passPercentobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria2Main else====>"+criteria2Main);
////insert 2421 tx area			
//		int result2631=criteria2Repository.insertCriteria26Qn(passPercentobj.getPassPercentofStudents().get(0).getInputpst6(),
//				passPercentobj.getPassPercentofStudents().get(0).getInputpst5(),1,passPercentobj.getCriteriaId().getCollegeId(),
//				passPercentobj.getCriteriaId().getFinancialYear(),passPercentobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("result2631 2632 inserted=======>"+result2631);
//
//	  
//	  }			
//}	
////2.6.2.1 Af 
//	else if("affiliated".equalsIgnoreCase(passPercentobj.getCriteriaId().getTypeofInstitution())){
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(passPercentobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(passPercentobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(passPercentobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//		if(criteria2.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria2.get().getCriteria26Qn())) {
//				System.out.println(" cr 26Qn is empty.....");
//	//Insert 2621 & 2622
//			int result2621=criteria2Repository.insertCriteria26QnAf(passPercentobj.getPassPercentofStudents().get(0).getInputpst6(),
//					passPercentobj.getPassPercentofStudents().get(0).getInputpst5(),1,passPercentobj.getCriteriaId().getCollegeId(),
//					passPercentobj.getCriteriaId().getFinancialYear(),passPercentobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result2621  2622 affiliated inserted=======>"+result2621);
//			}else {
//	//update 2631 & 2632		
//				System.out.println("Cr26 Qn is not  empty.....");
//					String value2621Af = criteria2.get().getCriteria26Qn().get(0).getInput2621t1();
//					String value2622Af = criteria2.get().getCriteria26Qn().get(0).getInput2622t2();
//					System.out.println("existing value2621Af is============>"+value2621Af+"  value2622Af=====>"+value2622Af);
//					BigDecimal bd3 = new BigDecimal(value2621Af);
//					BigDecimal bd4 = new BigDecimal(value2622Af);
//					BigDecimal finalValue3 = bd3.add(new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst6()));
//					BigDecimal finalValue4 = bd4.add(new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst5()));
//					System.out.println("what is the final value1 ==>"+finalValue3+"   finalValue2=====>"+finalValue4);
//					System.out.println("unique key ==>"+passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
//					int update2621Af=criteria2Repository.updateCriteria26QnAf(finalValue3,finalValue4,passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
//					System.out.println("update2621Af affiliated u=======>"+update2621Af);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr2 main table else......");
//		int criteria2Main=criteria2Repository.insertCriteria2Main(passPercentobj.getCriteriaId().getCollegeId(),
//				passPercentobj.getCriteriaId().getFinancialYear(),passPercentobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria2Main affiliated else====>"+criteria2Main);
////insert 2421 tx area			
//		int result2621=criteria2Repository.insertCriteria26QnAf(passPercentobj.getPassPercentofStudents().get(0).getInputpst6(),
//				passPercentobj.getPassPercentofStudents().get(0).getInputpst5(),1,passPercentobj.getCriteriaId().getCollegeId(),
//				passPercentobj.getCriteriaId().getFinancialYear(),passPercentobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("result2621  2622 affiliated inserted=======>"+result2621);
//
//	  
//	  }			
//}	
	
//			int result263 = criteria2Repository.updateCriteria2_FieldInfoQn3(passPercentobj.getPassPercentofStudents().get(0).getInputpst6(),
//					passPercentobj.getPassPercentofStudents().get(0).getInputpst5());
//			System.out.println("result263=============>"+result263);
			return passPercentStudRepository.save(passPercentobj);

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

	

	public List<PassPercentStudMain> getAllPassPercentData() {
		try {
			List<PassPercentStudMain> criteria1 = new ArrayList<PassPercentStudMain>();

			passPercentStudRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
