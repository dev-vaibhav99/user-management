package com.ci.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ci.dto.ApplicantResponseDto;
import com.ci.dto.ApplicationDto;
import com.ci.dto.LoginDto;
import com.ci.dto.UpdatePassword;
import com.ci.dto.UserResponseDto;
import com.ci.entity.Users;
import com.ci.exceptions.ApplicationNotFoundException;
import com.ci.exceptions.UserNotFoundException;
import com.ci.props.AppProperties;
import com.ci.repo.UserRepo;
import com.ci.service.UserService;
import com.ci.utils.EmailUtils;
import com.ci.utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	public static final String CHAR_SEQ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepo repo;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private UserUtils userUtils;

	private ModelMapper mapper;

	@Autowired
	private AppProperties appProps;

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
			// userUtils.setData(userResponseDto);
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
		String subject = "IES : Registration Successful";
		String body = readEmailToUnlockAccount(registeredUser);
		emailUtils.sendEmail(to, subject, body);

		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(registeredUser, UserResponseDto.class));
	}

	@Override
	public Boolean forgotPassword(String email) {
		Users entity = new Users();
		entity.setEmail(email);
		Example<Users> example = Example.of(entity);
		Optional<Users> findOne = repo.findOne(example);

		if (findOne.isPresent()) {
			Users user = findOne.get();
			String body = readEmailToForgotPassword(user);
			String subject = "IES : Password Recovery";
			try {
				emailUtils.sendEmail(email, subject, body);
			} catch (Exception e) {
				logger.error("Exception occured due to: " + e.getMessage());
			}
			return true;
		} else {
			return false;
		}
	}
	

	@Override
	public String readEmailToForgotPassword(Users entity) {
		StringBuilder sb = new StringBuilder("");
		String mailBody = "";
		String fileName = "RECOVER-PASSWORD.txt";
		try (InputStream in = getClass().getResourceAsStream("/" + fileName);
				BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			br.close();
			mailBody = sb.toString();
			mailBody = mailBody.replace("{firstName}", entity.getFirstName());
			mailBody = mailBody.replace("{pwd}", entity.getPassword());
		} catch (Exception e) {
			logger.error("Error occured during file reading, due to " + e.getMessage(), e);
		}
		return mailBody;
	}

	@Override
	public String readEmailToUnlockAccount(Users entity) {
		StringBuilder sb = new StringBuilder("");
		String mailBody = "";
		String fileName = "UNLOCK-EMAIL.txt";
		try (InputStream in = getClass().getResourceAsStream("/" + fileName);
				BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			br.close();

//			String pazzword = entity.getPassword();
//			String decryptedPwd = PwdUtils.decryptMsg(pazzword);

			mailBody = sb.toString();
			mailBody = mailBody.replace("{firstName}", entity.getFirstName());
			mailBody = mailBody.replace("{email}", entity.getEmail());
			mailBody = mailBody.replace("{temp-pwd}", entity.getTempPwd());
		} catch (Exception e) {
			logger.error("Error occured during file reading, due to " + e.getMessage(), e);
		}
		return mailBody;

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
		if (!foundApplication.isPresent())
			throw new ApplicationNotFoundException();
		return ResponseEntity.ok().body(mapper.map(foundApplication.get(), ApplicationDto.class));
	}

	@Override
	public ResponseEntity<List<ApplicationDto>> getAllApplications() {
		mapper = new ModelMapper();
		List<Users> allApplications = repo.findAll();
		List<ApplicationDto> applications = new ArrayList<>();
		if (allApplications.size() <= 0)
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
		if (!repo.findById(id).isPresent())
			throw new ApplicationNotFoundException();
		else {
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
		if (byEmail != null)
			isAlreadyPresent = true;
		return isAlreadyPresent;
	}

	@Override
	public ResponseEntity<UpdatePassword> updatePassword(UpdatePassword updatePassword) {
		mapper = new ModelMapper();
		Users findByTempPwd = repo.findByTempPwd(updatePassword.getTempPwd());

		if (findByTempPwd != null && updatePassword.getTempPwd().equals(findByTempPwd.getTempPwd())) {
			Users entity = mapper.map(updatePassword, Users.class);
			return ResponseEntity.status(HttpStatus.OK).body(mapper.map(repo.save(entity), UpdatePassword.class));
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}
