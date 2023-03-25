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
import com.adiverse.erp.model.BooksandChaptersFileUpload;
import com.adiverse.erp.model.BooksandChaptersMain;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.repository.BookandChaptersRepository;
import com.adiverse.erp.repository.Criteria3Repository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class BookandChapterService {

	private final Logger logger = LoggerFactory.getLogger(BookandChapterService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private BookandChaptersRepository bookandChaptersRepository;
	
	@Autowired
	private Criteria3Repository criteria3Repository;

	public BooksandChaptersMain booksandChapterInfo(BooksandChaptersMain booksInfo, MultipartFile[] booksFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(booksInfo));
			List<BooksandChaptersFileUpload> file1 = new ArrayList<>();
if(booksFiles != null) {
			for (int i = 0; i < booksFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = booksFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(booksFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				BooksandChaptersFileUpload fileUpload1 = new BooksandChaptersFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+booksInfo.getCriteriaId().getFinancialYear()));
				fileUpload1.setBooksandchaptersFileName(filename);
				fileUpload1.setBooksandchaptersFilePath(filepath);
				fileUpload1.setBooksandchaptersFileType(param);
				fileUpload1.setCriteriaId(booksInfo.getCriteriaId());

				file1.add(fileUpload1);

			}
			booksInfo.setBooksandChaptersFileUpload(file1);
}
////3.4.6.1  U
//	if("university".equalsIgnoreCase(booksInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(booksInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(booksInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(booksInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable3461())) {
//				System.out.println("3461 table is empty.....");
//	//Insert 3461 tb					
//				int result3461=criteria3Repository.insertYearTable3461(booksInfo.getBooksandChapters().get(0).getInputbct7(),
//						1,1,booksInfo.getCriteriaId().getCollegeId(),
//						booksInfo.getCriteriaId().getFinancialYear(),booksInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3461 inserted=======>"+result3461);
//			
//			}else {
//	//update 3461 tb		
//				System.out.println("yr 3461 is not  empty.....");
//					String value3461= criteria3.get().getUniversityYearTable3461().get(0).getInput3461v();
//					System.out.println("existing value3461 is============>"+value3461);
//					BigDecimal bd = new BigDecimal(value3461);
//					int finalValue = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue);
//					System.out.println("unique key ==>"+booksInfo.getBooksandChapters().get(0).getUniqueKey1());
//					int update3461=criteria3Repository.updatreYearTable3461(finalValue,
//							booksInfo.getBooksandChapters().get(0).getUniqueKey1());
//					System.out.println("update3461 u=======>"+update3461);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(booksInfo.getCriteriaId().getCollegeId(),
//				booksInfo.getCriteriaId().getFinancialYear(),booksInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3461 tb					
//		int result3461=criteria3Repository.insertYearTable3461(booksInfo.getBooksandChapters().get(0).getInputbct7(),
//				1,1,booksInfo.getCriteriaId().getCollegeId(),
//				booksInfo.getCriteriaId().getFinancialYear(),booksInfo.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3461 inserted=======>"+result3461);
//	  
//	  }			
//}
////3.4.4.1 Au
//	else if("autonomous".equalsIgnoreCase(booksInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(booksInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(booksInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(booksInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3441())) {
//				System.out.println("3441 table is empty.....");
//	//Insert 3441 tb					
//				int result3441Au=criteria3Repository.insertYearTable3441Au(booksInfo.getBooksandChapters().get(0).getInputbct7(),
//						1,1,booksInfo.getCriteriaId().getCollegeId(),
//						booksInfo.getCriteriaId().getFinancialYear(),booksInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3441Au inserted=======>"+result3441Au);
//			
//			}else {
//	//update 3441 tb		
//				System.out.println("yr 3441 is not  empty.....");
//					String value3441Au= criteria3.get().getYearTable3441().get(0).getInput3441v();
//					System.out.println("existing value3441Au is============>"+value3441Au);
//					BigDecimal bd = new BigDecimal(value3441Au);
//					int finalValue1 = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue1);
//					System.out.println("unique key ==>"+booksInfo.getBooksandChapters().get(0).getUniqueKey1());
//					int update3441Au=criteria3Repository.updatreYearTable3441Au(finalValue1,
//							booksInfo.getBooksandChapters().get(0).getUniqueKey1());
//					System.out.println("update3441Au u=======>"+update3441Au);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(booksInfo.getCriteriaId().getCollegeId(),
//				booksInfo.getCriteriaId().getFinancialYear(),booksInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main else====>"+criteria3Main);
//	//Insert 3441 tb					
//		int result3441Au=criteria3Repository.insertYearTable3441Au(booksInfo.getBooksandChapters().get(0).getInputbct7(),
//				1,1,booksInfo.getCriteriaId().getCollegeId(),
//				booksInfo.getCriteriaId().getFinancialYear(),booksInfo.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3441Au inserted=======>"+result3441Au);
//	  
//	  }			
//}
////3.3.2.1 Af
//	else if("affiliated".equalsIgnoreCase(booksInfo.getCriteriaId().getTypeofInstitution())) {
//		
//		CriteriaPrimaryKey key = new CriteriaPrimaryKey();
//		key.setCollegeId(booksInfo.getCriteriaId().getCollegeId());
//		key.setFinancialYear(booksInfo.getCriteriaId().getFinancialYear());
//		key.setTypeofInstitution(booksInfo.getCriteriaId().getTypeofInstitution());
//		Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
//		if(criteria3.isPresent()) {
//			if(CollectionUtils.isEmpty(criteria3.get().getYearTable3321())) {
//				System.out.println("3321 table affiliated is empty.....");
//	//Insert 3321 tb					
//				int result3321Af=criteria3Repository.insertYearTable3321Af(booksInfo.getBooksandChapters().get(0).getInputbct7(),
//						1,1,booksInfo.getCriteriaId().getCollegeId(),
//						booksInfo.getCriteriaId().getFinancialYear(),booksInfo.getCriteriaId().getTypeofInstitution());
//			System.out.println("result3321Af affiliated inserted=======>"+result3321Af);
//			
//			}else {
//	//update 3461 tb		
//				System.out.println("yr 3321 is not  empty.....");
//					String value3321Af= criteria3.get().getYearTable3321().get(0).getInput3321v();
//					System.out.println("existing value3321Af is============>"+value3321Af);
//					BigDecimal bd = new BigDecimal(value3321Af);
//					int finalValue2 = bd.intValue() + 1;
//					System.out.println("what is the final value ==>"+finalValue2);
//					System.out.println("unique key ==>"+booksInfo.getBooksandChapters().get(0).getUniqueKey1());
//					int update3321Af=criteria3Repository.updateYearTable3321Af(finalValue2,
//							booksInfo.getBooksandChapters().get(0).getUniqueKey1());
//					System.out.println("update3321Af affiliated u=======>"+update3321Af);			
//				}
//	  }else {
//				
//		System.out.println("inserting into cr3 main table else......");
//		int criteria3Main=criteria3Repository.insertCriteria3FieldInfoMain(booksInfo.getCriteriaId().getCollegeId(),
//				booksInfo.getCriteriaId().getFinancialYear(),booksInfo.getCriteriaId().getTypeofInstitution());
//		System.out.println("criteria3Main affiliated else====>"+criteria3Main);
//	//Insert 3321 tb					
//		int result3321Af=criteria3Repository.insertYearTable3321Af(booksInfo.getBooksandChapters().get(0).getInputbct7(),
//				1,1,booksInfo.getCriteriaId().getCollegeId(),
//				booksInfo.getCriteriaId().getFinancialYear(),booksInfo.getCriteriaId().getTypeofInstitution());
//	System.out.println("result3321Af  affiliated inserted=======>"+result3321Af);
//	  
//	  }			
//}
//			if("university".equalsIgnoreCase(booksInfo.getCriteriaId().getTypeofInstitution())) {
//				int result344 = criteria3Repository.updateYearTable3441(booksInfo.getBooksandChapters().get(0).getInputbct7(),
//						booksInfo.getBooksandChapters().get(0).getInputbct1());
//				System.out.println("result344=============>"+result344);
//			}else if("autonomous".equalsIgnoreCase(booksInfo.getCriteriaId().getTypeofInstitution())) {
//				System.out.println(" hii");
//				
//			}else if("affiliated".equalsIgnoreCase(booksInfo.getCriteriaId().getTypeofInstitution())) {
//				System.out.println(" hii");
//
//			}
			return bookandChaptersRepository.save(booksInfo);

		} catch (Exception e) {
			e.printStackTrace();
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

	

	public List<BooksandChaptersMain> getAllBookandChapterData() {
		try {
			List<BooksandChaptersMain> criteria1 = new ArrayList<BooksandChaptersMain>();

			bookandChaptersRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
