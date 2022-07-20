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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plans {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String planName;
	private String planDescription;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date planStartDate;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date planEndDate;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Cases cases; 
}
