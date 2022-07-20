package com.ci.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ci.entity.Ccap;

@Repository
public interface CcapRepo extends JpaRepository<Ccap, Long>{

}
