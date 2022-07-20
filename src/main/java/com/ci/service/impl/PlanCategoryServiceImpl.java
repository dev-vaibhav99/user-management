package com.ci.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.entity.PlanCategory;
import com.ci.repo.PlanCategoryRepo;
import com.ci.service.PlanCategoryService;

@Service
public class PlanCategoryServiceImpl implements PlanCategoryService{

	@Autowired
	private PlanCategoryRepo planCategoryRepo;
	
	@Override
	public Map<Long, String> getAllPlanCategories() {
		 List<PlanCategory> allPlanCategories = planCategoryRepo.findAll();
		 Map<Long, String> planMap = new HashMap<Long, String>();
		 
		 allPlanCategories.forEach(planCategory -> {
			 planMap.put(planCategory.getId(), planCategory.getPlanName());
		 });
		 return planMap;
	}

}
