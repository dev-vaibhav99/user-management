package com.ci.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseDto {

	private Long id;
	
	private Long arId;
	private String firstName;
	private String lastName;
	private String email;
	private Long contact;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dob;
	private String gender;
	
//	private Set<Plans> plans;
}
