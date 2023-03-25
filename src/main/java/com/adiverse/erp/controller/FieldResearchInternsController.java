package com.adiverse.erp.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.FieldResearchInternsMain;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.FieldResearchInternsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class FieldResearchInternsController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FieldResearchInternsService fieldResearchInternsService;

	@PostMapping(value = "/fieldResearchData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> facultyAwards(
			@RequestPart(name = "fieldInternsobj") FieldResearchInternsMain fieldInternsobj,
			@RequestPart(name = "fieldInternsFiles",required = false) MultipartFile[] fieldInternsFiles) {

		String message = "";
		try {
			fieldResearchInternsService.fieldInternsInfo(fieldInternsobj, fieldInternsFiles);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallFieldInternsdata")
	public ResponseEntity<List<FieldResearchInternsMain>> getCriteria1ListFiles(@RequestParam Map<String,String>allparams) {
		List<FieldResearchInternsMain> files = fieldResearchInternsService.getAllFieldInternsData(allparams);

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

}
