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

import com.adiverse.erp.model.NumberofWorkshopsSeminorsMain;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.NoOfWorkshopsSeminarsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class NoOfWorkshopsSeminarsController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private NoOfWorkshopsSeminarsService noOfWorkshopsSeminarsService;

	@PostMapping(value = "/noofWorkshopsData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> facultyAwards(
			@RequestPart(name = "noofWorkshopsobj") NumberofWorkshopsSeminorsMain noofWorkshopsobj,
			@RequestPart(name = "noofWorkshopsFiles",required = false) MultipartFile[] noofWorkshopsFiles) {

		String message = "";
		try {
			noOfWorkshopsSeminarsService.noofWorkshopsInfo(noofWorkshopsobj, noofWorkshopsFiles);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallWorkshopsdata")
	public ResponseEntity<List<NumberofWorkshopsSeminorsMain>> getCriteria1ListFiles() {
		List<NumberofWorkshopsSeminorsMain> files = noOfWorkshopsSeminarsService.getAllNoOfWorkshopsData();

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

}
