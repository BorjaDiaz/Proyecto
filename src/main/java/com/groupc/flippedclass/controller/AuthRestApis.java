package com.groupc.flippedclass.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupc.flippedclass.message.request.LoginForm;
import com.groupc.flippedclass.message.request.SignUpForm;
import com.groupc.flippedclass.services.AuthService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestApis {
	
	static Logger log = Logger.getLogger(AuthRestApis.class.getName());
	
	@Autowired
	AuthService authService;
  
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
    	log.info("En authenticateUser");
		log.debug(loginRequest.getUsername());
    	return authService.AuthenticateUser(loginRequest);
    }
   
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signupRequest) {
    	log.info("En registerUser");
		log.debug(signupRequest);
    	return authService.registerUser(signupRequest);
    }
}