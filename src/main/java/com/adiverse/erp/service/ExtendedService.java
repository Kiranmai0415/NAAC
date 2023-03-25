package com.adiverse.erp.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
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

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.ExtendedFileupload;
import com.adiverse.erp.model.ExtendedProfile;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.repository.ExtendedProfileRepository;
import com.adiverse.erp.repository.TrackingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class ExtendedService {

	@Value("${upload.files.path}")
	private String uploadFilePath;
	
	@Autowired
	private ExtendedProfileRepository extendedRepository;

	@Autowired
	private TrackingRepository trackingRepository;

	private final Logger logger = LoggerFactory.getLogger(ExtendedService.class);

	@Autowired
	private TrackingService trackingService;

	private final Logger log = LoggerFactory.getLogger(ExtendedService.class);

	public Tracking authorizedInfo(Tracking tracking) {

		return trackingRepository.save(tracking);

	}

	public ExtendedProfile extendedInfo(ExtendedProfile extendedProfile) {

		ExtendedProfile savedExtendedProfile = extendedRepository.save(extendedProfile);
		
		String institutionType = extendedProfile.getCriteriaId().getTypeofInstitution();
		
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId", extendedProfile.getCriteriaId().getCollegeId() );
		allParams.put("financialYear", extendedProfile.getCriteriaId().getFinancialYear() );
		allParams.put("typeofInstitution", extendedProfile.getCriteriaId().getTypeofInstitution() );

		if (institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			trackingService.sendAutonomousExtendedProfileEmail(allParams);
		} else if (institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
			trackingService.sendAffiliatedExtendedProfileEmail(allParams);
		}
		else if (institutionType != null && "university".equalsIgnoreCase(institutionType)) {
			trackingService.sendUniversityExtendedProfileEmail( allParams);
		}

		return savedExtendedProfile;

	}
	
	
	public String extendedMail(Map<String, String> allParams)
	{
		String status="";
		String institutionType = allParams.get("typeofInstitution");
		
		if (institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			trackingService.sendAutonomousExtendedProfileEmail(allParams);
		} else if (institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
			trackingService.sendAffiliatedExtendedProfileEmail(allParams);
		}
		else if (institutionType != null && "university".equalsIgnoreCase(institutionType)) {
			trackingService.sendUniversityExtendedProfileEmail( allParams);
		}

		return status;
	}
	
	


	public List<ExtendedProfile> getAllExtendedData(Map<String, String> allParams) {
		try {
			List<ExtendedProfile> extended = new ArrayList<ExtendedProfile>();
			
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("params are --->"+allParams);

			CriteriaPrimaryKey id = new CriteriaPrimaryKey();
			id.setCollegeId(allParams.get("collegeId"));
			id.setFinancialYear(allParams.get("financialYear"));
			id.setTypeofInstitution(allParams.get("typeofInstitution"));
			System.out.println("id object is--->"+mapper.writeValueAsString(id));
			Optional<ExtendedProfile> academic2 =extendedRepository.findById(id);
			System.out.println("options ==>"+mapper.writeValueAsString(academic2));
			if (academic2.isPresent()) {
				extended.add(academic2.get());
			}
			return extended;

		} catch (Exception e) {
			return null;
		}

	}

	// affiliated service
	public ExtendedProfile extendedInfo(ExtendedProfile extendedData, MultipartFile[] uploadextendedfile) {

		try {
			logger.info("uploadfile=========" + uploadextendedfile.length);
			logger.info("employee info===" + extendedData);
			List<ExtendedFileupload> extendedFile = new ArrayList<>();

			// executiveData.setExecutive_id(new Integer(6).longValue());
			for (int i = 0; i < uploadextendedfile.length; i++) {
				// Get the filename and build the local file path
				String filename = uploadextendedfile[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>" + filename);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(uploadextendedfile[i].getBytes());

				stream.close();

				String param = filename.substring(0, filename.indexOf("-"));

				// save it into file_upload_details table DB
				// String path = "C:\\Users\\my pc\\Desktop\\fileupload";
				ExtendedFileupload extendedFile2 = new ExtendedFileupload();
				extendedFile2.setUniqueKey1(param.concat("-" + extendedData.getCriteriaId().getFinancialYear()));
				extendedFile2.setExtendedFileName(filename);
				extendedFile2.setExtendedFilePath(filepath);
				extendedFile2.setExtendedFileType((uploadextendedfile[i].getContentType()));
				extendedFile2.setCriteriaId(extendedData.getCriteriaId());

				extendedFile.add(extendedFile2);

			}

			extendedData.setExtendedFileupload(extendedFile);
			extendedRepository.save(extendedData);
			Map<String, String> allParams = new HashMap<String, String>();
			allParams.put("collegeId", extendedData.getCriteriaId().getCollegeId() );
			allParams.put("financialYear", extendedData.getCriteriaId().getFinancialYear() );
			allParams.put("typeofInstitution", extendedData.getCriteriaId().getTypeofInstitution() );
		
			extendedMail(allParams);
		
		return null;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}

	}

}
