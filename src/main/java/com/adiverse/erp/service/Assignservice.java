package com.adiverse.erp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.AssignFunctionality;
import com.adiverse.erp.repository.AssignfunctionalityRepository;




@Service
@Transactional


public class Assignservice
{
	@Autowired
	private AssignfunctionalityRepository assignfunctionalityRepository;
	
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Autowired
	public Assignservice(JavaMailSender javaMailSender) {
	   this.javaMailSender=javaMailSender;
	}
	   public AssignFunctionality assigninfo(AssignFunctionality assignFunctionality) {
		
		return assignfunctionalityRepository.save(assignFunctionality);
	   }
	   
	   public List<AssignFunctionality> getAllAssignData(){
		   try {
			   List<AssignFunctionality>assigndata=new ArrayList<AssignFunctionality>();
			   
			   assignfunctionalityRepository.findAll().forEach(assigndata::add);
			   
			   return assigndata;
		   }catch(Exception e) {
			   e.printStackTrace();
			   return null;
			   
		   }
	   }
	   
	   
	   public String sendAssignFunctionality(AssignFunctionality assignFunctionality,Map<String,String>allparams) {
		   
		 MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		 MimeMessageHelper mimeMessageHelper;
		 
		 String email1=assignFunctionality.getAssignedBy();
		 String email2=assignFunctionality.getAssignedTo();
		 
		 try {
			 mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
			 
			 
			 mimeMessage.addRecipient(RecipientType.TO,new InternetAddress(email1));
			 mimeMessage.addRecipient(RecipientType.TO,new InternetAddress(email2));
			 mimeMessageHelper.setText("<html><body>Hello, this\r\n"+assignFunctionality.getAssignedTo()+" is assigned to you .please ,complete this before"+
					 assignFunctionality.getExpiryDate()+" ,"+"</body></html>",true);
			 
			 mimeMessageHelper.setSubject("assign email  for nacc");
			 
			 javaMailSender.send(mimeMessage);
			 return "mail sent successfully";
		 }
		 catch(Exception e) {
			 System.out.println(e);
			 
			 // dispaly  message when exception occured
			 return "error while sending mail!!!";
			 
			 
			 
			 
			 
		 }

		 }
		 
		   
	   }
	
    

