package com.vaibhav.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vaibhav.dto.ApplicantResponseDto;
import com.vaibhav.dto.ApplicationDto;
import com.vaibhav.dto.LoginDto;
import com.vaibhav.dto.UpdatePassword;
import com.vaibhav.dto.UserResponseDto;
import com.vaibhav.entity.Users;
import com.vaibhav.exceptions.ApplicationNotFoundException;
import com.vaibhav.exceptions.UserNotFoundException;
import com.vaibhav.repo.UserRepo;
import com.vaibhav.service.UserService;
import com.vaibhav.utils.EmailUtils;
import com.vaibhav.utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	public static final String CHAR_SEQ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";

	@Autowired
	UserRepo repo;

	@Autowired
	EmailUtils emailUtils;
	
	@Autowired
	UserUtils userUtils;

	private ModelMapper mapper;

	@Override
	public ResponseEntity<UserResponseDto> userLogin(LoginDto login) {
		mapper = new ModelMapper();
		if (login == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		String email = login.getEmail();
		String password = login.getPassword();
		UserResponseDto userResponseDto = new UserResponseDto();
		Users findByEmail = repo.findByEmailAndPassword(email, password);
		if (findByEmail != null) {
			userResponseDto = mapper.map(findByEmail, UserResponseDto.class);
		//	userUtils.setData(userResponseDto);
			return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
		} else
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}

	@Override
	public ResponseEntity<UserResponseDto> registerUser(UserResponseDto registration) {
		if (registration == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		mapper = new ModelMapper();
		Users registerToUsersObject = mapper.map(registration, Users.class);
		String tempPwd = generateRandomPassword(6);
		registerToUsersObject.setTempPwd(tempPwd);
		registerToUsersObject.setAccountStatus("LOCKED");

		Users registeredUser = repo.save(registerToUsersObject);

		String to = registeredUser.getEmail();
		String subject = "To Unlock Account";
		String body = readEmailToUnlockAccount(registeredUser);
		emailUtils.sendEmail(to, subject, body);

		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(registeredUser, UserResponseDto.class));
	}

	@Override
	public Boolean forgotPassword(String email) {
		boolean status = false;
		Users findByEmail = repo.findByEmail(email);
		if (findByEmail == null) {
			return status;
		} else {
			status = true;
			return status;
		}
	}

	@Override
	public String readEmailToUnlockAccount(Users users) {
		String emailBody = "";
		FileReader fileReader;
		StringBuffer buffer = new StringBuffer();
		try {
			String file = "UNLOCK-EMAIL.txt";
			fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = reader.readLine();
			while (line != null) {
				buffer.append(line);
				line = reader.readLine();
			}
			emailBody = buffer.toString();
			emailBody = emailBody.replace("{firstName}", users.getFirstName());
			emailBody = emailBody.replace("{email}", users.getEmail());
			emailBody = emailBody.replace("{temp-pwd}", users.getTempPwd());
			reader.close();
		} catch (Exception e) {
			System.out.println("Error occured during file reading, due to " + e.getMessage());
		}
		return emailBody;
	}

	@Override
	public String generateRandomPassword(int length) {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			buffer.append(CHAR_SEQ.charAt(random.nextInt(CHAR_SEQ.length())));
		}
		return buffer.toString();
	}

	@Override
	public ResponseEntity<List<UserResponseDto>> getAllUsers() {
		mapper = new ModelMapper();
		List<Users> findAll = repo.findAll();
		List<UserResponseDto> dtoList = new ArrayList<>();
		if (findAll.size() <= 0)
			throw new UserNotFoundException();
		for (Users users : findAll) {
			dtoList.add(mapper.map(users, UserResponseDto.class));
		}
		return ResponseEntity.of(Optional.of(dtoList));
	}

	@Override
	public ResponseEntity<UserResponseDto> updateUser(ApplicantResponseDto userResponseDto) {
		mapper = new ModelMapper();
		Users entity = mapper.map(userResponseDto, Users.class);
		Users updatedUser = repo.save(entity);
		return ResponseEntity.ok().body(mapper.map(updatedUser, UserResponseDto.class));
	}
	
	@Override
	public ResponseEntity<String> deleteUserById(Long id) {
		if (!repo.findById(id).isPresent())
			throw new UserNotFoundException();
		else {
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("USER DELETED SUCCESSFULLY");
		}
	}

	@Override
	public ResponseEntity<ApplicationDto> registerApplication(ApplicationDto applicationDto) {
		mapper = new ModelMapper();
		Users entity = mapper.map(applicationDto, Users.class);
		Users savedApplication = repo.save(entity);
		return ResponseEntity.ok().body(mapper.map(savedApplication, ApplicationDto.class));
	}

	@Override
	public ResponseEntity<ApplicationDto> getApplicationById(Long id) {
		mapper = new ModelMapper();
		Optional<Users> foundApplication = repo.findById(id);
		if(!foundApplication.isPresent())
			throw new ApplicationNotFoundException();
		return ResponseEntity.ok().body(mapper.map(foundApplication.get(), ApplicationDto.class));
	}

	@Override
	public ResponseEntity<List<ApplicationDto>> getAllApplications() {
		mapper = new ModelMapper();
		List<Users> allApplications = repo.findAll();
		List<ApplicationDto> applications = new ArrayList<>();
		if(allApplications.size()<=0)
			throw new ApplicationNotFoundException();
		for (Users users : allApplications) {
			applications.add(mapper.map(users, ApplicationDto.class));
		}
		return ResponseEntity.of(Optional.of(applications));
	}

	@Override
	public ResponseEntity<ApplicationDto> updateApplication(ApplicationDto applicationRegistrationDto) {
		mapper = new ModelMapper();
		Users applicationEntity = mapper.map(applicationRegistrationDto, Users.class);
		Users updatedApplication = repo.save(applicationEntity);
		return ResponseEntity.ok().body(mapper.map(updatedApplication, ApplicationDto.class));
	}

	@Override
	public ResponseEntity<String> deleteApplicationById(Long id) {
		if(!repo.findById(id).isPresent())
			throw new ApplicationNotFoundException();
		else{
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("APPLICANT DELETED SUCCESSFULLY");
		}
	}

	@Override
	public ResponseEntity<UserResponseDto> getUserById(Long id) {
		mapper = new ModelMapper();
		Optional<Users> foundUser = repo.findById(id);
		if (!foundUser.isPresent())
			throw new UserNotFoundException();
		return ResponseEntity.ok().body(mapper.map(foundUser.get(), UserResponseDto.class));
	}

	@Override
	public boolean findByEmail(String email) {
		boolean isAlreadyPresent = false;
		Users byEmail = repo.findByEmail(email);
		if(byEmail!=null)
			isAlreadyPresent = true;
		return isAlreadyPresent;
	}

	@Override
	public ResponseEntity<UpdatePassword> updatePassword(UpdatePassword updatePassword) {
		mapper = new ModelMapper();
		Users findByTempPwd = repo.findByTempPwd(updatePassword.getTempPwd());
		
		if (findByTempPwd!=null&&updatePassword.getTempPwd().equals(findByTempPwd.getTempPwd())) {			
			Users entity = mapper.map(updatePassword, Users.class);
			return ResponseEntity.status(HttpStatus.OK).body(mapper.map(repo.save(entity), UpdatePassword.class));
		}
		else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
