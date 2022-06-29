package com.vaibhav.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.drools.core.rule.Package;
import org.springframework.stereotype.Service;

import com.vaibhav.bindings.PlanInfo;
import com.vaibhav.bindings.UserInfo;



@Service
public class CCAPRulesExecutor implements IRuleService {

	@Override
	public PlanInfo executeRules(UserInfo userInfo) {
		PlanInfo planInfo = null;
		try {
			InputStream is = getClass().getResourceAsStream("/com/ed/rules/CCAP.drl");
			Reader reader = new InputStreamReader(is);

			PackageBuilder packageBuilder = new PackageBuilder();
			packageBuilder.addPackageFromDrl(reader);

			Package rulesPackage = packageBuilder.getPackage();

			RuleBase ruleBase = RuleBaseFactory.newRuleBase();
			ruleBase.addPackage(rulesPackage);

			// Firing Rules
			WorkingMemory workingMemory = ruleBase.newStatefulSession();
			workingMemory.insert(userInfo);
			workingMemory.fireAllRules();
			planInfo = userInfo.getPlanInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return planInfo;
	}
}
