
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

import com.adiverse.erp.model.Qualitative;
import com.adiverse.erp.model.QualitativeQuantitativeInfo;
import com.adiverse.erp.model.QuantitativeData;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.QualitativeQuantitativeService;
import com.adiverse.erp.service.TrackingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class QualitativeQuantitativeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QualitativeQuantitativeService qualitativeQuantitave;

	@Autowired
	private TrackingService trackingService;

	@PostMapping(value = "/saveQualitativeQuantitaveData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> qualitativeQuantitative(
			@RequestPart QualitativeQuantitativeInfo qualitativeQuantitativeInfo) {
		System.out.println("data is ==>" + qualitativeQuantitativeInfo);
		String message = "";
		try {
			qualitativeQuantitave.saveQualityInfo(qualitativeQuantitativeInfo);

			message = "EXTENDED Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the EXTENDED Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@PostMapping(value = "/QualityReportData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> qualitativeQuantitative1(
			@RequestPart QualitativeQuantitativeInfo qualitativeQuantitativeInfo1,
			@RequestParam Map<String, String> allParams) {
		System.out.println("data is ==>" + qualitativeQuantitativeInfo1);
		String message = "";
		try {
			logger.info("allParams from principalAuthorizedEmail() ==>{}", allParams);
			String institutionType = allParams.get("institutionType");
			qualitativeQuantitave.saveQualityInfo(qualitativeQuantitativeInfo1);
			trackingService.sendQaAuthorizedEmail(institutionType);

			message = "EXTENDED Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the EXTENDED Data: ";
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@PostMapping(value = "/saveQualitativeData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Qualitative(@RequestPart Qualitative qualitativeInfo) {
		System.out.println("data is ==>" + qualitativeInfo);
		String message = "";
		try {
			qualitativeQuantitave.saveQualtitativeInfo(qualitativeInfo);

			message = "EXTENDED Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the EXTENDED Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@PostMapping(value = "/saveQuantitativeData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> QuantitativeData(@RequestPart QuantitativeData quanitativeInfo) {
		System.out.println("data is ==>" + quanitativeInfo);
		String message = "";
		try {
			qualitativeQuantitave.saveQuantitativeInfo(quanitativeInfo);

			message = "EXTENDED Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the EXTENDED Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallqualitativeQuantitaveData")
	public ResponseEntity<List<QualitativeQuantitativeInfo>> getExtendedtotalData() {
		List<QualitativeQuantitativeInfo> qualityList = qualitativeQuantitave.getAllPdfData();

		return ResponseEntity.status(HttpStatus.OK).body(qualityList);
	}

	@GetMapping("/getallqualitativeData")
	public ResponseEntity<List<Qualitative>> getQualData() {
		List<Qualitative> qualityList = qualitativeQuantitave.getAllQualitativedataData();

		return ResponseEntity.status(HttpStatus.OK).body(qualityList);
	}

	@GetMapping("/getallquanitativeData")
	public ResponseEntity<List<QuantitativeData>> getQuantData() {
		List<QuantitativeData> qualityList = qualitativeQuantitave.getAllQuantitativeInfo();

		return ResponseEntity.status(HttpStatus.OK).body(qualityList);
	}

//	@GetMapping("/getAllQualitativeAndQuantitaveData")
//	public ResponseEntity<List<?>> getAllQualitativeAndQuantitaveData() throws JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
//		List<?> qaAndQnList = qualitativeQuantitave.getAllQnAndQlData();
//		System.out.println("list of both obects are ==>" + mapper.writeValueAsString(qaAndQnList));
//		return ResponseEntity.status(HttpStatus.OK).body(qaAndQnList);
//	}

}
