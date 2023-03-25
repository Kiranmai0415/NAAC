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
import com.adiverse.erp.model.ResearchGuideFileUpload;
import com.adiverse.erp.model.ResearchGuidesMain;
import com.adiverse.erp.model.SeedMoneyFileUpload;
import com.adiverse.erp.model.SeedMoneyMain;
import com.adiverse.erp.model.StudentSatisfactionMain;
import com.adiverse.erp.model.StudentSatisfactorySurveyFileUpload;
import com.adiverse.erp.repository.Criteria6Repository;
import com.adiverse.erp.repository.FellowshipRepository;
import com.adiverse.erp.repository.FinanceSupportTeachRepository;
import com.adiverse.erp.repository.FullTimeTeacherPhdRepository;
import com.adiverse.erp.repository.FullTimeTeacherSacnctionRepository;
import com.adiverse.erp.repository.OnlineF2FFDPRepository;
import com.adiverse.erp.repository.ResearchGuidesRepository;
import com.adiverse.erp.repository.SeedMoneyRepository;
import com.adiverse.erp.repository.StudentSatisfactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class OnlineF2FFDPService {

	private final Logger logger = LoggerFactory.getLogger(OnlineF2FFDPService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private OnlineF2FFDPRepository onlineF2FFDPRepository;
	
	@Autowired
	private Criteria6Repository criteria6Repository;

	public OnlineorF2FFDPMain onlineF2FFDPInfo(OnlineorF2FFDPMain onlinef2ffdpobj, MultipartFile[] onlinef2ffdpFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(onlinef2ffdpobj));
			List<OnlineorF2FFDPFileUpload> file1 = new ArrayList<>();
if(onlinef2ffdpFiles != null) {
			for (int i = 0; i < onlinef2ffdpFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = onlinef2ffdpFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(onlinef2ffdpFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				OnlineorF2FFDPFileUpload fileUpload1 = new OnlineorF2FFDPFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+onlinef2ffdpobj.getCriteriaId().getFinancialYear()));
				fileUpload1.setOnlineF2fFdpFileName(filename);
				fileUpload1.setOnlineF2fFdpFilePath(filepath);
				fileUpload1.setOnlineF2fFdpFileType(param);
				fileUpload1.setCriteriaId(onlinef2ffdpobj.getCriteriaId());

				file1.add(fileUpload1);

			}
			onlinef2ffdpobj.setOnlineorF2FFDPFileUpload(file1);
}
////6341 U
//	if("university".equalsIgnoreCase(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(onlinef2ffdpobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(onlinef2ffdpobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
//		if(criteria6.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria6.get().getYearTable6341())) {
//				System.out.println("6341 table is empty.....");
//	//Insert 6341 tb					
//				int result6341=criteria6Repository.insertYearTable6341(onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(),
//						1,1,onlinef2ffdpobj.getCriteriaId().getCollegeId(),
//						onlinef2ffdpobj.getCriteriaId().getFinancialYear(),onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result6341 inserted=======>"+result6341);
//			
//			}else {
//	//update 6341 tb		
//				System.out.println("yr 6341 is not  empty.....");
//					String value6341= criteria6.get().getYearTable6341().get(0).getInput6341v();
//					System.out.println("existing value6341 is============>"+value6341);
//					BigDecimal bd = new BigDecimal(value6341);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
//					int update6341=criteria6Repository.updateYearTable6341(finalValue,
//							onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
//					System.out.println("update6341 u=======>"+update6341);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr6 main table else......");
//		int criteria6Main=criteria6Repository.insertCriteria6FieldInfoMain(onlinef2ffdpobj.getCriteriaId().getCollegeId(),
//				onlinef2ffdpobj.getCriteriaId().getFinancialYear(),onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria6Main else====>"+criteria6Main);
//	//Insert 6341 tb					
//		int result6341=criteria6Repository.insertYearTable6341(onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(),
//				1,1,onlinef2ffdpobj.getCriteriaId().getCollegeId(),
//				onlinef2ffdpobj.getCriteriaId().getFinancialYear(),onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result6341 inserted=======>"+result6341);
//	  
//	  }	
//	
//}
//// 6341 Au 
//	else if("autonomous".equalsIgnoreCase(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(onlinef2ffdpobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(onlinef2ffdpobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
//		if(criteria6.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria6.get().getYearTable6341())) {
//				System.out.println("6341 table is empty.....");
//	//Insert 6341 tb					
//				int result6341=criteria6Repository.insertYearTable6341(onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(),
//						1,1,onlinef2ffdpobj.getCriteriaId().getCollegeId(),
//						onlinef2ffdpobj.getCriteriaId().getFinancialYear(),onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result6341 inserted=======>"+result6341);
//			
//			}else {
//	//update 6341 tb		
//				System.out.println("yr 6341 is not  empty.....");
//					String value6341= criteria6.get().getYearTable6341().get(0).getInput6341v();
//					System.out.println("existing value6341 is============>"+value6341);
//					BigDecimal bd = new BigDecimal(value6341);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
//					int update6341=criteria6Repository.updateYearTable6341(finalValue,
//							onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
//					System.out.println("update6341 u=======>"+update6341);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr6 main table else......");
//		int criteria6Main=criteria6Repository.insertCriteria6FieldInfoMain(onlinef2ffdpobj.getCriteriaId().getCollegeId(),
//				onlinef2ffdpobj.getCriteriaId().getFinancialYear(),onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria6Main else====>"+criteria6Main);
//	//Insert 6341 tb					
//		int result6341=criteria6Repository.insertYearTable6341(onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(),
//				1,1,onlinef2ffdpobj.getCriteriaId().getCollegeId(),
//				onlinef2ffdpobj.getCriteriaId().getFinancialYear(),onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result6341 inserted=======>"+result6341);
//	  
//	  }	
//	
//}
////6331 Af
//	else if("affiliated".equalsIgnoreCase(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(onlinef2ffdpobj.getCriteriaId().getCollegeId());
//		key.setFinancialYear(onlinef2ffdpobj.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
//		if(criteria6.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria6.get().getYearTable6331())) {
//				System.out.println("6331 table affiliated is empty.....");
//	//Insert 6331 tb					
//				int result6331=criteria6Repository.insertYearTable6331Af(onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(),
//						1,1,onlinef2ffdpobj.getCriteriaId().getCollegeId(),
//						onlinef2ffdpobj.getCriteriaId().getFinancialYear(),onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//			System.out.println("result6331 inserted=======>"+result6331);
//			
//			}else {
//	//update 6331 tb		
//				System.out.println("yr 6331 affiliated is not  empty.....");
//					String value6331= criteria6.get().getYearTable6331().get(0).getInput6331v();
//					System.out.println("existing value6331 is============>"+value6331);
//					BigDecimal bd = new BigDecimal(value6331);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
//					int update6331=criteria6Repository.updateYearTable6331Af(finalValue,
//							onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
//					System.out.println("update6331 affiliated u=======>"+update6331);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr6 main table else......");
//		int criteria6Main=criteria6Repository.insertCriteria6FieldInfoMain(onlinef2ffdpobj.getCriteriaId().getCollegeId(),
//				onlinef2ffdpobj.getCriteriaId().getFinancialYear(),onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria6Main affiliated else====>"+criteria6Main);
//	//Insert 6341 tb					
//		int result6331=criteria6Repository.insertYearTable6331Af(onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(),
//				1,1,onlinef2ffdpobj.getCriteriaId().getCollegeId(),
//				onlinef2ffdpobj.getCriteriaId().getFinancialYear(),onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
//	System.out.println("result6331 affiliated inserted=======>"+result6331);
//	  
//	  }	
//	
//}
			return onlineF2FFDPRepository.save(onlinef2ffdpobj);

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

	

	public List<OnlineorF2FFDPMain> getAllOnlineF2FFDPData() {
		try {
			List<OnlineorF2FFDPMain> criteria1 = new ArrayList<OnlineorF2FFDPMain>();

			onlineF2FFDPRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
