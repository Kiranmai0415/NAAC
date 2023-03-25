package com.adiverse.erp.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.QIAIndicatorMain;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.model.TrackingDetails;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.QiaService;
import com.adiverse.erp.service.TrackingDetailsService;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class QiaController {

	private final Logger logger = LoggerFactory.getLogger(QiaController.class);

	@Autowired
	private QiaService qiaService;

	@Autowired
	private TrackingService trackingService;
	@Autowired
	 private TrackingDetailsService trackingDetailsService;

	@PostMapping(value = "/qiafileupload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Qia(@RequestPart(name = "qiaData") QIAIndicatorMain qiaData,
			@RequestPart(name = "qiaUploadfile") MultipartFile[] qiaUploadfile) {

		String message = "";
		try {
			qiaService.qiaInfo(qiaData, qiaUploadfile);

			message = "Uploaded the QIA File and Data successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file and Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}
	
	
	
	@PostMapping("/qiaRejectRecord")
	public String principalRejectRecord(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams
//			@RequestBody TrackingDetails trackingDetails
			)
			throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(tracking));
		System.out.println("allparams==>"+mapper.writeValueAsString(allParams));
		System.out.println("all params are ==>" + allParams);
		String institutionType = allParams.get("institutionType");
		trackingService.trackingInfo(tracking);
//		trackingDetailsService.trackingDetailsInfo(trackingDetails);

		
		String status = trackingService.sendAutomatedEmail(tracking, institutionType);

		return status;
	}

	
//	@RequestBody TrackingDetails trackingDetails
	
	 @PostMapping("/qiadatasubmit")
		public String extendeDeanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams
			)

		{
	    	System.out.println("qiadatasubmittoprincipal");
	    	ObjectMapper mapper =new ObjectMapper();
	    	try {
				System.out.println("tracking"+mapper.writeValueAsString(tracking));

				System.out.println("allparams==>"+mapper.writeValueAsString(allParams));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String status1 = null;
			Map<String, String> allParams1 = new HashMap<String, String>();
			allParams1.put("collegeId", tracking.getCriteriaId().getCollegeId() );
			allParams1.put("financialYear", tracking.getCriteriaId().getFinancialYear() );
			allParams1.put("typeofInstitution", tracking.getCriteriaId().getTypeofInstitution() );
			

			
			try {
				System.out.println("allparems===++>>"+mapper.writeValueAsString(allParams1));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			trackingService.authorizedInfo(tracking);
			//trackingDetailsService.trackingDetailsInfo(trackingDetails);
			System.out.println("start");
		    status1 =qiaService.qiaMail(allParams1);
			
			return status1;
		}

	

	
	
	
	
	
	@GetMapping("/getallqiafiles")
	public ResponseEntity<List<QIAIndicatorMain>> getQiaListFiles(@RequestParam Map<String, String> allParams) {
		
		System.out.println("params are --->"+allParams);
		
		List<QIAIndicatorMain> qiaIndicator = qiaService.getAllQiaFiles(allParams);
		//logger.info("qiaIndicator ==>{}", qiaIndicator);
		return ResponseEntity.status(HttpStatus.OK).body(qiaIndicator);
	}

	@PostMapping("/iiqaEmail")
	public String sendIiqaEmail(@RequestPart Tracking tracking) {
		String status1 = null;
		trackingService.authorizedInfo(tracking);
		status1 = trackingService.sendIiqaEmail(tracking);
		return status1;

	}

}
