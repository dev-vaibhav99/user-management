package com.ci.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.entity.States;
import com.ci.repo.StateRepo;

@Service
public class StateService {

	@Autowired
	StateRepo stateRepo;
	
	public Map<Long, String> getStates(Long countryId) {
		Map<Long, String> stateMap = new HashMap<>();
		List<States> findAllStates = stateRepo.findByCountryId(countryId);
		findAllStates.forEach(state -> {
			stateMap.put(state.getId(), state.getStateName());
		});
		return stateMap;
	}

}
