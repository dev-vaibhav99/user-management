package com.vaibhav.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.dto.PlansDto;
import com.vaibhav.entity.Plans;
import com.vaibhav.exceptions.PlanAlreadyRegistered;
import com.vaibhav.service.PlanService;

@RestController
@RequestMapping("/plan")
@CrossOrigin(origins = "http://localhost:4200")

public class PlanResource {

	@Autowired
	PlanService planService;

	@PostMapping("/register")
	public ResponseEntity<PlansDto> registerPlan(@RequestBody PlansDto plansDto) {
		if(isPlanAlreadyRegistered(plansDto))
			throw new PlanAlreadyRegistered();
		return planService.registerPlan(plansDto);
	}

	private boolean isPlanAlreadyRegistered(PlansDto plansDto) {
		return planService.planAlreadyRegistered(plansDto);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PlansDto> getPlanById(@PathVariable Long id) {
		return planService.getPlanById(id);
	}

	@GetMapping("/getAllPlans")
	public ResponseEntity<List<Plans>> getAllPlans() {
		return planService.getAllPlans();
	}

	@PutMapping("/update")
	public ResponseEntity<PlansDto> updatePlan(@RequestBody PlansDto plansDto) {
		return planService.updatePlan(plansDto);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePlanById(@PathVariable Long id) {
		return planService.deletePlanById(id);
	}

}
