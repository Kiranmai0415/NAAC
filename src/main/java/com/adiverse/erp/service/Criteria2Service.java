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
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria2_FileUpload;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FileUploadProperties;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.repository.Criteria2Repository;
import com.adiverse.erp.repository.TrackingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
@Transactional
public class Criteria2Service {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    private Path dirLocation;
    
    @Autowired
    private Criteria2Repository criteria2Repository;
    
    @Autowired
	private TrackingRepository trackingRepository;
    
    @Autowired 
    private TrackingService trackingService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
//	@Autowired
//	private AutonomousCriteria2Report autonomousCriteria2Report;
//	
//	
//	@Autowired
//	private AffiliatedCriteria2Report   affiliatedCriteria2Report;
//	
//	@Autowired
//	private UniversityCriteria2Report universityCriteria2Report;
    
	
    @Autowired 
    public Criteria2Service(FileUploadProperties fileUploadProperties) {
        this.dirLocation = Paths.get(fileUploadProperties.getLocation())
                                .toAbsolutePath()
                                .normalize();
    }
    public Criteria2Service(JavaMailSender javaMailSender) {
 		this.javaMailSender = javaMailSender;
 	}
 	
 	public Tracking authorizedInfo(Tracking tracking) {

 		return trackingRepository.save(tracking);

 	}
    //String directory = dirLocation;
 	
 	
 	
