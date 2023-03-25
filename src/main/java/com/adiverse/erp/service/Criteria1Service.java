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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.exception.FileStorageException;
import com.adiverse.erp.model.AssignEmail;
import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria1_FileUpload;
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.GeneralParameter;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.repository.AssignEmailRepository;
import com.adiverse.erp.repository.Criteria1Repository;
import com.adiverse.erp.repository.TrackingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class Criteria1Service {

	private final Logger logger = LoggerFactory.getLogger(Criteria1Service.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Value("${excel.templates.path}")
	private String excelTemplatesPath;
	
	@Autowired
	private Criteria1Repository criteria1Repository;

	@Autowired
	private AssignEmailRepository assignEmailRepository;
	
	@Autowired
	private TrackingRepository trackingRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private TrackingService  trackingService; 
	
	public Criteria1Service(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public Tracking authorizedInfo(Tracking tracking) {

		return trackingRepository.save(tracking);

	}

	// String directory = dirLocation;
	public String criteria1Info(Map<String, String> allParams)
	{
		String institutionType=allParams.get("typeofInstitution");
		
		ObjectMapper mapper=new ObjectMapper();
		try {
			System.out.println("role====>"+mapper.writeValueAsString(allParams));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String returnstatement="";
		
		if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("faculty")) {
			System.out.println("criteria1 faculty");
		boolean isSubmited = false;
		List<Criteria1_FieldInfo> criteria1Data = getAllCriteria1Data(allParams);
		System.out.println("===>"+criteria1Data.get(0).getCriteria11Qn().get(0).getCriteria11status());
		System.out.println(criteria1Data.get(0).getCriteria12Qn().get(0).getCriteria12status());
		System.out.println(criteria1Data.get(0).getCriteria13Ql().get(0).getCriteria13status());
		System.out.println("===>"+criteria1Data.get(0).getCriteria14Qn().get(0).getCriteria14status());
		
		
		
		if(criteria1Data != null && CollectionUtils.isNotEmpty(criteria1Data)) {
			if("save".equalsIgnoreCase(criteria1Data.get(0).getCriteria11Qn().get(0).getCriteria11status()) && 
			"save".equalsIgnoreCase(criteria1Data.get(0).getCriteria12Qn().get(0).getCriteria12status())&&
			"save".equalsIgnoreCase(criteria1Data.get(0).getCriteria13Ql().get(0).getCriteria13status())&&
             "save".equalsIgnoreCase(criteria1Data.get(0).getCriteria14Qn().get(0).getCriteria14status()))
			{
			
				isSubmited = true;
			System.out.println("isSubmited=====>>"+isSubmited);
			
			}
		}
		if(isSubmited) {
		
		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			returnstatement=trackingService.sendAutonomousCriteria1Email(allParams);
		}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
			returnstatement=trackingService.sendAffiliatedCriteria1Email(allParams);
		}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
			returnstatement=trackingService.sendUniversityCriteria1Email(allParams);
		}
		}
		
		
		}
		else if( allParams.get("role")!=null&&allParams.get("role").equalsIgnoreCase("ROLE_DEAN"))
		{
			System.out.println("<===ROLE_DEAN===>");
			if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
				returnstatement=trackingService.sendAutonomousCriteria1Email(allParams);
			}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
				returnstatement=trackingService.sendAffiliatedCriteria1Email(allParams);
			}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
				returnstatement=trackingService.sendUniversityCriteria1Email(allParams);
			}
			
			
		}
			return returnstatement;
	
		
	}

	public Criteria1_FieldInfo criteria1Info(Criteria1_FieldInfo criteria1Fieldinfo, MultipartFile[] uploadfile1) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(criteria1Fieldinfo));
			logger.info("uploadfile=========" + uploadfile1.length);
			logger.info("employee info===" + criteria1Fieldinfo);
			List<Criteria1_FileUpload> file1 = new ArrayList<>();
			
			

			for (int i = 0; i < uploadfile1.length; i++) {
				// Get the filename and build the local file path
				String filename = uploadfile1[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(uploadfile1[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				Criteria1_FileUpload fileUpload1 = new Criteria1_FileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+criteria1Fieldinfo.getCriteriaId().getFinancialYear()));
				fileUpload1.setCriteria1FileName(filename);
				fileUpload1.setCriteria1FilePath(filepath);
				fileUpload1.setCriteria1FileType(uploadfile1[i].getContentType());
				fileUpload1.setCriteriaId(criteria1Fieldinfo.getCriteriaId());

				file1.add(fileUpload1);

			}
			criteria1Fieldinfo.setCriteria1FileUpload(file1);
			//add email 
			
			
//			String institutionType=criteria1Fieldinfo.getCriteriaId().getTypeofInstitution();
//			String financialYear=criteria1Fieldinfo.getCriteriaId().getFinancialYear();
//			String collegeId=criteria1Fieldinfo.getCriteriaId().getCollegeId();
//			
//			Map<String, String> allParams = new HashMap<String, String>();
//			allParams.put("collegeId", collegeId);
//			allParams.put("financialYear", financialYear);
//			allParams.put("typeofInstitution", institutionType);
//
//			trackingService.sendAutonomousCriteria1Email(allParams);
//			
//			String institutionType=criteria1Fieldinfo.getCriteriaId().getTypeofInstitution();
//		criteria1Fieldinfo.getCriteriaId().getTypeofInstitution().get 
//			
//         trackingService.sendAutonomousCriteria1Email(criteria1Fieldinfo);
//			Criteria1_FieldInfo s1;
//			s1 = criteria1Repository.save(criteria1Fieldinfo);
//			trackingService.sendUniversityCriteria1Email(criteria1Fieldinfo);
//			ObjectMapper mapper1=new ObjectMapper();
//			System.out.println("object of the 1st controler===."+ mapper1.writeValueAsString(criteria1Fieldinfo));
//			
//			if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
//				
//				
//			
//				
//			trackingService.sendAutonomousCriteria1Email(criteria1Fieldinfo);
//			
//			
//			
//				((Criteria1_FileUpload) criteria1Fieldinfo.getCriteria1FileUpload()).getCriteria1FilePath();
//					
//			}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
//				trackingService.sendAffiliatedCriteria1Email(criteria1Fieldinfo);
//			}else if(institutionType != null && "universities".equalsIgnoreCase(institutionType)) {
//				trackingService.sendUniversityCriteria1Email(criteria1Fieldinfo);
//			}
//			
			
			
			
	System.out.println("criteria1Repository.save");

		return criteria1Repository.save(criteria1Fieldinfo);

		} catch (Exception e) {
			System.out.println(e.getMessage());
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

	public Resource loadFile(String fileName) {
		logger.info("excelTemplatesPath==>{}",excelTemplatesPath);
		Path path = Paths.get(excelTemplatesPath + fileName);
		try {
			logger.info("path.toUri()=========>{}",path.toUri());
			Resource resource = new UrlResource(path.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new FileStorageException("Could not download file");
			}
		} catch (MalformedURLException e) {
			throw new FileStorageException("Could not download file");
		}
	}

	public List<Criteria1_FieldInfo> getAllCriteria1Data(Map<String, String> allParams) {
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("allParams=========="+allParams);
			
			List<Criteria1_FieldInfo> criteria1 = new ArrayList<Criteria1_FieldInfo>();
            CriteriaPrimaryKey id =new CriteriaPrimaryKey();
            id.setCollegeId(allParams.get("collegeId"));
            id.setFinancialYear(allParams.get("financialYear"));
			id.setTypeofInstitution(allParams.get("typeofInstitution"));
			
			
			
			System.out.println("id object is--->"+mapper.writeValueAsString(id));
			Optional<Criteria1_FieldInfo> academic2 = criteria1Repository.findById(id);
			
			System.out.println("options ==>"+mapper.writeValueAsString(academic2));
			if (academic2.isPresent()) {
				criteria1.add(academic2.get());
			}
			System.out.println("list object =="+mapper.writeValueAsString(criteria1));
			return criteria1;

		} catch (Exception e) {
			return null;
		}

	}
	
	
	public List<Criteria1_FieldInfo> getAllCriteria1Data () {
		try {
			List<Criteria1_FieldInfo> criteria1 = new ArrayList<Criteria1_FieldInfo>();
				criteria1Repository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	
	
	

	/*
	 * public Resource load(String filename) { try { Path file =
	 * root.resolve(filename); Resource resource = new UrlResource(file.toUri()); if
	 * (resource.exists() || resource.isReadable()) { return resource; } else {
	 * throw new RuntimeException("Could not read the file!"); } } catch (Exception
	 * e) { throw new RuntimeException("Error: " + e.getMessage()); } }
	 */

	public AssignEmail assign1Info(AssignEmail assignEmail) {

		return assignEmailRepository.save(assignEmail);

	}
	
	

	public String sendCriteria1AssignEmail(AssignEmail assignemail) {
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		ObjectMapper mapper = new ObjectMapper();

		try {
			logger.info("assignemail object is ==>{}",mapper.writeValueAsString(assignemail));
			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(assignemail.getEmailAddress());
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			mimeMessageHelper.setText("<html><body> Hello "+assignemail.getEmailAddress()+",<br> This " + assignemail.getCriteria()
					+ "is assigned to you.<br> Please complete this before " + assignemail.getExpiryDate() + "."
					+ "<br><br>- Adiverse ERP Portal.</body></html>", true);

			mimeMessageHelper.setSubject("Criterion Assignment Email");

			javaMailSender.send(mimeMessage);
			logger.info("Mail has been sent successfully");
			return "Mail sent Successfully";
		}

		// Catch block to handle MessagingException
		catch (Exception e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	

	public String sendAuthorizedEmail1(GeneralParameter generalParameter) {

		GeneralParameter obj = new GeneralParameter();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		// HttpSession session = request.getSession(true);

		try {

			// Setting multipart as true for attachments to
			// be send
			System.out.println(obj.getGeneral().get("seema"));
			String email = obj.getGeneral().get("seema");
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(email);
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			mimeMessageHelper.setText("<html><body> Please, review this report</body></html>", true);

			mimeMessageHelper.setSubject("NAAC report");

			// Adding the attachment
			FileSystemResource file = new FileSystemResource(
					new File("D:\\STSWorkspace\\springboot-backend\\Upload\\Doc2.docx"));

			mimeMessageHelper.addAttachment(file.getFilename(), file);

			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		// Catch block to handle MessagingException
		catch (Exception e) {
			System.out.println(e);
			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	
	
	
//	public Criteria1_FieldInfo criteria1_FieldInfo(Criteria1_FieldInfo criteria1_FieldInfo) {
//
//		Criteria1_FieldInfo s1 = null;
//		s1 = criteria1Repository.save(criteria1_FieldInfo);
//		trackingService.sendUniversityCriteria1Email();
//
//		return s1;
//
//	}
//	
	
	

}
