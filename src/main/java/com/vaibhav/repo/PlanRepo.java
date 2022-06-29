package com.vaibhav.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.entity.Plans;

public interface PlanRepo extends JpaRepository<Plans, Long> {

	public Plans findByPlanName(String planName);
}
