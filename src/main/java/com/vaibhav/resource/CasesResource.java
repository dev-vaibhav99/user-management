package com.vaibhav.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.dto.UserResponseDto;
import com.vaibhav.entity.Cases;
import com.vaibhav.service.CaseService;

@RestController
@RequestMapping("/cases")
public class CasesResource {

	@Autowired
	private CaseService caseService ;
	
	@PostMapping("/create")
	public Cases createCase(@RequestBody UserResponseDto usersDto) {
		return caseService.createCase(usersDto);
//		return null;
	}
}
