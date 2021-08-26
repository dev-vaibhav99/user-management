package com.vaibhav.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaibhav.dto.LoginDto;
import com.vaibhav.dto.RegistrationDto;
import com.vaibhav.entity.Users;
import com.vaibhav.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo repo;

	public String userLogin(LoginDto login) {
		if (login == null)
			return "Fill the values !";
		String email = login.getEmail();
		Users findByEmail = repo.findByEmail(email);
		if (findByEmail != null)
			return "Welcome " + findByEmail.getFirstName();
		return "You are not an authorized user !";
	}

	public String registerUser(RegistrationDto registration) {
		if(registration == null)
			return "Enter the values properly";
		ModelMapper mapper = new ModelMapper();
		Users registerToUsersObject = mapper.map(registration, Users.class);		
		Users registeredUser = repo.save(registerToUsersObject);
		return "Welcome to the Patient Assitant, "+registeredUser.getFirstName();
	}

}
