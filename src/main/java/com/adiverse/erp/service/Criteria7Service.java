package com.adiverse.erp.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.exception.FileStorageException;
import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria7_FieldInfo;
import com.adiverse.erp.model.Criteria7_FileUpload;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FileUploadProperties;
import com.adiverse.erp.repository.Criteria7Repository;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
@Transactional

public class Criteria7Service {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    private Path dirLocation;
    
    @Autowired
    private Criteria7Repository criteria7Repository;
    
    @Autowired
	private TrackingService  trackingService;
  
	

   
    
    @Autowired 
    public Criteria7Service(FileUploadProperties fileUploadProperties) {
        this.dirLocation = Paths.get(fileUploadProperties.getLocation())
                                .toAbsolutePath()
                                .normalize();
    }
    public String criteria7Info(Map<String, String> allParams )
    {
    	
    	System.out.println("criteria 7==>value");
    	String institutionType=allParams.get("typeofInstitution");
		String returnstatement="";
		
		if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("faculty")) {
			System.out.println("faculty");
		boolean isSubmited = false;
		List<Criteria7_FieldInfo> criteria7Data = getAllCriteria7Data(allParams);
		if(criteria7Data != null && CollectionUtils.isNotEmpty(criteria7Data)) {
			if("save".equalsIgnoreCase(criteria7Data.get(0).getCriteria71Ql().get(0).getCriteria71status()) && 
			"save".equalsIgnoreCase(criteria7Data.get(0).getCriteria72Ql().get(0).getCriteria72status())&&
			"save".equalsIgnoreCase(criteria7Data.get(0).getCriteria73Ql().get(0).getCriteria73status())
			   ) 
			{
				
				isSubmited = true;
			
			}
		}
		System.out.println(isSubmited);
		if(isSubmited) {
    	if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
    		trackingService.sendAutonomousCriteria7Email(allParams);
    		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
    			trackingService.sendAffiliatedCriteria7Email(allParams);
    		}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
    			System.out.println("university");
    			trackingService.sendUniversityCriteria7Email(allParams);
    		}
		}
		}
		else if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("ROLE_DEAN"))
		{
			if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
	    		trackingService.sendAutonomousCriteria7Email(allParams);
	    		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
	    			trackingService.sendAffiliatedCriteria7Email(allParams);
	    		}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
	    			System.out.println("university");
	    			trackingService.sendUniversityCriteria7Email(allParams);
	    		}
			
			
		} 
    	
    	return returnstatement;
    }
    
    //String directory = dirLocation;
    
    
    public Criteria7_FieldInfo criteria7Info( Criteria7_FieldInfo criteria7Fieldinfo, MultipartFile[] uploadfile7)
	 {
	
    	System.out.println("criteria7Fieldinfo");
    	try {
    		ObjectMapper mapper=new ObjectMapper();
	log.info("uploadfile========="+uploadfile7.length);
	log.info("employee info==="+criteria7Fieldinfo);
	List<Criteria7_FileUpload> file7 = new ArrayList<>();

	
	for (int i = 0; i < uploadfile7.length; i++) {
		// Get the filename and build the local file path
		String filename = uploadfile7[i].getOriginalFilename();
		log.info("File name is : "+filename);
		//String directory = this.dirLocation;
		Path dfile = this.dirLocation.resolve(filename);
		String filepath = dfile.toString();	   
		log.info("path:"+filepath);
		// =============Save the file locally====================
		BufferedOutputStream stream =
				new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		
			stream.write(uploadfile7[i].getBytes());
		
		stream.close();
		
		String param=filename.substring(0,filename.indexOf("-"));
		
		Criteria7_FileUpload fileUpload7 = new Criteria7_FileUpload();
		fileUpload7.setUniqueKey1(param.concat("-"+criteria7Fieldinfo.getCriteriaId().getFinancialYear()));
		fileUpload7.setCriteria7FileName(filename);
		fileUpload7.setCriteria7FilePath(filepath);
		fileUpload7.setCriteria7FileType(uploadfile7[i].getContentType()); 
		fileUpload7.setCriteriaId(criteria7Fieldinfo.getCriteriaId());
		
		file7.add(fileUpload7);
		
	}
	
	
	criteria7Fieldinfo.setCriteria7FileUpload(file7);
	
    	return criteria7Repository.save(criteria7Fieldinfo);
    	}catch (Exception e) {
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    	}
    	return null;

}
    
  
    public void init() {
        // TODO Auto-generated method stub
        try {
            Files.createDirectories(this.dirLocation);
        } 
        catch (Exception ex) {
            throw new FileStorageException("Could not create upload dir!");
        }
    }


    public String saveFile(MultipartFile file) {
        // TODO Auto-generated method stub
        try {
            String fileName = file.getOriginalFilename();
            Path dfile = this.dirLocation.resolve(fileName);
            Files.copy(file.getInputStream(), dfile,StandardCopyOption.REPLACE_EXISTING);
            return fileName;
            
        } catch (Exception e) {
            throw new FileStorageException("Could not upload file");
        }
    }

 
    public Resource loadFile(String fileName) {

        try {
          Path file = this.dirLocation.resolve(fileName).normalize();
          Resource resource = new UrlResource(file.toUri());

          if (resource.exists() || resource.isReadable()) {
              return resource;
          } 
          else {
        	  throw new FileStorageException("Could not download file");
        } 
        }
        catch (MalformedURLException e) {
            throw new FileStorageException("Could not download file");
        } 
    }
    
	  public List<Criteria7_FieldInfo> getAllCriteria7Data(Map<String, String> allParams) {
		    try {
		    	
		    	ObjectMapper mapper = new ObjectMapper();

		      List<Criteria7_FieldInfo> criteria7 = new ArrayList<Criteria7_FieldInfo>();
		      CriteriaPrimaryKey id = new CriteriaPrimaryKey();
				id.setCollegeId(allParams.get("collegeId"));
				id.setFinancialYear(allParams.get("financialYear"));
				id.setTypeofInstitution(allParams.get("typeofInstitution"));
				
				Optional<Criteria7_FieldInfo> academic2 = criteria7Repository.findById(id);
				
				System.out.println("options ==>"+mapper.writeValueAsString(academic2));
				if (academic2.isPresent()) {
					criteria7.add(academic2.get());
				}
				System.out.println("list object =="+mapper.writeValueAsString(criteria7));
				return criteria7;

			} catch (Exception e) {
				return null;
			}

		}
		      
	  
	  
	  
	  
	  public List<Criteria7_FieldInfo> getAllCriteria7Data() {
		    try {
		      List<Criteria7_FieldInfo> criteria7 = new ArrayList<Criteria7_FieldInfo>();
		      criteria7Repository.findAll().forEach(criteria7::add);
		   
		      return criteria7;
		    
		   
		  }catch (Exception e) { return null;
		  }
		  }
	  
	  
	  
	  
	  
	  
	// ccriteria 7
		
}
    

