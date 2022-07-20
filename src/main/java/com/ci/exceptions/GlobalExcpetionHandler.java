package com.ci.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExcpetionHandler {

	@ExceptionHandler(value = { PlanNotFoundException.class, UserNotFoundException.class, NullObjectException.class,
			NullPointerException.class, ApplicationNotFoundException.class, EmailAlreadyException.class,
			PlanAlreadyRegistered.class, PasswordDoesNotMatchException.class, CaseNotFoundException.class })
	public ResponseEntity<ExceptionResponseDto> handlerExceptionHandler(Exception ex, WebRequest request)
			throws Exception {

		if (ex instanceof PlanNotFoundException) {
			System.out.println();
			return new ResponseEntity<ExceptionResponseDto>(new ExceptionResponseDto(HttpStatus.BAD_REQUEST.value(),
					HttpStatus.BAD_REQUEST, "PLAN NOT AVAILABLE", new Date()), HttpStatus.BAD_REQUEST);
		}

		else if (ex instanceof UserNotFoundException) {
			return new ResponseEntity<ExceptionResponseDto>(new ExceptionResponseDto(HttpStatus.BAD_REQUEST.value(),
					HttpStatus.BAD_REQUEST, "USER NOT AVAILABLE", new Date()), HttpStatus.BAD_REQUEST);
		}

		else if (ex instanceof NullObjectException) {
			return new ResponseEntity<ExceptionResponseDto>(new ExceptionResponseDto(HttpStatus.BAD_REQUEST.value(),
					HttpStatus.BAD_REQUEST, "NULL OBJECT FOUND", new Date()), HttpStatus.BAD_REQUEST);
		}

		else if (ex instanceof UserNotFoundException) {
			return new ResponseEntity<ExceptionResponseDto>(new ExceptionResponseDto(HttpStatus.BAD_REQUEST.value(),
					HttpStatus.BAD_REQUEST, "USER NOT AVAILABLE", new Date()), HttpStatus.BAD_REQUEST);
		}

		else if (ex instanceof ApplicationNotFoundException) {
			return new ResponseEntity<ExceptionResponseDto>(new ExceptionResponseDto(HttpStatus.BAD_REQUEST.value(),
					HttpStatus.BAD_REQUEST, "APPLICANT NOT AVAILABLE", new Date()), HttpStatus.BAD_REQUEST);
		}

		else if (ex instanceof EmailAlreadyException) {
			return new ResponseEntity<ExceptionResponseDto>(new ExceptionResponseDto(HttpStatus.CONFLICT.value(),
					HttpStatus.CONFLICT, "THIS EMAIL IS ALREADY REGISTERED", new Date()), HttpStatus.CONFLICT);
		}
		
		else if (ex instanceof PlanAlreadyRegistered) {
			return new ResponseEntity<ExceptionResponseDto>(new ExceptionResponseDto(HttpStatus.CONFLICT.value(),
					HttpStatus.CONFLICT, "THIS PLAN IS ALREADY REGISTERED", new Date()), HttpStatus.CONFLICT);
		}
		
		else if(ex instanceof PasswordDoesNotMatchException) {
			return new ResponseEntity<ExceptionResponseDto>(new ExceptionResponseDto(HttpStatus.BAD_REQUEST.value(),
					HttpStatus.BAD_REQUEST, "PASSWORDS DOES NOT MATCH", new Date()), HttpStatus.BAD_REQUEST);
		}
		
		else if(ex instanceof CaseNotFoundException) {
			return new ResponseEntity<ExceptionResponseDto>(new ExceptionResponseDto(HttpStatus.BAD_REQUEST.value(),
					HttpStatus.BAD_REQUEST, "CASE NOT AVAILABLE", new Date()), HttpStatus.BAD_REQUEST);
		}
		
		else {
			throw ex;
		}
	}
}