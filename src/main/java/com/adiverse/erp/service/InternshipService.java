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
import com.adiverse.erp.model.InternshipFileupload;
import com.adiverse.erp.model.InternshipForm_WB;
import com.adiverse.erp.repository.InternshipRepository;

@Service
@Transactional
public class InternshipService
{
	@Autowired
	private  InternshipRepository internshipRepository;
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

  
	public InternshipForm_WB internshipInfo(InternshipForm_WB internshipForm , MultipartFile[] internshipfiles)
			 {
    		
    	try {
    		log.info("uploadfile========="+internshipfiles.length);
    		log.info("employee info==="+internshipForm);
    		List<InternshipFileupload> internFile = new ArrayList<>();
    	
    		internshipForm.setInternship_id(new Integer(6).longValue());
    		for (int i = 0; i < internshipfiles.length; i++) {
    			// Get the filename and build the local file path
    			String filename = internshipfiles[i].getOriginalFilename();
    			log.info("File name is : "+filename);
    			String directory = "C:\\seema\\FileUpload";
    			String filepath = Paths.get(directory, filename).toString();	   
    			
    			// =============Save the file locally====================
    			BufferedOutputStream stream =
    					new BufferedOutputStream(new FileOutputStream(new File(filepath)));
    			
    				stream.write(internshipfiles[i].getBytes());
    			
    			stream.close();
    			
    			// save it into file_upload_details table DB
    			//String path = "C:\\Users\\risha\\Desktop\\uploads\\"; tb
    			InternshipFileupload internshipFile = new InternshipFileupload();
    			internshipFile.setInternship_fileName(filename);
    			internshipFile.setInternship_filePath(filepath);
    			internshipFile.setInternship_fileType(internshipfiles[i].getContentType());
    			

    			internFile.add(internshipFile);
    			
    		}
    		internshipForm.setInternshipFileupload(internFile);
    		
    		

//    		log.info("employee details are"+employee);
//    		_tutorial = inputRepository.save(employee);
    		}catch (Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return internshipRepository.save(internshipForm);

	}
	
	
//	public Optional<Criteria1_FileUpload> getFile(Long fileId)
//	{
//		return criteria1fileUploadRepository.findById(fileId);
//	}
	

	  public List<InternshipForm_WB> getAllInternshipFiles() {
	    try {
	      List<InternshipForm_WB> internship = new ArrayList<InternshipForm_WB>();
	     
	      internshipRepository.findAll().forEach(internship::add);
	   
	      return internship;
	    
	   
	  }catch (Exception e) { return null;}
		
  
    
}
}
    

