package com.ci.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface PlanCategoryService {

	Map<Long, String> getAllPlanCategories();

	
}
