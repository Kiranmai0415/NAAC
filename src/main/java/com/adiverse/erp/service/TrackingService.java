package com.adiverse.erp.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.internal.build.AllowSysOut;
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
import com.adiverse.erp.model.ERole;
import com.adiverse.erp.model.ExtendedProfile;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.model.QIAIndicatorMain;
import com.adiverse.erp.model.Role;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.model.TrackingDetails;
import com.adiverse.erp.model.User;
import com.adiverse.erp.openpdf.AffiliatedBasicInformationReport;
//import com.adiverse.erp.openpdf.AffilatedCriteria11Report2;
//import com.adiverse.erp.openpdf.AffilatedCriteria12Report2;
//import com.adiverse.erp.openpdf.AffilatedCriteria13Report2;
//import com.adiverse.erp.openpdf.AffilatedCriteria14Report2;
//import com.adiverse.erp.openpdf.AffilatedCriteria1Report;
//import com.adiverse.erp.openpdf.AffilatedCriteria34Report2;
//import com.adiverse.erp.openpdf.AffiliatedBasicInformationReport;
//import com.adiverse.erp.openpdf.AffiliatedCriteria21Report2;
//import com.adiverse.erp.openpdf.AffiliatedCriteria41Report;
//import com.adiverse.erp.openpdf.AffiliatedCriteria42Report;
//import com.adiverse.erp.openpdf.AffiliatedCriteria43Report;
//import com.adiverse.erp.openpdf.AffiliatedCriteria44Report;
//import com.adiverse.erp.openpdf.AffiliatedCriteria51Report;
//import com.adiverse.erp.openpdf.AffiliatedCriteria52Report;
//import com.adiverse.erp.openpdf.AffiliatedCriteria53Report;
//import com.adiverse.erp.openpdf.AffiliatedCriteria54Report;
//import com.adiverse.erp.openpdf.AffiliatedCriteria5Report;
//import com.adiverse.erp.openpdf.AffiliatedCriteria63Report;
import com.adiverse.erp.openpdf.AffiliatedEvaluationReport;
import com.adiverse.erp.openpdf.AffiliatedExecutiveSummary;
import com.adiverse.erp.openpdf.AffiliatedExtendedProfileReport;
import com.adiverse.erp.openpdf.AffiliatedIiqaReport;
import com.adiverse.erp.openpdf.AffiliatedProfileoftheCollegeEvaluateReport;
import com.adiverse.erp.openpdf.AffiliatedSsrReport;
import com.adiverse.erp.openpdf.AutonomousCriteria54Report;
import com.adiverse.erp.openpdf.AutonomousEvaluationReport;
import com.adiverse.erp.openpdf.AutonomousExecutiveSummary;
import com.adiverse.erp.openpdf.AutonomousExtendedProfileReport;
import com.adiverse.erp.openpdf.AutonomousIiqaReport;
import com.adiverse.erp.openpdf.AutonomousProfileoftheCollegeEvaluateReport;
//import com.adiverse.erp.openpdf.AutonomousQualityAdivisorReport2;
import com.adiverse.erp.openpdf.AutonoumsAccademicInformation;
import com.adiverse.erp.openpdf.AutonoumsBasicInformationReport;
import com.adiverse.erp.openpdf.AutonoumsSsr;
import com.adiverse.erp.openpdf.Criteria1AffilatedReport;
import com.adiverse.erp.openpdf.Criteria1AutonomousReport;
import com.adiverse.erp.openpdf.Criteria1UniversityReport;
import com.adiverse.erp.openpdf.Criteria2AffilatedReport;
import com.adiverse.erp.openpdf.Criteria2AutonomousReport;
import com.adiverse.erp.openpdf.Criteria2UniversityReport;
import com.adiverse.erp.openpdf.Criteria3AffilatedReport;
import com.adiverse.erp.openpdf.Criteria3AutonomousReport;
import com.adiverse.erp.openpdf.Criteria3UniversityReport;
import com.adiverse.erp.openpdf.Criteria4AffilatedReport;
import com.adiverse.erp.openpdf.Criteria4AutonomousReport;
import com.adiverse.erp.openpdf.Criteria4UniversityReport;
import com.adiverse.erp.openpdf.Criteria5AffilatedReport;
import com.adiverse.erp.openpdf.Criteria5AutonomousReport;
import com.adiverse.erp.openpdf.Criteria5UniversityReport;
import com.adiverse.erp.openpdf.Criteria6AffilatedReport;
import com.adiverse.erp.openpdf.Criteria6AutonomousReport;
import com.adiverse.erp.openpdf.Criteria6UniversityReport;
import com.adiverse.erp.openpdf.Criteria7AffilatedReport;
import com.adiverse.erp.openpdf.Criteria7AutonomousReport;
import com.adiverse.erp.openpdf.Criteria7UniversityReport;
import com.adiverse.erp.openpdf.IiqaReport;
import com.adiverse.erp.openpdf.UniversityAccademicInformation;
import com.adiverse.erp.openpdf.UniversityBasicInformationReport;
import com.adiverse.erp.openpdf.UniversityEvaluationReport;
import com.adiverse.erp.openpdf.UniversityExecutiveSummary;
import com.adiverse.erp.openpdf.UniversityExtendedProfile;
import com.adiverse.erp.openpdf.UniversityIiqaReport;
import com.adiverse.erp.openpdf.UniversityProfileoftheCollegeEvaluateReport;
import com.adiverse.erp.openpdf.UniversityQualityAdvisorReport;
import com.adiverse.erp.openpdf.UniversitySsrReport;
import com.adiverse.erp.repository.TrackingRepository;
import com.adiverse.erp.utilities.AffliatedQualityProfile;
import com.adiverse.erp.utilities.QualityProfileReport;
import com.adiverse.erp.utilities.UniversityQualityProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class TrackingService {

	private final Logger logger = LoggerFactory.getLogger(TrackingService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private TrackingRepository trackingRepository;

	@Autowired
	private JavaMailSender javaMailSender;

//	@Autowired
//	private AutonomousQualityAdivisorReport2 autonomousQualityAdvisorReport;

	@Autowired
	private UniversityQualityAdvisorReport universityReport;

	@Autowired
	private IiqaReport iiqaReport;

	@Autowired
	private QualityProfileReport qualityProfileReport;
	@Autowired
	private AffliatedQualityProfile affliatedQualityProfile;
	@Autowired
	private UniversityQualityProfile universityQualityProfile;

	@Autowired
	private UserService userService;
	// ----------------------authonoumous Email

	@Autowired
	private AutonoumsSsr autonoumsSsr;

	//@Autowired
//	public AffilatedCriteria11Report2 affilatedCriteria11Report2;
//
//	@Autowired
//	public AffilatedCriteria12Report2 affilatedCriteria12Report2;
//
//	@Autowired
//	public AffilatedCriteria13Report2 affilatedCriteria13Report2;
//
//	@Autowired
//	public AffilatedCriteria14Report2 affilatedCriteria14Report2;
//
//	@Autowired
//	public AuthonomousCriteria11Report2 authonomousCriteria11Report2;
//
//	@Autowired
//	public AuthonomousCriteria12Report2 authonomousCriteria12Report2;
//
//	@Autowired
//	public AuthonomousCriteria13Report2 authonomousCriteria13Report2;
//
//	@Autowired
//	public AuthonomousCriteria14Report authonomousCriteria14Report;
//
//	@Autowired
//	private AutonomousCriteria22Report2 autonomousCriteria22Report2;

	@Autowired
	private AffiliatedProfileoftheCollegeEvaluateReport affiliatedProfileoftheCollegeEvaluateReport;

	@Autowired
	private AutonomousProfileoftheCollegeEvaluateReport autonomousProfileoftheCollegeEvaluateReport;

	@Autowired
	private UniversityProfileoftheCollegeEvaluateReport universityProfileoftheCollegeEvaluateReport;

//	@Autowired
//	private AffiliatedCriteria51Report affiliatedCriteria51Report;
//
//	@Autowired
//	private AffiliatedCriteria52Report affiliatedCriteria52Report;
//	@Autowired
//	private AffiliatedCriteria53Report affiliatedCriteria53Report;
//	@Autowired
//	private AffiliatedCriteria54Report affiliatedCriteria54Report;
//
//	@Autowired
//	private AffiliatedCriteria63Report affiliatedCriteria63Report;

	// --------------------->//AffiliatedSsrReport
	@Autowired
	private AffiliatedSsrReport affiliatedSsrReport;

//	@Autowired
//	private AffilatedCriteria1Report affilatedCriteria1Report;
//
//	@Autowired
//	private AutonomousCriteria43Report autonomousCriteria43Report;
//
//	@Autowired
//	private AffiliatedCriteria5Report affiliatedCriteria5Report;

	@Autowired
	private UniversitySsrReport universitySsrReport;

	@Autowired
	private UniversityExtendedProfile universityExtendedProfile;

//	@Autowired
//	private AutonomousCriteria71Report autonomousCriteria71Report;
//
//	@Autowired
//	private UniversityCriteria71Report universityCriteria71Report;
//	@Autowired
//	private UniversityCriteria72Report universityCriteria72Report;
//	@Autowired
//	private UniversityCriteria73Report universityCriteria73Report;
//
//	@Autowired
//	private UniversityCriteria61Report universityCriteria61Report;
//
//	@Autowired
//	private UniversityCriteria62Report universityCriteria62Report;
//
//	@Autowired
//	private UniversityCriteria63Report universityCriteria63Report;
//
//	@Autowired
//	private UniversityCriteria64Report universityCriteria64Report;
//	@Autowired
//	private UniversityCriteria65Report universityCriteria65Report;
//
//	@Autowired
//	private UniversityCriteria52Report universityCriteria52Report;

//	@Autowired
//	private UniversityCriteria41Report universityCriteria41Report;
//
//	@Autowired
//	private UniversityCriteria27Report2 universityCriteria27Report2;
//
//	@Autowired
//	private AffiliatedCriteria21Report2 affiliatedCriteria21Report2;
//
//	@Autowired
//	private AffilatedCriteria34Report2 affilatedCriteria34Report2;
//
//	@Autowired
//	private AffiliatedCriteria41Report affiliatedCriteria41Report;
//	@Autowired
//	private AffiliatedCriteria42Report affiliatedCriteria42Report;
//	@Autowired
//	private AffiliatedCriteria43Report affiliatedCriteria43Report;
//	@Autowired
//	private AffiliatedCriteria44Report affiliatedCriteria44Report;
//
//	@Autowired
//	private UniversityCriteria14Report2 universityCriteria14Report2;

	@Autowired
	private AutonomousIiqaReport autonomousIiqa;

	@Autowired
	private AffiliatedIiqaReport affiliatedIiqaReport;

	@Autowired
	private UniversityIiqaReport universityIiqaReport;

	@Autowired
	private AutonomousExecutiveSummary autonomousExecutiveSummary;

	@Autowired
	private UniversityExecutiveSummary universityExecutiveSummary;

	@Autowired
	private AutonoumsBasicInformationReport autonoumsBasicInformationReport;

	@Autowired
	private UniversityBasicInformationReport universityBasicInformationReport;

//	@Autowired
//	private AffiliatedBasicInformationReport affiliatedBasicInformationReport;

	@Autowired
	private AutonoumsAccademicInformation autonomousAccademicInformation;

	@Autowired
	private UniversityAccademicInformation universityAccademicInformation;

	@Autowired
	private AutonomousCriteria54Report autonomousCriteria54Report;

//	@Autowired
//	private AutonomousCriteria65Report autonomousCriteria65Report;
//
//	@Autowired
//	private UniversityCriteria31Report2 universityCriteria31Report2;

	@Autowired
	private AffiliatedEvaluationReport affiliatedEvaluationReport;

	@Autowired
	private UniversityEvaluationReport universityEvaluationReport;

	@Autowired
	private AutonomousEvaluationReport autonomousEvaluationReport;

//	@Autowired
//	private AutonomousCriteria37Report2 autonomousCriteria37Report2;

	@Autowired
	private Criteria1AffilatedReport criteria1AffilatedReport;
	
	@Autowired
	private Criteria1UniversityReport criteria1UniversityReport;
	
	@Autowired
	private Criteria2UniversityReport criteria2UniversityReport;
	
	@Autowired
	private Criteria3UniversityReport criteria3UniversityReport;
	
	@Autowired
	private Criteria4UniversityReport criteria4UniversityReport;
	
	
	@Autowired
	private Criteria5UniversityReport criteria5UniversityReport;
	
	@Autowired
	private Criteria6UniversityReport criteria6UniversityReport;

	@Autowired
	private Criteria7UniversityReport criteria7UniversityReport;

	@Autowired
  private Criteria3AffilatedReport criteria3AffilatedReport;
	
	
	@Autowired
	private Criteria3AutonomousReport criteria3AutonomousReport;
	
	  
//	@Autowired
//	private Criteria1AutonomousReport criteria1AutonomousReport;
	
	@Autowired
	private Criteria2AutonomousReport criteria2AutonomousReport;
	@Autowired
	private Criteria2AffilatedReport criteria2AffilatedReport;
	@Autowired
	private Criteria4AutonomousReport criteria4AutonomousReport;
	@Autowired
	private Criteria4AffilatedReport criteria4AffilatedReport;
	@Autowired 
	private Criteria5AutonomousReport criteria5AutonomousReport;
	@Autowired
	private Criteria5AffilatedReport criteria5AffilatedReport;
	@Autowired
	private Criteria6AutonomousReport criteria6AutonomousReport;
	@Autowired
	private Criteria6AffilatedReport criteria6AffilatedReport;
	@Autowired
	private Criteria7AutonomousReport criteria7AutonomousReport;
	@Autowired
	private Criteria7AffilatedReport criteria7AffilatedReport;
	
	@Autowired
	private Criteria1AutonomousReport criteria1AutonomousReport;
	@Autowired
	private AutonomousExtendedProfileReport autonomousExtendedProfileReport;
	@Autowired
	private AffiliatedExecutiveSummary affiliatedExecutiveSummary;
	@Autowired
	private AffiliatedBasicInformationReport affiliatedBasicInformationReport;
	@Autowired
	private AffiliatedExtendedProfileReport affiliatedExtendedProfileReport;
	
	
	public TrackingService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public Tracking trackingInfo(Tracking tracking) {

		return trackingRepository.save(tracking);

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
			Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			return fileName;

		} catch (Exception e) {
			throw new FileStorageException("Could not upload file");
		}
	}

	public Resource loadFile(String fileName) {
		logger.info("excelTemplatesPath==>{}", uploadFilePath);
		Path path = Paths.get(uploadFilePath + fileName);
		try {
			logger.info("path.toUri()=========>{}", path.toUri());
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

	public String AssignEmail(Tracking tracking) {
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(tracking.getRecord());
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			mimeMessageHelper.setText("<html><body> Hello, This" + tracking.getAssignedTo()
					+ "is assigned to you. Please, complete this before " + tracking.getStatus() + "."
					+ "</body></html>", true);

			mimeMessageHelper.setSubject("Assign email");

			// Adding the attachment
			// FileSystemResource file= new FileSystemResource(new
			// File(rejectemail.getAttachment()));

			// mimeMessageHelper.addAttachment(file.getFilename(), file);

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
	
	///////////senddeanAuthorizedEmail
//	public String senddeanAuthorizedEmail(Tracking tracking, Map<String, String> allParams)
//	{
//		String email1 = tracking.getAssignedBy();
//	    String email2 = tracking.getAssignedTo();
//	    String institutionType=tracking.getCriteriaId().getTypeofInstitution();
//		
//		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//		MimeMessageHelper mimeMessageHelper;
//
//		String reportPath = "";
//		try {
//			try {
//				if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType))
//				{
//      			reportPath = affiliatedExtendedProfileReport.generateReport(null);
//				}
//				else if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType))
//				{
//					
//				}
//				else if(institutionType != null && "autonomous".equalsIgnoreCase(institutionType))
//				{
//					
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//			// mimeMessageHelper.setFrom(sender);
////			System.out.println(trackingDetails.getAssignedTo());
////			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
////			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
//			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
//
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
//			mimeMessageHelper.setText("<html><body> Please review the NAAC Report </body></html>", true);
//
//			mimeMessageHelper.setSubject("NAAC Report");
//
//			if (reportPath != null && !StringUtils.isEmpty(reportPath)) {
//				System.out.println("is the report path not empty ==>" + reportPath);
//				// Adding the attachment
//				FileSystemResource file = new FileSystemResource(new File(reportPath));
//
//				mimeMessageHelper.addAttachment(file.getFilename(), file);
//			}
//			// Sending the mail
//			javaMailSender.send(mimeMessage);
//			return "Mail sent Successfully";
//		}
//
//		// Catch block to handle MessagingException
//		catch (Exception e) {
//
//			// Display message when exception occurred
//			return "Error while sending mail!!!";
//		}
//	}

//Reject email

	
	
	public String sendAutomatedEmail(Tracking tracking,String institutionType) {

		Tracking details = new Tracking();
		String email = details.getAssignedBy();
		
   
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			logger.info("email TO: " + tracking.getAssignedBy());
			
			mimeMessageHelper.setTo(tracking.getAssignedTo());
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			
//			 String contentAuth = "<html><body>Hi " + tracking.getAssignedTo()
//			 + ",<br><br>Email has been sent to prinicipal for review.<br><br>-Adiverse Team.</body></html>";
//			
			 if (tracking.getDeanComments() != null) {
				 List<User> userList = userService.getAllUserRecords();
					userList.stream().forEach(eachUser -> {
						try {
							mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(eachUser.getEmail()));
						} catch  (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
				 String contentReject  = "<html><body>Hi " + tracking.getAssignedTo()
				 + ",<br><br>Email has been sent to Faculty for correction.<br><br>-Adiverse Team.</body></html>"+"\r\n"+tracking.getDeanComments();
			 mimeMessageHelper.setText(contentReject, true);
			 }else if(tracking.getPrincipalComments() != null )
//				 && !"".equalsIgnoreCase(tracking.getPrincipalComments())
			 {
				 String contentReject  = "<html><body>Hi " + tracking.getAssignedTo()
				 + ",<br><br>Email has been sent to Dean for correction.<br><br>-Adiverse Team.</body></html>"+"\r\n"+tracking.getPrincipalComments();
			 mimeMessageHelper.setText(contentReject, true);
				 
			 }
//			 else {
//				 List<User> userList = userService.getAllUserRecords();
//					userList.stream().forEach(eachUser -> {
//						try {
//							mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(eachUser.getEmail()));
//						} catch (MessagingException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					});
//				 
//					mimeMessageHelper.setText("<html><body>Hi "+tracking.getAssignedBy()+",<br><br>Email has been sent to prinicipal for review.<br><br>-Adiverse Team.</body></html>"+"\r\n", true);
//			 }
			
			
//			mimeMessageHelper.setText("<html><body>Hi "+tracking.getAssignedBy()+",<br><br>Email has been sent to prinicipal for review.<br><br>-Adiverse Team.</body></html>"+"\r\n"+comments, true);
//			mimeMessageHelper.setText(comments);
			 
		
			mimeMessageHelper.setSubject("Automated  Email for NAAC Review");

			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully to the principal";
		}

		// Catch block to handle MessagingException
		catch (Exception e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}
	


	public Tracking authorizedInfo(Tracking tracking) {

		return trackingRepository.save(tracking);

	}

	// Authorized Email
	public String sendPrincipalAuthorizedEmail(Tracking trackingDetails, String institutionType) {

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				if (institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
//					reportPath = autonomousQualityAdvisorReport.generateReport();
				} else if (institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
					//reportPath = affiliatedReport.generateReport();
				} else if (institutionType != null && "university".equalsIgnoreCase(institutionType)) {
//					reportPath = universityReport.generateReport();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
			System.out.println(trackingDetails.getAssignedTo());
			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			// mimeMessage.addRecipient(RecipientType.CC, new
			// InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			mimeMessageHelper.setText("<html><body> Hi " + trackingDetails.getAssignedTo()
					+ ", <br>Principal has been authorized the NAAC Quality Advisory Report.<br><br><br>Please find the NAAC Quality Advisory Report.<br><br>-Adiverse Tech Team. </body></html>",
					true);

			mimeMessageHelper.setSubject("NAAC Quality Advisory Report");
			logger.info("report generated path with file is ==>" + reportPath);
			if (reportPath != null && !StringUtils.isEmpty(reportPath)) {
				logger.info("is the report path not empty ==>" + reportPath);
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

	// affiliatedExtendedProfileReport
	public String sendAffiliatedExtendedProfileReport() {
		List<Tracking> tracking = getTrackingData();

		String email1 = tracking.get(0).getAssignedBy();
		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
//				reportPath = affiliatedExtendedProfileReport.generateReport(null);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
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

//	AffiliatedProfileoftheCollegeEvaluateReport/////////////////////////////////////////////////////////////////////////////////////////////
	public String sendAffiliatedProfileoftheCollegeEvaluateReport(Map<String, String> allParams) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = affiliatedProfileoftheCollegeEvaluateReport.generateReport( allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	public String sendAutonomousProfileoftheCollegeEvaluateReport(	Map<String, String> allParams ) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

//		System.out.println("sendAutonomousProfileoftheCollegeEvaluateReport"+email1+email2);
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				System.out.println("gsgdsgahfgj");
				reportPath = autonomousProfileoftheCollegeEvaluateReport.generateReport(allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	public String sendUniversityProfileoftheCollegeEvaluateReport(Map<String, String> allParams ) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = universityProfileoftheCollegeEvaluateReport.generateReport(allParams );
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	public String sendUniversityAuthorizedEmail(Tracking trackingDetails) {

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
//				reportPath = universityReport.generateReport();
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

	public String sendQaAuthorizedEmail(String institutionType) {

//		List<Tracking> tracking = getTrackingData();
//
//		// Tracking trackingDetails = new Tracking();
//
//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				System.out.println(institutionType);
				if (institutionType != null && "autonomous".equalsIgnoreCase(institutionType)) {
					reportPath = qualityProfileReport.export();
				} else if (institutionType != null && "affiliated".equalsIgnoreCase(institutionType)) {
					reportPath = affliatedQualityProfile.export();
				} else if (institutionType != null && "university".equalsIgnoreCase(institutionType)) {
					reportPath = universityQualityProfile.export();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			mimeMessageHelper.setText("<html><body> Please, review this report</body></html>", true);

			mimeMessageHelper.setSubject("NAAC report");
			if (reportPath != null && !StringUtils.isEmpty(reportPath)) {
				System.out.println("is the report path not empty ==>" + reportPath);
				// Adding the attachment
				FileSystemResource file = new FileSystemResource(new File(reportPath));

				mimeMessageHelper.addAttachment(file.getFilename(), file);
			}
			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		} catch (Exception e) {
			System.out.println(e);
			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	public List<Tracking> getTrackingData() {
		try {
			List<Tracking> trackingInfo = new ArrayList<Tracking>();

			trackingRepository.findAll().forEach(trackingInfo::add);

			return trackingInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String sendFacultyAutonomusEmail() {

		List<Tracking> tracking = getTrackingData();

		// Tracking trackingDetails = new Tracking();

		String email1 = tracking.get(0).getAssignedBy();
		String email2 = tracking.get(0).getAssignedTo();

		System.out.println(email1);

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			// mimeMessageHelper.setTo(email1);

			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			mimeMessageHelper.setText("<html><body>Email has been sent to Dean and prinicipal for review</body></html>",
					true);

			mimeMessageHelper.setSubject("automated email");

			// Adding the attachment
			// FileSystemResource file= new FileSystemResource(new
			// File(rejectemail.getAttachment()));

			// mimeMessageHelper.addAttachment(file.getFilename(), file);

			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully to the principal";
		}

		// Catch block to handle MessagingException
		catch (Exception e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	// SSREMAIL
	public String sendAutonomousSsrEmail(ProfileoftheCollege ssrData) {

		List<Tracking> tracking = getTrackingData();

		String email1 = tracking.get(0).getAssignedBy();
		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				if (ssrData.getBasicProfile() != null) {

				} else if (ssrData.getAcademicinstitution() != null) {

				}

				reportPath = autonoumsSsr.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

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

//EXTENDEDpROFILE EMAIL
	public String sendAutonomousExtendedProfileEmail(Map<String, String> allParams) {

		// Creating a mime message
		
		
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();
//		System.out.println("Email"+email1+email2);

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);
//		
//		Map<String, String> allParams = new HashMap<String, String>();
//		allParams.put("collegeId", extendedProfile.getCriteriaId().getCollegeId() );
//		allParams.put("financialYear", extendedProfile.getCriteriaId().getFinancialYear() );
//		allParams.put("typeofInstitution", extendedProfile.getCriteriaId().getTypeofInstitution() );
    	


		try {
			try {
				reportPath = autonomousExtendedProfileReport.generateReport(allParams);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
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

	// autonomous email in criteria 1

	public String sendAutonomousCriteria1Email(Map<String, String> allParams ) {

		// Tracking trackingDetails = new Tracking();
		System.out.println("sendAutonomousCriteria1Email");
		List<Tracking> tracking = getTrackingData();
		
		ObjectMapper mapper=new ObjectMapper();
		

		
		
//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();
//		System.out.println(email1);
//		System.out.println(email2);

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";
		
//		

		// HttpSession session = request.getSession(true);
System.out.println("chek point 00======>");
		try {
			try {
				System.out.println("chek point 0======>");
				reportPath = criteria1AutonomousReport.generateReport( allParams );
				
			} catch (Exception e) {
				// TODO: handle exception
			}
//					
////					reportPath = authonomousCriteria1Report.generateReport();

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
					System.out.println("the mail id is====>"+eachUser.getEmail());
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

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
               e.printStackTrace();
			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	// autonoumous criteria2email
	public String sendAutonomousCriteria2Email(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

		// Tracking trackingDetails = new Tracking();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				System.out.println("cr 2.2");
				reportPath = criteria2AutonomousReport.generateReport( allParams);

//				if(criteria2Fieldinfo.getYearTable2111() !=null && criteria2Fieldinfo.getYearTable2121() !=null )	
//				{
//					System.out.println("cr 2.1");
//					reportPath = autonomousCriteria21Report2.generateReport( criteria2Fieldinfo);
//					
//				}
//				
//				else if(criteria2Fieldinfo.getYearTable2421() !=null)
//				{
//					System.out.println("cr 2.4");
//					
//					reportPath = autonomousCriteria24Report2.generateReport( criteria2Fieldinfo);
//				}
//				else if(criteria2Fieldinfo.getYearTable2511() !=null)
//				{
//					System.out.println("cr 2.5");
//					reportPath = autonomousCriteria25Report2.generateReport( criteria2Fieldinfo);
//					
//				}
//				else if(criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse262() !=null )
//				{
//					System.out.println("cr 2.6");				
//					
//					reportPath = autonomousCriteria26Report2.generateReport( criteria2Fieldinfo);
//
//				}else if(criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse221()  !=null)
//				{
//					System.out.println("cr 2.2");
//					
//					reportPath = autonomousCriteria22Report2.generateReport( criteria2Fieldinfo);
//					
//				}
//				else if(criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse231()  !=null)
//				{
//					System.out.println("nead correct if condition  2.3");
//					
//					
//					reportPath = autonomousCriteria23Report2.generateReport( criteria2Fieldinfo);
//
//				}
//				else
//				{
//					reportPath = autonomousCriteria27Report2.generateReport( criteria2Fieldinfo);
//
//				}
//				
//				

//				reportPath = autonomousCriteria2Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	// criteria3
	public String sendAutonomousCriteria3Email(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				System.out.println("cr3.7");
				reportPath = criteria3AutonomousReport.generateReport(allParams);

//		               if (criteria3Fieldinfo.getYearTable3431() !=null)
//					{
//						
//						
//					}
//					else if(criteria3Fieldinfo.getYearTable3511()!=null)
//					{
//						System.out.println("cr3.5");
//						reportPath = autonomousCriteria35Report2.generateReport();
//					}
//					else if(criteria3Fieldinfo.getYearTable3621() != null)
//					{
//						System.out.println("cr3.6");
//						reportPath = autonomousCriteria36Report2.generateReport();
//					}
//					else if(criteria3Fieldinfo.getYearTable3711() !=null)
//					{
//						System.out.println("cr3.7");
//						reportPath = autonomousCriteria37Report2.generateReport();
//						
//					}
//					else if(criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getResponse311()!=null )
//					{
//
//						System.out.println("cr3.1");
//						reportPath = autonomousCriteria31Report2.generateReport();
//						
//					}
//					else if (criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3231t1() !=null)
//					{
//						System.out.println("cr3.2");
//						reportPath = autonomousCriteria32Report2.generateReport();
//					}
//					 
//					else if(criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getResponse331() !=null)
//					{
//						System.out.println("cr3.3");
//						reportPath = autonomousCriteria33Report2.generateReport();
//					}
//					

				// reportPath = autonomousCriteria3Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
//
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	// criteria 4
	public String sendAutonomousCriteria4Email(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

		// Tracking trackingDetails = new Tracking();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				System.out.println("cr4.2");
				reportPath = criteria4AutonomousReport.generateReport( allParams);

//					if(criteria4Fieldinfo.getYearTable4141() !=null)
//					{
//						System.out.println("cr4.1");
//						reportPath=autonomousCriteria41Report.generateReport( criteria4Fieldinfo);
//						
//					}
//					else if(criteria4Fieldinfo.getYearTable4231() !=null)
//					{
//						System.out.println("cr4.2");
//						reportPath=autonomousCriteria42Report.generateReport( criteria4Fieldinfo);
//					}
//					else if(criteria4Fieldinfo.criteria4FieldInfoQn.get(0).getInput434t1() !=null)
//					{
//						System.out.println("cr4.3");
//						reportPath=autonomousCriteria43Report.generateReport( criteria4Fieldinfo);
//					}
//					else if(criteria4Fieldinfo.getYearTable4411() !=null)
//					{
//						System.out.println("cr4.4");
//						reportPath=autonomousCriteria44Report.generateReport( criteria4Fieldinfo);
//						
//					}

//					reportPath = autonomousCriteria4Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//				// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	// criteria5 email

	public String sendAutonomousCriteria5Email( Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				System.out.println("cr5.1");
				reportPath = criteria5AutonomousReport.generateReport( allParams);

//					if(criteria5Fieldinfo.getYearTable5111()!=null)
//					{
//						System.out.println("cr5.1");
//						reportPath = autonomousCriteria51Report.generateReport();
//						
//					}
//					else if(criteria5Fieldinfo.getYearTable5211() !=null)
//					{
//						
//						System.out.println("cr5.2");
//						reportPath = autonomousCriteria51Report.generateReport();
//						
//						
//					}
//					else if(criteria5Fieldinfo.getYearTable5311() !=null)
//					{
//						
//						System.out.println("cr5.3");
//						reportPath = autonomousCriteria51Report.generateReport();
//						
//						
//					}
//					else
//					{
//						System.out.println("cr5.4");
//						reportPath = autonomousCriteria51Report.generateReport();
//						
//						
//					}
//					reportPath = autonomousCriteria5Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			
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

	// criteria 6
	public String sendAutonomousCriteria6Email(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				System.out.println("cr 6.1");
				reportPath = criteria6AutonomousReport.generateReport( allParams);

//					if( criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse611() !=null) {
//						
//						System.out.println("cr 6.1");
//						reportPath = autonomousCriteria61Report.generateReport( criteria6Fieldinfo);
//					}
//					else if(criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse621() !=null)
//					{
//						System.out.println("cr 6.2");
//						reportPath = autonomousCriteria62Report.generateReport( criteria6Fieldinfo);
//						
//					}
//					else if(criteria6Fieldinfo.getYearTable6321() !=null)
//					{
//						
//						System.out.println("cr 6.3");
//						reportPath = autonomousCriteria63Report.generateReport( criteria6Fieldinfo);
//						
//					}
//					else if(criteria6Fieldinfo.getYearTable6421() != null)
//					{
//						
//						System.out.println("cr 6.4");
//						reportPath = autonomousCriteria64Report.generateReport( criteria6Fieldinfo);
//						
//					}
//					else
//					{
//						System.out.println("cr 6.5");
//						reportPath = autonomousCriteria65Report.generateReport( criteria6Fieldinfo);
//						
//					}
//					reportPath = autonomousCriteria6Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	// ccriteria 7
	public String sendAutonomousCriteria7Email(Map<String, String> allParams ) {

		

		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				System.out.println("cr 7.1");
				reportPath = criteria7AutonomousReport.generateReport(allParams );

//					if(criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse711() !=null)
//					{
//						System.out.println("cr7.1");
//						reportPath=autonomousCriteria71Report.generateReport( criteria7Fieldinfo);
//					}
//					else if( criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse721() !=null)
//					{
//						System.out.println("cr7.2");
//						reportPath=autonomousCriteria72Report.generateReport( criteria7Fieldinfo);
//					}
//					else if(criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse731() !=null)
//					{
//						System.out.println("cr7.3");
//						reportPath=autonomousCriteria73Report.generateReport( criteria7Fieldinfo);
//					}

//					reportPath = autonomousCriteria7Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	// AffiliatedSSrReport
	public String sendAffiliatedSsrEmail(ProfileoftheCollege ssrData) {

		List<Tracking> tracking = getTrackingData();

		String email1 = tracking.get(0).getAssignedBy();
		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				reportPath = affiliatedSsrReport.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

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

	// Affiliated Extended Profile
	public String sendAffiliatedExtendedProfileEmail(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
               	reportPath = affiliatedExtendedProfileReport.generateReport(allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	/// Affiliated criteria1report
	public String sendAffiliatedCriteria1Email(Map<String, String> allParams ) {

		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = criteria1AffilatedReport.generateReport( allParams );
				
//				if(criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0).getInput111t1() !=null)
//				{
//					reportPath=affilatedCriteria11Report2.generateReport();
//				}
//				else if(criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput122t1() !=null)
//				{
//					reportPath=affilatedCriteria12Report2.generateReport();
//					
//				}
//				else if(criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0).getInput131t1() !=null)
//				{
//					reportPath=affilatedCriteria13Report2.generateReport();
//				}
//				else if(criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0) !=null)
//				{
//					System.out.println("need to change the logic");
//					reportPath=affilatedCriteria14Report2.generateReport();
//					
//				}

				//reportPath = affilatedCriteria1Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
//
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
					System.out.println("data is"+eachUser.getEmail());
					
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
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
			e.printStackTrace();

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	// Affiliated criteria2Report

	public String sendAffiliatedCriteria2Email(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = criteria2AffilatedReport.generateReport(allParams);
//				
//				if(criteria2Fieldinfo.getYearTable2111() !=null)
//				{
//					reportPath=affiliatedCriteria21Report2.generateReport();
//				}
//				else if(criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getInput221t1() !=null)
//				{
//					reportPath=affiliatedCriteria22Report2.generateReport();
//				}
//				else if(criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getInput231t1() !=null)
//				{
//					reportPath=affiliatedCriteria23Report2.generateReport();
//					
//				}
//				else if (criteria2Fieldinfo.getYearTable2411() !=null)
//				{
//					reportPath=affiliatedCriteria24Report2.generateReport();
//				}
//				else if (criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getInput251t1() !=null)
//				{
//					reportPath=affiliatedCriteria25Report2.generateReport();
//					
//				}
//				else if(criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getInput261t1() !=null)
//				{
//					reportPath=affiliatedCriteria26Report2.generateReport();
//				}
//				else {
//					reportPath=affiliatedCriteria27Report2.generateReport();
//					
//				}
//				reportPath = affiliatedCriteria2Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			
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

	// affILIATEDcRITERIA3
	public String sendAffiliatedCriteria3Email(Map<String, String> allParams) {

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				
				reportPath = criteria3AffilatedReport.generateReport( allParams);
//				
//				if(criteria3Fieldinfo.getAffiliated_YearTable3111() !=null)
//				{
//					reportPath = affilatedCriteria31Report2.generateReport();
//					
//				}
//				else if(criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getInput311t1() !=null)
//				{
//					reportPath = affilatedCriteria32Report2.generateReport();
//				}
//				else if(criteria3Fieldinfo.getAffiliated_YearTable3311() !=null)
//				{
//					reportPath = affilatedCriteria33Report2.generateReport();
//				}
//				else if(true)
//				{
//					reportPath = affilatedCriteria34Report2.generateReport();
//					
//				}
//				else if(true)
//				{
//					reportPath = affilatedCriteria35Report2.generateReport();
//					
//				}else if (criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getInput361t1() !=null)
//				{
//					reportPath = affilatedCriteria36Report2.generateReport();
//					
//				}
//				else if(criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse371() !=null)
//				{
//					reportPath = affilatedCriteria37Report2.generateReport();
//				}
//			

//				reportPath = affilatedCriteria3Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
//			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	// AffiliatedCriteria4
	public String sendAffiliatedCriteria4Email(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

		// Tracking trackingDetails = new Tracking();
//
//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				reportPath = criteria4AffilatedReport.generateReport( allParams);
				
				
				
//				if (criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse411() != null) {
//					reportPath = affiliatedCriteria41Report.generateReport(criteria4Fieldinfo);
//				} else if (criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse421() != null) {
//					reportPath = affiliatedCriteria42Report.generateReport(criteria4Fieldinfo);
//				} else if (criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse431() != null) {
//					reportPath = affiliatedCriteria43Report.generateReport(criteria4Fieldinfo);
//				} else if (criteria4Fieldinfo.getYearTable4411() != null) {
//					reportPath = affiliatedCriteria44Report.generateReport(criteria4Fieldinfo);
//				}
//				reportPath = affiliatedCriteria4Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	//// affiliated
	public String sendAffiliatedCriteria5Email( Map<String, String> allParams) {

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				reportPath = criteria5AffilatedReport.generateReport( allParams);
				
				
				
//				
//				if (criteria5Fieldinfo.getAffiliated_YearTable5131() != null) {
//					reportPath = affiliatedCriteria51Report.generateReport(criteria5Fieldinfo);
////					
//				} else if (criteria5Fieldinfo.getAffiliated_YearTable5212().get(0).getInput5212v() != null) {
//					reportPath = affiliatedCriteria52Report.generateReport(criteria5Fieldinfo);
//				} else if (criteria5Fieldinfo.getAffiliated_YearTable5221() != null) {
//					reportPath = affiliatedCriteria53Report.generateReport(criteria5Fieldinfo);
//				} else if (true) {
//					reportPath = affiliatedCriteria54Report.generateReport(criteria5Fieldinfo);
//
//					reportPath = affiliatedCriteria5Report.generateReport();

//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			/////
			/*
			 * try { try { if(institutionType != null &&
			 * "autonomous".equalsIgnoreCase(institutionType)) { reportPath =
			 * autonomousQualityAdvisorReport.generateReport(); }else if(institutionType !=
			 * null && "affiliated".equalsIgnoreCase(institutionType)) { reportPath =
			 * affiliatedReport.generateReport(); }else if(institutionType != null &&
			 * "university".equalsIgnoreCase(institutionType)) { reportPath =
			 * universityReport.generateReport(); } } catch (Exception e) {
			 * e.printStackTrace(); }
			 */
			/////

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
//			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			
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
	// AffiliatedCriteria4

	// AffiliatedCriteria5

//	public String sendAffiliatedCriteria5Email(Criteria5_FieldInfo criteria5Fieldinfo) {
//		
//		
//		List<Tracking> tracking = getTrackingData();
//
//		
//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();
//		
//		
//		
//
//		// Creating a mime message
//		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//		MimeMessageHelper mimeMessageHelper;
//		String reportPath = "";
//
//		// HttpSession session = request.getSession(true);
//
//		try {
//			try {
//				
//				
//				System.out.println("need condition");
//				reportPath=affiliatedCriteria52Report.generateReport(criteria5Fieldinfo);
//				
//				
////				if(false)
////				{
////					
////				}
////				else if(criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getInput5221t1() !=null)
////				{
////					reportPath=affiliatedCriteria52Report.generateReport();
////				}
////				else if (criteria5Fieldinfo.getCriteria5FieldInfoQn() !=null)
////				{
////					System.out.println("need condition");
////					reportPath=affiliatedCriteria53Report.generateReport();
////				}
////				else if(criteria5Fieldinfo.getCriteria5FieldInfoQl().get(0).getInput541t1() !=null)
////				{
////					reportPath=affiliatedCriteria54Report.generateReport();
////				}
////				reportPath = affiliatedCriteria5Report.generateReport();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			
//			
//			
//			// Setting multipart as true for attachments to
//			// be send
//			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//			// mimeMessageHelper.setFrom(sender);
////			System.out.println(trackingDetails.getAssignedTo());
////			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
////			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
//			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
//			
//			
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
//			
//			
//			mimeMessageHelper.setText("<html><body> Please review the NAAC Report </body></html>", true);
//
//			mimeMessageHelper.setSubject("NAAC Report");
//
//			if (reportPath != null && !StringUtils.isEmpty(reportPath)) {
//				System.out.println("is the report path not empty ==>" + reportPath);
//				// Adding the attachment
//				FileSystemResource file = new FileSystemResource(new File(reportPath));
//
//				mimeMessageHelper.addAttachment(file.getFilename(), file);
//			}
//			// Sending the mail
//			javaMailSender.send(mimeMessage);
//			return "Mail sent Successfully";
//		}
//
//		// Catch block to handle MessagingException
//		catch (Exception e) {
//
//			// Display message when exception occurred
//			return "Error while sending mail!!!";
//		}
//	}
	// criteria6em
	public String sendAffiliatedCriteria6Email(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				System.out.println("jdshjk");

				reportPath = criteria6AffilatedReport.generateReport(allParams);
//				
//				if(criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse611() !=null)
//				{
//					reportPath =affiliatedCriteria61Report.generateReport(criteria6Fieldinfo);
//				}
//				else if(criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse621() != null)
//				{
//					reportPath =affiliatedCriteria62Report.generateReport();
//				}
//				else if(criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse631() != null)
//				{
//					reportPath =affiliatedCriteria63Report.generateReport();
//				}
//				else if(false)
//				{
//					reportPath =affiliatedCriteria64Report.generateReport();
//				}
//				else if(criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse651() !=null)
//				{
//					reportPath =affiliatedCriteria65Report.generateReport();
//				}
//				reportPath = affiliatedCriteria6Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	////////////////////////////////////////////////////////////////
	public String sendAffiliatedCriteria7Email(Map<String, String> allParams ) {

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = criteria7AffilatedReport.generateReport( allParams );
				
				
				
				
				
				
//				
//				if(criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse711() !=null)
//				{
//					reportPath = affiliatedCriteria71Report.generateReport();
//				
//				}
//				else if(criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse721() !=null)
//				{
//					reportPath = affiliatedCriteria72Report.generateReport();
//				}
//				else if(criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse731() !=null)
//				{
//					reportPath = affiliatedCriteria73Report.generateReport();
//				}
//				reportPath = affiliatedCriteria7Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	//
	public String sendUniversitySsr(ProfileoftheCollege ssrData) {

		List<Tracking> tracking = getTrackingData();

		String email1 = tracking.get(0).getAssignedBy();
		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				if (ssrData.getBasicProfile() != null) {

				} else if (ssrData.getEvaluativeReport() != null) {

				}

				reportPath = universitySsrReport.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

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

	public String sendUniversityExtendedProfileEmail(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = universityExtendedProfile.generateReport( allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

/////////////////////////////////////////////////Univetrsity Criteria1
	public String sendUniversityCriteria1Email(Map<String, String> allParams ) {

		List<Tracking> tracking = getTrackingData();
//
//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				System.out.println("cr 1.4");
				reportPath = criteria1UniversityReport.generateReport(allParams );

//				if(criteria1Fieldinfo.getYearTable1131() ==null)
//				{
//					System.out.println("cr 1.1");
//					reportPath =	universityCriteria14Report2.generateReport(  criteria1Fieldinfo);
//				   System.out.println("cr 1.11");
//				}
//			else if(criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1211t1() !=null)
//				{
//				System.out.println("cr 1.2");
//					reportPath =	universityCriteria12Report2.generateReport();
//				}
//				else if(criteria1Fieldinfo.getYearTable1321() !=null)
//				{
//					System.out.println("cr 1.3");
//					reportPath =	universityCriteria13Report2.generateReport();
//				}
//				else
//				{
//					System.out.println("cr 1.4");
//					reportPath =	universityCriteria14Report2.generateReport();
//				}
//				
//				reportPath = universityCriteria1Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
//			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
//			System.out.println("the mail id are"+email1+""+email2);
			
//			 mimeMessageHelper.setFrom(sender);
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
					System.out.println("the mail id is ==>"+eachUser.getEmail());
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setText("<html><body> Please review the NAAC Report </body></html>", true);

			mimeMessageHelper.setSubject("NAAC Report");

			if (reportPath != null && !StringUtils.isEmpty(reportPath)) {
				System.out.println("is the report path not empty ==>" + reportPath);
				// Adding the attachment
				FileSystemResource file = new FileSystemResource(new File(reportPath));

				mimeMessageHelper.addAttachment(file.getFilename(), file);
				System.out.println("file added");
			}
			// Sending the mail
			javaMailSender.send(mimeMessage);
			System.out.println("Successfully");
			return "Mail sent Successfully";
		}

		// Catch block to handle MessagingException
		catch (Exception e) {

			e.printStackTrace();
			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

//////university criteriareport 
	public String sendUniversityCriteria2Email(Map<String, String> allParams) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("mapper======>" + mapper.writeValueAsString( allParams));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			try {

				System.out.println("cr ");
				reportPath = criteria2UniversityReport.generateReport(  allParams);
//				
//				if(criteria2Fieldinfo.getYearTable2121() ==null)
//				{
//					System.out.println("cr 2.1");
//					ObjectMapper  mapperservice=new ObjectMapper();
//					System.out.println("mapperservice====>"+mapperservice.writeValueAsString(criteria2Fieldinfo));
//					reportPath = universityCriteria24Report2.generateReport( criteria2Fieldinfo);
//				}
//				else if(criteria2Fieldinfo.getYearTable2121() !=null)
//				{
//					System.out.println("cr 2.2");
//					reportPath = universityCriteria22Report2.generateReport();
//				}
//				else if(criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse231() !=null)
//				{
//					System.out.println("cr 2.3");
//					reportPath = universityCriteria23Report2.generateReport();
//				}
//				else if(criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getInput2421t21() !=null)
//				{
//					System.out.println("cr 2.4");
//					reportPath = universityCriteria24Report2.generateReport();
//				}
//				else if(criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse253() !=null)
//				{
//					System.out.println("cr 2.5");
//					reportPath = universityCriteria25Report2.generateReport();
//				}
//				else if(criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse261() !=null)
//				{
//					System.out.println("cr 2.6");
//					reportPath = universityCriteria26Report2.generateReport();
//				}
//				else
//				{
//					System.out.println("cr 2.7");
//					
//					reportPath = universityCriteria27Report2.generateReport();
//				}
//				reportPath = universityCriteria2Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	// university criteria3 report email
	public String sendUniversityCriteria3Email(Map<String, String> allParams) {

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);
//		System.out.println(
//				"criteria3Fieldinfo.getCriteria3FieldInfoQl()==>" + criteria3Fieldinfo.getCriteria3FieldInfoQl());
//		System.out.println("criteria3Fieldinfo.getCriteria3FieldInfoQl()====>"+criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0));
		try {
			try {

				System.out.println("cr 3.7");
				reportPath = criteria3UniversityReport.generateReport(allParams);

//				if(criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getResponse311() !=null)
//				{
//					System.out.println("cr 3.1");
//					reportPath =universityCriteria31Report2.generateReport( criteria3Fieldinfo );
//				}
//				else if(criteria3Fieldinfo.getUniversityYearTable3231() !=null)
//				{
//					System.out.println("cr 3.2");
//					reportPath =universityCriteria32Report2.generateReport( criteria3Fieldinfo );
//				}
//				else if(criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getResponse331() !=null)
//				{
//					System.out.println("cr 3.3");
//					reportPath =universityCriteria33Report2.generateReport( criteria3Fieldinfo );
//				}
//				else if(criteria3Fieldinfo.getUniversityYearTable3451() !=null)
//				{
//					System.out.println("cr 3.4");
//					reportPath =universityCriteria34Report2.generateReport( criteria3Fieldinfo );
//				}
//				else if(criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput351t1() !=null)
//				{
//					System.out.println("cr 3.5");
//					reportPath =universityCriteria35Report2.generateReport( criteria3Fieldinfo );
//				}
//				else if(criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getResponse361() !=null)
//				{
//					System.out.println("cr 3.6");
//					reportPath =universityCriteria36Report2.generateReport( criteria3Fieldinfo );
//					
//				}
//				else if(criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse371() !=null)
//				{
//					System.out.println("cr 3.7");
//					reportPath =universityCriteria37Report2.generateReport( criteria3Fieldinfo );
//				}
//				reportPath = universityCriteria3Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

//university  criteria4 report 
	public String sendUniversityCriteria4Email(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

		// Tracking trackingDetails = new Tracking();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				System.out.println("cr4.1");
				reportPath = criteria4UniversityReport.generateReport(allParams);

//				if(criteria4Fieldinfo.getYearTable4141()!=null)
//				{
//					System.out.println("cr4.1");
//					reportPath =universityCriteria41Report.generateReport(criteria4Fieldinfo);
//				}
//				else if(criteria4Fieldinfo.getYearTable4231() !=null)
//				{
//					System.out.println("cr4.2");
//					reportPath =universityCriteria42Report.generateReport( criteria4Fieldinfo);	
//				}
//				else if(criteria4Fieldinfo.getYearTable4411() !=null)
//				{
//					System.out.println("cr4.4");
//					reportPath =universityCriteria44Report.generateReport( criteria4Fieldinfo);
//					
//				}
//				
//				else 
//				{
//					System.out.println("cr4.3");
//					
//					reportPath =universityCriteria43Report.generateReport( criteria4Fieldinfo);
//				}
//				
//				reportPath = universityCriteria4Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
//			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
					System.out.println(eachUser.getEmail());
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	////
	public String sendUniversityCriteria5Email( Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();
//
//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				System.out.println("cr5.2");
				reportPath = criteria5UniversityReport.generateReport( allParams);

//				if(criteria5Fieldinfo.getYearTable5111() !=null)
//				{
//					System.out.println("cr7.1");
//					reportPath=universityCriteria51Report.generateReport( criteria5Fieldinfo);
//					
//				}
//				else if(criteria5Fieldinfo.getYearTable5211() !=null)
//				{
//					System.out.println("cr7.2");
//					reportPath=universityCriteria52Report.generateReport( criteria5Fieldinfo);
//					
//				}
//				else if(criteria5Fieldinfo.getYearTable5311() !=null)
//				{
//					System.out.println("cr7.3");
//					reportPath=universityCriteria53Report.generateReport( criteria5Fieldinfo);
//					
//				}
//				else if(criteria5Fieldinfo.getCriteria5FieldInfoQl().get(0).getInput541t1() !=null)
//				{
//					System.out.println("cr7.4");
//					reportPath=universityCriteria54Report.generateReport( criteria5Fieldinfo);
//				}
//				

			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
//
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			
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

	/// UniversityCriteria6email
	public String sendUniversityCriteria6Email(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				System.out.println("111111");
				
				reportPath = criteria6UniversityReport.generateReport( allParams);


//				if (criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getInput611t1() != null) {
//					System.out.println("cr6.1");
//					reportPath = universityCriteria61Report.generateReport(criteria6Fieldinfo);
//				} else if (criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getInput621t1() != null) {
//					System.out.println("cr6.2");
//					reportPath = universityCriteria62Report.generateReport(criteria6Fieldinfo);
//				} else if (criteria6Fieldinfo.getYearTable6321() != null) {
//					System.out.println("cr6.3");
//					reportPath = universityCriteria63Report.generateReport(criteria6Fieldinfo);
//
//				} else if (criteria6Fieldinfo.getYearTable6321() != null) {
//					System.out.println("cr6.4");
//					System.out.println("need to write the correct logic");
//
//					reportPath = universityCriteria64Report.generateReport(criteria6Fieldinfo);
//				} else if (criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getInput651t1() != null) {
//					System.out.println("cr6.5");
//					reportPath = universityCriteria65Report.generateReport(criteria6Fieldinfo);
//
//				}

//				reportPath = universityCriteria6Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
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
//university criteria7 report 

	public String sendUniversityCriteria7Email(Map<String, String> allParams ) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				
				reportPath = criteria7UniversityReport.generateReport(allParams );

				

//				if (criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse711() != null) {
//					System.out.println("cr7.1");
//					reportPath = universityCriteria71Report.generateReport(criteria7Fieldinfo, uploadfile7);
//
//				} else if (criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse721() != null) {
//					System.out.println("cr7.2");
//					reportPath = universityCriteria72Report.generateReport(criteria7Fieldinfo, uploadfile7);
//
//				} else if (criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse731() != null) {
//					System.out.println("cr7.3");
//
//					reportPath = universityCriteria73Report.generateReport(criteria7Fieldinfo, uploadfile7);
//
//				}
//				reportPath = universityCriteria7Report.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//			System.out.println(trackingDetails.getAssignedTo());
//			mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//			mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
		
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	// iiqa
	public String sendIiqaEmail(Tracking trackingDetails) {

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = iiqaReport.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	public String sendAffiliatedIiqaEmail(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = affiliatedIiqaReport.generateReport( allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
					System.out.println("the mail id are==>"+eachUser.getEmail());
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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
              e.printStackTrace();
			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	public String sendAutonomousIiqaEmail(Map<String, String> allParams) {


//		List<Tracking> tracking = getTrackingData();
//
//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();
//		
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = autonomousIiqa.generateReport(allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
//				mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//				mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));

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

	public String sendUniversityIiqaEmail(Map<String, String> allParams) {
		List<Tracking> tracking = getTrackingData();

		String email1 = tracking.get(0).getAssignedBy();
		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = universityIiqaReport.generateReport( allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));

			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
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

	/////
	public String sendAutonomousExecutiveSummary(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

		// Tracking trackingDetails = new Tracking();
//
//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();
//	    System.out.println("mail"+email1+email2);

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = autonomousExecutiveSummary.generateReport(allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//					// mimeMessageHelper.setFrom(sender);
//					System.out.println(trackingDetails.getAssignedTo());
//					mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//					mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	public String sendUniversityExecutiveEmail(Map<String, String> allParams ) {

		List<Tracking> tracking = getTrackingData();

		// Tracking trackingDetails = new Tracking();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = universityExecutiveSummary.generateReport(allParams );
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//					// mimeMessageHelper.setFrom(sender);
//					System.out.println(trackingDetails.getAssignedTo());
//					mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//					mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	public String sendAffiliatedExecutiveEmail(Map<String, String> allParams) {

		List<Tracking> tracking = getTrackingData();

		// Tracking trackingDetails = new Tracking();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = affiliatedExecutiveSummary.generateReport(allParams);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//					// mimeMessageHelper.setFrom(sender);
//					System.out.println(trackingDetails.getAssignedTo());
//					mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//					mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	public String sendAffiliatedExecutiveSummary() {

		List<Tracking> tracking = getTrackingData();

		// Tracking trackingDetails = new Tracking();

		String email1 = tracking.get(0).getAssignedBy();
		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
//					reportPath = affiliatedExecutiveSummaryReport.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//					// mimeMessageHelper.setFrom(sender);
//					System.out.println(trackingDetails.getAssignedTo());
//					mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//					mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
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

	public String sendUniversityExecutiveSummary() {

		List<Tracking> tracking = getTrackingData();

		// Tracking trackingDetails = new Tracking();

		String email1 = tracking.get(0).getAssignedBy();
		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				// reportPath = universityExtendedProfile.generateReport();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//					// mimeMessageHelper.setFrom(sender);
//					System.out.println(trackingDetails.getAssignedTo());
//					mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//					mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
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

	public String sendAutonoumsBasicInformationReport(Map<String, String> allParams) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();
		
//		System.out.println(email1+"+"+email2);

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = autonoumsBasicInformationReport.generateReport( allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	/// universityBasicInformationReport

	

	// AffiliatedBasicInformationReport

	public String sendAffiliatedBasicInformationReport(Map<String, String> allParams) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = affiliatedBasicInformationReport.generateReport( allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	public String sendAutonomousAccademicInformationReport(	Map<String, String> allParams) {
		System.out.println("ts");
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {

				reportPath = autonomousAccademicInformation.generateReport(	allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	public String sendUniversityAccademicInformationReport(Map<String, String> allParams) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = universityAccademicInformation.generateReport( allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	
	public String sendUniversityBasicInformationReport(Map<String, String> allParams) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = universityBasicInformationReport.generateReport( allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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
	
	
	
	
	public String sendAffiliatedEvaluationReport(Map<String, String> allParams) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = affiliatedEvaluationReport.generateReport(allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
//		
			
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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

	public String sendUniversityEvaluationReport(Map<String, String> allParams) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = universityEvaluationReport.generateReport(allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			
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

	public String sendAutonomousEvaluationReport(Map<String, String> allParams) {
		List<Tracking> tracking = getTrackingData();

//		String email1 = tracking.get(0).getAssignedBy();
//		String email2 = tracking.get(0).getAssignedTo();
//		System.out.println("mail"+email1+email2);

		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		// HttpSession session = request.getSession(true);

		try {
			try {
				reportPath = autonomousEvaluationReport.generateReport( allParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
//				System.out.println(trackingDetails.getAssignedTo());
//				mimeMessageHelper.setTo(trackingDetails.getAssignedTo());
//				mimeMessage.addRecipient(RecipientType.CC, new InternetAddress(trackingDetails.getAssignedBy()));
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);

//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
			
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					
					mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
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
	
	/*
	 * principal rejection mail function 
	 */
	public String sendPrincipalRejetedEmail(TrackingDetails programsAuthorise) {

		List<Tracking> tracking = getTrackingData();
		String email = tracking.get(0).getAssignedBy();
		
   
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			logger.info("email TO: " + tracking.get(0).getAssignedBy());
			
			mimeMessageHelper.setTo(tracking.get(0).getAssignedTo());
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			
//			 String contentAuth = "<html><body>Hi " + tracking.getAssignedTo()
//			 + ",<br><br>Email has been sent to prinicipal for review.<br><br>-Adiverse Team.</body></html>";
//			
		
				 List<User> userList = userService.getAllUserRecords();
					userList.stream().forEach(eachUser -> {
						try {
							mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(eachUser.getEmail()));
						} catch  (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
				
				 String contentReject  = "<html><body>Hi " + email
				 + ",<br><br>Email has been sent to Dean for correction.<br><br>-Adiverse Team.</body></html>"+"\r\n"+programsAuthorise.getPrincipalComments();
			 mimeMessageHelper.setText(contentReject, true);
				 
		
			mimeMessageHelper.setSubject("Automated  Email for NAAC Review");

			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully to the principal";
		}

		// Catch block to handle MessagingException
		catch (Exception e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	
	
	
	
	
	
	
	
	

}
