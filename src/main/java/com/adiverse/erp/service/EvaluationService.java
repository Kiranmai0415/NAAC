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
import com.adiverse.erp.model.EvaluativeFileUpload;
import com.adiverse.erp.model.EvaluativereportMain;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.repository.EvalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class EvaluationService {

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Value("${excel.templates.path}")
	private String excelTemplatesPath;
	
	@Autowired
	private EvalRepository evalRepository;
	
	@Autowired
	private TrackingService trackingService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public ProfileoftheCollege evaluationInfo(ProfileoftheCollege profileoftheCollege,
			MultipartFile[] evaluationuploadfile) {
		try {
			try {
				ObjectMapper mapper=new ObjectMapper();
				System.out.println("values====>" +mapper.writeValueAsString(profileoftheCollege));
				logger.info("uploadfile=========" + evaluationuploadfile.length);
				List<EvaluativeFileUpload> file1 = new ArrayList<>();

				for (int i = 0; i < evaluationuploadfile.length; i++) {
					// Get the filename and build the local file path
					String filename = evaluationuploadfile[i].getOriginalFilename();
					logger.info("File name is : " + filename);
					// String directory = this.dirLocation;
					logger.info("uploadFilePath ==>"+uploadFilePath);
					String filepath = Paths.get(uploadFilePath, filename).toString();
					logger.info("path:" + filepath);
					// =============Save the file locally====================
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

					stream.write(evaluationuploadfile[i].getBytes());

					stream.close();
					
					String param=filename.substring(0,filename.indexOf("-"));

					EvaluativeFileUpload fileUpload1 = new EvaluativeFileUpload();
					fileUpload1.setUniqueKey1(param.concat("-"+profileoftheCollege.getCriteriaId().getFinancialYear()));
					fileUpload1.setEvaluative_fileName(filename);
					fileUpload1.setEvaluative_filePath(filepath);
					fileUpload1.setEvaluate_fileType(evaluationuploadfile[i].getContentType());
					fileUpload1.setCriteriaId(profileoftheCollege.getCriteriaId());

					file1.add(fileUpload1);

				}
				profileoftheCollege.setEvaluativeFileupload(file1);
				
				evalRepository.save(profileoftheCollege);
				
				
				String institutionType=profileoftheCollege.getCriteriaId().getTypeofInstitution();
				

				Map<String, String> allParams = new HashMap<String, String>();
		    	allParams.put("collegeId", profileoftheCollege.getCriteriaId().getCollegeId() );
		    	allParams.put("financialYear", profileoftheCollege.getCriteriaId().getFinancialYear() );
		    	allParams.put("typeofInstitution", profileoftheCollege.getCriteriaId().getTypeofInstitution() );
				
				if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
					
					trackingService.sendAutonomousProfileoftheCollegeEvaluateReport(allParams );
					
						
					}
				else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
					
						trackingService.sendAffiliatedProfileoftheCollegeEvaluateReport( allParams );
					}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
						
					System.out.println("university");
						trackingService.sendUniversityProfileoftheCollegeEvaluateReport( allParams );
					}

			
				
				
	
				

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String evaluationMail(Map<String, String> allParams)
	{
		String status="";
		String institutionType=allParams.get("typeofInstitution");

		
		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			status=trackingService.sendAutonomousProfileoftheCollegeEvaluateReport(allParams );
			}
		else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
			status=	trackingService.sendAffiliatedProfileoftheCollegeEvaluateReport( allParams );
			}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
				
			System.out.println("university");
			status=	trackingService.sendUniversityProfileoftheCollegeEvaluateReport( allParams );
			}

	
		
		return status;
	}
	
	
	
	public List<ProfileoftheCollege> getAllEvaluationData(Map<String, String> allParams) {
		try {
			
			ObjectMapper mapper =new ObjectMapper();
			
			List<ProfileoftheCollege> evaluation = new ArrayList<ProfileoftheCollege>();
			CriteriaPrimaryKey id =new CriteriaPrimaryKey();
			 id.setCollegeId(allParams.get("collegeId"));
	            id.setFinancialYear(allParams.get("financialYear"));
				id.setTypeofInstitution(allParams.get("typeofInstitution"));
				System.out.println("id object is--->"+mapper.writeValueAsString(id));
				Optional<ProfileoftheCollege> academic2 = evalRepository.findById(id);
				
				if (academic2.isPresent()) {
					evaluation.add(academic2.get());
				}
				System.out.println("options ==>"+mapper.writeValueAsString(academic2));

				return evaluation;

		} catch (Exception e) {
			return null;
		}

	}
}

