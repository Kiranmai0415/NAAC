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
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.exception.FileStorageException;
import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria5_FieldInfo;
import com.adiverse.erp.model.Criteria5_FileUpload;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FileUploadProperties;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.repository.Criteria5Repository;
import com.adiverse.erp.repository.TrackingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
@Transactional
public class Criteria5Service {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    private Path dirLocation;
    
    @Autowired
    private Criteria5Repository criteria5Repository;
    
    @Autowired
	private TrackingRepository trackingRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	

//	@Autowired
//	private AutonomousCriteria5Report autonomousCriteria5Report;
//	
//
//	
//	
//	@Autowired
//	private UniversityCriteria5Report universityCriteria5Report;
	
	@Autowired
	private TrackingService trackingService;
	
    
	
    @Autowired 
    public Criteria5Service(FileUploadProperties fileUploadProperties) {
        this.dirLocation = Paths.get(fileUploadProperties.getLocation())
                                .toAbsolutePath()
                                .normalize();
    }
    
    //String directory = dirLocation;
    public Criteria5Service(JavaMailSender javaMailSender) {
 		this.javaMailSender = javaMailSender;
 	}
 	
 	public Tracking authorizedInfo(Tracking tracking) {

 		return trackingRepository.save(tracking);

 	}
 	
    public String criteria5Info( Map<String, String> allParams)
 	{
 		
 		String institutionType=allParams.get("typeofInstitution");
		String returnstatement="";
		
		if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("faculty")) {
			System.out.println("faculty");
		boolean isSubmited = false;
		List<Criteria5_FieldInfo> criteria5Data = getAllCriteria5Data(allParams);

		if(criteria5Data != null && CollectionUtils.isNotEmpty(criteria5Data)) {
			if("save".equalsIgnoreCase(criteria5Data.get(0).getCriteria51Qn().get(0).getCriteria51status()) && 
			"save".equalsIgnoreCase(criteria5Data.get(0).getCriteria52Qn().get(0).getCriteria52status())&&
			"save".equalsIgnoreCase(criteria5Data.get(0).getCriteria53Qn().get(0).getCriteria53status())&&
             "save".equalsIgnoreCase(criteria5Data.get(0).getCriteria54Ql().get(0).getCriteria54status())
			   ) 
			{
				
				isSubmited = true;
			
			}
		}
		if(isSubmited) {
		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			returnstatement=trackingService.sendAutonomousCriteria5Email(allParams);
 		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
 			returnstatement=trackingService.sendAffiliatedCriteria5Email(allParams);
 		}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
 			returnstatement=trackingService.sendUniversityCriteria5Email(allParams);
 		}
		}
		}
		else if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("ROLE_DEAN"))
		{
			
			if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
				returnstatement=trackingService.sendAutonomousCriteria5Email(allParams);
	 		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
	 			returnstatement=trackingService.sendAffiliatedCriteria5Email(allParams);
	 		}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
	 			returnstatement=trackingService.sendUniversityCriteria5Email(allParams);
	 		}
			
		}
		return returnstatement;
 		
 	}
 	
 	
 	
 	
 	
    public Criteria5_FieldInfo criteria5Info( Criteria5_FieldInfo criteria5Fieldinfo, MultipartFile[] uploadfile5)
	 {
	
    	try {
    		ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(criteria5Fieldinfo));
	log.info("uploadfile========="+uploadfile5.length);
	log.info("employee info==="+criteria5Fieldinfo);
	List<Criteria5_FileUpload> file5= new ArrayList<>();

	
	for (int i = 0; i < uploadfile5.length; i++) {
		// Get the filename and build the local file path
		String filename = uploadfile5[i].getOriginalFilename();
		log.info("File name is : "+filename);
		//String directory = this.dirLocation;
		Path dfile = this.dirLocation.resolve(filename);
		String filepath = dfile.toString();	   
		log.info("path:"+filepath);
		// =============Save the file locally====================
		BufferedOutputStream stream =
				new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		
			stream.write(uploadfile5[i].getBytes());
		
		stream.close();
		
		String param=filename.substring(0,filename.indexOf("-"));
		
		Criteria5_FileUpload fileUpload5 = new Criteria5_FileUpload();
		fileUpload5.setUniqueKey1(param.concat("-"+criteria5Fieldinfo.getCriteriaId().getFinancialYear()));
		fileUpload5.setCriteria5FileName(filename);
		fileUpload5.setCriteria5FilePath(filepath);
		fileUpload5.setCriteria5FileType(uploadfile5[i].getContentType());
		fileUpload5.setCriteriaId(criteria5Fieldinfo.getCriteriaId());
		
		file5.add(fileUpload5);
		
	}
	criteria5Fieldinfo.setCriteria5FileUpload(file5);
	
//	String institutionType=criteria5Fieldinfo.getCriteriaId().getTypeofInstitution();
//
//	
//	
//	if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
//		trackingService.sendAutonomousCriteria5Email(criteria5Fieldinfo);
//	}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
//		trackingService.sendAffiliatedCriteria5Email(criteria5Fieldinfo);
//	}else if(institutionType != null && "universities".equalsIgnoreCase(institutionType)) {
//		trackingService.sendUniversityCriteria5Email(criteria5Fieldinfo);
//	}
//	

	
    	return criteria5Repository.save(criteria5Fieldinfo);
    	}catch (Exception e) {
    		e.printStackTrace();
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
    
	  public List<Criteria5_FieldInfo> getAllCriteria5Data(Map<String, String> allParams) {
		    try {
		    	
		    	ObjectMapper mapper = new ObjectMapper();
		    	
		      List<Criteria5_FieldInfo> criteria5 = new ArrayList<Criteria5_FieldInfo>();
		      CriteriaPrimaryKey id=new CriteriaPrimaryKey();
		      id.setCollegeId(allParams.get("collegeId"));
				id.setFinancialYear(allParams.get("financialYear"));
				id.setTypeofInstitution(allParams.get("typeofInstitution"));
		      
				
				 Optional<Criteria5_FieldInfo> academic2 = criteria5Repository.findById(id);
					
					System.out.println("options ==>"+mapper.writeValueAsString(academic2));
					if (academic2.isPresent()) {
						criteria5.add(academic2.get());
					}
					System.out.println("list object =="+mapper.writeValueAsString(criteria5));
					return criteria5;

				} catch (Exception e) {
					return null;
				}

			}
//		      criteria5Repository.findAll().forEach(criteria5::add);
//		   
//		      return criteria5;
//		    
//		   
//		  }catch (Exception e) { return null;
//		  }
//		  }
//	  
	  
	  
	  
	  
	  
	  public List<Criteria5_FieldInfo> getAllCriteria5Data() {
		    try {
		      List<Criteria5_FieldInfo> criteria5 = new ArrayList<Criteria5_FieldInfo>();
		      
		      criteria5Repository.findAll().forEach(criteria5::add);
		   
		      return criteria5;
		    
		   
		  }catch (Exception e) { return null;
		  }
		  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	/////university criteriareport 
		


		
		

		}
	
//    

