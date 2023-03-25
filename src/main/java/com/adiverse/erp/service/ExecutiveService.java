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
import com.adiverse.erp.model.ExecutiveSummary;
import com.adiverse.erp.model.Executive_FileUpload;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.repository.ExecutiveRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class ExecutiveService
{
	@Value("${upload.files.path}")
	private String uploadFilePath;
	
	@Autowired
	private  ExecutiveRepository executiveRepository;
	
	
	@Autowired
	private TrackingService trackingService;
	
	
	private final Logger logger = LoggerFactory.getLogger(ExecutiveService.class);

	
	public ExecutiveSummary executiveInfo( ExecutiveSummary executiveData, MultipartFile[] uploadexecutivefile)
	 {
	
try {
	logger.info("uploadfile========="+uploadexecutivefile.length);
	logger.info("employee info==="+executiveData);
	List<Executive_FileUpload> evaluativeFile = new ArrayList<>();

	//executiveData.setExecutive_id(new Integer(6).longValue());
	for (int i = 0; i < uploadexecutivefile.length; i++) {
		// Get the filename and build the local file path
		String filename = uploadexecutivefile[i].getOriginalFilename();
		logger.info("File name is : " + filename);
		// String directory = this.dirLocation;
		logger.info("uploadFilePath ==>"+uploadFilePath);
		String filepath = Paths.get(uploadFilePath, filename).toString();
		logger.info("path:" + filepath);
		// =============Save the file locally====================
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

		stream.write(uploadexecutivefile[i].getBytes());

		stream.close();
		
		String param=filename.substring(0,filename.indexOf("-"));
		
		// save it into file_upload_details table DB
		//String path = "C:\\Users\\my pc\\Desktop\\fileupload"; 
		Executive_FileUpload  evaluativeFile2= new Executive_FileUpload();
		evaluativeFile2.setUniqueKey1(param.concat("-"+executiveData.getCriteriaId().getFinancialYear()));
		evaluativeFile2.setExecutiveFileName(filename);
		evaluativeFile2.setExecutiveFilePath(filepath);
		evaluativeFile2.setExecutiveFileType((uploadexecutivefile[i].getContentType()));
		evaluativeFile2.setCriteriaId(executiveData.getCriteriaId());

		evaluativeFile.add(evaluativeFile2);
		
	}
	
	executiveData.setExecutiveFileUpload(evaluativeFile);
	executiveRepository.save(executiveData);
	
	String institutionType=executiveData.getCriteriaId().getTypeofInstitution();
	
	ObjectMapper mapper1=new ObjectMapper();
	System.out.println("object of the 1st controler===."+ mapper1.writeValueAsString(executiveData));
	
	Map<String, String> allParams = new HashMap<String, String>();
	allParams.put("collegeId", executiveData.getCriteriaId().getCollegeId() );
	allParams.put("financialYear", executiveData.getCriteriaId().getFinancialYear() );
	allParams.put("typeofInstitution", executiveData.getCriteriaId().getTypeofInstitution() );
	
	if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
	trackingService.sendAutonomousExecutiveSummary( allParams);
	}
	else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
		trackingService.sendAffiliatedExecutiveEmail(allParams);
	}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
		trackingService.sendUniversityExecutiveEmail(allParams);
	}
	
	return null;
	
}
	catch (Exception e) 
	{
		e.printStackTrace();
		System.out.println(e.getMessage());
		return null;
	}
	 }
	
	public String executiveMail(Map<String, String> allParams)
	{
		String status="";
		String institutionType=allParams.get("typeofInstitution");
		
		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			status=trackingService.sendAutonomousExecutiveSummary( allParams);
			}
			else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
				status=trackingService.sendAffiliatedExecutiveEmail(allParams);
			}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
				status=trackingService.sendUniversityExecutiveEmail(allParams);
			}
			
		
		return status;
	}

  


	  
	  public List<ExecutiveSummary> getAllExecutiveData(Map<String, String> allParams ) {
	    try {
	      List<ExecutiveSummary> executiveFile = new ArrayList<ExecutiveSummary>();
	      ObjectMapper mapper = new ObjectMapper();
	      System.out.println("params are --->"+allParams);
	      CriteriaPrimaryKey id = new CriteriaPrimaryKey();
			id.setCollegeId(allParams.get("collegeId"));
			id.setFinancialYear(allParams.get("financialYear"));
			id.setTypeofInstitution(allParams.get("typeofInstitution"));
			
			System.out.println("id object is--->"+mapper.writeValueAsString(id));
			Optional<ExecutiveSummary> academic2 = executiveRepository.findById(id);
			
			
			if (academic2.isPresent()) {
				executiveFile.add(academic2.get());
			}
			System.out.println("list object =="+mapper.writeValueAsString(executiveFile));
			return executiveFile;

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
				Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				return fileName;

			} catch (Exception e) {
				throw new FileStorageException("Could not upload file");
			}
		}
		
		
		
		
		
		 public List<ExecutiveSummary> getAllExecutiveData() {
			    try {
			      List<ExecutiveSummary> executiveFile = new ArrayList<ExecutiveSummary>();
			      
			      executiveRepository.findAll().forEach(executiveFile::add);
			   
			      return executiveFile;
			    
			   
			  }catch (Exception e) { return null;}
				    
		}


}
    

