package com.ci.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ci.dto.ApplicationDto;
import com.ci.dto.CaseDto;
import com.ci.entity.Cases;

@Service
public interface CaseService {
	
	List<Cases> getAllCases();
	
	CaseDto createCase(ApplicationDto dto);
	
	CaseDto getCaseById(Long id);
}
