package com.vaibhav.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseDto {

	private String firstName;
	private String lastName;
	private String email;
	private Long contact;
	private String dob;
	private String gender;
}
