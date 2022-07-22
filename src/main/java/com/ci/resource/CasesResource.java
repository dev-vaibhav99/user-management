package com.ci.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.dto.ApplicationDto;
import com.ci.dto.CaseDto;
import com.ci.entity.Cases;
import com.ci.service.CaseService;

@RestController
@RequestMapping("/cases")
@CrossOrigin(origins = "*")
public class CasesResource {

	@Autowired
	private CaseService caseService;

	@PostMapping("/create")
	public ResponseEntity<CaseDto> createCase(@RequestBody ApplicationDto dto) {
		return new ResponseEntity<CaseDto>(caseService.createCase(dto), HttpStatus.OK);
	}

	@GetMapping("/getAllCases")
	public ResponseEntity<List<Cases>> getAllCases() {
		return new ResponseEntity<List<Cases>>(caseService.getAllCases(), HttpStatus.OK);
	}

	@GetMapping("/getCaseById/{id}")
	public ResponseEntity<CaseDto> getCaseById(@PathVariable Long id) {
		return new ResponseEntity<CaseDto>(caseService.getCaseById(id), HttpStatus.OK);
	}
}
