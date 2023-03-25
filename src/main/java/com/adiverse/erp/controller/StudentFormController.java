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

import com.adiverse.erp.model.CourseRegistrationform_WB;
import com.adiverse.erp.model.LaptopAvailability_WB;
import com.adiverse.erp.model.StudentForm_WB;
import com.adiverse.erp.model.StudentInternshipForm_WB;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class StudentFormController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentService studentService;
	
	

	@PostMapping(value = "/studentupload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Student(@RequestPart(name = "studentform") StudentForm_WB studentform,
			@RequestPart(name = "studentfileUpload") MultipartFile[] studentfileUpload) {

		String message = "";
		try {
			studentService.studentInfo(studentform, studentfileUpload);

			message = "Uploaded the Student file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Student file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallstudentfiles")
	public ResponseEntity<List<StudentForm_WB>> getStudentListFiles() {
		List<StudentForm_WB> studentFiles = studentService.getAllStudentFiles();

		return ResponseEntity.status(HttpStatus.OK).body(studentFiles);
	}
	
	
	//laptop

	@PostMapping(value = "/laptopdata", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Laptop(@RequestPart LaptopAvailability_WB laptopAvailability) {

		String message = "";
		try {
			studentService.laptopInfo(laptopAvailability);

			message = " Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getalllaptopdata")
	public ResponseEntity<List<LaptopAvailability_WB>> getLaptopData() {
		List<LaptopAvailability_WB> laptop1 = studentService.getAllLaptopData();

		return ResponseEntity.status(HttpStatus.OK).body(laptop1);
	}
	
	
	
	/////////////////////Cmr
	
	
	@PostMapping(value = "/Cmr", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> CMR(@RequestPart CourseRegistrationform_WB courseRegistrationformWB,
	@RequestPart(name = "courseRegistreFileUpload") MultipartFile[] courseRegistreFileUpload) 
	
	{
	
		
		
//		public ResponseEntity<MessageResponse> Student(@RequestPart(name = "studentform") StudentForm_WB studentform,
//				@RequestPart(name = "studentfileUpload") MultipartFile[] studentfileUpload) {


		String message = "";
		try {
		//	studentService.Cmr1(courseRegistrationformWB,courseRegistreFileUpload);

			message = " Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallcourseRegistration")
	public ResponseEntity<List<CourseRegistrationform_WB>> getAllCourseRegistre()	 {
		
	//public List<CourseRegistrationform_WB> getAllCourseRegistre()	
		List<CourseRegistrationform_WB> laptop1 = studentService.getAllCourseRegistre();

		return ResponseEntity.status(HttpStatus.OK).body(laptop1);
		
		
	}
	
	
	
	
	/////
	
	@PostMapping(value = "/StudentIntership", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> StudentIntership(@RequestPart StudentInternshipForm_WB studentInternshipForm_WB,
	@RequestPart(name = "studentIntershipFileUpload") MultipartFile[] studentInternshipFileUpload) 
	
	{
	
		String message = "";
		try {
		//	studentService.ST(studentInternshipForm_WB,studentInternshipFileUpload);

			message = " Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallStudent")
	public ResponseEntity<List<StudentInternshipForm_WB>> getAllForms()	 {
		
	//public List<CourseRegistrationform_WB> getAllCourseRegistre()	
		List<StudentInternshipForm_WB> student1 = studentService.getAllForms();

		return ResponseEntity.status(HttpStatus.OK).body(student1);
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
