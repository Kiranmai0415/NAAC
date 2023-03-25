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

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.exception.FileStorageException;
import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.Criteria3_FileUpload;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FileUploadProperties;
import com.adiverse.erp.model.Tracking;
//import com.adiverse.erp.openpdf.AffilatedCriteria3Report;
//import com.adiverse.erp.openpdf.AutonomousCriteria3Report;
//import com.adiverse.erp.openpdf.UniversityCriteria3Report;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.TrackingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;




@Service
@Transactional
public class Criteria3Service {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    private Path dirLocation;
    
    @Autowired
    private Criteria3Repository criteria3Repository;
    
    @Autowired
	private TrackingRepository trackingRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
//	@Autowired
//	private AutonomousCriteria3Report autonomousCriteria3Report;
//	
//	
//	@Autowired
//	private AffilatedCriteria3Report  affilatedCriteria3Report;
	
	@Autowired
	private TrackingService  trackingService; 
	
	
	
	

    
    @Autowired 
    public Criteria3Service(FileUploadProperties fileUploadProperties) {
        this.dirLocation = Paths.get(fileUploadProperties.getLocation())
                                .toAbsolutePath()
                                .normalize();
    }
    public Criteria3Service(JavaMailSender javaMailSender) {
 		this.javaMailSender = javaMailSender;
 	}
 	
 	public Tracking authorizedInfo(Tracking tracking) {

 		return trackingRepository.save(tracking);

 	}
    
