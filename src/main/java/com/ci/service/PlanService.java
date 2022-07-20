package com.ci.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ci.dto.PlansDto;
import com.ci.dto.SnapDto;
import com.ci.entity.Plans;

@Service
public interface PlanService {

	ResponseEntity<PlansDto> registerPlan(PlansDto plansDto);

	ResponseEntity<List<Plans>> getAllPlans();

	ResponseEntity<?> deletePlanById(Long id);

	ResponseEntity<PlansDto> getPlanById(Long id);

	ResponseEntity<PlansDto> updatePlan(PlansDto plansDto);

	boolean planAlreadyRegistered(PlansDto plansDto);
	
//	ResponseEntity<SnapDto> 
}
