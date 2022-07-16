package com.ci.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ci.dto.ApplicantResponseDto;
import com.ci.dto.ApplicationDto;
import com.ci.dto.LoginDto;
import com.ci.dto.UpdatePassword;
import com.ci.dto.UserResponseDto;
import com.ci.entity.Users;

@Service
public interface UserService {

	public ResponseEntity<UserResponseDto> userLogin(LoginDto login);

	public ResponseEntity<UserResponseDto> registerUser(UserResponseDto registration);

	public Boolean forgotPassword(String email);
	
	public String readEmailToUnlockAccount(Users users);
	
	public String readEmailToForgotPassword(Users users);
	
	public String generateRandomPassword(int length);

	public ResponseEntity<List<UserResponseDto>> getAllUsers();

	public ResponseEntity<String> deleteUserById(Long id);

	public ResponseEntity<ApplicationDto> registerApplication(ApplicationDto applicationDto);

	public ResponseEntity<ApplicationDto> getApplicationById(Long id);

	public ResponseEntity<List<ApplicationDto>> getAllApplications();

	public ResponseEntity<ApplicationDto> updateApplication(ApplicationDto applicationRegistrationDto);

	public ResponseEntity<String> deleteApplicationById(Long id);

	public ResponseEntity<UserResponseDto> getUserById(Long id);

	public ResponseEntity<UserResponseDto> updateUser(ApplicantResponseDto userResponseDto);

	public boolean findByEmail(String email);

	public ResponseEntity<UpdatePassword> updatePassword(UpdatePassword updatePassword);
}
