package com.vaibhav.dto;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vaibhav.entity.Users;

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
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	private String gender;
	private String password;
	private Long aadharNo;
	private List<Users> plans;
	
	public ApplicantResponseDto(String msg){
		this.msg = msg;
	}
	
}
