package com.ci.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.service.UserService;

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
			return "Please check your mail to recover your password";
		} else {
			return "Invalid Email Id";
		}
	}
}
