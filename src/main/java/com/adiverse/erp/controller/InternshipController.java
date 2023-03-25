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

import com.adiverse.erp.model.InternshipForm_WB;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.InternshipService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class InternshipController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private InternshipService internshipService;

	@PostMapping(value = "/internshipupload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Internship(
			@RequestPart(name = "internshipForm") InternshipForm_WB internshipForm,
			@RequestPart(name = "internshipfiles") MultipartFile[] internshipfiles) {

		String message = "";
		try {
			internshipService.internshipInfo(internshipForm, internshipfiles);

			message = "Uploaded the Internship file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Internship file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallinternshipfiles")
	public ResponseEntity<List<InternshipForm_WB>> getInternListFiles() {
		List<InternshipForm_WB> Files = internshipService.getAllInternshipFiles();

		return ResponseEntity.status(HttpStatus.OK).body(Files);
	}

}
