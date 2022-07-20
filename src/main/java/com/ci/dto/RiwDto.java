package com.ci.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiwDto {

	private Long id;
	private Long caseId;
	private String firstName;
	private String lastName;
	private String highestQualification;
	private Long completedYear;
	private String grade;
}