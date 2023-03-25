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

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.exception.FileStorageException;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.model.QIAIndicatorMain;
import com.adiverse.erp.model.QIAIndicator_FileUpload;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.openpdf.IiqaReport;
import com.adiverse.erp.repository.QiaRepository;
import com.adiverse.erp.repository.TrackingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class QiaService {
	@Autowired
	private QiaRepository qiaRepository;

	private final Logger logger = LoggerFactory.getLogger(QiaService.class);
	
	@Value("${upload.files.path}")
	private String uploadFilePath;
	
	
	@Autowired
	private IiqaReport  iiqaReport;
	
	
	@Autowired
	private TrackingRepository trackingRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private TrackingService trackingService;
	
	
	
//	private final String uploadPath = "C:\\SRINI\\STSWorkspace\\UploadFiles";
//	@PostConstruct
//    public void init() {
//        try {
//            Files.createDirectories(Paths.get(uploadPath));
//        } catch (IOException e) {
//            throw new RuntimeException("Could not create upload folder!");
//        }
//    }
	
	
	

	 public QiaService(JavaMailSender javaMailSender) {
	 		this.javaMailSender = javaMailSender;
	 	}
	 	
	 	public Tracking authorizedInfo(Tracking tracking) {

	 		return trackingRepository.save(tracking);

	 	}

	public QIAIndicatorMain qiaInfo(QIAIndicatorMain qiaData, MultipartFile[] qiaUploadfile) {

		try {
			
			ObjectMapper mapper=new ObjectMapper();
	     	System.out.println("data===="+mapper.writeValueAsString(qiaData));
			logger.info("uploadfile=========" + qiaUploadfile.length);
			logger.info("qia info===" + qiaData);
			List<QIAIndicator_FileUpload> qiaFile = new ArrayList<>();

			//qiaData.setQiaIndicator_id(new Integer(6).longValue());
//			Path root = Paths.get(uploadPath);
//            if (!Files.exists(root)) {
//                init();
//            }
			for (int i = 0; i < qiaUploadfile.length; i++) {
				// Get the filename and build the local file path
				String filename = qiaUploadfile[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(qiaUploadfile[i].getBytes());

				stream.close();

				// save it into file_upload_details table DB
				// String path = "C:\\Users\\risha\\Desktop\\uploads\\"; tb
				String param=filename.substring(0,filename.indexOf("-"));
				
				QIAIndicator_FileUpload qiaUploadfile1 = new QIAIndicator_FileUpload();
				qiaUploadfile1.setUniqueKey1(param.concat("-"+qiaData.getCriteriaId().getFinancialYear()));
				qiaUploadfile1.setQiaFileName(filename);
				
				qiaUploadfile1.setQiaFilePath(filepath);
				
				qiaUploadfile1.setQiaFileType(qiaUploadfile[i].getContentType());
				qiaUploadfile1.setCriteriaId(qiaData.getCriteriaId());


				qiaFile.add(qiaUploadfile1);
				
			}
			qiaData.setQiaIndiactor_fileupload(qiaFile);
			qiaRepository.save(qiaData);
			String  institutionType = qiaData.getCriteriaId().getTypeofInstitution();
			
			Map<String, String> allParams = new HashMap<>();
			allParams.put("collegeId", qiaData.getCriteriaId().getCollegeId());
			allParams.put("financialYear", qiaData.getCriteriaId().getFinancialYear());
			allParams.put("typeofInstitution", qiaData.getCriteriaId().getTypeofInstitution());
			
			
			
			if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			 trackingService.sendAutonomousIiqaEmail(allParams);
				}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
			 trackingService.sendAffiliatedIiqaEmail(allParams);
				}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
		 trackingService.sendUniversityIiqaEmail(allParams);
				}
//			return qiaRepository.save(qiaData);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Got the Exception while sending the mail & save data =="+e);
			return null;
		}
		

	}
	
	
	public String qiaMail(Map<String, String> allParams)
	{
		String status="";
		
		String  institutionType = allParams.get("typeofInstitution");
		
		if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
			 trackingService.sendAutonomousIiqaEmail(allParams);
				}else if(institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
			 trackingService.sendAffiliatedIiqaEmail(allParams);
				}else if(institutionType != null && "university".equalsIgnoreCase(institutionType)) {
		 trackingService.sendUniversityIiqaEmail(allParams);
				}
		
		return status;
		
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
	

	public List<QIAIndicatorMain> getAllQiaFiles(Map<String, String> allParams) {
		try {
			List<QIAIndicatorMain> qia = new ArrayList<QIAIndicatorMain>();
			CriteriaPrimaryKey id = new CriteriaPrimaryKey();
			id.setCollegeId(allParams.get("collegeId"));
			id.setFinancialYear(allParams.get("financialYear"));
			id.setTypeofInstitution(allParams.get("typeofInstitution"));
			 ObjectMapper mapper=new ObjectMapper();
				System.out.println("QIAIndicatorMain id====>"+mapper.writeValueAsString(id));
			Optional<QIAIndicatorMain> academic2 = qiaRepository.findById(id);
           
			if (academic2.isPresent()) {
				qia.add(academic2.get());
			}
			

			return qia;

		} catch (Exception e) {
			logger.error("Got Error while fetch the data -->{}",e);
			return null;
		}

	}
	
	
	public String sendIiqaEmail(Tracking trackingDetails) {

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				//reportPath = iiqaReport.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
			System.out.println(trackingDetails.getAssignedTo());
			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			mimeMessageHelper.setText("<html><body> Please review the NAAC Report </body></html>", true);

			mimeMessageHelper.setSubject("NAAC Report");

			if (reportPath != null && !StringUtils.isEmpty(reportPath)) {
				System.out.println("is the report path not empty ==>" + reportPath);
				// Adding the attachment
				FileSystemResource file = new FileSystemResource(new File(reportPath));

				mimeMessageHelper.addAttachment(file.getFilename(), file);
			}
			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		// Catch block to handle MessagingException
		catch (Exception e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}



	

	

}
