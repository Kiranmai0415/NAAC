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

import com.adiverse.erp.model.PatentsMain;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.PatentsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PatentsController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PatentsService patentsService;

	@PostMapping(value = "/patentsData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> facultyAwards(@RequestPart(name = "patents") PatentsMain patents,
			@RequestPart(name = "patentsFiles",required = false) MultipartFile[] patentsFiles) {

		String message = "";
		try {
			patentsService.patentsInfo(patents, patentsFiles);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallpatentsdata")
	public ResponseEntity<List<PatentsMain>> getCriteria1ListFiles(@RequestParam Map<String, String> allParams) {
		
		System.out.println("params are --->"+allParams);

		List<PatentsMain> files = patentsService.getAllPatentData();
		System.out.println("patents data from service is ==>"+files);
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

}
