package com.ci.service;

import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.ci.bindings.PlanInfo;
import com.ci.bindings.UserInfo;

@Service
public class DetermineEligibilityService {

	public PlanInfo determineEligibility(UserInfo userInfo) {
		String planName = userInfo.getPlanName();
		PlanInfo planInfo = null;

		try {
			String clzName = "com.ci.service." + planName + "RulesExecutor";

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
