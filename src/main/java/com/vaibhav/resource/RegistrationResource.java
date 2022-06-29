package com.vaibhav.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.dto.UserResponseDto;
import com.vaibhav.service.UserService;

@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:4200")

public class RegistrationResource {

	@Autowired
	UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserResponseDto registration) {
		return service.registerUser(registration); 
	}
}
