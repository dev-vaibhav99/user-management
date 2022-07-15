package com.ci.service;

import org.springframework.stereotype.Service;

import com.ci.bindings.PlanInfo;
import com.ci.bindings.UserInfo;

@Service
public interface IRuleService {

	public PlanInfo executeRules(UserInfo userInfo);
}
