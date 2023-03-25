package com.adiverse.erp.service;

import java.io.File;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.exception.FileStorageException;
import com.adiverse.erp.model.AttainmentsMain;
import com.adiverse.erp.model.BooksandChaptersMain;
import com.adiverse.erp.model.CentricMethods;
import com.adiverse.erp.model.Citations;
import com.adiverse.erp.model.CollaborationLinkagesMain;
import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.Criteria6_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.DashboardProgramsAuthorise;
import com.adiverse.erp.model.FacultyAwardsMain;
import com.adiverse.erp.model.FieldResearchInternsMain;
import com.adiverse.erp.model.FinancialSupportToTeachersMain;
import com.adiverse.erp.model.FullTimeTeachersPhdMain;
import com.adiverse.erp.model.GrantsResearchMain;
import com.adiverse.erp.model.Hindex;
import com.adiverse.erp.model.NumberofWorkshopsSeminorsMain;
import com.adiverse.erp.model.OnlineorF2FFDPMain;
import com.adiverse.erp.model.PassPercentStudMain;
import com.adiverse.erp.model.PatentsMain;
import com.adiverse.erp.model.PhdAwardedorRegisteredMain;
import com.adiverse.erp.model.ProfessionalDevelopmenMain;
import com.adiverse.erp.model.ResearchFellowsEnrolledMain;
import com.adiverse.erp.model.ResearchPapersMain;
import com.adiverse.erp.model.RevenueConsultancyMain;
import com.adiverse.erp.model.RevenueCorpTrainingMain;
import com.adiverse.erp.model.SeedMoneyMain;
import com.adiverse.erp.model.StudentMentorMain;
import com.adiverse.erp.model.TeachingPedagology;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.model.User;
import com.adiverse.erp.model.ValueAddedCoursesMain;
import com.adiverse.erp.payload.request.RestAPIRequest;
import com.adiverse.erp.payload.response.RestAPIResponse;
import com.adiverse.erp.repository.Criteria1Repository;
import com.adiverse.erp.repository.Criteria2Repository;
import com.adiverse.erp.repository.Criteria3Repository;
import com.adiverse.erp.repository.Criteria6Repository;
import com.adiverse.erp.repository.DashboardTrackingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class DashBoardTrackingService {

	private final Logger logger = LoggerFactory.getLogger(DashBoardTrackingService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private DashboardTrackingRepository dashboardTrackingRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserService userService;

	@Autowired
	Criteria1Repository criteria1Repository;

	@Autowired
	private ValueAddCourseService valueAddCourseService;

	@Autowired
	private CentricService centricService;

	@Autowired
	private TeachingPedagologyService teachingPedagologyService;

	@Autowired
	private FieldResearchInternsService fieldResearchInternsService;

	@Autowired
	private Criteria2Repository criteria2Repository;

	@Autowired
	private StudentMentorService studentMentorService;

	@Autowired
	private FullTimeTeachPhdService fullTimeTeachPhdService;

	@Autowired
	private AttainmentsService attainmentsService;

	@Autowired
	private PassPercentStudService passPercentStudService;

	@Autowired
	private SeedMoneyService seedMoneyService;

	@Autowired
	Criteria3Repository criteria3Repository;

	@Autowired
	private GrantResearchService grantResearchService;

	@Autowired
	private NoOfWorkshopsSeminarsService noOfWorkshopsSeminarsService;

	@Autowired
	private ResearchPaperService researchPaperService;

	@Autowired
	private BookandChapterService bookandChapterService;

	@Autowired
	private CitationsService citationsService;

	@Autowired
	private RevenueConsultService revenueConsultService;

	@Autowired
	private RevenueCorpTrainingService revenueCorpTrainingService;

	@Autowired
	private CollaborationsService collaborationsService;

	@Autowired
	private FinanceSupportTeachService financeSupportTeachService;

	@Autowired
	Criteria6Repository criteria6Repository;

	@Autowired
	private ProfessionaldevelopmentService professionaldevelopmentService;

	@Autowired
	private OnlineF2FFDPService onlineF2FFDPService;

	@Autowired
	private FacultyAwardsService facultyAwardsService;

	@Autowired
	private ResearchFellowsService researchFellowsService;

	@Autowired
	private PatentsService patentsService;

	@Autowired
	private PhDAwardedService phDAwardedService;

	@Autowired
	private HindexService hindexService;

	private RestAPIResponse restAPIResponse;

	private ObjectMapper mapper = new ObjectMapper();
	
	public DashBoardTrackingService(JavaMailSender javaMailSender, RestAPIResponse restAPIResponse) {
		this.javaMailSender = javaMailSender;
		this.restAPIResponse = restAPIResponse;
	}

	// DashBoard Mapping

	public RestAPIResponse trackingInfo(RestAPIRequest restAPIRequest, String screenType) {
		
		try {
			if ("valueAdded".equalsIgnoreCase(screenType)) {
				getValueAddedCriteriasUpdate();
			} else if ("CenticAuthorize".equalsIgnoreCase(screenType)) {
				getCentricMethodsUpdate();
			} else if ("TeachingPedagology".equalsIgnoreCase(screenType)) {
				getTeachingPedagologyUpdate();
			} else if ("FieldProjects".equalsIgnoreCase(screenType)) {
				getFieldResearcInternshUpdate(restAPIRequest);
			} else if ("counselling".equalsIgnoreCase(screenType)) {
				getStudentMentorRatioUpdate(restAPIRequest);
			} else if ("PercentageFullTimeTeacher".equalsIgnoreCase(screenType)) {
				getFullTimeTeachPHDUpdate();
			} else if ("Attainment".equalsIgnoreCase(screenType)) {
				getAttainmentsUpdate();
			} else if ("passPercentage".equalsIgnoreCase(screenType)) {
				getPassPercentOfStudentsUpdate();
			} else if ("Seedmoney".equalsIgnoreCase(screenType)) {
				getSeedMoneyCriteriasUpdate();
			} else if ("Grants".equalsIgnoreCase(screenType)) {
				getGrantsResearchCriteriasUpdate();
			} else if ("nOOFwORKsHOP".equalsIgnoreCase(screenType)) {
				getNoOfWorkshopsCriteriasUpdate();
			} else if ("publications".equalsIgnoreCase(screenType)) {
				getResearchPapersCriteriasUpdate();
			} else if ("Books".equalsIgnoreCase(screenType)) {
				getBooksandChaptersCriteriasUpdate();
			} else if ("RevenueCorporate".equalsIgnoreCase(screenType)) {
				getRevenueCorporateCriteriasUpdate();
			} else if ("Consultancy".equalsIgnoreCase(screenType)) {
				getRevenueConsultaCriteriasUpdate();
			} else if ("collaborationLinkages".equalsIgnoreCase(screenType)) {
				getCollaborationsCriteriasUpdate();
			} else if ("FinancialSupport".equalsIgnoreCase(screenType)) {
				getFinanceSupToTeachersCriteriasUpdate();
			} else if ("Professional".equalsIgnoreCase(screenType)) {
				getProfessionalDevlopProgmCriteriasUpdate();
			} else if ("online".equalsIgnoreCase(screenType)) {
				getOnlineFDPCriteriasUpdate();
			} else if ("FacultyAward".equalsIgnoreCase(screenType)) {
				getFacultyAwardsCriteriasUpdate();
			} else if ("ResearchFellows".equalsIgnoreCase(screenType)) {
				getResearchFellowsEnrolledCriteriasUpdate();
			} else if ("Patents".equalsIgnoreCase(screenType)) {
				getPatentsCriteriasUpdate();
			} else if ("phdAward".equalsIgnoreCase(screenType)) {
				getPHDAwardedCriteriasUpdate();
			}

			else if ("Hindex".equalsIgnoreCase(screenType)) {
				getHindexCriteriasData();
			} else if ("Citations".equalsIgnoreCase(screenType)) {
				getCitationsCriteriasUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restAPIResponse;

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

	/////////// senddeanAuthorizedEmail
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

	public String sendAutomatedEmail(DashboardProgramsAuthorise programsAuthorise, String institutionType,
			String screenType) {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String comments = programsAuthorise.getDeanComments();

		try {

			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			logger.info("email TO: " + programsAuthorise.getAuthorizedBy());
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			mimeMessageHelper.setTo(programsAuthorise.getAuthorizedBy());
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			String contentAuth = "<html><body>Hi " + programsAuthorise.getAuthorizedBy()
					+ ",<br><br>Email has been sent to Hod for review.<br><br>-Adiverse Team.</body></html>";
			String contentReject = "<html><body>Hi " + programsAuthorise.getAuthorizedBy()
					+ ",<br><br>Email has been sent to Faculty for correction.\r\n\r\n<br><br>" + "HODComments:"
					+ comments + "<br><br>-Adiverse Team.</body></html>";
			if (programsAuthorise.getDeanComments() != null
					&& !"".equalsIgnoreCase(programsAuthorise.getDeanComments())) {
				mimeMessageHelper.setText(contentReject, true);
			} else {
				mimeMessageHelper.setText(contentAuth, true);
			}

			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		// Catch block to handle MessagingException
		catch (Exception e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	public String sendPrincipalAuthorizedEmail(Tracking tracking, String institutionType) {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String comments = tracking.getDeanComments();

		try {

			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			logger.info("email TO: " + tracking.getAssignedBy());
			List<User> userList = userService.getAllUserRecords();
			userList.stream().forEach(eachUser -> {
				try {
					mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(eachUser.getEmail()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			mimeMessageHelper.setTo(tracking.getAssignedTo());
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			String contentAuth = "<html><body>Hi " + tracking.getAssignedTo()
					+ ",<br><br>Email has been sent to QA for review.<br><br>-Adiverse Team.</body></html>";
			String contentReject = "<html><body>Hi " + tracking.getAssignedTo()
					+ ",<br><br>Email has been sent to dean for correction.\r\n\r\n<br><br>" + "DeanComments:"
					+ comments + "<br><br>-Adiverse Team.</body></html>";
			if (tracking.getDeanComments() != null && !"".equalsIgnoreCase(tracking.getDeanComments())) {
				mimeMessageHelper.setText(contentReject, true);
			} else {
				mimeMessageHelper.setText(contentAuth, true);
			}

			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		// Catch block to handle MessagingException
		catch (Exception e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

//	public Tracking authorizedInfo(Tracking tracking) {
//
//		return trackingRepository.save(tracking);
//
//	}
	/*
	 * principalstatus
	 */
//	public PrincipalStatus principalStatus(PrincipalStatus principalstatus)
//	{
//		return principalStatus.save(principalstatus);
//		
//	}
//	
//	/*
//	 * statues of report
//	 */
//
//	public String statusOfReport( Map<String, String> allParams)
//	{
//		
//		try {
//		List<PrincipalStatus> statues = new ArrayList<PrincipalStatus>();
//		CriteriaPrimaryKey id =new CriteriaPrimaryKey();
//		 
//		 
//		 id.setCollegeId(allParams.get("collegeId"));
//         id.setFinancialYear(allParams.get("financialYear"));
//		 id.setTypeofInstitution(allParams.get("typeofInstitution"));
//		 
//		 Optional<PrincipalStatus> academic2 = principalStatus.findById(id);
//	
//		 if (academic2.isPresent()) {
//			 statues.add(academic2.get());
//			}
//		 
//		}
//		catch (Exception e) {
//			System.out.println("error while feching");
//		}
//		
//		return "";
//		
//	}

	// Authorized Email

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

	public List<DashboardProgramsAuthorise> getTrackingData() {
		try {
			List<DashboardProgramsAuthorise> trackingInfo = new ArrayList<DashboardProgramsAuthorise>();

			// dashboardTrackingRepository.findAll().forEach(ProgramsAuthorise::add);

			return trackingInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	public String sendFacultyAutonomusEmail() {
//
////		List<Tracking> tracking = getTrackingData();
//
//		// Tracking trackingDetails = new Tracking();
//
////		String email1 = tracking.get(0).getAssignedBy();
////		String email2 = tracking.get(0).getAssignedTo();
//
//		System.out.println(email1);
//
//		// Creating a mime message
//		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//		MimeMessageHelper mimeMessageHelper;
//
//		try {
//
//			// Setting multipart as true for attachments to
//			// be send
//			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//
//			// mimeMessageHelper.setTo(email1);
//
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email1));
//			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email2));
//			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
//			mimeMessageHelper.setText("<html><body>Email has been sent to Dean and prinicipal for review</body></html>",
//					true);
//
//			mimeMessageHelper.setSubject("automated email");
//
//			// Adding the attachment
//			// FileSystemResource file= new FileSystemResource(new
//			// File(rejectemail.getAttachment()));
//
//			// mimeMessageHelper.addAttachment(file.getFilename(), file);
//
//			// Sending the mail
//			javaMailSender.send(mimeMessage);
//			return "Mail sent Successfully to the principal";
//		}
//
//		// Catch block to handle MessagingException
//		catch (Exception e) {
//
//			// Display message when exception occurred
//			return "Error while sending mail!!!";
//		}
//	}
//

	// Value Added Courses

	private void getValueAddedCriteriasUpdate() {
		try {
			List<ValueAddedCoursesMain> valueAddObj = valueAddCourseService.getAllValueAddData();
			ValueAddedCoursesMain valueAddobj = null;
			if (valueAddObj != null) {
				valueAddobj = valueAddObj.get(0);
			}
			if (valueAddobj != null) {
				if ("university".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(valueAddobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(valueAddobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(valueAddobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
					if (criteria1.isPresent()) {
						if (CollectionUtils.isEmpty(criteria1.get().getYearTable1321())) {
							System.out.println("year table 1321 is empty.....");
							// Insert 1321
							int result1321 = criteria1Repository.insertYearTable1321(
									valueAddobj.getValueAddedCourses().get(0).getInputvat5(), 1, 1,
									valueAddobj.getCriteriaId().getCollegeId(),
									valueAddobj.getCriteriaId().getFinancialYear(),
									valueAddobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result1321 inserted=======>" + result1321);
							// insert 1331
							int result1331 = criteria1Repository.insertYearTable1331(
									valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
									valueAddobj.getValueAddedCourses().get(0).getInputvat8(), 1,
									valueAddobj.getCriteriaId().getCollegeId(),
									valueAddobj.getCriteriaId().getFinancialYear(),
									valueAddobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result1331 inserted=======>" + result1331);
						} else {
							// update 1321
							System.out.println("year table 1321 is not  empty.....");
							String value1321 = criteria1.get().getYearTable1321().get(0).getInput1321v();
							System.out.println("existing value is============>" + value1321);
							BigDecimal bd = new BigDecimal(value1321);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println(
									"unique key ==>" + valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							int update1321u = criteria1Repository.updateYearTable1321Au(finalValue,
									valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							System.out.println("update1321 u=======>" + update1321u);
							// update 1331
							System.out.println("year table 1331 is not  empty.....");
							String value1331 = criteria1.get().getYearTable1331().get(0).getInput1331v();
							System.out.println("existing value is============>" + value1331);
							BigDecimal bd1 = new BigDecimal(value1331);
							BigDecimal finalValue1 = bd1
									.add(new BigDecimal(valueAddobj.getValueAddedCourses().get(0).getInputvat8()));
							System.out.println("what is the final value ==>" + finalValue1);
							System.out.println(
									"unique key ==>" + valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							int update1331 = criteria1Repository.updateYearTable1331(finalValue1,
									valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							System.out.println("update1331u=======>" + update1331);
						}
					} else {

						System.out.println("inserting into cr1 main table else......");
						int criteria1Main = criteria1Repository.insertCriteria1Main(
								valueAddobj.getCriteriaId().getCollegeId(),
								valueAddobj.getCriteriaId().getFinancialYear(),
								valueAddobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria1Main else====>" + criteria1Main);
						// insert 1321
						int result1321 = criteria1Repository.insertYearTable1321(
								valueAddobj.getValueAddedCourses().get(0).getInputvat5(), 1, 1,
								valueAddobj.getCriteriaId().getCollegeId(),
								valueAddobj.getCriteriaId().getFinancialYear(),
								valueAddobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result1321 inserted=======>" + result1321);
						// insert 1331
						int result1331 = criteria1Repository.insertYearTable1331(
								valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
								valueAddobj.getValueAddedCourses().get(0).getInputvat8(), 1,
								valueAddobj.getCriteriaId().getCollegeId(),
								valueAddobj.getCriteriaId().getFinancialYear(),
								valueAddobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result1331 inserted=======>" + result1331);
					}
				}
//1321 & 1331  Au  table

				else if ("autonomous".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution())) {
					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(valueAddobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(valueAddobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(valueAddobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
					if (criteria1.isPresent()) {
						if (CollectionUtils.isEmpty(criteria1.get().getYearTable1321())) {
							System.out.println("year table 1321 is empty.....");
							// Insert 1321
							int result1321 = criteria1Repository.insertYearTable1321(
									valueAddobj.getValueAddedCourses().get(0).getInputvat5(), 1, 1,
									valueAddobj.getCriteriaId().getCollegeId(),
									valueAddobj.getCriteriaId().getFinancialYear(),
									valueAddobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result1321 inserted=======>" + result1321);
							// insert 1331
							int result1331 = criteria1Repository.insertYearTable1331(
									valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
									valueAddobj.getValueAddedCourses().get(0).getInputvat8(), 1,
									valueAddobj.getCriteriaId().getCollegeId(),
									valueAddobj.getCriteriaId().getFinancialYear(),
									valueAddobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result1331 inserted=======>" + result1331);
						} else {
							// update 1321
							System.out.println("year table 1321 is not  empty.....");
							String value1321Au = criteria1.get().getYearTable1321().get(0).getInput1321v();
							System.out.println("existing value is============>" + value1321Au);
							BigDecimal bdAu = new BigDecimal(value1321Au);
							int finalValueAu = bdAu.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValueAu);
							System.out.println(
									"unique key ==>" + valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							int update1321Au = criteria1Repository.updateYearTable1321Au(finalValueAu,
									valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							System.out.println("update1321 u=======>" + update1321Au);
//update 1331
							System.out.println("year table 1331 is not  empty.....");
							String value1331Au = criteria1.get().getYearTable1331().get(0).getInput1331v();
							System.out.println("existing value is============>" + value1331Au);
							BigDecimal bdAu1 = new BigDecimal(value1331Au);
							BigDecimal finalValueAu1 = bdAu1
									.add(new BigDecimal(valueAddobj.getValueAddedCourses().get(0).getInputvat8()));
							System.out.println("what is the final value ==>" + finalValueAu1);
							System.out.println(
									"unique key ==>" + valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							int update1331Au = criteria1Repository.updateYearTable1331(finalValueAu1,
									valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							System.out.println("update1331u=======>" + update1331Au);
						}
					} else {

						System.out.println("inserting into cr1 main table else......");
						int criteria1Main = criteria1Repository.insertCriteria1Main(
								valueAddobj.getCriteriaId().getCollegeId(),
								valueAddobj.getCriteriaId().getFinancialYear(),
								valueAddobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria1Main else====>" + criteria1Main);
						// 1321 insert
						System.out.println("year table 1321 insertion else .......");
						int result1321 = criteria1Repository.insertYearTable1321(
								valueAddobj.getValueAddedCourses().get(0).getInputvat5(), 1,
								valueAddobj.getCriteriaId().hashCode(), valueAddobj.getCriteriaId().getCollegeId(),
								valueAddobj.getCriteriaId().getFinancialYear(),
								valueAddobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result1321 else=======>" + result1321);
						// 1331 insert
						int result1331 = criteria1Repository.insertYearTable1331(
								valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
								valueAddobj.getValueAddedCourses().get(0).getInputvat8(), 1,
								valueAddobj.getCriteriaId().getCollegeId(),
								valueAddobj.getCriteriaId().getFinancialYear(),
								valueAddobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result1331 inserted=======>" + result1331);
					}
				}
// 1211 & 1221 Af 	

				else if ("affiliated".equalsIgnoreCase(valueAddobj.getCriteriaId().getTypeofInstitution())) {
					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(valueAddobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(valueAddobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(valueAddobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
					if (criteria1.isPresent()) {
						if (CollectionUtils.isEmpty(criteria1.get().getCriteria12Qn())) {
							System.out.println(" Cr12 Qn is empty affiliated.....");
							// Insert 1211t1
							int result1211 = criteria1Repository.insertCriteria12Qn(1, 1,
									valueAddobj.getCriteriaId().getCollegeId(),
									valueAddobj.getCriteriaId().getFinancialYear(),
									valueAddobj.getCriteriaId().getTypeofInstitution());
							System.out.println("input1211t1 affiliated inserted=======>" + result1211);
							// insert 1221 table
							System.out.println("year table 1221 affiliated insertion .......");
							int result1221 = criteria1Repository.insertAffiliatedYrTable1221(
									valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
									valueAddobj.getValueAddedCourses().get(0).getInputvat8(), 1,
									valueAddobj.getCriteriaId().getCollegeId(),
									valueAddobj.getCriteriaId().getFinancialYear(),
									valueAddobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result1221 affiliated inserted=======>" + result1221);
						} else {
							// update 1211t1
							System.out.println("Cr12 Qn not  empty affiliated .....");
							String value1211 = criteria1.get().getCriteria12Qn().get(0).getInput1211t1();
							System.out.println("existing value1211 is============>" + value1211);
							BigDecimal bd = new BigDecimal(value1211);
							int finalValueAf = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValueAf);
							System.out.println(
									"unique key ==>" + valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							int update1211 = criteria1Repository.updateCriteria12Qn(finalValueAf,
									valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							System.out.println("update1211 affiliated=======>" + update1211);
							// update 1221 table
							System.out.println("year table 1221 is not  empty affiliated.....");
							String value1221 = criteria1.get().getAffiliatedYearTable1221().get(0).getInput1221v();
							System.out.println("existing value is affiliated============>" + value1221);
							BigDecimal bdAf = new BigDecimal(value1221);
							BigDecimal finalValueAf2 = bdAf
									.add(new BigDecimal(valueAddobj.getValueAddedCourses().get(0).getInputvat8()));
							System.out.println("what is the final value affiliated ==>" + finalValueAf2);
							System.out.println(
									"unique key ==>" + valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							int update1221 = criteria1Repository.updateAffiliatedYrTable1221(finalValueAf2,
									valueAddobj.getValueAddedCourses().get(0).getUniqueKey1());
							System.out.println("update1221 affiliated u=======>" + update1221);
						}
					} else {

						System.out.println("inserting into cr1 main table else affiliated ......");
						int criteria1Main = criteria1Repository.insertCriteria1Main(
								valueAddobj.getCriteriaId().getCollegeId(),
								valueAddobj.getCriteriaId().getFinancialYear(),
								valueAddobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria1Main affiliated else====>" + criteria1Main);
						// 1211t1 insert
						int result1211 = criteria1Repository.insertCriteria12Qn(1, 1,
								valueAddobj.getCriteriaId().getCollegeId(),
								valueAddobj.getCriteriaId().getFinancialYear(),
								valueAddobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result1211af affiliated inserted=======>" + result1211);
						// 1221 insert
						System.out.println("year table 1221 insertion .......");
						int result1221 = criteria1Repository.insertAffiliatedYrTable1221(
								valueAddobj.getValueAddedCourses().get(0).getInputvat5(),
								valueAddobj.getValueAddedCourses().get(0).getInputvat8(), 1,
								valueAddobj.getCriteriaId().getCollegeId(),
								valueAddobj.getCriteriaId().getFinancialYear(),
								valueAddobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result1221 affiliated inserted=======>" + result1221);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// Centric methods 

	private void getCentricMethodsUpdate() {
		try {
			List<CentricMethods> centricobj1 = centricService.getAllCentricData();
			CentricMethods centricobj = null;
			if (centricobj1 != null) {
				centricobj = centricobj1.get(0);
			}
			if (centricobj != null) {

//2.3.1 U,Au,Af 
				if ("university".equalsIgnoreCase(centricobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(centricobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(centricobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(centricobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria23Ql())) {
							System.out.println(" Cr23 Ql is empty.....");
							// Insert 231 tx area
							int result231 = criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(), 1,
									centricobj.getCriteriaId().getCollegeId(),
									centricobj.getCriteriaId().getFinancialYear(),
									centricobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result231 inserted=======>" + result231);
						} else {
							// update 1341 tx
							System.out.println("Cr23 Ql is not  empty.....");
							String value231 = criteria2.get().getCriteria23Ql().get(0).getResponse231();
							System.out.println("existing value is============>" + value231);
							System.out.println("unique key ==>" + centricobj.getUniqueKey1());
							int update231 = criteria2Repository.updateCriteria23Ql(centricobj.getInputcmt5(),
									centricobj.getUniqueKey1());
							System.out.println("update231 u=======>" + update231);

						}
					} else {

						System.out.println("inserting into cr1 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								centricobj.getCriteriaId().getCollegeId(),
								centricobj.getCriteriaId().getFinancialYear(),
								centricobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// insert 231 tx area
						int result231 = criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(), 1,
								centricobj.getCriteriaId().getCollegeId(),
								centricobj.getCriteriaId().getFinancialYear(),
								centricobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result231 inserted=======>" + result231);

					}
				}
//2.3.1 Au
				else if ("autonomous".equalsIgnoreCase(centricobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(centricobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(centricobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(centricobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria23Ql())) {
							System.out.println(" Cr23 Ql is empty.....");
							// Insert 231 tx area
							int result231 = criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(), 1,
									centricobj.getCriteriaId().getCollegeId(),
									centricobj.getCriteriaId().getFinancialYear(),
									centricobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result231 autonomous inserted=======>" + result231);
						} else {
							// update 231 tx
							System.out.println("Cr23 Ql autonomous is not  empty.....");
							String value231Au = criteria2.get().getCriteria23Ql().get(0).getInput231t1();
							System.out.println("existing value231Au is============>" + value231Au);
							System.out.println("unique key ==>" + centricobj.getUniqueKey1());
							int update231Au = criteria2Repository.updateCriteria23QlAu(centricobj.getInputcmt5(),
									centricobj.getUniqueKey1());
							System.out.println("update231Au autonomous u=======>" + update231Au);

						}
					} else {

						System.out.println("inserting into cr1 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								centricobj.getCriteriaId().getCollegeId(),
								centricobj.getCriteriaId().getFinancialYear(),
								centricobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main autonomous else====>" + criteria2Main);
						// insert 231 tx area
						int result231 = criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(), 1,
								centricobj.getCriteriaId().getCollegeId(),
								centricobj.getCriteriaId().getFinancialYear(),
								centricobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result231 autonomous inserted=======>" + result231);

					}
				}
//2.3.1 Af
				else if ("affiliated".equalsIgnoreCase(centricobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(centricobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(centricobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(centricobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria23Ql())) {
							System.out.println(" Cr23 Ql is empty.....");
							// Insert 231 tx area
							int result231 = criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(), 1,
									centricobj.getCriteriaId().getCollegeId(),
									centricobj.getCriteriaId().getFinancialYear(),
									centricobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result231 inserted affiliated=======>" + result231);
						} else {
							// update 1341 tx
							System.out.println("Cr23 Ql is not  empty.....");
							String value231 = criteria2.get().getCriteria23Ql().get(0).getResponse231();
							System.out.println("existing value is============>" + value231);
							System.out.println("unique key ==>" + centricobj.getUniqueKey1());
							int update231 = criteria2Repository.updateCriteria23Ql(centricobj.getInputcmt5(),
									centricobj.getUniqueKey1());
							System.out.println("update231 affiliated u=======>" + update231);

						}
					} else {

						System.out.println("inserting into cr1 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								centricobj.getCriteriaId().getCollegeId(),
								centricobj.getCriteriaId().getFinancialYear(),
								centricobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main affiliated else====>" + criteria2Main);
						// insert 231 tx area
						int result231 = criteria2Repository.insertCriteria23Ql(centricobj.getInputcmt5(), 1,
								centricobj.getCriteriaId().getCollegeId(),
								centricobj.getCriteriaId().getFinancialYear(),
								centricobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result231 affiliated inserted=======>" + result231);

					}
				} else {
					System.out.println("centric data is not mapped.......................");
				}
			} else {
				System.out.println("centric obj is null or empty.........................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// Teaching Pedagology 

	private void getTeachingPedagologyUpdate() {
		try {
			List<TeachingPedagology> pedagologyobj1 = teachingPedagologyService.getAllPedagologyData();
			TeachingPedagology pedagologyobj = null;
			if (pedagologyobj1 != null) {
				pedagologyobj = pedagologyobj1.get(0);
			}
			if (pedagologyobj != null) {

//2.3.2 U,Au 
				if ("university".equalsIgnoreCase(pedagologyobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(pedagologyobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(pedagologyobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(pedagologyobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria23Ql())) {
							System.out.println(" Cr23 Ql is empty.....");
							// Insert 232 tx area
							int result232 = criteria2Repository.insertCriteria23Ql1(pedagologyobj.getInputtpt5(), 1,
									pedagologyobj.getCriteriaId().getCollegeId(),
									pedagologyobj.getCriteriaId().getFinancialYear(),
									pedagologyobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result232 inserted=======>" + result232);
						} else {
							// update 232 tx area
							System.out.println("Cr23 Ql is not  empty.....");
							String value232 = criteria2.get().getCriteria23Ql().get(0).getResponse232();
							System.out.println("existing value is============>" + value232);
							System.out.println("unique key ==>" + pedagologyobj.getUniqueKey1());
							int update232 = criteria2Repository.updateCriteria23Ql1(pedagologyobj.getInputtpt5(),
									pedagologyobj.getUniqueKey1());
							System.out.println("update232 u=======>" + update232);

						}
					} else {

						System.out.println("inserting into cr1 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								pedagologyobj.getCriteriaId().getCollegeId(),
								pedagologyobj.getCriteriaId().getFinancialYear(),
								pedagologyobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// insert 232 tx area
						int result232 = criteria2Repository.insertCriteria23Ql1(pedagologyobj.getInputtpt5(), 1,
								pedagologyobj.getCriteriaId().getCollegeId(),
								pedagologyobj.getCriteriaId().getFinancialYear(),
								pedagologyobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result232 inserted else=======>" + result232);

					}
				}
// 2.3.2 Au
				else if ("autonomous".equalsIgnoreCase(pedagologyobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(pedagologyobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(pedagologyobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(pedagologyobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria23Ql())) {
							System.out.println(" Cr23 Ql is empty.....");
							// Insert 232 tx area
							int result232 = criteria2Repository.insertCriteria23Ql1(pedagologyobj.getInputtpt4(), 1,
									pedagologyobj.getCriteriaId().getCollegeId(),
									pedagologyobj.getCriteriaId().getFinancialYear(),
									pedagologyobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result232 inserted=======>" + result232);
						} else {
							// update 232 tx area
							System.out.println("Cr23 Ql is not  empty.....");
							String value232 = criteria2.get().getCriteria23Ql().get(0).getResponse232();
							System.out.println("existing value is============>" + value232);
							System.out.println("unique key ==>" + pedagologyobj.getUniqueKey1());
							int update232 = criteria2Repository.updateCriteria23Ql1(pedagologyobj.getInputtpt4(),
									pedagologyobj.getUniqueKey1());
							System.out.println("update232 u=======>" + update232);

						}
					} else {

						System.out.println("inserting into cr1 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								pedagologyobj.getCriteriaId().getCollegeId(),
								pedagologyobj.getCriteriaId().getFinancialYear(),
								pedagologyobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// insert 232 tx area
						int result232 = criteria2Repository.insertCriteria23Ql1(pedagologyobj.getInputtpt4(), 1,
								pedagologyobj.getCriteriaId().getCollegeId(),
								pedagologyobj.getCriteriaId().getFinancialYear(),
								pedagologyobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result232 inserted else=======>" + result232);

					}
				} else {
					System.out.println("Pedagology data is not mapped..................");
				}
			} else {
				System.out.println("pedagologyobj is null or empty.........................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// Field Research Interns

	// @SuppressWarnings("unused")
	private void getFieldResearcInternshUpdate(RestAPIRequest restAPIRequest) {
		try {
			Map<String, String> allParams = new HashedMap<>() ;
			allParams.put("collegeId", restAPIRequest.getCollegeId());
			allParams.put("financialYear", restAPIRequest.getFinancialYear());
			allParams.put("typeofInstitution", restAPIRequest.getTypeofInstitution());
			List<FieldResearchInternsMain> fieldInternsobj1 = fieldResearchInternsService.getAllFieldInternsData( allParams);
			FieldResearchInternsMain fieldInternsobj = null;
			if (fieldInternsobj1 != null) {
				fieldInternsobj = fieldInternsobj1.get(0);
			}
			if (fieldInternsobj != null) {
				if ("university".equalsIgnoreCase(fieldInternsobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(fieldInternsobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(fieldInternsobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(fieldInternsobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
					if (criteria1.isPresent()) {
						if (CollectionUtils.isEmpty(criteria1.get().getCriteria13Qn())) {
							System.out.println(" Cr13 Qn is empty.....");
							// Insert 1341 tx
							int result1341 = criteria1Repository.insertCriteria13Qn(
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(), 1,
									fieldInternsobj.getCriteriaId().getCollegeId(),
									fieldInternsobj.getCriteriaId().getFinancialYear(),
									fieldInternsobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result1341 inserted=======>" + result1341);
						} else {
							// update 1341 tx
							System.out.println("Cr13 Qn is not  empty.....");
							String value1341t1 = criteria1.get().getCriteria13Qn().get(0).getInput1341t1();
							String value1341t2 = criteria1.get().getCriteria13Qn().get(0).getInput1341t2();
							System.out.println(
									"existing value is============>" + value1341t1 + "   value1341t2==>" + value1341t2);
							BigDecimal bdAu1 = new BigDecimal(value1341t1);
							BigDecimal bdAu2 = new BigDecimal(value1341t2);
							BigDecimal finalValueAu1 = bdAu1.add(new BigDecimal(
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7()));
							BigDecimal finalValueAu2 = bdAu2.add(new BigDecimal(
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5()));
							System.out.println("what is the final value ==>" + finalValueAu1 + "   finalValueAu2====>"
									+ finalValueAu2);
							System.out.println("unique key ==>"
									+ fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
							int update1341 = criteria1Repository.updateCriteria13Qn(finalValueAu1, finalValueAu2,
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
							System.out.println("update1341 u=======>" + update1341);

						}
					} else {

						System.out.println("inserting into cr1 main table else......");
						int criteria1Main = criteria1Repository.insertCriteria1Main(
								fieldInternsobj.getCriteriaId().getCollegeId(),
								fieldInternsobj.getCriteriaId().getFinancialYear(),
								fieldInternsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria1Main else====>" + criteria1Main);
						// insert 1341
						int result1341 = criteria1Repository.insertCriteria13Qn(
								fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),
								fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(), 1,
								fieldInternsobj.getCriteriaId().getCollegeId(),
								fieldInternsobj.getCriteriaId().getFinancialYear(),
								fieldInternsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result1341 inserted=======>" + result1341);

					}
				}
				// 1.3.4.1 Au
				else if ("autonomous".equalsIgnoreCase(fieldInternsobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(fieldInternsobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(fieldInternsobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(fieldInternsobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
					if (criteria1.isPresent()) {
						if (CollectionUtils.isEmpty(criteria1.get().getCriteria13Qn())) {
							System.out.println(" Cr13 Qn is empty.....");
							// Insert 1341 tx
							int result1341 = criteria1Repository.insertCriteria13Qn(
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(), 1,
									fieldInternsobj.getCriteriaId().getCollegeId(),
									fieldInternsobj.getCriteriaId().getFinancialYear(),
									fieldInternsobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result1341 inserted=======>" + result1341);
						} else {
							// update 1341 tx
							System.out.println("Cr13 Qn is not  empty.....");
							String value1341t1 = criteria1.get().getCriteria13Qn().get(0).getInput1341t1();
							String value1341t2 = criteria1.get().getCriteria13Qn().get(0).getInput1341t2();
							System.out.println(
									"existing value is============>" + value1341t1 + "   value1341t2==>" + value1341t2);
							BigDecimal bdAu1 = new BigDecimal(value1341t1);
							BigDecimal bdAu2 = new BigDecimal(value1341t2);
							BigDecimal finalValueAu1 = bdAu1.add(new BigDecimal(
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7()));
							BigDecimal finalValueAu2 = bdAu1.add(new BigDecimal(
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5()));
							System.out.println("what is the final value ==>" + finalValueAu1 + "   finalValueAu2====>"
									+ finalValueAu2);
							System.out.println("unique key ==>"
									+ fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
							int update1341 = criteria1Repository.updateCriteria13Qn(finalValueAu1, finalValueAu2,
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
							System.out.println("update1341 u=======>" + update1341);

						}
					} else {

						System.out.println("inserting into cr1 main table else......");
						int criteria1Main = criteria1Repository.insertCriteria1Main(
								fieldInternsobj.getCriteriaId().getCollegeId(),
								fieldInternsobj.getCriteriaId().getFinancialYear(),
								fieldInternsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria1Main else====>" + criteria1Main);
						// insert 1341
						int result1341 = criteria1Repository.insertCriteria13Qn(
								fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),
								fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(), 1,
								fieldInternsobj.getCriteriaId().getCollegeId(),
								fieldInternsobj.getCriteriaId().getFinancialYear(),
								fieldInternsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result1341 inserted=======>" + result1341);

					}
				}
				// 1.3.2.1 Af
				else if ("affiliated".equalsIgnoreCase(fieldInternsobj.getCriteriaId().getTypeofInstitution())) {
					System.out.println("collegeId ===>" + fieldInternsobj.getCriteriaId().getCollegeId());
					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(fieldInternsobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(fieldInternsobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(fieldInternsobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria1_FieldInfo> criteria1 = criteria1Repository.findById(key);
					if (criteria1.isPresent()) {
						if (CollectionUtils.isEmpty(criteria1.get().getCriteria13Qn())) {
							System.out.println(" Cr13 Qn is empty.....");
//Insert 1321 tx		
							int result1321 = criteria1Repository.insertCriteria13QnAf(
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(), 1,
									fieldInternsobj.getCriteriaId().getCollegeId(),
									fieldInternsobj.getCriteriaId().getFinancialYear(),
									fieldInternsobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result1321 affiliated inserted=======>" + result1321);
						} else {
//update 1321 tx				
							System.out.println("Cr13 Qn affiliated is not  empty.....");
							String value1321af1 = criteria1.get().getCriteria13Qn().get(0).getInput1321t11();
							String value1321af2 = criteria1.get().getCriteria13Qn().get(0).getInput1321t12();
							System.out.println("existing value is============>" + value1321af1
									+ "      value1321af2=====> " + value1321af2);
							BigDecimal bdaf1 = new BigDecimal(value1321af1);
							BigDecimal bdaf2 = new BigDecimal(value1321af2);
							BigDecimal finalValueAf1 = bdaf1.add(new BigDecimal(
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7()));
							BigDecimal finalValueAf2 = bdaf2.add(new BigDecimal(
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5()));
							System.out.println("what is the final value ==>" + finalValueAf1
									+ "    finalValueAf2=====> " + finalValueAf2);
							System.out.println("unique key ==>"
									+ fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
							int update1341 = criteria1Repository.updateCriteria13QnAf(finalValueAf1, finalValueAf2,
									fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getUniqueKey1());
							System.out.println("update1341 affiliated u=======>" + update1341);

						}
					} else {

						System.out.println("inserting into cr1 main table else......");
						int criteria1Main = criteria1Repository.insertCriteria1Main(
								fieldInternsobj.getCriteriaId().getCollegeId(),
								fieldInternsobj.getCriteriaId().getFinancialYear(),
								fieldInternsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria1Main else====>" + criteria1Main);
						// insert 1341
						int result1321 = criteria1Repository.insertCriteria13QnAf(
								fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit7(),
								fieldInternsobj.getFieldorResearchProjectsInternships().get(0).getInputfrit5(), 1,
								fieldInternsobj.getCriteriaId().getCollegeId(),
								fieldInternsobj.getCriteriaId().getFinancialYear(),
								fieldInternsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result1321 affiliated inserted=======>" + result1321);

					}
				} else {
					System.out.println(" FieldResearchInterns is not mapped.................. ");
				}

				// return fieldResearchInternsRepository.save(fieldInternsobj);
			} else {
				System.out.println("fieldInterns obj is null or empty....................... ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Student-Mentor Ratio

	private RestAPIResponse getStudentMentorRatioUpdate(RestAPIRequest restAPIRequest) {
		try {
			
			if (restAPIRequest != null) {
				logger.info("studentMentorobj is ==>{}",mapper.writeValueAsString(restAPIRequest));
				if ("university".equalsIgnoreCase(restAPIRequest.getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(restAPIRequest.getCollegeId());
					key.setFinancialYear(restAPIRequest.getFinancialYear());
					key.setTypeofInstitution(restAPIRequest.getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria23Qn())) {
							System.out.println(" Cr23 Qn is empty.....");
							// Insert 233 tx
							int result233 = criteria2Repository.insertCriteria23Qn(
									restAPIRequest.getInputArg2(),
									restAPIRequest.getInputArg1(), 1,
									restAPIRequest.getCollegeId(),
									restAPIRequest.getFinancialYear(),
									restAPIRequest.getTypeofInstitution());
							System.out.println("result233 inserted=======>" + result233);
						} else {
							// update 233 tx
							System.out.println("Cr23 Qn is not  empty.....");
							String value233t1 = criteria2.get().getCriteria23Qn().get(0).getInput2331t1();
							String value233t2 = criteria2.get().getCriteria23Qn().get(0).getInput2331t2();
							System.out.println("existing value233t1 is============>" + value233t1 + "  value233t2====> "
									+ value233t2);
							BigDecimal bd1 = new BigDecimal(value233t1);
							BigDecimal bd2 = new BigDecimal(value233t2);
							BigDecimal finalValue1 = bd1.add(
									new BigDecimal(restAPIRequest.getInputArg2()));
							BigDecimal finalValue2 = bd2.add(
									new BigDecimal(restAPIRequest.getInputArg1()));
							System.out.println(
									"what is the final value ==>" + finalValue1 + "  finalValue2=====> " + finalValue2);
							System.out.println(
									"unique key ==>" + restAPIRequest.getUniqueKey1());
							int update233 = criteria2Repository.updateCriteria23Qn(finalValue1, finalValue2,
									restAPIRequest.getUniqueKey1());
							System.out.println("update233 u=======>" + update233);

						}
					} else {

						System.out.println("inserting into cr2 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								restAPIRequest.getCollegeId(),
								restAPIRequest.getFinancialYear(),
								restAPIRequest.getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// Insert 233 tx
						int result233 = criteria2Repository.insertCriteria23Qn(
								restAPIRequest.getInputArg2(),
								restAPIRequest.getInputArg1(), 1,
								restAPIRequest.getCollegeId(),
								restAPIRequest.getFinancialYear(),
								restAPIRequest.getTypeofInstitution());
						System.out.println("result233 inserted=======>" + result233);
					}
				}
				// 2.3.3 Au
				else if ("autonomous".equalsIgnoreCase(restAPIRequest.getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(restAPIRequest.getCollegeId());
					key.setFinancialYear(restAPIRequest.getFinancialYear());
					key.setTypeofInstitution(restAPIRequest.getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria23Qn())) {
							System.out.println(" Cr23 Qn is empty.....");
							// Insert 233 tx
							int result233 = criteria2Repository.insertCriteria23Qn(
									restAPIRequest.getInputArg2(),
									restAPIRequest.getInputArg1(), 1,
									restAPIRequest.getCollegeId(),
									restAPIRequest.getFinancialYear(),
									restAPIRequest.getTypeofInstitution());
							System.out.println("result233 inserted=======>" + result233);
						} else {
							// update 233 tx
							System.out.println("Cr23 Qn is not  empty.....");
							String value233t1 = criteria2.get().getCriteria23Qn().get(0).getInput2331t1();
							String value233t2 = criteria2.get().getCriteria23Qn().get(0).getInput2331t2();
							System.out.println("existing value233t1 is============>" + value233t1 + "  value233t2====> "
									+ value233t2);
							BigDecimal bd1 = new BigDecimal(value233t1);
							BigDecimal bd2 = new BigDecimal(value233t2);
							BigDecimal finalValue1 = bd1.add(
									new BigDecimal(restAPIRequest.getInputArg2()));
							BigDecimal finalValue2 = bd2.add(
									new BigDecimal(restAPIRequest.getInputArg1()));
							System.out.println(
									"what is the final value ==>" + finalValue1 + "  finalValue2=====> " + finalValue2);
							System.out.println(
									"unique key ==>" + restAPIRequest.getUniqueKey1());
							int update233 = criteria2Repository.updateCriteria23Qn(finalValue1, finalValue2,
									restAPIRequest.getUniqueKey1());
							System.out.println("update233 u=======>" + update233);

						}
					} else {

						System.out.println("inserting into cr2 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								restAPIRequest.getCollegeId(),
								restAPIRequest.getFinancialYear(),
								restAPIRequest.getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// Insert 233 tx
						int result233 = criteria2Repository.insertCriteria23Qn(
								restAPIRequest.getInputArg2(),
								restAPIRequest.getInputArg1(), 1,
								restAPIRequest.getCollegeId(),
								restAPIRequest.getFinancialYear(),
								restAPIRequest.getTypeofInstitution());
						System.out.println("result233 inserted=======>" + result233);
					}
				}
			}
			restAPIResponse.setErrorCode("001");
			restAPIResponse.setErrorMessage("Success");
		}

		catch (Exception e) {
			e.printStackTrace();
			restAPIResponse.setErrorCode("002");
			restAPIResponse.setErrorMessage(e.getMessage());
			return restAPIResponse;
		}
		return restAPIResponse;
	}

// Full Time Teachers PHD

	private void getFullTimeTeachPHDUpdate() {
		try {
			List<FullTimeTeachersPhdMain> ftTeachPhd1 = fullTimeTeachPhdService.getAllFtTeachPhdData();
			FullTimeTeachersPhdMain ftTeachPhd = null;
			if (ftTeachPhd1 != null) {
				ftTeachPhd = ftTeachPhd1.get(0);
			}
			if (ftTeachPhd != null) {
				if ("university".equalsIgnoreCase(ftTeachPhd.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(ftTeachPhd.getCriteriaId().getCollegeId());
					key.setFinancialYear(ftTeachPhd.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(ftTeachPhd.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getYearTable2421())) {
							System.out.println(" yr 2421 is empty.....");
							// Insert 2421 tb area
							int result242 = criteria2Repository.insertYearTable2421(
									ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(), 1, 1,
									ftTeachPhd.getCriteriaId().getCollegeId(),
									ftTeachPhd.getCriteriaId().getFinancialYear(),
									ftTeachPhd.getCriteriaId().getTypeofInstitution());
							System.out.println("result242 inserted=======>" + result242);
// insert 2431 tx
							int result2431 = criteria2Repository.insertCriteria243Qn(
									ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht7(), 1, 1,
									ftTeachPhd.getCriteriaId().getCollegeId(),
									ftTeachPhd.getCriteriaId().getFinancialYear(),
									ftTeachPhd.getCriteriaId().getTypeofInstitution());
							System.out.println("result2431 inserted=======>" + result2431);
						} else {
							// update 2421 tx area
							System.out.println("yr 2421 is not  empty.....");
							String value2421 = criteria2.get().getYearTable2421().get(0).getInput2421v();
							System.out.println("existing value is============>" + value2421);
							BigDecimal bd = new BigDecimal(value2421);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println(
									"unique key ==>" + ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
							int update2421 = criteria2Repository.updateYearTable2421(finalValue,
									ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
							System.out.println("update2421 u=======>" + update2421);
//update 2431 tx 
							System.out.println("yr 2431 is not  empty.....");
							String value2431t1 = criteria2.get().getCriteria24Qn().get(0).getInput2431t1();
							String value2431t2 = criteria2.get().getCriteria24Qn().get(0).getInput2431t2();
							System.out.println("existing value2431t1 is============>" + value2431t1
									+ "    value2431t2=====>" + value2431t2);
							BigDecimal bd1 = new BigDecimal(value2431t1);
							BigDecimal bd2 = new BigDecimal(value2431t2);
							BigDecimal finalValue1 = bd1
									.add(new BigDecimal(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht7()));
							int finalValue2 = bd2.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue1);
							System.out.println(
									"unique key ==>" + ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
							int update2431 = criteria2Repository.updateCriteria243Qn(finalValue1, finalValue2,
									ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
							System.out.println("update2431 u=======>" + update2431);

						}
					} else {

						System.out.println("inserting into cr2 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								ftTeachPhd.getCriteriaId().getCollegeId(),
								ftTeachPhd.getCriteriaId().getFinancialYear(),
								ftTeachPhd.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// insert 2421 tb area
						int result242 = criteria2Repository.insertYearTable2421(
								ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(), 1, 1,
								ftTeachPhd.getCriteriaId().getCollegeId(),
								ftTeachPhd.getCriteriaId().getFinancialYear(),
								ftTeachPhd.getCriteriaId().getTypeofInstitution());
						System.out.println("result242 inserted=======>" + result242);
						// insert 2431 tx
						int result2431 = criteria2Repository.insertCriteria243Qn(
								ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht7(), 1, 1,
								ftTeachPhd.getCriteriaId().getCollegeId(),
								ftTeachPhd.getCriteriaId().getFinancialYear(),
								ftTeachPhd.getCriteriaId().getTypeofInstitution());
						System.out.println("result2431 inserted=======>" + result2431);

					}
				}
				// 2421 & 2431 Au
				else if ("autonomous".equalsIgnoreCase(ftTeachPhd.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(ftTeachPhd.getCriteriaId().getCollegeId());
					key.setFinancialYear(ftTeachPhd.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(ftTeachPhd.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getYearTable2421())) {
							System.out.println(" yr 2421 is empty.....");
							// Insert 2421 tb area
							int result242 = criteria2Repository.insertYearTable2421(
									ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(), 1, 1,
									ftTeachPhd.getCriteriaId().getCollegeId(),
									ftTeachPhd.getCriteriaId().getFinancialYear(),
									ftTeachPhd.getCriteriaId().getTypeofInstitution());
							System.out.println("result242 inserted=======>" + result242);
							// insert 2431 tx
							int result2431 = criteria2Repository.insertCriteria243Qn(
									ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht7(), 1, 1,
									ftTeachPhd.getCriteriaId().getCollegeId(),
									ftTeachPhd.getCriteriaId().getFinancialYear(),
									ftTeachPhd.getCriteriaId().getTypeofInstitution());
							System.out.println("result2431 inserted=======>" + result2431);
						} else {
							// update 2421 tx area
							System.out.println("yr 2421 is not  empty.....");
							String value2421 = criteria2.get().getYearTable2421().get(0).getInput2421v();
							System.out.println("existing value is============>" + value2421);
							BigDecimal bd = new BigDecimal(value2421);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println(
									"unique key ==>" + ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
							int update2421 = criteria2Repository.updateYearTable2421(finalValue,
									ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
							System.out.println("update2421 u=======>" + update2421);
							// update 2431 tx
							System.out.println("yr 2431 is not  empty.....");
							String value2431t1 = criteria2.get().getCriteria24Qn().get(0).getInput2431t1();
							String value2431t2 = criteria2.get().getCriteria24Qn().get(0).getInput2431t2();
							System.out.println("existing value2431t1 is============>" + value2431t1
									+ "    value2431t2=====>" + value2431t2);
							BigDecimal bd1 = new BigDecimal(value2431t1);
							BigDecimal bd2 = new BigDecimal(value2431t2);
							BigDecimal finalValue1 = bd1
									.add(new BigDecimal(ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht5()));
							int finalValue2 = bd2.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue1);
							System.out.println(
									"unique key ==>" + ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
							int update2431 = criteria2Repository.updateCriteria243Qn(finalValue1, finalValue2,
									ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
							System.out.println("update2431 u=======>" + update2431);

						}
					} else {

						System.out.println("inserting into cr2 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								ftTeachPhd.getCriteriaId().getCollegeId(),
								ftTeachPhd.getCriteriaId().getFinancialYear(),
								ftTeachPhd.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// insert 2421 tb area
						int result242 = criteria2Repository.insertYearTable2421(
								ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(), 1, 1,
								ftTeachPhd.getCriteriaId().getCollegeId(),
								ftTeachPhd.getCriteriaId().getFinancialYear(),
								ftTeachPhd.getCriteriaId().getTypeofInstitution());
						System.out.println("result242 inserted=======>" + result242);
						// insert 2431 tx
						int result2431 = criteria2Repository.insertCriteria243Qn(
								ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht7(), 1, 1,
								ftTeachPhd.getCriteriaId().getCollegeId(),
								ftTeachPhd.getCriteriaId().getFinancialYear(),
								ftTeachPhd.getCriteriaId().getTypeofInstitution());
						System.out.println("result2431 inserted=======>" + result2431);

					}
				}
				// 2421 Af
				else if ("affiliated".equalsIgnoreCase(ftTeachPhd.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(ftTeachPhd.getCriteriaId().getCollegeId());
					key.setFinancialYear(ftTeachPhd.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(ftTeachPhd.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getYearTable2421())) {
							System.out.println(" yr 2421 is empty affiliated.....");
							// Insert 2421 tx area
							int result242 = criteria2Repository.insertYearTable2421(
									ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(), 1, 1,
									ftTeachPhd.getCriteriaId().getCollegeId(),
									ftTeachPhd.getCriteriaId().getFinancialYear(),
									ftTeachPhd.getCriteriaId().getTypeofInstitution());
							System.out.println("result2421 affiliated inserted=======>" + result242);
						} else {
							// update 2421 tx area
							System.out.println("yr 2421 is not  empty.....");
							String value2421 = criteria2.get().getYearTable2421().get(0).getInput2421v();
							System.out.println("existing value is============>" + value2421);
							BigDecimal bd = new BigDecimal(value2421);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println(
									"unique key ==>" + ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
							int update2421 = criteria2Repository.updateYearTable2421(finalValue,
									ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getUniqueKey1());
							System.out.println("update2421 affiliated u=======>" + update2421);

						}
					} else {

						System.out.println("inserting into cr2 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								ftTeachPhd.getCriteriaId().getCollegeId(),
								ftTeachPhd.getCriteriaId().getFinancialYear(),
								ftTeachPhd.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main affiliated else====>" + criteria2Main);
						// insert 2421 tx area
						int result242 = criteria2Repository.insertYearTable2421(
								ftTeachPhd.getFullTimeTeacherswithPhd().get(0).getInputpht6(), 1, 1,
								ftTeachPhd.getCriteriaId().getCollegeId(),
								ftTeachPhd.getCriteriaId().getFinancialYear(),
								ftTeachPhd.getCriteriaId().getTypeofInstitution());
						System.out.println("result2421 affiliated inserted=======>" + result242);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Attainment

	private void getAttainmentsUpdate() {
		try {
			List<AttainmentsMain> attainmentsobj1 = attainmentsService.getAllAttainmentData();
			AttainmentsMain attainmentsobj = null;
			if (attainmentsobj1 != null) {
				attainmentsobj = attainmentsobj1.get(0);
			}
			if (attainmentsobj != null) {
				// 2.6.2 U
				if ("university".equalsIgnoreCase(attainmentsobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(attainmentsobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(attainmentsobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(attainmentsobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria26Ql())) {
							System.out.println("cr2 Ql is empty.....");
							// Insert 262 tx area
							int result262 = criteria2Repository.insertCriteria26Ql(
									attainmentsobj.getAttainments().get(0).getInputat4(), 1,
									attainmentsobj.getCriteriaId().getCollegeId(),
									attainmentsobj.getCriteriaId().getFinancialYear(),
									attainmentsobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result262 inserted=======>" + result262);
						} else {
							// update 262 tx area
							System.out.println("yr 262 is not  empty.....");
							String value262t1 = criteria2.get().getCriteria26Ql().get(0).getResponse262();
							String value262t2 = criteria2.get().getCriteria26Ql().get(0).getInput262t1();
							System.out.println("existing value262t1 is============>" + value262t1 + "   value262t2====>"
									+ value262t2);
							System.out
									.println("unique key ==>" + attainmentsobj.getAttainments().get(0).getUniqueKey1());
							int update262 = criteria2Repository.updateCriteria26Ql(
									attainmentsobj.getAttainments().get(0).getInputat4(),
									attainmentsobj.getAttainments().get(0).getUniqueKey1());
							System.out.println("update262 u=======>" + update262);
						}
					} else {

						System.out.println("inserting into cr2 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								attainmentsobj.getCriteriaId().getCollegeId(),
								attainmentsobj.getCriteriaId().getFinancialYear(),
								attainmentsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// Insert 262 tx area
						int result262 = criteria2Repository.insertCriteria26Ql(
								attainmentsobj.getAttainments().get(0).getInputat4(), 1,
								attainmentsobj.getCriteriaId().getCollegeId(),
								attainmentsobj.getCriteriaId().getFinancialYear(),
								attainmentsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result262 inserted=======>" + result262);

					}
				}
				// 2.6.2 Au
				else if ("autonomous".equalsIgnoreCase(attainmentsobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(attainmentsobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(attainmentsobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(attainmentsobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria26Ql())) {
							System.out.println("cr2 Ql is empty.....");
							// Insert 262 tx area
							int result262 = criteria2Repository.insertCriteria26Ql(
									attainmentsobj.getAttainments().get(0).getInputat4(), 1,
									attainmentsobj.getCriteriaId().getCollegeId(),
									attainmentsobj.getCriteriaId().getFinancialYear(),
									attainmentsobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result262 inserted=======>" + result262);
						} else {
							// update 262 tx area
							System.out.println("yr 262 is not  empty.....");
							String value262t1 = criteria2.get().getCriteria26Ql().get(0).getResponse262();
							String value262t2 = criteria2.get().getCriteria26Ql().get(0).getInput262t1();
							System.out.println("existing value262t1 is============>" + value262t1 + "   value262t2====>"
									+ value262t2);
							System.out
									.println("unique key ==>" + attainmentsobj.getAttainments().get(0).getUniqueKey1());
							int update262 = criteria2Repository.updateCriteria26Ql(
									attainmentsobj.getAttainments().get(0).getInputat4(),
									attainmentsobj.getAttainments().get(0).getUniqueKey1());
							System.out.println("update262 u=======>" + update262);
						}
					} else {

						System.out.println("inserting into cr2 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								attainmentsobj.getCriteriaId().getCollegeId(),
								attainmentsobj.getCriteriaId().getFinancialYear(),
								attainmentsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// Insert 262 tx area
						int result262 = criteria2Repository.insertCriteria26Ql(
								attainmentsobj.getAttainments().get(0).getInputat4(), 1,
								attainmentsobj.getCriteriaId().getCollegeId(),
								attainmentsobj.getCriteriaId().getFinancialYear(),
								attainmentsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result262 inserted=======>" + result262);

					}
				} else {
					System.out.println("Attainments data not Mapped........");
				}

			} else {
				System.out.println("attainmentsobj is null or empty........");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Pass Percent of Students

	private void getPassPercentOfStudentsUpdate() {
		try {
			List<PassPercentStudMain> passPercentobj1 = passPercentStudService.getAllPassPercentData();
			PassPercentStudMain passPercentobj = null;
			if (passPercentobj1 != null) {
				passPercentobj = passPercentobj1.get(0);
			}
			if (passPercentobj != null) {
				// 2.6.3 U,Au
				if ("university".equalsIgnoreCase(passPercentobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(passPercentobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(passPercentobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(passPercentobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria26Qn())) {
							System.out.println(" cr 26Qn is empty.....");
							// Insert 2631 & 2632
							int result2631 = criteria2Repository.insertCriteria26Qn(
									passPercentobj.getPassPercentofStudents().get(0).getInputpst5(),
									passPercentobj.getPassPercentofStudents().get(0).getInputpst6(), 1,
									passPercentobj.getCriteriaId().getCollegeId(),
									passPercentobj.getCriteriaId().getFinancialYear(),
									passPercentobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result2631  2632 inserted=======>" + result2631);
						} else {
							// update 2631 & 2632
							System.out.println("Cr26 Qn is not  empty.....");
							String value2631 = criteria2.get().getCriteria26Qn().get(0).getInput2631t1();
							String value2632 = criteria2.get().getCriteria26Qn().get(0).getInput2632t1();
							System.out.println(
									"existing value is============>" + value2631 + "  value2632=====>" + value2632);
							BigDecimal bd1 = new BigDecimal(value2631);
							BigDecimal bd2 = new BigDecimal(value2632);
							BigDecimal finalValue1 = bd1.add(
									new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst5()));
							BigDecimal finalValue2 = bd2.add(
									new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst6()));
							System.out.println("what is the final value1 ==>" + finalValue1 + "   finalValue2=====>"
									+ finalValue2);
							System.out.println("unique key ==>"
									+ passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
							int update2631 = criteria2Repository.updateCriteria26Qn(finalValue1, finalValue2,
									passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
							System.out.println("update2631 u=======>" + update2631);
						}
					} else {

						System.out.println("inserting into cr2 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								passPercentobj.getCriteriaId().getCollegeId(),
								passPercentobj.getCriteriaId().getFinancialYear(),
								passPercentobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// insert 2421 tx area
						int result2631 = criteria2Repository.insertCriteria26Qn(
								passPercentobj.getPassPercentofStudents().get(0).getInputpst5(),
								passPercentobj.getPassPercentofStudents().get(0).getInputpst6(), 1,
								passPercentobj.getCriteriaId().getCollegeId(),
								passPercentobj.getCriteriaId().getFinancialYear(),
								passPercentobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result2631 2632 inserted=======>" + result2631);

					}
				}
				// 2.6.3 Au
				else if ("autonomous".equalsIgnoreCase(passPercentobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(passPercentobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(passPercentobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(passPercentobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria26Qn())) {
							System.out.println(" cr 26Qn is empty.....");
							// Insert 2631 & 2632
							int result2631 = criteria2Repository.insertCriteria26Qn(
									passPercentobj.getPassPercentofStudents().get(0).getInputpst6(),
									passPercentobj.getPassPercentofStudents().get(0).getInputpst5(), 1,
									passPercentobj.getCriteriaId().getCollegeId(),
									passPercentobj.getCriteriaId().getFinancialYear(),
									passPercentobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result2631  2632 inserted=======>" + result2631);
						} else {
							// update 2631 & 2632
							System.out.println("Cr26 Qn is not  empty.....");
							String value2631 = criteria2.get().getCriteria26Qn().get(0).getInput2631t1();
							String value2632 = criteria2.get().getCriteria26Qn().get(0).getInput2632t1();
							System.out.println(
									"existing value is============>" + value2631 + "  value2632=====>" + value2632);
							BigDecimal bd1 = new BigDecimal(value2631);
							BigDecimal bd2 = new BigDecimal(value2632);
							BigDecimal finalValue1 = bd1.add(
									new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst6()));
							BigDecimal finalValue2 = bd2.add(
									new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst5()));
							System.out.println("what is the final value1 ==>" + finalValue1 + "   finalValue2=====>"
									+ finalValue2);
							System.out.println("unique key ==>"
									+ passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
							int update2631 = criteria2Repository.updateCriteria26Qn(finalValue1, finalValue2,
									passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
							System.out.println("update2631 u=======>" + update2631);
						}
					} else {

						System.out.println("inserting into cr2 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								passPercentobj.getCriteriaId().getCollegeId(),
								passPercentobj.getCriteriaId().getFinancialYear(),
								passPercentobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// insert 2421 tx area
						int result2631 = criteria2Repository.insertCriteria26Qn(
								passPercentobj.getPassPercentofStudents().get(0).getInputpst6(),
								passPercentobj.getPassPercentofStudents().get(0).getInputpst5(), 1,
								passPercentobj.getCriteriaId().getCollegeId(),
								passPercentobj.getCriteriaId().getFinancialYear(),
								passPercentobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result2631 2632 inserted=======>" + result2631);

					}
				}
				// 2.6.2.1 Af
				else if ("affiliated".equalsIgnoreCase(passPercentobj.getCriteriaId().getTypeofInstitution())) {
					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(passPercentobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(passPercentobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(passPercentobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getCriteria26Qn())) {
							System.out.println(" cr 26Qn is empty.....");
							// Insert 2621 & 2622
							int result2621 = criteria2Repository.insertCriteria26QnAf(
									passPercentobj.getPassPercentofStudents().get(0).getInputpst6(),
									passPercentobj.getPassPercentofStudents().get(0).getInputpst5(), 1,
									passPercentobj.getCriteriaId().getCollegeId(),
									passPercentobj.getCriteriaId().getFinancialYear(),
									passPercentobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result2621  2622 affiliated inserted=======>" + result2621);
						} else {
							// update 2631 & 2632
							System.out.println("Cr26 Qn is not  empty.....");
							String value2621Af = criteria2.get().getCriteria26Qn().get(0).getInput2621t1();
							String value2622Af = criteria2.get().getCriteria26Qn().get(0).getInput2622t2();
							System.out.println("existing value2621Af is============>" + value2621Af
									+ "  value2622Af=====>" + value2622Af);
							BigDecimal bd3 = new BigDecimal(value2621Af);
							BigDecimal bd4 = new BigDecimal(value2622Af);
							BigDecimal finalValue3 = bd3.add(
									new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst6()));
							BigDecimal finalValue4 = bd4.add(
									new BigDecimal(passPercentobj.getPassPercentofStudents().get(0).getInputpst5()));
							System.out.println("what is the final value1 ==>" + finalValue3 + "   finalValue2=====>"
									+ finalValue4);
							System.out.println("unique key ==>"
									+ passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
							int update2621Af = criteria2Repository.updateCriteria26QnAf(finalValue3, finalValue4,
									passPercentobj.getPassPercentofStudents().get(0).getUniqueKey1());
							System.out.println("update2621Af affiliated u=======>" + update2621Af);
						}
					} else {

						System.out.println("inserting into cr2 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								passPercentobj.getCriteriaId().getCollegeId(),
								passPercentobj.getCriteriaId().getFinancialYear(),
								passPercentobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main affiliated else====>" + criteria2Main);
						// insert 2421 tx area
						int result2621 = criteria2Repository.insertCriteria26QnAf(
								passPercentobj.getPassPercentofStudents().get(0).getInputpst6(),
								passPercentobj.getPassPercentofStudents().get(0).getInputpst5(), 1,
								passPercentobj.getCriteriaId().getCollegeId(),
								passPercentobj.getCriteriaId().getFinancialYear(),
								passPercentobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result2621  2622 affiliated inserted=======>" + result2621);

					}
				} else {
					System.out.println("Pass percent of Students data is not mapped................");
				}

			} else {
				System.out.println("passPercentobj is null or empty.............");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Seed Money

	private void getSeedMoneyCriteriasUpdate() {
		try {
			List<SeedMoneyMain> seedMoney1 = seedMoneyService.getAllFacultyData();
			SeedMoneyMain seedMoney = null;
			if (seedMoney1 != null) {
				seedMoney = seedMoney1.get(0);
			}
			if (seedMoney != null) {
				// 3.1.2 U
				if ("university".equalsIgnoreCase(seedMoney.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(seedMoney.getCriteriaId().getCollegeId());
					key.setFinancialYear(seedMoney.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(seedMoney.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3121())) {
							System.out.println(" yr 3121  is empty.....");
							// Insert 3121 tb
							int result312 = criteria3Repository.insertYearTable3121(
									seedMoney.getSeedMoney().get(0).getInputsmt5(),
									seedMoney.getSeedMoney().get(0).getInputsmt4(), 1,
									seedMoney.getCriteriaId().getCollegeId(),
									seedMoney.getCriteriaId().getFinancialYear(),
									seedMoney.getCriteriaId().getTypeofInstitution());
							System.out.println("result312 inserted=======>" + result312);
						} else {
							// update 3121 tb
							System.out.println("yr 3121 is not  empty.....");
							String value3121 = criteria3.get().getYearTable3121().get(0).getInput3121v();
							System.out.println("existing value is============>" + value3121);
							BigDecimal bd = new BigDecimal(value3121);
							BigDecimal finalValue = bd
									.add(new BigDecimal(seedMoney.getSeedMoney().get(0).getInputsmt4()));
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>" + seedMoney.getSeedMoney().get(0).getUniqueKey1());
							int update3121 = criteria3Repository.updateYearTable3121(finalValue,
									seedMoney.getSeedMoney().get(0).getUniqueKey1());
							System.out.println("update3121 u=======>" + update3121);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								seedMoney.getCriteriaId().getCollegeId(), seedMoney.getCriteriaId().getFinancialYear(),
								seedMoney.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// insert 3121 tb
						int result312 = criteria3Repository.insertYearTable3121(
								seedMoney.getSeedMoney().get(0).getInputsmt5(),
								seedMoney.getSeedMoney().get(0).getInputsmt4(), 1,
								seedMoney.getCriteriaId().getCollegeId(), seedMoney.getCriteriaId().getFinancialYear(),
								seedMoney.getCriteriaId().getTypeofInstitution());
						System.out.println("result312 inserted else=======>" + result312);

					}
				} else if ("autonomous".equalsIgnoreCase(seedMoney.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(seedMoney.getCriteriaId().getCollegeId());
					key.setFinancialYear(seedMoney.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(seedMoney.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3121())) {
							System.out.println(" yr 3121  is empty.....");
							// Insert 3121 tb
							int result312 = criteria3Repository.insertYearTable3121(
									seedMoney.getSeedMoney().get(0).getInputsmt5(),
									seedMoney.getSeedMoney().get(0).getInputsmt4(), 1,
									seedMoney.getCriteriaId().getCollegeId(),
									seedMoney.getCriteriaId().getFinancialYear(),
									seedMoney.getCriteriaId().getTypeofInstitution());
							System.out.println("result312 inserted=======>" + result312);
						} else {
							// update 3121 tb
							System.out.println("yr 3121 is not  empty.....");
							String value3121 = criteria3.get().getYearTable3121().get(0).getInput3121v();
							System.out.println("existing value is============>" + value3121);
							BigDecimal bd = new BigDecimal(value3121);
							BigDecimal finalValue = bd
									.add(new BigDecimal(seedMoney.getSeedMoney().get(0).getInputsmt4()));
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>" + seedMoney.getSeedMoney().get(0).getUniqueKey1());
							int update3121 = criteria3Repository.updateYearTable3121(finalValue,
									seedMoney.getSeedMoney().get(0).getUniqueKey1());
							System.out.println("update3121 u=======>" + update3121);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								seedMoney.getCriteriaId().getCollegeId(), seedMoney.getCriteriaId().getFinancialYear(),
								seedMoney.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// insert 3121 tb
						int result312 = criteria3Repository.insertYearTable3121(
								seedMoney.getSeedMoney().get(0).getInputsmt5(),
								seedMoney.getSeedMoney().get(0).getInputsmt4(), 1,
								seedMoney.getCriteriaId().getCollegeId(), seedMoney.getCriteriaId().getFinancialYear(),
								seedMoney.getCriteriaId().getTypeofInstitution());
						System.out.println("result312 inserted else=======>" + result312);

					}
				}
        
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// grants Research Projects

	private void getGrantsResearchCriteriasUpdate() {
		try {
			List<GrantsResearchMain> grantInfo1 = grantResearchService.getAllGrantResearchData();
			GrantsResearchMain grantInfo = null;
			if (grantInfo1 != null) {
				grantInfo = grantInfo1.get(0);
			}
			if (grantInfo != null) {
				// 3231 U
				if ("university".equalsIgnoreCase(grantInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(grantInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(grantInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(grantInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable3231())) {
							System.out.println(" yr 3231 is empty.....");
							// Insert 3231
							int result3231 = criteria3Repository.insertYearTable3231(
									grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
									grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
									grantInfo.getCriteriaId().getCollegeId(),
									grantInfo.getCriteriaId().getFinancialYear(),
									grantInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3231 inserted=======>" + result3231);
							// 3221 insert
							if ("government"
									.equalsIgnoreCase(grantInfo.getGrantsResearchProjects().get(0).getInputgrt6())) {
								int result3221 = criteria3Repository.insertYearTable3221U(
										grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
										grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
										grantInfo.getCriteriaId().getCollegeId(),
										grantInfo.getCriteriaId().getFinancialYear(),
										grantInfo.getCriteriaId().getTypeofInstitution());
								System.out.println("result3221 inserted=======>" + result3221);
							}
							// Insert 3211
							else {
								int result3211 = criteria3Repository.insertYearTable3211U(
										grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
										grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
										grantInfo.getCriteriaId().getCollegeId(),
										grantInfo.getCriteriaId().getFinancialYear(),
										grantInfo.getCriteriaId().getTypeofInstitution());
								System.out.println("result3211 inserted=======>" + result3211);
							}
						} else {
							// update 3231
							System.out.println("yr 3231 is not  empty.....");
							String value3231 = criteria3.get().getUniversityYearTable3231().get(0).getInput3231v();
							System.out.println("existing value is============>" + value3231);
							BigDecimal bd1 = new BigDecimal(value3231);
							BigDecimal finalValue1 = bd1
									.add(new BigDecimal(grantInfo.getGrantsResearchProjects().get(0).getInputgrt9()));
							System.out.println("what is the final value1 ==>" + finalValue1);
							System.out.println(
									"unique key ==>" + grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
							int update3231 = criteria3Repository.updateYearTable3231(finalValue1,
									grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
							System.out.println("update3231 u=======>" + update3231);

							System.out.println("inserting into yr tb 3221......");

							if (CollectionUtils.isEmpty(criteria3.get().getYearTable3221())) {
								// insert 3221
								int result3221 = criteria3Repository.insertYearTable3221U(
										grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
										grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
										grantInfo.getCriteriaId().getCollegeId(),
										grantInfo.getCriteriaId().getFinancialYear(),
										grantInfo.getCriteriaId().getTypeofInstitution());
								System.out.println("result3221 inserted=======>" + result3221);
							} else {
								// Insert 3221
								System.out.println("yr 3221 is not  empty.....");
								String value3221 = criteria3.get().getYearTable3221().get(0).getInput3221v();
								System.out.println("existing value3221 is============>" + value3221);
								BigDecimal bd3 = new BigDecimal(value3221);
								BigDecimal finalValue3221 = bd3.add(
										new BigDecimal(grantInfo.getGrantsResearchProjects().get(0).getInputgrt9()));
								System.out.println("what is the finalValue3221 ==>" + finalValue3221);
								System.out.println("unique key ==>"
										+ grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
								int update3221 = criteria3Repository.updateYearTable3221U(finalValue3221,
										grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
								System.out.println("update3221 u=======>" + update3221);
							}

							System.out.println("inserting into yr tb 3211......");

							if (CollectionUtils.isEmpty(criteria3.get().getYearTable3211())) {
								// Insert 3211
								int result3211 = criteria3Repository.insertYearTable3211U(
										grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
										grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
										grantInfo.getCriteriaId().getCollegeId(),
										grantInfo.getCriteriaId().getFinancialYear(),
										grantInfo.getCriteriaId().getTypeofInstitution());
								System.out.println("result3211 inserted=======>" + result3211);
							} else {
								// update 3211
								System.out.println("yr 3211 is not  empty.....");
								String value3211 = criteria3.get().getYearTable3211().get(0).getInput3211v();
								System.out.println("existing value3211 is============>" + value3211);
								BigDecimal bd2 = new BigDecimal(value3211);
								BigDecimal finalValue3211 = bd2.add(
										new BigDecimal(grantInfo.getGrantsResearchProjects().get(0).getInputgrt9()));
								System.out.println("what is the finalValue3211 ==>" + finalValue3211);
								System.out.println("unique key ==>"
										+ grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
								int update3211 = criteria3Repository.updateYearTable3211U(finalValue3211,
										grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
								System.out.println("update3211 u=======>" + update3211);
							}
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								grantInfo.getCriteriaId().getCollegeId(), grantInfo.getCriteriaId().getFinancialYear(),
								grantInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3231
						int result3231 = criteria3Repository.insertYearTable3231(
								grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
								grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
								grantInfo.getCriteriaId().getCollegeId(), grantInfo.getCriteriaId().getFinancialYear(),
								grantInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3231 inserted=======>" + result3231);

						// 3221 insert
						if ("government"
								.equalsIgnoreCase(grantInfo.getGrantsResearchProjects().get(0).getInputgrt6())) {
							int result3221 = criteria3Repository.insertYearTable3221U(
									grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
									grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
									grantInfo.getCriteriaId().getCollegeId(),
									grantInfo.getCriteriaId().getFinancialYear(),
									grantInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3221 inserted=======>" + result3221);
						}
						// Insert 3211
						else {
							int result3211 = criteria3Repository.insertYearTable3211U(
									grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
									grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
									grantInfo.getCriteriaId().getCollegeId(),
									grantInfo.getCriteriaId().getFinancialYear(),
									grantInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3211 inserted=======>" + result3211);
						}
					}
				}
				// 3211 Au
				else if ("autonomous".equalsIgnoreCase(grantInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(grantInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(grantInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(grantInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3211())) {
							System.out.println(" yr 3211 is empty.....");
							// Insert 3211
							int result3211 = criteria3Repository.insertYearTable3211Au(
									grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
									grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
									grantInfo.getCriteriaId().getCollegeId(),
									grantInfo.getCriteriaId().getFinancialYear(),
									grantInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3211 inserted=======>" + result3211);
						} else {
							// update 3211
							System.out.println("yr 3211 is not  empty.....");
							String value3211 = criteria3.get().getYearTable3211().get(0).getInput3211v();
							System.out.println("existing value is============>" + value3211);
							BigDecimal bd1 = new BigDecimal(value3211);
							BigDecimal finalValue2 = bd1
									.add(new BigDecimal(grantInfo.getGrantsResearchProjects().get(0).getInputgrt9()));
							System.out.println("what is the final value1 ==>" + finalValue2);
							System.out.println(
									"unique key ==>" + grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
							int update3211 = criteria3Repository.updateYearTable3211Au(finalValue2,
									grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
							System.out.println("update3211 u=======>" + update3211);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								grantInfo.getCriteriaId().getCollegeId(), grantInfo.getCriteriaId().getFinancialYear(),
								grantInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3211
						int result3211 = criteria3Repository.insertYearTable3211Au(
								grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
								grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
								grantInfo.getCriteriaId().getCollegeId(), grantInfo.getCriteriaId().getFinancialYear(),
								grantInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3211 inserted=======>" + result3211);

					}
				}
				// 3111 Af
				else if ("affiliated".equalsIgnoreCase(grantInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(grantInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(grantInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(grantInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getAffiliatedYearTable3111())) {
							System.out.println(" yr 3111 is empty.....");
							// Insert 3111
							int result3111 = criteria3Repository.insertYearTable3111Af(
									grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
									grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
									grantInfo.getCriteriaId().getCollegeId(),
									grantInfo.getCriteriaId().getFinancialYear(),
									grantInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3111 inserted=======>" + result3111);
						} else {
							// update 3231
							System.out.println("yr 3111 is not  empty.....");
							String value3111 = criteria3.get().getAffiliatedYearTable3111().get(0).getInput3111v();
							System.out.println("existing value is============>" + value3111);
							BigDecimal bd1 = new BigDecimal(value3111);
							BigDecimal finalValue3 = bd1
									.add(new BigDecimal(grantInfo.getGrantsResearchProjects().get(0).getInputgrt9()));
							System.out.println("what is the final value1 ==>" + finalValue3);
							System.out.println(
									"unique key ==>" + grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
							int update3111 = criteria3Repository.updateYearTable3111Af(finalValue3,
									grantInfo.getGrantsResearchProjects().get(0).getUniqueKey1());
							System.out.println("update3111 u=======>" + update3111);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								grantInfo.getCriteriaId().getCollegeId(), grantInfo.getCriteriaId().getFinancialYear(),
								grantInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3111
						int result3111 = criteria3Repository.insertYearTable3111Af(
								grantInfo.getGrantsResearchProjects().get(0).getInputgrt8(),
								grantInfo.getGrantsResearchProjects().get(0).getInputgrt9(), 1,
								grantInfo.getCriteriaId().getCollegeId(), grantInfo.getCriteriaId().getFinancialYear(),
								grantInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3111 inserted=======>" + result3111);

					}
				} else {
					System.out.println("Grants data not mapped.............................");
				}
			} else {
				System.out.println("grants obj is null or empty.............................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// No.of Workshops

	private void getNoOfWorkshopsCriteriasUpdate() {
		try {
			List<NumberofWorkshopsSeminorsMain> noofWorkshopspobj1 = noOfWorkshopsSeminarsService
					.getAllNoOfWorkshopsData();
			NumberofWorkshopsSeminorsMain noofWorkshopspobj = null;
			if (noofWorkshopspobj1 != null) {
				noofWorkshopspobj = noofWorkshopspobj1.get(0);
			}
			if (noofWorkshopspobj != null) {
				// 3321 U
				if ("university".equalsIgnoreCase(noofWorkshopspobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(noofWorkshopspobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(noofWorkshopspobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3321())) {
							System.out.println("3321 table is empty.....");
							// Insert 3321 tb
							int result3321 = criteria3Repository.insertYearTable3321(
									noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(), 1, 1,
									noofWorkshopspobj.getCriteriaId().getCollegeId(),
									noofWorkshopspobj.getCriteriaId().getFinancialYear(),
									noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3321 inserted=======>" + result3321);
						} else {
							// update 3321 tb
							System.out.println("yr 3321 is not  empty.....");
							String value3321 = criteria3.get().getYearTable3321().get(0).getInput3321v();
							System.out.println("existing value3321 is============>" + value3321);
							BigDecimal bd = new BigDecimal(value3321);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>"
									+ noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
							int update3321 = criteria3Repository.updateYearTable3321(finalValue,
									noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
							System.out.println("update3321 u=======>" + update3321);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								noofWorkshopspobj.getCriteriaId().getCollegeId(),
								noofWorkshopspobj.getCriteriaId().getFinancialYear(),
								noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3321 tb
						int result3321 = criteria3Repository.insertYearTable3321(
								noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(), 1, 1,
								noofWorkshopspobj.getCriteriaId().getCollegeId(),
								noofWorkshopspobj.getCriteriaId().getFinancialYear(),
								noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3321 inserted=======>" + result3321);

					}
				}
				// 3321 Au
				else if ("autonomous".equalsIgnoreCase(noofWorkshopspobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(noofWorkshopspobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(noofWorkshopspobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3321())) {
							System.out.println("3321 table is empty.....");
							// Insert 3321 tb
							int result3321 = criteria3Repository.insertYearTable3321(
									noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(), 1, 1,
									noofWorkshopspobj.getCriteriaId().getCollegeId(),
									noofWorkshopspobj.getCriteriaId().getFinancialYear(),
									noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3321 inserted=======>" + result3321);
						} else {
							// update 3321 tb
							System.out.println("yr 3321 is not  empty.....");
							String value3321 = criteria3.get().getYearTable3321().get(0).getInput3321v();
							System.out.println("existing value3321 is============>" + value3321);
							BigDecimal bd = new BigDecimal(value3321);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>"
									+ noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
							int update3321 = criteria3Repository.updateYearTable3321(finalValue,
									noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
							System.out.println("update3321 u=======>" + update3321);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								noofWorkshopspobj.getCriteriaId().getCollegeId(),
								noofWorkshopspobj.getCriteriaId().getFinancialYear(),
								noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3321 tb
						int result3321 = criteria3Repository.insertYearTable3321(
								noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(), 1, 1,
								noofWorkshopspobj.getCriteriaId().getCollegeId(),
								noofWorkshopspobj.getCriteriaId().getFinancialYear(),
								noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3321 inserted=======>" + result3321);

					}
				}
				// 3221 Af
				else if ("affiliated".equalsIgnoreCase(noofWorkshopspobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(noofWorkshopspobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(noofWorkshopspobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3221())) {
							System.out.println("3221 table affiliated is empty.....");
							// Insert 3221 tb
							int result3221 = criteria3Repository.insertYearTable3221(
									noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(), 1, 1,
									noofWorkshopspobj.getCriteriaId().getCollegeId(),
									noofWorkshopspobj.getCriteriaId().getFinancialYear(),
									noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3221 affiliated inserted=======>" + result3221);
						} else {
							// update 3221 tb
							System.out.println("yr 3221 affiliated is not  empty.....");
							String value3221Af = criteria3.get().getYearTable3221().get(0).getInput3221v();
							System.out.println("existing value3221Af is============>" + value3221Af);
							BigDecimal bdAf = new BigDecimal(value3221Af);
							int finalValueAf = bdAf.intValue() + 1;
							System.out.println("what is the finalValueAf ==>" + finalValueAf);
							System.out.println("unique key ==>"
									+ noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
							int update3221 = criteria3Repository.updateYearTable3221(finalValueAf,
									noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getUniqueKey1());
							System.out.println("update3221 affiliated u=======>" + update3221);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								noofWorkshopspobj.getCriteriaId().getCollegeId(),
								noofWorkshopspobj.getCriteriaId().getFinancialYear(),
								noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main  affiliated else====>" + criteria3Main);
						// Insert 3221 tb
						int result3221 = criteria3Repository.insertYearTable3221(
								noofWorkshopspobj.getNumberofWorkshopsorSeminars().get(0).getInputwt1(), 1, 1,
								noofWorkshopspobj.getCriteriaId().getCollegeId(),
								noofWorkshopspobj.getCriteriaId().getFinancialYear(),
								noofWorkshopspobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3221 affiliated inserted=======>" + result3221);

					}
				} else {
					System.out.println("data not mapped.......................");
				}
			} else {
				System.out.println("no of workshops obj is null or empty..............................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// research papers published

	private void getResearchPapersCriteriasUpdate() {
		try {
			List<ResearchPapersMain> researchInfo1 = researchPaperService.getAllResearchData();
			ResearchPapersMain researchInfo = null;
			if (researchInfo1 != null) {
				researchInfo = researchInfo1.get(0);
			}
			if (researchInfo != null) {
				// 3.4.5.1 U
				if ("university".equalsIgnoreCase(researchInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(researchInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(researchInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(researchInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable34512())) {
							System.out.println("3451 table is empty.....");
							// Insert 3451 tb
							int result3451 = criteria3Repository.insertYearTable3451(
									researchInfo.getResearchPapersPublished().get(0).getInputrp7(), 1, 1,
									researchInfo.getCriteriaId().getCollegeId(),
									researchInfo.getCriteriaId().getFinancialYear(),
									researchInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3451 inserted=======>" + result3451);

						} else {
							// update 3441 tb
							System.out.println("yr 3451 is not  empty.....");
							String value3451 = criteria3.get().getUniversityYearTable34512().get(0).getInput34512v();
							System.out.println("existing value3451 is============>" + value3451);
							BigDecimal bd = new BigDecimal(value3451);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>"
									+ researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
							int update3451 = criteria3Repository.updateYearTable3451(finalValue,
									researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
							System.out.println("update3451 u=======>" + update3451);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								researchInfo.getCriteriaId().getCollegeId(),
								researchInfo.getCriteriaId().getFinancialYear(),
								researchInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3451 tb
						int result3451 = criteria3Repository.insertYearTable3451(
								researchInfo.getResearchPapersPublished().get(0).getInputrp7(), 1, 1,
								researchInfo.getCriteriaId().getCollegeId(),
								researchInfo.getCriteriaId().getFinancialYear(),
								researchInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3451 inserted=======>" + result3451);

					}
				}
				// 3431 Au
				else if ("autonomous".equalsIgnoreCase(researchInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(researchInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(researchInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(researchInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3431())) {
							System.out.println("3431 table is empty.....");
							// Insert 3431 tb
							int result3431 = criteria3Repository.insertYearTable3431Au(
									researchInfo.getResearchPapersPublished().get(0).getInputrp7(), 1, 1,
									researchInfo.getCriteriaId().getCollegeId(),
									researchInfo.getCriteriaId().getFinancialYear(),
									researchInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3431 inserted=======>" + result3431);

						} else {
							// update 3441 tb
							System.out.println("yr 34311 is not  empty.....");
							String value3431 = criteria3.get().getYearTable3431().get(0).getInput3431v();
							System.out.println("existing value3431 is============>" + value3431);
							BigDecimal bd = new BigDecimal(value3431);
							int finalValue1 = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue1);
							System.out.println("unique key ==>"
									+ researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
							int update3431 = criteria3Repository.updateYearTable3431Au(finalValue1,
									researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
							System.out.println("update3431 u=======>" + update3431);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								researchInfo.getCriteriaId().getCollegeId(),
								researchInfo.getCriteriaId().getFinancialYear(),
								researchInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3431 tb
						int result3431 = criteria3Repository.insertYearTable3431Au(
								researchInfo.getResearchPapersPublished().get(0).getInputrp7(), 1, 1,
								researchInfo.getCriteriaId().getCollegeId(),
								researchInfo.getCriteriaId().getFinancialYear(),
								researchInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3431 inserted=======>" + result3431);

					}
				}
				// 3311 Af
				else if ("affiliated".equalsIgnoreCase(researchInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(researchInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(researchInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(researchInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getAffiliatedYearTable3311())) {
							System.out.println("3311 table affiliated is empty.....");
							// Insert 3311 tb
							int result3311 = criteria3Repository.insertYearTable3311Af(
									researchInfo.getResearchPapersPublished().get(0).getInputrp12(), 1, 1,
									researchInfo.getCriteriaId().getCollegeId(),
									researchInfo.getCriteriaId().getFinancialYear(),
									researchInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3311 affiliated inserted=======>" + result3311);

						} else {
							// update 3311 tb
							System.out.println("yr 3311 is not  empty.....");
							String value3311 = criteria3.get().getAffiliatedYearTable3311().get(0).getInput3311v();
							System.out.println("existing value3311 is============>" + value3311);
							BigDecimal bd = new BigDecimal(value3311);
							int finalValue2 = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue2);
							System.out.println("unique key ==>"
									+ researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
							int update3311 = criteria3Repository.updateYearTable3311Af(finalValue2,
									researchInfo.getResearchPapersPublished().get(0).getUniqueKey1());
							System.out.println("update3311 affiliated  u=======>" + update3311);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								researchInfo.getCriteriaId().getCollegeId(),
								researchInfo.getCriteriaId().getFinancialYear(),
								researchInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main affiliated else====>" + criteria3Main);
						// Insert 3311 tb
						int result3311 = criteria3Repository.insertYearTable3311Af(
								researchInfo.getResearchPapersPublished().get(0).getInputrp12(), 1, 1,
								researchInfo.getCriteriaId().getCollegeId(),
								researchInfo.getCriteriaId().getFinancialYear(),
								researchInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3311 affiliated inserted=======>" + result3311);

					}
				} else {
					System.out.println("research Papers data not mapped.....................");
				}
			} else {
				System.out.println("researchInfo obj is null or empty.....................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Books And Chapters

	private void getBooksandChaptersCriteriasUpdate() {
		try {
			List<BooksandChaptersMain> booksInfo1 = bookandChapterService.getAllBookandChapterData();
			BooksandChaptersMain booksInfo = null;
			if (booksInfo1 != null) {
				booksInfo = booksInfo1.get(0);
			}
			if (booksInfo != null) {
				// 3.4.6.1 U
				if ("university".equalsIgnoreCase(booksInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(booksInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(booksInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(booksInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable3461())) {
							System.out.println("3461 table is empty.....");
							// Insert 3461 tb
							int result3461 = criteria3Repository.insertYearTable3461(
									booksInfo.getBooksandChapters().get(0).getInputbct7(), 1, 1,
									booksInfo.getCriteriaId().getCollegeId(),
									booksInfo.getCriteriaId().getFinancialYear(),
									booksInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3461 inserted=======>" + result3461);

						} else {
							// update 3461 tb
							System.out.println("yr 3461 is not  empty.....");
							String value3461 = criteria3.get().getUniversityYearTable3461().get(0).getInput3461v();
							System.out.println("existing value3461 is============>" + value3461);
							BigDecimal bd = new BigDecimal(value3461);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out
									.println("unique key ==>" + booksInfo.getBooksandChapters().get(0).getUniqueKey1());
							int update3461 = criteria3Repository.updatreYearTable3461(finalValue,
									booksInfo.getBooksandChapters().get(0).getUniqueKey1());
							System.out.println("update3461 u=======>" + update3461);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								booksInfo.getCriteriaId().getCollegeId(), booksInfo.getCriteriaId().getFinancialYear(),
								booksInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3461 tb
						int result3461 = criteria3Repository.insertYearTable3461(
								booksInfo.getBooksandChapters().get(0).getInputbct7(), 1, 1,
								booksInfo.getCriteriaId().getCollegeId(), booksInfo.getCriteriaId().getFinancialYear(),
								booksInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3461 inserted=======>" + result3461);

					}
				}
				// 3.4.4.1 Au
				else if ("autonomous".equalsIgnoreCase(booksInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(booksInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(booksInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(booksInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3441())) {
							System.out.println("3441 table is empty.....");
							// Insert 3441 tb
							int result3441Au = criteria3Repository.insertYearTable3441Au(
									booksInfo.getBooksandChapters().get(0).getInputbct7(), 1, 1,
									booksInfo.getCriteriaId().getCollegeId(),
									booksInfo.getCriteriaId().getFinancialYear(),
									booksInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3441Au inserted=======>" + result3441Au);

						} else {
							// update 3441 tb
							System.out.println("yr 3441 is not  empty.....");
							String value3441Au = criteria3.get().getYearTable3441().get(0).getInput3441v();
							System.out.println("existing value3441Au is============>" + value3441Au);
							BigDecimal bd = new BigDecimal(value3441Au);
							int finalValue1 = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue1);
							System.out
									.println("unique key ==>" + booksInfo.getBooksandChapters().get(0).getUniqueKey1());
							int update3441Au = criteria3Repository.updatreYearTable3441Au(finalValue1,
									booksInfo.getBooksandChapters().get(0).getUniqueKey1());
							System.out.println("update3441Au u=======>" + update3441Au);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								booksInfo.getCriteriaId().getCollegeId(), booksInfo.getCriteriaId().getFinancialYear(),
								booksInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3441 tb
						int result3441Au = criteria3Repository.insertYearTable3441Au(
								booksInfo.getBooksandChapters().get(0).getInputbct7(), 1, 1,
								booksInfo.getCriteriaId().getCollegeId(), booksInfo.getCriteriaId().getFinancialYear(),
								booksInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3441Au inserted=======>" + result3441Au);

					}
				}
				// 3.3.2.1 Af
				else if ("affiliated".equalsIgnoreCase(booksInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(booksInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(booksInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(booksInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3321())) {
							System.out.println("3321 table affiliated is empty.....");
							// Insert 3321 tb
							int result3321Af = criteria3Repository.insertYearTable3321Af(
									booksInfo.getBooksandChapters().get(0).getInputbct7(), 1, 1,
									booksInfo.getCriteriaId().getCollegeId(),
									booksInfo.getCriteriaId().getFinancialYear(),
									booksInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3321Af affiliated inserted=======>" + result3321Af);

						} else {
							// update 3461 tb
							System.out.println("yr 3321 is not  empty.....");
							String value3321Af = criteria3.get().getYearTable3321().get(0).getInput3321v();
							System.out.println("existing value3321Af is============>" + value3321Af);
							BigDecimal bd = new BigDecimal(value3321Af);
							int finalValue2 = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue2);
							System.out
									.println("unique key ==>" + booksInfo.getBooksandChapters().get(0).getUniqueKey1());
							int update3321Af = criteria3Repository.updateYearTable3321Af(finalValue2,
									booksInfo.getBooksandChapters().get(0).getUniqueKey1());
							System.out.println("update3321Af affiliated u=======>" + update3321Af);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								booksInfo.getCriteriaId().getCollegeId(), booksInfo.getCriteriaId().getFinancialYear(),
								booksInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main affiliated else====>" + criteria3Main);
						// Insert 3321 tb
						int result3321Af = criteria3Repository.insertYearTable3321Af(
								booksInfo.getBooksandChapters().get(0).getInputbct7(), 1, 1,
								booksInfo.getCriteriaId().getCollegeId(), booksInfo.getCriteriaId().getFinancialYear(),
								booksInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3321Af  affiliated inserted=======>" + result3321Af);

					}
				} else {
					System.out.println("books & chapters data is not mapped............................");
				}

			} else {
				System.out.println("booksInfo obj is null or empty...........................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Citations

//    private void getCitationsCriteriasUpdate() {
//    	try {
//    		List<BooksandChaptersMain> booksInfo1 = citationsService.getAllBookandChapterData();
//    		BooksandChaptersMain booksInfo = null;
//    		if(booksInfo1 != null) {
//    			booksInfo = booksInfo1.get(0); 
//    		}
//    		if(booksInfo != null)

	// H-Index

	// Revenue Consultancy

	private void getRevenueConsultaCriteriasUpdate() {
		try {
			List<RevenueConsultancyMain> revenueConsultobj1 = revenueConsultService.getAllRevenueConsultData();
			RevenueConsultancyMain revenueConsultobj = null;
			if (revenueConsultobj1 != null) {
				revenueConsultobj = revenueConsultobj1.get(0);
			}
			if (revenueConsultobj != null) {
				// 3521 u
				if ("university".equalsIgnoreCase(revenueConsultobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(revenueConsultobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(revenueConsultobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(revenueConsultobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3521())) {
							System.out.println("yr 3521 tb is empty.....");
							// Insert 3521
							int result3521 = criteria3Repository.insertYearTable3521(
									revenueConsultobj.getRevenueConsultancy().get(0).getInputrct6(),
									revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7(), 1,
									revenueConsultobj.getCriteriaId().getCollegeId(),
									revenueConsultobj.getCriteriaId().getFinancialYear(),
									revenueConsultobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3521 inserted=======>" + result3521);

						} else {
							// update 3521
							System.out.println("yr 3521 tb is not  empty.....");
							String value3521t1 = criteria3.get().getYearTable3521().get(0).getInput3521v();
							System.out.println("existing value3521 is============>" + value3521t1);
							BigDecimal bd1 = new BigDecimal(value3521t1);
							BigDecimal finalValue1 = bd1.add(
									new BigDecimal(revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7()));
							System.out.println("what is the final value ==>" + finalValue1);
							System.out.println("unique key ==>"
									+ revenueConsultobj.getRevenueConsultancy().get(0).getUniqueKey1());
							int update3521 = criteria3Repository.updateYearTable3521(finalValue1,
									revenueConsultobj.getRevenueConsultancy().get(0).getUniqueKey1());
							System.out.println("update3521 u=======>" + update3521);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								revenueConsultobj.getCriteriaId().getCollegeId(),
								revenueConsultobj.getCriteriaId().getFinancialYear(),
								revenueConsultobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3521
						int result3521 = criteria3Repository.insertYearTable3521(
								revenueConsultobj.getRevenueConsultancy().get(0).getInputrct6(),
								revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7(), 1,
								revenueConsultobj.getCriteriaId().getCollegeId(),
								revenueConsultobj.getCriteriaId().getFinancialYear(),
								revenueConsultobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3521 inserted=======>" + result3521);

					}
				}
				// 3511 Au
				else if ("autonomous".equalsIgnoreCase(revenueConsultobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(revenueConsultobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(revenueConsultobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(revenueConsultobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3511())) {
							System.out.println("yr 3511 tb is empty.....");
							// Insert 3511
							int result3511 = criteria3Repository.insertYearTable3511(
									revenueConsultobj.getRevenueConsultancy().get(0).getInputrct6(),
									revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7(), 1,
									revenueConsultobj.getCriteriaId().getCollegeId(),
									revenueConsultobj.getCriteriaId().getFinancialYear(),
									revenueConsultobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3511 inserted=======>" + result3511);

						} else {
							// update 3511
							System.out.println("yr 3511 tb is not  empty.....");
							String value3511t1 = criteria3.get().getYearTable3511().get(0).getInput3511v();
							System.out.println("existing value3511t1 is============>" + value3511t1);
							BigDecimal bd1 = new BigDecimal(value3511t1);
							BigDecimal finalValue1 = bd1.add(
									new BigDecimal(revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7()));
							System.out.println("what is the final value ==>" + finalValue1);
							System.out.println("unique key ==>"
									+ revenueConsultobj.getRevenueConsultancy().get(0).getUniqueKey1());
							int update3511 = criteria3Repository.updateYearTable3511(finalValue1,
									revenueConsultobj.getRevenueConsultancy().get(0).getUniqueKey1());
							System.out.println("update3511 u=======>" + update3511);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								revenueConsultobj.getCriteriaId().getCollegeId(),
								revenueConsultobj.getCriteriaId().getFinancialYear(),
								revenueConsultobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3511
						int result3511 = criteria3Repository.insertYearTable3511(
								revenueConsultobj.getRevenueConsultancy().get(0).getInputrct6(),
								revenueConsultobj.getRevenueConsultancy().get(0).getInputrct7(), 1,
								revenueConsultobj.getCriteriaId().getCollegeId(),
								revenueConsultobj.getCriteriaId().getFinancialYear(),
								revenueConsultobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3511 inserted=======>" + result3511);

					}
				} else {
					System.out.println("Revenue Consultancy data is not mapped..................");
				}

			} else {
				System.out.println("Revenue Consultancy obj is null or empty...................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Revenue Corporate

	private void getRevenueCorporateCriteriasUpdate() {
		try {
			List<RevenueCorpTrainingMain> revenueCorpTrainobj1 = revenueCorpTrainingService.getAllRevCorpTrainData();
			RevenueCorpTrainingMain revenueCorpTrainobj = null;
			if (revenueCorpTrainobj1 != null) {
				revenueCorpTrainobj = revenueCorpTrainobj1.get(0);
			}
			if (revenueCorpTrainobj != null) {

				// 3521 U
				if ("university".equalsIgnoreCase(revenueCorpTrainobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(revenueCorpTrainobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(revenueCorpTrainobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3521())) {
							System.out.println("yr 3521 tb is empty.....");
							// Insert 3521
							int result3521 = criteria3Repository.insertYearTable3521(
									revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt6(),
									revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt7(), 1,
									revenueCorpTrainobj.getCriteriaId().getCollegeId(),
									revenueCorpTrainobj.getCriteriaId().getFinancialYear(),
									revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3521 inserted=======>" + result3521);
						} else {

							// update 3521
							System.out.println("yr 3521 tb is not  empty Corp.....");
							String value3521Corp = criteria3.get().getYearTable3521().get(0).getInput3521v();
							System.out.println("existing value3521Corp is============>" + value3521Corp);
							BigDecimal bd1 = new BigDecimal(value3521Corp);
							BigDecimal finalValue2 = bd1.add(new BigDecimal(
									revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt7()));
							System.out.println("what is the final value ==>" + finalValue2);
							System.out.println(
									"unique key ==>" + criteria3.get().getYearTable3521().get(0).getUniqueKey1());
							int update3521Corp = criteria3Repository.updateYearTable3521Corp(finalValue2,
									criteria3.get().getYearTable3521().get(0).getUniqueKey1());
							System.out.println("update3521Corp u Corp =======>" + update3521Corp);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								revenueCorpTrainobj.getCriteriaId().getCollegeId(),
								revenueCorpTrainobj.getCriteriaId().getFinancialYear(),
								revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3481
//    					int result3521=criteria3Repository.insertYearTable3521(revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt6(),
//    							revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt7(),1,revenueCorpTrainobj.getCriteriaId().getCollegeId(),
//    							revenueCorpTrainobj.getCriteriaId().getFinancialYear(),revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
//    				System.out.println("result3521 inserted=======>"+result3521);

					}
				}
				// 3511 Au
				else if ("autonomous".equalsIgnoreCase(revenueCorpTrainobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(revenueCorpTrainobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(revenueCorpTrainobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3511())) {
							System.out.println("yr 3511 tb is empty.....");
							// Insert 3511
							int result3511 = criteria3Repository.insertYearTable3511(
									revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt6(),
									revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt7(), 1,
									revenueCorpTrainobj.getCriteriaId().getCollegeId(),
									revenueCorpTrainobj.getCriteriaId().getFinancialYear(),
									revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3511 inserted=======>" + result3511);
						} else {

							// update 3511
							System.out.println("yr 3511 tb is not  empty Corp.....");
							String value3511Corp = criteria3.get().getYearTable3511().get(0).getInput3511v();
							System.out.println("existing value3511Corp is============>" + value3511Corp);
							BigDecimal bd1 = new BigDecimal(value3511Corp);
							BigDecimal finalValue2 = bd1.add(new BigDecimal(
									revenueCorpTrainobj.getRevenueCorporateTraining().get(0).getInputrctt7()));
							System.out.println("what is the final value ==>" + finalValue2);
							System.out.println(
									"unique key ==>" + criteria3.get().getYearTable3511().get(0).getUniqueKey1());
							int update3511Corp = criteria3Repository.updateYearTable3511Corp(finalValue2,
									criteria3.get().getYearTable3511().get(0).getUniqueKey1());
							System.out.println("update3511Corp u Corp =======>" + update3511Corp);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								revenueCorpTrainobj.getCriteriaId().getCollegeId(),
								revenueCorpTrainobj.getCriteriaId().getFinancialYear(),
								revenueCorpTrainobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);

					}
				} else {
					System.out.println("Revenue Corporate data is not Mapped......................");
				}

			} else {
				System.out.println("revenueCorpTrainobj is null or Empty........................");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Collaborations Linkages

	private void getCollaborationsCriteriasUpdate() {
		try {
			List<CollaborationLinkagesMain> collaborationsobj1 = collaborationsService.getAllCollaborationData();
			CollaborationLinkagesMain collaborationsobj = null;
			if (collaborationsobj1 != null) {
				collaborationsobj = collaborationsobj1.get(0);
			}
			if (collaborationsobj != null) {

				// 3711 U
				if ("university".equalsIgnoreCase(collaborationsobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(collaborationsobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(collaborationsobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(collaborationsobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3711())) {
							System.out.println("3711 table is empty.....");
							// Insert 3711 tb
							int result3711 = criteria3Repository.insertYearTable3711(
									collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(), 1, 1,
									collaborationsobj.getCriteriaId().getCollegeId(),
									collaborationsobj.getCriteriaId().getFinancialYear(),
									collaborationsobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3711 inserted=======>" + result3711);

						} else {
							// update 3711 tb
							System.out.println("yr 3711 is not  empty.....");
							String value3711 = criteria3.get().getYearTable3711().get(0).getInput3711v();
							System.out.println("existing value3711 is============>" + value3711);
							BigDecimal bd = new BigDecimal(value3711);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>"
									+ collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
							int update3711 = criteria3Repository.updateYearTable3711(finalValue,
									collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
							System.out.println("update3711 u=======>" + update3711);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								collaborationsobj.getCriteriaId().getCollegeId(),
								collaborationsobj.getCriteriaId().getFinancialYear(),
								collaborationsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3711 tb
						int result3711 = criteria3Repository.insertYearTable3711(
								collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(), 1, 1,
								collaborationsobj.getCriteriaId().getCollegeId(),
								collaborationsobj.getCriteriaId().getFinancialYear(),
								collaborationsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3711 inserted=======>" + result3711);

					}
				}
				// 3711 Au
				else if ("autonomous".equalsIgnoreCase(collaborationsobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(collaborationsobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(collaborationsobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(collaborationsobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3711())) {
							System.out.println("3711 table is empty.....");
							// Insert 3711 tb
							int result3711 = criteria3Repository.insertYearTable3711(
									collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(), 1, 1,
									collaborationsobj.getCriteriaId().getCollegeId(),
									collaborationsobj.getCriteriaId().getFinancialYear(),
									collaborationsobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3711 inserted=======>" + result3711);

						} else {
							// update 3711 tb
							System.out.println("yr 3711 is not  empty.....");
							String value3711 = criteria3.get().getYearTable3711().get(0).getInput3711v();
							System.out.println("existing value3711 is============>" + value3711);
							BigDecimal bd = new BigDecimal(value3711);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>"
									+ collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
							int update3711 = criteria3Repository.updateYearTable3711(finalValue,
									collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
							System.out.println("update3711 u=======>" + update3711);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								collaborationsobj.getCriteriaId().getCollegeId(),
								collaborationsobj.getCriteriaId().getFinancialYear(),
								collaborationsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3711 tb
						int result3711 = criteria3Repository.insertYearTable3711(
								collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(), 1, 1,
								collaborationsobj.getCriteriaId().getCollegeId(),
								collaborationsobj.getCriteriaId().getFinancialYear(),
								collaborationsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3711 inserted=======>" + result3711);

					}
				}
				// 3711 Af
				else if ("affiliated".equalsIgnoreCase(collaborationsobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(collaborationsobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(collaborationsobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(collaborationsobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3711())) {
							System.out.println("3711 table affiliated is empty.....");
							// Insert 3711 tb
							int result3711 = criteria3Repository.insertYearTable3711(
									collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(), 1, 1,
									collaborationsobj.getCriteriaId().getCollegeId(),
									collaborationsobj.getCriteriaId().getFinancialYear(),
									collaborationsobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3711 affiliated inserted=======>" + result3711);

						} else {
							// update 3711 tb
							System.out.println("yr 3711 is not  empty.....");
							String value3711 = criteria3.get().getYearTable3711().get(0).getInput3711v();
							System.out.println("existing value3711 is============>" + value3711);
							BigDecimal bd = new BigDecimal(value3711);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>"
									+ collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
							int update3711 = criteria3Repository.updateYearTable3711(finalValue,
									collaborationsobj.getCollaborationsLinkages().get(0).getUniqueKey1());
							System.out.println("update3711 affiliated u=======>" + update3711);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								collaborationsobj.getCriteriaId().getCollegeId(),
								collaborationsobj.getCriteriaId().getFinancialYear(),
								collaborationsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main affiliated else====>" + criteria3Main);
						// Insert 3711 tb
						int result3711 = criteria3Repository.insertYearTable3711(
								collaborationsobj.getCollaborationsLinkages().get(0).getInputclt6(), 1, 1,
								collaborationsobj.getCriteriaId().getCollegeId(),
								collaborationsobj.getCriteriaId().getFinancialYear(),
								collaborationsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3711 affiliated inserted=======>" + result3711);

					}
				} else {
					System.out.println("Collaborations data is not mapped..........................");
				}
			} else {
				System.out.println("collaborationsobj is null or empty...........................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Finance Support to Teachers

	private void getFinanceSupToTeachersCriteriasUpdate() {
		try {
			List<FinancialSupportToTeachersMain> financeSupportTeach1 = financeSupportTeachService
					.getAllFinanceSuppTeachData();
			FinancialSupportToTeachersMain financeSupportTeach = null;
			if (financeSupportTeach1 != null) {
				financeSupportTeach = financeSupportTeach1.get(0);
			}
			if (financeSupportTeach != null) {
				// 6321 U
				if ("university".equalsIgnoreCase(financeSupportTeach.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(financeSupportTeach.getCriteriaId().getCollegeId());
					key.setFinancialYear(financeSupportTeach.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(financeSupportTeach.getCriteriaId().getTypeofInstitution());
					Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
					if (criteria6.isPresent()) {
						if (CollectionUtils.isEmpty(criteria6.get().getYearTable6321())) {
							System.out.println("6321 table is empty.....");
							// Insert 6321 tb
							int result6321 = criteria6Repository.insertYearTable6321(
									financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(), 1, 1,
									financeSupportTeach.getCriteriaId().getCollegeId(),
									financeSupportTeach.getCriteriaId().getFinancialYear(),
									financeSupportTeach.getCriteriaId().getTypeofInstitution());
							System.out.println("result6321 inserted=======>" + result6321);

						} else {
							// update 6321 tb
							System.out.println("yr 6321 is not  empty.....");
							String value6321 = criteria6.get().getYearTable6321().get(0).getInput6321v();
							System.out.println("existing value6321 is============>" + value6321);
							BigDecimal bd = new BigDecimal(value6321);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>"
									+ financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
							int update6321 = criteria6Repository.updateYearTable6321(finalValue,
									financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
							System.out.println("update6321 u=======>" + update6321);
						}
					} else {

						System.out.println("inserting into cr6 main table else......");
						int criteria6Main = criteria6Repository.insertCriteria6FieldInfoMain(
								financeSupportTeach.getCriteriaId().getCollegeId(),
								financeSupportTeach.getCriteriaId().getFinancialYear(),
								financeSupportTeach.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria6Main else====>" + criteria6Main);
						// Insert 6321 tb
						int result6321 = criteria6Repository.insertYearTable6321(
								financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(), 1, 1,
								financeSupportTeach.getCriteriaId().getCollegeId(),
								financeSupportTeach.getCriteriaId().getFinancialYear(),
								financeSupportTeach.getCriteriaId().getTypeofInstitution());
						System.out.println("result6321 inserted=======>" + result6321);

					}
				}
				// 6321 Au
				else if ("autonomous".equalsIgnoreCase(financeSupportTeach.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(financeSupportTeach.getCriteriaId().getCollegeId());
					key.setFinancialYear(financeSupportTeach.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(financeSupportTeach.getCriteriaId().getTypeofInstitution());
					Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
					if (criteria6.isPresent()) {
						if (CollectionUtils.isEmpty(criteria6.get().getYearTable6321())) {
							System.out.println("3711 table is empty.....");
							// Insert 6321 tb
							int result6321 = criteria6Repository.insertYearTable6321(
									financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(), 1, 1,
									financeSupportTeach.getCriteriaId().getCollegeId(),
									financeSupportTeach.getCriteriaId().getFinancialYear(),
									financeSupportTeach.getCriteriaId().getTypeofInstitution());
							System.out.println("result6321 inserted=======>" + result6321);

						} else {
							// update 6321 tb
							System.out.println("yr 6321 is not  empty.....");
							String value6321 = criteria6.get().getYearTable6321().get(0).getInput6321v();
							System.out.println("existing value6321 is============>" + value6321);
							BigDecimal bd = new BigDecimal(value6321);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>"
									+ financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
							int update6321 = criteria6Repository.updateYearTable6321(finalValue,
									financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
							System.out.println("update6321 u=======>" + update6321);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria6Repository.insertCriteria6FieldInfoMain(
								financeSupportTeach.getCriteriaId().getCollegeId(),
								financeSupportTeach.getCriteriaId().getFinancialYear(),
								financeSupportTeach.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 6321 tb
						int result6321 = criteria6Repository.insertYearTable6321(
								financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(), 1, 1,
								financeSupportTeach.getCriteriaId().getCollegeId(),
								financeSupportTeach.getCriteriaId().getFinancialYear(),
								financeSupportTeach.getCriteriaId().getTypeofInstitution());
						System.out.println("result6321 inserted=======>" + result6321);

					}
				}
				// 36321 Af
				else if ("affiliated".equalsIgnoreCase(financeSupportTeach.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(financeSupportTeach.getCriteriaId().getCollegeId());
					key.setFinancialYear(financeSupportTeach.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(financeSupportTeach.getCriteriaId().getTypeofInstitution());
					Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
					if (criteria6.isPresent()) {
						if (CollectionUtils.isEmpty(criteria6.get().getYearTable6321())) {
							System.out.println("3711 table is empty.....");
							// Insert 6321 tb
							int result6321 = criteria6Repository.insertYearTable6321(
									financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(), 1, 1,
									financeSupportTeach.getCriteriaId().getCollegeId(),
									financeSupportTeach.getCriteriaId().getFinancialYear(),
									financeSupportTeach.getCriteriaId().getTypeofInstitution());
							System.out.println("result6321 inserted=======>" + result6321);

						} else {
							// update 6321 tb
							System.out.println("yr 6321 is not  empty.....");
							String value6321 = criteria6.get().getYearTable6321().get(0).getInput6321v();
							System.out.println("existing value6321 is============>" + value6321);
							BigDecimal bd = new BigDecimal(value6321);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>"
									+ financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
							int update6321 = criteria6Repository.updateYearTable6321(finalValue,
									financeSupportTeach.getFinancialSupportToTeachers().get(0).getUniqueKey1());
							System.out.println("update6321 u=======>" + update6321);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria6Repository.insertCriteria6FieldInfoMain(
								financeSupportTeach.getCriteriaId().getCollegeId(),
								financeSupportTeach.getCriteriaId().getFinancialYear(),
								financeSupportTeach.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 6321 tb
						int result6321 = criteria6Repository.insertYearTable6321(
								financeSupportTeach.getFinancialSupportToTeachers().get(0).getInputfst1(), 1, 1,
								financeSupportTeach.getCriteriaId().getCollegeId(),
								financeSupportTeach.getCriteriaId().getFinancialYear(),
								financeSupportTeach.getCriteriaId().getTypeofInstitution());
						System.out.println("result6321 inserted=======>" + result6321);

					}
				} else {
					System.out.println("Finance support to teachers data is not mapped............................. ");
				}
			} else {
				System.out.println("financeSupportTeach obj is null or empty..........................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Professional Development Progms

	private void getProfessionalDevlopProgmCriteriasUpdate() {
		try {
			List<ProfessionalDevelopmenMain> professionalInfo1 = professionaldevelopmentService
					.getAllProfessionalData();
			ProfessionalDevelopmenMain professionalInfo = null;
			if (professionalInfo1 != null) {
				professionalInfo = professionalInfo1.get(0);
			}
			if (professionalInfo != null) {

				// 6331 U
				if ("university".equalsIgnoreCase(professionalInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(professionalInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(professionalInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(professionalInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
					if (criteria6.isPresent()) {
						if (CollectionUtils.isEmpty(criteria6.get().getYearTable6331())) {
							System.out.println("6331 table is empty.....");
							// Insert 6331 tb
							int result6331 = criteria6Repository.insertYearTable6331(
									professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getInputpdt1(), 1, 1,
									professionalInfo.getCriteriaId().getCollegeId(),
									professionalInfo.getCriteriaId().getFinancialYear(),
									professionalInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result6331 inserted=======>" + result6331);

						} else {
							// update 6331 tb
							System.out.println("yr 6331 is not  empty.....");
							String value6331 = criteria6.get().getYearTable6331().get(0).getInput6331v();
							System.out.println("existing value6331 is============>" + value6331);
							BigDecimal bd = new BigDecimal(value6331);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>"
									+ professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getUniqueKey1());
							int update6331 = criteria6Repository.updateYearTable6331(finalValue,
									professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getUniqueKey1());
							System.out.println("update6331 u=======>" + update6331);
						}
					} else {

						System.out.println("inserting into cr6 main table else......");
						int criteria6Main = criteria6Repository.insertCriteria6FieldInfoMain(
								professionalInfo.getCriteriaId().getCollegeId(),
								professionalInfo.getCriteriaId().getFinancialYear(),
								professionalInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria6Main else====>" + criteria6Main);
						// Insert 6331 tb
						int result6331 = criteria6Repository.insertYearTable6331(
								professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getInputpdt1(), 1, 1,
								professionalInfo.getCriteriaId().getCollegeId(),
								professionalInfo.getCriteriaId().getFinancialYear(),
								professionalInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result6331 inserted=======>" + result6331);

					}

				}
				// 6331 Au
				else if ("autonomous".equalsIgnoreCase(professionalInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(professionalInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(professionalInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(professionalInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
					if (criteria6.isPresent()) {
						if (CollectionUtils.isEmpty(criteria6.get().getYearTable6331())) {
							System.out.println("6331 table is empty.....");
							// Insert 6331 tb
							int result6331 = criteria6Repository.insertYearTable6331(
									professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getInputpdt1(), 1, 1,
									professionalInfo.getCriteriaId().getCollegeId(),
									professionalInfo.getCriteriaId().getFinancialYear(),
									professionalInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result6331 inserted=======>" + result6331);

						} else {
							// update 6331 tb
							System.out.println("yr 6331 is not  empty.....");
							String value6331 = criteria6.get().getYearTable6331().get(0).getInput6331v();
							System.out.println("existing value6331 is============>" + value6331);
							BigDecimal bd = new BigDecimal(value6331);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>"
									+ professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getUniqueKey1());
							int update6331 = criteria6Repository.updateYearTable6331(finalValue,
									professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getUniqueKey1());
							System.out.println("update6331 u=======>" + update6331);
						}
					} else {

						System.out.println("inserting into cr6 main table else......");
						int criteria6Main = criteria6Repository.insertCriteria6FieldInfoMain(
								professionalInfo.getCriteriaId().getCollegeId(),
								professionalInfo.getCriteriaId().getFinancialYear(),
								professionalInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria6Main else====>" + criteria6Main);
						// Insert 6331 tb
						int result6331 = criteria6Repository.insertYearTable6331(
								professionalInfo.getProfessionalDevelopmentProgrammes().get(0).getInputpdt1(), 1, 1,
								professionalInfo.getCriteriaId().getCollegeId(),
								professionalInfo.getCriteriaId().getFinancialYear(),
								professionalInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result6331 inserted=======>" + result6331);

					}

				} else {
					System.out.println("Professional devlopment data is not mapped.......................");
				}
			} else {
				System.out.println("Professional devlopment progm obj is null or empty.........................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// OnlineFDP

	private void getOnlineFDPCriteriasUpdate() {
		try {
			List<OnlineorF2FFDPMain> onlinef2ffdpobj1 = onlineF2FFDPService.getAllOnlineF2FFDPData();
			OnlineorF2FFDPMain onlinef2ffdpobj = null;
			if (onlinef2ffdpobj1 != null) {
				onlinef2ffdpobj = onlinef2ffdpobj1.get(0);
			}
			if (onlinef2ffdpobj != null) {

				// 6341 U
				if ("university".equalsIgnoreCase(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(onlinef2ffdpobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(onlinef2ffdpobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
					if (criteria6.isPresent()) {
						if (CollectionUtils.isEmpty(criteria6.get().getYearTable6341())) {
							System.out.println("6341 table is empty.....");
							// Insert 6341 tb
							int result6341 = criteria6Repository.insertYearTable6341(
									onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(), 1, 1,
									onlinef2ffdpobj.getCriteriaId().getCollegeId(),
									onlinef2ffdpobj.getCriteriaId().getFinancialYear(),
									onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result6341 inserted=======>" + result6341);

						} else {
							// update 6341 tb
							System.out.println("yr 6341 is not  empty.....");
							String value6341 = criteria6.get().getYearTable6341().get(0).getInput6341v();
							System.out.println("existing value6341 is============>" + value6341);
							BigDecimal bd = new BigDecimal(value6341);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println(
									"unique key ==>" + onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
							int update6341 = criteria6Repository.updateYearTable6341(finalValue,
									onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
							System.out.println("update6341 u=======>" + update6341);
						}
					} else {

						System.out.println("inserting into cr6 main table else......");
						int criteria6Main = criteria6Repository.insertCriteria6FieldInfoMain(
								onlinef2ffdpobj.getCriteriaId().getCollegeId(),
								onlinef2ffdpobj.getCriteriaId().getFinancialYear(),
								onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria6Main else====>" + criteria6Main);
						// Insert 6341 tb
						int result6341 = criteria6Repository.insertYearTable6341(
								onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(), 1, 1,
								onlinef2ffdpobj.getCriteriaId().getCollegeId(),
								onlinef2ffdpobj.getCriteriaId().getFinancialYear(),
								onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result6341 inserted=======>" + result6341);

					}

				}
				// 6341 Au
				else if ("autonomous".equalsIgnoreCase(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(onlinef2ffdpobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(onlinef2ffdpobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
					if (criteria6.isPresent()) {
						if (CollectionUtils.isEmpty(criteria6.get().getYearTable6341())) {
							System.out.println("6341 table is empty.....");
							// Insert 6341 tb
							int result6341 = criteria6Repository.insertYearTable6341(
									onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(), 1, 1,
									onlinef2ffdpobj.getCriteriaId().getCollegeId(),
									onlinef2ffdpobj.getCriteriaId().getFinancialYear(),
									onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result6341 inserted=======>" + result6341);

						} else {
							// update 6341 tb
							System.out.println("yr 6341 is not  empty.....");
							String value6341 = criteria6.get().getYearTable6341().get(0).getInput6341v();
							System.out.println("existing value6341 is============>" + value6341);
							BigDecimal bd = new BigDecimal(value6341);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println(
									"unique key ==>" + onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
							int update6341 = criteria6Repository.updateYearTable6341(finalValue,
									onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
							System.out.println("update6341 u=======>" + update6341);
						}
					} else {

						System.out.println("inserting into cr6 main table else......");
						int criteria6Main = criteria6Repository.insertCriteria6FieldInfoMain(
								onlinef2ffdpobj.getCriteriaId().getCollegeId(),
								onlinef2ffdpobj.getCriteriaId().getFinancialYear(),
								onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria6Main else====>" + criteria6Main);
						// Insert 6341 tb
						int result6341 = criteria6Repository.insertYearTable6341(
								onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(), 1, 1,
								onlinef2ffdpobj.getCriteriaId().getCollegeId(),
								onlinef2ffdpobj.getCriteriaId().getFinancialYear(),
								onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result6341 inserted=======>" + result6341);

					}

				}
				// 6331 Af
				else if ("affiliated".equalsIgnoreCase(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(onlinef2ffdpobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(onlinef2ffdpobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria6_FieldInfo> criteria6 = criteria6Repository.findById(key);
					if (criteria6.isPresent()) {
						if (CollectionUtils.isEmpty(criteria6.get().getYearTable6331())) {
							System.out.println("6331 table affiliated is empty.....");
							// Insert 6331 tb
							int result6331 = criteria6Repository.insertYearTable6331Af(
									onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(), 1, 1,
									onlinef2ffdpobj.getCriteriaId().getCollegeId(),
									onlinef2ffdpobj.getCriteriaId().getFinancialYear(),
									onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result6331 inserted=======>" + result6331);

						} else {
							// update 6331 tb
							System.out.println("yr 6331 affiliated is not  empty.....");
							String value6331 = criteria6.get().getYearTable6331().get(0).getInput6331v();
							System.out.println("existing value6331 is============>" + value6331);
							BigDecimal bd = new BigDecimal(value6331);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println(
									"unique key ==>" + onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
							int update6331 = criteria6Repository.updateYearTable6331Af(finalValue,
									onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getUniqueKey1());
							System.out.println("update6331 affiliated u=======>" + update6331);
						}
					} else {

						System.out.println("inserting into cr6 main table else......");
						int criteria6Main = criteria6Repository.insertCriteria6FieldInfoMain(
								onlinef2ffdpobj.getCriteriaId().getCollegeId(),
								onlinef2ffdpobj.getCriteriaId().getFinancialYear(),
								onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria6Main affiliated else====>" + criteria6Main);
						// Insert 6341 tb
						int result6331 = criteria6Repository.insertYearTable6331Af(
								onlinef2ffdpobj.getOnlineorF2FFDP().get(0).getInputfdpt1(), 1, 1,
								onlinef2ffdpobj.getCriteriaId().getCollegeId(),
								onlinef2ffdpobj.getCriteriaId().getFinancialYear(),
								onlinef2ffdpobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result6331 affiliated inserted=======>" + result6331);

					}

				} else {
					System.out.println("onlinef2ffdp \"online FDP  data is not mapped.......................");
				}
			} else {
				System.out.println("onlinef2ffdp obj is null or empty.................................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Faculty Awards

	private void getFacultyAwardsCriteriasUpdate() {
		try {
			List<FacultyAwardsMain> awardsInfo1 = facultyAwardsService.getAllFacultyData();
			FacultyAwardsMain awardsInfo = null;
			if (awardsInfo1 != null) {
				awardsInfo = awardsInfo1.get(0);
			}
			if (awardsInfo != null) {

				// 2441 U
				if ("university".equalsIgnoreCase(awardsInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(awardsInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(awardsInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(awardsInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria2_FieldInfo> criteria2 = criteria2Repository.findById(key);
					if (criteria2.isPresent()) {
						if (CollectionUtils.isEmpty(criteria2.get().getUniversityYearTable2441())) {
							System.out.println(" yr 2441 is empty.....");
							// Insert 2441
							int result2441 = criteria2Repository.insertYearTable2441(
									awardsInfo.getFacultyAwards().get(0).getInputfat9(), 1, 1,
									awardsInfo.getCriteriaId().getCollegeId(),
									awardsInfo.getCriteriaId().getFinancialYear(),
									awardsInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result2441 inserted=======>" + result2441);

						} else {
							// update 2441
							System.out.println("yr 2441 is not  empty.....");
							String value2441 = criteria2.get().getUniversityYearTable2441().get(0).getInput2441v();
							System.out.println("existing value is============>" + value2441);
							BigDecimal bd = new BigDecimal(value2441);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>" + awardsInfo.getFacultyAwards().get(0).getUniqueKey1());
							int update2441 = criteria2Repository.updateYearTable2441(finalValue,
									awardsInfo.getFacultyAwards().get(0).getUniqueKey1());
							System.out.println("update2441 u=======>" + update2441);
						}
					} else {

						System.out.println("inserting into cr2 main table else......");
						int criteria2Main = criteria2Repository.insertCriteria2Main(
								awardsInfo.getCriteriaId().getCollegeId(),
								awardsInfo.getCriteriaId().getFinancialYear(),
								awardsInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// insert 2421 tx area
						int result2441 = criteria2Repository.insertYearTable2441(
								awardsInfo.getFacultyAwards().get(0).getInputfat9(), 1, 1,
								awardsInfo.getCriteriaId().getCollegeId(),
								awardsInfo.getCriteriaId().getFinancialYear(),
								awardsInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result2441 inserted=======>" + result2441);

					}
				} else {
					System.out.println("inserted and updated into 2441........");
				}
				System.out.println("now inserting into table 3331 university.........");

				// 3331 table U

				if ("university".equalsIgnoreCase(awardsInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(awardsInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(awardsInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(awardsInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable3331())) {
							System.out.println(" yr 3331 is empty.....");
							// Insert 3331
							int result3331 = criteria3Repository.insertYearTable3331(
									awardsInfo.getFacultyAwards().get(0).getInputfat9(), 1, 1,
									awardsInfo.getCriteriaId().getCollegeId(),
									awardsInfo.getCriteriaId().getFinancialYear(),
									awardsInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3331 inserted=======>" + result3331);

						} else {
							// update 3331
							System.out.println("yr 3331 is not  empty.....");
							String value3331 = criteria3.get().getUniversityYearTable3331().get(0).getInput3331v();
							System.out.println("existing value is============>" + value3331);
							BigDecimal bd = new BigDecimal(value3331);
							int finalValue1 = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue1);
							System.out.println("unique key ==>" + awardsInfo.getFacultyAwards().get(0).getUniqueKey1());
							int update3331 = criteria3Repository.updateYearTable3331(finalValue1,
									awardsInfo.getFacultyAwards().get(0).getUniqueKey1());
							System.out.println("update3331 u=======>" + update3331);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								awardsInfo.getCriteriaId().getCollegeId(),
								awardsInfo.getCriteriaId().getFinancialYear(),
								awardsInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria3Main);
						// Insert 3331
						int result3331 = criteria3Repository.insertYearTable3331(
								awardsInfo.getFacultyAwards().get(0).getInputfat9(), 1, 1,
								awardsInfo.getCriteriaId().getCollegeId(),
								awardsInfo.getCriteriaId().getFinancialYear(),
								awardsInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3331 inserted=======>" + result3331);

					}
				} else {
					System.out.println("Faculty Awards data not mapped...............");
				}

			} else {
				System.out.println("facultyAwards obj is null or empty..........................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Research Fellows Enrolled

	private void getResearchFellowsEnrolledCriteriasUpdate() {
		try {
			List<ResearchFellowsEnrolledMain> reseachFellowsInfo1 = researchFellowsService.getAllResearchFellowsData();
			ResearchFellowsEnrolledMain reseachFellowsInfo = null;
			if (reseachFellowsInfo1 != null) {
				reseachFellowsInfo = reseachFellowsInfo1.get(0);
			}
			if (reseachFellowsInfo != null) {
				// 3141 U
				if ("university".equalsIgnoreCase(reseachFellowsInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(reseachFellowsInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(reseachFellowsInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(reseachFellowsInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable3141())) {
							System.out.println("3141 table is empty.....");
							// Insert 3141 tb
							int result3141 = criteria3Repository.insertYearTable3141(
									reseachFellowsInfo.getResearchFellowsEnrolledinInstitution().get(0).getInputrft4(),
									1, 1, reseachFellowsInfo.getCriteriaId().getCollegeId(),
									reseachFellowsInfo.getCriteriaId().getFinancialYear(),
									reseachFellowsInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3141 inserted=======>" + result3141);
						} else {
							// update 3141 tb
							System.out.println("yr 3141 is not  empty.....");
							String value3141 = criteria3.get().getUniversityYearTable3141().get(0).getInput3141v();
							System.out.println("existing value3141 is============>" + value3141);
							BigDecimal bd = new BigDecimal(value3141);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>" + reseachFellowsInfo
									.getResearchFellowsEnrolledinInstitution().get(0).getUniqueKey1());
							int update3141 = criteria3Repository.updateYearTable3141(finalValue, reseachFellowsInfo
									.getResearchFellowsEnrolledinInstitution().get(0).getUniqueKey1());
							System.out.println("update3141 u=======>" + update3141);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria2Main = criteria3Repository.insertCriteria3FieldInfoMain(
								reseachFellowsInfo.getCriteriaId().getCollegeId(),
								reseachFellowsInfo.getCriteriaId().getFinancialYear(),
								reseachFellowsInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria2Main else====>" + criteria2Main);
						// Insert 3141 tb
						int result3141 = criteria3Repository.insertYearTable3141(
								reseachFellowsInfo.getResearchFellowsEnrolledinInstitution().get(0).getInputrft4(), 1,
								1, reseachFellowsInfo.getCriteriaId().getCollegeId(),
								reseachFellowsInfo.getCriteriaId().getFinancialYear(),
								reseachFellowsInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3141 inserted=======>" + result3141);
					}
				} else {
					System.out.println("Research Fellows Data is not mapped................");
				}
			} else {
				System.out.println("reseachFellowsInfo obj is null or empty...........................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Patents

	private void getPatentsCriteriasUpdate() {
		try {
			List<PatentsMain> patentsObj1 = patentsService.getAllPatentData();
			PatentsMain patentsObj = null;
			if (patentsObj1 != null) {
				patentsObj = patentsObj1.get(0);
			}
			if (patentsObj != null) {
				// 3431 U
				if ("university".equalsIgnoreCase(patentsObj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(patentsObj.getCriteriaId().getCollegeId());
					key.setFinancialYear(patentsObj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(patentsObj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getUniversityYearTable3431())) {
							System.out.println("3431 table is empty.....");
							// Insert 3431 tb
							int result3431 = criteria3Repository.insertYearTable3431(
									patentsObj.getPatents().get(0).getInputppt7(), 1, 1,
									patentsObj.getCriteriaId().getCollegeId(),
									patentsObj.getCriteriaId().getFinancialYear(),
									patentsObj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3431 inserted=======>" + result3431);
						} else {
							// update 3431 tb
							System.out.println("yr 3431 is not  empty.....");
							String value3431 = criteria3.get().getUniversityYearTable3431().get(0).getInput3431v();
							System.out.println("existing value3431 is============>" + value3431);
							BigDecimal bd = new BigDecimal(value3431);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println("unique key ==>" + patentsObj.getPatents().get(0).getUniqueKey1());
							int update3431 = criteria3Repository.updateYearTable3431(finalValue,
									patentsObj.getPatents().get(0).getUniqueKey1());
							System.out.println("update3321 u=======>" + update3431);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								patentsObj.getCriteriaId().getCollegeId(),
								patentsObj.getCriteriaId().getFinancialYear(),
								patentsObj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3431 tb
						int result3431 = criteria3Repository.insertYearTable3431(
								patentsObj.getPatents().get(0).getInputppt7(), 1, 1,
								patentsObj.getCriteriaId().getCollegeId(),
								patentsObj.getCriteriaId().getFinancialYear(),
								patentsObj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3431 inserted=======>" + result3431);

					}
				} else {
					System.out.println("Patents data is not mapped.....................");
				}
			} else {
				System.out.println("Patents obj is null or empty.....................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// PHD Awarded

	private void getPHDAwardedCriteriasUpdate() {
		try {
			List<PhdAwardedorRegisteredMain> phdInfo1 = phDAwardedService.getAllPhDAwardedData();
			PhdAwardedorRegisteredMain phdInfo = null;
			if (phdInfo1 != null) {
				phdInfo = phdInfo1.get(0);
			}
			if (phdInfo != null) {

				// 3441 & 3442
				if ("university".equalsIgnoreCase(phdInfo.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(phdInfo.getCriteriaId().getCollegeId());
					key.setFinancialYear(phdInfo.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(phdInfo.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getYearTable3441())) {
							System.out.println("3441 table is empty.....");
							// Insert 3441 tb
							int result3441 = criteria3Repository.insertYearTable3441(
									phdInfo.getPhdAwardedorRegistered().get(0).getInputphdt10(), 1, 1,
									phdInfo.getCriteriaId().getCollegeId(), phdInfo.getCriteriaId().getFinancialYear(),
									phdInfo.getCriteriaId().getTypeofInstitution());
							System.out.println("result3441 inserted=======>" + result3441);

						} else {
							// update 3441 tb
							System.out.println("yr 3441 is not  empty.....");
							String value3441 = criteria3.get().getYearTable3441().get(0).getInput3441v();
							System.out.println("existing value3441 is============>" + value3441);
							BigDecimal bd = new BigDecimal(value3441);
							int finalValue = bd.intValue() + 1;
							System.out.println("what is the final value ==>" + finalValue);
							System.out.println(
									"unique key ==>" + phdInfo.getPhdAwardedorRegistered().get(0).getUniqueKey1());
							int update3441 = criteria3Repository.updateYearTable3441(finalValue,
									phdInfo.getPhdAwardedorRegistered().get(0).getUniqueKey1());
							System.out.println("update3441 u=======>" + update3441);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								phdInfo.getCriteriaId().getCollegeId(), phdInfo.getCriteriaId().getFinancialYear(),
								phdInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3441 tb
						int result3441 = criteria3Repository.insertYearTable3441(
								phdInfo.getPhdAwardedorRegistered().get(0).getInputphdt10(), 1, 1,
								phdInfo.getCriteriaId().getCollegeId(), phdInfo.getCriteriaId().getFinancialYear(),
								phdInfo.getCriteriaId().getTypeofInstitution());
						System.out.println("result3441 inserted=======>" + result3441);

					}
				} else {
					System.out.println("PHDAwarded data is not mapped..........................");
				}
			} else {
				System.out.println("phdInfo obj is null or empty.........................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// H-Index
	private void getHindexCriteriasData() {
		try {
			List<Hindex> hindexobj1 = hindexService.getAllHindexData();
			Hindex hindexobj = null;
			if (hindexobj1 != null) {
				hindexobj = hindexobj1.get(0);
			}
			if (hindexobj != null) {
				// 3.4.9 U
				if ("university".equalsIgnoreCase(hindexobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(hindexobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(hindexobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(hindexobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getCriteria34Ql())) {
							System.out.println("3491 Ql is empty.....");
							// Insert 3491
							int result3491 = criteria3Repository.insertCriteria3491U(hindexobj.getInputhit5(),
									hindexobj.getInputhit4(), 1, hindexobj.getCriteriaId().getCollegeId(),
									hindexobj.getCriteriaId().getFinancialYear(),
									hindexobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3491 inserted=======>" + result3491);

						} else {
							// update 3491
							System.out.println("Ql 3491 is not  empty.....");
							String value3491t1 = criteria3.get().getCriteria34Ql().get(0).getInput3491t1();
							String value3491t2 = criteria3.get().getCriteria34Ql().get(0).getInput3491t2();
							System.out.println("existing value3491t1 is============>" + value3491t1
									+ "  value3491t2====> " + value3491t2);
							BigDecimal bd1 = new BigDecimal(value3491t1);
							BigDecimal bd2 = new BigDecimal(value3491t2);
							BigDecimal finalValue1 = bd1.add(new BigDecimal(hindexobj.getInputhit5()));
							BigDecimal finalValue2 = bd2.add(new BigDecimal(hindexobj.getInputhit4()));
							System.out.println("what is the final value ==>" + finalValue1 + "    finalValue2=====>"
									+ finalValue2);
							System.out.println("unique key ==>" + hindexobj.getUniqueKey1());
							int update3491 = criteria3Repository.updateCriteria3491U(finalValue1, finalValue2,
									hindexobj.getUniqueKey1());
							System.out.println("update3491 u=======>" + update3491);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								hindexobj.getCriteriaId().getCollegeId(), hindexobj.getCriteriaId().getFinancialYear(),
								hindexobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3491
						int result3491 = criteria3Repository.insertCriteria3491U(hindexobj.getInputhit5(),
								hindexobj.getInputhit4(), 1, hindexobj.getCriteriaId().getCollegeId(),
								hindexobj.getCriteriaId().getFinancialYear(),
								hindexobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3491 inserted=======>" + result3491);

					}
				}
				// 3.4.6.1 Au
				else if ("autonomous".equalsIgnoreCase(hindexobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(hindexobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(hindexobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(hindexobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getCriteria34Qn())) {
							System.out.println("3461 Qn is empty.....");
							// Insert 3461
							int result3461 = criteria3Repository.insertCriteria3461AU(hindexobj.getInputhit5(),
									hindexobj.getInputhit4(), 0, 0, hindexobj.getUniqueKey1(),
									hindexobj.getCriteriaId().getCollegeId(),
									hindexobj.getCriteriaId().getFinancialYear(),
									hindexobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3461 & 3451  inserted=======>" + result3461);

						} else {
							// update 3461
							System.out.println("Qn 3461 is not  empty.....");
							String value3461t1 = criteria3.get().getCriteria34Qn().get(0).getInput3461t1();
							String value3461t2 = criteria3.get().getCriteria34Qn().get(0).getInput3461t2();
							System.out.println("existing value3461t1 is============>" + value3461t1
									+ "  value3461t2====> " + value3461t2);

							BigDecimal finalValue3 = new BigDecimal(0);
							BigDecimal finalValue4 = new BigDecimal(0);
							System.out.println(" variables declared=====>");

							if (value3461t1 != null) {
								BigDecimal bd3 = new BigDecimal(value3461t1);
								finalValue3 = bd3.add(new BigDecimal(hindexobj.getInputhit5()));
								System.out.println("bd3 value is====>" + bd3);
								System.out.println("finalValue3 value is====>" + finalValue3);
							} else {
								BigDecimal bd3n = new BigDecimal(0);
								finalValue3 = bd3n.add(new BigDecimal(hindexobj.getInputhit5()));
								System.out.println("what is the finalValue3  ====>" + finalValue3);
							}

							System.out.println("value3461t2 is======>" + value3461t2);

							if (value3461t2 != null) {
								BigDecimal bd4 = new BigDecimal(value3461t2);
								finalValue4 = bd4.add(new BigDecimal(hindexobj.getInputhit4()));
								System.out.println("bd4 value is====>" + bd4);
								System.out.println("finalValue4 value is====>" + finalValue4);
							} else {
								BigDecimal bd4n = new BigDecimal(0);
								finalValue4 = bd4n.add(new BigDecimal(hindexobj.getInputhit4()));
								System.out.println("what is the finalValue4 ==>" + finalValue4);
							}

							System.out.println("h index .....");

							System.out.println("unique key ==>" + hindexobj.getUniqueKey1());
							int update3461 = criteria3Repository.updateCriteria3461AU(finalValue3, finalValue4,
									hindexobj.getUniqueKey1());
							System.out.println("update3461 u=======>" + update3461);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								hindexobj.getCriteriaId().getCollegeId(), hindexobj.getCriteriaId().getFinancialYear(),
								hindexobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3461
						int result3461 = criteria3Repository.insertCriteria3461AU(hindexobj.getInputhit5(),
								hindexobj.getInputhit4(), 0, 0, hindexobj.getUniqueKey1(),
								hindexobj.getCriteriaId().getCollegeId(), hindexobj.getCriteriaId().getFinancialYear(),
								hindexobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3461 inserted=======>" + result3461);

					}
				} else {
					System.out.println("H-index data is not mapped........................");
				}
			} else {
				System.out.println("hindex obj is null or empty...............");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Citations

	private void getCitationsCriteriasUpdate() {
		try {
			List<Citations> citationsobj1 = citationsService.getAllCitationsData();
			Citations citationsobj = null;
			if (citationsobj1 != null) {
				citationsobj = citationsobj1.get(0);
			}
			if (citationsobj != null) {

				// 3.4.8.1 U insert
				if ("university".equalsIgnoreCase(citationsobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(citationsobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(citationsobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(citationsobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getCriteria34Qn())) {
							System.out.println("3481 Qn is empty.....");
							// Insert 3481
							int result3481 = criteria3Repository.insertCriteria3481U(citationsobj.getInputct5(),
									citationsobj.getInputct4(), 1, citationsobj.getCriteriaId().getCollegeId(),
									citationsobj.getCriteriaId().getFinancialYear(),
									citationsobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3481 inserted=======>" + result3481);

						} else {
							// update 3481
							System.out.println("Qn 3481 is not  empty.....");
							String value3481t1 = criteria3.get().getCriteria34Qn().get(0).getInput348t1();
							String value3481t2 = criteria3.get().getCriteria34Qn().get(0).getInput348t2();
							System.out.println("existing value3481 is============>" + value3481t1
									+ "  value3481t2====> " + value3481t2);
							BigDecimal bd1 = new BigDecimal(value3481t1);
							BigDecimal bd2 = new BigDecimal(value3481t2);
							BigDecimal finalValue1 = bd1.add(new BigDecimal(citationsobj.getInputct5()));
							BigDecimal finalValue2 = bd2.add(new BigDecimal(citationsobj.getInputct4()));
							System.out.println("what is the final value ==>" + finalValue1 + "    finalValue2=====>"
									+ finalValue2);
							System.out.println("unique key ==>" + citationsobj.getUniqueKey1());
							int update3481 = criteria3Repository.updateCriteria3481U(finalValue1, finalValue2,
									citationsobj.getUniqueKey1());
							System.out.println("update3481 u=======>" + update3481);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								citationsobj.getCriteriaId().getCollegeId(),
								citationsobj.getCriteriaId().getFinancialYear(),
								citationsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3481
						int result3481 = criteria3Repository.insertCriteria3481U(citationsobj.getInputct5(),
								citationsobj.getInputct4(), 1, citationsobj.getCriteriaId().getCollegeId(),
								citationsobj.getCriteriaId().getFinancialYear(),
								citationsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3481 inserted=======>" + result3481);

					}
				}
				// 3.4.5.1 Au
				else if ("autonomous".equalsIgnoreCase(citationsobj.getCriteriaId().getTypeofInstitution())) {

					CriteriaPrimaryKey key = new CriteriaPrimaryKey();
					key.setCollegeId(citationsobj.getCriteriaId().getCollegeId());
					key.setFinancialYear(citationsobj.getCriteriaId().getFinancialYear());
					key.setTypeofInstitution(citationsobj.getCriteriaId().getTypeofInstitution());
					Optional<Criteria3_FieldInfo> criteria3 = criteria3Repository.findById(key);
					if (criteria3.isPresent()) {
						if (CollectionUtils.isEmpty(criteria3.get().getCriteria34Qn())) {
							System.out.println("3451 Qn is empty.....");
							// Insert 3451
							int result3451Au = criteria3Repository.insertCriteria3451Au(citationsobj.getInputct5(),
									citationsobj.getInputct4(), 1, citationsobj.getCriteriaId().getCollegeId(),
									citationsobj.getCriteriaId().getFinancialYear(),
									citationsobj.getCriteriaId().getTypeofInstitution());
							System.out.println("result3451Au inserted=======>" + result3451Au);

						} else {
							// update 3451
							System.out.println("Qn 3451 is not  empty.....");
							String value3451t1 = criteria3.get().getCriteria34Qn().get(0).getInput3451t1();
							String value3451t2 = criteria3.get().getCriteria34Qn().get(0).getInput3451t2();
							System.out.println("existing value3451t1 is============>" + value3451t1
									+ "  value3451t2====> " + value3451t2);
							BigDecimal bd3 = new BigDecimal(value3451t1);
							BigDecimal bd4 = new BigDecimal(value3451t2);
							BigDecimal finalValue3 = bd3.add(new BigDecimal(citationsobj.getInputct5()));
							BigDecimal finalValue4 = bd4.add(new BigDecimal(citationsobj.getInputct4()));
							System.out.println("what is the final value ==>" + finalValue3 + "    finalValue2=====>"
									+ finalValue4);
							System.out.println("unique key ==>" + citationsobj.getUniqueKey1());
							int update3451Au = criteria3Repository.updateCriteria3451Au(finalValue3, finalValue4,
									citationsobj.getUniqueKey1());
							System.out.println("update3451Au u=======>" + update3451Au);
						}
					} else {

						System.out.println("inserting into cr3 main table else......");
						int criteria3Main = criteria3Repository.insertCriteria3FieldInfoMain(
								citationsobj.getCriteriaId().getCollegeId(),
								citationsobj.getCriteriaId().getFinancialYear(),
								citationsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("criteria3Main else====>" + criteria3Main);
						// Insert 3481
						int result3451Au = criteria3Repository.insertCriteria3451Au(citationsobj.getInputct5(),
								citationsobj.getInputct4(), 1, citationsobj.getCriteriaId().getCollegeId(),
								citationsobj.getCriteriaId().getFinancialYear(),
								citationsobj.getCriteriaId().getTypeofInstitution());
						System.out.println("result3451Au inserted=======>" + result3451Au);

					}
				} else {
					System.out.println("Citations data is not mapped.......................");
				}
			} else {
				System.out.println("citation obj is null or empty...................");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
