package com.ci.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private String tempPwd;
	private Long ssnNo;
	private Long contact;
	private String role;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	private String gender;
	private Long countryId;
	private Long stateId;
	private Long cityId;
//	private String createdBy;
//	private Date createdOn;
//	private Date updatedOn;
//	private String updatedBy;
	private String accountStatus;

}
