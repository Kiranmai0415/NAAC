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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import com.adiverse.erp.model.FeedbackForm_WB;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.FeedbackService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class FeedbackController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FeedbackService feedbackService;

	@PostMapping(value = "/feedbackdata",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Ssr(@RequestPart FeedbackForm_WB feedbackForm) {
System.out.println("feedbackdata");
		String message = "";
		try {
			feedbackService.feedbackInfo(feedbackForm);

			message = "Feedback Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Feedback Data: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}

	}

	@GetMapping("/getallfeedbackdata")
	public ResponseEntity<List<FeedbackForm_WB>> getFeedbacktotalData() {
		List<FeedbackForm_WB> feedback = feedbackService.getAllFeedbackData();

		return ResponseEntity.status(HttpStatus.OK).body(feedback);
	}

}
