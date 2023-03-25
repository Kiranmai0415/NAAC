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

import com.adiverse.erp.model.OnlineorF2FFDPMain;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.OnlineF2FFDPService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class OnlineF2FFDPController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OnlineF2FFDPService onlineF2FFDPService;

	@PostMapping(value = "/onlineF2FFDPData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> facultyAwards(
			@RequestPart(name = "onlineF2FFDPobj") OnlineorF2FFDPMain onlineF2FFDPobj,
			@RequestPart(name = "onlineF2FFDPFiles",required = false) MultipartFile[] onlineF2FFDPFiles) {

		String message = "";
		try {
			onlineF2FFDPService.onlineF2FFDPInfo(onlineF2FFDPobj, onlineF2FFDPFiles);

			message = "Uploaded the file successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallOnlineF2FFDPdata")
	public ResponseEntity<List<OnlineorF2FFDPMain>> getCriteria1ListFiles() {
		List<OnlineorF2FFDPMain> files = onlineF2FFDPService.getAllOnlineF2FFDPData();

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

}
