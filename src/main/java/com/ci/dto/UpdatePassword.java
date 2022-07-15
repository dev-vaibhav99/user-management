package com.ci.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePassword {

	private Long id;
	private String password;
	private String tempPwd;
	private String confirmPassword;
}
