package com.ci.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long ssnNo;
	private Long contact;
	private String role;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dob;
	private String gender;
}
