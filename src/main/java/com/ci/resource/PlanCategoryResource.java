package com.ci.resource;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.service.PlanCategoryService;

@RestController
@RequestMapping("/planCategory")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanCategoryResource {

	@Autowired
	PlanCategoryService planCategoryService;
	
	@GetMapping("/getAllPlanCategories")
	public Map<Long, String> getAllPlanCategories(){
		return planCategoryService.getAllPlanCategories();
	}
	
}
