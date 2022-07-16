package com.ci.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.dto.UserResponseDto;
import com.ci.entity.Cases;
import com.ci.service.CaseService;

@RestController
@RequestMapping("/cases")
@CrossOrigin("*")
public class CasesResource {

	@Autowired
	private CaseService caseService ;
	
	@PostMapping("/create")
	public Cases createCase(@RequestBody UserResponseDto usersDto) {
		return caseService.createCase(usersDto);
//		return null;
	}
}