 	public String  criteria3Info(Map<String, String> allParams)
 	{
 		String institutionType=allParams.get("typeofInstitution");
 		String returnstatement="";
 		

		if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("faculty")) {
			System.out.println("faculty");
		boolean isSubmited = false;
		List<Criteria3_FieldInfo> criteria3Data = getAllCriteria3Data(allParams);
		System.out.println("===>>>"+criteria3Data.get(0).getCriteria31Ql().get(0).getCriteria31status());
		System.out.println(criteria3Data.get(0).getCriteria32Qn().get(0).getCriteria32status());

		System.out.println(criteria3Data.get(0).getCriteria33Qn().get(0).getCriteria33status());

		System.out.println(criteria3Data.get(0).getCriteria34Qn().get(0).getCriteria34status());

		System.out.println(criteria3Data.get(0).getCriteria35Qn().get(0).getCriteria35status());

		System.out.println(criteria3Data.get(0).getCriteria36Qn().get(0).getCriteria36status());
        System.out.println(criteria3Data.get(0).getCriteria37Qn().get(0).getCriteria37status());
		
		
		
		
		if(criteria3Data != null && CollectionUtils.isNotEmpty(criteria3Data)) {
			if("save".equalsIgnoreCase(criteria3Data.get(0).getCriteria31Ql().get(0).getCriteria31status()) && 
					"save".equalsIgnoreCase(criteria3Data.get(0).getCriteria32Qn().get(0).getCriteria32status())&&
					"save".equalsIgnoreCase(criteria3Data.get(0).getCriteria33Qn().get(0).getCriteria33status())&&
		             "save".equalsIgnoreCase(criteria3Data.get(0).getCriteria34Qn().get(0).getCriteria34status())&&
		             "save".equalsIgnoreCase(criteria3Data.get(0).getCriteria35Qn().get(0).getCriteria35status())&&
		             "save".equalsIgnoreCase(criteria3Data.get(0).getCriteria36Qn().get(0).getCriteria36status())&&
		             "save".equalsIgnoreCase(criteria3Data.get(0).getCriteria37Qn().get(0).getCriteria37status())
					   ) 
					{
						
						isSubmited = true;
					
					}
			
			
			
			
		if(isSubmited) {
		System.out.println("criteria1Info");
		System.out.println(institutionType);
 		
 		
 		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {	
 			returnstatement=trackingService.sendAutonomousCriteria3Email(allParams);
 			}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
 				returnstatement=trackingService.sendAffiliatedCriteria3Email(allParams);
 			}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
 				System.out.println("criteria3Fieldinfo================>"+allParams);
 				returnstatement=trackingService.sendUniversityCriteria3Email(allParams);
 			}
		}
		}
		}
		
		else if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("ROLE_DEAN"))
		{
			System.out.println("<===ROLE_DEAN===>");
			if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
				returnstatement=trackingService.sendAutonomousCriteria3Email(allParams);
			}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
				returnstatement=trackingService.sendAffiliatedCriteria3Email(allParams);
			}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
				returnstatement=trackingService.sendUniversityCriteria3Email(allParams);
			}
			
			
		}
 		
 		return returnstatement;
 	}
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	//String directory = dirLocation;
 	
    
    public Criteria3_FieldInfo criteria3Info( Criteria3_FieldInfo criteria3Fieldinfo, MultipartFile[] uploadfile3)
	 {
	
    	try {
    		ObjectMapper mapper=new ObjectMapper();
    		System.out.println("values===>" +mapper.writeValueAsString(criteria3Fieldinfo));
	log.info("uploadfile========="+uploadfile3.length);
	log.info("employee info==="+criteria3Fieldinfo);
	System.out.println("criteria3 file"+criteria3Fieldinfo.getYearTable3131());
	List<Criteria3_FileUpload> file3 = new ArrayList<>();

	for (int i = 0; i < uploadfile3.length; i++) {
		// Get the filename and build the local file path
		String filename = uploadfile3[i].getOriginalFilename();
		log.info("File name is"+filename);
		//String directory = this.dirLocation;
		Path dfile = this.dirLocation.resolve(filename);
		String filepath = dfile.toString();	   
		log.info("path:"+filepath);
		// =============Save the file locally====================
		BufferedOutputStream stream =
				new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		
			stream.write(uploadfile3[i].getBytes());
		
		stream.close();
		
		String param=filename.substring(0, filename.indexOf("-"));
		Criteria3_FileUpload fileUpload3 = new Criteria3_FileUpload();
	
			//fileUpload3.setCriteria3_file_id(file3.get(i).getCriteria3_file_id());
		
		    fileUpload3.setUniqueKey1(param.concat("-"+criteria3Fieldinfo.getCriteriaId().getFinancialYear()));
			fileUpload3.setCriteria3FileName(filename);
			fileUpload3.setCriteria3FilePath(filepath);
			fileUpload3.setCriteria3FileType(uploadfile3[i].getContentType()); 
			fileUpload3.setCriteriaId(criteria3Fieldinfo.getCriteriaId());
		
		
		file3.add(fileUpload3);
		
	}
	
	criteria3Fieldinfo.setCriteria3FileUpload(file3);

	
//	if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
//		
//		
//			
//		trackingService.sendAutonomousCriteria3Email(criteria3Fieldinfo);
//		//	((Criteria1_FileUpload) criteria1Fieldinfo.getCriteria1FileUpload()).getCriteria1FilePath();
//		
//			
//		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
//			trackingService.sendAffiliatedCriteria3Email(criteria3Fieldinfo);
//		}else if(institutionType != null && "universities".equalsIgnoreCase(institutionType)) {
//			System.out.println("criteria3Fieldinfo================>"+criteria3Fieldinfo);
//			trackingService.sendUniversityCriteria3Email(criteria3Fieldinfo);
//		}
//	
//	
//	
	System.out.println("criteria3Repository");
    	return criteria3Repository.save(criteria3Fieldinfo);

    	}
    	catch (Exception e) {
    	e.printStackTrace();
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
    
	  public List<Criteria3_FieldInfo> getAllCriteria3Data(Map<String, String> allParams) {
		    try {
		    	
		    	ObjectMapper mapper = new ObjectMapper();
				System.out.println("allParams=========="+allParams);
				
				
		      List<Criteria3_FieldInfo> criteria3 = new ArrayList<Criteria3_FieldInfo>();
		      CriteriaPrimaryKey id = new CriteriaPrimaryKey();
				id.setCollegeId(allParams.get("collegeId"));
				id.setFinancialYear(allParams.get("financialYear"));
				id.setTypeofInstitution(allParams.get("typeofInstitution"));
				System.out.println("options ==>"+mapper.writeValueAsString(id));
				
         Optional<Criteria3_FieldInfo> academic2 = criteria3Repository.findById(id);
				
				System.out.println("options ==>"+mapper.writeValueAsString(academic2));
				if (academic2.isPresent()) {
					criteria3.add(academic2.get());
				}
				System.out.println("list object =="+mapper.writeValueAsString(criteria3));
				return criteria3;

			} catch (Exception e) {
				return null;
			}

		}
		
		      
		      
//		      criteria3Repository.findAll().forEach(criteria3::add);
//		   
//		      return criteria3;
//		    
//		   
//		  }catch (Exception e) { return null;
//		  }
//		  }
	  
	  
	  
	  
	  
	  public List<Criteria3_FieldInfo> getAllCriteria3Data() {
		    try {
		      List<Criteria3_FieldInfo> criteria3 = new ArrayList<Criteria3_FieldInfo>();
		      criteria3Repository.findAll().forEach(criteria3::add);
		   
		      return criteria3;
		    
		   
		  }catch (Exception e) { return null;
		  }
		  }
	
	  
	  
		
		
	
			
			
		  
		  
}