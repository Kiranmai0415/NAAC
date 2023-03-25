package com.adiverse.erp.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.GeneralParameter;
import com.adiverse.erp.model.QuantitativeInfo;
import com.adiverse.erp.model.User;
import com.adiverse.erp.repository.QuantitativeRepository;

@Service
@Transactional
public class QuantitativeService {
	@Autowired
	private QuantitativeRepository quantitativeRepository;

	@Autowired
	private JavaMailSender javaMailSender;
	
	public QuantitativeService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	private final Logger logger = LoggerFactory.getLogger(QuantitativeService.class);

//	public QuantitativeInfo saveQuantitativeInfo(QuantitativeInfo quantitativeInfo) {
//
//		return quantitativeRepository.save(quantitativeInfo);
//
//	}

//	public List<QuantitativeInfo> getAllQuantitativeInfo() {
//		try {
//			List<QuantitativeInfo> quantitativeInfo = new ArrayList<QuantitativeInfo>();
//
//			quantitativeRepository.findAll().forEach(quantitativeInfo::add);
//
//			return quantitativeInfo;
//
//		} catch (Exception e) {
//			logger.info("Got Exception while fetching the data from the table QuantitativeInfo =>{}", e);
//			return null;
//		}
//
//	}
//	
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
	}

}
