package com.vaibhav.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.service.UserService;

@RestController
@RequestMapping("/forgot")
@CrossOrigin(origins = "http://localhost:4200")

public class ForgotPasswordResource {

	@Autowired
	private UserService userService;
	
	@GetMapping("/password/{email}")
	public String forgotPassword(@PathVariable("email") String email) {
		Boolean forgotPassword = userService.forgotPassword(email);
		if(forgotPassword) {
			return "Successfully sent email to your Email Id";
		} else {
			return "Invalid Email Id";
		}
	}
}
