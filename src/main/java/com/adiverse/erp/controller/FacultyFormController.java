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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.DashboardProgramsAuthorise;
import com.adiverse.erp.model.DocumentSubmission_wb;
import com.adiverse.erp.model.EventDetails_wb;
import com.adiverse.erp.model.FacultyReport_Wb;
import com.adiverse.erp.model.FacultydailyReport_WB;
import com.adiverse.erp.model.ResearchPublications_wb;
import com.adiverse.erp.model.TeachingActivities_MB;
import com.adiverse.erp.model.TeachingActivities_WB;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.FacultyService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class FacultyFormController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FacultyService facultyService;
	
//	@Autowired
//	
//	private Tracking tracking;
	
	
	
	
	//documentSubmission

	@PostMapping(value = "/facultyupload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Faculty(
			@RequestPart(name = "documentSubmission") DocumentSubmission_wb documentSubmission,
			@RequestPart(name = "uploadfilefaculty") MultipartFile[] uploadfilefaculty) {

		String message = "";
		try {
			facultyService.facultyfileInfo(documentSubmission, uploadfilefaculty);

			message = "Uploaded the Faculty file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Faculty file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}
	
	@GetMapping("/getallfacultyfiles")
	public ResponseEntity<List<DocumentSubmission_wb>> getFacultyListFiles() {
		List<DocumentSubmission_wb> facultyFiles = facultyService.getAllFacultyFiles();

		return ResponseEntity.status(HttpStatus.OK).body(facultyFiles);
	}

	
	/////teachingActivities
	@PostMapping(value = "/teachingActivities", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> teaching (@RequestPart TeachingActivities_WB teachingActivities) {

		String message = "";
		try {
			facultyService.TeachingInfo(teachingActivities);

			message = "Uploaded the Faculty file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Faculty file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}
	
	
	@GetMapping("/getallteachingActivities")
	public ResponseEntity<List<TeachingActivities_WB>> getEntity(){
		List<TeachingActivities_WB> facultyFiles = facultyService.getAllTeachingWBData();

		return ResponseEntity.status(HttpStatus.OK).body(facultyFiles);
	}

	//
	
//////////teachingActivitiesAuthorized
	
	@PostMapping("/authorizeForms")
	public String AuthorizedEmail(@RequestBody Tracking tracking, @RequestParam String screenType)
	{
		String status1 = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			System.out.println("object is ==>"+mapper.writeValueAsString(tracking));
			System.out.println("screen type ==>"+screenType);
			
			status1 = facultyService.authorizeForms(tracking, screenType);
			
	
			//status1 = facultyService.sendAutomatedEmail(programsAuthorise, programsAuthorise.getCheckerid(),screenType);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status1;
	}
	
	
	
	
//	
//	@PostMapping("/AuthorizedEmail")
//	public String AuthorizedEmail(@RequestBody TeachingActivities_MB programsAuthorise, @RequestParam String screenType)
//	{
//		String status1 = null;
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			
//			System.out.println("object is ==>"+mapper.writeValueAsString(programsAuthorise));
//			System.out.println("screen type ==>"+screenType);
//			facultyService.TeachingInfo1((programsAuthorise);
//			
//	
//			status1 = facultyService.sendAutomatedEmail(programsAuthorise, programsAuthorise.getCheckerid(),screenType);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return status1;
//	}
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping(value = "/teachingActivitiesmb", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public ResponseEntity<MessageResponse> teaching (@RequestPart TeachingActivities_MB teachingActivitiesmb) {
//
//		String message = "";
//		try {
//			facultyService.TeachingInfo1(teachingActivitiesmb);
//
//			message = "Uploaded the Faculty file successfully:";
//			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
//		} catch (Exception e) {
//			message = "Could not upload the Faculty file: ";
//			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
//		}
//
//	}
	
	//////////////////////
	

	
	@PostMapping(value = "/eventupload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Faculty(@RequestPart(name = "eventDetails") EventDetails_wb eventDetails,
			@RequestPart(name = "eventFiles") MultipartFile[] eventFiles) {

		String message = "";
		try {
			facultyService.eventInfo(eventDetails, eventFiles);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getalleventfiles")
	public ResponseEntity<List<EventDetails_wb>> getEventListFiles() {
		List<EventDetails_wb> eventFiles = facultyService.getAllEventData();

		return ResponseEntity.status(HttpStatus.OK).body(eventFiles);
	}

	@PostMapping(value = "/facultydailydata", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> FacultyDaily(@RequestPart FacultydailyReport_WB facultyDailyreport) {

		System.out.println("facultydailydata");
		String message = "";
		try {
			ObjectMapper mapper= new ObjectMapper();
			System.out.println("facultydailydata===>"+mapper.writeValueAsString(facultyDailyreport));
			facultyService.FacultyInfo(facultyDailyreport);

			message = " Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getalldailyfacultyddata")
	public ResponseEntity<List<FacultydailyReport_WB>> getFacultydailyData() {
		List<FacultydailyReport_WB> facultyDaily = facultyService.getAllFacultyDailyData();

		return ResponseEntity.status(HttpStatus.OK).body(facultyDaily);
	}

	@PostMapping(value = "/facultydata")
	public ResponseEntity<MessageResponse> Faculty(@RequestPart FacultyReport_Wb facultyReport) {

		String message = "";
		try {
			System.out.println("facultydata");
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("facultydata===>"+mapper.writeValueAsString(facultyReport));
			facultyService.FacultyInfo1(facultyReport);
            System.out.println("end");
			message = " Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			e.printStackTrace();
			message = "Could not upload the Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallfacultydata")
	public ResponseEntity<List<FacultyReport_Wb>> getFacultyData() {
		List<FacultyReport_Wb> faculty = facultyService.getAllFacultyData();

		return ResponseEntity.status(HttpStatus.OK).body(faculty);
	}

	@PostMapping(value = "/researchupload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Research(
			@RequestPart(name = "researchPublications") ResearchPublications_wb researchPublications,
			@RequestPart(name = "researchFiles") MultipartFile[] researchFiles) {

		String message = "";
		try {
			facultyService.researchInfo(researchPublications, researchFiles);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallresearchfiles")
	public ResponseEntity<List<ResearchPublications_wb>> getResearchFiles() {
		List<ResearchPublications_wb> researchFiles = facultyService.getAllResearchFiles();

		return ResponseEntity.status(HttpStatus.OK).body(researchFiles);
	}


	
	
	
	
	
}
