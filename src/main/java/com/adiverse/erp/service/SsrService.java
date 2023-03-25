package com.adiverse.erp.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.exception.FileStorageException;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.EvaluativeFileUpload;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.repository.SsrRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class SsrService {
	@Autowired
	private SsrRepository ssrRepository;

	@Value("${upload.files.path}")
	private String uploadFilePath;

//	@Autowired
//	private TrackingRepository trackingRepository;

	@Autowired
	private TrackingService trackingService;

	private final Logger logger = LoggerFactory.getLogger(SsrService.class);

	public ProfileoftheCollege ssrInfo(ProfileoftheCollege ssrData, MultipartFile[] uploadSsrfile) throws Exception {

		try {
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("data=======" + mapper.writeValueAsString(ssrData));
			System.out.println("uploadfile=========" + uploadSsrfile);
			System.out.println("uploadfile=========" + uploadSsrfile.length);
			logger.info("uploadfile=========" + uploadSsrfile.length);
			logger.info("employee info===" + ssrData);
			List<EvaluativeFileUpload> evaluativeFile = new ArrayList<>();

			for (int i = 0; i < uploadSsrfile.length; i++) {
				// Get the filename and build the local file path
				String filename = uploadSsrfile[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>" + uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(uploadSsrfile[i].getBytes());

				stream.close();

				String param = filename.substring(0, filename.indexOf("-"));

				// save it into file_upload_details table DB
				// String path = "C:\\Users\\risha\\Desktop\\uploads\\"; tb
				EvaluativeFileUpload evaluativeFile1 = new EvaluativeFileUpload();
				evaluativeFile1.setUniqueKey1(param.concat("-" + ssrData.getCriteriaId().getFinancialYear()));
				evaluativeFile1.setEvaluative_fileName(filename);
				evaluativeFile1.setEvaluative_filePath(filepath);
				evaluativeFile1.setEvaluative_filePath(uploadSsrfile[i].getContentType());
				evaluativeFile1.setCriteriaId(ssrData.getCriteriaId());
				evaluativeFile.add(evaluativeFile1);

			}

			ssrData.setEvaluativeFileupload(evaluativeFile);
			ssrRepository.save(ssrData);
			String institutionType = ssrData.getCriteriaId().getTypeofInstitution();
			
			Map<String, String> allParams = new HashMap<String, String>();
	    	allParams.put("collegeId", ssrData.getCriteriaId().getCollegeId() );
	    	allParams.put("financialYear", ssrData.getCriteriaId().getFinancialYear() );
	    	allParams.put("typeofInstitution", ssrData.getCriteriaId().getTypeofInstitution() );

			if (institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
				System.out.println("autonomousBasic");
		        trackingService.sendAutonoumsBasicInformationReport(allParams);
			
				
			}
			
			System.out.println("end of the process going to save the data==========");
		
			return ssrData;
		} catch (Exception e) {
			logger.info("Got the Exception while save the data ==>", e);
			e.printStackTrace();
			return null;
		}
	

	}
	
	
	
	
	public String ssruploadMail(Map<String, String> allParams)
	{
		String status="";
		String institutionType = allParams.get("typeofInstitution");
		
		if (institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			System.out.println("ssrservice");
			
			status=trackingService.sendAutonoumsBasicInformationReport(allParams);
			status=trackingService.sendAutonomousAccademicInformationReport(allParams);
		}
		
		

		return status;
	}
	
	
	

	public List<ProfileoftheCollege> getAllSsrData() {
		try {
			List<ProfileoftheCollege> ssrFiles = new ArrayList<ProfileoftheCollege>();

			ssrRepository.findAll().forEach(ssrFiles::add);

			return ssrFiles;

		} catch (Exception e) {
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
			Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			return fileName;

		} catch (Exception e) {
			throw new FileStorageException("Could not upload file");
		}
	}

	public ProfileoftheCollege academicInfo(ProfileoftheCollege ssrData) {
			ObjectMapper mapper = new ObjectMapper();
		try {

			String institutionType = ssrData.getCriteriaId().getTypeofInstitution();
			ProfileoftheCollege ssrDataReturned = ssrRepository.save(ssrData);
			System.out.println("savved data is ===>"+mapper.writeValueAsString(ssrDataReturned));
			Map<String, String> allParams = new HashMap<String, String>();
	    	allParams.put("collegeId", ssrData.getCriteriaId().getCollegeId() );
	    	allParams.put("financialYear", ssrData.getCriteriaId().getFinancialYear() );
	    	allParams.put("typeofInstitution", ssrData.getCriteriaId().getTypeofInstitution() );
			
			
			
			if (institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
				System.out.println("ssrservice");
				trackingService.sendAffiliatedBasicInformationReport(allParams);
			}
			
			else if (institutionType != null && "university".equalsIgnoreCase(institutionType)) {
				System.out.println("ssrservice");

				trackingService.sendUniversityAccademicInformationReport(allParams);
				
				trackingService.sendUniversityBasicInformationReport(allParams);
			}
			else if (institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
				System.out.println("ssrservice");

				trackingService.sendAutonomousAccademicInformationReport(allParams);
//				trackingService.sendAutonoumsBasicInformationReport(ssrData);
			}
			
			return ssrDataReturned;

			

		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	
	
	
	public String academicdataMail(Map<String, String> allParams)
	{
		String status="";
		String institutionType = allParams.get("typeofInstitution");

		
		if (institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
			System.out.println("ssrservice");
			trackingService.sendAffiliatedBasicInformationReport(allParams);
		}
		
		else if (institutionType != null && "university".equalsIgnoreCase(institutionType)) {
			System.out.println("ssrservice");

			trackingService.sendUniversityAccademicInformationReport(allParams);
			trackingService.sendUniversityBasicInformationReport(allParams);
		}
		else if (institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			System.out.println("ssrservice");

			trackingService.sendAutonomousAccademicInformationReport(allParams);
//			trackingService.sendAutonoumsBasicInformationReport(ssrData);
		}
		
		
		
		return status;
	}

	public List<ProfileoftheCollege> getAllAcademicData(Map<String, String> allParams) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			System.out.println("allParams=========="+allParams);
			
			List<ProfileoftheCollege> academic1 = new ArrayList<ProfileoftheCollege>();
			CriteriaPrimaryKey id = new CriteriaPrimaryKey();
			id.setCollegeId(allParams.get("collegeId"));
			id.setFinancialYear(allParams.get("financialYear"));
			id.setTypeofInstitution(allParams.get("typeofInstitution"));
			
			System.out.println("id object is--->"+mapper.writeValueAsString(id));
			Optional<ProfileoftheCollege> academic2 = ssrRepository.findById(id);
			
			System.out.println("options ==>"+mapper.writeValueAsString(academic2));
			if (academic2.isPresent()) {
				academic1.add(academic2.get());
			}
			System.out.println("list object =="+mapper.writeValueAsString(academic1));
			return academic1;

		} catch (Exception e) {
			return null;
		}

	}

	public List<ProfileoftheCollege> getAllBasicData() {
		try {
			List<ProfileoftheCollege> basic = new ArrayList<ProfileoftheCollege>();

			ssrRepository.findAll().forEach(basic::add);

			return basic;

		} catch (Exception e) {
			return null;
		}

	}

}
