package com.ci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.dto.UserResponseDto;
import com.ci.entity.Cases;
import com.ci.repo.CaseRepo;
import com.ci.repo.UserRepo;

@Service
public class CaseService {
	
	@Autowired
	private CaseRepo caseRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
//	private PlanRepo planRepo;
	
	public Cases createCase(UserResponseDto usersDto) {
//		Users userByFirstName = userRepo.findByFirstName(usersDto.getFirstName());
////		Plans planByPlanName = planRepo.findPlanByPlanName(plansDto.getPlanName());
//		ModelMapper mapper = new ModelMapper();
//		Cases entity = mapper.map(userByFirstName, Cases.class);
////		entity = mapper.map(planByPlanName, Cases.class);
//		return caseRepo.save(entity);
		return null;
	}

}
