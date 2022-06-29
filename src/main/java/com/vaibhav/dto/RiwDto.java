package com.vaibhav.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiwDto {

	private Long caseID;
	private String firstName;
	private String lastName;
	private String highestQualification;
	private Long completedYear;
	private String grade;
}