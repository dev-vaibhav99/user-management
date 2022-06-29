package com.vaibhav.bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Component
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class PlanInfo {

	private String planName;
	private String planStatus;
	private String planStartDate;
	private String planEndDate;
	private String benefitAmt;
	private String denialReason;
}
