package com.vaibhav.service;

import org.springframework.stereotype.Service;

import com.vaibhav.bindings.PlanInfo;
import com.vaibhav.bindings.UserInfo;

@Service
public interface IRuleService {

	public PlanInfo executeRules(UserInfo userInfo);
}
