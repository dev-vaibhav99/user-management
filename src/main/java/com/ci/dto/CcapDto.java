package com.ci.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CcapDto {
	
	private Long id;
	private Long caseId;
	private String firstName;
	private String lastName;
	private String childName;
	private String childGender;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date childDob;
	private Long childSsnNo;
}
