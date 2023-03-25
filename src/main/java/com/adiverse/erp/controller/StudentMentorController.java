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

import com.adiverse.erp.model.StudentMentorMain;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.StudentMentorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class StudentMentorController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentMentorService studentMentorService;

	@PostMapping(value = "/studentMentorData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Student(
			@RequestPart(name = "studentMentorobj") StudentMentorMain studentMentorobj,
			@RequestPart(name = "studentMentoruploadfile",required = false) MultipartFile[] studentMentoruploadfile) {

		String message = "";
		try {
//	    	    	ObjectMapper mapper=new ObjectMapper();
//	    	    	System.out.println("Files======>"+mapper.writeValueAsString(studentMentoruploadfile));
//	    	    	System.out.println("size oif the upload files -->"+studentMentoruploadfile.length);
			studentMentorService.studentMentor(studentMentorobj, studentMentoruploadfile);

			message = "Uploaded the Data successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Data: ";
//	    	      e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallstudentMentorData")
	public ResponseEntity<List<StudentMentorMain>> getAllStudentfiles() {
		List<StudentMentorMain> files7 = studentMentorService.getAllStudentData();

		return ResponseEntity.status(HttpStatus.OK).body(files7);
	}

}
