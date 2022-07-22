package com.ci.resource;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.service.CityService;

@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "*")
public class CityResource {
	@Autowired
	CityService cityService;
	
	@GetMapping("/getAllCitiesByStateId/{stateId}")
	public Map<Long, String> getCities(@PathVariable("stateId") Long stateId){
		return cityService.getCities(stateId);
	}
}
