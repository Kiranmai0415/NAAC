package com.adiverse.erp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.QIAIndicator;
import com.adiverse.erp.model.User;
import com.adiverse.erp.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class UserService {

	private final Logger loggr = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUserRecords() {
		try {
			List<User> userRecords = new ArrayList<User>();

			userRepository.findAll().forEach(userRecords::add);

			return userRecords;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	public List<User>  mailInfo()
	{
		List<User> userInfo = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
	try {
        userInfo=	userRepository.userInfo();
		System.out.println("id ===>"+mapper.writeValueAsString(userInfo));
	} catch (Exception e) {
		e.printStackTrace();
	}
	return userInfo;
		
	}
    
}
