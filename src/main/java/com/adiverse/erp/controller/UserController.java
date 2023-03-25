package com.adiverse.erp.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.adiverse.erp.model.User;
import com.adiverse.erp.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	
	
//	@Autowired
//	private TrackingService trackingService;
	
	@GetMapping("/getalluserdata")
	public ResponseEntity<List<User>> getuserListFiles() {
		
		
		List<User> files = userService.getAllUserRecords();

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

}
