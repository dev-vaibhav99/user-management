package com.ci.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class ApplicantResponseDto {

	private String msg;
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Long contact;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dob;
	private String gender;
	private String password;
	private Long ssnNo;
	
	public ApplicantResponseDto(String msg){
		this.msg = msg;
	}
	
}
