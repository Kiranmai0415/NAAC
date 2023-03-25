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
import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.ValueAddedCoursesFileUpload;
import com.adiverse.erp.model.ValueAddedCoursesMain;
import com.adiverse.erp.repository.Criteria1Repository;
import com.adiverse.erp.repository.ValueAddCourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class ValueAddCourseService {

	private final Logger logger = LoggerFactory.getLogger(ValueAddCourseService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private ValueAddCourseRepository valueAddCourseRepository;
	
	@Autowired
	private Criteria1Repository criteria1Repository;

	public ValueAddedCoursesMain valueAddInfo(ValueAddedCoursesMain valueAddobj, MultipartFile[] valueAddFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(valueAddobj));
			List<ValueAddedCoursesFileUpload> file1 = new ArrayList<>();
if(valueAddFiles != null) {
			for (int i = 0; i < valueAddFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = valueAddFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(valueAddFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				ValueAddedCoursesFileUpload fileUpload1 = new ValueAddedCoursesFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+valueAddobj.getCriteriaId().getFinancialYear()));
				fileUpload1.setValueAddedCoursesFileName(filename);
				fileUpload1.setValueAddedCoursesFilePath(filepath);
				fileUpload1.setValueAddedCoursesFileType(param);
				fileUpload1.setCriteriaId(valueAddobj.getCriteriaId());

				file1.add(fileUpload1);

			}
			valueAddobj.setValueAddedCoursesFileUpload(file1);
}
//1321 & 1331  U table 	
			
//	if("university".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution())) {
//				
//			CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//			key.setCollegeId(valueAddobj.getCriteriaId().getCollegeId());
//			key.setFinancialYear(valueAddobj.getCriteriaId().getFinancialYear());
//			key.setTypeofInstitution(valueAddobj.getCriteriaId().getTypeofInstitution());
//			Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
//			if(criteria1.isPresent()) {
//				if(CollectionUtils.isEmpty(criteria1.get().getYearTable1321())) {
//					System.out.println("year table 1321 is empty.....");
//		//Insert 1321			
//					int result1321=criteria1Repository.insertYearTable1321(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//							1,1,valueAddobj.getCriteriaId().getCollegeId(),
//							valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//					System.out.println("result1321 inserted=======>"+result1321);
//		//insert 1331
//					int result1331=criteria1Repository.insertYearTable1331(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//							valueAddobj.getValueAddedCourses().get(0).getInputvat8(),1,valueAddobj.getCriteriaId().getCollegeId(),
//							valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//					System.out.println("result1331 inserted=======>"+result1331);	
//				}else {
//		//update 1321				
//					System.out.println("year table 1321 is not  empty.....");
//						String value1321 = criteria1.get().getYearTable1321().get(0).getInput1321v();
//						System.out.println("existing value is============>"+value1321);
//						BigDecimal bd = new BigDecimal(value1321);
//						int finalValue = bd.intValue() + 1;
//						System.out.println("what is the final value ==>"+finalValue);
//						System.out.println("unique key ==>"+valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//						int update1321u=criteria1Repository.updateYearTable1321Au(finalValue,valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//						System.out.println("update1321 u=======>"+update1321u);
//	 //update 1331
//						System.out.println("year table 1331 is not  empty.....");
//						String value1331 = criteria1.get().getYearTable1331().get(0).getInput1331v();
//						System.out.println("existing value is============>"+value1331);
//						BigDecimal bd1 = new BigDecimal(value1331);
//						BigDecimal finalValue1=bd1.add(new BigDecimal(valueAddobj.getValueAddedCourses().get(0).getInputvat8()));
//						System.out.println("what is the final value ==>"+finalValue1);
//						System.out.println("unique key ==>"+valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//						int update1331=criteria1Repository.updateYearTable1331(finalValue1,valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//						System.out.println("update1331u=======>"+update1331);
//					}
//		  }else {
//					
//					System.out.println("inserting into cr1 main table else......");
//					int criteria1Main=criteria1Repository.insertCriteria1Main(valueAddobj.getCriteriaId().getCollegeId(),
//							valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//					System.out.println("criteria1Main else====>"+criteria1Main);
//		//insert 1321			
//					int result1321=criteria1Repository.insertYearTable1321(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//							1,1,valueAddobj.getCriteriaId().getCollegeId(),
//							valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//					System.out.println("result1321 inserted=======>"+result1321);
//		//insert 1331
//					int result1331=criteria1Repository.insertYearTable1331(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//							valueAddobj.getValueAddedCourses().get(0).getInputvat8(),1,valueAddobj.getCriteriaId().getCollegeId(),
//							valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//					System.out.println("result1331 inserted=======>"+result1331);		
//		  }					
//	}
////1321 & 1331  Au  table
//	
//	else if("autonomous".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution())) {
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(valueAddobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(valueAddobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(valueAddobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
//		if(criteria1.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria1.get().getYearTable1321())) {
//				System.out.println("year table 1321 is empty.....");
//	//Insert 1321			
//				int result1321=criteria1Repository.insertYearTable1321(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//						1,1,valueAddobj.getCriteriaId().getCollegeId(),
//						valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result1321 inserted=======>"+result1321);
//	//insert 1331 
//				int result1331=criteria1Repository.insertYearTable1331(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//						valueAddobj.getValueAddedCourses().get(0).getInputvat8(),1,valueAddobj.getCriteriaId().getCollegeId(),
//						valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result1331 inserted=======>"+result1331);	
//			}else {
//	//update 1321				
//				System.out.println("year table 1321 is not  empty.....");
//				String value1321Au = criteria1.get().getYearTable1321().get(0).getInput1321v();
//				System.out.println("existing value is============>"+value1321Au);
//				BigDecimal bdAu = new BigDecimal(value1321Au);
//				int finalValueAu = bdAu.intValue() + 1;
//				System.out.println("what is the final value ==>"+finalValueAu);
//				System.out.println("unique key ==>"+valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//				int update1321Au=criteria1Repository.updateYearTable1321Au(finalValueAu,valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//				System.out.println("update1321 u=======>"+update1321Au);
////update 1331
//				System.out.println("year table 1331 is not  empty.....");
//				String value1331Au = criteria1.get().getYearTable1331().get(0).getInput1331v();
//				System.out.println("existing value is============>"+value1331Au);
//				BigDecimal bdAu1 = new BigDecimal(value1331Au);
//				BigDecimal finalValueAu1=bdAu1.add(new BigDecimal(valueAddobj.getValueAddedCourses().get(0).getInputvat8()));
//				System.out.println("what is the final value ==>"+finalValueAu1);
//				System.out.println("unique key ==>"+valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//				int update1331Au=criteria1Repository.updateYearTable1331(finalValueAu1,valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//				System.out.println("update1331u=======>"+update1331Au);
//				}
//	  }else {
//				
//				System.out.println("inserting into cr1 main table else......");
//				int criteria1Main=criteria1Repository.insertCriteria1Main(valueAddobj.getCriteriaId().getCollegeId(),
//						valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("criteria1Main else====>"+criteria1Main);
//	//1321 insert			
//				System.out.println("year table 1321 insertion else .......");
//				int result1321=criteria1Repository.insertYearTable1321(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//						1,valueAddobj.getCriteriaId().hashCode(),valueAddobj.getCriteriaId().getCollegeId(),
//						valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result1321 else=======>"+result1321);
//	//1331 insert
//				int result1331=criteria1Repository.insertYearTable1331(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//						valueAddobj.getValueAddedCourses().get(0).getInputvat8(),1,valueAddobj.getCriteriaId().getCollegeId(),
//						valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result1331 inserted=======>"+result1331);	
//	  }	
//}
//// 1211 & 1221 Af 	
//	
//	else if("affiliated".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution())) {
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(valueAddobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(valueAddobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(valueAddobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
//		if(criteria1.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria1.get().getCriteria12Qn())) {
//				System.out.println(" Cr12 Qn is empty affiliated.....");
//	//Insert 1211t1			
//				int result1211=criteria1Repository.insertCriteria12Qn(1,
//						1,valueAddobj.getCriteriaId().getCollegeId(),
//						valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//					System.out.println("result1211af affiliated inserted=======>"+result1211);
//	//insert 1221 table
//					System.out.println("year table 1221 affiliated insertion .......");
//					int result1221=criteria1Repository.insertAffiliatedYrTable1221(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//							valueAddobj.getValueAddedCourses().get(0).getInputvat8(),1,valueAddobj.getCriteriaId().getCollegeId(),
//							valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//					System.out.println("result1221 affiliated inserted=======>"+result1221);	
//			}else {
//	//update 1211t1				
//				System.out.println("Cr12 Qn not  empty affiliated .....");
//				String value1211 = criteria1.get().getCriteria12Qn().get(0).getInput1211t1();
//				System.out.println("existing value is============>"+value1211);
//				BigDecimal bd = new BigDecimal(value1211);
//				int finalValueAf = bd.intValue() + 1;
//				System.out.println("what is the final value ==>"+finalValueAf);
//				System.out.println("unique key ==>"+valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//				int update1211=criteria1Repository.updateCriteria12Qn(finalValueAf,valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//				System.out.println("update1211 affiliated=======>"+update1211);
//	//update 1221 table
//				System.out.println("year table 1221 is not  empty affiliated.....");
//				String value1221 = criteria1.get().getAffiliatedYearTable1221().get(0).getInput1221v();
//				System.out.println("existing value is affiliated============>"+value1221);
//				BigDecimal bdAf = new BigDecimal(value1221);
//				BigDecimal finalValueAf2=bdAf.add(new BigDecimal(valueAddobj.getValueAddedCourses().get(0).getInputvat8()));
//				System.out.println("what is the final value affiliated ==>"+finalValueAf2);
//				System.out.println("unique key ==>"+valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//				int update1221=criteria1Repository.updateAffiliatedYrTable1221(finalValueAf2,valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
//				System.out.println("update1221 affiliated u=======>"+update1221);
//				}
//	  }else {
//				
//				System.out.println("inserting into cr1 main table else affiliated ......");
//				int criteria1Main=criteria1Repository.insertCriteria1Main(valueAddobj.getCriteriaId().getCollegeId(),
//						valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("criteria1Main affiliated else====>"+criteria1Main);
//	//1211t1 insert			
//				int result1211=criteria1Repository.insertCriteria12Qn(1,1,valueAddobj.getCriteriaId().getCollegeId(),
//						valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//					System.out.println("result1211af affiliated inserted=======>"+result1211);
//	//1221 insert
//				System.out.println("year table 1221 insertion .......");
//				int result1221=criteria1Repository.insertAffiliatedYrTable1221(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//						valueAddobj.getValueAddedCourses().get(0).getInputvat8(),1,valueAddobj.getCriteriaId().getCollegeId(),
//						valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//				System.out.println("result1221 affiliated inserted=======>"+result1221);	
//	  }	
						
//				if(CollectionUtils.isEmpty(criteria1.get().getYearTable1321())) {
//					System.out.println("year table insertion else .......");
//					int result1321=criteria1Repository.insertYearTable1321(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//							"1",valueAddobj.getCriteriaId().hashCode(),valueAddobj.getCriteriaId().getCollegeId(),
//							valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//					System.out.println("result1321 else=======>"+result1321);
//				}else {
//						System.out.println("year table is not  empty else.....");
//						String value1321 = criteria1.get().getYearTable1321().get(0).getInput1321v();
//						BigDecimal bd = new BigDecimal(value1321);
//						bd.add(new BigDecimal(1));
//						int update1321=criteria1Repository.updateYearTable1321(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),bd.intValue());
//						
//						System.out.println("update1321u else=======>"+update1321);
//					}
					
			

			
//			System.out.println("key is ==>"+mapper.writeValueAsString(valueAddobj.getCriteriaId()));
//			int result132 =criteria1Repository.insertYearTable1321(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//					valueAddobj.getValueAddedCourses().get(0).getInputvat1(),valueAddobj.getCriteriaId().getCollegeId(),
//					valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result1321=======>"+result132);
//			
//			int result133 =criteria1Repository.insertYearTable1331(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//					valueAddobj.getValueAddedCourses().get(0).getInputvat8(),valueAddobj.getCriteriaId().getCollegeId(),
//					valueAddobj.getCriteriaId().getFinancialYear(),valueAddobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result1331=======>"+result133);
			


// //1. AU,U 132		
//	if("autonomous".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution())) {
//	int result132 = criteria1Repository.updateYearTable1321(valueAddobj.getValueAddedCourses().get(0).getInputvat5(), 
//		valueAddobj.getValueAddedCourses().get(0).getInputvat1()	);
//		System.out.println("result132au=============>"+result132);
//				
//	}
//	else if ("university".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution()))	{
//		int result132 = criteria1Repository.updateYearTable1321(valueAddobj.getValueAddedCourses().get(0).getInputvat5(), valueAddobj.getValueAddedCourses().get(0).getInputvat1());
//		System.out.println("result132u=============>"+result132);	
//	}
//	
////1. Af 121		
//	else if("affiliated".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution())) {
//	int result1211 = criteria1Repository.updateCriteria1_FieldInfoQn(valueAddobj.getValueAddedCourses().get(0).getInputvat1());
//    System.out.println("result1211af=============>"+result1211);
//	}
//	
////2. U,Au 133		
//	if("autonomous".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution())) {
//		int result133 = criteria1Repository.updateYearTable1331(valueAddobj.getValueAddedCourses().get(0).getInputvat5(), 
//			valueAddobj.getValueAddedCourses().get(0).getInputvat8()	);
//			System.out.println("result133au=============>"+result133);
//					
//		}
//		else if ("university".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution()))	{
//			int result133 = criteria1Repository.updateYearTable1331(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//					valueAddobj.getValueAddedCourses().get(0).getInputvat8());
//			System.out.println("result133u=============>"+result133);	
//		}
//
////2. Af 122
//		else if ("affiliated".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution())) {
//			int result1221 = criteria1Repository.updateAffiliated_YearTable1221(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//					valueAddobj.getValueAddedCourses().get(0).getInputvat8());
//		    System.out.println("result1211af=============>"+result1221); 
//			
//		}
	        
//			int result1321 = criteria1Repository.updateYearTable1321(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//					valueAddobj.getValueAddedCourses().get(0).getInputvat1());
//			System.out.println("result1321=============>"+result1321);
//			
//			int result1331 = criteria1Repository.updateYearTable1331(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//					valueAddobj.getValueAddedCourses().get(0).getInputvat8());
//			System.out.println("result1331=============>"+result1331);
//			
//	//university 
//			
//			int result1321u = criteria1Repository.updateYearTable1321u(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//					valueAddobj.getValueAddedCourses().get(0).getInputvat1());
//			System.out.println("result1321u=============>"+result1321u);
//			
//			int result1331u = criteria1Repository.updateYearTable1331(valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
//					valueAddobj.getValueAddedCourses().get(0).getInputvat8());
//			System.out.println("result1331u=============>"+result1331u);
			
	
			return valueAddCourseRepository.save(valueAddobj);
	
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

	

	public List<ValueAddedCoursesMain> getAllValueAddData() {
		try {
			List<ValueAddedCoursesMain> criteria1 = new ArrayList<ValueAddedCoursesMain>();

			valueAddCourseRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
