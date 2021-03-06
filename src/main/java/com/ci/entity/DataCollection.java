
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

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class DataCollection {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long caseId;
	private String firstName;
	private String lastName;
	
	//SNAP
	private Long income;
	private Long otherIncome;
	
	//CCAP
	private String childName;
	private String childGender;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date childDOB;
	private Long childSsnNo;
	
	//RIW
	private String highestQualification;
	private Long completedYear;
	private String grade;
	
}
