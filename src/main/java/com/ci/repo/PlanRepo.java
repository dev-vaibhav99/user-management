package com.ci.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ci.entity.Plans;

public interface PlanRepo extends JpaRepository<Plans, Long> {

	public Plans findByPlanName(String planName);
}
