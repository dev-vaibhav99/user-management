package com.ci.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ci.dto.PlansDto;
import com.ci.entity.PlanCategory;
import com.ci.entity.Plans;
import com.ci.exceptions.PlanNotFoundException;
import com.ci.repo.PlanCategoryRepo;
import com.ci.repo.PlanRepo;
import com.ci.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired(required = false)
	private PlanRepo planRepo;

	@Autowired
	private PlanCategoryRepo planCategoryRepo;

	@Autowired
	public ModelMapper mapper;

	@Override
	public ResponseEntity<PlansDto> registerPlan(PlansDto plansDto) {
		Plans planEntity = null;
		PlansDto mapped = null;
		try {
			planEntity = mapper.map(plansDto, Plans.class);
			Plans registeredPlan = planRepo.save(planEntity);
			PlanCategory planCategory = new PlanCategory(registeredPlan.getId(), registeredPlan.getPlanName());
			planCategoryRepo.save(planCategory);
			mapped = mapper.map(registeredPlan, PlansDto.class);
			return ResponseEntity.ok().body(mapped);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@Override
	public ResponseEntity<List<Plans>> getAllPlans() {
		List<Plans> allPlans = planRepo.findAll();
		if (allPlans.size() <= 0)
			throw new PlanNotFoundException();
		else
			return ResponseEntity.of(Optional.of(allPlans));
	}

	@Override
	public ResponseEntity<?> deletePlanById(Long id) {
		if (!planRepo.findById(id).isPresent()) {
			throw new PlanNotFoundException();
		} else {
			planRepo.deleteById(id);
			planCategoryRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("PLAN DELETED SUCCESSFULLY");
		}
	}

	@Override
	public ResponseEntity<PlansDto> getPlanById(Long id) {
		Optional<Plans> found = planRepo.findById(id);
		if (!found.isPresent()) {
			throw new PlanNotFoundException();
		}
		PlansDto foundPlan = mapper.map(found.get(), PlansDto.class);
		return ResponseEntity.ok().body(foundPlan);
	}

	@Override
	public ResponseEntity<PlansDto> updatePlan(PlansDto plansDto) {
		Plans entity = mapper.map(plansDto, Plans.class);
		Plans updated = planRepo.save(entity);
		PlansDto updatedPlan = mapper.map(updated, PlansDto.class);
		if (!updatedPlan.equals(null))
			return ResponseEntity.ok().body(updatedPlan);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	

	@Override
	public boolean planAlreadyRegistered(PlansDto plansDto) {
		List<Plans> allPlans = planRepo.findAll();
		List<PlansDto> dtoList = new ArrayList<>();
		for (int i = 0; i < allPlans.size(); i++) {
			dtoList.add(mapper.map(allPlans.get(i), PlansDto.class));
		}
		for (PlansDto dto : dtoList) {
			if (dto.getPlanName().equals(plansDto.getPlanName()))
				return true;
		}

		return false;
	}

}
