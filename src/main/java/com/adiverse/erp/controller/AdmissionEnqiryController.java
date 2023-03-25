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

import com.adiverse.erp.model.AdmissionEnquiryForm_WB;
import com.adiverse.erp.model.AdmissionForm_WB;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.AdmissionEnquiryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AdmissionEnqiryController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdmissionEnquiryService admissionEnquiryService;

	@PostMapping(value = "/admissionEnquiryupload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Admission(
			@RequestPart(name = "admissionEnquiryForm") AdmissionForm_WB admissionEnquiryForm,
			@RequestPart(name = "uploadfileadmin") MultipartFile[] uploadfileadmin) {

		String message = "";
		try {
			admissionEnquiryService.admissionInfo(admissionEnquiryForm, uploadfileadmin);

			message = "Uploaded the  file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getalladmissionfiles")
	public ResponseEntity<List<AdmissionEnquiryForm_WB>> getAdminListFiles() {
		List<AdmissionEnquiryForm_WB> form = admissionEnquiryService.getAllAdmissionFiles();

		return ResponseEntity.status(HttpStatus.OK).body(form);
	}

}
