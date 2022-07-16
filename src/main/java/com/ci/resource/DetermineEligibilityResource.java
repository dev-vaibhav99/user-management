package com.ci.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ci.bindings.PlanInfo;
import com.ci.bindings.UserInfo;
import com.ci.service.DetermineEligibilityService;

@RestController
@CrossOrigin("*")
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
