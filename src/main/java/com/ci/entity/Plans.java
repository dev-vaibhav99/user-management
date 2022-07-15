package com.ci.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Plans {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String planName;
	private String planDescription;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date planStartDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date planEndDate;
	
}
