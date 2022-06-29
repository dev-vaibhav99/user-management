package com.vaibhav.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long>{
	public Users findByEmail(String email);
	public Users findByEmailAndPassword(String email, String password);
	public Users findByTempPwd(String tempPwd);
	
	public Users findByFirstName(String firstName);
}
