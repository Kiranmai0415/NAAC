package com.adiverse.erp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adiverse.erp.model.MenteeForm;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.MenteeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class MenteeController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MenteeService menteeService;

	@PostMapping(value = "/menteedata")
	public ResponseEntity<MessageResponse> Mentee(@RequestBody MenteeForm menteeForm) {

		String message = "";
		try {
			menteeService.admissionInfo(menteeForm);

			message = "Mentee Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Mentee Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallmenteedata")
	public ResponseEntity<List<MenteeForm>> getMenteetotalData() {
		List<MenteeForm> mentee1 = menteeService.getAllMenteeData();

		return ResponseEntity.status(HttpStatus.OK).body(mentee1);
	}

}
