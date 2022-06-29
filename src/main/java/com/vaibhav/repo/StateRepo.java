package com.vaibhav.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.entity.States;

@Repository
public interface StateRepo extends JpaRepository<States, Long>{

	List<States> findByCountryId(Long countryId);

}
