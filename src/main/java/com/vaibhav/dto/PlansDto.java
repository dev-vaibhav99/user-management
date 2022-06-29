package com.vaibhav.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PlansDto {

	private Long id;
	private String planName;
	private String planDescription;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date planStartDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date planEndDate;
	
}
