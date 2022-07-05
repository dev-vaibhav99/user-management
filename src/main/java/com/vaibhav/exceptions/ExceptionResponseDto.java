package com.vaibhav.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionResponseDto {

	private int statusCode;
	private HttpStatus status;
	private String cause;
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date timeStamp;
}
