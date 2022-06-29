package com.vaibhav.bindings;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Component
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserInfo {

	private String indvFirstName;
	private String indvLastName;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date indvDob;
	private String planName;
	private String isEmployed;

	private PlanInfo planInfo;
}
