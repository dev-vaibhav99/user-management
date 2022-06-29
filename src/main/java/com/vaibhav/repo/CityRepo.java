package com.vaibhav.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.entity.Cities;

@Repository
public interface CityRepo extends JpaRepository<Cities, Long> {

	public List<Cities> findByStateId(Long stateId);

}
