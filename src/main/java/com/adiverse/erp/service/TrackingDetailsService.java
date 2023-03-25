package com.adiverse.erp.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.TrackingDetails;
import com.adiverse.erp.model.User;
import com.adiverse.erp.openpdf.AffiliatedQualityAdivisorReport;
import com.adiverse.erp.openpdf.AutonomousQualityAdivisorReport2;
import com.adiverse.erp.openpdf.UniversityQualityAdvisorReport;
import com.adiverse.erp.repository.TrackingDetailsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
@Transactional
public class TrackingDetailsService 
{
	
	@Autowired
	private UserService userService;
	@Autowired
	private AffiliatedQualityAdivisorReport affiliatedQualityAdivisorReport;
	@Autowired
	private UniversityQualityAdvisorReport universityQualityAdvisorReport;
	@Autowired
	private AutonomousQualityAdivisorReport2 autonomousQualityAdivisorReport2;
	@Autowired
	private TrackingService trackingService;
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private TrackingDetailsRepository trackingDetailsRepository;
	
	boolean isGenerateReport = true;
	int counter = 0;
	
	
	public TrackingDetails trackingDetailsInfo(TrackingDetails programsAuthorise) {

		return trackingDetailsRepository.save(programsAuthorise);
		
		
	}

	public List<TrackingDetails> getAllTrakingDetialsData(Map<String, String> allParams) {
		
		List<TrackingDetails> trackingDetails = new ArrayList<TrackingDetails>();
		
		ObjectMapper mapper=new ObjectMapper();
		try {
		 CriteriaPrimaryKey id =new CriteriaPrimaryKey();
         id.setCollegeId(allParams.get("collegeId"));
         id.setFinancialYear(allParams.get("financialYear"));
			id.setTypeofInstitution(allParams.get("typeofInstitution"));
			
			
			
			System.out.println("id object is--->"+mapper.writeValueAsString(id));
			Optional<TrackingDetails> academic2 = trackingDetailsRepository.findById(id);
			
			System.out.println("options ==>"+mapper.writeValueAsString(academic2));
			if (academic2.isPresent()) {
				trackingDetails.add(academic2.get());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return trackingDetails;
		
	}
	
	public List<TrackingDetails> getAllEvaluationData(Map<String, String> allParams) { 
		try {
			
			ObjectMapper mapper =new ObjectMapper();
			
			List<TrackingDetails> evaluation = new ArrayList<TrackingDetails>();
			CriteriaPrimaryKey id =new CriteriaPrimaryKey();
			   
			
			    id.setCollegeId(allParams.get("collegeId"));
	            id.setFinancialYear(allParams.get("financialYear"));
				id.setTypeofInstitution(allParams.get("typeofInstitution"));
				System.out.println("id object is--->"+mapper.writeValueAsString(id));
			
				
				
				List<TrackingDetails> academic2 = trackingDetailsRepository.progreamsdata(allParams.get("collegeId"),
						allParams.get("financialYear"),allParams.get("typeofInstitution"));
				
				System.out.println("academic2"+mapper.writeValueAsString(academic2));
				
//				System.out.println("options ==>"+mapper.writeValueAsString(academic2));
//
//				if (academic2.isPresent()) {
//					evaluation.add(academic2.get());
//				}
				System.out.println("options evaluation ==>"+mapper.writeValueAsString(evaluation));

				return academic2;

		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}

	}
	
	
	/*
	 * This method is used for sending the mail of whole report from principle to the quality advisor
	 *  
	 */
	
	
	public String sendPrincipalAuthorizedEmails(TrackingDetails programsAuthorise) {
		
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String reportPath = "";

		
 
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("collegeId",programsAuthorise.getCriteriaId().getCollegeId() );
		allParams.put("financialYear",programsAuthorise.getCriteriaId().getFinancialYear() );
		allParams.put("typeofInstitution", programsAuthorise.getCriteriaId().getTypeofInstitution());
		

		ObjectMapper mapper= new ObjectMapper();
		try {
			System.out.println("tracking===>"+mapper.writeValueAsString(programsAuthorise));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		

       try {
                      
			try {
				if(programsAuthorise.getPrincipalStatus()!=null) {
				
				List<TrackingDetails>  status=getAllEvaluationData(allParams);
				
				
				System.out.println("TrackingDetails===>"+mapper.writeValueAsString(status));
				
				status.stream().forEach(eachRecord ->{
	    			
	   
	    			
	    			if("criteria1".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				
	    				counter++;
	    			};
	    			if("criteria2".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				counter++;
	    			};
	    			if("criteria3".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				counter++;
	    			};
	    			if("criteria4".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				counter++;
	    			};
	    			if("criteria5".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				counter++;
	    			};
	    			if("criteria6".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				counter++;
	    			};
	    			if("criteria7".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				counter++;
	    			};
	    			if("Executive".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				System.out.println("Executive");
	    				counter++;
	    			};
	    			if("BasicInformation".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				System.out.println("BasicInformation");

	    				counter++;
	    			};
	    			if("AccademicInformation".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				System.out.println("AccademicInformation");

	    				counter++;
	    			};
	    			if("EvaluativeReport".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				System.out.println("EvaluativeReport");
	    				counter++;
	    			};
	    			if("ExtendedProfile".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				System.out.println("ExtendedProfile");

	    				counter++;
	    			};
	    			if("EvaluationReportView".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				System.out.println("EvaluationReportView");
	    				counter++;
	    			};
	    			if("IIQA".equalsIgnoreCase(eachRecord.getProgrammerId()) && "A".equalsIgnoreCase(eachRecord.getPrincipalStatus())){
	    				System.out.println("IIQA");
	    				counter++;
	    			};
	    			
	    		});
				
				System.out.println("counter====>"+counter);
				
				if("autonomous".equalsIgnoreCase( programsAuthorise.getCriteriaId().getTypeofInstitution())&&counter==14)
				{
					reportPath = autonomousQualityAdivisorReport2.generateReport(allParams);
				}
				if("affiliated".equalsIgnoreCase( programsAuthorise.getCriteriaId().getTypeofInstitution())&&counter==12)
				{
					reportPath = affiliatedQualityAdivisorReport.generateReport(allParams);
				}
				if("university".equalsIgnoreCase( programsAuthorise.getCriteriaId().getTypeofInstitution())&&counter==14)
				{
					reportPath = universityQualityAdvisorReport.generateReport(allParams);
				}
				
				}

				else
				{
					if("autonomous".equalsIgnoreCase( programsAuthorise.getCriteriaId().getTypeofInstitution()))
					{
						reportPath = autonomousQualityAdivisorReport2.generateReport(allParams);
					}
					if("affiliated".equalsIgnoreCase( programsAuthorise.getCriteriaId().getTypeofInstitution()))
					{
						reportPath = affiliatedQualityAdivisorReport.generateReport(allParams);
					}
					if("university".equalsIgnoreCase( programsAuthorise.getCriteriaId().getTypeofInstitution()))
					{
						reportPath = universityQualityAdvisorReport.generateReport(allParams);
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				counter=0;
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

//			mimeMessageHelper.setText("<html><body>Dear QA"
//					+ ",<br>Email has been sent to QualityAdviser for correction.<br>-Adiverse Team.</body></html>",
//					true);
			String contentAuth = "<html><body>Hi ,<br><br>Email has been sent to prinicipal for review.<br><br>-Adiverse Team.</body></html>";
			String contentReject = "<html><body>  ,<br><br>Email has been sent to dean for correction.<br><br>-Adiverse Team.</body></html>";
			if(programsAuthorise.getPrincipalComments() != null && !"".equalsIgnoreCase(programsAuthorise.getPrincipalComments())) {
				mimeMessageHelper.setText(contentReject,true);
			}else {
				mimeMessageHelper.setText(contentAuth,true);
			}
			mimeMessageHelper.setSubject(" NAAC Report");
			logger.info("report generated path with file is ==>" + reportPath);
			if (reportPath != null && !StringUtils.isEmpty(reportPath)) {
				logger.info("is the report path not empty ==>" + reportPath);
				// Adding the attachment
				FileSystemResource file = new FileSystemResource(new File(reportPath));

				mimeMessageHelper.addAttachment(file.getFilename(), file);
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

	
		
}
