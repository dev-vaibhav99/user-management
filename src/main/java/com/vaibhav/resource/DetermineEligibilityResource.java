package com.vaibhav.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.bindings.PlanInfo;
import com.vaibhav.bindings.UserInfo;
import com.vaibhav.service.DetermineEligibilityService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class DetermineEligibilityResource {
	
	@Autowired
	private DetermineEligibilityService eligService;
	
	@PostMapping(
			value = "/rules", 
			produces = { "application/xml", "application/json" },
			consumes= {"application/xml", "application/json"}
		)
		public PlanInfo checkPlanEligibility(@RequestBody UserInfo userInfo) {
			PlanInfo planInfo = eligService.determineEligibility(userInfo);
			return planInfo;
		}
}
