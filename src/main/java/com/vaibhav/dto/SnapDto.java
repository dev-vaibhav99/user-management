package com.vaibhav.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnapDto {
	
	private Long caseID;
	private String firstName;
	private String lastName;
	private Long income;
	private Long otherIncome; 

}
