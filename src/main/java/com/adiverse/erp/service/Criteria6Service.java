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
import com.adiverse.erp.model.Criteria6_FieldInfo;
import com.adiverse.erp.model.Criteria6_FileUpload;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FileUploadProperties;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.repository.Criteria6Repository;
import com.adiverse.erp.repository.TrackingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
@Transactional
public class Criteria6Service {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    private Path dirLocation;
    
    @Autowired
    private Criteria6Repository criteria6Repository;
    
    @Autowired
	private TrackingRepository trackingRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
//	@Autowired
//	private AutonomousCriteria6Report autonomousCriteria6Report;
//	
////	@Autowired
////	private AffiliatedCriteria6Report  affiliatedCriteria6Report;
//	
//	
//	@Autowired 
//	private UniversityCriteria6Report universityCriteria6Report;
	
	
	@Autowired
	private TrackingService trackingService;
    
    
    @Autowired 
    public Criteria6Service(FileUploadProperties fileUploadProperties) {
        this.dirLocation = Paths.get(fileUploadProperties.getLocation())
                                .toAbsolutePath()
                                .normalize();
    }
    
    //String directory = dirLocation;
    public Criteria6Service(JavaMailSender javaMailSender) {
 		this.javaMailSender = javaMailSender;
 	}
 	
 	public Tracking authorizedInfo(Tracking tracking) {

 		return trackingRepository.save(tracking);

 	}
 	
 	
 	public String criteria6Info(Map<String, String> allParams)
 	{
 		
 		String institutionType=allParams.get("typeofInstitution");
		String returnstatement="";
 		
		if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("faculty")) {
			System.out.println("faculty");
		boolean isSubmited = false;
		List<Criteria6_FieldInfo> criteria6Data = getAllCriteria6Data(allParams);
		if(criteria6Data != null && CollectionUtils.isNotEmpty(criteria6Data)) {
			if("save".equalsIgnoreCase(criteria6Data.get(0).getCriteria61Ql().get(0).getCriteria61status()) && 
			"save".equalsIgnoreCase(criteria6Data.get(0).getCriteria62Ql().get(0).getCriteria62status())&&
			"save".equalsIgnoreCase(criteria6Data.get(0).getCriteria63Ql().get(0).getCriteria63status())&&
			"save".equalsIgnoreCase(criteria6Data.get(0).getCriteria64Qn().get(0).getCriteria64status())&&
             "save".equalsIgnoreCase(criteria6Data.get(0).getCriteria65Qn().get(0).getCriteria65status()))
			{
				
				isSubmited = true;
			
			}
		}
		if(isSubmited) {
 		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
 			trackingService.sendAutonomousCriteria6Email(allParams);
 		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
 			System.out.println("aff controller");
 			trackingService.sendAffiliatedCriteria6Email(allParams);
 		}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
 			System.out.println("22222");
 			trackingService.sendUniversityCriteria6Email(allParams);
 		}
		}
		}
		else if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("ROLE_DEAN"))
		{
			
			if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
	 			trackingService.sendAutonomousCriteria6Email(allParams);
	 		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
	 			System.out.println("aff controller");
	 			trackingService.sendAffiliatedCriteria6Email(allParams);
	 		}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
	 			System.out.println("22222");
	 			trackingService.sendUniversityCriteria6Email(allParams);
	 		}	
			
		}
 		
		return returnstatement;
 		
 	}
 	
 	
 	
 	
    public Criteria6_FieldInfo criteria6Info( Criteria6_FieldInfo criteria6Fieldinfo, MultipartFile[] uploadfile6)
	 {
	
    	try {
    		ObjectMapper mapper=new ObjectMapper();
			//System.out.println("valuesuploadfile6====>" +mapper.writeValueAsString(uploadfile6));
    		
    		System.out.println("criteria6upload==>"+uploadfile6.length);
	log.info("uploadfile========="+uploadfile6.length);
	log.info("employee info==="+criteria6Fieldinfo);
	List<Criteria6_FileUpload> file6 = new ArrayList<>();
     System.out.println("Criteria6_FileUpload");
	
	for (int i = 0; i < uploadfile6.length; i++) {
		// Get the filename and build the local file path
		String filename = uploadfile6[i].getOriginalFilename();
		log.info("File name is : "+filename);
		//String directory = this.dirLocation;
		Path dfile = this.dirLocation.resolve(filename);
		String filepath = dfile.toString();	   
		log.info("path:"+filepath);
		// =============Save the file locally====================
		BufferedOutputStream stream =
				new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		
			stream.write(uploadfile6[i].getBytes());
		
		stream.close();
		
		String param=filename.substring(0,filename.indexOf("-"));
		
		Criteria6_FileUpload fileUpload6 = new Criteria6_FileUpload();
	
		fileUpload6.setUniqueKey1(param.concat("-"+criteria6Fieldinfo.getCriteriaId().getFinancialYear()));
		fileUpload6.setCriteria6FileName(filename);
		fileUpload6.setCriteria6FilePath(filepath);
		fileUpload6.setCriteria6FileType(uploadfile6[i].getContentType()); 
		fileUpload6.setCriteriaId(criteria6Fieldinfo.getCriteriaId());
		
		file6.add(fileUpload6);
		
	}
	criteria6Fieldinfo.setCriteria6FileUpload(file6);
	
//	String institutionType=criteria6Fieldinfo.getCriteriaId().getTypeofInstitution();
//
//	
//	if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
//		trackingService.sendAutonomousCriteria6Email(criteria6Fieldinfo);
//	}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
//		System.out.println("aff controller");
//		trackingService.sendAffiliatedCriteria6Email(criteria6Fieldinfo);
//	}else if(institutionType != null && "universities".equalsIgnoreCase(institutionType)) {
//		System.out.println("22222");
//		trackingService.sendUniversityCriteria6Email(criteria6Fieldinfo);
//	}
	
	
//	trackingService.sendAutonomousCriteria1Email(null);

	
	return criteria6Repository.save(criteria6Fieldinfo);
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
    
	  public List<Criteria6_FieldInfo> getAllCriteria6Data(Map<String, String> allParams) {
		    try {
		    	
		    	ObjectMapper mapper = new ObjectMapper();

		      List<Criteria6_FieldInfo> criteria6 = new ArrayList<Criteria6_FieldInfo>();
		     CriteriaPrimaryKey id=new CriteriaPrimaryKey();
		     id.setCollegeId(allParams.get("collegeId"));
				id.setFinancialYear(allParams.get("financialYear"));
				id.setTypeofInstitution(allParams.get("typeofInstitution"));
				
				
				 Optional<Criteria6_FieldInfo> academic2 = criteria6Repository.findById(id);
					
					System.out.println("options ==>"+mapper.writeValueAsString(academic2));
					if (academic2.isPresent()) {
						criteria6.add(academic2.get());
					}
					System.out.println("list object =="+mapper.writeValueAsString(criteria6));
					return criteria6;

				} catch (Exception e) {
					return null;
				}

			}
		      
//		      criteria6Repository.findAll().forEach(criteria6::add);
//		   
//		      return criteria6;
//		    
//		   
//		  }catch (Exception e) { return null;
//		  }
//		  }
	  
	  
	  
	  public List<Criteria6_FieldInfo> getAllCriteria6Data() {
		    try {
		      List<Criteria6_FieldInfo> criteria6 = new ArrayList<Criteria6_FieldInfo>();
		      
		      criteria6Repository.findAll().forEach(criteria6::add);
		   
		      return criteria6;
		    
		   
		  }catch (Exception e) { return null;
		  }
		  }
	  

		
		
		
}
    

