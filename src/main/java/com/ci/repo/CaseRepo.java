package com.ci.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ci.entity.Cases;

@Repository
public interface CaseRepo extends JpaRepository<Cases, Long>{

}
