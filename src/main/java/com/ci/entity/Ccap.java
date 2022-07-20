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
public class Ccap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long caseId;
	private String firstName;
	private String lastName;
	
	// ArrayList of following data
	private String childName;
	private String childGender;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date childDob;
	private Long childSsnNo;
}
