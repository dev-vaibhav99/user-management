package com.ci;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ci.entity.Users;
import com.ci.repo.UserRepo;

@SpringBootApplication
public class IES {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(IES.class, args);
		List<Users> users = Arrays.asList(
				new Users(1L,"Rahul", "C", "rahul@gmail.com", "pazzzword", "pazzzword", null, 667733828L, 9989876765L, "Admin", new Date(), "male",1L, 1L, 1L,"UNLOCKED"),
				new Users(2L,"Santosh", "Turerao", "santosh@gmail.com", "pwd", "pwd", null, 223384656L, 8776767898L, "Admin", new Date(), "male",1L, 1L, 2L,"UNLOCKED"),
				new Users(3L,"Raj", "S", "raj@gmail.com", "passs", "passs", null, 547653989L, 8927876576L, "Caseworker", new Date(), "male",1L, 2L, 1L,"UNLOCKED"),
				new Users(4L,"Milind", "Turerao", "milind@gmail.com", "pazzwd", "pazzwd", null, 9887898677L, 9284616976L, "Caseworker", new Date(), "male",2L, 2L, 1L,"UNLOCKED"),
				new Users(5L,"Prajkta", "C", "prajkta@gmail.com", "pwdd", "pwdd", null, 846374629L, 8987876453L, "Caseworker", new Date(), "female",1L, 2L, 2L,"UNLOCKED"));
		
		UserRepo userRepo = run.getBean(UserRepo.class);
		userRepo.saveAll(users);
		userRepo.flush();
	}
}