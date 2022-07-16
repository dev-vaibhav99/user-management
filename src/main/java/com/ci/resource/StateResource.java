package com.ci.resource;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.service.StateService;

@RestController
@RequestMapping("/state")
@CrossOrigin(origins = "*")
public class StateResource {

	@Autowired
	StateService stateService;
	
	@GetMapping("/getAllStatesByCountryId/{countryId}")
	public Map<Long, String> getStates(@PathVariable("countryId") Long countryId){
		return stateService.getStates(countryId);
	}
}
