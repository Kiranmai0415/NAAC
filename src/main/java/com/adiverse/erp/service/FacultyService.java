package com.adiverse.erp.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.AdmissionEnquiryForm_MB;
import com.adiverse.erp.model.AdmissionEnquiryForm_WB;
import com.adiverse.erp.model.AdmissionForm_MB;
import com.adiverse.erp.model.AdmissionForm_WB;
import com.adiverse.erp.model.CourseRegistrationform_WB;
import com.adiverse.erp.model.DashboardProgramsAuthorise;
import com.adiverse.erp.model.DocumentSubmission_mb;
import com.adiverse.erp.model.DocumentSubmission_wb;
import com.adiverse.erp.model.EventDetails_mb;
import com.adiverse.erp.model.EventDetails_wb;
import com.adiverse.erp.model.EventFileupload;
import com.adiverse.erp.model.FacultyFileupload;
import com.adiverse.erp.model.FacultyReport_Mb;
import com.adiverse.erp.model.FacultyReport_Wb;

import com.adiverse.erp.model.FacultydailyReport_MB;
import com.adiverse.erp.model.FacultydailyReport_WB;
import com.adiverse.erp.model.FeedbackForm_MB;
import com.adiverse.erp.model.FeedbackForm_WB;
import com.adiverse.erp.model.FileUploadProperties;
import com.adiverse.erp.model.InternshipForm_MB;
import com.adiverse.erp.model.InternshipForm_WB;
import com.adiverse.erp.model.LaptopAvailability_MB;
import com.adiverse.erp.model.LaptopAvailability_WB;
import com.adiverse.erp.model.ResearchPublications_mb;
import com.adiverse.erp.model.ResearchPublications_wb;
import com.adiverse.erp.model.StudentForm_MB;
import com.adiverse.erp.model.StudentForm_WB;
import com.adiverse.erp.model.StudentInternshipForm_WB;
import com.adiverse.erp.model.TeachingActivities_MB;
import com.adiverse.erp.model.TeachingActivities_WB;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.model.User;
import com.adiverse.erp.repository.DocumentSubmissionrepository;
import com.adiverse.erp.repository.EventRepository;
import com.adiverse.erp.repository.FacultyRepository;
import com.adiverse.erp.repository.FacultyRepositoryDaily;
import com.adiverse.erp.repository.ResearchPublicationsrepository;
import com.adiverse.erp.repository.TeachingActivitiesRepository;
import com.adiverse.erp.repository.TeachingActivitiesRepositoryMB;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class FacultyService {
	private final Logger logger = LoggerFactory.getLogger(FacultyService.class);

	@Autowired
	private FacultyRepository facultyRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private ResearchPublicationsrepository researchRepository;

	@Autowired
	private FacultyRepositoryDaily facultyRepositorydaily;

	@Autowired
	private DocumentSubmissionrepository documentSubmissionrepository;

	@Autowired
	private TeachingActivitiesRepository teachingActivitiesRepository;

	@Autowired
	private TeachingActivitiesRepositoryMB teachingActivitiesRepositoryMB;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdmissionEnquiryService admissionEnquiryService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private StudentService studentService;
	
	
	
	@Autowired
	private InternshipService internshipService;
	

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private Path dirLocation;

	@Autowired
	public FacultyService(FileUploadProperties fileUploadProperties) {
		this.dirLocation = Paths.get(fileUploadProperties.getLocation()).toAbsolutePath().normalize();
	}

	public DocumentSubmission_wb facultyfileInfo(DocumentSubmission_wb documentSubmission,
			MultipartFile[] uploadfilefaculty) {

		try {
			log.info("uploadfile=========" + uploadfilefaculty.length);
			log.info("employee info===" + documentSubmission);
			List<FacultyFileupload> facultyFile = new ArrayList<>();

			// teachingActivities.setTeaching_id(new Integer(6).longValue());
			for (int i = 0; i < uploadfilefaculty.length; i++) {
				// Get the filename and build the local file path
				String filename = uploadfilefaculty[i].getOriginalFilename();
				log.info("File name is : " + filename);
				Path dfile = this.dirLocation.resolve(filename);
				String filepath = dfile.toString();
				log.info("path:" + filepath);

				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(uploadfilefaculty[i].getBytes());

				stream.close();
				// String param=filename.substring(0,filename.indexOf("-"));
				// save it into file_upload_details table DB
				// String path = "C:\\Users\\risha\\Desktop\\uploads\\"; tb
				FacultyFileupload facultyFile1 = new FacultyFileupload();
				// facultyFile1.setUniqueKey1(param.concat("-"+documentSubmission.getFinancialYear()));
				facultyFile1.setTeachingstaff_fileName(filename);
				facultyFile1.setTeachingstaff_filePath(filepath);
				facultyFile1.setTeachingstaff_fileType(uploadfilefaculty[i].getContentType());
				// facultyFile1.setCriteriaId(documentSubmission.getCriteriaId());

				facultyFile.add(facultyFile1);

			}
			documentSubmission.setFacultyFileupload(facultyFile);

			return documentSubmissionrepository.save(documentSubmission);

//    		log.info("employee details are"+employee);
//    		_tutorial = inputRepository.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}

	}
	public List<DocumentSubmission_wb> getDocumentSubmissionwbs() {
		try {
			List<DocumentSubmission_wb> documentSubmission = new ArrayList<DocumentSubmission_wb>();

			documentSubmissionrepository.findAll().forEach(documentSubmission::add);

			return documentSubmission;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	

	public TeachingActivities_WB TeachingInfo(TeachingActivities_WB teaching) {

		return teachingActivitiesRepository.save(teaching);

	}

	public List<TeachingActivities_WB> getAllTeachingWBData() {
		try {
			List<TeachingActivities_WB> teachingWBData = new ArrayList<TeachingActivities_WB>();

			teachingActivitiesRepository.findAll().forEach(teachingWBData::add);

			return teachingWBData;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//////

	public TeachingActivities_MB teachingInfo1(TeachingActivities_MB teaching1) {

		return teachingActivitiesRepositoryMB.save(teaching1);

	}

	public List<TeachingActivities_MB> getAllteachingData() {
		try {
			List<TeachingActivities_MB> faculty1 = new ArrayList<TeachingActivities_MB>();

			teachingActivitiesRepositoryMB.findAll().forEach(faculty1::add);

			return faculty1;

		} catch (Exception e) {
			return null;
		}
	}

	public List<DocumentSubmission_wb> getAllFacultyFiles() {
		try {
			List<DocumentSubmission_wb> faculty2 = new ArrayList<DocumentSubmission_wb>();

			documentSubmissionrepository.findAll().forEach(faculty2::add);

			return faculty2;

		} catch (Exception e) {
			return null;
		}
	}

	public EventDetails_wb eventInfo(EventDetails_wb eventDetails, MultipartFile[] eventFiles) {

		try {
			log.info("uploadfile=========" + eventFiles.length);
			log.info("employee info===" + eventDetails);
			List<EventFileupload> eventFile = new ArrayList<>();

			// teachingActivities.setTeaching_id(new Integer(6).longValue());
			for (int i = 0; i < eventFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = eventFiles[i].getOriginalFilename();
				log.info("File name is : " + filename);
				Path dfile = this.dirLocation.resolve(filename);
				String filepath = dfile.toString();
				log.info("path:" + filepath);

				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(eventFiles[i].getBytes());

				stream.close();

				// save it into file_upload_details table DB
				// String path = "C:\\Users\\risha\\Desktop\\uploads\\"; tb
				EventFileupload eventFile1 = new EventFileupload();
				eventFile1.setFileName(filename);
				eventFile1.setFilePath(filepath);
				eventFile1.setFileType(eventFiles[i].getContentType());

				eventFile.add(eventFile1);

			}

			eventDetails.setEventFileupload(eventFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return eventRepository.save(eventDetails);

	}

	public FacultydailyReport_WB FacultyInfo(FacultydailyReport_WB faculty) {

		return facultyRepositorydaily.save(faculty);

	}

	public List<FacultydailyReport_WB> getAllFacultyDailyData() {
		try {
			List<FacultydailyReport_WB> faculty1 = new ArrayList<FacultydailyReport_WB>();

			facultyRepositorydaily.findAll().forEach(faculty1::add);

			return faculty1;

		} catch (Exception e) {
			return null;
		}
	}

	public FacultyReport_Wb FacultyInfo1(FacultyReport_Wb faculty1) {

		return facultyRepository.save(faculty1);

	}

	public List<FacultyReport_Wb> getAllFacultyData() {
		try {
			List<FacultyReport_Wb> faculty1 = new ArrayList<FacultyReport_Wb>();

			facultyRepository.findAll().forEach(faculty1::add);

			return faculty1;

		} catch (Exception e) {
			return null;
		}
	}

	public List<EventDetails_wb> getAllEventData() {
		try {
			List<EventDetails_wb> event = new ArrayList<EventDetails_wb>();

			eventRepository.findAll().forEach(event::add);

			return event;

		} catch (Exception e) {
			return null;
		}
	}

	public ResearchPublications_wb researchInfo(ResearchPublications_wb researchPublications,
			MultipartFile[] researchFiles) {

		try {
			log.info("uploadfile=========" + researchFiles.length);
			log.info("employee info===" + researchPublications);
			List<FacultyFileupload> facultyFile = new ArrayList<>();

			// teachingActivities.setTeaching_id(new Integer(6).longValue());
			for (int i = 0; i < researchFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = researchFiles[i].getOriginalFilename();
				log.info("File name is : " + filename);
				Path dfile = this.dirLocation.resolve(filename);
				String filepath = dfile.toString();
				log.info("path:" + filepath);

				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(researchFiles[i].getBytes());

				stream.close();

				// save it into file_upload_details table DB
				// String path = "C:\\Users\\risha\\Desktop\\uploads\\"; tb
				FacultyFileupload facultyFile1 = new FacultyFileupload();
				facultyFile1.setTeachingstaff_fileName(filename);
				facultyFile1.setTeachingstaff_filePath(filepath);
				facultyFile1.setTeachingstaff_fileType(researchFiles[i].getContentType());

				facultyFile.add(facultyFile1);

			}
			researchPublications.setFacultyFileupload(facultyFile);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return researchRepository.save(researchPublications);

	}

	public List<ResearchPublications_wb> getAllResearchFiles() {
		try {
			List<ResearchPublications_wb> research = new ArrayList<ResearchPublications_wb>();

			researchRepository.findAll().forEach(research::add);

			return research;

		} catch (Exception e) {
			return null;
		}
	}

///
//	public String sendAutomatedEmail(TeachingActivities_MB programsAuthorise, String institutionType,
//			String screenType) {
//
//		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//		MimeMessageHelper mimeMessageHelper;
//		String comments = programsAuthorise.getCheckerdate();
//
//		try {
//
//			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//			logger.info("email TO: " + programsAuthorise.getAuthorizedBy());
//			List<User> userList = userService.getAllUserRecords();
//			userList.stream().forEach(eachUser -> {
//				try {
//					mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(eachUser.getEmail()));
//				} catch (MessagingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			});
//			mimeMessageHelper.setTo(programsAuthorise.getAuthorizedBy());
//			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
//			String contentAuth = "<html><body>Hi " + programsAuthorise.getAuthorizedBy()
//					+ ",<br><br>Email has been sent to Hod for review.<br><br>-Adiverse Team.</body></html>";
//			String contentReject = "<html><body>Hi " + programsAuthorise.getAuthorizedBy()
//					+ ",<br><br>Email has been sent to Faculty for correction.\r\n\r\n<br><br>" + "HODComments:"
//					+ comments + "<br><br>-Adiverse Team.</body></html>";
//			if (programsAuthorise.getDeanComments() != null
//					&& !"".equalsIgnoreCase(programsAuthorise.getDeanComments())) {
//				mimeMessageHelper.setText(contentReject, true);
//			} else {
//				mimeMessageHelper.setText(contentAuth, true);
//			}
//
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

	public String authorizeForms(Tracking tracking, String screenType) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("object is ==>" + mapper.writeValueAsString(tracking));
			System.out.println("screen type is ======>" + screenType);
			if ("teaching".equalsIgnoreCase(screenType)) {
				List<TeachingActivities_WB> teachingList = getAllTeachingWBData();
				TeachingActivities_MB teachingMb = new TeachingActivities_MB();
				teachingMb.setFf1t1(teachingList.get(0).getFf1t1());
				teachingMb.setFf1t2(teachingList.get(0).getFf1t2());
				teachingMb.setFf1t3(teachingList.get(0).getFf1t3());
				teachingMb.setFf1t4(teachingList.get(0).getFf1t4());
				teachingMb.setFf1t5(teachingList.get(0).getFf1t5());
				teachingMb.setFf1t6(teachingList.get(0).getFf1t6());
				teachingMb.setFf1t7(teachingList.get(0).getFf1t7());
				teachingMb.setFf1t8(teachingList.get(0).getFf1t8());
				teachingMb.setFf1t9(teachingList.get(0).getFf1t9());
				teachingMb.setFf1t10(teachingList.get(0).getFf1t10());
				teachingMb.setFf1t11(teachingList.get(0).getFf1t11());
				teachingMb.setFf1t12(teachingList.get(0).getFf1t12());
				teachingMb.setWorkstatus("A");
				teachingMb.setCheckerid(tracking.getAssignedBy());
				teachingMb.setCheckerdate(tracking.getDate());
				
		
			}
			else if("facultyReport".equalsIgnoreCase(screenType)) {
				List<FacultyReport_Wb>facultyReportList= getAllFacultyData();
				FacultyReport_Mb facultyReportmb = new FacultyReport_Mb();
				facultyReportmb.setFf6t1(facultyReportList.get(0).getFf6t1());
				facultyReportmb.setFf6t2(facultyReportList.get(0).getFf6t2());
				facultyReportmb.setFf6t3(facultyReportList.get(0).getFf6t3());
				facultyReportmb.setFf6t4(facultyReportList.get(0).getFf6t4());
				facultyReportmb.setFf6t5(facultyReportList.get(0).getFf6t5());
				facultyReportmb.setFf6t6(facultyReportList.get(0).getFf6t6());
				facultyReportmb.setFf6t7(facultyReportList.get(0).getFf6t7());
				facultyReportmb.setFf6t8(facultyReportList.get(0).getFf6t8());
				facultyReportmb.setFf6t9(facultyReportList.get(0).getFf6t9());
				facultyReportmb.setFf6t10(facultyReportList.get(0).getFf6t10());
				facultyReportmb.setFf6t11(facultyReportList.get(0).getFf6t11());
				facultyReportmb.setFf6t12(facultyReportList.get(0).getFf6t12());
				facultyReportmb.setFf6t13(facultyReportList.get(0).getFf6t13());
				facultyReportmb.setFf6t14(facultyReportList.get(0).getFf6t14());
				facultyReportmb.setFf6t15(facultyReportList.get(0).getFf6t15());
				facultyReportmb.setFf6t16(facultyReportList.get(0).getFf6t16());
				facultyReportmb.setFf6t17(facultyReportList.get(0).getFf6t17());
				facultyReportmb.setFf6t18(facultyReportList.get(0).getFf6t18());
				facultyReportmb.setFf6t19(facultyReportList.get(0).getFf6t19());
				facultyReportmb.setWorkstatus("A");
				facultyReportmb.setCheckerid(tracking.getAssignedBy());
				facultyReportmb.setCheckerdate(tracking.getDate());
				
				
			}
			else if("facultyDailyReport".equalsIgnoreCase(screenType)) {
			List<FacultydailyReport_WB>facultyDailyReportList=getAllFacultyDailyData();
			FacultydailyReport_MB facultydailyReportmb =new FacultydailyReport_MB();
			facultydailyReportmb.setFf5t1(facultyDailyReportList.get(0).getFf5t1());
			facultydailyReportmb.setFf5t2(facultyDailyReportList.get(0).getFf5t2());
			facultydailyReportmb.setFf5t3(facultyDailyReportList.get(0).getFf5t3());
			facultydailyReportmb.setFf5t4(facultyDailyReportList.get(0).getFf5t4());
			facultydailyReportmb.setFf5t5(facultyDailyReportList.get(0).getFf5t5());
			facultydailyReportmb.setFf5t6(facultyDailyReportList.get(0).getFf5t6());
			facultydailyReportmb.setFf5t7(facultyDailyReportList.get(0).getFf5t7());
			facultydailyReportmb.setFf5t8(facultyDailyReportList.get(0).getFf5t8());
			facultydailyReportmb.setFf5t9(facultyDailyReportList.get(0).getFf5t9());
			facultydailyReportmb.setFf5t10(facultyDailyReportList.get(0).getFf5t10());
			facultydailyReportmb.setFf5t11(facultyDailyReportList.get(0).getFf5t11());
			facultydailyReportmb.setFf5t12(facultyDailyReportList.get(0).getFf5t12());
			facultydailyReportmb.setFf5t13(facultyDailyReportList.get(0).getFf5t13());
			facultydailyReportmb.setFf5t14(facultyDailyReportList.get(0).getFf5t14());
			facultydailyReportmb.setFf5t15(facultyDailyReportList.get(0).getFf5t15());
			facultydailyReportmb.setWorkstatus("A");
			facultydailyReportmb.setCheckerid(tracking.getAssignedBy());
			facultydailyReportmb.setCheckerdate(tracking.getDate());
			
				
			}
			
			else if("documentSubmission".equalsIgnoreCase(screenType)) {
			List<DocumentSubmission_wb>documentSubmissionWbList = getDocumentSubmissionwbs();
			DocumentSubmission_mb documentSubmissionmb = new DocumentSubmission_mb();
			documentSubmissionmb.setFf2t1(documentSubmissionWbList.get(0).getFf2t1());
			documentSubmissionmb.setFf2t2(documentSubmissionWbList.get(0).getFf2t2());
			documentSubmissionmb.setFf2t3(documentSubmissionWbList.get(0).getFf2t3());
			documentSubmissionmb.setFf2t4(documentSubmissionWbList.get(0).getFf2t4());
			documentSubmissionmb.setFf2t5(documentSubmissionWbList.get(0).getFf2t5());
			documentSubmissionmb.setFf2t6(documentSubmissionWbList.get(0).getFf2t6());
			documentSubmissionmb.setWorkstatus("A");
			documentSubmissionmb.setCheckerid(tracking.getAssignedBy());
			documentSubmissionmb.setCheckerdate(tracking.getDate());
			
			
				
			}
			else if("evenDetails".equalsIgnoreCase(screenType))	{
				List<EventDetails_wb>eventDetailsWbList = getAllEventData();
				EventDetails_mb eventDetailsMb = new EventDetails_mb();
				eventDetailsMb.setFf4t1(eventDetailsWbList.get(0).getFf4t1());
				eventDetailsMb.setFf4t2(eventDetailsWbList.get(0).getFf4t2());
				eventDetailsMb.setFf4t3(eventDetailsWbList.get(0).getFf4t3());
				eventDetailsMb.setFf4t4(eventDetailsWbList.get(0).getFf4t4());
				eventDetailsMb.setFf4t5(eventDetailsWbList.get(0).getFf4t5());
				eventDetailsMb.setFf4t6(eventDetailsWbList.get(0).getFf4t6());
				eventDetailsMb.setFf4t7(eventDetailsWbList.get(0).getFf4t7());
				eventDetailsMb.setFf4t8(eventDetailsWbList.get(0).getFf4t8());
				eventDetailsMb.setFf4t9(eventDetailsWbList.get(0).getFf4t9());
				eventDetailsMb.setFf4t10(eventDetailsWbList.get(0).getFf4t10());
				eventDetailsMb.setWorkstatus("A");
				eventDetailsMb.setCheckerid(tracking.getAssignedBy());
				eventDetailsMb.setCheckerdate(tracking.getDate());

			}
			else if("researchPublications".equalsIgnoreCase(screenType)) {
				List<ResearchPublications_wb>researchPublicationsWbList = getAllResearchFiles();
				ResearchPublications_mb researchPublicationsMb = new ResearchPublications_mb();
				researchPublicationsMb.setFf3t1(researchPublicationsWbList.get(0).getFf3t1());
				researchPublicationsMb.setFf3t2(researchPublicationsWbList.get(0).getFf3t12());
				researchPublicationsMb.setFf3t3(researchPublicationsWbList.get(0).getFf3t13());
				researchPublicationsMb.setFf3t4(researchPublicationsWbList.get(0).getFf3t4());
				researchPublicationsMb.setFf3t5(researchPublicationsWbList.get(0).getFf3t5());
				researchPublicationsMb.setFf3t6(researchPublicationsWbList.get(0).getFf3t6());
				researchPublicationsMb.setFf3t7(researchPublicationsWbList.get(0).getFf3t7());
				researchPublicationsMb.setFf3t8(researchPublicationsWbList.get(0).getFf3t8());
				researchPublicationsMb.setFf3t9(researchPublicationsWbList.get(0).getFf3t9());
				researchPublicationsMb.setFf3t10(researchPublicationsWbList.get(0).getFf3t10());
				researchPublicationsMb.setFf3t11(researchPublicationsWbList.get(0).getFf3t11());
				researchPublicationsMb.setFf3t12(researchPublicationsWbList.get(0).getFf3t12());
				researchPublicationsMb.setFf3t13(researchPublicationsWbList.get(0).getFf3t13());
				researchPublicationsMb.setFf3t14(researchPublicationsWbList.get(0).getFf3t14());
				researchPublicationsMb.setFf3t15(researchPublicationsWbList.get(0).getFf3t15());
				researchPublicationsMb.setFf3t16(researchPublicationsWbList.get(0).getFf3t16());
				researchPublicationsMb.setFf3t17(researchPublicationsWbList.get(0).getFf3t17());
				researchPublicationsMb.setWorkstatus("A");
				researchPublicationsMb.setCheckerid(tracking.getAssignedBy());
				researchPublicationsMb.setCheckerdate(tracking.getDate());
			}
			else if("adminForms".equalsIgnoreCase(screenType)) {
				List<AdmissionForm_WB>adminFormList = adminService.getAllAdminFiles();
				AdmissionForm_MB admissionForm_MB = new AdmissionForm_MB();
				admissionForm_MB.setAf1t1(adminFormList.get(0).getAf1t1());
				admissionForm_MB.setAf1t2(adminFormList.get(0).getAf1t2());
				admissionForm_MB.setAf1t3(adminFormList.get(0).getAf1t3());
				admissionForm_MB.setAf1t4(adminFormList.get(0).getAf1t4());
				admissionForm_MB.setAf1t5(adminFormList.get(0).getAf1t5());
				admissionForm_MB.setAf1t6(adminFormList.get(0).getAf1t6());
				admissionForm_MB.setAf1t7(adminFormList.get(0).getAf1t7());
				admissionForm_MB.setAf1t8(adminFormList.get(0).getAf1t8());
				admissionForm_MB.setAf1t9(adminFormList.get(0).getAf1t9());
				admissionForm_MB.setAf1t10(adminFormList.get(0).getAf1t10());
				admissionForm_MB.setAf1t11(adminFormList.get(0).getAf1t11());
				admissionForm_MB.setAf1t12(adminFormList.get(0).getAf1t1());
				admissionForm_MB.setAf1t13(adminFormList.get(0).getAf1t1());
				admissionForm_MB.setAf1t14(adminFormList.get(0).getAf1t1());
				admissionForm_MB.setWorkstatus("A");
				admissionForm_MB.setCheckerid(tracking.getAssignedBy());
				admissionForm_MB.setCheckerdate(tracking.getDate());
				
			}
			else if("admissionEnquiryForm".equalsIgnoreCase(screenType)) {
			List<AdmissionEnquiryForm_WB> admissionEnquiryFormWb = admissionEnquiryService.getAllAdmissionFiles();
			AdmissionEnquiryForm_MB admissionEnquiryFormMB = new AdmissionEnquiryForm_MB();
			admissionEnquiryFormMB.setAf2t1(admissionEnquiryFormWb.get(0).getAf2t1());
			admissionEnquiryFormMB.setAf2t2(admissionEnquiryFormWb.get(0).getAf2t3());
			admissionEnquiryFormMB.setAf2t3(admissionEnquiryFormWb.get(0).getAf2t3());
			admissionEnquiryFormMB.setAf2t4(admissionEnquiryFormWb.get(0).getAf2t4());
			admissionEnquiryFormMB.setAf2t5(admissionEnquiryFormWb.get(0).getAf2t5());
			admissionEnquiryFormMB.setAf2t6(admissionEnquiryFormWb.get(0).getAf2t6());
			admissionEnquiryFormMB.setAf2t7(admissionEnquiryFormWb.get(0).getAf2t7());
			admissionEnquiryFormMB.setAf2t8(admissionEnquiryFormWb.get(0).getAf2t8());
			admissionEnquiryFormMB.setAf2t9(admissionEnquiryFormWb.get(0).getAf2t9());
			admissionEnquiryFormMB.setAf2t10(admissionEnquiryFormWb.get(0).getAf2t10());
			admissionEnquiryFormMB.setAf2t11(admissionEnquiryFormWb.get(0).getAf2t11());
			admissionEnquiryFormMB.setAf2t12(admissionEnquiryFormWb.get(0).getAf2t12());
			admissionEnquiryFormMB.setAf2t13(admissionEnquiryFormWb.get(0).getAf2t13());
			admissionEnquiryFormMB.setAf2t14(admissionEnquiryFormWb.get(0).getAf2t14());
			admissionEnquiryFormMB.setWorkstatus("A");
			admissionEnquiryFormMB.setCheckerid(tracking.getAssignedBy());
			admissionEnquiryFormMB.setCheckerdate(tracking.getDate());
			
			
			}
			else if("feedbackForm".equalsIgnoreCase(screenType)) {
				List<FeedbackForm_WB>feedbackFormWBList =feedbackService.getAllFeedbackData();
				FeedbackForm_MB feedbackFormMB = new FeedbackForm_MB();
				feedbackFormMB.setFf1t1(feedbackFormWBList.get(0).getFf1t1());
				feedbackFormMB.setFf1t2(feedbackFormWBList.get(0).getFf1t2());
				feedbackFormMB.setFf1t3(feedbackFormWBList.get(0).getFf1t3());
				feedbackFormMB.setFf1t4(feedbackFormWBList.get(0).getFf1t4());
				feedbackFormMB.setFf1t5(feedbackFormWBList.get(0).getFf1t5());
				feedbackFormMB.setFf1t6(feedbackFormWBList.get(0).getFf1t6());
				
				feedbackFormMB.setWorkstatus("A");
				
				feedbackFormMB.setCheckerid(tracking.getAssignedBy());
				feedbackFormMB.setCheckerdate(tracking.getDate());
				
				
			}
			
			else if("studentform".equalsIgnoreCase(screenType))	{
				List<StudentForm_WB>studentFormList = studentService.getAllStudentFiles();
				StudentForm_MB studentFormMb = new StudentForm_MB();
				studentFormMb.setSf1t1(studentFormList.get(0).getSf1t1());
				studentFormMb.setSf1t2(studentFormList.get(0).getSf1t2());
				studentFormMb.setSf1t3(studentFormList.get(0).getSf1t3());
				studentFormMb.setSf1t4(studentFormList.get(0).getSf1t4());
				studentFormMb.setSf1t5(studentFormList.get(0).getSf1t5());
				studentFormMb.setSf1t6(studentFormList.get(0).getSf1t6());
				studentFormMb.setSf1t7(studentFormList.get(0).getSf1t7());
				studentFormMb.setSf1t8(studentFormList.get(0).getSf1t8());
				studentFormMb.setSf1t9(studentFormList.get(0).getSf1t9());
				studentFormMb.setSf1t10(studentFormList.get(0).getSf1t10());
				
				studentFormMb.setSf1t11(studentFormList.get(0).getSf1t11());
				
				studentFormMb.setWorkstatus("A");
				studentFormMb.setCheckerid(tracking.getAssignedBy());
				
				studentFormMb.setCheckerdate(tracking.getDate());
				
			}
			else if("lapTopAvailabilityForm".equalsIgnoreCase(screenType)) {
				
			List<LaptopAvailability_WB>	laptopAvailabilityList = studentService.getAllLaptopData();
			LaptopAvailability_MB laptopAvailabilityMB = new LaptopAvailability_MB();
			laptopAvailabilityMB.setSf2t1(laptopAvailabilityList.get(0).getSf2t1());
			laptopAvailabilityMB.setSf2t2(laptopAvailabilityList.get(0).getSf2t2());
			laptopAvailabilityMB.setSf2t3(laptopAvailabilityList.get(0).getSf2t3());
			laptopAvailabilityMB.setSf2t4(laptopAvailabilityList.get(0).getSf2t4());
			laptopAvailabilityMB.setSf2t5(laptopAvailabilityList.get(0).getSf2t5());
			laptopAvailabilityMB.setSf2t6(laptopAvailabilityList.get(0).getSf2t6());
			laptopAvailabilityMB.setSf2t7(laptopAvailabilityList.get(0).getSf2t7());
			laptopAvailabilityMB.setSf2t8(laptopAvailabilityList.get(0).getSf2t8());
			laptopAvailabilityMB.setSf2t9(laptopAvailabilityList.get(0).getSf2t9());
			laptopAvailabilityMB.setWorkstatus("A");
			laptopAvailabilityMB.setCheckerid(tracking.getAssignedBy());
			laptopAvailabilityMB.setCheckerdate(tracking.getDate());
			
			
				
			}
			
			else if("studentInternshipForm".equalsIgnoreCase(screenType))	{
				
			List<StudentInternshipForm_WB> studentInternshipFormList = studentService.getAllstudentIntern();
			StudentForm_MB studentForm_MB = new StudentForm_MB();
			
			studentForm_MB.setSf1t1(studentInternshipFormList.get(0).getSf3t1());
			studentForm_MB.setSf1t2(studentInternshipFormList.get(0).getSf3t1());
			studentForm_MB.setSf1t3(studentInternshipFormList.get(0).getSf3t1());
			studentForm_MB.setSf1t4(studentInternshipFormList.get(0).getSf3t1());
			studentForm_MB.setSf1t5(studentInternshipFormList.get(0).getSf3t1());
			studentForm_MB.setSf1t6(studentInternshipFormList.get(0).getSf3t1());
			studentForm_MB.setSf1t7(studentInternshipFormList.get(0).getSf3t1());
			studentForm_MB.setSf1t8(studentInternshipFormList.get(0).getSf3t1());
			studentForm_MB.setSf1t9(studentInternshipFormList.get(0).getSf3t1());
			studentForm_MB.setSf1t10(studentInternshipFormList.get(0).getSf3t1());
			studentForm_MB.setSf1t11(studentInternshipFormList.get(0).getSf3t1());
			studentForm_MB.setWorkstatus("A");
			studentForm_MB.setCheckerid(tracking.getAssignedBy());
			studentForm_MB.setCheckerdate(tracking.getDate());
			
			
			}
			
			else if("CourseRegistre".equalsIgnoreCase(screenType))	{
				
				List<CourseRegistrationform_WB> courseRegistrationform_WB = studentService.getAllCourseRegistre();
				StudentForm_MB studentForm_MB = new StudentForm_MB();
				
				studentForm_MB.setSf1t1(courseRegistrationform_WB.get(0).getSf4t1());
				studentForm_MB.setSf1t2(courseRegistrationform_WB.get(0).getSf4t2());
				studentForm_MB.setSf1t3(courseRegistrationform_WB.get(0).getSf4t3());
				studentForm_MB.setSf1t4(courseRegistrationform_WB.get(0).getSf4t4());
				studentForm_MB.setSf1t5(courseRegistrationform_WB.get(0).getSf4t5());
				studentForm_MB.setSf1t6(courseRegistrationform_WB.get(0).getSf4t6());
				studentForm_MB.setSf1t7(courseRegistrationform_WB.get(0).getSf4t7());
				studentForm_MB.setSf1t8(courseRegistrationform_WB.get(0).getSf4t8());
				studentForm_MB.setSf1t9(courseRegistrationform_WB.get(0).getSf4t9());
	
				studentForm_MB.setWorkstatus("A");
				studentForm_MB.setCheckerid(tracking.getAssignedBy());
				studentForm_MB.setCheckerdate(tracking.getDate());

				
				
				
			}	
			else if("intershipform".equalsIgnoreCase(screenType))	{
				List<InternshipForm_WB> InternshipFormwbList = internshipService.getAllInternshipFiles();
				InternshipForm_MB internshipForm_MB = new InternshipForm_MB();
				
				internshipForm_MB.setIf1t1(InternshipFormwbList.get(0).getIf1t1());
				internshipForm_MB.setIf1t2(InternshipFormwbList.get(0).getIf1t2());
				internshipForm_MB.setIf1t3(InternshipFormwbList.get(0).getIf1t3());
				internshipForm_MB.setIf1t4(InternshipFormwbList.get(0).getIf1t4());
				internshipForm_MB.setIf1t5(InternshipFormwbList.get(0).getIf1t5());
				internshipForm_MB.setIf1t6(InternshipFormwbList.get(0).getIf1t6());
				internshipForm_MB.setIf1t7(InternshipFormwbList.get(0).getIf1t7());
				internshipForm_MB.setIf1t8(InternshipFormwbList.get(0).getIf1t8());
				internshipForm_MB.setIf1t9(InternshipFormwbList.get(0).getIf1t9());
				internshipForm_MB.setIf1t10(InternshipFormwbList.get(0).getIf1t10());
				internshipForm_MB.setIf1t11(InternshipFormwbList.get(0).getIf1t11());
				internshipForm_MB.setWorkstatus("A");
				internshipForm_MB.setCheckerid(tracking.getAssignedBy());
				internshipForm_MB.setCheckerdate(tracking.getDate());
				
			
			}
			
			
			
			
			
			
			
			
			
			
			
	
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	
	}

}
