package com.vaibhav.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.dto.LoginDto;
import com.vaibhav.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginResource {
	
	@Autowired
	UserService service;

	@PostMapping("/login")
	public String userLogin(@RequestBody LoginDto login) {
		return service.userLogin(login);
	}
}