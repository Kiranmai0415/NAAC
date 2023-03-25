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
import com.adiverse.erp.model.Criteria4_FieldInfo;
import com.adiverse.erp.model.Criteria4_FileUpload;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FileUploadProperties;
//import com.adiverse.erp.openpdf.UniversityCriteria4Report;
import com.adiverse.erp.repository.Criteria4Repository;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
@Transactional
public class Criteria4Service {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    private Path dirLocation;
    
    @Autowired
    private Criteria4Repository criteria4Repository;
    
    

	@Autowired
	private TrackingService  trackingService; 
	


	
    @Autowired 
    public Criteria4Service(FileUploadProperties fileUploadProperties) {
        this.dirLocation = Paths.get(fileUploadProperties.getLocation())
                                .toAbsolutePath()
                                .normalize();
    }
   
    
    
    public String criteria4Info(Map<String, String> allParams)
    {
    	String institutionType=allParams.get("typeofInstitution");
    	String returnstatement="";
    	
    	if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("faculty")) {
    	System.out.println("faculty");
		boolean isSubmited = false;
		List<Criteria4_FieldInfo> criteria4Data = getAllCriteria4Data(allParams);
		if(criteria4Data != null && CollectionUtils.isNotEmpty(criteria4Data)) {
			if("save".equalsIgnoreCase(criteria4Data.get(0).getCriteria41Ql().get(0).getCriteria41status()) && 
			"save".equalsIgnoreCase(criteria4Data.get(0).getCriteria42Qn().get(0).getCriteria42status())&&
			"save".equalsIgnoreCase(criteria4Data.get(0).getCriteria43Qn().get(0).getCriteria43status())&&
             "save".equalsIgnoreCase(criteria4Data.get(0).getCriteria44Ql().get(0).getCriteria44status())
			   ) 
			{
				
				isSubmited = true;
			
			}
		}	
		if(isSubmited) {
    		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {		
    			returnstatement=trackingService.sendAutonomousCriteria4Email(allParams);
    		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
    			returnstatement=trackingService.sendAffiliatedCriteria4Email(allParams);
    		}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
    			returnstatement=trackingService.sendUniversityCriteria4Email(allParams);
    		}
		}
    	}
    	else if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("ROLE_DEAN"))
		{
    		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {		
    			returnstatement=trackingService.sendAutonomousCriteria4Email(allParams);
    		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
    			returnstatement=trackingService.sendAffiliatedCriteria4Email(allParams);
    		}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
    			returnstatement=trackingService.sendUniversityCriteria4Email(allParams);
    		}	
		}
    	
    		return returnstatement;
    	
    }
    
    
    
    
    
    
    
    
    //String directory = dirLocation;
    
    public Criteria4_FieldInfo criteria4Info( Criteria4_FieldInfo criteria4Fieldinfo, MultipartFile[] uploadfile4)
	 {
	
    	try {
    		ObjectMapper mapper=new ObjectMapper();
//			System.out.println("values====>" +mapper.writeValueAsString(criteria4Fieldinfo));
//			System.out.println("ql values====>" +mapper.writeValueAsString(criteria4Fieldinfo.getCriteria4FieldInfoQn()));
//			System.out.println("yeartable4231=====>"+mapper.writeValueAsString(criteria4Fieldinfo.getYearTable4231()));
//	log.info("uploadfile========="+uploadfile4.length);
//	log.info("employee info==="+criteria4Fieldinfo);
	List<Criteria4_FileUpload> file4 = new ArrayList<>();

	
	for (int i = 0; i < uploadfile4.length; i++) {
		// Get the filename and build the local file path
		String filename = uploadfile4[i].getOriginalFilename();
		log.info("File name is : "+filename);
		//String directory = this.dirLocation;
		Path dfile = this.dirLocation.resolve(filename);
		String filepath = dfile.toString();	   
		log.info("path:"+filepath);
		// =============Save the file locally====================
		BufferedOutputStream stream =
				new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		
			stream.write(uploadfile4[i].getBytes());
		
		stream.close();
		
		String param=filename.substring(0,filename.indexOf("-"));
		
		Criteria4_FileUpload fileUpload4 = new Criteria4_FileUpload();
		fileUpload4.setUniqueKey1(param.concat("-"+criteria4Fieldinfo.getCriteriaId().getFinancialYear()));
		fileUpload4.setCriteria4FileName(filename);
		fileUpload4.setCriteria4FilePath(filepath);
		fileUpload4.setCriteria4FileType(uploadfile4[i].getContentType()); 
		fileUpload4.setCriteriaId(criteria4Fieldinfo.getCriteriaId());
		
		file4.add(fileUpload4);
		
	}
	criteria4Fieldinfo.setCriteria4FileUpload(file4);
	
//	String institutionType=criteria4Fieldinfo.getCriteriaId().getTypeofInstitution();
//  System.out.println("institutionType======>"+institutionType);
//  
//	if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {		
//		trackingService.sendAutonomousCriteria4Email(criteria4Fieldinfo);
//	}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
//		trackingService.sendAffiliatedCriteria4Email(criteria4Fieldinfo);
//	}else if(institutionType != null && "universities".equalsIgnoreCase(institutionType)) {
//		
//		trackingService.sendUniversityCriteria4Email(criteria4Fieldinfo);
//	}
	
	
    	return criteria4Repository.save(criteria4Fieldinfo);
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
    		return null;
    	}

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
    
	  public List<Criteria4_FieldInfo> getAllCriteria4Data(Map<String, String> allParams ) {
		    try {
		    	
		    	ObjectMapper mapper = new ObjectMapper();
		      List<Criteria4_FieldInfo> criteria4 = new ArrayList<Criteria4_FieldInfo>();
		      
		      CriteriaPrimaryKey id = new CriteriaPrimaryKey();
				id.setCollegeId(allParams.get("collegeId"));
				id.setFinancialYear(allParams.get("financialYear"));
				id.setTypeofInstitution(allParams.get("typeofInstitution"));
           Optional<Criteria4_FieldInfo> academic2 = criteria4Repository.findById(id);
				
				System.out.println("options ==>"+mapper.writeValueAsString(academic2));
				if (academic2.isPresent()) {
					criteria4.add(academic2.get());
				}
				System.out.println("list object =="+mapper.writeValueAsString(criteria4));
				return criteria4;

			} catch (Exception e) {
				return null;
			}

		}
				
				
//		      criteria4Repository.findAll().forEach(criteria4::add);
//		   
//		      return criteria4;
//		    
//		   
//		  }catch (Exception e) { return null;
//		  }
//		  }

	  
	  
	  
	  
	  public List<Criteria4_FieldInfo> getAllCriteria4Data( ) {
		    try {
		      List<Criteria4_FieldInfo> criteria4 = new ArrayList<Criteria4_FieldInfo>();
		      
		      criteria4Repository.findAll().forEach(criteria4::add);
		   
		      return criteria4;
		    
		   
		  }catch (Exception e) { return null;
		  }
		  }


	
	  
}
    

