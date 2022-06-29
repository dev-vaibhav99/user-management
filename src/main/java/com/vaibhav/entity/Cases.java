package com.vaibhav.entity;

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

public class Cases {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long aadharNo;
	private Long contact;
	private String role;
	private String dob;
	private String gender;
	
	private String planName;
	private String planDescription;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date planStartDate;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date planEndDate;
	
}
