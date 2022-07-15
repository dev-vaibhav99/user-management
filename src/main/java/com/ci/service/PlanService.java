package com.ci.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ci.dto.PlansDto;
import com.ci.entity.Plans;

@Service
public interface PlanService {

	public ResponseEntity<PlansDto> registerPlan(PlansDto plansDto);

	public ResponseEntity<List<Plans>> getAllPlans();

	public ResponseEntity<?> deletePlanById(Long id);

	public ResponseEntity<PlansDto> getPlanById(Long id);

	public ResponseEntity<PlansDto> updatePlan(PlansDto plansDto);

	public boolean planAlreadyRegistered(PlansDto plansDto);
}
