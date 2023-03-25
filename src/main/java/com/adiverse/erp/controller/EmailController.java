package com.adiverse.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adiverse.erp.model.RejectEmail;

import com.adiverse.erp.service.EmailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EmailController {

	@Autowired
	private EmailService emailService;

	// Sending a simple Email
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody RejectEmail details)

	{
		emailService.emailInfo(details);

		String status = emailService.sendEmail(details);

		return status;
	}

	// Sending email with attachment
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody RejectEmail details)

	{
		emailService.emailInfo(details);
		String status = emailService.sendMailWithAttachment(details);

		return status;
	}

}
