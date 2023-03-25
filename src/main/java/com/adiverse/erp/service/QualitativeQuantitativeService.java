
  package com.adiverse.erp.service;
  
  import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import
  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.GeneralParameter;
import com.adiverse.erp.model.Qualitative;
import com.adiverse.erp.model.QualitativeCriterionWise;
import com.adiverse.erp.model.QualitativeQuantitativeCriterionWise;
import com.adiverse.erp.model.QualitativeQuantitativeInfo;
import com.adiverse.erp.model.QuantitativeCriterionWise;
import com.adiverse.erp.model.QuantitativeData;
import com.adiverse.erp.model.QuantitativeInfo;
import com.adiverse.erp.model.User;
import com.adiverse.erp.repository.QualitativeCriteriaWiseRepository;
import com.adiverse.erp.repository.QualitativeQuantitativeCriteriaWiseRepository;
import com.adiverse.erp.repository.QualitativeQuantitativeRepository;
import com.adiverse.erp.repository.QualitativeRepository;
import com.adiverse.erp.repository.QuantitativeCriteriaWiseRepository;
import com.adiverse.erp.repository.QuantitativeRepository;

  
  @Service
  public class QualitativeQuantitativeService {
  
  @Autowired 
  private QualitativeQuantitativeRepository  qualitativequantitativeRepo;
  
	@Autowired
	private   QualitativeRepository qualitativeRepository;
	
	@Autowired
	private QuantitativeRepository quantitativeRepository;
	
	@Autowired
	private QualitativeQuantitativeCriteriaWiseRepository qlqnRepository;
	
	@Autowired
	private QualitativeCriteriaWiseRepository qlRepository;
	
	
	@Autowired
	private QuantitativeCriteriaWiseRepository qnRepository;
	
	//---email
	@Autowired
	private JavaMailSender javaMailSender;
	
	public QualitativeQuantitativeService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	
	
	
	
	
  
  private final Logger log = LoggerFactory.getLogger(this.getClass());
  
  
  
  
//  public QualitativeQuantitative qualityInfo(QualitativeQuantitative data) {
//  
//  return qualitativequantitative.save(data);
//  
//  }
  
  
  public QualitativeQuantitativeInfo saveQualityInfo(QualitativeQuantitativeInfo qualitativeQuantitativeInfo) {
	  return qualitativequantitativeRepo.save(qualitativeQuantitativeInfo);
  }
  
  
  public List<QualitativeQuantitativeInfo> getAllPdfData() { 
	  try {
		  List<QualitativeQuantitativeInfo> qualitativeQuantitativeInfo = new ArrayList<QualitativeQuantitativeInfo>();
  
		  qualitativequantitativeRepo.findAll().forEach(qualitativeQuantitativeInfo::add);
  
		  return qualitativeQuantitativeInfo;
  
  
	  }catch (Exception e) {
		  e.printStackTrace();
		  return null;
		  }
  }
//  
//	  public List getAllQnAndQlData() { 
//		  try {
//			  List bundleInfo = new ArrayList<>();
//			  List<QualitativeInfo> qualitativeInfo = new ArrayList<QualitativeInfo>();
//			  List<QuantitativeInfo> quantitativeInfo = new ArrayList<QuantitativeInfo>();
//	  
//			  qualitativeRepository.findAll().forEach(qualitativeInfo::add);
//			  bundleInfo.addAll(qualitativeInfo);
//			  
//			  quantitativeRepository.findAll().forEach(quantitativeInfo::add);
//			  bundleInfo.addAll(quantitativeInfo);
//			  return bundleInfo;
//	  
//	  
//		  }catch (Exception e) {
//			  e.printStackTrace();
//			  return null;
//			  }
//		  
//	  
//  
//  }
	  
	  public QuantitativeData saveQuantitativeInfo(QuantitativeData quantitativeInfo) {

			return quantitativeRepository.save(quantitativeInfo);

		}
	  
	  public Qualitative saveQualtitativeInfo(Qualitative quanlitativeInfo) {

			return qualitativeRepository.save(quanlitativeInfo);

		}





	public List<Qualitative> getAllQualitativedataData() {
		    try {
		      List<Qualitative> qualitative = new ArrayList<Qualitative>();
		     
		      qualitativeRepository.findAll().forEach(qualitative::add);
		   
		      return qualitative;
		    
		   
		  }catch (Exception e) { return null;}
			
	
	}
	
	public List<QualitativeQuantitativeCriterionWise> getCriteriawise()  {
	    try {
	      List<QualitativeQuantitativeCriterionWise> cwise = new ArrayList<QualitativeQuantitativeCriterionWise>();
	     
	      qlqnRepository.findAll().forEach(cwise::add);
	   
	      return cwise;
	    
	   
	  }catch (Exception e) { return null;}
		

}
	
	public List<QualitativeCriterionWise> getQualCriteriawise()  {
	    try {
	      List<QualitativeCriterionWise> qualwise = new ArrayList<QualitativeCriterionWise>();
	     
	      qlRepository.findAll().forEach(qualwise::add);
	   
	      return qualwise;
	    
	   
	  }catch (Exception e) { return null;}
		

}
	public List<QuantitativeCriterionWise> getQuanCriteriawise()  {
	    try {
	      List<QuantitativeCriterionWise> quanwise = new ArrayList<QuantitativeCriterionWise>();
	     
	      qnRepository.findAll().forEach(quanwise::add);
	   
	      return quanwise;
	    
	   
	  }catch (Exception e) { return null;}
		

}
	
	
	public List<QuantitativeData> getAllQuantitativeInfo() {
		try {
			List<QuantitativeData> quantitativeInfo = new ArrayList<QuantitativeData>();

			quantitativeRepository.findAll().forEach(quantitativeInfo::add);

			return quantitativeInfo;

		} catch (Exception e) {
			//logger.info("Got Exception while fetching the data from the table QuantitativeInfo =>{}", e);
			return null;
		}

	}
	public String sendAuthorizedEmail(User userDetails) {

		String email1 = "namita131996@gmail.com";
		String email;

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof User) {
			email = ((User) principal).getEmail();
		} else {
			email = principal.toString();
		}
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		// HttpSession session = request.getSession(true);

		try {

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			// mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(email1);
			// mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
			mimeMessageHelper.setText("<html><body> The email has been send to the expert for review </body></html>",
					true);

			mimeMessageHelper.setSubject("Automated email");

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
					new File("D:\\Files\\pdf_2022-10-10_05_59_58.pdf"));

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
  
	}}
 