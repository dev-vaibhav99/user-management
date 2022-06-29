package com.vaibhav.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.entity.Cases;

@Repository
public interface CaseRepo extends JpaRepository<Cases, Long>{

}
