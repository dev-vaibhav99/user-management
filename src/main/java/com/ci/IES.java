package com.ci;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ci.entity.Users;

@SpringBootApplication
public class IES {

	public static void main(String[] args) {
		SpringApplication.run(IES.class, args);
		Users user1 = new Users(1L,"Rahul", "C", "rahul@gmail.com", "pazzzword", "pazzzword", null, 667733828L, 9989876765L, "Admin", new Date(), "male",1L, 1L, 1L,"UNLOCKED"); 
		Users user2 = new Users(2L,"Santosh", "Turerao", "santosh@gmail.com", "pwd", "pwd", null, 223384656L, 8776767898L, "Admin", new Date(), "male",1L, 1L, 2L,"UNLOCKED"); 
		Users user3 = new Users(3L,"Raj", "S", "raj@gmail.com", "passs", "passs", null, 547653989L, 8927876576L, "Caseworker", new Date(), "male",1L, 2L, 1L,"UNLOCKED"); 
		Users user4 = new Users(4L,"Milind", "Turerao", "milind@gmail.com", "pazzwd", "pazzwd", null, 9887898677L, 9284616976L, "Caseworker", new Date(), "male",2L, 2L, 1L,"UNLOCKED"); 
		Users user5 = new Users(5L,"Prajkta", "C", "prajkta@gmail.com", "pwdd", "pwdd", null, 846374629L, 8987876453L, "Caseworker", new Date(), "female",1L, 2L, 2L,"UNLOCKED"); 
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		System.out.println(user4);
		System.out.println(user5);
	}
}