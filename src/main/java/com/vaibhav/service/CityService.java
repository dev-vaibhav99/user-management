package com.vaibhav.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.entity.Cities;
import com.vaibhav.repo.CityRepo;

@Service
public class CityService {

	@Autowired
	CityRepo cityRepo;

	public Map<Long, String> getCities(Long stateId) {
		Map<Long, String> cityMap = new HashMap<Long, String>();
		List<Cities> findByStateId = cityRepo.findByStateId(stateId);
		findByStateId.forEach(city -> {
			cityMap.put(city.getId(), city.getCityName());
		});
		return cityMap;
	}
	
	
}