     public String criteria2Info(Map<String, String> allParams)
 	{
    	 System.out.println("data======");
    	 String institutionType=allParams.get("typeofInstitution");
    		String returnstatement="";
 		if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("faculty")) {
 		System.out.println("faculty");
    	
    		boolean isSubmited = false;
    		List<Criteria2_FieldInfo>criteria2Data = getAllCriteria2Data(allParams);
    		System.out.println("====>>>"+criteria2Data.get(0).getCriteria21Qn().get(0).getCriteria21status());
    		System.out.println(criteria2Data.get(0).getCriteria22Qn().get(0).getCriteria22status());
    		System.out.println(criteria2Data.get(0).getCriteria23Ql().get(0).getCriteria23status());
    		System.out.println(criteria2Data.get(0).getCriteria24Qn().get(0).getCriteria24status());
    		System.out.println(criteria2Data.get(0).getCriteria25Qn().get(0).getCriteria25status());
    		System.out.println(criteria2Data.get(0).getCriteria26Qn().get(0).getCriteria26status());
    		System.out.println(criteria2Data.get(0).getCriteria27Ql().get(0).getCriteria27status());
    		
    		if(criteria2Data != null && CollectionUtils.isNotEmpty(criteria2Data)) {
    			if("save".equalsIgnoreCase(criteria2Data.get(0).getCriteria21Qn().get(0).getCriteria21status()) && 
    			"save".equalsIgnoreCase(criteria2Data.get(0).getCriteria22Qn().get(0).getCriteria22status())&&
    			"save".equalsIgnoreCase(criteria2Data.get(0).getCriteria23Ql().get(0).getCriteria23status())&&
                 "save".equalsIgnoreCase(criteria2Data.get(0).getCriteria24Qn().get(0).getCriteria24status())&&
                 "save".equalsIgnoreCase(criteria2Data.get(0).getCriteria25Qn().get(0).getCriteria25status())&&
                 "save".equalsIgnoreCase(criteria2Data.get(0).getCriteria26Qn().get(0).getCriteria26status())&&
                 "save".equalsIgnoreCase(criteria2Data.get(0).getCriteria27Ql().get(0).getCriteria27status())
    			   ) 
    			{
    				
    				isSubmited = true;
    			
    			}
    		}
    		System.out.println("isSubmited"+isSubmited);
    		if(isSubmited) {
	    		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
	    			returnstatement=trackingService.sendAutonomousCriteria2Email(allParams);
	    		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
	    			returnstatement=trackingService.sendAffiliatedCriteria2Email(allParams);
	    		}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
	    			returnstatement=trackingService.sendUniversityCriteria2Email(allParams);
	    		}
    		}
 		
 		}
 		else if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("ROLE_DEAN"))
		{
 			
 			if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
    			returnstatement=trackingService.sendAutonomousCriteria2Email(allParams);
    		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
    			returnstatement=trackingService.sendAffiliatedCriteria2Email(allParams);
    		}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
    			returnstatement=trackingService.sendUniversityCriteria2Email(allParams);
    		}
 			
		}
 		
    		
    		
 		return 	returnstatement;
 		
 	}
    
    public Criteria2_FieldInfo criteria2Info( Criteria2_FieldInfo criteria2Fieldinfo, MultipartFile[] uploadfile2)
	 {
	
    	try {
    		ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(criteria2Fieldinfo));
	log.info("uploadfile========="+uploadfile2.length);
	log.info("employee info==="+criteria2Fieldinfo);
	List<Criteria2_FileUpload> file2 = new ArrayList<>();

	
	for (int i = 0; i < uploadfile2.length; i++) {
		// Get the filename and build the local file path
		String filename = uploadfile2[i].getOriginalFilename();
		log.info("File name is : "+filename);
		//String directory = this.dirLocation;
		Path dfile = this.dirLocation.resolve(filename);
		String filepath = dfile.toString();	   
		log.info("path:"+filepath);
		// =============Save the file locally====================
		BufferedOutputStream stream =
				new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		
			stream.write(uploadfile2[i].getBytes());
		
		stream.close();
		
		String param=filename.substring(0,filename.indexOf("-"));
		
		Criteria2_FileUpload fileUpload2 = new Criteria2_FileUpload();
		fileUpload2.setUniqueKey1(param.concat("-"+criteria2Fieldinfo.getCriteriaId().getFinancialYear()));
		fileUpload2.setCriteria2FileName(filename);
		fileUpload2.setCriteria2FilePath(filepath);
		fileUpload2.setCriteria2FileType(uploadfile2[i].getContentType()); 
		fileUpload2.setCriteriaId(criteria2Fieldinfo.getCriteriaId());
		
		file2.add(fileUpload2);
		
	}
	
	criteria2Fieldinfo.setCriteria2FileUpload(file2);
//	trackingService.sendUniversityCriteria2Email();
	
//	String institutionType=criteria2Fieldinfo.getCriteriaId().getTypeofInstitution();
//	
//	ObjectMapper mapper1= new ObjectMapper();
//	
//	System.out.println("object==>" + mapper1.writeValueAsString(criteria2Fieldinfo));
//	
//	
//	if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
//		
//		
//		trackingService.sendAutonomousCriteria2Email(criteria2Fieldinfo);
//		
//		
//		
//	}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
//		trackingService.sendAffiliatedCriteria2Email(criteria2Fieldinfo);
//	}else if(institutionType != null && "universities".equalsIgnoreCase(institutionType)) {
//		
//		
//		trackingService.sendUniversityCriteria2Email(criteria2Fieldinfo);
//	}

	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
    	System.out.println("criteria2Fieldinfo");
    	return criteria2Repository.save(criteria2Fieldinfo);

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
    
	  public List<Criteria2_FieldInfo> getAllCriteria2Data(Map<String, String> allParams) {
		    try {
		    	
		    	ObjectMapper mapper = new ObjectMapper();
				System.out.println("allParams=========="+allParams);
				
		      List<Criteria2_FieldInfo> criteria2 = new ArrayList<Criteria2_FieldInfo>();
		     
		      CriteriaPrimaryKey id = new CriteriaPrimaryKey();
				id.setCollegeId(allParams.get("collegeId"));
				id.setFinancialYear(allParams.get("financialYear"));
				id.setTypeofInstitution(allParams.get("typeofInstitution"));
		        System.out.println("id object is--->"+mapper.writeValueAsString(id));
				Optional<Criteria2_FieldInfo> academic2 = criteria2Repository.findById(id);
				
				System.out.println("options ==>"+mapper.writeValueAsString(academic2));
				if (academic2.isPresent()) {
					criteria2.add(academic2.get());
				}
				System.out.println("list object =="+mapper.writeValueAsString(criteria2));
				return criteria2;

			} catch (Exception e) {
				return null;
			}

		}
		
				
				
		      
//		      criteria2Repository.findAll().forEach(criteria2::add);
//		   
//		      return criteria2;
//		    
//		   
//		  }catch (Exception e) { return null;
//		  }
//		  }
	  
	  
	  
	  
	  
	  public List<Criteria2_FieldInfo> getAllCriteria2Data() {
		    try {
		      List<Criteria2_FieldInfo> criteria2 = new ArrayList<Criteria2_FieldInfo>();
		     
		      criteria2Repository.findAll().forEach(criteria2::add);
		   
		      return criteria2;
		    
		   
		  }catch (Exception e) { return null;
		  }
		  }
	  
	  
	  
	  
	  
	

}
    

