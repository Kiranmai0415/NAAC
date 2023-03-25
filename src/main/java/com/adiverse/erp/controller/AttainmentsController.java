package com.adiverse.erp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.AttainmentsMain;
import com.adiverse.erp.model.AwardsRecognitionMain;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.AttainmentsService;
import com.adiverse.erp.service.AwardsRecogService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AttainmentsController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AttainmentsService attainmentsService;

	@PostMapping(value = "/attainmentsData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> facultyAwards(
			@RequestPart(name = "attainmentsobj") AttainmentsMain attainmentsobj,
			@RequestPart(name = "attainmentsFile",required = false) MultipartFile[] attainmentsFile) {

		String message = "";
		try {
			attainmentsService.attainmentsInfo(attainmentsobj, attainmentsFile);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallattainmentsdata")
	public ResponseEntity<List<AttainmentsMain>> getCriteria1ListFiles() {
		List<AttainmentsMain> files = attainmentsService.getAllAttainmentData();

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

}
