package com.ci.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.dto.ApplicationDto;
import com.ci.dto.CaseDto;
import com.ci.entity.Cases;
import com.ci.exceptions.CaseNotFoundException;
import com.ci.exceptions.UserNotFoundException;
import com.ci.repo.CaseRepo;
import com.ci.repo.UserRepo;
import com.ci.service.CaseService;

@Service
public class CaseServiceImpl implements CaseService {

	@Autowired
	private CaseRepo caseRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Cases> getAllCases() {
		return caseRepo.findAll();
	}

	@Override
	public CaseDto createCase(ApplicationDto dto) {
		boolean existsById = userRepo.existsById(dto.getId());
		if (existsById) {
			Cases cases = mapper.map(dto, Cases.class);
			cases.setArId(dto.getId());
			Cases savedCase = caseRepo.save(cases);
			return mapper.map(savedCase, CaseDto.class);
		} else {
			throw new UserNotFoundException();
		}
	}

	@Override
	public CaseDto getCaseById(Long id) {
		boolean present = caseRepo.findById(id).isPresent();
		if (present) {
			return mapper.map(caseRepo.findById(id).get(), CaseDto.class);
		} else {
			throw new CaseNotFoundException();
		}
	}

}
