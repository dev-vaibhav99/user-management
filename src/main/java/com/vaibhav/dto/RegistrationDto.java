package com.vaibhav.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
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
}
