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
import com.adiverse.erp.model.FullTimeTeachersPhdFileUpload;
import com.adiverse.erp.model.FullTimeTeachersPhdMain;
import com.adiverse.erp.repository.Criteria2Repository;
import com.adiverse.erp.repository.FullTimeTeacherPhdRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class FullTimeTeachPhdService {

	private final Logger logger = LoggerFactory.getLogger(FullTimeTeachPhdService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private FullTimeTeacherPhdRepository fullTimeTeacherPhdRepository;
	
	@Autowired
	private Criteria2Repository criteria2Repository;


	public FullTimeTeachersPhdMain ftTeachPhdInfo(FullTimeTeachersPhdMain ftTeachPhd, MultipartFile[] ftTeachPhdFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(ftTeachPhd));
			List<FullTimeTeachersPhdFileUpload> file1 = new ArrayList<>();
if(ftTeachPhdFiles != null) {
			for (int i = 0; i < ftTeachPhdFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = ftTeachPhdFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(ftTeachPhdFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				FullTimeTeachersPhdFileUpload fileUpload1 = new FullTimeTeachersPhdFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+ftTeachPhd.getCriteriaId().getFinancialYear()));
				fileUpload1.setFtTeachPhdFileName(filename);
				fileUpload1.setFtTeachPhdFilePath(filepath);
				fileUpload1.setFtTeachPhdFileType(param);
				fileUpload1.setCriteriaId(ftTeachPhd.getCriteriaId());

				file1.add(fileUpload1);

			}
			ftTeachPhd.setFullTimeTeachersPhdFileUpload(file1);
}
//2421 & 2431 U
//	if("university".equalsIgnoreCase(ftTeachPhd.getCriteriaId().getTypeofInstitution())) {
//			
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(ftTeachPhd.getCriteriaId().getCollegeId());
//			key.setFinancialYear(ftTeachPhd.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(ftTeachPhd.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//			if(criteria2.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria2.get().getYearTable2421())) {
//					System.out.println(" yr 2421 is empty.....");
//		//Insert 2421 tb area	
//				int result242=criteria2Repository.insertYearTable2421(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(),
//						1,1,ftTeachPhd.getCriteriaId().getCollegeId(),
//						ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//				System.out.println("result242 inserted=======>"+result242);
//	// insert 2431 tx
//				int result2431=criteria2Repository.insertCriteria243Qn(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht7(),
//						1,1,ftTeachPhd.getCriteriaId().getCollegeId(),
//						ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//				System.out.println("result2431 inserted=======>"+result2431);
//				}else {
//		//update 2421 tx	area		
//					System.out.println("yr 2421 is not  empty.....");
//						String value2421 = criteria2.get().getYearTable2421().get(0).getInput2421v();
//						System.out.println("existing value is============>"+value2421);
//						BigDecimal bd = new BigDecimal(value2421);
//						int finalValue = bd.intValue() + 1;
//						System.out.println("what is the final value ==>"+finalValue);
//						System.out.println("unique key ==>"+ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
//						int update2421=criteria2Repository.updateYearTable2421(finalValue,ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
//						System.out.println("update2421 u=======>"+update2421);
//	//update 2431 tx 
//		           System.out.println("yr 2431 is not  empty.....");
//						String value2431t1 = criteria2.get().getCriteria24Qn().get(0).getInput2431t1();
//						String value2431t2 = criteria2.get().getCriteria24Qn().get(0).getInput2431t2();
//						System.out.println("existing value2431t1 is============>"+value2431t1+"    value2431t2=====>"+value2431t2);
//						BigDecimal bd1 = new BigDecimal(value2431t1);
//						BigDecimal bd2 = new BigDecimal(value2431t2);
//					    BigDecimal finalValue1=bd1.add(new BigDecimal(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht7()));
//					    int finalValue2=bd2.intValue()+1;
//						System.out.println("what is the final value ==>"+finalValue1);
//						System.out.println("unique key ==>"+ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
//						int update2431=criteria2Repository.updateCriteria243Qn(finalValue1,finalValue2,ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
//						System.out.println("update2431 u=======>"+update2431);				
//	
//					}
//		  }else {
//					
//			System.out.println("inserting into cr2 main table else......");
//			int criteria2Main=criteria2Repository.insertCriteria2Main(ftTeachPhd.getCriteriaId().getCollegeId(),
//					ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//			System.out.println("criteria2Main else====>"+criteria2Main);
//	//insert 2421 tb area			
//			int result242=criteria2Repository.insertYearTable2421(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(),
//					1,1,ftTeachPhd.getCriteriaId().getCollegeId(),
//					ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//			System.out.println("result242 inserted=======>"+result242);
//	//insert 2431 tx
//			int result2431=criteria2Repository.insertCriteria243Qn(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht7(),
//					1,1,ftTeachPhd.getCriteriaId().getCollegeId(),
//					ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//			System.out.println("result2431 inserted=======>"+result2431);
//		
//		  }			
//	}
// //2421 & 2431 Au
//	else if("autonomous".equalsIgnoreCase(ftTeachPhd.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(ftTeachPhd.getCriteriaId().getCollegeId());
//		key.setFinancialYear(ftTeachPhd.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(ftTeachPhd.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//		if(criteria2.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria2.get().getYearTable2421())) {
//				System.out.println(" yr 2421 is empty.....");
//	//Insert 2421 tb area	
//			int result242=criteria2Repository.insertYearTable2421(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(),
//					1,1,ftTeachPhd.getCriteriaId().getCollegeId(),
//					ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//			System.out.println("result242 inserted=======>"+result242);
//// insert 2431 tx
//			int result2431=criteria2Repository.insertCriteria243Qn(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht7(),
//					1,1,ftTeachPhd.getCriteriaId().getCollegeId(),
//					ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//			System.out.println("result2431 inserted=======>"+result2431);
//			}else {
//	//update 2421 tx	area		
//				System.out.println("yr 2421 is not  empty.....");
//					String value2421 = criteria2.get().getYearTable2421().get(0).getInput2421v();
//					System.out.println("existing value is============>"+value2421);
//					BigDecimal bd = new BigDecimal(value2421);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
//					int update2421=criteria2Repository.updateYearTable2421(finalValue,ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
//					System.out.println("update2421 u=======>"+update2421);
////update 2431 tx 
//	           System.out.println("yr 2431 is not  empty.....");
//					String value2431t1 = criteria2.get().getCriteria24Qn().get(0).getInput2431t1();
//					String value2431t2 = criteria2.get().getCriteria24Qn().get(0).getInput2431t2();
//					System.out.println("existing value2431t1 is============>"+value2431t1+"    value2431t2=====>"+value2431t2);
//					BigDecimal bd1 = new BigDecimal(value2431t1);
//					BigDecimal bd2 = new BigDecimal(value2431t2);
//				    BigDecimal finalValue1=bd1.add(new BigDecimal(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht5()));
//				    int finalValue2=bd2.intValue()+1;
//					System.out.println("what is the final value ==>"+finalValue1);
//					System.out.println("unique key ==>"+ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
//					int update2431=criteria2Repository.updateCriteria243Qn(finalValue1,finalValue2,ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
//					System.out.println("update2431 u=======>"+update2431);				
//
//				}
//	  }else {
//				
//		System.out.println("inserting into cr2 main table else......");
//		int criteria2Main=criteria2Repository.insertCriteria2Main(ftTeachPhd.getCriteriaId().getCollegeId(),
//				ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria2Main else====>"+criteria2Main);
////insert 2421 tb area			
//		int result242=criteria2Repository.insertYearTable2421(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(),
//				1,1,ftTeachPhd.getCriteriaId().getCollegeId(),
//				ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//		System.out.println("result242 inserted=======>"+result242);
////insert 2431 tx
//		int result2431=criteria2Repository.insertCriteria243Qn(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht7(),
//				1,1,ftTeachPhd.getCriteriaId().getCollegeId(),
//				ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//		System.out.println("result2431 inserted=======>"+result2431);
//	
//	  }			
//}
//// 2421 Af
//	else if("affiliated".equalsIgnoreCase(ftTeachPhd.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(ftTeachPhd.getCriteriaId().getCollegeId());
//		key.setFinancialYear(ftTeachPhd.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(ftTeachPhd.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
//		if(criteria2.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria2.get().getYearTable2421())) {
//				System.out.println(" yr 2421 is empty affiliated.....");
//	//Insert 2421 tx	area	
//			int result242=criteria2Repository.insertYearTable2421(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(),
//					1,1,ftTeachPhd.getCriteriaId().getCollegeId(),
//					ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//			System.out.println("result2421 affiliated inserted=======>"+result242);
//			}else {
//	//update 2421 tx	area		
//				System.out.println("yr 2421 is not  empty.....");
//				String value2421 = criteria2.get().getYearTable2421().get(0).getInput2421v();
//				System.out.println("existing value is============>"+value2421);
//				BigDecimal bd = new BigDecimal(value2421);
//				int finalValue = bd.intValue() + 1;
//				System.out.println("what is the final value ==>"+finalValue);
//				System.out.println("unique key ==>"+ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
//				int update2421=criteria2Repository.updateYearTable2421(finalValue,ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
//				System.out.println("update2421 affiliated u=======>"+update2421);
//
//				}
//	  }else {
//				
//		System.out.println("inserting into cr2 main table else......");
//		int criteria2Main=criteria2Repository.insertCriteria2Main(ftTeachPhd.getCriteriaId().getCollegeId(),
//				ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria2Main affiliated else====>"+criteria2Main);
////insert 2421 tx area			
//		int result242=criteria2Repository.insertYearTable2421(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(),
//				1,1,ftTeachPhd.getCriteriaId().getCollegeId(),
//				ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//		System.out.println("result2421 affiliated inserted=======>"+result242);
//	
//	  }			
//}
//			System.out.println("key is ==>"+mapper.writeValueAsString(ftTeachPhd.getCriteriaId()));
//			int result = criteria2Repository.updateCriteria2_FieldInfoQn1(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht5(),
//					ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht1(),ftTeachPhd.getCriteriaId().getCollegeId(),
//					ftTeachPhd.getCriteriaId().getFinancialYear(),ftTeachPhd.getCriteriaId().getTypeofInstitution());
//			System.out.println("result=======>"+result);
			return fullTimeTeacherPhdRepository.save(ftTeachPhd);

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

	

	public List<FullTimeTeachersPhdMain> getAllFtTeachPhdData() {
		try {
			List<FullTimeTeachersPhdMain> criteria1 = new ArrayList<FullTimeTeachersPhdMain>();

			fullTimeTeacherPhdRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
