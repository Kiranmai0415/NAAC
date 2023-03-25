package com.adiverse.erp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.adiverse.erp.model.RejectEmail;
import com.adiverse.erp.repository.RejectemailRepository;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.SimpleMailMessage;
import javax.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;

@Service
@Transactional
public class EmailService
{
	@Autowired
	private  RejectemailRepository rejectemailRepository;
	
	private JavaMailSender javaMailSender;

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
		
	
	}
	
	public RejectEmail emailInfo(RejectEmail rejectEmail)
	 {

			return rejectemailRepository.save(rejectEmail);

	 }
	
	public String sendEmail(RejectEmail rejectemail)  {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */
  try {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(rejectemail.getEmailAddress());
		mail.setSubject("Reject Email");
		mail.setText(rejectemail.getComments());

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
		return "Mail Sent Successfully...";
		
  }catch (Exception e) {
      return "Error while Sending Mail";
  }
	}
	
	 public String sendMailWithAttachment(RejectEmail rejectemail)
	    {
	        // Creating a mime message
	        MimeMessage mimeMessage
	            = javaMailSender.createMimeMessage();
	        MimeMessageHelper mimeMessageHelper;
	 
	        try {
	 
	            // Setting multipart as true for attachments to
	            // be send
	            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	            //mimeMessageHelper.setFrom(sender);
	            mimeMessageHelper.setTo(rejectemail.getEmailAddress());
	            //mimeMessageHelper.setText("<html>rejectemail.getComments()</html>", true);
	            mimeMessageHelper.setText("<html><body> " +rejectemail.getComments() + "</body></html>",true);
	            
	            mimeMessageHelper.setSubject("Reject email");
	 
	            // Adding the attachment
	            FileSystemResource file= new FileSystemResource(new File(rejectemail.getAttachment()));
	 
	            mimeMessageHelper.addAttachment(file.getFilename(), file);
	 
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
    

