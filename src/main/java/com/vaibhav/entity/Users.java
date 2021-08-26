package com.vaibhav.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private Long contact;
	private String dob;
	private String gender;
	private Long countryId;
	private Long stateId;
	private Long cityId;
	private String createdBy;
	private Date createdOn;
	private Date updatedOn;
	private String updatedBy;
	private String accountStatus;
}
