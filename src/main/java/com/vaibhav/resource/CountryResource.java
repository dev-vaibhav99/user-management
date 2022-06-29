package com.vaibhav.resource;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.service.CountryService;

@RestController
@RequestMapping("/country")
@CrossOrigin(origins = "http://localhost:4200")

public class CountryResource {

	@Autowired
	CountryService countryService;
	
	@GetMapping("/getAllCountries")
	public Map<Long, String> getAllCountries(){
		return countryService.getAllCountries();
	}
}
