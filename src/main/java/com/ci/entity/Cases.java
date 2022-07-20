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

public class Cases {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long arId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long ssnNo;
	private Long contact;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dob;
	private String gender;

	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cases")
//	@JsonIgnore
//	private Set<Plans> plans;
}
