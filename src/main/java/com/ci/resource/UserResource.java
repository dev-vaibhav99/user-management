package com.ci.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ci.dto.ApplicantResponseDto;
import com.ci.dto.ApplicationDto;
import com.ci.dto.LoginDto;
import com.ci.dto.UpdatePassword;
import com.ci.dto.UserResponseDto;
import com.ci.exceptions.EmailAlreadyException;
import com.ci.exceptions.PasswordDoesNotMatchException;
import com.ci.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserResource {

	@Autowired
	private UserService userService;
	
//	@Autowired
//	private UserUtils userUtils;
	
	// For Employees
	@PostMapping("/login")
	public ResponseEntity<UserResponseDto> userLogin(@RequestBody LoginDto login) {
		return userService.userLogin(login);
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserResponseDto registration) {
//		userUtils.setData(registration);
		if(alreadyRegisteredEmail(registration.getEmail()))
			throw new EmailAlreadyException();
		
		else
			return userService.registerUser(registration); 
	}
		
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserResponseDto>> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<UserResponseDto> updateUser(@RequestBody ApplicantResponseDto userResponseDto) {
		return userService.updateUser(userResponseDto);
	}
	
	@PutMapping("/updatePassword")
	public ResponseEntity<UpdatePassword> updatePassword(@RequestBody UpdatePassword updatePassword){
		if(!updatePassword.getPassword().equals(updatePassword.getConfirmPassword()))
			throw new PasswordDoesNotMatchException();
		return userService.updatePassword(updatePassword);
	}

	@DeleteMapping("deleteUser/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
		return userService.deleteUserById(id);
	}

	@PostMapping("/applicationRegistration")
	public ResponseEntity<ApplicationDto> registerApplication(@RequestBody ApplicationDto applicationDto) {
		if(alreadyRegisteredEmail(applicationDto.getEmail()))
			throw new EmailAlreadyException();
		else
			return userService.registerApplication(applicationDto);
	}

	private boolean alreadyRegisteredEmail(String email) {
		return userService.findByEmail(email);
	}

	@GetMapping("/getApplication/{id}")
	public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable Long id) {
		return userService.getApplicationById(id);
	}
	
	@GetMapping("/getByEmailAndPassword")
	public ResponseEntity<UserResponseDto> getByEmailAndPassword(@RequestParam String email, @RequestParam String password){
		return userService.getByEmailAndPassword(email, password);
	}

	@GetMapping("/getAllApplications")
	public ResponseEntity<List<ApplicationDto>> getAllApplications() {
		return userService.getAllApplications();
	}

	@PutMapping("/updateApplication")
	public ResponseEntity<ApplicationDto> updateApplication(
			@RequestBody ApplicationDto applicationRegistrationDto) {
		return userService.updateApplication(applicationRegistrationDto);
	}
	
	@DeleteMapping("/deleteApplication/{id}")
	public ResponseEntity<String> deleteApplicationById(@PathVariable Long id) {
		return userService.deleteApplicationById(id);
	}
}
