package com.vaibhav.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.entity.Countries;
import com.vaibhav.repo.CountryRepo;

@Service
public class CountryService {

	@Autowired
	CountryRepo countryRepo;

	public Map<Long, String> getAllCountries() {
		List<Countries> findAll = countryRepo.findAll();
		Map<Long, String> countryMap = new HashMap<>();

		findAll.forEach(country -> {
			countryMap.put(country.getId(), country.getCountryName());
		});
		return countryMap;
	}

}
