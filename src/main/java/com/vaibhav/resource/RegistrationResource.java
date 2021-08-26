package com.vaibhav.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.dto.RegistrationDto;
import com.vaibhav.service.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationResource {

	@Autowired
	UserService service;
	
	@PostMapping("/save")
	public String registerUser(@RequestBody RegistrationDto registration) {
		return service.registerUser(registration); 
	}
}
