package com.adiverse.erp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.adiverse.erp.model.TeachingPedagology;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.TeachingPedagologyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class TeachingPedagologyController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TeachingPedagologyService teachingPedagologyService;

	@PostMapping(value = "/pedagologydata")
	public ResponseEntity<MessageResponse> Quality(@RequestPart TeachingPedagology pedagologyobj) {

		String message = "";
		try {
			teachingPedagologyService.pedagologyInfo(pedagologyobj);

			message = "EXTENDED Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the EXTENDED Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallpedagologydata")
	public ResponseEntity<List<TeachingPedagology>> getExtendedtotalData() {
		List<TeachingPedagology> qualityList = teachingPedagologyService.getAllPedagologyData();

		return ResponseEntity.status(HttpStatus.OK).body(qualityList);
	}

}
