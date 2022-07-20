package com.ci.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QhpDto {
	
	private Long id;
	private Long caseId;
	private String firstName;
	private String lastName;
	private Long income;

}
