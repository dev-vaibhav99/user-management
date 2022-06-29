package com.vaibhav.service;

import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.vaibhav.bindings.PlanInfo;
import com.vaibhav.bindings.UserInfo;

@Service
public class DetermineEligibilityService {

	public PlanInfo determineEligibility(UserInfo userInfo) {
		String planName = userInfo.getPlanName();
		PlanInfo planInfo = null;

		try {
			String clzName = "com.vaibhav.service." + planName + "RulesExecutor";

			Class<?> clz = Class.forName(clzName);

			Method method = clz.getDeclaredMethod("executeRules", UserInfo.class);

			Object object = clz.getDeclaredConstructor().newInstance();

			planInfo = (PlanInfo) method.invoke(object, userInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return planInfo;
	}

}
