package com.adiverse.erp.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.adiverse.erp.model.AdmissionFileupload;
import com.adiverse.erp.model.AdmissionForm_WB;
import com.adiverse.erp.repository.AdminFormRepository;

@Service
@Transactional
public class AdminService
{
	@Autowired
	private AdminFormRepository adminformRepository;
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

  
	public AdmissionForm_WB adminInfo( AdmissionForm_WB admissionForm, MultipartFile[] uploadfileadmin)
			 {
    		
    	try {
    		log.info("uploadfile========="+uploadfileadmin.length);
    		log.info("employee info==="+admissionForm);
    		List<AdmissionFileupload> adminFile = new ArrayList<>();
    	
    		admissionForm.setAdmissionform_id(new Integer(6).longValue());
    		for (int i = 0; i < uploadfileadmin.length; i++) {
    			// Get the filename and build the local file path
    			String filename = uploadfileadmin[i].getOriginalFilename();
    			log.info("File name is : "+filename);
    			String directory = "C:\\seema\\FileUpload";
    			String filepath = Paths.get(directory, filename).toString();	   
    			
    			// =============Save the file locally====================
    			BufferedOutputStream stream =
    					new BufferedOutputStream(new FileOutputStream(new File(filepath)));
    			
    				stream.write(uploadfileadmin[i].getBytes());
    			
    			stream.close();
    			
    			// save it into file_upload_details table DB
    			//String path = "C:\\Users\\risha\\Desktop\\uploads\\"; tb
    			AdmissionFileupload adminFile1 = new AdmissionFileupload();
    			adminFile1.setAdmin_fileName(filename);
    			adminFile1.setAdmin_filePath(filepath);
    			adminFile1.setAdmin_fileType(uploadfileadmin[i].getContentType());
    			

    			adminFile.add(adminFile1);
    			
    		}
    		admissionForm.setAdmissionFileupload(adminFile);
    		
    		

//    		log.info("employee details are"+employee);
//    		_tutorial = inputRepository.save(employee);
    		}catch (Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return adminformRepository.save(admissionForm);

	}
	
	
//	public Optional<Criteria1_FileUpload> getFile(Long fileId)
//	{
//		return criteria1fileUploadRepository.findById(fileId);
//	}
	

	  public List<AdmissionForm_WB> getAllAdminFiles() {
	    try {
	      List<AdmissionForm_WB> admin = new ArrayList<AdmissionForm_WB>();
	     
	      adminformRepository.findAll().forEach(admin::add);
	   
	      return admin;
	    
	   
	  }catch (Exception e) { return null;}
		
  
    
}
}
    

